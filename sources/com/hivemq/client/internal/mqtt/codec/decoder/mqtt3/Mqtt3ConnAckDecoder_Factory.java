package com.hivemq.client.internal.mqtt.codec.decoder.mqtt3;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt3ConnAckDecoder_Factory implements Factory<Mqtt3ConnAckDecoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt3ConnAckDecoder_Factory f17883a = new Mqtt3ConnAckDecoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt3ConnAckDecoder_Factory a() {
        return InstanceHolder.f17883a;
    }

    public static Mqtt3ConnAckDecoder c() {
        return new Mqtt3ConnAckDecoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt3ConnAckDecoder get() {
        return c();
    }
}
