package com.hivemq.client.internal.mqtt.codec.decoder.mqtt5;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt5UnsubAckDecoder_Factory implements Factory<Mqtt5UnsubAckDecoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt5UnsubAckDecoder_Factory f17911a = new Mqtt5UnsubAckDecoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt5UnsubAckDecoder_Factory a() {
        return InstanceHolder.f17911a;
    }

    public static Mqtt5UnsubAckDecoder c() {
        return new Mqtt5UnsubAckDecoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt5UnsubAckDecoder get() {
        return c();
    }
}
