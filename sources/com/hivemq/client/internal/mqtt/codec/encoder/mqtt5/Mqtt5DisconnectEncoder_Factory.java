package com.hivemq.client.internal.mqtt.codec.encoder.mqtt5;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt5DisconnectEncoder_Factory implements Factory<Mqtt5DisconnectEncoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt5DisconnectEncoder_Factory f17967a = new Mqtt5DisconnectEncoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt5DisconnectEncoder_Factory a() {
        return InstanceHolder.f17967a;
    }

    public static Mqtt5DisconnectEncoder c() {
        return new Mqtt5DisconnectEncoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt5DisconnectEncoder get() {
        return c();
    }
}
