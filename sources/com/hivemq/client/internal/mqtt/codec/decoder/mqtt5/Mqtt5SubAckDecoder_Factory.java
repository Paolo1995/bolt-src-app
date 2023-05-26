package com.hivemq.client.internal.mqtt.codec.decoder.mqtt5;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt5SubAckDecoder_Factory implements Factory<Mqtt5SubAckDecoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt5SubAckDecoder_Factory f17910a = new Mqtt5SubAckDecoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt5SubAckDecoder_Factory a() {
        return InstanceHolder.f17910a;
    }

    public static Mqtt5SubAckDecoder c() {
        return new Mqtt5SubAckDecoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt5SubAckDecoder get() {
        return c();
    }
}
