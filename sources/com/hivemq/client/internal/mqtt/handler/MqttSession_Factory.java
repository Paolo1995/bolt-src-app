package com.hivemq.client.internal.mqtt.handler;

import com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttIncomingQosHandler;
import com.hivemq.client.internal.mqtt.handler.publish.outgoing.MqttOutgoingQosHandler;
import com.hivemq.client.internal.mqtt.handler.subscribe.MqttSubscriptionHandler;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MqttSession_Factory implements Factory<MqttSession> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MqttSubscriptionHandler> f18027a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MqttIncomingQosHandler> f18028b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<MqttOutgoingQosHandler> f18029c;

    public MqttSession_Factory(Provider<MqttSubscriptionHandler> provider, Provider<MqttIncomingQosHandler> provider2, Provider<MqttOutgoingQosHandler> provider3) {
        this.f18027a = provider;
        this.f18028b = provider2;
        this.f18029c = provider3;
    }

    public static MqttSession_Factory a(Provider<MqttSubscriptionHandler> provider, Provider<MqttIncomingQosHandler> provider2, Provider<MqttOutgoingQosHandler> provider3) {
        return new MqttSession_Factory(provider, provider2, provider3);
    }

    public static MqttSession c(MqttSubscriptionHandler mqttSubscriptionHandler, MqttIncomingQosHandler mqttIncomingQosHandler, MqttOutgoingQosHandler mqttOutgoingQosHandler) {
        return new MqttSession(mqttSubscriptionHandler, mqttIncomingQosHandler, mqttOutgoingQosHandler);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MqttSession get() {
        return c(this.f18027a.get(), this.f18028b.get(), this.f18029c.get());
    }
}
