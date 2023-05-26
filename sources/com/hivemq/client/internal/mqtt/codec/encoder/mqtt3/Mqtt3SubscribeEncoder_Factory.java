package com.hivemq.client.internal.mqtt.codec.encoder.mqtt3;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt3SubscribeEncoder_Factory implements Factory<Mqtt3SubscribeEncoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt3SubscribeEncoder_Factory f17947a = new Mqtt3SubscribeEncoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt3SubscribeEncoder_Factory a() {
        return InstanceHolder.f17947a;
    }

    public static Mqtt3SubscribeEncoder c() {
        return new Mqtt3SubscribeEncoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt3SubscribeEncoder get() {
        return c();
    }
}
