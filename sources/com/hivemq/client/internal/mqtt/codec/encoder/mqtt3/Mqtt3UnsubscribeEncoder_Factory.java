package com.hivemq.client.internal.mqtt.codec.encoder.mqtt3;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt3UnsubscribeEncoder_Factory implements Factory<Mqtt3UnsubscribeEncoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt3UnsubscribeEncoder_Factory f17949a = new Mqtt3UnsubscribeEncoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt3UnsubscribeEncoder_Factory a() {
        return InstanceHolder.f17949a;
    }

    public static Mqtt3UnsubscribeEncoder c() {
        return new Mqtt3UnsubscribeEncoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt3UnsubscribeEncoder get() {
        return c();
    }
}
