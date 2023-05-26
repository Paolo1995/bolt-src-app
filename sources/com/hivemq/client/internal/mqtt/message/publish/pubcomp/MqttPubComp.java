package com.hivemq.client.internal.mqtt.message.publish.pubcomp;

import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;
import com.hivemq.client.mqtt.mqtt5.message.publish.pubcomp.Mqtt5PubComp;
import com.hivemq.client.mqtt.mqtt5.message.publish.pubcomp.Mqtt5PubCompReasonCode;
import d1.a;

/* loaded from: classes3.dex */
public class MqttPubComp extends MqttMessageWithUserProperties.WithReason.WithCode.WithId<Mqtt5PubCompReasonCode> implements Mqtt5PubComp {

    /* renamed from: f  reason: collision with root package name */
    public static final Mqtt5PubCompReasonCode f18583f = Mqtt5PubCompReasonCode.SUCCESS;

    public MqttPubComp(int i8, Mqtt5PubCompReasonCode mqtt5PubCompReasonCode, MqttUtf8StringImpl mqttUtf8StringImpl, MqttUserPropertiesImpl mqttUserPropertiesImpl) {
        super(i8, mqtt5PubCompReasonCode, mqttUtf8StringImpl, mqttUserPropertiesImpl);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttPubComp)) {
            return false;
        }
        return i((MqttPubComp) obj);
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5Message
    public /* synthetic */ Mqtt5MessageType getType() {
        return a.a(this);
    }

    public int hashCode() {
        return d();
    }

    public String toString() {
        return "MqttPubComp{" + e() + "}";
    }
}
