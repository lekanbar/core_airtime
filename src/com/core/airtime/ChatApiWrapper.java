package com.core.airtime;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.FactoryConfigurationError;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;

public class ChatApiWrapper {
    private final HttpClient httpClient;
    private final String siteid;
    private final String server;
    private final String protocol;
    private String sessionURI;
    private final String version;
    private final String appkey;

    private int lastEventID;
    private ChatState currentState;

    public final ChatState getCurrentState() {
        return currentState;
    }

    /**
     * @param siteid
     *            Site ID
     * @param server
     *            Server name (without http://)
     * @param protocol
     *            valid values are http or https
     * @param version
     *            version of the API
     * @param appkey
     *            Application key, as provided by LivePerson
     */
    public ChatApiWrapper(String siteid, String server, String protocol, String version, String appkey) {
        this.siteid = siteid;
        this.server = server;
        this.protocol = protocol;
        this.lastEventID = 0;
        this.version = version;
        this.appkey = appkey;
        this.httpClient = new DefaultHttpClient();
    }

    /**
     * Get current chat session URI string used to send subsequent requests
     * 
     * @return the current chat session URI
     */
    public String getCurrentSessionURI() {
        return sessionURI;
    }

    public boolean initSession() throws IOException, URISyntaxException, IllegalStateException,
                    XmlPullParserException, ChatApiException {
        URI uri = buildRequestURI("", "");

        startPull(sendGetRequest(uri).getEntity());
        return true;
    }

    /**
     * Check if agents are available to take a chat
     * 
     * @param skill
     *            the skill name to check on
     * @param serviceQueue
     *            service queue to connect to
     * @param maxWaitTime
     *            maximum expected wait time (in seconds). If predicted wait
     *            time for an agent to become available is less than the
     *            specified maxWaitTime, "true" will be returned by this method.
     * @param agent
     *            specific agent name to connect to (not allowed if Skill or
     *            service queue are defined)
     * @return "true" if agents are available, "false" if no agents are
     *         available with the specified parameters
     * @throws IOException
     * @throws URISyntaxException
     * @throws ChatApiException
     * @throws XmlPullParserException
     * @throws IllegalStateException
     */
    public boolean checkAvailability(String skill, String serviceQueue, int maxWaitTime,
                    String agent) throws IOException, URISyntaxException, IllegalStateException,
                    XmlPullParserException, ChatApiException {
        StringBuffer queryStringBuffer = new StringBuffer();
        if (skill != null && skill.length() > 0) {
            queryStringBuffer.append("&skill=").append(URLEncoder.encode(skill, "UTF-8"));
        }

        if (serviceQueue != null && serviceQueue.length() > 0) {
            queryStringBuffer.append("&serviceQueue=").append(
                URLEncoder.encode(serviceQueue, "UTF-8"));
        }

        if (maxWaitTime > 0) {
            queryStringBuffer.append("&maxWaitTime=").append(maxWaitTime);
        }

        if (agent != null && agent.length() > 0) {
            queryStringBuffer.append("&agent=").append(agent);
        }

        URI uri = buildRequestURI("availability", queryStringBuffer.toString());

        XmlPullParser parser = startPull(sendGetRequest(uri).getEntity());
        if (parser.getName().equals("availability")) {
            return parser.nextText().equals("true");
        } else {
            throw new ChatApiException("Unexpected response to 'availability' call");
        }
    }

    /**
     * Get the predicted wait time for a chat
     * 
     * @param skill
     *            name of the skill to check
     * @param serviceQueue
     *            name of the service queue to check
     * @return Expected wait time in seconds
     * @throws IOException
     * @throws XmlPullParserException
     * @throws URISyntaxException
     * @throws ChatApiException
     * @throws IllegalStateException
     * @throws XMLStreamException
     */
    public int checkWaitTime(String skill, String serviceQueue) throws IOException,
                    XmlPullParserException, URISyntaxException, IllegalStateException,
                    ChatApiException {
        URI uri = buildRequestURI("wait-time", "skill=" + URLEncoder.encode(skill, "UTF-8")
                        + "&serviceQueue=" + URLEncoder.encode(serviceQueue, "UTF-8"));
        XmlPullParser parser = startPull(sendGetRequest(uri).getEntity());
        int result = -1;
        if (parser.getName().equals("estimatedWaitTime")) {
            result = Integer.parseInt(parser.nextText());
        } else {
            throw new ChatApiException("Unexpected response to 'estimatedWaitTime' call");
        }
        return result;
    }

