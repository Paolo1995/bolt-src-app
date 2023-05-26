package com.hivemq.client.internal.mqtt.codec.decoder.mqtt5;

import com.hivemq.client.internal.mqtt.codec.decoder.MqttPingRespDecoder;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class Mqtt5ClientMessageDecoders_Factory implements Factory<Mqtt5ClientMessageDecoders> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Mqtt5ConnAckDecoder> f17892a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Mqtt5PublishDecoder> f17893b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Mqtt5PubAckDecoder> f17894c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<Mqtt5PubRecDecoder> f17895d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<Mqtt5PubRelDecoder> f17896e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<Mqtt5PubCompDecoder> f17897f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<Mqtt5SubAckDecoder> f17898g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<Mqtt5UnsubAckDecoder> f17899h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<MqttPingRespDecoder> f17900i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<Mqtt5DisconnectDecoder> f17901j;

    /* renamed from: k  reason: collision with root package name */
    private final Provider<Mqtt5AuthDecoder> f17902k;

    public Mqtt5ClientMessageDecoders_Factory(Provider<Mqtt5ConnAckDecoder> provider, Provider<Mqtt5PublishDecoder> provider2, Provider<Mqtt5PubAckDecoder> provider3, Provider<Mqtt5PubRecDecoder> provider4, Provider<Mqtt5PubRelDecoder> provider5, Provider<Mqtt5PubCompDecoder> provider6, Provider<Mqtt5SubAckDecoder> provider7, Provider<Mqtt5UnsubAckDecoder> provider8, Provider<MqttPingRespDecoder> provider9, Provider<Mqtt5DisconnectDecoder> provider10, Provider<Mqtt5AuthDecoder> provider11) {
        this.f17892a = provider;
        this.f17893b = provider2;
        this.f17894c = provider3;
        this.f17895d = provider4;
        this.f17896e = provider5;
        this.f17897f = provider6;
        this.f17898g = provider7;
        this.f17899h = provider8;
        this.f17900i = provider9;
        this.f17901j = provider10;
        this.f17902k = provider11;
    }

    public static Mqtt5ClientMessageDecoders_Factory a(Provider<Mqtt5ConnAckDecoder> provider, Provider<Mqtt5PublishDecoder> provider2, Provider<Mqtt5PubAckDecoder> provider3, Provider<Mqtt5PubRecDecoder> provider4, Provider<Mqtt5PubRelDecoder> provider5, Provider<Mqtt5PubCompDecoder> provider6, Provider<Mqtt5SubAckDecoder> provider7, Provider<Mqtt5UnsubAckDecoder> provider8, Provider<MqttPingRespDecoder> provider9, Provider<Mqtt5DisconnectDecoder> provider10, Provider<Mqtt5AuthDecoder> provider11) {
        return new Mqtt5ClientMessageDecoders_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static Mqtt5ClientMessageDecoders c(Mqtt5ConnAckDecoder mqtt5ConnAckDecoder, Mqtt5PublishDecoder mqtt5PublishDecoder, Mqtt5PubAckDecoder mqtt5PubAckDecoder, Mqtt5PubRecDecoder mqtt5PubRecDecoder, Mqtt5PubRelDecoder mqtt5PubRelDecoder, Mqtt5PubCompDecoder mqtt5PubCompDecoder, Mqtt5SubAckDecoder mqtt5SubAckDecoder, Mqtt5UnsubAckDecoder mqtt5UnsubAckDecoder, MqttPingRespDecoder mqttPingRespDecoder, Mqtt5DisconnectDecoder mqtt5DisconnectDecoder, Mqtt5AuthDecoder mqtt5AuthDecoder) {
        return new Mqtt5ClientMessageDecoders(mqtt5ConnAckDecoder, mqtt5PublishDecoder, mqtt5PubAckDecoder, mqtt5PubRecDecoder, mqtt5PubRelDecoder, mqtt5PubCompDecoder, mqtt5SubAckDecoder, mqtt5UnsubAckDecoder, mqttPingRespDecoder, mqtt5DisconnectDecoder, mqtt5AuthDecoder);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt5ClientMessageDecoders get() {
        return c(this.f17892a.get(), this.f17893b.get(), this.f17894c.get(), this.f17895d.get(), this.f17896e.get(), this.f17897f.get(), this.f17898g.get(), this.f17899h.get(), this.f17900i.get(), this.f17901j.get(), this.f17902k.get());
    }
}
