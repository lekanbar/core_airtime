package com.core.airtime;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;

import javax.xml.parsers.FactoryConfigurationError;

import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

/**
 * This class does all the work for setting up and managing communications with
 * the LivePerson chat API. It has a thread that polls for changes to the chat
 * state.
 * 
 * @author Jim Allers
 * 
 */
public class LivePersonChatService {
    // Debugging
    private static final String TAG = "LivePersonChatService";
    private static final boolean D = true;

    private ChatApiWrapper mSess;
    private final Handler mHandler;
    private ChatStatePoller chatStatePoller;
    private int mState = STATE_NONE;
    private final String appKey = "d999d9a78a524f82853c64a723475647";

    // Constants that indicate the current connection state
    public static final int STATE_NONE = 0;
    public static final int STATE_READY = 1;
    public static final int STATE_CONNECTING = 2;
    public static final int STATE_IN_CHAT = 3;

    public LivePersonChatService(Context context, Handler handler) {
        mSess = null;
        mHandler = handler;
    }

    /**
     * Set the current state of the chat connection
     * 
     * @param state
     *            An integer defining the current connection state
     */
    private synchronized void setState(int state) {
        if (D)
            Log.d(TAG, "setState() " + mState + " -> " + state);
        mState = state;

        // give the new state to the Handler so the UI Activity can update
        mHandler.obtainMessage(LiveChat.MESSAGE_STATE_CHANGE, state, -1).sendToTarget();
    }

    public synchronized void sendMessage(String message) throws IllegalStateException, IOException,
                    ChatApiException, URISyntaxException, XmlPullParserException {
        if (mState == STATE_IN_CHAT) {
            mSess.sendLine(message);
            mHandler.obtainMessage(LiveChat.MESSAGE_WRITE, message).sendToTarget();
        }
    }

    public synchronized boolean startChat(String skill, String serviceQueue, int maxWaitTime,
                    String agentName, String visitorIP, String chatReferrer, String userAgent,
                    String visitorID, String preChatLinesXML) throws IOException, ChatApiException,
                    URISyntaxException, IllegalStateException, XmlPullParserException {
        String sessionURI = mSess.requestChat(skill, serviceQueue, maxWaitTime, agentName,
            visitorIP, chatReferrer, userAgent, visitorID, preChatLinesXML);
        if (sessionURI != null && sessionURI.length() > 0) {
            chatStatePoller = new ChatStatePoller();
            new Thread(chatStatePoller, "LiveChat State Poller").start();
        }
        boolean chatStarted = sessionURI != null && sessionURI.length() > 0;
        if (chatStarted) {
            setState(STATE_IN_CHAT);
        }
        return chatStarted;
    }

    public synchronized boolean startChat() throws IOException, URISyntaxException,
                    IllegalStateException, XmlPullParserException, ChatApiException {
        String sessionURI = mSess.requestChat();
        if (sessionURI != null && sessionURI.length() > 0) {
            chatStatePoller = new ChatStatePoller();
            new Thread(chatStatePoller, "LiveChat State Poller").start();
        }
        boolean chatStarted = sessionURI != null && sessionURI.length() > 0;
        if (chatStarted) {
            setState(STATE_IN_CHAT);
        }
        return sessionURI != null && sessionURI.length() > 0;
    }

    public synchronized boolean startChat(String skill) throws IOException, URISyntaxException,
                    IllegalStateException, XmlPullParserException, ChatApiException {
        String sessionURI = mSess.requestChat(skill);
        if (sessionURI != null && sessionURI.length() > 0) {
            chatStatePoller = new ChatStatePoller();
            new Thread(chatStatePoller, "LiveChat State Poller").start();
        }
        boolean chatStarted = sessionURI != null && sessionURI.length() > 0;
        if (chatStarted) {
            setState(STATE_IN_CHAT);
        }
        return sessionURI != null && sessionURI.length() > 0;
    }

    public synchronized boolean terminateChat() throws IOException, ChatApiException,
                    URISyntaxException, IllegalStateException, XmlPullParserException {
        if (chatStatePoller != null) {
            chatStatePoller.stopPolling();
            chatStatePoller = null;
        }
        if (mState == STATE_IN_CHAT) {
            return mSess.stopChat();
        } else {
            return true;
        }
    }

    public synchronized ChatInfo getChatInfo() throws IllegalStateException, IOException,
                    ChatApiException, XmlPullParserException, URISyntaxException {
        if (mState == STATE_IN_CHAT) {
            return mSess.getChatInfo();
        } else {
            return null;
        }
    }

    private class ChatStatePoller implements Runnable {
        private boolean polling = true;

        public void run() {
            try {
                while (polling) {
                    synchronized (LivePersonChatService.this) {
                        if (mSess != null && mSess.isInChat()) {
                            List<ChatEvent> chatMessages = mSess.getLines(false);
                            for (ChatEvent chatMessage : chatMessages) {
                                if (chatMessage instanceof ChatLineEvent) {
                                    mHandler.obtainMessage(LiveChat.MESSAGE_READ, chatMessage)
                                        .sendToTarget();
                                } else if (chatMessage instanceof ChatStateEvent) {
                                    mHandler.obtainMessage(LiveChat.MESSAGE_STATE_CHANGE,
                                        chatMessage).sendToTarget();
                                }
                            }
                        } else {
                            setState(STATE_READY);
                        }
                    }
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                if (D)
                    Log.e(TAG, "Interrupted while waiting to poll");
            } catch (IOException e) {
                if (D)
                    Log.e(TAG, "IO exception while polling chat");
            } catch (ChatApiException e) {
                if (D)
                    Log.e(TAG, "ChatApiException while polling chat", e);
            } catch (XmlPullParserException e) {
                if (D)
                    Log.e(TAG, "XML parser exception while polling chat");
            } catch (URISyntaxException e) {
                if (D)
                    Log.e(TAG, "XML parser exception while polling chat");
            } catch (IllegalStateException e) {
                if (D)
                    Log.e(TAG, "XML parser exception while polling chat");
            } catch (FactoryConfigurationError e) {
                if (D)
                    Log.e(TAG, "XML parser exception while polling chat");
            } catch (ParseException e) {
                if (D)
                    Log.e(TAG, "XML parser exception while polling chat");
            }

        }

        public void stopPolling() {
            polling = false;
        }
    }

    public synchronized void stop() throws URISyntaxException {
        if (mState == STATE_IN_CHAT) {
            try {
                terminateChat();
            } catch (IOException e) {
                if (D)
                    Log.e(TAG, "Interrupted while stopping");
            } catch (ChatApiException e) {
                if (D)
                    Log.e(TAG, "ApiException while stopping chat");
            } catch (IllegalStateException e) {
                if (D)
                    Log.e(TAG, "Illegal HttpState while stopping chat");
            } catch (XmlPullParserException e) {
                if (D)
                    Log.e(TAG, "Unexpected response from server while stopping chat");
            }
            setState(STATE_READY);
        }
    }
    /**
     * Return the current connection state.
     */
    public synchronized int getState() {
        return mState;
    }

    public synchronized void initSession(String server, String accountId) throws IOException,
                    URISyntaxException, IllegalStateException, XmlPullParserException,
                    ChatApiException {
        mSess = new ChatApiWrapper(accountId, server, "https", "1", this.appKey);
        mSess.initSession();
        setState(STATE_READY);
    }

    public synchronized boolean checkAvailability(String accountId) throws IOException,
                    URISyntaxException, IllegalStateException, XmlPullParserException,
                    ChatApiException {
        boolean avail = mSess.checkAvailability("", "", -1, "");
        return avail;
    }

}
