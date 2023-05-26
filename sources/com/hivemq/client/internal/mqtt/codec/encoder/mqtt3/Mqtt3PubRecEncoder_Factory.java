package com.hivemq.client.internal.mqtt.codec.encoder.mqtt3;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt3PubRecEncoder_Factory implements Factory<Mqtt3PubRecEncoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt3PubRecEncoder_Factory f17941a = new Mqtt3PubRecEncoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt3PubRecEncoder_Factory a() {
        return InstanceHolder.f17941a;
    }

    public static Mqtt3PubRecEncoder c() {
        return new Mqtt3PubRecEncoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt3PubRecEncoder get() {
        return c();
    }
}
