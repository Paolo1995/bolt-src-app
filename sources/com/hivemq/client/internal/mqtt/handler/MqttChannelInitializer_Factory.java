package com.hivemq.client.internal.mqtt.handler;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.codec.encoder.MqttEncoder;
import com.hivemq.client.internal.mqtt.handler.auth.MqttAuthHandler;
import com.hivemq.client.internal.mqtt.handler.connect.MqttConnAckFlow;
import com.hivemq.client.internal.mqtt.handler.connect.MqttConnectHandler;
import com.hivemq.client.internal.mqtt.handler.disconnect.MqttDisconnectHandler;
import com.hivemq.client.internal.mqtt.handler.websocket.MqttWebSocketInitializer;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnect;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MqttChannelInitializer_Factory implements Factory<MqttChannelInitializer> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MqttClientConfig> f18012a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MqttConnect> f18013b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<MqttConnAckFlow> f18014c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<MqttEncoder> f18015d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<MqttConnectHandler> f18016e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<MqttDisconnectHandler> f18017f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<MqttAuthHandler> f18018g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<MqttWebSocketInitializer> f18019h;

    public MqttChannelInitializer_Factory(Provider<MqttClientConfig> provider, Provider<MqttConnect> provider2, Provider<MqttConnAckFlow> provider3, Provider<MqttEncoder> provider4, Provider<MqttConnectHandler> provider5, Provider<MqttDisconnectHandler> provider6, Provider<MqttAuthHandler> provider7, Provider<MqttWebSocketInitializer> provider8) {
        this.f18012a = provider;
        this.f18013b = provider2;
        this.f18014c = provider3;
        this.f18015d = provider4;
        this.f18016e = provider5;
        this.f18017f = provider6;
        this.f18018g = provider7;
        this.f18019h = provider8;
    }

    public static MqttChannelInitializer_Factory a(Provider<MqttClientConfig> provider, Provider<MqttConnect> provider2, Provider<MqttConnAckFlow> provider3, Provider<MqttEncoder> provider4, Provider<MqttConnectHandler> provider5, Provider<MqttDisconnectHandler> provider6, Provider<MqttAuthHandler> provider7, Provider<MqttWebSocketInitializer> provider8) {
        return new MqttChannelInitializer_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static MqttChannelInitializer c(MqttClientConfig mqttClientConfig, MqttConnect mqttConnect, MqttConnAckFlow mqttConnAckFlow, MqttEncoder mqttEncoder, MqttConnectHandler mqttConnectHandler, MqttDisconnectHandler mqttDisconnectHandler, MqttAuthHandler mqttAuthHandler, Lazy<MqttWebSocketInitializer> lazy) {
        return new MqttChannelInitializer(mqttClientConfig, mqttConnect, mqttConnAckFlow, mqttEncoder, mqttConnectHandler, mqttDisconnectHandler, mqttAuthHandler, lazy);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MqttChannelInitializer get() {
        return c(this.f18012a.get(), this.f18013b.get(), this.f18014c.get(), this.f18015d.get(), this.f18016e.get(), this.f18017f.get(), this.f18018g.get(), DoubleCheck.lazy(this.f18019h));
    }
}
