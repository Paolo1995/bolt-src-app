package com.sinch.android.rtc.internal.service.pubnub;

import com.sinch.android.rtc.internal.natives.PubSubscriber;
import com.sinch.android.rtc.internal.service.http.HttpClientInterface;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class PubNubSubscriber {
    private final String baseUrl;
    private final Executor callbackExecutor;
    private Set<PubSubscriber> callbacks;
    private final List<String> channels;
    private final HttpClientInterface httpClient;
    private PubNubListener listener;
    private final String pubnubUuid;
    private final String subscribeKey;
    private final int timeOffsetOnSubscribeInMs;
    private final String timeToken;

    public PubNubSubscriber(String str, String str2, List<String> list, String str3, int i8, String str4, PubSubscriber pubSubscriber, Executor executor, HttpClientInterface httpClientInterface) {
        this.baseUrl = str;
        this.subscribeKey = str2;
        this.channels = list;
        this.timeToken = str3;
        this.pubnubUuid = str4;
        this.timeOffsetOnSubscribeInMs = i8;
        this.callbackExecutor = executor;
        this.httpClient = httpClientInterface;
        Set<PubSubscriber> synchronizedSet = Collections.synchronizedSet(new HashSet());
        this.callbacks = synchronizedSet;
        synchronizedSet.add(pubSubscriber);
    }

    public void addCallback(PubSubscriber pubSubscriber) {
        this.callbacks.add(pubSubscriber);
    }

    public boolean hasNoCallbackers() {
        return this.callbacks.isEmpty();
    }

    public boolean isSubscribing() {
        PubNubListener pubNubListener = this.listener;
        return pubNubListener != null && pubNubListener.isActive();
    }

    public void removeCallback(PubSubscriber pubSubscriber) {
        this.callbacks.remove(pubSubscriber);
    }

    public void subscribe() {
        if (isSubscribing()) {
            throw new IllegalStateException("Already subscribing");
        }
        PubNubListener pubNubListener = new PubNubListener(this.baseUrl, this.subscribeKey, this.channels, this.timeToken, this.timeOffsetOnSubscribeInMs, this.pubnubUuid, Collections.unmodifiableSet(this.callbacks), this.callbackExecutor, this.httpClient);
        this.listener = pubNubListener;
        pubNubListener.poll();
    }

    public void unsubscribe() {
        this.listener.abort();
    }
}
