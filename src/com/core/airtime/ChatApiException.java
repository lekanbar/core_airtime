package com.core.airtime;

public class ChatApiException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String internalCode;

    public final String getInternalCode() {
        return internalCode;
    }

    public final void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }

    private String timeStamp;

    public final String getTimeStamp() {
        return timeStamp;
    }

    public final void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    private String reason;

    public final String getReason() {
        return reason;
    }

    public final void setReason(String reason) {
        this.reason = reason;
    }

    public ChatApiException() {
    }

    public ChatApiException(String detailMessage) {
        super(detailMessage);
    }

    public ChatApiException(String detailMessage, Throwable t) {
        super(detailMessage, t);
    }
}
