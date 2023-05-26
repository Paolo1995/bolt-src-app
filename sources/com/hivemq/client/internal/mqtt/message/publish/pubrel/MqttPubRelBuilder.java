package com.hivemq.client.internal.mqtt.message.publish.pubrel;

import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.message.publish.pubrec.MqttPubRec;
import com.hivemq.client.mqtt.mqtt5.message.publish.pubrel.Mqtt5PubRelReasonCode;

/* loaded from: classes3.dex */
public class MqttPubRelBuilder {

    /* renamed from: a  reason: collision with root package name */
    private final int f18596a;

    /* renamed from: c  reason: collision with root package name */
    private MqttUtf8StringImpl f18598c;

    /* renamed from: b  reason: collision with root package name */
    private Mqtt5PubRelReasonCode f18597b = MqttPubRel.f18595f;

    /* renamed from: d  reason: collision with root package name */
    private MqttUserPropertiesImpl f18599d = MqttUserPropertiesImpl.f17992c;

    public MqttPubRelBuilder(MqttPubRec mqttPubRec) {
        this.f18596a = mqttPubRec.a();
    }

    public MqttPubRel a() {
        return new MqttPubRel(this.f18596a, this.f18597b, this.f18598c, this.f18599d);
    }
}
