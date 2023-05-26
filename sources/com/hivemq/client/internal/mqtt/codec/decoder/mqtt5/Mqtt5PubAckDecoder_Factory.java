package com.hivemq.client.internal.mqtt.codec.decoder.mqtt5;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt5PubAckDecoder_Factory implements Factory<Mqtt5PubAckDecoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt5PubAckDecoder_Factory f17905a = new Mqtt5PubAckDecoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt5PubAckDecoder_Factory a() {
        return InstanceHolder.f17905a;
    }

    public static Mqtt5PubAckDecoder c() {
        return new Mqtt5PubAckDecoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt5PubAckDecoder get() {
        return c();
    }
}