    /**
     * Request to start a chat. Pretty much every variable is optional
     * 
     * @param skill
     *            name of the skill to connect to
     * @param serviceQueue
     *            name of the service queue to connect to
     * @param maxWaitTime
     *            Maximum wait time (in seconds)
     * @param agentName
     *            Specific agent name to connect to (not allowed if Skill or
     *            Service Queue are defined)
     * @param visitorIP
     *            Visitors IP address
     * @param chatReferer
     *            Page address or other identifier that will be recorded as chat
     *            referrer
     * @param userAgent
     *            User-agent string to be linked to this chat, for example
     *            "iPhone-app"
     * @param visitorID
     *            LivePerson visitor ID from a previous chat (this ID can be
     *            obtained by calling getChatInfo() after a chat is connected
     * @param preChatLinesXML
     *            Pre chat lines that will be added to the chat
     * @return session URI to be used in subsequent requests
     * @throws IOException
     * @throws URISyntaxException
     * @throws ChatApiException
     * @throws XmlPullParserException
     * @throws IllegalStateException
     */
    public String requestChat(String skill, String serviceQueue, int maxWaitTime, String agentName,
                    String visitorIP, String chatReferrer, String userAgent, String visitorID,
                    String preChatLinesXML) throws IOException, URISyntaxException,
                    IllegalStateException, XmlPullParserException, ChatApiException {
        String string = buildChatRequestXML(skill, serviceQueue, maxWaitTime, agentName, visitorIP,
            chatReferrer, userAgent, visitorID, preChatLinesXML);
        URI uri = buildRequestURI("requestChat", null);
        HttpResponse response = sendPostRequest(uri, string);
        if (response.getStatusLine().getStatusCode() == 201) {
            // if no error, assume the request was accepted, the chat session
            // has
            // been initiated
            this.sessionURI = response.getFirstHeader("Location").getValue();
            return sessionURI;
        } else {
            startPull(response.getEntity());
            throw new ChatApiException("Couldn't start chat");
        }
    }

    public String requestChat(String skill) throws IOException, URISyntaxException,
                    IllegalStateException, XmlPullParserException, ChatApiException {
        return requestChat(skill, null, -1, null, null, null, "AndroidChat", null, null);
    }

    public String requestChat() throws IOException, URISyntaxException, IllegalStateException,
                    XmlPullParserException, ChatApiException {
        return requestChat(null, null, -1, null, null, null, "AndroidChat", null, null);
    }

    /**
     * Send a chat line from the visitor to the server
     * 
     * @param text
     *            Line text
     * @throws IOException
     * @throws URISyntaxException
     * @throws ChatApiException
     * @throws XmlPullParserException
     * @throws IllegalStateException
     */
    public void sendLine(String text) throws IOException, URISyntaxException,
                    IllegalStateException, XmlPullParserException, ChatApiException {
        // add event element if needed (it will not be there for Close ChatApiWrapper
        // request)
        if (!text.contains("event")) {
            text = escapeHtmlFull(text).toString();
            text = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><event type=\"line\"><text>" + text
                            + "</text></event>";
        }

        URI uri = buildRequestURI("sendline", null);
        HttpResponse httpResponse = sendPostRequest(uri, text);
        if (httpResponse.getStatusLine().getStatusCode() != 201) {
            throw new ChatApiException("Couldn't send chat message");
        }
    }

