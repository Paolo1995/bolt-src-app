package com.hivemq.client.internal.mqtt.codec.decoder.mqtt5;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt5ConnAckDecoder_Factory implements Factory<Mqtt5ConnAckDecoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt5ConnAckDecoder_Factory f17903a = new Mqtt5ConnAckDecoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt5ConnAckDecoder_Factory a() {
        return InstanceHolder.f17903a;
    }

    public static Mqtt5ConnAckDecoder c() {
        return new Mqtt5ConnAckDecoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt5ConnAckDecoder get() {
        return c();
    }
}
