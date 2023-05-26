package com.hivemq.client.internal.mqtt.message.unsubscribe.unsuback;

import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties;
import com.hivemq.client.internal.util.StringUtil;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;
import com.hivemq.client.mqtt.mqtt5.message.unsubscribe.unsuback.Mqtt5UnsubAck;
import com.hivemq.client.mqtt.mqtt5.message.unsubscribe.unsuback.Mqtt5UnsubAckReasonCode;
import j1.a;

/* loaded from: classes3.dex */
public class MqttUnsubAck extends MqttMessageWithUserProperties.WithReason.WithCodesAndId<Mqtt5UnsubAckReasonCode> implements Mqtt5UnsubAck {
    public MqttUnsubAck(int i8, ImmutableList<Mqtt5UnsubAckReasonCode> immutableList, MqttUtf8StringImpl mqttUtf8StringImpl, MqttUserPropertiesImpl mqttUserPropertiesImpl) {
        super(i8, immutableList, mqttUtf8StringImpl, mqttUserPropertiesImpl);
    }

    @Override // com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties.WithReason.WithCodesAndId, com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties.WithReason, com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties
    protected String e() {
        return "reasonCodes=" + h() + StringUtil.a(", ", super.e());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttUnsubAck)) {
            return false;
        }
        return i((MqttUnsubAck) obj);
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5Message
    public /* synthetic */ Mqtt5MessageType getType() {
        return a.a(this);
    }

    public int hashCode() {
        return d();
    }

    public String toString() {
        return "MqttUnsubAck{" + e() + "}";
    }
}
