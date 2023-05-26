package com.hivemq.client.internal.mqtt.codec.decoder.mqtt3;

import com.hivemq.client.internal.mqtt.codec.decoder.MqttPingRespDecoder;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class Mqtt3ClientMessageDecoders_Factory implements Factory<Mqtt3ClientMessageDecoders> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Mqtt3ConnAckDecoder> f17874a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Mqtt3PublishDecoder> f17875b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Mqtt3PubAckDecoder> f17876c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<Mqtt3PubRecDecoder> f17877d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<Mqtt3PubRelDecoder> f17878e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<Mqtt3PubCompDecoder> f17879f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<Mqtt3SubAckDecoder> f17880g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<Mqtt3UnsubAckDecoder> f17881h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<MqttPingRespDecoder> f17882i;

    public Mqtt3ClientMessageDecoders_Factory(Provider<Mqtt3ConnAckDecoder> provider, Provider<Mqtt3PublishDecoder> provider2, Provider<Mqtt3PubAckDecoder> provider3, Provider<Mqtt3PubRecDecoder> provider4, Provider<Mqtt3PubRelDecoder> provider5, Provider<Mqtt3PubCompDecoder> provider6, Provider<Mqtt3SubAckDecoder> provider7, Provider<Mqtt3UnsubAckDecoder> provider8, Provider<MqttPingRespDecoder> provider9) {
        this.f17874a = provider;
        this.f17875b = provider2;
        this.f17876c = provider3;
        this.f17877d = provider4;
        this.f17878e = provider5;
        this.f17879f = provider6;
        this.f17880g = provider7;
        this.f17881h = provider8;
        this.f17882i = provider9;
    }

    public static Mqtt3ClientMessageDecoders_Factory a(Provider<Mqtt3ConnAckDecoder> provider, Provider<Mqtt3PublishDecoder> provider2, Provider<Mqtt3PubAckDecoder> provider3, Provider<Mqtt3PubRecDecoder> provider4, Provider<Mqtt3PubRelDecoder> provider5, Provider<Mqtt3PubCompDecoder> provider6, Provider<Mqtt3SubAckDecoder> provider7, Provider<Mqtt3UnsubAckDecoder> provider8, Provider<MqttPingRespDecoder> provider9) {
        return new Mqtt3ClientMessageDecoders_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static Mqtt3ClientMessageDecoders c(Mqtt3ConnAckDecoder mqtt3ConnAckDecoder, Mqtt3PublishDecoder mqtt3PublishDecoder, Mqtt3PubAckDecoder mqtt3PubAckDecoder, Mqtt3PubRecDecoder mqtt3PubRecDecoder, Mqtt3PubRelDecoder mqtt3PubRelDecoder, Mqtt3PubCompDecoder mqtt3PubCompDecoder, Mqtt3SubAckDecoder mqtt3SubAckDecoder, Mqtt3UnsubAckDecoder mqtt3UnsubAckDecoder, MqttPingRespDecoder mqttPingRespDecoder) {
        return new Mqtt3ClientMessageDecoders(mqtt3ConnAckDecoder, mqtt3PublishDecoder, mqtt3PubAckDecoder, mqtt3PubRecDecoder, mqtt3PubRelDecoder, mqtt3PubCompDecoder, mqtt3SubAckDecoder, mqtt3UnsubAckDecoder, mqttPingRespDecoder);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt3ClientMessageDecoders get() {
        return c(this.f17874a.get(), this.f17875b.get(), this.f17876c.get(), this.f17877d.get(), this.f17878e.get(), this.f17879f.get(), this.f17880g.get(), this.f17881h.get(), this.f17882i.get());
    }
}
