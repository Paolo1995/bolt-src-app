package com.hivemq.client.mqtt.mqtt5.message.subscribe.suback;

import com.hivemq.client.internal.mqtt.message.MqttCommonReasonCode;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5ReasonCode;
import v0.a;

/* loaded from: classes3.dex */
public enum Mqtt5SubAckReasonCode implements Mqtt5ReasonCode {
    GRANTED_QOS_0(0),
    GRANTED_QOS_1(1),
    GRANTED_QOS_2(2),
    UNSPECIFIED_ERROR(MqttCommonReasonCode.UNSPECIFIED_ERROR),
    IMPLEMENTATION_SPECIFIC_ERROR(MqttCommonReasonCode.IMPLEMENTATION_SPECIFIC_ERROR),
    NOT_AUTHORIZED(MqttCommonReasonCode.NOT_AUTHORIZED),
    TOPIC_FILTER_INVALID(MqttCommonReasonCode.TOPIC_FILTER_INVALID),
    PACKET_IDENTIFIER_IN_USE(MqttCommonReasonCode.PACKET_IDENTIFIER_IN_USE),
    QUOTA_EXCEEDED(MqttCommonReasonCode.QUOTA_EXCEEDED),
    SHARED_SUBSCRIPTIONS_NOT_SUPPORTED(MqttCommonReasonCode.SHARED_SUBSCRIPTIONS_NOT_SUPPORTED),
    SUBSCRIPTION_IDENTIFIERS_NOT_SUPPORTED(MqttCommonReasonCode.SUBSCRIPTION_IDENTIFIERS_NOT_SUPPORTED),
    WILDCARD_SUBSCRIPTIONS_NOT_SUPPORTED(MqttCommonReasonCode.WILDCARD_SUBSCRIPTIONS_NOT_SUPPORTED);
    

    /* renamed from: s  reason: collision with root package name */
    private static final Mqtt5SubAckReasonCode[] f18920s = values();

    /* renamed from: f  reason: collision with root package name */
    private final int f18922f;

    Mqtt5SubAckReasonCode(int i8) {
        this.f18922f = i8;
    }

    public static Mqtt5SubAckReasonCode c(int i8) {
        Mqtt5SubAckReasonCode[] mqtt5SubAckReasonCodeArr;
        for (Mqtt5SubAckReasonCode mqtt5SubAckReasonCode : f18920s) {
            if (mqtt5SubAckReasonCode.f18922f == i8) {
                return mqtt5SubAckReasonCode;
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
        return this.f18922f;
    }

    Mqtt5SubAckReasonCode(MqttCommonReasonCode mqttCommonReasonCode) {
        this(mqttCommonReasonCode.getCode());
    }
}
