package com.hivemq.client.internal.mqtt.handler.connect;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttDecoder;
import com.hivemq.client.internal.mqtt.handler.MqttSession;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnect;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MqttConnectHandler_Factory implements Factory<MqttConnectHandler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MqttConnect> f18115a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MqttConnAckFlow> f18116b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<MqttClientConfig> f18117c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<MqttSession> f18118d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<MqttDecoder> f18119e;

    public MqttConnectHandler_Factory(Provider<MqttConnect> provider, Provider<MqttConnAckFlow> provider2, Provider<MqttClientConfig> provider3, Provider<MqttSession> provider4, Provider<MqttDecoder> provider5) {
        this.f18115a = provider;
        this.f18116b = provider2;
        this.f18117c = provider3;
        this.f18118d = provider4;
        this.f18119e = provider5;
    }

    public static MqttConnectHandler_Factory a(Provider<MqttConnect> provider, Provider<MqttConnAckFlow> provider2, Provider<MqttClientConfig> provider3, Provider<MqttSession> provider4, Provider<MqttDecoder> provider5) {
        return new MqttConnectHandler_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static MqttConnectHandler c(MqttConnect mqttConnect, MqttConnAckFlow mqttConnAckFlow, MqttClientConfig mqttClientConfig, MqttSession mqttSession, MqttDecoder mqttDecoder) {
        return new MqttConnectHandler(mqttConnect, mqttConnAckFlow, mqttClientConfig, mqttSession, mqttDecoder);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MqttConnectHandler get() {
        return c(this.f18115a.get(), this.f18116b.get(), this.f18117c.get(), this.f18118d.get(), this.f18119e.get());
    }
}
