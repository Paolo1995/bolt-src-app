package com.hivemq.client.internal.mqtt.message.publish.pubrec;

import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.message.publish.MqttStatefulPublish;
import com.hivemq.client.mqtt.mqtt5.message.publish.pubrec.Mqtt5PubRecReasonCode;

/* loaded from: classes3.dex */
public class MqttPubRecBuilder {

    /* renamed from: a  reason: collision with root package name */
    private final MqttStatefulPublish f18590a;

    /* renamed from: c  reason: collision with root package name */
    private MqttUtf8StringImpl f18592c;

    /* renamed from: b  reason: collision with root package name */
    private Mqtt5PubRecReasonCode f18591b = MqttPubRec.f18589f;

    /* renamed from: d  reason: collision with root package name */
    private MqttUserPropertiesImpl f18593d = MqttUserPropertiesImpl.f17992c;

    public MqttPubRecBuilder(MqttStatefulPublish mqttStatefulPublish) {
        this.f18590a = mqttStatefulPublish;
    }

    public MqttPubRec a() {
        return new MqttPubRec(this.f18590a.a(), this.f18591b, this.f18592c, this.f18593d);
    }
}
