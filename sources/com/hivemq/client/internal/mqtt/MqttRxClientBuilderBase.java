package com.hivemq.client.internal.mqtt;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.MqttRxClientBuilderBase;
import com.hivemq.client.internal.mqtt.advanced.MqttClientAdvancedConfig;
import com.hivemq.client.internal.mqtt.datatypes.MqttClientIdentifierImpl;
import com.hivemq.client.internal.util.Checks;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.mqtt.MqttClientSslConfig;
import com.hivemq.client.mqtt.MqttVersion;
import com.hivemq.client.mqtt.MqttWebSocketConfig;
import com.hivemq.client.mqtt.lifecycle.MqttClientConnectedListener;
import com.hivemq.client.mqtt.lifecycle.MqttClientDisconnectedListener;

/* loaded from: classes3.dex */
public abstract class MqttRxClientBuilderBase<B extends MqttRxClientBuilderBase<B>> extends MqttClientTransportConfigImplBuilder<B> {

    /* renamed from: i  reason: collision with root package name */
    private MqttClientIdentifierImpl f17832i = MqttClientIdentifierImpl.f17982j;

    /* renamed from: j  reason: collision with root package name */
    private MqttClientTransportConfigImpl f17833j = MqttClientTransportConfigImpl.f17815g;

    /* renamed from: k  reason: collision with root package name */
    private MqttClientExecutorConfigImpl f17834k = MqttClientExecutorConfigImpl.f17797e;

    /* renamed from: l  reason: collision with root package name */
    private ImmutableList.Builder<MqttClientConnectedListener> f17835l;

    /* renamed from: m  reason: collision with root package name */
    private ImmutableList.Builder<MqttClientDisconnectedListener> f17836m;

    private ImmutableList<MqttClientConnectedListener> x() {
        ImmutableList.Builder<MqttClientConnectedListener> builder = this.f17835l;
        if (builder == null) {
            return com.hivemq.client.internal.util.collections.b.z();
        }
        return builder.b();
    }

    private ImmutableList<MqttClientDisconnectedListener> y() {
        ImmutableList.Builder<MqttClientDisconnectedListener> builder = this.f17836m;
        if (builder == null) {
            return com.hivemq.client.internal.util.collections.b.z();
        }
        return builder.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hivemq.client.internal.mqtt.MqttClientTransportConfigImplBuilder
    /* renamed from: A */
    public abstract B n();

    public B B(String str) {
        this.f17833j = null;
        return (B) super.o(str);
    }

    public B C(int i8) {
        this.f17833j = null;
        return (B) super.p(i8);
    }

    public B D(MqttClientSslConfig mqttClientSslConfig) {
        return (B) super.r(mqttClientSslConfig);
    }

    public B E() {
        this.f17833j = null;
        return (B) super.s();
    }

    public B F(MqttWebSocketConfig mqttWebSocketConfig) {
        this.f17833j = null;
        return (B) super.t(mqttWebSocketConfig);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.MqttClientTransportConfigImplBuilder
    public MqttClientTransportConfigImpl k() {
        MqttClientTransportConfigImpl mqttClientTransportConfigImpl = this.f17833j;
        if (mqttClientTransportConfigImpl == null) {
            return super.k();
        }
        return mqttClientTransportConfigImpl;
    }

    public B u(MqttClientConnectedListener mqttClientConnectedListener) {
        Checks.j(mqttClientConnectedListener, "Connected listener");
        if (this.f17835l == null) {
            this.f17835l = com.hivemq.client.internal.util.collections.b.v();
        }
        this.f17835l.a(mqttClientConnectedListener);
        return n();
    }

    public B v(MqttClientDisconnectedListener mqttClientDisconnectedListener) {
        Checks.j(mqttClientDisconnectedListener, "Disconnected listener");
        if (this.f17836m == null) {
            this.f17836m = com.hivemq.client.internal.util.collections.b.v();
        }
        this.f17836m.a(mqttClientDisconnectedListener);
        return n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MqttClientConfig w(MqttVersion mqttVersion, MqttClientAdvancedConfig mqttClientAdvancedConfig, MqttClientConfig.ConnectDefaults connectDefaults) {
        return new MqttClientConfig(mqttVersion, this.f17832i, k(), this.f17834k, mqttClientAdvancedConfig, connectDefaults, x(), y());
    }

    public B z(String str) {
        this.f17832i = MqttClientIdentifierImpl.r(str);
        return n();
    }
}
