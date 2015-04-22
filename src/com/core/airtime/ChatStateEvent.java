package com.core.airtime;

public class ChatStateEvent extends ChatEvent {
    private ChatState chatState;

    public final ChatState getChatState() {
        return chatState;
    }

    public final void setChatState(ChatState chatState) {
        this.chatState = chatState;
    }

    public ChatStateEvent(ChatState chatState, long time) {
        super(time);
        this.chatState = chatState;
    }
}
