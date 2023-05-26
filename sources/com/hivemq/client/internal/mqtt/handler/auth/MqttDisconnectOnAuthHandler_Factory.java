package com.hivemq.client.internal.mqtt.handler.auth;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class MqttDisconnectOnAuthHandler_Factory implements Factory<MqttDisconnectOnAuthHandler> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final MqttDisconnectOnAuthHandler_Factory f18044a = new MqttDisconnectOnAuthHandler_Factory();

        private InstanceHolder() {
        }
    }

    public static MqttDisconnectOnAuthHandler_Factory a() {
        return InstanceHolder.f18044a;
    }

    public static MqttDisconnectOnAuthHandler c() {
        return new MqttDisconnectOnAuthHandler();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MqttDisconnectOnAuthHandler get() {
        return c();
    }
}
