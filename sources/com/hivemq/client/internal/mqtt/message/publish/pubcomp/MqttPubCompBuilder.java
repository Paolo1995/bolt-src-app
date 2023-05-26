package com.hivemq.client.internal.mqtt.message.publish.pubcomp;

import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.message.publish.pubrel.MqttPubRel;
import com.hivemq.client.mqtt.mqtt5.message.publish.pubcomp.Mqtt5PubCompReasonCode;

/* loaded from: classes3.dex */
public class MqttPubCompBuilder {

    /* renamed from: a  reason: collision with root package name */
    private final MqttPubRel f18584a;

    /* renamed from: c  reason: collision with root package name */
    private MqttUtf8StringImpl f18586c;

    /* renamed from: b  reason: collision with root package name */
    private Mqtt5PubCompReasonCode f18585b = MqttPubComp.f18583f;

    /* renamed from: d  reason: collision with root package name */
    private MqttUserPropertiesImpl f18587d = MqttUserPropertiesImpl.f17992c;

    public MqttPubCompBuilder(MqttPubRel mqttPubRel) {
        this.f18584a = mqttPubRel;
    }

    public MqttPubComp a() {
        return new MqttPubComp(this.f18584a.a(), this.f18585b, this.f18586c, this.f18587d);
    }

    public MqttPubCompBuilder b(Mqtt5PubCompReasonCode mqtt5PubCompReasonCode) {
        this.f18585b = mqtt5PubCompReasonCode;
        return this;
    }
}
