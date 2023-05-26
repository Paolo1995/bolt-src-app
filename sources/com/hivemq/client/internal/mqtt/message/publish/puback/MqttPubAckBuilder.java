package com.hivemq.client.internal.mqtt.message.publish.puback;

import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.message.publish.MqttStatefulPublish;
import com.hivemq.client.mqtt.mqtt5.message.publish.puback.Mqtt5PubAckReasonCode;

/* loaded from: classes3.dex */
public class MqttPubAckBuilder {

    /* renamed from: a  reason: collision with root package name */
    private final MqttStatefulPublish f18578a;

    /* renamed from: c  reason: collision with root package name */
    private MqttUtf8StringImpl f18580c;

    /* renamed from: b  reason: collision with root package name */
    private Mqtt5PubAckReasonCode f18579b = MqttPubAck.f18577f;

    /* renamed from: d  reason: collision with root package name */
    private MqttUserPropertiesImpl f18581d = MqttUserPropertiesImpl.f17992c;

    public MqttPubAckBuilder(MqttStatefulPublish mqttStatefulPublish) {
        this.f18578a = mqttStatefulPublish;
    }

    public MqttPubAck a() {
        return new MqttPubAck(this.f18578a.a(), this.f18579b, this.f18580c, this.f18581d);
    }
}
