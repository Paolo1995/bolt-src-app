package com.sinch.android.rtc.internal.service.pubnub;

/* loaded from: classes3.dex */
public class PubNubMessage {
    private String message;
    private long timeToken;

    public PubNubMessage(String str, Long l8) {
        this.message = str;
        this.timeToken = l8.longValue();
    }

    public String getMessage() {
        return this.message;
    }

    public long getTimeToken() {
        return this.timeToken;
    }
}
