package com.hivemq.client.internal.mqtt.message.subscribe.suback;

import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties;
import com.hivemq.client.internal.util.StringUtil;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;
import com.hivemq.client.mqtt.mqtt5.message.subscribe.suback.Mqtt5SubAck;
import com.hivemq.client.mqtt.mqtt5.message.subscribe.suback.Mqtt5SubAckReasonCode;
import h1.a;

/* loaded from: classes3.dex */
public class MqttSubAck extends MqttMessageWithUserProperties.WithReason.WithCodesAndId<Mqtt5SubAckReasonCode> implements Mqtt5SubAck {
    public MqttSubAck(int i8, ImmutableList<Mqtt5SubAckReasonCode> immutableList, MqttUtf8StringImpl mqttUtf8StringImpl, MqttUserPropertiesImpl mqttUserPropertiesImpl) {
        super(i8, immutableList, mqttUtf8StringImpl, mqttUserPropertiesImpl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties.WithReason.WithCodesAndId, com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties.WithReason, com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties
    public String e() {
        return "reasonCodes=" + h() + StringUtil.a(", ", super.e());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttSubAck)) {
            return false;
        }
        return i((MqttSubAck) obj);
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5Message
    public /* synthetic */ Mqtt5MessageType getType() {
        return a.a(this);
    }

    public int hashCode() {
        return d();
    }

    public String toString() {
        return "MqttSubAck{" + e() + "}";
    }
}
