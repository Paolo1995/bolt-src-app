package com.hivemq.client.internal.mqtt.codec.encoder;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MqttEncoder_Factory implements Factory<MqttEncoder> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MqttMessageEncoders> f17918a;

    public MqttEncoder_Factory(Provider<MqttMessageEncoders> provider) {
        this.f17918a = provider;
    }

    public static MqttEncoder_Factory a(Provider<MqttMessageEncoders> provider) {
        return new MqttEncoder_Factory(provider);
    }

    public static MqttEncoder c(MqttMessageEncoders mqttMessageEncoders) {
        return new MqttEncoder(mqttMessageEncoders);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MqttEncoder get() {
        return c(this.f17918a.get());
    }
}
