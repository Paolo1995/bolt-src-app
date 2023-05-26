package com.sinch.android.rtc.internal.service.pubnub;

import java.util.List;

/* loaded from: classes3.dex */
public class Subscription {
    private final List<String> channels;
    private final String pubnubUuid;
    private final String subscriptionKey;
    private final int timeOffsetOnSubscribeInMs;
    private final String timeToken;

    public Subscription(List<String> list, String str) {
        this.channels = list;
        this.subscriptionKey = str;
        this.timeToken = "0";
        this.timeOffsetOnSubscribeInMs = 0;
        this.pubnubUuid = "";
    }

    public Subscription(List<String> list, String str, String str2, int i8) {
        this.channels = list;
        this.subscriptionKey = str;
        this.timeToken = "0";
        this.timeOffsetOnSubscribeInMs = i8;
        this.pubnubUuid = str2;
    }

    public Subscription(List<String> list, String str, String str2, String str3) {
        this.channels = list;
        this.subscriptionKey = str;
        this.timeToken = str3;
        this.timeOffsetOnSubscribeInMs = 0;
        this.pubnubUuid = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Subscription subscription = (Subscription) obj;
            List<String> list = this.channels;
            if (list == null) {
                if (subscription.channels != null) {
                    return false;
                }
            } else if (!list.equals(subscription.channels)) {
                return false;
            }
            String str = this.subscriptionKey;
            String str2 = subscription.subscriptionKey;
            if (str == null) {
                if (str2 != null) {
                    return false;
                }
            } else if (!str.equals(str2)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public List<String> getChannels() {
        return this.channels;
    }

    public String getPubNubUuid() {
        return this.pubnubUuid;
    }

    public String getSubscriptionKey() {
        return this.subscriptionKey;
    }

    public int getTimeOffsetOnSubscribeInMs() {
        return this.timeOffsetOnSubscribeInMs;
    }

    public String getTimeToken() {
        return this.timeToken;
    }

    public int hashCode() {
        List<String> list = this.channels;
        int hashCode = ((list == null ? 0 : list.hashCode()) + 31) * 31;
        String str = this.subscriptionKey;
        return hashCode + (str != null ? str.hashCode() : 0);
    }
}
