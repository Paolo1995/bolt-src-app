package com.hivemq.client.internal.mqtt.codec.decoder.mqtt3;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt3PubCompDecoder_Factory implements Factory<Mqtt3PubCompDecoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt3PubCompDecoder_Factory f17885a = new Mqtt3PubCompDecoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt3PubCompDecoder_Factory a() {
        return InstanceHolder.f17885a;
    }

    public static Mqtt3PubCompDecoder c() {
        return new Mqtt3PubCompDecoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt3PubCompDecoder get() {
        return c();
    }
}
