package com.hivemq.client.internal.mqtt.ioc;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.codec.MqttCodecModule_ProvideMessageDecodersFactory;
import com.hivemq.client.internal.mqtt.codec.MqttCodecModule_ProvideMessageEncodersFactory;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttDecoder_Factory;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoders;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttPingRespDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttPingRespDecoder_Factory;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt3.Mqtt3ClientMessageDecoders;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt3.Mqtt3ClientMessageDecoders_Factory;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt3.Mqtt3ConnAckDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt3.Mqtt3ConnAckDecoder_Factory;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt3.Mqtt3PubAckDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt3.Mqtt3PubAckDecoder_Factory;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt3.Mqtt3PubCompDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt3.Mqtt3PubCompDecoder_Factory;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt3.Mqtt3PubRecDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt3.Mqtt3PubRecDecoder_Factory;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt3.Mqtt3PubRelDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt3.Mqtt3PubRelDecoder_Factory;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt3.Mqtt3PublishDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt3.Mqtt3PublishDecoder_Factory;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt3.Mqtt3SubAckDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt3.Mqtt3SubAckDecoder_Factory;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt3.Mqtt3UnsubAckDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt3.Mqtt3UnsubAckDecoder_Factory;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt5.Mqtt5AuthDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt5.Mqtt5AuthDecoder_Factory;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt5.Mqtt5ClientMessageDecoders;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt5.Mqtt5ClientMessageDecoders_Factory;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt5.Mqtt5ConnAckDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt5.Mqtt5ConnAckDecoder_Factory;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt5.Mqtt5DisconnectDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt5.Mqtt5DisconnectDecoder_Factory;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt5.Mqtt5PubAckDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt5.Mqtt5PubAckDecoder_Factory;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt5.Mqtt5PubCompDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt5.Mqtt5PubCompDecoder_Factory;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt5.Mqtt5PubRecDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt5.Mqtt5PubRecDecoder_Factory;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt5.Mqtt5PubRelDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt5.Mqtt5PubRelDecoder_Factory;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt5.Mqtt5PublishDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt5.Mqtt5PublishDecoder_Factory;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt5.Mqtt5SubAckDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt5.Mqtt5SubAckDecoder_Factory;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt5.Mqtt5UnsubAckDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.mqtt5.Mqtt5UnsubAckDecoder_Factory;
import com.hivemq.client.internal.mqtt.codec.encoder.MqttEncoder;
import com.hivemq.client.internal.mqtt.codec.encoder.MqttEncoder_Factory;
import com.hivemq.client.internal.mqtt.codec.encoder.MqttMessageEncoders;
import com.hivemq.client.internal.mqtt.codec.encoder.MqttPingReqEncoder;
import com.hivemq.client.internal.mqtt.codec.encoder.MqttPingReqEncoder_Factory;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3ClientMessageEncoders;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3ClientMessageEncoders_Factory;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3ConnectEncoder;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3ConnectEncoder_Factory;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3DisconnectEncoder;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3DisconnectEncoder_Factory;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3PubAckEncoder;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3PubAckEncoder_Factory;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3PubCompEncoder;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3PubCompEncoder_Factory;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3PubRecEncoder;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3PubRecEncoder_Factory;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3PubRelEncoder;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3PubRelEncoder_Factory;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3PublishEncoder;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3PublishEncoder_Factory;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3SubscribeEncoder;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3SubscribeEncoder_Factory;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3UnsubscribeEncoder;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3UnsubscribeEncoder_Factory;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5AuthEncoder;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5AuthEncoder_Factory;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5ClientMessageEncoders;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5ClientMessageEncoders_Factory;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5ConnectEncoder;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5ConnectEncoder_Factory;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5DisconnectEncoder;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5DisconnectEncoder_Factory;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5PubAckEncoder;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5PubAckEncoder_Factory;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5PubCompEncoder;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5PubCompEncoder_Factory;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5PubRecEncoder;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5PubRecEncoder_Factory;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5PubRelEncoder;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5PubRelEncoder_Factory;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5PublishEncoder;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5PublishEncoder_Factory;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5SubscribeEncoder;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5SubscribeEncoder_Factory;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5UnsubscribeEncoder;
import com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5UnsubscribeEncoder_Factory;
import com.hivemq.client.internal.mqtt.handler.MqttChannelInitializer;
import com.hivemq.client.internal.mqtt.handler.MqttChannelInitializer_Factory;
import com.hivemq.client.internal.mqtt.handler.MqttSession;
import com.hivemq.client.internal.mqtt.handler.MqttSession_Factory;
import com.hivemq.client.internal.mqtt.handler.auth.MqttAuthHandler;
import com.hivemq.client.internal.mqtt.handler.auth.MqttConnectAuthHandler;
import com.hivemq.client.internal.mqtt.handler.auth.MqttConnectAuthHandler_Factory;
import com.hivemq.client.internal.mqtt.handler.auth.MqttDisconnectOnAuthHandler;
import com.hivemq.client.internal.mqtt.handler.auth.MqttDisconnectOnAuthHandler_Factory;
import com.hivemq.client.internal.mqtt.handler.connect.MqttConnAckFlow;
import com.hivemq.client.internal.mqtt.handler.connect.MqttConnectHandler;
import com.hivemq.client.internal.mqtt.handler.connect.MqttConnectHandler_Factory;
import com.hivemq.client.internal.mqtt.handler.disconnect.MqttDisconnectHandler;
import com.hivemq.client.internal.mqtt.handler.disconnect.MqttDisconnectHandler_Factory;
import com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttIncomingPublishFlows;
import com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttIncomingPublishFlows_Factory;
import com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttIncomingQosHandler;
import com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttIncomingQosHandler_Factory;
import com.hivemq.client.internal.mqtt.handler.publish.outgoing.MqttOutgoingQosHandler;
import com.hivemq.client.internal.mqtt.handler.publish.outgoing.MqttOutgoingQosHandler_Factory;
import com.hivemq.client.internal.mqtt.handler.subscribe.MqttSubscriptionHandler;
import com.hivemq.client.internal.mqtt.handler.subscribe.MqttSubscriptionHandler_Factory;
import com.hivemq.client.internal.mqtt.handler.websocket.MqttWebSocketCodec;
import com.hivemq.client.internal.mqtt.handler.websocket.MqttWebSocketCodec_Factory;
import com.hivemq.client.internal.mqtt.handler.websocket.MqttWebSocketInitializer;
import com.hivemq.client.internal.mqtt.handler.websocket.MqttWebSocketInitializer_Factory;
import com.hivemq.client.internal.mqtt.ioc.ClientComponent;
import com.hivemq.client.internal.mqtt.ioc.ConnectionComponent;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnect;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import io.netty.bootstrap.Bootstrap;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DaggerSingletonComponent implements SingletonComponent {
    private Provider<Mqtt5PubRecDecoder> A;
    private Provider<Mqtt5PubRelDecoder> B;
    private Provider<Mqtt5PubCompDecoder> C;
    private Provider<Mqtt5SubAckDecoder> D;
    private Provider<Mqtt5UnsubAckDecoder> E;
    private Provider<MqttPingRespDecoder> F;
    private Provider<Mqtt5DisconnectDecoder> G;
    private Provider<Mqtt5AuthDecoder> H;
    private Provider<Mqtt5ClientMessageDecoders> I;
    private Provider<Mqtt3ConnAckDecoder> J;
    private Provider<Mqtt3PublishDecoder> K;
    private Provider<Mqtt3PubAckDecoder> L;
    private Provider<Mqtt3PubRecDecoder> M;
    private Provider<Mqtt3PubRelDecoder> N;
    private Provider<Mqtt3PubCompDecoder> O;
    private Provider<Mqtt3SubAckDecoder> P;
    private Provider<Mqtt3UnsubAckDecoder> Q;
    private Provider<Mqtt3ClientMessageDecoders> R;
    private Provider<MqttDisconnectOnAuthHandler> S;
    private Provider<MqttWebSocketCodec> T;

    /* renamed from: b  reason: collision with root package name */
    private Provider<Mqtt5PublishEncoder> f18370b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<Mqtt5ConnectEncoder> f18371c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<Mqtt5PubAckEncoder> f18372d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<Mqtt5PubRecEncoder> f18373e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<Mqtt5PubRelEncoder> f18374f;

    /* renamed from: g  reason: collision with root package name */
    private Provider<Mqtt5PubCompEncoder> f18375g;

    /* renamed from: h  reason: collision with root package name */
    private Provider<Mqtt5SubscribeEncoder> f18376h;

    /* renamed from: i  reason: collision with root package name */
    private Provider<Mqtt5UnsubscribeEncoder> f18377i;

    /* renamed from: j  reason: collision with root package name */
    private Provider<MqttPingReqEncoder> f18378j;

    /* renamed from: k  reason: collision with root package name */
    private Provider<Mqtt5DisconnectEncoder> f18379k;

    /* renamed from: l  reason: collision with root package name */
    private Provider<Mqtt5AuthEncoder> f18380l;

    /* renamed from: m  reason: collision with root package name */
    private Provider<Mqtt5ClientMessageEncoders> f18381m;

    /* renamed from: n  reason: collision with root package name */
    private Provider<Mqtt3ConnectEncoder> f18382n;

    /* renamed from: o  reason: collision with root package name */
    private Provider<Mqtt3PublishEncoder> f18383o;

    /* renamed from: p  reason: collision with root package name */
    private Provider<Mqtt3PubAckEncoder> f18384p;

    /* renamed from: q  reason: collision with root package name */
    private Provider<Mqtt3PubRecEncoder> f18385q;

    /* renamed from: r  reason: collision with root package name */
    private Provider<Mqtt3PubRelEncoder> f18386r;

    /* renamed from: s  reason: collision with root package name */
    private Provider<Mqtt3PubCompEncoder> f18387s;

    /* renamed from: t  reason: collision with root package name */
    private Provider<Mqtt3SubscribeEncoder> f18388t;

    /* renamed from: u  reason: collision with root package name */
    private Provider<Mqtt3UnsubscribeEncoder> f18389u;

    /* renamed from: v  reason: collision with root package name */
    private Provider<Mqtt3DisconnectEncoder> f18390v;

    /* renamed from: w  reason: collision with root package name */
    private Provider<Mqtt3ClientMessageEncoders> f18391w;

    /* renamed from: x  reason: collision with root package name */
    private Provider<Mqtt5ConnAckDecoder> f18392x;

    /* renamed from: y  reason: collision with root package name */
    private Provider<Mqtt5PublishDecoder> f18393y;

    /* renamed from: z  reason: collision with root package name */
    private Provider<Mqtt5PubAckDecoder> f18394z;

    /* loaded from: classes3.dex */
    public static final class Builder {
        public SingletonComponent a() {
            return new DaggerSingletonComponent();
        }

        private Builder() {
        }
    }

    /* loaded from: classes3.dex */
    private final class ClientComponentBuilder implements ClientComponent.Builder {

        /* renamed from: a  reason: collision with root package name */
        private MqttClientConfig f18395a;

        private ClientComponentBuilder() {
        }

        @Override // com.hivemq.client.internal.mqtt.ioc.ClientComponent.Builder
        /* renamed from: b */
        public ClientComponentBuilder a(MqttClientConfig mqttClientConfig) {
            this.f18395a = (MqttClientConfig) Preconditions.checkNotNull(mqttClientConfig);
            return this;
        }

        @Override // com.hivemq.client.internal.mqtt.ioc.ClientComponent.Builder
        public ClientComponent build() {
            Preconditions.checkBuilderRequirement(this.f18395a, MqttClientConfig.class);
            return new ClientComponentImpl(this.f18395a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class ClientComponentImpl implements ClientComponent {

        /* renamed from: a  reason: collision with root package name */
        private Provider<MqttClientConfig> f18397a;

        /* renamed from: b  reason: collision with root package name */
        private Provider<MqttIncomingPublishFlows> f18398b;

        /* renamed from: c  reason: collision with root package name */
        private Provider<MqttSubscriptionHandler> f18399c;

        /* renamed from: d  reason: collision with root package name */
        private Provider<MqttIncomingQosHandler> f18400d;

        /* renamed from: e  reason: collision with root package name */
        private Provider<MqttOutgoingQosHandler> f18401e;

        /* renamed from: f  reason: collision with root package name */
        private Provider<MqttSession> f18402f;

        /* loaded from: classes3.dex */
        private final class ConnectionComponentBuilder implements ConnectionComponent.Builder {

            /* renamed from: a  reason: collision with root package name */
            private MqttConnect f18404a;

            /* renamed from: b  reason: collision with root package name */
            private MqttConnAckFlow f18405b;

            private ConnectionComponentBuilder() {
            }

            @Override // com.hivemq.client.internal.mqtt.ioc.ConnectionComponent.Builder
            public ConnectionComponent build() {
                Preconditions.checkBuilderRequirement(this.f18404a, MqttConnect.class);
                Preconditions.checkBuilderRequirement(this.f18405b, MqttConnAckFlow.class);
                return new ConnectionComponentImpl(this.f18404a, this.f18405b);
            }

            @Override // com.hivemq.client.internal.mqtt.ioc.ConnectionComponent.Builder
            /* renamed from: c */
            public ConnectionComponentBuilder a(MqttConnAckFlow mqttConnAckFlow) {
                this.f18405b = (MqttConnAckFlow) Preconditions.checkNotNull(mqttConnAckFlow);
                return this;
            }

            @Override // com.hivemq.client.internal.mqtt.ioc.ConnectionComponent.Builder
            /* renamed from: d */
            public ConnectionComponentBuilder b(MqttConnect mqttConnect) {
                this.f18404a = (MqttConnect) Preconditions.checkNotNull(mqttConnect);
                return this;
            }
        }

        /* loaded from: classes3.dex */
        private final class ConnectionComponentImpl implements ConnectionComponent {

            /* renamed from: a  reason: collision with root package name */
            private Provider<MqttConnect> f18407a;

            /* renamed from: b  reason: collision with root package name */
            private Provider<MqttConnAckFlow> f18408b;

            /* renamed from: c  reason: collision with root package name */
            private Provider<MqttMessageEncoders> f18409c;

            /* renamed from: d  reason: collision with root package name */
            private Provider<MqttEncoder> f18410d;

            /* renamed from: e  reason: collision with root package name */
            private Provider<MqttMessageDecoders> f18411e;

            /* renamed from: f  reason: collision with root package name */
            private Provider<MqttDecoder> f18412f;

            /* renamed from: g  reason: collision with root package name */
            private Provider<MqttConnectHandler> f18413g;

            /* renamed from: h  reason: collision with root package name */
            private Provider<MqttDisconnectHandler> f18414h;

            /* renamed from: i  reason: collision with root package name */
            private Provider<MqttConnectAuthHandler> f18415i;

            /* renamed from: j  reason: collision with root package name */
            private Provider<MqttAuthHandler> f18416j;

            /* renamed from: k  reason: collision with root package name */
            private Provider<MqttWebSocketInitializer> f18417k;

            /* renamed from: l  reason: collision with root package name */
            private Provider<MqttChannelInitializer> f18418l;

            private void b(MqttConnect mqttConnect, MqttConnAckFlow mqttConnAckFlow) {
                this.f18407a = InstanceFactory.create(mqttConnect);
                this.f18408b = InstanceFactory.create(mqttConnAckFlow);
                Provider<MqttMessageEncoders> provider = DoubleCheck.provider(MqttCodecModule_ProvideMessageEncodersFactory.a(ClientComponentImpl.this.f18397a, DaggerSingletonComponent.this.f18381m, DaggerSingletonComponent.this.f18391w));
                this.f18409c = provider;
                this.f18410d = DoubleCheck.provider(MqttEncoder_Factory.a(provider));
                Provider<MqttMessageDecoders> provider2 = DoubleCheck.provider(MqttCodecModule_ProvideMessageDecodersFactory.a(ClientComponentImpl.this.f18397a, DaggerSingletonComponent.this.I, DaggerSingletonComponent.this.R));
                this.f18411e = provider2;
                this.f18412f = DoubleCheck.provider(MqttDecoder_Factory.a(provider2, ClientComponentImpl.this.f18397a, this.f18407a));
                this.f18413g = DoubleCheck.provider(MqttConnectHandler_Factory.a(this.f18407a, this.f18408b, ClientComponentImpl.this.f18397a, ClientComponentImpl.this.f18402f, this.f18412f));
                this.f18414h = DoubleCheck.provider(MqttDisconnectHandler_Factory.a(ClientComponentImpl.this.f18397a, ClientComponentImpl.this.f18402f));
                Provider<MqttConnectAuthHandler> provider3 = DoubleCheck.provider(MqttConnectAuthHandler_Factory.a(ClientComponentImpl.this.f18397a, this.f18407a));
                this.f18415i = provider3;
                this.f18416j = DoubleCheck.provider(ConnectionModule_ProvideAuthHandlerFactory.a(this.f18407a, provider3, DaggerSingletonComponent.this.S));
                this.f18417k = DoubleCheck.provider(MqttWebSocketInitializer_Factory.a(DaggerSingletonComponent.this.T));
                this.f18418l = DoubleCheck.provider(MqttChannelInitializer_Factory.a(ClientComponentImpl.this.f18397a, this.f18407a, this.f18408b, this.f18410d, this.f18413g, this.f18414h, this.f18416j, this.f18417k));
            }

            @Override // com.hivemq.client.internal.mqtt.ioc.ConnectionComponent
            public Bootstrap a() {
                return ConnectionModule_ProvideBootstrapFactory.a(this.f18418l.get());
            }

            private ConnectionComponentImpl(MqttConnect mqttConnect, MqttConnAckFlow mqttConnAckFlow) {
                b(mqttConnect, mqttConnAckFlow);
            }
        }

        private void g(MqttClientConfig mqttClientConfig) {
            this.f18397a = InstanceFactory.create(mqttClientConfig);
            Provider<MqttIncomingPublishFlows> provider = DoubleCheck.provider(MqttIncomingPublishFlows_Factory.a());
            this.f18398b = provider;
            this.f18399c = DoubleCheck.provider(MqttSubscriptionHandler_Factory.a(this.f18397a, provider));
            this.f18400d = DoubleCheck.provider(MqttIncomingQosHandler_Factory.a(this.f18397a, this.f18398b));
            Provider<MqttOutgoingQosHandler> provider2 = DoubleCheck.provider(MqttOutgoingQosHandler_Factory.a(this.f18397a));
            this.f18401e = provider2;
            this.f18402f = DoubleCheck.provider(MqttSession_Factory.a(this.f18399c, this.f18400d, provider2));
        }

        @Override // com.hivemq.client.internal.mqtt.ioc.ClientComponent
        public MqttSubscriptionHandler a() {
            return this.f18399c.get();
        }

        @Override // com.hivemq.client.internal.mqtt.ioc.ClientComponent
        public MqttOutgoingQosHandler b() {
            return this.f18401e.get();
        }

        @Override // com.hivemq.client.internal.mqtt.ioc.ClientComponent
        public MqttIncomingQosHandler c() {
            return this.f18400d.get();
        }

        @Override // com.hivemq.client.internal.mqtt.ioc.ClientComponent
        public ConnectionComponent.Builder d() {
            return new ConnectionComponentBuilder();
        }

        private ClientComponentImpl(MqttClientConfig mqttClientConfig) {
            g(mqttClientConfig);
        }
    }

    public static SingletonComponent h() {
        return new Builder().a();
    }

    private void i() {
        Provider<Mqtt5PublishEncoder> provider = DoubleCheck.provider(Mqtt5PublishEncoder_Factory.a());
        this.f18370b = provider;
        this.f18371c = DoubleCheck.provider(Mqtt5ConnectEncoder_Factory.a(provider));
        this.f18372d = DoubleCheck.provider(Mqtt5PubAckEncoder_Factory.a());
        this.f18373e = DoubleCheck.provider(Mqtt5PubRecEncoder_Factory.a());
        this.f18374f = DoubleCheck.provider(Mqtt5PubRelEncoder_Factory.a());
        this.f18375g = DoubleCheck.provider(Mqtt5PubCompEncoder_Factory.a());
        this.f18376h = DoubleCheck.provider(Mqtt5SubscribeEncoder_Factory.a());
        this.f18377i = DoubleCheck.provider(Mqtt5UnsubscribeEncoder_Factory.a());
        this.f18378j = DoubleCheck.provider(MqttPingReqEncoder_Factory.a());
        this.f18379k = DoubleCheck.provider(Mqtt5DisconnectEncoder_Factory.a());
        Provider<Mqtt5AuthEncoder> provider2 = DoubleCheck.provider(Mqtt5AuthEncoder_Factory.a());
        this.f18380l = provider2;
        this.f18381m = DoubleCheck.provider(Mqtt5ClientMessageEncoders_Factory.a(this.f18371c, this.f18370b, this.f18372d, this.f18373e, this.f18374f, this.f18375g, this.f18376h, this.f18377i, this.f18378j, this.f18379k, provider2));
        this.f18382n = DoubleCheck.provider(Mqtt3ConnectEncoder_Factory.a());
        this.f18383o = DoubleCheck.provider(Mqtt3PublishEncoder_Factory.a());
        this.f18384p = DoubleCheck.provider(Mqtt3PubAckEncoder_Factory.a());
        this.f18385q = DoubleCheck.provider(Mqtt3PubRecEncoder_Factory.a());
        this.f18386r = DoubleCheck.provider(Mqtt3PubRelEncoder_Factory.a());
        this.f18387s = DoubleCheck.provider(Mqtt3PubCompEncoder_Factory.a());
        this.f18388t = DoubleCheck.provider(Mqtt3SubscribeEncoder_Factory.a());
        this.f18389u = DoubleCheck.provider(Mqtt3UnsubscribeEncoder_Factory.a());
        Provider<Mqtt3DisconnectEncoder> provider3 = DoubleCheck.provider(Mqtt3DisconnectEncoder_Factory.a());
        this.f18390v = provider3;
        this.f18391w = DoubleCheck.provider(Mqtt3ClientMessageEncoders_Factory.a(this.f18382n, this.f18383o, this.f18384p, this.f18385q, this.f18386r, this.f18387s, this.f18388t, this.f18389u, this.f18378j, provider3));
        this.f18392x = DoubleCheck.provider(Mqtt5ConnAckDecoder_Factory.a());
        this.f18393y = DoubleCheck.provider(Mqtt5PublishDecoder_Factory.a());
        this.f18394z = DoubleCheck.provider(Mqtt5PubAckDecoder_Factory.a());
        this.A = DoubleCheck.provider(Mqtt5PubRecDecoder_Factory.a());
        this.B = DoubleCheck.provider(Mqtt5PubRelDecoder_Factory.a());
        this.C = DoubleCheck.provider(Mqtt5PubCompDecoder_Factory.a());
        this.D = DoubleCheck.provider(Mqtt5SubAckDecoder_Factory.a());
        this.E = DoubleCheck.provider(Mqtt5UnsubAckDecoder_Factory.a());
        this.F = DoubleCheck.provider(MqttPingRespDecoder_Factory.a());
        this.G = DoubleCheck.provider(Mqtt5DisconnectDecoder_Factory.a());
        Provider<Mqtt5AuthDecoder> provider4 = DoubleCheck.provider(Mqtt5AuthDecoder_Factory.a());
        this.H = provider4;
        this.I = DoubleCheck.provider(Mqtt5ClientMessageDecoders_Factory.a(this.f18392x, this.f18393y, this.f18394z, this.A, this.B, this.C, this.D, this.E, this.F, this.G, provider4));
        this.J = DoubleCheck.provider(Mqtt3ConnAckDecoder_Factory.a());
        this.K = DoubleCheck.provider(Mqtt3PublishDecoder_Factory.a());
        this.L = DoubleCheck.provider(Mqtt3PubAckDecoder_Factory.a());
        this.M = DoubleCheck.provider(Mqtt3PubRecDecoder_Factory.a());
        this.N = DoubleCheck.provider(Mqtt3PubRelDecoder_Factory.a());
        this.O = DoubleCheck.provider(Mqtt3PubCompDecoder_Factory.a());
        this.P = DoubleCheck.provider(Mqtt3SubAckDecoder_Factory.a());
        Provider<Mqtt3UnsubAckDecoder> provider5 = DoubleCheck.provider(Mqtt3UnsubAckDecoder_Factory.a());
        this.Q = provider5;
        this.R = DoubleCheck.provider(Mqtt3ClientMessageDecoders_Factory.a(this.J, this.K, this.L, this.M, this.N, this.O, this.P, provider5, this.F));
        this.S = DoubleCheck.provider(MqttDisconnectOnAuthHandler_Factory.a());
        this.T = DoubleCheck.provider(MqttWebSocketCodec_Factory.a());
    }

    @Override // com.hivemq.client.internal.mqtt.ioc.SingletonComponent
    public ClientComponent.Builder a() {
        return new ClientComponentBuilder();
    }

    private DaggerSingletonComponent() {
        i();
    }
}
