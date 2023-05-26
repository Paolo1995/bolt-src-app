package com.sinch.android.rtc.internal.service.pubnub;

import com.sinch.android.rtc.internal.natives.PubPublisher;
import com.sinch.android.rtc.internal.natives.PubSubHistoryConsumer;
import com.sinch.android.rtc.internal.natives.PubSubscriber;
import com.sinch.android.rtc.internal.service.http.HttpClientInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public class PublishSubscribeClient implements PubSubClient {
    private static final String TAG = "PublishSubscribeClient";
    private Executor callbackExecutor;
    private final HttpClientInterface httpClient;
    private String pubNubBaseUrl;
    private final ExecutorService publishExecutor;
    private final PubNubSubscriberFactory subscriberFactory;
    private String undecoratedHostName;
    private volatile boolean active = false;
    private boolean useSsl = true;
    private Map<Subscription, PubNubSubscriber> subscribers = new HashMap();
    private Map<String, List<PubNubPublisher>> publishers = new HashMap();
    private boolean subscribtionsEnabled = true;

    /* loaded from: classes3.dex */
    public class PubNubPublishCallback implements PubPublisher {
        public PubPublisher callback;
        public String channel;
        public PubNubPublisher publisher;

        public PubNubPublishCallback(String str, PubNubPublisher pubNubPublisher, PubPublisher pubPublisher) {
            this.channel = str;
            this.publisher = pubNubPublisher;
            this.callback = pubPublisher;
        }

        @Override // com.sinch.android.rtc.internal.natives.PubPublisher
        public void onPublishFailed(int i8, String str, String str2) {
            PubPublisher pubPublisher = this.callback;
            if (pubPublisher != null) {
                pubPublisher.onPublishFailed(i8, str, str2);
            }
            PublishSubscribeClient.this.removePublisher(this.channel, this.publisher);
        }

        @Override // com.sinch.android.rtc.internal.natives.PubPublisher
        public void onPublishSuccess(String str) {
            PubPublisher pubPublisher = this.callback;
            if (pubPublisher != null) {
                pubPublisher.onPublishSuccess(str);
            }
            PublishSubscribeClient.this.removePublisher(this.channel, this.publisher);
        }
    }

    public PublishSubscribeClient(PubNubSubscriberFactory pubNubSubscriberFactory, Executor executor, ExecutorService executorService, HttpClientInterface httpClientInterface) {
        this.subscriberFactory = pubNubSubscriberFactory;
        this.callbackExecutor = executor;
        this.publishExecutor = executorService;
        this.httpClient = httpClientInterface;
    }

    private void addPublisher(String str, PubNubPublisher pubNubPublisher) {
        synchronized (this.publishers) {
            List<PubNubPublisher> list = this.publishers.get(str);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(pubNubPublisher);
            this.publishers.put(str, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removePublisher(String str, PubNubPublisher pubNubPublisher) {
        synchronized (this.publishers) {
            List<PubNubPublisher> list = this.publishers.get(str);
            if (list == null) {
                return;
            }
            list.remove(pubNubPublisher);
            if (list.size() != 0) {
                this.publishers.put(str, list);
            } else {
                this.publishers.remove(str);
            }
        }
    }

    private void startSubscribe(Subscription subscription, PubSubscriber pubSubscriber) {
        if (this.subscribers.containsKey(subscription)) {
            this.subscribers.get(subscription).addCallback(pubSubscriber);
            return;
        }
        PubNubSubscriber createSubscriber = this.subscriberFactory.createSubscriber(this.pubNubBaseUrl, subscription.getSubscriptionKey(), subscription.getChannels(), subscription.getTimeToken(), subscription.getTimeOffsetOnSubscribeInMs(), subscription.getPubNubUuid(), pubSubscriber, this.callbackExecutor, this.httpClient);
        this.subscribers.put(subscription, createSubscriber);
        if (this.subscribtionsEnabled) {
            createSubscriber.subscribe();
        }
    }

    private void stopAllPublishers() {
        synchronized (this.publishers) {
            for (String str : this.publishers.keySet()) {
                for (PubNubPublisher pubNubPublisher : this.publishers.get(str)) {
                    if (pubNubPublisher != null) {
                        pubNubPublisher.abort();
                    }
                }
            }
            this.publishers.clear();
        }
    }

    private void stopAllSubscribers() {
        synchronized (this.subscribers) {
            for (Subscription subscription : this.subscribers.keySet()) {
                PubNubSubscriber pubNubSubscriber = this.subscribers.get(subscription);
                if (pubNubSubscriber != null) {
                    pubNubSubscriber.unsubscribe();
                }
            }
        }
        this.subscribers.clear();
    }

    private void stopSubscribe(Subscription subscription, PubSubscriber pubSubscriber) {
        PubNubSubscriber pubNubSubscriber = this.subscribers.get(subscription);
        if (pubNubSubscriber == null) {
            return;
        }
        pubNubSubscriber.removeCallback(pubSubscriber);
        if (pubNubSubscriber.hasNoCallbackers()) {
            pubNubSubscriber.unsubscribe();
            this.subscribers.remove(subscription);
        }
    }

    @Override // com.sinch.android.rtc.internal.service.pubnub.PubSubClient
    public void beginBroadcastHistoryGet(PubSubHistoryConsumer pubSubHistoryConsumer, double d8) {
        new PubNubHistoryReader(this.pubNubBaseUrl, -Double.valueOf(d8).intValue(), pubSubHistoryConsumer, this.callbackExecutor, this.httpClient).startHistoryReader();
    }

    public void disableSubscriptions() {
        this.subscribtionsEnabled = false;
        for (PubNubSubscriber pubNubSubscriber : this.subscribers.values()) {
            pubNubSubscriber.unsubscribe();
        }
    }

    public void enableSubscriptions() {
        this.subscribtionsEnabled = true;
        for (PubNubSubscriber pubNubSubscriber : this.subscribers.values()) {
            pubNubSubscriber.subscribe();
        }
    }

    @Override // com.sinch.android.rtc.internal.service.pubnub.PubSubClient
    public String getHost() {
        return this.pubNubBaseUrl;
    }

    public boolean isSubscriptionEnabled() {
        return this.subscribtionsEnabled;
    }

    @Override // com.sinch.android.rtc.internal.service.pubnub.PubSubClient
    public void publish(String str, String str2, String str3, String str4, String str5, PubPublisher pubPublisher) {
        if (this.active) {
            PubNubPublisher pubNubPublisher = new PubNubPublisher(this.publishExecutor, this.pubNubBaseUrl, this.httpClient);
            addPublisher(str, pubNubPublisher);
            pubNubPublisher.publish(str, str2, str3, str4, str5, new PubNubPublishCallback(str, pubNubPublisher, pubPublisher));
        } else if (pubPublisher != null) {
            pubPublisher.onPublishFailed(1, "PubSubClient is stopped.", "0");
        }
    }

    @Override // com.sinch.android.rtc.internal.service.pubnub.PubSubClient
    public void setHost(String str) {
        StringBuilder sb;
        String str2;
        this.undecoratedHostName = str;
        if (this.useSsl) {
            sb = new StringBuilder();
            str2 = "https://";
        } else {
            sb = new StringBuilder();
            str2 = "http://";
        }
        sb.append(str2);
        sb.append(this.undecoratedHostName);
        this.pubNubBaseUrl = sb.toString();
    }

    @Override // com.sinch.android.rtc.internal.service.pubnub.PubSubClient
    public void setUseSsl(boolean z7) {
        this.useSsl = z7;
        String str = this.undecoratedHostName;
        if (str != null) {
            setHost(str);
        }
    }

    @Override // com.sinch.android.rtc.internal.service.pubnub.PubSubClient
    public void startPubSubClient() {
        this.active = true;
    }

    @Override // com.sinch.android.rtc.internal.service.pubnub.PubSubClient
    public void startSubscribe(PubSubscriber pubSubscriber, double d8) {
        startSubscribe(new Subscription(pubSubscriber.getChannels(), pubSubscriber.getSubscribeKey(), pubSubscriber.getClientId(), -((int) d8)), pubSubscriber);
    }

    @Override // com.sinch.android.rtc.internal.service.pubnub.PubSubClient
    public void startSubscribe(PubSubscriber pubSubscriber, String str) {
        startSubscribe(new Subscription(pubSubscriber.getChannels(), pubSubscriber.getSubscribeKey(), pubSubscriber.getClientId(), str), pubSubscriber);
    }

    @Override // com.sinch.android.rtc.internal.service.pubnub.PubSubClient
    public void stopPubSubClient() {
        this.active = false;
        stopSubscribersAndHistory();
        stopAllPublishers();
        this.callbackExecutor = null;
        this.publishExecutor.shutdown();
    }

    @Override // com.sinch.android.rtc.internal.service.pubnub.PubSubClient
    public void stopSubscribe(PubSubscriber pubSubscriber) {
        stopSubscribe(new Subscription(pubSubscriber.getChannels(), pubSubscriber.getSubscribeKey()), pubSubscriber);
    }

    @Override // com.sinch.android.rtc.internal.service.pubnub.PubSubClient
    public void stopSubscribersAndHistory() {
        stopAllSubscribers();
    }
}
