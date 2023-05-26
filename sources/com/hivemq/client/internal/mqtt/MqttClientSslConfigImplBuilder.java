package com.hivemq.client.internal.mqtt;

import com.hivemq.client.internal.mqtt.MqttClientSslConfigImplBuilder;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.mqtt.MqttClientSslConfig;
import com.hivemq.client.mqtt.MqttClientSslConfigBuilder;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;

/* loaded from: classes3.dex */
public abstract class MqttClientSslConfigImplBuilder<B extends MqttClientSslConfigImplBuilder<B>> {

    /* renamed from: a  reason: collision with root package name */
    private KeyManagerFactory f17809a;

    /* renamed from: b  reason: collision with root package name */
    private TrustManagerFactory f17810b;

    /* renamed from: c  reason: collision with root package name */
    private ImmutableList<String> f17811c;

    /* renamed from: d  reason: collision with root package name */
    private ImmutableList<String> f17812d;

    /* renamed from: e  reason: collision with root package name */
    private int f17813e = 10000;

    /* renamed from: f  reason: collision with root package name */
    private HostnameVerifier f17814f = MqttClientSslConfigImpl.f17801g;

    /* loaded from: classes3.dex */
    public static class Default extends MqttClientSslConfigImplBuilder<Default> implements MqttClientSslConfigBuilder {
        @Override // com.hivemq.client.mqtt.MqttClientSslConfigBuilder
        public /* bridge */ /* synthetic */ MqttClientSslConfig build() {
            return super.a();
        }
    }

    MqttClientSslConfigImplBuilder() {
    }

    public MqttClientSslConfigImpl a() {
        return new MqttClientSslConfigImpl(this.f17809a, this.f17810b, this.f17811c, this.f17812d, this.f17813e, this.f17814f);
    }
}
