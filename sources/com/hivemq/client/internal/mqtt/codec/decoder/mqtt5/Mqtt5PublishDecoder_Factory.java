package com.hivemq.client.internal.mqtt.codec.decoder.mqtt5;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt5PublishDecoder_Factory implements Factory<Mqtt5PublishDecoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt5PublishDecoder_Factory f17909a = new Mqtt5PublishDecoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt5PublishDecoder_Factory a() {
        return InstanceHolder.f17909a;
    }

    public static Mqtt5PublishDecoder c() {
        return new Mqtt5PublishDecoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt5PublishDecoder get() {
        return c();
    }
}
