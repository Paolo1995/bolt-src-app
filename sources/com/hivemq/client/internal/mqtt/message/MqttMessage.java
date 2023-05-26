package com.hivemq.client.internal.mqtt.message;

import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5Message;

/* loaded from: classes3.dex */
public interface MqttMessage extends Mqtt5Message {

    /* loaded from: classes3.dex */
    public interface WithId extends MqttMessage {
        int a();
    }

    /* loaded from: classes3.dex */
    public interface WithUserProperties extends MqttMessage {
        MqttUserPropertiesImpl b();
    }
}
