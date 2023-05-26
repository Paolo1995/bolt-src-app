package com.hivemq.client.internal.mqtt.handler.publish.incoming;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class MqttIncomingPublishFlows_Factory implements Factory<MqttIncomingPublishFlows> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final MqttIncomingPublishFlows_Factory f18206a = new MqttIncomingPublishFlows_Factory();

        private InstanceHolder() {
        }
    }

    public static MqttIncomingPublishFlows_Factory a() {
        return InstanceHolder.f18206a;
    }

    public static MqttIncomingPublishFlows c() {
        return new MqttIncomingPublishFlows();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MqttIncomingPublishFlows get() {
        return c();
    }
}
