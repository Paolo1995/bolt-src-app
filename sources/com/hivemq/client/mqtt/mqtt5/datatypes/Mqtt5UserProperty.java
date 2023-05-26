package com.hivemq.client.mqtt.mqtt5.datatypes;

import com.hivemq.client.mqtt.datatypes.MqttUtf8String;

/* loaded from: classes3.dex */
public interface Mqtt5UserProperty extends Comparable<Mqtt5UserProperty> {
    MqttUtf8String getName();

    MqttUtf8String getValue();
}
