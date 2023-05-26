package com.hivemq.client.internal.mqtt.codec.encoder.mqtt5;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt5AuthEncoder_Factory implements Factory<Mqtt5AuthEncoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt5AuthEncoder_Factory f17951a = new Mqtt5AuthEncoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt5AuthEncoder_Factory a() {
        return InstanceHolder.f17951a;
    }

    public static Mqtt5AuthEncoder c() {
        return new Mqtt5AuthEncoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt5AuthEncoder get() {
        return c();
    }
}
