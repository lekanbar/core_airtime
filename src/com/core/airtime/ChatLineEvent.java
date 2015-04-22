package com.core.airtime;
/**
 * Represents on line in a chat
 * 
 * @author Jim Allers
 */
public class ChatLineEvent extends ChatEvent {
    public enum SOURCE_TYPE {
        SYSTEM, VISITOR, AGENT;
    }

    public enum LINE_TYPE {
        TEXT, HTML;
    }

    public String content;
    public LINE_TYPE type;
    public SOURCE_TYPE source;
    public String senderName;

    public ChatLineEvent(String content, LINE_TYPE lineType, SOURCE_TYPE source, String sender, long time) {
        super(time);
        this.content = content;
        this.type = lineType;
        this.source = source;
        this.senderName = sender;
    }

    public static SOURCE_TYPE getSourceType(String t) {
        if (t.equals("system")) {
            return SOURCE_TYPE.SYSTEM;
        }
        if (t.equals("visitor")) {
            return SOURCE_TYPE.VISITOR;
        }
        if (t.equals("agent")) {
            return SOURCE_TYPE.AGENT;
        }
        return SOURCE_TYPE.SYSTEM;
    }

    public static LINE_TYPE getLineType(String t) {
        if (t.equals("text")) {
            return LINE_TYPE.TEXT;
        }
        if (t.equals("html")) {
            return LINE_TYPE.HTML;
        }
        return LINE_TYPE.TEXT;
    }
}