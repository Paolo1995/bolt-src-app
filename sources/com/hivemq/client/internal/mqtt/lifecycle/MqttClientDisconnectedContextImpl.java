package com.hivemq.client.internal.mqtt.lifecycle;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.lifecycle.mqtt3.Mqtt3ClientDisconnectedContextView;
import com.hivemq.client.mqtt.MqttVersion;
import com.hivemq.client.mqtt.lifecycle.MqttClientDisconnectedContext;
import com.hivemq.client.mqtt.lifecycle.MqttDisconnectSource;

/* loaded from: classes3.dex */
public class MqttClientDisconnectedContextImpl implements MqttClientDisconnectedContext {

    /* renamed from: a  reason: collision with root package name */
    private final MqttClientConfig f18424a;

    /* renamed from: b  reason: collision with root package name */
    private final MqttDisconnectSource f18425b;

    /* renamed from: c  reason: collision with root package name */
    private final Throwable f18426c;

    /* renamed from: d  reason: collision with root package name */
    private final MqttClientReconnector f18427d;

    private MqttClientDisconnectedContextImpl(MqttClientConfig mqttClientConfig, MqttDisconnectSource mqttDisconnectSource, Throwable th, MqttClientReconnector mqttClientReconnector) {
        this.f18424a = mqttClientConfig;
        this.f18425b = mqttDisconnectSource;
        this.f18426c = th;
        this.f18427d = mqttClientReconnector;
    }

    public static MqttClientDisconnectedContext f(MqttClientConfig mqttClientConfig, MqttDisconnectSource mqttDisconnectSource, Throwable th, MqttClientReconnector mqttClientReconnector) {
        if (mqttClientConfig.l() == MqttVersion.MQTT_3_1_1) {
            return Mqtt3ClientDisconnectedContextView.f(mqttClientConfig, mqttDisconnectSource, th, mqttClientReconnector);
        }
        return new MqttClientDisconnectedContextImpl(mqttClientConfig, mqttDisconnectSource, th, mqttClientReconnector);
    }

    @Override // com.hivemq.client.mqtt.lifecycle.MqttClientDisconnectedContext
    public Throwable b() {
        return this.f18426c;
    }

    @Override // com.hivemq.client.mqtt.lifecycle.MqttClientDisconnectedContext
    /* renamed from: d */
    public MqttClientConfig a() {
        return this.f18424a;
    }

    @Override // com.hivemq.client.mqtt.lifecycle.MqttClientDisconnectedContext
    /* renamed from: e */
    public MqttClientReconnector c() {
        return this.f18427d;
    }

    @Override // com.hivemq.client.mqtt.lifecycle.MqttClientDisconnectedContext
    public MqttDisconnectSource getSource() {
        return this.f18425b;
    }
}
