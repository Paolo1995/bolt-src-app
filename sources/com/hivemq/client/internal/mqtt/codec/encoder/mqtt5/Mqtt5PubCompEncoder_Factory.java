package com.hivemq.client.internal.mqtt.codec.encoder.mqtt5;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt5PubCompEncoder_Factory implements Factory<Mqtt5PubCompEncoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt5PubCompEncoder_Factory f17971a = new Mqtt5PubCompEncoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt5PubCompEncoder_Factory a() {
        return InstanceHolder.f17971a;
    }

    public static Mqtt5PubCompEncoder c() {
        return new Mqtt5PubCompEncoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt5PubCompEncoder get() {
        return c();
    }
}
