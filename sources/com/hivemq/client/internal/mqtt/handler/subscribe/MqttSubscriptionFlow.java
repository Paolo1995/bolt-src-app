package com.hivemq.client.internal.mqtt.handler.subscribe;

import io.netty.channel.EventLoop;

/* loaded from: classes3.dex */
public interface MqttSubscriptionFlow<M> {
    EventLoop d();

    boolean init();

    boolean isCancelled();

    void onError(Throwable th);

    void onSuccess(M m8);
}
