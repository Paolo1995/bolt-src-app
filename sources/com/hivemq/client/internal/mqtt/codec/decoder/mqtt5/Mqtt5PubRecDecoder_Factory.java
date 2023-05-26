package com.hivemq.client.internal.mqtt.codec.decoder.mqtt5;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt5PubRecDecoder_Factory implements Factory<Mqtt5PubRecDecoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt5PubRecDecoder_Factory f17907a = new Mqtt5PubRecDecoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt5PubRecDecoder_Factory a() {
        return InstanceHolder.f17907a;
    }

    public static Mqtt5PubRecDecoder c() {
        return new Mqtt5PubRecDecoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt5PubRecDecoder get() {
        return c();
    }
}
