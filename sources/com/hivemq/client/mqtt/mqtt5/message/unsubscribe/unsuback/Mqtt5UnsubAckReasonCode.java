package com.hivemq.client.mqtt.mqtt5.message.unsubscribe.unsuback;

import com.hivemq.client.internal.mqtt.message.MqttCommonReasonCode;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5ReasonCode;
import v0.a;

/* loaded from: classes3.dex */
public enum Mqtt5UnsubAckReasonCode implements Mqtt5ReasonCode {
    SUCCESS(MqttCommonReasonCode.SUCCESS),
    NO_SUBSCRIPTIONS_EXISTED(17),
    UNSPECIFIED_ERROR(MqttCommonReasonCode.UNSPECIFIED_ERROR),
    IMPLEMENTATION_SPECIFIC_ERROR(MqttCommonReasonCode.IMPLEMENTATION_SPECIFIC_ERROR),
    NOT_AUTHORIZED(MqttCommonReasonCode.NOT_AUTHORIZED),
    TOPIC_FILTER_INVALID(MqttCommonReasonCode.TOPIC_FILTER_INVALID),
    PACKET_IDENTIFIER_IN_USE(MqttCommonReasonCode.PACKET_IDENTIFIER_IN_USE);
    

    /* renamed from: n  reason: collision with root package name */
    private static final Mqtt5UnsubAckReasonCode[] f18930n = values();

    /* renamed from: f  reason: collision with root package name */
    private final int f18932f;

    Mqtt5UnsubAckReasonCode(int i8) {
        this.f18932f = i8;
    }

    public static Mqtt5UnsubAckReasonCode c(int i8) {
        Mqtt5UnsubAckReasonCode[] mqtt5UnsubAckReasonCodeArr;
        for (Mqtt5UnsubAckReasonCode mqtt5UnsubAckReasonCode : f18930n) {
            if (mqtt5UnsubAckReasonCode.f18932f == i8) {
                return mqtt5UnsubAckReasonCode;
            }
        }
        return null;
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5ReasonCode
    public /* synthetic */ boolean a() {
        return a.a(this);
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5ReasonCode
    public int getCode() {
        return this.f18932f;
    }

    Mqtt5UnsubAckReasonCode(MqttCommonReasonCode mqttCommonReasonCode) {
        this(mqttCommonReasonCode.getCode());
    }
}
