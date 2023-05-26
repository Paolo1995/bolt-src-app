package com.hivemq.client.internal.mqtt.codec.decoder;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnect;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MqttDecoder_Factory implements Factory<MqttDecoder> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MqttMessageDecoders> f17869a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MqttClientConfig> f17870b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<MqttConnect> f17871c;

    public MqttDecoder_Factory(Provider<MqttMessageDecoders> provider, Provider<MqttClientConfig> provider2, Provider<MqttConnect> provider3) {
        this.f17869a = provider;
        this.f17870b = provider2;
        this.f17871c = provider3;
    }

    public static MqttDecoder_Factory a(Provider<MqttMessageDecoders> provider, Provider<MqttClientConfig> provider2, Provider<MqttConnect> provider3) {
        return new MqttDecoder_Factory(provider, provider2, provider3);
    }

    public static MqttDecoder c(MqttMessageDecoders mqttMessageDecoders, MqttClientConfig mqttClientConfig, MqttConnect mqttConnect) {
        return new MqttDecoder(mqttMessageDecoders, mqttClientConfig, mqttConnect);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MqttDecoder get() {
        return c(this.f17869a.get(), this.f17870b.get(), this.f17871c.get());
    }
}
