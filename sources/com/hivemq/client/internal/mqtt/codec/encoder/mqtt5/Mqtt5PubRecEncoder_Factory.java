package com.hivemq.client.internal.mqtt.codec.encoder.mqtt5;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt5PubRecEncoder_Factory implements Factory<Mqtt5PubRecEncoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt5PubRecEncoder_Factory f17973a = new Mqtt5PubRecEncoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt5PubRecEncoder_Factory a() {
        return InstanceHolder.f17973a;
    }

    public static Mqtt5PubRecEncoder c() {
        return new Mqtt5PubRecEncoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt5PubRecEncoder get() {
        return c();
    }
}
