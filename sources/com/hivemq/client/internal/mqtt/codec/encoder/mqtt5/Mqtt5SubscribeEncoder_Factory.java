package com.hivemq.client.internal.mqtt.codec.encoder.mqtt5;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt5SubscribeEncoder_Factory implements Factory<Mqtt5SubscribeEncoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt5SubscribeEncoder_Factory f17979a = new Mqtt5SubscribeEncoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt5SubscribeEncoder_Factory a() {
        return InstanceHolder.f17979a;
    }

    public static Mqtt5SubscribeEncoder c() {
        return new Mqtt5SubscribeEncoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt5SubscribeEncoder get() {
        return c();
    }
}
