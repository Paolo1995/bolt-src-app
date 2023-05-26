package com.hivemq.client.internal.mqtt.codec.encoder;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class MqttPingReqEncoder_Factory implements Factory<MqttPingReqEncoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final MqttPingReqEncoder_Factory f17921a = new MqttPingReqEncoder_Factory();

        private InstanceHolder() {
        }
    }

    public static MqttPingReqEncoder_Factory a() {
        return InstanceHolder.f17921a;
    }

    public static MqttPingReqEncoder c() {
        return new MqttPingReqEncoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MqttPingReqEncoder get() {
        return c();
    }
}
