package com.hivemq.client.internal.mqtt.codec.decoder.mqtt3;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt3PublishDecoder_Factory implements Factory<Mqtt3PublishDecoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt3PublishDecoder_Factory f17888a = new Mqtt3PublishDecoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt3PublishDecoder_Factory a() {
        return InstanceHolder.f17888a;
    }

    public static Mqtt3PublishDecoder c() {
        return new Mqtt3PublishDecoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt3PublishDecoder get() {
        return c();
    }
}
