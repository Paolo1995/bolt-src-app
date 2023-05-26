package com.hivemq.client.internal.mqtt.codec;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.codec.encoder.MqttMessageEncoders;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3ClientMessageEncoders;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5ClientMessageEncoders;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MqttCodecModule_ProvideMessageEncodersFactory implements Factory<MqttMessageEncoders> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MqttClientConfig> f17855a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Mqtt5ClientMessageEncoders> f17856b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Mqtt3ClientMessageEncoders> f17857c;

    public MqttCodecModule_ProvideMessageEncodersFactory(Provider<MqttClientConfig> provider, Provider<Mqtt5ClientMessageEncoders> provider2, Provider<Mqtt3ClientMessageEncoders> provider3) {
        this.f17855a = provider;
        this.f17856b = provider2;
        this.f17857c = provider3;
    }

    public static MqttCodecModule_ProvideMessageEncodersFactory a(Provider<MqttClientConfig> provider, Provider<Mqtt5ClientMessageEncoders> provider2, Provider<Mqtt3ClientMessageEncoders> provider3) {
        return new MqttCodecModule_ProvideMessageEncodersFactory(provider, provider2, provider3);
    }

    public static MqttMessageEncoders c(MqttClientConfig mqttClientConfig, Lazy<Mqtt5ClientMessageEncoders> lazy, Lazy<Mqtt3ClientMessageEncoders> lazy2) {
        return (MqttMessageEncoders) Preconditions.checkNotNull(MqttCodecModule.b(mqttClientConfig, lazy, lazy2), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MqttMessageEncoders get() {
        return c(this.f17855a.get(), DoubleCheck.lazy(this.f17856b), DoubleCheck.lazy(this.f17857c));
    }
}
