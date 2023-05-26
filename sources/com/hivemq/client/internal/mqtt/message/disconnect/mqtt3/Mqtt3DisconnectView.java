package com.hivemq.client.internal.mqtt.message.disconnect.mqtt3;

import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.message.disconnect.MqttDisconnect;
import com.hivemq.client.mqtt.mqtt3.message.Mqtt3MessageType;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5DisconnectReasonCode;

/* loaded from: classes3.dex */
public class Mqtt3DisconnectView {

    /* renamed from: a  reason: collision with root package name */
    public static final MqttDisconnect f18545a = new MqttDisconnect(Mqtt5DisconnectReasonCode.NORMAL_DISCONNECTION, -1, null, null, MqttUserPropertiesImpl.f17992c);

    /* renamed from: b  reason: collision with root package name */
    public static final Mqtt3DisconnectView f18546b = new Mqtt3DisconnectView();

    private Mqtt3DisconnectView() {
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public int hashCode() {
        return Mqtt3MessageType.DISCONNECT.ordinal();
    }

    public String toString() {
        return "MqttDisconnect{}";
    }
}
