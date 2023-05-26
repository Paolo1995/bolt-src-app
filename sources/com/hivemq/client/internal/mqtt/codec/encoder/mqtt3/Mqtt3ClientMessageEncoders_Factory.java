package com.hivemq.client.internal.mqtt.codec.encoder.mqtt3;

import com.hivemq.client.internal.mqtt.codec.encoder.MqttPingReqEncoder;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class Mqtt3ClientMessageEncoders_Factory implements Factory<Mqtt3ClientMessageEncoders> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Mqtt3ConnectEncoder> f17922a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Mqtt3PublishEncoder> f17923b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Mqtt3PubAckEncoder> f17924c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<Mqtt3PubRecEncoder> f17925d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<Mqtt3PubRelEncoder> f17926e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<Mqtt3PubCompEncoder> f17927f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<Mqtt3SubscribeEncoder> f17928g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<Mqtt3UnsubscribeEncoder> f17929h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<MqttPingReqEncoder> f17930i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<Mqtt3DisconnectEncoder> f17931j;

    public Mqtt3ClientMessageEncoders_Factory(Provider<Mqtt3ConnectEncoder> provider, Provider<Mqtt3PublishEncoder> provider2, Provider<Mqtt3PubAckEncoder> provider3, Provider<Mqtt3PubRecEncoder> provider4, Provider<Mqtt3PubRelEncoder> provider5, Provider<Mqtt3PubCompEncoder> provider6, Provider<Mqtt3SubscribeEncoder> provider7, Provider<Mqtt3UnsubscribeEncoder> provider8, Provider<MqttPingReqEncoder> provider9, Provider<Mqtt3DisconnectEncoder> provider10) {
        this.f17922a = provider;
        this.f17923b = provider2;
        this.f17924c = provider3;
        this.f17925d = provider4;
        this.f17926e = provider5;
        this.f17927f = provider6;
        this.f17928g = provider7;
        this.f17929h = provider8;
        this.f17930i = provider9;
        this.f17931j = provider10;
    }

    public static Mqtt3ClientMessageEncoders_Factory a(Provider<Mqtt3ConnectEncoder> provider, Provider<Mqtt3PublishEncoder> provider2, Provider<Mqtt3PubAckEncoder> provider3, Provider<Mqtt3PubRecEncoder> provider4, Provider<Mqtt3PubRelEncoder> provider5, Provider<Mqtt3PubCompEncoder> provider6, Provider<Mqtt3SubscribeEncoder> provider7, Provider<Mqtt3UnsubscribeEncoder> provider8, Provider<MqttPingReqEncoder> provider9, Provider<Mqtt3DisconnectEncoder> provider10) {
        return new Mqtt3ClientMessageEncoders_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static Mqtt3ClientMessageEncoders c(Mqtt3ConnectEncoder mqtt3ConnectEncoder, Mqtt3PublishEncoder mqtt3PublishEncoder, Mqtt3PubAckEncoder mqtt3PubAckEncoder, Mqtt3PubRecEncoder mqtt3PubRecEncoder, Mqtt3PubRelEncoder mqtt3PubRelEncoder, Mqtt3PubCompEncoder mqtt3PubCompEncoder, Mqtt3SubscribeEncoder mqtt3SubscribeEncoder, Mqtt3UnsubscribeEncoder mqtt3UnsubscribeEncoder, MqttPingReqEncoder mqttPingReqEncoder, Mqtt3DisconnectEncoder mqtt3DisconnectEncoder) {
        return new Mqtt3ClientMessageEncoders(mqtt3ConnectEncoder, mqtt3PublishEncoder, mqtt3PubAckEncoder, mqtt3PubRecEncoder, mqtt3PubRelEncoder, mqtt3PubCompEncoder, mqtt3SubscribeEncoder, mqtt3UnsubscribeEncoder, mqttPingReqEncoder, mqtt3DisconnectEncoder);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Mqtt3ClientMessageEncoders get() {
        return c(this.f17922a.get(), this.f17923b.get(), this.f17924c.get(), this.f17925d.get(), this.f17926e.get(), this.f17927f.get(), this.f17928g.get(), this.f17929h.get(), this.f17930i.get(), this.f17931j.get());
    }
}
