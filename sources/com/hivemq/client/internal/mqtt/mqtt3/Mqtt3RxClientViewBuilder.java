package com.hivemq.client.internal.mqtt.mqtt3;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.MqttRxClient;
import com.hivemq.client.internal.mqtt.MqttRxClientBuilderBase;
import com.hivemq.client.internal.mqtt.advanced.MqttClientAdvancedConfig;
import com.hivemq.client.internal.mqtt.message.auth.MqttSimpleAuth;
import com.hivemq.client.internal.mqtt.message.auth.mqtt3.Mqtt3SimpleAuthView;
import com.hivemq.client.internal.util.Checks;
import com.hivemq.client.mqtt.MqttClientBuilderBase;
import com.hivemq.client.mqtt.MqttClientSslConfig;
import com.hivemq.client.mqtt.MqttVersion;
import com.hivemq.client.mqtt.MqttWebSocketConfig;
import com.hivemq.client.mqtt.lifecycle.MqttClientConnectedListener;
import com.hivemq.client.mqtt.lifecycle.MqttClientDisconnectedListener;
import com.hivemq.client.mqtt.mqtt3.Mqtt3ClientBuilder;
import com.hivemq.client.mqtt.mqtt3.message.auth.Mqtt3SimpleAuth;

/* loaded from: classes3.dex */
public class Mqtt3RxClientViewBuilder extends MqttRxClientBuilderBase<Mqtt3RxClientViewBuilder> implements Mqtt3ClientBuilder {

    /* renamed from: n  reason: collision with root package name */
    private MqttSimpleAuth f18632n;

    private MqttClientConfig G() {
        return w(MqttVersion.MQTT_3_1_1, MqttClientAdvancedConfig.f17848c, MqttClientConfig.ConnectDefaults.d(this.f18632n, null, null));
    }

    private MqttRxClient I() {
        return new MqttRxClient(G());
    }

    @Override // com.hivemq.client.mqtt.mqtt3.Mqtt3ClientBuilder
    /* renamed from: H */
    public Mqtt3RxClientView j() {
        return new Mqtt3RxClientView(I());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hivemq.client.internal.mqtt.MqttRxClientBuilderBase
    /* renamed from: J */
    public Mqtt3RxClientViewBuilder A() {
        return this;
    }

    @Override // com.hivemq.client.mqtt.mqtt3.Mqtt3ClientBuilder
    /* renamed from: K */
    public Mqtt3RxClientViewBuilder a(Mqtt3SimpleAuth mqtt3SimpleAuth) {
        MqttSimpleAuth b8;
        if (mqtt3SimpleAuth == null) {
            b8 = null;
        } else {
            b8 = ((Mqtt3SimpleAuthView) Checks.g(mqtt3SimpleAuth, Mqtt3SimpleAuthView.class, "Simple auth")).b();
        }
        this.f18632n = b8;
        return this;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.hivemq.client.mqtt.mqtt3.Mqtt3ClientBuilder, com.hivemq.client.mqtt.MqttClientBuilderBase] */
    @Override // com.hivemq.client.mqtt.MqttClientBuilderBase
    public /* bridge */ /* synthetic */ Mqtt3ClientBuilder b(MqttClientConnectedListener mqttClientConnectedListener) {
        return (MqttClientBuilderBase) super.u(mqttClientConnectedListener);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.hivemq.client.mqtt.mqtt3.Mqtt3ClientBuilder, com.hivemq.client.mqtt.MqttClientBuilderBase] */
    @Override // com.hivemq.client.mqtt.MqttClientBuilderBase
    public /* bridge */ /* synthetic */ Mqtt3ClientBuilder c(String str) {
        return (MqttClientBuilderBase) super.B(str);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.hivemq.client.mqtt.mqtt3.Mqtt3ClientBuilder, com.hivemq.client.mqtt.MqttClientBuilderBase] */
    @Override // com.hivemq.client.mqtt.MqttClientBuilderBase
    public /* bridge */ /* synthetic */ Mqtt3ClientBuilder d(MqttWebSocketConfig mqttWebSocketConfig) {
        return (MqttClientBuilderBase) super.F(mqttWebSocketConfig);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.hivemq.client.mqtt.mqtt3.Mqtt3ClientBuilder, com.hivemq.client.mqtt.MqttClientBuilderBase] */
    @Override // com.hivemq.client.mqtt.MqttClientBuilderBase
    public /* bridge */ /* synthetic */ Mqtt3ClientBuilder e() {
        return (MqttClientBuilderBase) super.E();
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.hivemq.client.mqtt.mqtt3.Mqtt3ClientBuilder, com.hivemq.client.mqtt.MqttClientBuilderBase] */
    @Override // com.hivemq.client.mqtt.MqttClientBuilderBase
    public /* bridge */ /* synthetic */ Mqtt3ClientBuilder f(String str) {
        return (MqttClientBuilderBase) super.z(str);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.hivemq.client.mqtt.mqtt3.Mqtt3ClientBuilder, com.hivemq.client.mqtt.MqttClientBuilderBase] */
    @Override // com.hivemq.client.mqtt.MqttClientBuilderBase
    public /* bridge */ /* synthetic */ Mqtt3ClientBuilder g(MqttClientSslConfig mqttClientSslConfig) {
        return (MqttClientBuilderBase) super.D(mqttClientSslConfig);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.hivemq.client.mqtt.mqtt3.Mqtt3ClientBuilder, com.hivemq.client.mqtt.MqttClientBuilderBase] */
    @Override // com.hivemq.client.mqtt.MqttClientBuilderBase
    public /* bridge */ /* synthetic */ Mqtt3ClientBuilder h(int i8) {
        return (MqttClientBuilderBase) super.C(i8);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.hivemq.client.mqtt.mqtt3.Mqtt3ClientBuilder, com.hivemq.client.mqtt.MqttClientBuilderBase] */
    @Override // com.hivemq.client.mqtt.MqttClientBuilderBase
    public /* bridge */ /* synthetic */ Mqtt3ClientBuilder i(MqttClientDisconnectedListener mqttClientDisconnectedListener) {
        return (MqttClientBuilderBase) super.v(mqttClientDisconnectedListener);
    }
}
