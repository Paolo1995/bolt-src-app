package com.hivemq.client.mqtt.mqtt5.message.auth;

import com.hivemq.client.internal.mqtt.message.MqttCommonReasonCode;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5ReasonCode;
import v0.a;

/* loaded from: classes3.dex */
public enum Mqtt5AuthReasonCode implements Mqtt5ReasonCode {
    SUCCESS(MqttCommonReasonCode.SUCCESS),
    CONTINUE_AUTHENTICATION(24),
    REAUTHENTICATE(25);
    

    /* renamed from: f  reason: collision with root package name */
    private final int f18822f;

    Mqtt5AuthReasonCode(int i8) {
        this.f18822f = i8;
    }

    public static Mqtt5AuthReasonCode c(int i8) {
        Mqtt5AuthReasonCode mqtt5AuthReasonCode = SUCCESS;
        if (i8 == mqtt5AuthReasonCode.f18822f) {
            return mqtt5AuthReasonCode;
        }
        Mqtt5AuthReasonCode mqtt5AuthReasonCode2 = CONTINUE_AUTHENTICATION;
        if (i8 == mqtt5AuthReasonCode2.f18822f) {
            return mqtt5AuthReasonCode2;
        }
        Mqtt5AuthReasonCode mqtt5AuthReasonCode3 = REAUTHENTICATE;
        if (i8 == mqtt5AuthReasonCode3.f18822f) {
            return mqtt5AuthReasonCode3;
        }
        return null;
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5ReasonCode
    public /* synthetic */ boolean a() {
        return a.a(this);
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5ReasonCode
    public int getCode() {
        return this.f18822f;
    }

    Mqtt5AuthReasonCode(MqttCommonReasonCode mqttCommonReasonCode) {
        this(mqttCommonReasonCode.getCode());
    }
}
