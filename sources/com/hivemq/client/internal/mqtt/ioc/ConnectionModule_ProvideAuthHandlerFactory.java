package com.hivemq.client.internal.mqtt.ioc;

import com.hivemq.client.internal.mqtt.handler.auth.MqttAuthHandler;
import com.hivemq.client.internal.mqtt.handler.auth.MqttConnectAuthHandler;
import com.hivemq.client.internal.mqtt.handler.auth.MqttDisconnectOnAuthHandler;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnect;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ConnectionModule_ProvideAuthHandlerFactory implements Factory<MqttAuthHandler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MqttConnect> f18367a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MqttConnectAuthHandler> f18368b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<MqttDisconnectOnAuthHandler> f18369c;

    public ConnectionModule_ProvideAuthHandlerFactory(Provider<MqttConnect> provider, Provider<MqttConnectAuthHandler> provider2, Provider<MqttDisconnectOnAuthHandler> provider3) {
        this.f18367a = provider;
        this.f18368b = provider2;
        this.f18369c = provider3;
    }

    public static ConnectionModule_ProvideAuthHandlerFactory a(Provider<MqttConnect> provider, Provider<MqttConnectAuthHandler> provider2, Provider<MqttDisconnectOnAuthHandler> provider3) {
        return new ConnectionModule_ProvideAuthHandlerFactory(provider, provider2, provider3);
    }

    public static MqttAuthHandler c(MqttConnect mqttConnect, Lazy<MqttConnectAuthHandler> lazy, Lazy<MqttDisconnectOnAuthHandler> lazy2) {
        return (MqttAuthHandler) Preconditions.checkNotNull(ConnectionModule.a(mqttConnect, lazy, lazy2), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MqttAuthHandler get() {
        return c(this.f18367a.get(), DoubleCheck.lazy(this.f18368b), DoubleCheck.lazy(this.f18369c));
    }
}