    /**
     * Get chat lines from the server for the current chat
     * 
     * @param allLines
     * @return list of ChatLineEvent objects
     * @throws IOException
     * @throws URISyntaxException
     * @throws ParseException
     * @throws FactoryConfigurationError
     * @throws IllegalStateException
     * @throws XMLStreamException
     */
    public List<ChatEvent> getLines(boolean allLines) throws IOException, XmlPullParserException,
                    URISyntaxException, IllegalStateException, FactoryConfigurationError,
                    ParseException {
        URI uri = buildRequestURI("getlines", !allLines && lastEventID > 0 ? "from="
                        + (lastEventID + 1)
                        : "");
        return parseLines(sendGetRequest(uri).getEntity().getContent());
    }

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
        "yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    private long parseTimeStamp(String timeStamp) throws ParseException {
        return simpleDateFormat.parse(timeStamp).getTime();
    }

    /**
     * Sends a request to the given URL
     * 
     * @param uri
     * @return
     * @throws IOException
     * @throws ClientProtocolException
     */
    private HttpResponse sendGetRequest(URI uri) throws ClientProtocolException, IOException {
        HttpGet httpGet = new HttpGet(uri);
        httpGet.addHeader("Authorization", "LivePerson appKey=" + this.appkey);
        httpGet.addHeader("Accept", "application/xml");
        httpGet.addHeader("Content-Type", "application/xml; charset=UTF-8");
        return this.httpClient.execute(httpGet);
    }

    private HttpResponse sendPostRequest(URI uri, String body) throws ClientProtocolException,
                    IOException {
        HttpPost httpPost = new HttpPost(uri);
        httpPost.addHeader("Authorization", "LivePerson appKey=" + this.appkey);
        httpPost.addHeader("Accept", "application/xml");
        httpPost.addHeader("Content-type", "application/xml; charset=UTF-8");
        httpPost.setEntity(new StringEntity(body));
        return this.httpClient.execute(httpPost);
    }

    private XmlPullParser startPull(HttpEntity httpEntity) throws IllegalStateException,
                    XmlPullParserException, IOException, ChatApiException {
        return startPull(httpEntity.getContent());
    }

    private XmlPullParser startPull(InputStream inputStream) throws IllegalStateException,
                    XmlPullParserException, IOException, ChatApiException {
        XmlPullParser parser = Xml.newPullParser();
        parser.setInput(inputStream, "UTF-8");
        parser.nextTag();
        checkError(parser);
        return parser;
    }

    /**
     * Invoke after the first call to XmlPullParser.next() to check whether an
     * error response has been received from the invoked chat api call.
     * 
     * @param pullParser
     * @throws ChatApiException
     * @throws XmlPullParserException
     * @throws IOException
     */
    private void checkError(XmlPullParser pullParser) throws ChatApiException,
                    XmlPullParserException, IOException {
        if (pullParser.getEventType() == XmlPullParser.START_TAG
                        && pullParser.getName().equals("error")) {
            int eventType = -1;
            String message = null;
            String timeStamp = null;
            String reason = null;
            String internalCode = null;
            while ((eventType = pullParser.next()) != XmlPullParser.END_TAG
                            || !pullParser.getName().equals("error")) {
                if (eventType == XmlPullParser.START_TAG) {
                    if (pullParser.getName().equals("time")) {
                        timeStamp = pullParser.nextText();
                        continue;
                    }
                    if (pullParser.getName().equals("reason")) {
                        reason = pullParser.nextText();
                        continue;
                    }
                    if (pullParser.getName().equals("message")) {
                        message = pullParser.nextText();
                        continue;
                    }
                    if (pullParser.getName().equals("internalCode")) {
                        internalCode = pullParser.nextText();
                        continue;
                    }
                }
            }
            ChatApiException chatApiException = null;
            if (message != null)
                chatApiException = new ChatApiException(message);
            else
                chatApiException = new ChatApiException();
            if (timeStamp != null) {
                chatApiException.setTimeStamp(timeStamp);
            }
            if (reason != null) {
                chatApiException.setReason(reason);
            }
            if (internalCode != null) {
                chatApiException.setInternalCode(internalCode);
            }
            throw chatApiException;
        }
    }

    /**
     * Get current real time chat info of the current chat
     * 
     * @return
     * @throws IOException
     * @throws XmlPullParserException
     * @throws URISyntaxException
     * @throws ChatApiException
     * @throws IllegalStateException
     * @throws XMLStreamException
     */
    public ChatInfo getChatInfo() throws IOException, XmlPullParserException, URISyntaxException,
                    IllegalStateException, ChatApiException {
        URI uri = buildRequestURI("chatinfo", "");
        return parseChatInfo(sendGetRequest(uri).getEntity().getContent());
    }

    public boolean isInChat() throws ChatApiException {
        try {
            getChatInfo();
            return true;
        } catch (IOException ioe) {
            return false;
        } catch (XmlPullParserException ioe) {
            return false;
        } catch (URISyntaxException e) {
            return false;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /**
     * Send custom variable (in the context of a chat)
     * 
     * @param name
     *            Variable name
     * @param value
     *            Variable value
     * @param scope
     *            variable scope
     * @throws IOException
     * @throws URISyntaxException
     * @throws ChatApiException
     * @throws XmlPullParserException
     * @throws IllegalStateException
     */
    public void sendCV(String name, String value, String scope) throws IOException,
                    URISyntaxException, IllegalStateException, XmlPullParserException,
                    ChatApiException {
        String datatxt = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><customVarialble>"
                        + escapeHtmlFull(value) + "</customVariable>";

        URI uri = buildRequestURI("cv", name);
        startPull(sendPostRequest(uri, datatxt).getEntity());
    }

    /**
     * Send a request to stop a chat
     * 
     * @throws IOException
     * @throws URISyntaxException
     * @throws ChatApiException
     * @throws XmlPullParserException
     * @throws IllegalStateException
     */
    public boolean stopChat() throws IOException, URISyntaxException, IllegalStateException,
                    XmlPullParserException, ChatApiException {
        sendLine("<?xml version=\"1.0\" encoding=\"UTF-8\"?><event type=\"state\"><state>ended</state></event>");
        return true;
    }

    /**
     * Build the URL per the request
     * 
     * @param resourceType
     * @param queryString
     * @return the URL to make the desired API request
     * @throws MalformedURLException
     * @throws URISyntaxException
     */
    private URI buildRequestURI(String resourceType, String queryString) throws URISyntaxException {
        if (resourceType.equals("")) {
            return new URI(this.protocol + "://" + this.server + "/api/account/" + this.siteid
                            + "?v=" + this.version);
        }
        if (resourceType.equals("requestChat")) {
            return new URI(this.protocol + "://" + this.server + "/" + "api/account/" + this.siteid
                            + "/" + "chat/request?v=" + this.version);
        }

        if (resourceType.equals("availability")) {
            return new URI(this.protocol + "://" + this.server + "/" + "api/account/" + this.siteid
                            + "/" + "chat/availability?v=" + this.version + "&" + queryString);
        }

        if (resourceType.equals("wait-time")) {
            return new URI(this.protocol + "://" + this.server + "/" + "api/account/" + this.siteid
                            + "/" + "chat/estimatedWaitTime?v=" + this.version + "&" + queryString);
        }

        if (resourceType.equals("sendline") || resourceType.equals("getlines")) {
            return new URI(this.sessionURI
                            + "/events?v="
                            + this.version
                            + "&"
                            + ((queryString != null && queryString.length() > 0) ? (queryString)
                                            : ""));
        }

        if (resourceType.equals("cv")) {
            return new URI(this.sessionURI + "/customVariables/" + queryString + "?v="
                            + this.version);
        }

        if (resourceType.equals("chatinfo")) {
            if (queryString == null || queryString.length() == 0) {
                return new URI(this.sessionURI + "/info?v=" + this.version);
            } else {
                return new URI(this.sessionURI + "/info/" + queryString + "?v=" + this.version);
            }
        }
        return null;
    }

    private static StringBuilder escapeHtmlFull(String s) {
        StringBuilder b = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <= '9') {
                // safe
                b.append(ch);
            } else if (Character.isWhitespace(ch)) {
                // paranoid version: whitespaces are unsafe - escape
                // conversion of (int)ch is naive
                b.append("&#").append((int) ch).append(";");
            } else if (Character.isISOControl(ch)) {
                // paranoid version:isISOControl which are not isWhitespace
                // removed !
                // do nothing do not include in output !
            } else if (Character.isHighSurrogate(ch)) {
                int codePoint;
                if (i + 1 < s.length()
                                && Character.isSurrogatePair(ch, s.charAt(i + 1))
                                && Character.isDefined(codePoint = (Character.toCodePoint(ch, s
                                    .charAt(i + 1))))) {
                    b.append("&#").append(codePoint).append(";");
                }
                i++; // in both ways move forward
            } else if (Character.isLowSurrogate(ch)) {
                // wrong char[] sequence, //TODO: LOG !!!
                i++; // move forward,do nothing do not include in output !
            } else {
                if (Character.isDefined(ch)) {
                    // paranoid version
                    // the rest is unsafe, including <127 control chars
                    b.append("&#").append((int) ch).append(";");
                }
                // do nothing do not include undefined in output!
            }
        }
        return b;
    }

    /**
     * Build the XML string of the parameters for a ChatApiWrapper Request
     * 
     * @param skill
     * @param serviceQueue
     * @param maxWaitTime
     * @param agent
     * @param visitorIp
     * @param chatReferrer
     * @param userAgent
     * @param visitorId
     * @param preChatLinesXML
     * @return
     */
    private String buildChatRequestXML(String skill, String serviceQueue, int maxWaitTime,
                    String agent, String visitorIp, String chatReferrer, String userAgent,
                    String visitorId, String preChatLinesXML) {
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><request>";
        str += (skill != null && skill != "" ? ("<skill>" + skill + "</skill>") : "");
        str += (serviceQueue != null && serviceQueue != "" ? "<serviceQueue>" + serviceQueue
                        + "</serviceQueue>" : "");
        str += (maxWaitTime > 0 ? "<maxWaitTime>" + maxWaitTime + "</maxWaitTime>" : "");
        str += (chatReferrer != null && chatReferrer != "" ? "<chatReferrer>" + chatReferrer
                        + "</chatReferrer>" : "");
        str += (userAgent != null && userAgent != "" ? "<userAgent>" + userAgent + "</userAgent>"
                        : "");
        str += (preChatLinesXML != null && preChatLinesXML != "" ? "<preChatLines>"
                        + preChatLinesXML + "</preChatLines>" : "");
        str += (visitorId != null && visitorId != "" ? "<visitorId>" + visitorId + "</visitorId>"
                        : "");
        return str + "</request>";
    }

    /**
     * Parse the XML that returns from a chat/info request
     * 
     * @param allData
     * @return ChatInfo object
     * @throws IOException
     * @throws XmlPullParserException
     * @throws ChatApiException
     * @throws IllegalStateException
     */
    private ChatInfo parseChatInfo(InputStream inputStream) throws XmlPullParserException,
                    IOException, IllegalStateException, ChatApiException {
        XmlPullParser parser = startPull(inputStream);
        ChatInfo chatInfo = new ChatInfo();
        int eventType = parser.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG) {
                if (parser.getName() != null && parser.getName().equals("state")) {
                    chatInfo.setState(parser.nextText());
                } else if (parser.getName() != null && parser.getName().equals("agentName")) {
                    chatInfo.setAgentName(parser.nextText());
                } else if (parser.getName() != null && parser.getName().equals("startTime")) {
                    chatInfo.setStartTime(parser.nextText());
                } else if (parser.getName() != null && parser.getName().equals("lastUpdate")) {
                    chatInfo.setLastUpdate(parser.nextText());
                } else if (parser.getName() != null && parser.getName().equals("chatTimeout")) {
                    chatInfo.setChatTimeout(parser.nextText());
                } else if (parser.getName() != null && parser.getName().equals("visitorId")) {
                    chatInfo.setVisitorId(parser.nextText());
                } else if (parser.getName() != null && parser.getName().equals("agentTyping")) {
                    chatInfo.setAgentTyping(parser.nextText());
                } else if (parser.getName() != null && parser.getName().equals("visitorTyping")) {
                    chatInfo.setVisitorTyping(parser.nextText());
                } else if (parser.getName() != null && parser.getName().equals("visitorName")) {
                    chatInfo.setVisitorName(parser.nextText());
                }
            }
            eventType = parser.next();
        }
        return chatInfo;
    }

    /**
     * Parse chat lines that returned from the server
     * 
     * @param allData
     *            XML data from the server
     * @return list of ChatLineEvent objects
     * @throws FactoryConfigurationError
     * @throws XmlPullParserException
     * @throws IOException
     * @throws ParseException
     * @throws XMLStreamException
     */
    private ArrayList<ChatEvent> parseLines(InputStream inputStream)
                    throws FactoryConfigurationError, XmlPullParserException, IOException,
                    ParseException {
        XmlPullParser parser = Xml.newPullParser();
        parser.setInput(inputStream, "UTF-8");
        ArrayList<ChatEvent> chatLineEvents = new ArrayList<ChatEvent>();
        int eventType = parser.next();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG) {
                if (parser.getName().equals("event")) {
                    int eventId = Integer.parseInt(parser.getAttributeValue(null, "id"));
                    if (parser.getAttributeValue(null, "type").equals("line")) {
                        chatLineEvents.add(parseChatLine(parser));
                    } else if (parser.getAttributeValue(null, "type").equals("state")) {
                        ChatStateEvent chatStateEvent = parseChatState(parser);
                        chatLineEvents.add(chatStateEvent);
                        if (eventId > lastEventID) {
                            currentState = chatStateEvent.getChatState();
                        }
                    }
                    if (eventId > lastEventID) {
                        this.lastEventID = eventId;
                    }
                }
            }
            eventType = parser.next();
        }
        return chatLineEvents;
    }

    private ChatStateEvent parseChatState(XmlPullParser parser)
                    throws XmlPullParserException, IOException, ParseException {
        ChatState chatState = ChatState.WAITING;
        long time = -1L;
        int eventType = parser.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG) {
                if (parser.getName() != null && parser.getName().equals("state")) {
                    String stateTxt = parser.nextText();
                    if (stateTxt.equals("waiting")) {
                        chatState = ChatState.WAITING;
                    }
                    if (stateTxt.equals("chatting")) {
                        chatState = ChatState.CHATTING;
                    }
                    if (stateTxt.equals("ended")) {
                        chatState = ChatState.ENDED;
                    }
                }
                if (parser.getName() != null && parser.getName().equals("time")) {
                    time = parseTimeStamp(parser.nextText());
                }
            }
            if (eventType == XmlPullParser.END_TAG && parser.getName().equals("event")) {
                break;
            }
            eventType = parser.next();
        }
        ChatStateEvent chatStateEvent = new ChatStateEvent(chatState, time);
        return chatStateEvent;
    }

    private ChatLineEvent parseChatLine(XmlPullParser parser)
                    throws XmlPullParserException, IOException {
        String text = null;
        String source = null;
        String by = null;
        long time = -1L;
        int eventType = parser.next();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG) {
                if (parser.getName() != null && parser.getName().equals("text")) {
                    text = parser.nextText();
                }
                if (parser.getName() != null && parser.getName().equals("source")) {
                    source = parser.nextText();
                }
                if (parser.getName() != null && parser.getName().equals("by")) {
                    by = parser.nextText();
                }
                if (parser.getName() != null && parser.getName().equals("time")) {
                    try {
                        time = parseTimeStamp(parser.nextText());
                    } catch (ParseException e) {
                        // TODO figure out how to handle this
                        e.printStackTrace();
                    }
                }
            }
            if (eventType == XmlPullParser.END_TAG && parser.getName().equals("event")) {
                break;
            }
            eventType = parser.next();
        }
        ChatLineEvent line = new ChatLineEvent(text, ChatLineEvent.LINE_TYPE.TEXT, ChatLineEvent.getSourceType(source),
            by, time);
        return line;
    }
}
