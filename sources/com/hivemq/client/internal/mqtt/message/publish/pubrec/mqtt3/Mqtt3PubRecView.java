package com.hivemq.client.internal.mqtt.message.publish.pubrec.mqtt3;

import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.message.publish.pubrec.MqttPubRec;
import com.hivemq.client.mqtt.mqtt3.message.Mqtt3MessageType;
import com.hivemq.client.mqtt.mqtt5.message.publish.pubrec.Mqtt5PubRecReasonCode;

/* loaded from: classes3.dex */
public class Mqtt3PubRecView {

    /* renamed from: a  reason: collision with root package name */
    public static final Mqtt3PubRecView f18594a = new Mqtt3PubRecView();

    private Mqtt3PubRecView() {
    }

    public static MqttPubRec a(int i8) {
        return new MqttPubRec(i8, Mqtt5PubRecReasonCode.SUCCESS, null, MqttUserPropertiesImpl.f17992c);
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public int hashCode() {
        return Mqtt3MessageType.PUBREC.ordinal();
    }

    public String toString() {
        return "MqttPubRec{}";
    }
}
