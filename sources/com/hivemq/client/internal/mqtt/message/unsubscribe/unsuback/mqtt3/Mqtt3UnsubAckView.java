package com.hivemq.client.internal.mqtt.message.unsubscribe.unsuback.mqtt3;

import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.message.unsubscribe.unsuback.MqttUnsubAck;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.internal.util.collections.b;
import com.hivemq.client.mqtt.mqtt3.message.Mqtt3MessageType;
import com.hivemq.client.mqtt.mqtt5.message.unsubscribe.unsuback.Mqtt5UnsubAckReasonCode;

/* loaded from: classes3.dex */
public class Mqtt3UnsubAckView {

    /* renamed from: a  reason: collision with root package name */
    public static final ImmutableList<Mqtt5UnsubAckReasonCode> f18620a = b.z();

    /* renamed from: b  reason: collision with root package name */
    public static final Mqtt3UnsubAckView f18621b = new Mqtt3UnsubAckView();

    private Mqtt3UnsubAckView() {
    }

    public static MqttUnsubAck a(int i8) {
        return new MqttUnsubAck(i8, f18620a, null, MqttUserPropertiesImpl.f17992c);
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public int hashCode() {
        return Mqtt3MessageType.UNSUBACK.ordinal();
    }

    public String toString() {
        return "MqttUnsubAck{}";
    }
}
