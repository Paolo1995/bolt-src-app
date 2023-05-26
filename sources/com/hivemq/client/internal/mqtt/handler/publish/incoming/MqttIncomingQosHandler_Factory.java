package com.hivemq.client.internal.mqtt.handler.publish.incoming;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MqttIncomingQosHandler_Factory implements Factory<MqttIncomingQosHandler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MqttClientConfig> f18226a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MqttIncomingPublishFlows> f18227b;

    public MqttIncomingQosHandler_Factory(Provider<MqttClientConfig> provider, Provider<MqttIncomingPublishFlows> provider2) {
        this.f18226a = provider;
        this.f18227b = provider2;
    }

    public static MqttIncomingQosHandler_Factory a(Provider<MqttClientConfig> provider, Provider<MqttIncomingPublishFlows> provider2) {
        return new MqttIncomingQosHandler_Factory(provider, provider2);
    }

    public static MqttIncomingQosHandler c(MqttClientConfig mqttClientConfig, MqttIncomingPublishFlows mqttIncomingPublishFlows) {
        return new MqttIncomingQosHandler(mqttClientConfig, mqttIncomingPublishFlows);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MqttIncomingQosHandler get() {
        return c(this.f18226a.get(), this.f18227b.get());
    }
}
