package com.hivemq.client.mqtt.mqtt5.message.publish.puback;

import com.hivemq.client.internal.mqtt.message.MqttCommonReasonCode;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5ReasonCode;
import java.util.EnumSet;
import v0.a;

/* loaded from: classes3.dex */
public enum Mqtt5PubAckReasonCode implements Mqtt5ReasonCode {
    SUCCESS(MqttCommonReasonCode.SUCCESS),
    NO_MATCHING_SUBSCRIBERS(MqttCommonReasonCode.NO_MATCHING_SUBSCRIBERS),
    UNSPECIFIED_ERROR(MqttCommonReasonCode.UNSPECIFIED_ERROR),
    IMPLEMENTATION_SPECIFIC_ERROR(MqttCommonReasonCode.IMPLEMENTATION_SPECIFIC_ERROR),
    NOT_AUTHORIZED(MqttCommonReasonCode.NOT_AUTHORIZED),
    TOPIC_NAME_INVALID(MqttCommonReasonCode.TOPIC_NAME_INVALID),
    PACKET_IDENTIFIER_IN_USE(MqttCommonReasonCode.PACKET_IDENTIFIER_IN_USE),
    QUOTA_EXCEEDED(MqttCommonReasonCode.QUOTA_EXCEEDED),
    PAYLOAD_FORMAT_INVALID(MqttCommonReasonCode.PAYLOAD_FORMAT_INVALID);
    

    /* renamed from: p  reason: collision with root package name */
    private static final Mqtt5PubAckReasonCode[] f18879p;

    /* renamed from: q  reason: collision with root package name */
    private static final EnumSet<Mqtt5PubAckReasonCode> f18880q;

    /* renamed from: f  reason: collision with root package name */
    private final int f18882f;

    static {
        Mqtt5PubAckReasonCode mqtt5PubAckReasonCode = SUCCESS;
        Mqtt5PubAckReasonCode mqtt5PubAckReasonCode2 = UNSPECIFIED_ERROR;
        Mqtt5PubAckReasonCode mqtt5PubAckReasonCode3 = IMPLEMENTATION_SPECIFIC_ERROR;
        Mqtt5PubAckReasonCode mqtt5PubAckReasonCode4 = NOT_AUTHORIZED;
        Mqtt5PubAckReasonCode mqtt5PubAckReasonCode5 = TOPIC_NAME_INVALID;
        Mqtt5PubAckReasonCode mqtt5PubAckReasonCode6 = QUOTA_EXCEEDED;
        Mqtt5PubAckReasonCode mqtt5PubAckReasonCode7 = PAYLOAD_FORMAT_INVALID;
        f18879p = values();
        f18880q = EnumSet.of(mqtt5PubAckReasonCode, mqtt5PubAckReasonCode2, mqtt5PubAckReasonCode3, mqtt5PubAckReasonCode4, mqtt5PubAckReasonCode5, mqtt5PubAckReasonCode6, mqtt5PubAckReasonCode7);
    }

    Mqtt5PubAckReasonCode(int i8) {
        this.f18882f = i8;
    }

    public static Mqtt5PubAckReasonCode c(int i8) {
        Mqtt5PubAckReasonCode[] mqtt5PubAckReasonCodeArr;
        for (Mqtt5PubAckReasonCode mqtt5PubAckReasonCode : f18879p) {
            if (mqtt5PubAckReasonCode.f18882f == i8) {
                return mqtt5PubAckReasonCode;
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
        return this.f18882f;
    }

    Mqtt5PubAckReasonCode(MqttCommonReasonCode mqttCommonReasonCode) {
        this(mqttCommonReasonCode.getCode());
    }
}
