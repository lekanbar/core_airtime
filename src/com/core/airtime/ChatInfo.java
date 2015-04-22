package com.core.airtime;

public class ChatInfo {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getChatTimeout() {
        return chatTimeout;
    }

    public void setChatTimeout(String chatTimeout) {
        this.chatTimeout = chatTimeout;
    }

    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public String getAgentTyping() {
        return agentTyping;
    }

    public void setAgentTyping(String agentTyping) {
        this.agentTyping = agentTyping;
    }

    public String getVisitorTyping() {
        return visitorTyping;
    }

    public void setVisitorTyping(String visitorTyping) {
        this.visitorTyping = visitorTyping;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    private String agentName;
    private String startTime;
    private String lastUpdate;
    private String chatTimeout;
    private String visitorId;
    private String agentTyping;
    private String visitorTyping;
    private String visitorName;

    public ChatInfo() {
    }

    public ChatInfo(String state, String agentName, String startTime, String lastUpdate,
                    String chatTimeout, String visitorId, String agentTyping, String visitorTyping,
                    String visitorName) {
        this.state = state;
        this.agentName = agentName;
        this.startTime = startTime;
        this.lastUpdate = lastUpdate;
        this.chatTimeout = chatTimeout;
        this.visitorId = visitorId;
        this.agentTyping = agentTyping;
        this.visitorTyping = visitorTyping;
        this.visitorName = visitorName;
    }

}
