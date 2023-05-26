package com.hivemq.client.internal.mqtt.codec.encoder.mqtt3;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt3PubAckEncoder_Factory implements Factory<Mqtt3PubAckEncoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt3PubAckEncoder_Factory f17937a = new Mqtt3PubAckEncoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt3PubAckEncoder_Factory a() {
        return InstanceHolder.f17937a;
    }

    public static Mqtt3PubAckEncoder c() {
        return new Mqtt3PubAckEncoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt3PubAckEncoder get() {
        return c();
    }
}
