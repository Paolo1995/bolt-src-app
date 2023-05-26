package com.hivemq.client.internal.mqtt.handler.websocket;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class MqttWebSocketCodec_Factory implements Factory<MqttWebSocketCodec> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final MqttWebSocketCodec_Factory f18355a = new MqttWebSocketCodec_Factory();

        private InstanceHolder() {
        }
    }

    public static MqttWebSocketCodec_Factory a() {
        return InstanceHolder.f18355a;
    }

    public static MqttWebSocketCodec c() {
        return new MqttWebSocketCodec();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MqttWebSocketCodec get() {
        return c();
    }
}
