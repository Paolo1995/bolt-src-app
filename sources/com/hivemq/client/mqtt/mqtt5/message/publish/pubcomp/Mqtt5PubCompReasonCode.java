package com.hivemq.client.mqtt.mqtt5.message.publish.pubcomp;

import com.hivemq.client.internal.mqtt.message.MqttCommonReasonCode;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5ReasonCode;
import v0.a;

/* loaded from: classes3.dex */
public enum Mqtt5PubCompReasonCode implements Mqtt5ReasonCode {
    SUCCESS(MqttCommonReasonCode.SUCCESS),
    PACKET_IDENTIFIER_NOT_FOUND(MqttCommonReasonCode.PACKET_IDENTIFIER_NOT_FOUND);
    

    /* renamed from: f  reason: collision with root package name */
    private final int f18886f;

    Mqtt5PubCompReasonCode(int i8) {
        this.f18886f = i8;
    }

    public static Mqtt5PubCompReasonCode c(int i8) {
        Mqtt5PubCompReasonCode mqtt5PubCompReasonCode = SUCCESS;
        if (i8 == mqtt5PubCompReasonCode.f18886f) {
            return mqtt5PubCompReasonCode;
        }
        Mqtt5PubCompReasonCode mqtt5PubCompReasonCode2 = PACKET_IDENTIFIER_NOT_FOUND;
        if (i8 == mqtt5PubCompReasonCode2.f18886f) {
            return mqtt5PubCompReasonCode2;
        }
        return null;
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5ReasonCode
    public /* synthetic */ boolean a() {
        return a.a(this);
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5ReasonCode
    public int getCode() {
        return this.f18886f;
    }

    Mqtt5PubCompReasonCode(MqttCommonReasonCode mqttCommonReasonCode) {
        this(mqttCommonReasonCode.getCode());
    }
}
