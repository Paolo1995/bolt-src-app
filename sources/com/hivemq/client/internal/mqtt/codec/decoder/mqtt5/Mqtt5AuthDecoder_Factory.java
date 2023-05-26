package com.hivemq.client.internal.mqtt.codec.decoder.mqtt5;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt5AuthDecoder_Factory implements Factory<Mqtt5AuthDecoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt5AuthDecoder_Factory f17891a = new Mqtt5AuthDecoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt5AuthDecoder_Factory a() {
        return InstanceHolder.f17891a;
    }

    public static Mqtt5AuthDecoder c() {
        return new Mqtt5AuthDecoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt5AuthDecoder get() {
        return c();
    }
}
