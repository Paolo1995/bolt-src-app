package com.hivemq.client.internal.mqtt.codec.encoder.mqtt3;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt3DisconnectEncoder_Factory implements Factory<Mqtt3DisconnectEncoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt3DisconnectEncoder_Factory f17935a = new Mqtt3DisconnectEncoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt3DisconnectEncoder_Factory a() {
        return InstanceHolder.f17935a;
    }

    public static Mqtt3DisconnectEncoder c() {
        return new Mqtt3DisconnectEncoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt3DisconnectEncoder get() {
        return c();
    }
}
