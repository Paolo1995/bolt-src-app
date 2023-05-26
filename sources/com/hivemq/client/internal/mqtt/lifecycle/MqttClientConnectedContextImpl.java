package com.hivemq.client.internal.mqtt.lifecycle;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.lifecycle.mqtt3.Mqtt3ClientConnectedContextView;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnect;
import com.hivemq.client.internal.mqtt.message.connect.connack.MqttConnAck;
import com.hivemq.client.mqtt.MqttVersion;
import com.hivemq.client.mqtt.lifecycle.MqttClientConnectedContext;

/* loaded from: classes3.dex */
public class MqttClientConnectedContextImpl implements MqttClientConnectedContext {

    /* renamed from: a  reason: collision with root package name */
    private final MqttClientConfig f18421a;

    /* renamed from: b  reason: collision with root package name */
    private final MqttConnect f18422b;

    /* renamed from: c  reason: collision with root package name */
    private final MqttConnAck f18423c;

    private MqttClientConnectedContextImpl(MqttClientConfig mqttClientConfig, MqttConnect mqttConnect, MqttConnAck mqttConnAck) {
        this.f18421a = mqttClientConfig;
        this.f18422b = mqttConnect;
        this.f18423c = mqttConnAck;
    }

    public static MqttClientConnectedContext c(MqttClientConfig mqttClientConfig, MqttConnect mqttConnect, MqttConnAck mqttConnAck) {
        if (mqttClientConfig.l() == MqttVersion.MQTT_3_1_1) {
            return Mqtt3ClientConnectedContextView.c(mqttClientConfig, mqttConnect, mqttConnAck);
        }
        return new MqttClientConnectedContextImpl(mqttClientConfig, mqttConnect, mqttConnAck);
    }

    @Override // com.hivemq.client.mqtt.lifecycle.MqttClientConnectedContext
    /* renamed from: b */
    public MqttClientConfig a() {
        return this.f18421a;
    }
}
