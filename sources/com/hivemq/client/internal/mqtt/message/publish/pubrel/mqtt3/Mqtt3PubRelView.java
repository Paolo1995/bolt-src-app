package com.hivemq.client.internal.mqtt.message.publish.pubrel.mqtt3;

import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.message.publish.pubrel.MqttPubRel;
import com.hivemq.client.mqtt.mqtt3.message.Mqtt3MessageType;
import com.hivemq.client.mqtt.mqtt5.message.publish.pubrel.Mqtt5PubRelReasonCode;

/* loaded from: classes3.dex */
public class Mqtt3PubRelView {

    /* renamed from: a  reason: collision with root package name */
    public static final Mqtt3PubRelView f18600a = new Mqtt3PubRelView();

    private Mqtt3PubRelView() {
    }

    public static MqttPubRel a(int i8) {
        return new MqttPubRel(i8, Mqtt5PubRelReasonCode.SUCCESS, null, MqttUserPropertiesImpl.f17992c);
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public int hashCode() {
        return Mqtt3MessageType.PUBREL.ordinal();
    }

    public String toString() {
        return "MqttPubRel{}";
    }
}
