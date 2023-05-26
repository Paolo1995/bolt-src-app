package com.hivemq.client.mqtt.mqtt5.message.publish.pubrel;

import com.hivemq.client.internal.mqtt.message.MqttCommonReasonCode;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5ReasonCode;
import v0.a;

/* loaded from: classes3.dex */
public enum Mqtt5PubRelReasonCode implements Mqtt5ReasonCode {
    SUCCESS(MqttCommonReasonCode.SUCCESS),
    PACKET_IDENTIFIER_NOT_FOUND(MqttCommonReasonCode.PACKET_IDENTIFIER_NOT_FOUND);
    

    /* renamed from: f  reason: collision with root package name */
    private final int f18903f;

    Mqtt5PubRelReasonCode(int i8) {
        this.f18903f = i8;
    }

    public static Mqtt5PubRelReasonCode c(int i8) {
        Mqtt5PubRelReasonCode mqtt5PubRelReasonCode = SUCCESS;
        if (i8 == mqtt5PubRelReasonCode.f18903f) {
            return mqtt5PubRelReasonCode;
        }
        Mqtt5PubRelReasonCode mqtt5PubRelReasonCode2 = PACKET_IDENTIFIER_NOT_FOUND;
        if (i8 == mqtt5PubRelReasonCode2.f18903f) {
            return mqtt5PubRelReasonCode2;
        }
        return null;
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5ReasonCode
    public /* synthetic */ boolean a() {
        return a.a(this);
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5ReasonCode
    public int getCode() {
        return this.f18903f;
    }

    Mqtt5PubRelReasonCode(MqttCommonReasonCode mqttCommonReasonCode) {
        this(mqttCommonReasonCode.getCode());
    }
}
