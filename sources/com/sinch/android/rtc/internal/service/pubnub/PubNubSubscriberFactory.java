package com.sinch.android.rtc.internal.service.pubnub;

import com.sinch.android.rtc.internal.natives.PubSubscriber;
import com.sinch.android.rtc.internal.service.http.HttpClientInterface;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class PubNubSubscriberFactory {
    public PubNubSubscriber createSubscriber(String str, String str2, List<String> list, String str3, int i8, String str4, PubSubscriber pubSubscriber, Executor executor, HttpClientInterface httpClientInterface) {
        return new PubNubSubscriber(str, str2, list, str3, i8, str4, pubSubscriber, executor, httpClientInterface);
    }
}
