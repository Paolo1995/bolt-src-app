package com.hivemq.client.internal.mqtt.codec.encoder.mqtt3;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt3PubCompEncoder_Factory implements Factory<Mqtt3PubCompEncoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt3PubCompEncoder_Factory f17939a = new Mqtt3PubCompEncoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt3PubCompEncoder_Factory a() {
        return InstanceHolder.f17939a;
    }

    public static Mqtt3PubCompEncoder c() {
        return new Mqtt3PubCompEncoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt3PubCompEncoder get() {
        return c();
    }
}
