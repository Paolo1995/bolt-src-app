package com.hivemq.client.internal.mqtt.handler.subscribe;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttIncomingPublishFlows;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MqttSubscriptionHandler_Factory implements Factory<MqttSubscriptionHandler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MqttClientConfig> f18344a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MqttIncomingPublishFlows> f18345b;

    public MqttSubscriptionHandler_Factory(Provider<MqttClientConfig> provider, Provider<MqttIncomingPublishFlows> provider2) {
        this.f18344a = provider;
        this.f18345b = provider2;
    }

    public static MqttSubscriptionHandler_Factory a(Provider<MqttClientConfig> provider, Provider<MqttIncomingPublishFlows> provider2) {
        return new MqttSubscriptionHandler_Factory(provider, provider2);
    }

    public static MqttSubscriptionHandler c(MqttClientConfig mqttClientConfig, MqttIncomingPublishFlows mqttIncomingPublishFlows) {
        return new MqttSubscriptionHandler(mqttClientConfig, mqttIncomingPublishFlows);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MqttSubscriptionHandler get() {
        return c(this.f18344a.get(), this.f18345b.get());
    }
}
