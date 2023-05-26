package com.sinch.android.rtc.internal.service.pubnub;

import com.sinch.android.rtc.internal.natives.PubPublisher;
import com.sinch.android.rtc.internal.natives.PubSubHistoryConsumer;
import com.sinch.android.rtc.internal.natives.PubSubscriber;

/* loaded from: classes3.dex */
public interface PubSubClient {
    void beginBroadcastHistoryGet(PubSubHistoryConsumer pubSubHistoryConsumer, double d8);

    String getHost();

    void publish(String str, String str2, String str3, String str4, String str5, PubPublisher pubPublisher);

    void setHost(String str);

    void setUseSsl(boolean z7);

    void startPubSubClient();

    void startSubscribe(PubSubscriber pubSubscriber, double d8);

    void startSubscribe(PubSubscriber pubSubscriber, String str);

    void stopPubSubClient();

    void stopSubscribe(PubSubscriber pubSubscriber);

    void stopSubscribersAndHistory();
}
