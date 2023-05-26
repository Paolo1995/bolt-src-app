package com.hivemq.client.mqtt.mqtt5.message.connect.connack;

import com.hivemq.client.internal.mqtt.message.MqttCommonReasonCode;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5ReasonCode;
import v0.a;

/* loaded from: classes3.dex */
public enum Mqtt5ConnAckReasonCode implements Mqtt5ReasonCode {
    SUCCESS(MqttCommonReasonCode.SUCCESS),
    UNSPECIFIED_ERROR(MqttCommonReasonCode.UNSPECIFIED_ERROR),
    MALFORMED_PACKET(MqttCommonReasonCode.MALFORMED_PACKET),
    PROTOCOL_ERROR(MqttCommonReasonCode.PROTOCOL_ERROR),
    IMPLEMENTATION_SPECIFIC_ERROR(MqttCommonReasonCode.IMPLEMENTATION_SPECIFIC_ERROR),
    UNSUPPORTED_PROTOCOL_VERSION(132),
    CLIENT_IDENTIFIER_NOT_VALID(133),
    BAD_USER_NAME_OR_PASSWORD(134),
    NOT_AUTHORIZED(MqttCommonReasonCode.NOT_AUTHORIZED),
    SERVER_UNAVAILABLE(136),
    SERVER_BUSY(MqttCommonReasonCode.SERVER_BUSY),
    BANNED(138),
    BAD_AUTHENTICATION_METHOD(MqttCommonReasonCode.BAD_AUTHENTICATION_METHOD),
    TOPIC_NAME_INVALID(MqttCommonReasonCode.TOPIC_NAME_INVALID),
    PACKET_TOO_LARGE(MqttCommonReasonCode.PACKET_TOO_LARGE),
    QUOTA_EXCEEDED(MqttCommonReasonCode.QUOTA_EXCEEDED),
    PAYLOAD_FORMAT_INVALID(MqttCommonReasonCode.PAYLOAD_FORMAT_INVALID),
    RETAIN_NOT_SUPPORTED(MqttCommonReasonCode.RETAIN_NOT_SUPPORTED),
    QOS_NOT_SUPPORTED(MqttCommonReasonCode.QOS_NOT_SUPPORTED),
    USE_ANOTHER_SERVER(MqttCommonReasonCode.USE_ANOTHER_SERVER),
    SERVER_MOVED(MqttCommonReasonCode.SERVER_MOVED),
    CONNECTION_RATE_EXCEEDED(MqttCommonReasonCode.CONNECTION_RATE_EXCEEDED);
    
    private static final int C;
    private static final int D;
    private static final Mqtt5ConnAckReasonCode[] E;

    /* renamed from: f  reason: collision with root package name */
    private final int f18843f;

    static {
        Mqtt5ConnAckReasonCode[] values;
        Mqtt5ConnAckReasonCode mqtt5ConnAckReasonCode = UNSPECIFIED_ERROR;
        Mqtt5ConnAckReasonCode mqtt5ConnAckReasonCode2 = CONNECTION_RATE_EXCEEDED;
        int i8 = mqtt5ConnAckReasonCode.f18843f;
        C = i8;
        int i9 = mqtt5ConnAckReasonCode2.f18843f;
        D = i9;
        E = new Mqtt5ConnAckReasonCode[(i9 - i8) + 1];
        for (Mqtt5ConnAckReasonCode mqtt5ConnAckReasonCode3 : values()) {
            if (mqtt5ConnAckReasonCode3 != SUCCESS) {
                E[mqtt5ConnAckReasonCode3.f18843f - C] = mqtt5ConnAckReasonCode3;
            }
        }
    }

    Mqtt5ConnAckReasonCode(int i8) {
        this.f18843f = i8;
    }

    public static Mqtt5ConnAckReasonCode c(int i8) {
        Mqtt5ConnAckReasonCode mqtt5ConnAckReasonCode = SUCCESS;
        if (i8 == mqtt5ConnAckReasonCode.f18843f) {
            return mqtt5ConnAckReasonCode;
        }
        int i9 = C;
        if (i8 >= i9 && i8 <= D) {
            return E[i8 - i9];
        }
        return null;
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5ReasonCode
    public /* synthetic */ boolean a() {
        return a.a(this);
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5ReasonCode
    public int getCode() {
        return this.f18843f;
    }

    Mqtt5ConnAckReasonCode(MqttCommonReasonCode mqttCommonReasonCode) {
        this(mqttCommonReasonCode.getCode());
    }
}
