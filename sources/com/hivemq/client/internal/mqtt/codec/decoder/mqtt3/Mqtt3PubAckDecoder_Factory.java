package com.hivemq.client.internal.mqtt.codec.decoder.mqtt3;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt3PubAckDecoder_Factory implements Factory<Mqtt3PubAckDecoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt3PubAckDecoder_Factory f17884a = new Mqtt3PubAckDecoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt3PubAckDecoder_Factory a() {
        return InstanceHolder.f17884a;
    }

    public static Mqtt3PubAckDecoder c() {
        return new Mqtt3PubAckDecoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt3PubAckDecoder get() {
        return c();
    }
}
