package com.hivemq.client.internal.mqtt.handler.websocket;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MqttWebSocketInitializer_Factory implements Factory<MqttWebSocketInitializer> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MqttWebSocketCodec> f18357a;

    public MqttWebSocketInitializer_Factory(Provider<MqttWebSocketCodec> provider) {
        this.f18357a = provider;
    }

    public static MqttWebSocketInitializer_Factory a(Provider<MqttWebSocketCodec> provider) {
        return new MqttWebSocketInitializer_Factory(provider);
    }

    public static MqttWebSocketInitializer c(MqttWebSocketCodec mqttWebSocketCodec) {
        return new MqttWebSocketInitializer(mqttWebSocketCodec);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MqttWebSocketInitializer get() {
        return c(this.f18357a.get());
    }
}
