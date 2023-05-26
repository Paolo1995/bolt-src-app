package com.hivemq.client.internal.mqtt.message.ping;

import a1.a;
import com.hivemq.client.internal.mqtt.message.MqttMessage;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;
import com.hivemq.client.mqtt.mqtt5.message.ping.Mqtt5PingReq;

/* loaded from: classes3.dex */
public class MqttPingReq implements MqttMessage, Mqtt5PingReq {

    /* renamed from: b  reason: collision with root package name */
    public static final MqttPingReq f18547b = new MqttPingReq();

    private MqttPingReq() {
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5Message
    public /* synthetic */ Mqtt5MessageType getType() {
        return a.a(this);
    }

    public int hashCode() {
        return Mqtt5MessageType.PINGREQ.ordinal();
    }

    public String toString() {
        return "MqttPingReq{}";
    }
}
