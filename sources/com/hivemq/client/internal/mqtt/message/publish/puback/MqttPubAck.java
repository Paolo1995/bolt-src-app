package com.hivemq.client.internal.mqtt.message.publish.puback;

import c1.a;
import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;
import com.hivemq.client.mqtt.mqtt5.message.publish.puback.Mqtt5PubAck;
import com.hivemq.client.mqtt.mqtt5.message.publish.puback.Mqtt5PubAckReasonCode;

/* loaded from: classes3.dex */
public class MqttPubAck extends MqttMessageWithUserProperties.WithReason.WithCode.WithId<Mqtt5PubAckReasonCode> implements Mqtt5PubAck {

    /* renamed from: f  reason: collision with root package name */
    public static final Mqtt5PubAckReasonCode f18577f = Mqtt5PubAckReasonCode.SUCCESS;

    public MqttPubAck(int i8, Mqtt5PubAckReasonCode mqtt5PubAckReasonCode, MqttUtf8StringImpl mqttUtf8StringImpl, MqttUserPropertiesImpl mqttUserPropertiesImpl) {
        super(i8, mqtt5PubAckReasonCode, mqttUtf8StringImpl, mqttUserPropertiesImpl);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttPubAck)) {
            return false;
        }
        return i((MqttPubAck) obj);
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5Message
    public /* synthetic */ Mqtt5MessageType getType() {
        return a.a(this);
    }

    public int hashCode() {
        return d();
    }

    public String toString() {
        return "MqttPubAck{" + e() + "}";
    }
}
