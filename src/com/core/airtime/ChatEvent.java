package com.core.airtime;

public abstract class ChatEvent {
    private long time;
    private int id;

    public final int getId() {
        return id;
    }

    public final void setId(int id) {
        this.id = id;
    }

    public ChatEvent(long time) {
        this.time = time;
    }

    public final long getTime() {
        return time;
    }

    public final void setTime(long time) {
        this.time = time;
    }
}
