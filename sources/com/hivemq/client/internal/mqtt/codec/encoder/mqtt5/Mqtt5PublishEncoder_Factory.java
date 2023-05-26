package com.hivemq.client.internal.mqtt.codec.encoder.mqtt5;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt5PublishEncoder_Factory implements Factory<Mqtt5PublishEncoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt5PublishEncoder_Factory f17977a = new Mqtt5PublishEncoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt5PublishEncoder_Factory a() {
        return InstanceHolder.f17977a;
    }

    public static Mqtt5PublishEncoder c() {
        return new Mqtt5PublishEncoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt5PublishEncoder get() {
        return c();
    }
}
