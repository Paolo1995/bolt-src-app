package com.hivemq.client.internal.mqtt.codec.encoder.mqtt5;

import com.hivemq.client.internal.mqtt.codec.encoder.MqttPingReqEncoder;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class Mqtt5ClientMessageEncoders_Factory implements Factory<Mqtt5ClientMessageEncoders> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Mqtt5ConnectEncoder> f17952a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Mqtt5PublishEncoder> f17953b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Mqtt5PubAckEncoder> f17954c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<Mqtt5PubRecEncoder> f17955d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<Mqtt5PubRelEncoder> f17956e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<Mqtt5PubCompEncoder> f17957f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<Mqtt5SubscribeEncoder> f17958g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<Mqtt5UnsubscribeEncoder> f17959h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<MqttPingReqEncoder> f17960i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<Mqtt5DisconnectEncoder> f17961j;

    /* renamed from: k  reason: collision with root package name */
    private final Provider<Mqtt5AuthEncoder> f17962k;

    public Mqtt5ClientMessageEncoders_Factory(Provider<Mqtt5ConnectEncoder> provider, Provider<Mqtt5PublishEncoder> provider2, Provider<Mqtt5PubAckEncoder> provider3, Provider<Mqtt5PubRecEncoder> provider4, Provider<Mqtt5PubRelEncoder> provider5, Provider<Mqtt5PubCompEncoder> provider6, Provider<Mqtt5SubscribeEncoder> provider7, Provider<Mqtt5UnsubscribeEncoder> provider8, Provider<MqttPingReqEncoder> provider9, Provider<Mqtt5DisconnectEncoder> provider10, Provider<Mqtt5AuthEncoder> provider11) {
        this.f17952a = provider;
        this.f17953b = provider2;
        this.f17954c = provider3;
        this.f17955d = provider4;
        this.f17956e = provider5;
        this.f17957f = provider6;
        this.f17958g = provider7;
        this.f17959h = provider8;
        this.f17960i = provider9;
        this.f17961j = provider10;
        this.f17962k = provider11;
    }

    public static Mqtt5ClientMessageEncoders_Factory a(Provider<Mqtt5ConnectEncoder> provider, Provider<Mqtt5PublishEncoder> provider2, Provider<Mqtt5PubAckEncoder> provider3, Provider<Mqtt5PubRecEncoder> provider4, Provider<Mqtt5PubRelEncoder> provider5, Provider<Mqtt5PubCompEncoder> provider6, Provider<Mqtt5SubscribeEncoder> provider7, Provider<Mqtt5UnsubscribeEncoder> provider8, Provider<MqttPingReqEncoder> provider9, Provider<Mqtt5DisconnectEncoder> provider10, Provider<Mqtt5AuthEncoder> provider11) {
        return new Mqtt5ClientMessageEncoders_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static Mqtt5ClientMessageEncoders c(Mqtt5ConnectEncoder mqtt5ConnectEncoder, Mqtt5PublishEncoder mqtt5PublishEncoder, Mqtt5PubAckEncoder mqtt5PubAckEncoder, Mqtt5PubRecEncoder mqtt5PubRecEncoder, Mqtt5PubRelEncoder mqtt5PubRelEncoder, Mqtt5PubCompEncoder mqtt5PubCompEncoder, Mqtt5SubscribeEncoder mqtt5SubscribeEncoder, Mqtt5UnsubscribeEncoder mqtt5UnsubscribeEncoder, MqttPingReqEncoder mqttPingReqEncoder, Mqtt5DisconnectEncoder mqtt5DisconnectEncoder, Mqtt5AuthEncoder mqtt5AuthEncoder) {
        return new Mqtt5ClientMessageEncoders(mqtt5ConnectEncoder, mqtt5PublishEncoder, mqtt5PubAckEncoder, mqtt5PubRecEncoder, mqtt5PubRelEncoder, mqtt5PubCompEncoder, mqtt5SubscribeEncoder, mqtt5UnsubscribeEncoder, mqttPingReqEncoder, mqtt5DisconnectEncoder, mqtt5AuthEncoder);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt5ClientMessageEncoders get() {
        return c(this.f17952a.get(), this.f17953b.get(), this.f17954c.get(), this.f17955d.get(), this.f17956e.get(), this.f17957f.get(), this.f17958g.get(), this.f17959h.get(), this.f17960i.get(), this.f17961j.get(), this.f17962k.get());
    }
}
