package com.hivemq.client.internal.mqtt.codec.decoder.mqtt3;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt3UnsubAckDecoder_Factory implements Factory<Mqtt3UnsubAckDecoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt3UnsubAckDecoder_Factory f17890a = new Mqtt3UnsubAckDecoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt3UnsubAckDecoder_Factory a() {
        return InstanceHolder.f17890a;
    }

    public static Mqtt3UnsubAckDecoder c() {
        return new Mqtt3UnsubAckDecoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt3UnsubAckDecoder get() {
        return c();
    }
}
