package com.hivemq.client.internal.mqtt.codec.decoder.mqtt5;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class Mqtt5DisconnectDecoder_Factory implements Factory<Mqtt5DisconnectDecoder> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Mqtt5DisconnectDecoder_Factory f17904a = new Mqtt5DisconnectDecoder_Factory();

        private InstanceHolder() {
        }
    }

    public static Mqtt5DisconnectDecoder_Factory a() {
        return InstanceHolder.f17904a;
    }

    public static Mqtt5DisconnectDecoder c() {
        return new Mqtt5DisconnectDecoder();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt5DisconnectDecoder get() {
        return c();
    }
}
