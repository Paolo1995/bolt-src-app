package com.hivemq.client.internal.mqtt.handler.auth;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnect;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MqttConnectAuthHandler_Factory implements Factory<MqttConnectAuthHandler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MqttClientConfig> f18042a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MqttConnect> f18043b;

    public MqttConnectAuthHandler_Factory(Provider<MqttClientConfig> provider, Provider<MqttConnect> provider2) {
        this.f18042a = provider;
        this.f18043b = provider2;
    }

    public static MqttConnectAuthHandler_Factory a(Provider<MqttClientConfig> provider, Provider<MqttConnect> provider2) {
        return new MqttConnectAuthHandler_Factory(provider, provider2);
    }

    public static MqttConnectAuthHandler c(MqttClientConfig mqttClientConfig, MqttConnect mqttConnect) {
        return new MqttConnectAuthHandler(mqttClientConfig, mqttConnect);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MqttConnectAuthHandler get() {
        return c(this.f18042a.get(), this.f18043b.get());
    }
}
