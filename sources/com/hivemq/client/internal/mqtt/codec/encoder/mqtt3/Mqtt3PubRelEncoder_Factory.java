package com.hivemq.client.internal.mqtt.codec.encoder.mqtt3;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt3PubRelEncoder_Factory implements Factory<Mqtt3PubRelEncoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt3PubRelEncoder_Factory f17943a = new Mqtt3PubRelEncoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt3PubRelEncoder_Factory a() {
        return InstanceHolder.f17943a;
    }

    public static Mqtt3PubRelEncoder c() {
        return new Mqtt3PubRelEncoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt3PubRelEncoder get() {
        return c();
    }
}
