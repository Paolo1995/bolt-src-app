package com.hivemq.client.mqtt;

import com.hivemq.client.mqtt.MqttClientBuilderBase;
import com.hivemq.client.mqtt.lifecycle.MqttClientConnectedListener;
import com.hivemq.client.mqtt.lifecycle.MqttClientDisconnectedListener;

/* loaded from: classes3.dex */
public interface MqttClientBuilderBase<B extends MqttClientBuilderBase<B>> {
    B b(MqttClientConnectedListener mqttClientConnectedListener);

    B c(String str);

    B d(MqttWebSocketConfig mqttWebSocketConfig);

    B e();

    B f(String str);

    B g(MqttClientSslConfig mqttClientSslConfig);

    B h(int i8);

    B i(MqttClientDisconnectedListener mqttClientDisconnectedListener);
}
