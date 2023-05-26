package com.hivemq.client.internal.mqtt.handler.disconnect;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.handler.MqttSession;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MqttDisconnectHandler_Factory implements Factory<MqttDisconnectHandler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MqttClientConfig> f18152a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MqttSession> f18153b;

    public MqttDisconnectHandler_Factory(Provider<MqttClientConfig> provider, Provider<MqttSession> provider2) {
        this.f18152a = provider;
        this.f18153b = provider2;
    }

    public static MqttDisconnectHandler_Factory a(Provider<MqttClientConfig> provider, Provider<MqttSession> provider2) {
        return new MqttDisconnectHandler_Factory(provider, provider2);
    }

    public static MqttDisconnectHandler c(MqttClientConfig mqttClientConfig, MqttSession mqttSession) {
        return new MqttDisconnectHandler(mqttClientConfig, mqttSession);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MqttDisconnectHandler get() {
        return c(this.f18152a.get(), this.f18153b.get());
    }
}
