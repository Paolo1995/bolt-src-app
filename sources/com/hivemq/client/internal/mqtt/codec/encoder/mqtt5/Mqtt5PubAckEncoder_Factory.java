package com.hivemq.client.internal.mqtt.codec.encoder.mqtt5;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt5PubAckEncoder_Factory implements Factory<Mqtt5PubAckEncoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt5PubAckEncoder_Factory f17969a = new Mqtt5PubAckEncoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt5PubAckEncoder_Factory a() {
        return InstanceHolder.f17969a;
    }

    public static Mqtt5PubAckEncoder c() {
        return new Mqtt5PubAckEncoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt5PubAckEncoder get() {
        return c();
    }
}
