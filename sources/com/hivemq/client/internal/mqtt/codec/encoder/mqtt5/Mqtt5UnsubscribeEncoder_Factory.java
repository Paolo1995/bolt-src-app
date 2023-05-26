package com.hivemq.client.internal.mqtt.codec.encoder.mqtt5;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt5UnsubscribeEncoder_Factory implements Factory<Mqtt5UnsubscribeEncoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt5UnsubscribeEncoder_Factory f17981a = new Mqtt5UnsubscribeEncoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt5UnsubscribeEncoder_Factory a() {
        return InstanceHolder.f17981a;
    }

    public static Mqtt5UnsubscribeEncoder c() {
        return new Mqtt5UnsubscribeEncoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt5UnsubscribeEncoder get() {
        return c();
    }
}
