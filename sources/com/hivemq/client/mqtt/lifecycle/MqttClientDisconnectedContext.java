package com.hivemq.client.mqtt.lifecycle;

import com.hivemq.client.mqtt.MqttClientConfig;

/* loaded from: classes3.dex */
public interface MqttClientDisconnectedContext {
    MqttClientConfig a();

    Throwable b();

    MqttClientReconnector c();

    MqttDisconnectSource getSource();
}
