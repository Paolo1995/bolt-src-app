package com.hivemq.client.mqtt.mqtt5.message.publish.pubrec;

import com.hivemq.client.internal.mqtt.message.MqttCommonReasonCode;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5ReasonCode;
import java.util.EnumSet;
import v0.a;

/* loaded from: classes3.dex */
public enum Mqtt5PubRecReasonCode implements Mqtt5ReasonCode {
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
    private static final Mqtt5PubRecReasonCode[] f18896p;

    /* renamed from: q  reason: collision with root package name */
    private static final EnumSet<Mqtt5PubRecReasonCode> f18897q;

    /* renamed from: f  reason: collision with root package name */
    private final int f18899f;

    static {
        Mqtt5PubRecReasonCode mqtt5PubRecReasonCode = SUCCESS;
        Mqtt5PubRecReasonCode mqtt5PubRecReasonCode2 = UNSPECIFIED_ERROR;
        Mqtt5PubRecReasonCode mqtt5PubRecReasonCode3 = IMPLEMENTATION_SPECIFIC_ERROR;
        Mqtt5PubRecReasonCode mqtt5PubRecReasonCode4 = NOT_AUTHORIZED;
        Mqtt5PubRecReasonCode mqtt5PubRecReasonCode5 = TOPIC_NAME_INVALID;
        Mqtt5PubRecReasonCode mqtt5PubRecReasonCode6 = QUOTA_EXCEEDED;
        Mqtt5PubRecReasonCode mqtt5PubRecReasonCode7 = PAYLOAD_FORMAT_INVALID;
        f18896p = values();
        f18897q = EnumSet.of(mqtt5PubRecReasonCode, mqtt5PubRecReasonCode2, mqtt5PubRecReasonCode3, mqtt5PubRecReasonCode4, mqtt5PubRecReasonCode5, mqtt5PubRecReasonCode6, mqtt5PubRecReasonCode7);
    }

    Mqtt5PubRecReasonCode(int i8) {
        this.f18899f = i8;
    }

    public static Mqtt5PubRecReasonCode c(int i8) {
        Mqtt5PubRecReasonCode[] mqtt5PubRecReasonCodeArr;
        for (Mqtt5PubRecReasonCode mqtt5PubRecReasonCode : f18896p) {
            if (mqtt5PubRecReasonCode.f18899f == i8) {
                return mqtt5PubRecReasonCode;
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
        return this.f18899f;
    }

    Mqtt5PubRecReasonCode(MqttCommonReasonCode mqttCommonReasonCode) {
        this(mqttCommonReasonCode.getCode());
    }
}
