package com.hivemq.client.internal.mqtt.message.publish.pubcomp.mqtt3;

import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.message.publish.pubcomp.MqttPubComp;
import com.hivemq.client.mqtt.mqtt3.message.Mqtt3MessageType;
import com.hivemq.client.mqtt.mqtt5.message.publish.pubcomp.Mqtt5PubCompReasonCode;

/* loaded from: classes3.dex */
public class Mqtt3PubCompView {

    /* renamed from: a  reason: collision with root package name */
    public static final Mqtt3PubCompView f18588a = new Mqtt3PubCompView();

    private Mqtt3PubCompView() {
    }

    public static MqttPubComp a(int i8) {
        return new MqttPubComp(i8, Mqtt5PubCompReasonCode.SUCCESS, null, MqttUserPropertiesImpl.f17992c);
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public int hashCode() {
        return Mqtt3MessageType.PUBCOMP.ordinal();
    }

    public String toString() {
        return "MqttPubComp{}";
    }
}
