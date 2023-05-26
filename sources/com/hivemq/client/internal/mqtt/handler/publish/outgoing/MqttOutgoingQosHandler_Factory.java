package com.hivemq.client.internal.mqtt.handler.publish.outgoing;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MqttOutgoingQosHandler_Factory implements Factory<MqttOutgoingQosHandler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MqttClientConfig> f18289a;

    public MqttOutgoingQosHandler_Factory(Provider<MqttClientConfig> provider) {
        this.f18289a = provider;
    }

    public static MqttOutgoingQosHandler_Factory a(Provider<MqttClientConfig> provider) {
        return new MqttOutgoingQosHandler_Factory(provider);
    }

    public static MqttOutgoingQosHandler c(MqttClientConfig mqttClientConfig) {
        return new MqttOutgoingQosHandler(mqttClientConfig);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MqttOutgoingQosHandler get() {
        return c(this.f18289a.get());
    }
}
