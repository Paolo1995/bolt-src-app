package com.hivemq.client.internal.mqtt.codec;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoders;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt3.Mqtt3ClientMessageDecoders;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt5.Mqtt5ClientMessageDecoders;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MqttCodecModule_ProvideMessageDecodersFactory implements Factory<MqttMessageDecoders> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MqttClientConfig> f17852a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Mqtt5ClientMessageDecoders> f17853b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Mqtt3ClientMessageDecoders> f17854c;

    public MqttCodecModule_ProvideMessageDecodersFactory(Provider<MqttClientConfig> provider, Provider<Mqtt5ClientMessageDecoders> provider2, Provider<Mqtt3ClientMessageDecoders> provider3) {
        this.f17852a = provider;
        this.f17853b = provider2;
        this.f17854c = provider3;
    }

    public static MqttCodecModule_ProvideMessageDecodersFactory a(Provider<MqttClientConfig> provider, Provider<Mqtt5ClientMessageDecoders> provider2, Provider<Mqtt3ClientMessageDecoders> provider3) {
        return new MqttCodecModule_ProvideMessageDecodersFactory(provider, provider2, provider3);
    }

    public static MqttMessageDecoders c(MqttClientConfig mqttClientConfig, Lazy<Mqtt5ClientMessageDecoders> lazy, Lazy<Mqtt3ClientMessageDecoders> lazy2) {
        return (MqttMessageDecoders) Preconditions.checkNotNull(MqttCodecModule.a(mqttClientConfig, lazy, lazy2), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MqttMessageDecoders get() {
        return c(this.f17852a.get(), DoubleCheck.lazy(this.f17853b), DoubleCheck.lazy(this.f17854c));
    }
}
