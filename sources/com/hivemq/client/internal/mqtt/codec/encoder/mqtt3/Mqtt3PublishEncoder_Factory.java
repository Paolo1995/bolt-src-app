package com.hivemq.client.internal.mqtt.codec.encoder.mqtt3;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt3PublishEncoder_Factory implements Factory<Mqtt3PublishEncoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt3PublishEncoder_Factory f17945a = new Mqtt3PublishEncoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt3PublishEncoder_Factory a() {
        return InstanceHolder.f17945a;
    }

    public static Mqtt3PublishEncoder c() {
        return new Mqtt3PublishEncoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt3PublishEncoder get() {
        return c();
    }
}
