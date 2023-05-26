package com.hivemq.client.mqtt.mqtt3.lifecycle;

import com.hivemq.client.mqtt.lifecycle.MqttClientReconnector;
import com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3ConnectBuilder;

/* loaded from: classes3.dex */
public interface Mqtt3ClientReconnector extends MqttClientReconnector {
    Mqtt3ConnectBuilder.Nested<? extends Mqtt3ClientReconnector> a();
}
