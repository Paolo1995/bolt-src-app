package com.sinch.android.rtc.internal.client.calling.PeerConnection;

/* loaded from: classes3.dex */
public class IncompleteRtcStatObject {
    private String id;
    private long timestamp;
    private String type;

    public IncompleteRtcStatObject(String str, String str2, long j8) {
        this.id = str;
        this.type = str2;
        this.timestamp = j8;
    }

    public boolean equals(Object obj) {
        return (obj instanceof IncompleteRtcStatObject) && obj.hashCode() == hashCode();
    }

    public String getId() {
        return this.id;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.id + this.type + this.timestamp).hashCode();
    }
}
