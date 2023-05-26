package com.hivemq.client.mqtt.lifecycle;

import j$.util.function.BiConsumer;
import java.util.concurrent.CompletableFuture;

/* loaded from: classes3.dex */
public interface MqttClientReconnector {
    MqttClientReconnector b(boolean z7);

    int c();

    <T> MqttClientReconnector d(CompletableFuture<T> completableFuture, BiConsumer<? super T, ? super Throwable> biConsumer);
}
