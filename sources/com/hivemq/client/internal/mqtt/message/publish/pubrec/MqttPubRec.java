package com.hivemq.client.internal.mqtt.message.publish.pubrec;

import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;
import com.hivemq.client.mqtt.mqtt5.message.publish.pubrec.Mqtt5PubRec;
import com.hivemq.client.mqtt.mqtt5.message.publish.pubrec.Mqtt5PubRecReasonCode;
import e1.a;

/* loaded from: classes3.dex */
public class MqttPubRec extends MqttMessageWithUserProperties.WithReason.WithCode.WithId<Mqtt5PubRecReasonCode> implements Mqtt5PubRec {

    /* renamed from: f  reason: collision with root package name */
    public static final Mqtt5PubRecReasonCode f18589f = Mqtt5PubRecReasonCode.SUCCESS;

    public MqttPubRec(int i8, Mqtt5PubRecReasonCode mqtt5PubRecReasonCode, MqttUtf8StringImpl mqttUtf8StringImpl, MqttUserPropertiesImpl mqttUserPropertiesImpl) {
        super(i8, mqtt5PubRecReasonCode, mqttUtf8StringImpl, mqttUserPropertiesImpl);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttPubRec)) {
            return false;
        }
        return i((MqttPubRec) obj);
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5Message
    public /* synthetic */ Mqtt5MessageType getType() {
        return a.a(this);
    }

    public int hashCode() {
        return d();
    }

    public String toString() {
        return "MqttPubRec{" + e() + "}";
    }
}
