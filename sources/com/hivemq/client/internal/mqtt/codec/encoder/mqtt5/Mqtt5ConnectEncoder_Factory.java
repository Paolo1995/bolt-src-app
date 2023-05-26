package com.hivemq.client.internal.mqtt.codec.encoder.mqtt5;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class Mqtt5ConnectEncoder_Factory implements Factory<Mqtt5ConnectEncoder> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Mqtt5PublishEncoder> f17965a;

    public Mqtt5ConnectEncoder_Factory(Provider<Mqtt5PublishEncoder> provider) {
        this.f17965a = provider;
    }

    public static Mqtt5ConnectEncoder_Factory a(Provider<Mqtt5PublishEncoder> provider) {
        return new Mqtt5ConnectEncoder_Factory(provider);
    }

    public static Mqtt5ConnectEncoder c(Mqtt5PublishEncoder mqtt5PublishEncoder) {
        return new Mqtt5ConnectEncoder(mqtt5PublishEncoder);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt5ConnectEncoder get() {
        return c(this.f17965a.get());
    }
}
