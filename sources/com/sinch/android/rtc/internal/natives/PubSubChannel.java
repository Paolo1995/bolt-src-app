package com.sinch.android.rtc.internal.natives;

/* loaded from: classes3.dex */
public class PubSubChannel {
    private String channel;
    private long historyMs;

    public PubSubChannel(String str, long j8) {
        this.channel = str;
        this.historyMs = j8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PubSubChannel pubSubChannel = (PubSubChannel) obj;
        if (getChannel() == null) {
            if (pubSubChannel.getChannel() != null) {
                return false;
            }
        } else if (!getChannel().equals(pubSubChannel.getChannel())) {
            return false;
        }
        return true;
    }

    public String getChannel() {
        return this.channel;
    }

    public long getHistoryMs() {
        return this.historyMs;
    }

    public int hashCode() {
        return (getChannel() == null ? 0 : getChannel().hashCode()) + 31;
    }
}
