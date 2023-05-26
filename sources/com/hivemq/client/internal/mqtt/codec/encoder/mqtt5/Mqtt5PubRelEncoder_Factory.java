package com.hivemq.client.internal.mqtt.codec.encoder.mqtt5;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt5PubRelEncoder_Factory implements Factory<Mqtt5PubRelEncoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt5PubRelEncoder_Factory f17975a = new Mqtt5PubRelEncoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt5PubRelEncoder_Factory a() {
        return InstanceHolder.f17975a;
    }

    public static Mqtt5PubRelEncoder c() {
        return new Mqtt5PubRelEncoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt5PubRelEncoder get() {
        return c();
    }
}
