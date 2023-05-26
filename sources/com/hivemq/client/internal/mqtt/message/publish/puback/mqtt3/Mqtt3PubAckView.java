package com.hivemq.client.internal.mqtt.message.publish.puback.mqtt3;

import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.message.publish.puback.MqttPubAck;
import com.hivemq.client.mqtt.mqtt3.message.Mqtt3MessageType;
import com.hivemq.client.mqtt.mqtt5.message.publish.puback.Mqtt5PubAckReasonCode;

/* loaded from: classes3.dex */
public class Mqtt3PubAckView {

    /* renamed from: a  reason: collision with root package name */
    public static final Mqtt3PubAckView f18582a = new Mqtt3PubAckView();

    private Mqtt3PubAckView() {
    }

    public static MqttPubAck a(int i8) {
        return new MqttPubAck(i8, Mqtt5PubAckReasonCode.SUCCESS, null, MqttUserPropertiesImpl.f17992c);
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public int hashCode() {
        return Mqtt3MessageType.PUBACK.ordinal();
    }

    public String toString() {
        return "MqttPubAck{}";
    }
}
