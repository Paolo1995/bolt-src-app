package com.hivemq.client.internal.mqtt.mqtt3;

import com.hivemq.client.mqtt.MqttClientConfig;
import com.hivemq.client.mqtt.MqttClientState;

/* loaded from: classes3.dex */
public class Mqtt3ClientConfigView implements MqttClientConfig {

    /* renamed from: a  reason: collision with root package name */
    private final com.hivemq.client.internal.mqtt.MqttClientConfig f18622a;

    public Mqtt3ClientConfigView(com.hivemq.client.internal.mqtt.MqttClientConfig mqttClientConfig) {
        this.f18622a = mqttClientConfig;
    }

    @Override // com.hivemq.client.mqtt.MqttClientConfig
    public MqttClientState getState() {
        return this.f18622a.getState();
    }
}
