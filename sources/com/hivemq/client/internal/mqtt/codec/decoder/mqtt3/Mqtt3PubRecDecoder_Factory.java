package com.hivemq.client.internal.mqtt.codec.decoder.mqtt3;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt3PubRecDecoder_Factory implements Factory<Mqtt3PubRecDecoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt3PubRecDecoder_Factory f17886a = new Mqtt3PubRecDecoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt3PubRecDecoder_Factory a() {
        return InstanceHolder.f17886a;
    }

    public static Mqtt3PubRecDecoder c() {
        return new Mqtt3PubRecDecoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt3PubRecDecoder get() {
        return c();
    }
}
