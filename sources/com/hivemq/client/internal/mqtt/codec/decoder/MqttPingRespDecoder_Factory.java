package com.hivemq.client.internal.mqtt.codec.decoder;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class MqttPingRespDecoder_Factory implements Factory<MqttPingRespDecoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final MqttPingRespDecoder_Factory f17873a = new MqttPingRespDecoder_Factory();

        private InstanceHolder() {
        }
    }

    public static MqttPingRespDecoder_Factory a() {
        return InstanceHolder.f17873a;
    }

    public static MqttPingRespDecoder c() {
        return new MqttPingRespDecoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MqttPingRespDecoder get() {
        return c();
    }
}
