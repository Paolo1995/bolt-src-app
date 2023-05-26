package com.hivemq.client.internal.mqtt.codec.decoder.mqtt3;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt3SubAckDecoder_Factory implements Factory<Mqtt3SubAckDecoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt3SubAckDecoder_Factory f17889a = new Mqtt3SubAckDecoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt3SubAckDecoder_Factory a() {
        return InstanceHolder.f17889a;
    }

    public static Mqtt3SubAckDecoder c() {
        return new Mqtt3SubAckDecoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt3SubAckDecoder get() {
        return c();
    }
}
