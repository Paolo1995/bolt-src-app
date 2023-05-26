package com.hivemq.client.internal.mqtt.codec.decoder.mqtt3;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt3PubRelDecoder_Factory implements Factory<Mqtt3PubRelDecoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt3PubRelDecoder_Factory f17887a = new Mqtt3PubRelDecoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt3PubRelDecoder_Factory a() {
        return InstanceHolder.f17887a;
    }

    public static Mqtt3PubRelDecoder c() {
        return new Mqtt3PubRelDecoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt3PubRelDecoder get() {
        return c();
    }
}
