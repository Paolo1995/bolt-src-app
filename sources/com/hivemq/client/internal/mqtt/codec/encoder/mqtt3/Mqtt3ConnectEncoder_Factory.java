package com.hivemq.client.internal.mqtt.codec.encoder.mqtt3;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt3ConnectEncoder_Factory implements Factory<Mqtt3ConnectEncoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt3ConnectEncoder_Factory f17933a = new Mqtt3ConnectEncoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt3ConnectEncoder_Factory a() {
        return InstanceHolder.f17933a;
    }

    public static Mqtt3ConnectEncoder c() {
        return new Mqtt3ConnectEncoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt3ConnectEncoder get() {
        return c();
    }
}
