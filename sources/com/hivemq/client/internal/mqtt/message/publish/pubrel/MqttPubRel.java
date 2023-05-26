package com.hivemq.client.internal.mqtt.message.publish.pubrel;

import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;
import com.hivemq.client.mqtt.mqtt5.message.publish.pubrel.Mqtt5PubRel;
import com.hivemq.client.mqtt.mqtt5.message.publish.pubrel.Mqtt5PubRelReasonCode;
import f1.a;

/* loaded from: classes3.dex */
public class MqttPubRel extends MqttMessageWithUserProperties.WithReason.WithCode.WithId<Mqtt5PubRelReasonCode> implements Mqtt5PubRel {

    /* renamed from: f  reason: collision with root package name */
    public static final Mqtt5PubRelReasonCode f18595f = Mqtt5PubRelReasonCode.SUCCESS;

    public MqttPubRel(int i8, Mqtt5PubRelReasonCode mqtt5PubRelReasonCode, MqttUtf8StringImpl mqttUtf8StringImpl, MqttUserPropertiesImpl mqttUserPropertiesImpl) {
        super(i8, mqtt5PubRelReasonCode, mqttUtf8StringImpl, mqttUserPropertiesImpl);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttPubRel)) {
            return false;
        }
        return i((MqttPubRel) obj);
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5Message
    public /* synthetic */ Mqtt5MessageType getType() {
        return a.a(this);
    }

    public int hashCode() {
        return d();
    }

    public String toString() {
        return "MqttPubRel{" + e() + "}";
    }
}
