package com.hivemq.client.internal.mqtt.codec.decoder.mqtt5;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt5PubCompDecoder_Factory implements Factory<Mqtt5PubCompDecoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt5PubCompDecoder_Factory f17906a = new Mqtt5PubCompDecoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt5PubCompDecoder_Factory a() {
        return InstanceHolder.f17906a;
    }

    public static Mqtt5PubCompDecoder c() {
        return new Mqtt5PubCompDecoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt5PubCompDecoder get() {
        return c();
    }
}
