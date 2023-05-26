package com.hivemq.client.internal.mqtt.message.ping;

import a1.b;
import com.hivemq.client.internal.mqtt.message.MqttMessage;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;
import com.hivemq.client.mqtt.mqtt5.message.ping.Mqtt5PingResp;

/* loaded from: classes3.dex */
public class MqttPingResp implements MqttMessage, Mqtt5PingResp {

    /* renamed from: b  reason: collision with root package name */
    public static final MqttPingResp f18548b = new MqttPingResp();

    private MqttPingResp() {
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5Message
    public /* synthetic */ Mqtt5MessageType getType() {
        return b.a(this);
    }

    public int hashCode() {
        return Mqtt5MessageType.PINGRESP.ordinal();
    }

    public String toString() {
        return "MqttPingResp{}";
    }
}
