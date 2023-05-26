package com.hivemq.client.internal.mqtt.codec.decoder.mqtt5;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt5PubRelDecoder_Factory implements Factory<Mqtt5PubRelDecoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt5PubRelDecoder_Factory f17908a = new Mqtt5PubRelDecoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt5PubRelDecoder_Factory a() {
        return InstanceHolder.f17908a;
    }

    public static Mqtt5PubRelDecoder c() {
        return new Mqtt5PubRelDecoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt5PubRelDecoder get() {
        return c();
    }
}
