package com.hivemq.client.mqtt.mqtt5.message.disconnect;

import com.hivemq.client.internal.mqtt.message.MqttCommonReasonCode;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5ReasonCode;
import java.util.EnumSet;
import v0.a;

/* loaded from: classes3.dex */
public enum Mqtt5DisconnectReasonCode implements Mqtt5ReasonCode {
    NORMAL_DISCONNECTION(0),
    DISCONNECT_WITH_WILL_MESSAGE(4),
    UNSPECIFIED_ERROR(MqttCommonReasonCode.UNSPECIFIED_ERROR),
    MALFORMED_PACKET(MqttCommonReasonCode.MALFORMED_PACKET),
    PROTOCOL_ERROR(MqttCommonReasonCode.PROTOCOL_ERROR),
    IMPLEMENTATION_SPECIFIC_ERROR(MqttCommonReasonCode.IMPLEMENTATION_SPECIFIC_ERROR),
    NOT_AUTHORIZED(MqttCommonReasonCode.NOT_AUTHORIZED),
    SERVER_BUSY(MqttCommonReasonCode.SERVER_BUSY),
    SERVER_SHUTTING_DOWN(139),
    BAD_AUTHENTICATION_METHOD(MqttCommonReasonCode.BAD_AUTHENTICATION_METHOD),
    KEEP_ALIVE_TIMEOUT(141),
    SESSION_TAKEN_OVER(142),
    TOPIC_FILTER_INVALID(MqttCommonReasonCode.TOPIC_FILTER_INVALID),
    TOPIC_NAME_INVALID(MqttCommonReasonCode.TOPIC_NAME_INVALID),
    RECEIVE_MAXIMUM_EXCEEDED(147),
    TOPIC_ALIAS_INVALID(148),
    PACKET_TOO_LARGE(MqttCommonReasonCode.PACKET_TOO_LARGE),
    MESSAGE_RATE_TOO_HIGH(150),
    QUOTA_EXCEEDED(MqttCommonReasonCode.QUOTA_EXCEEDED),
    ADMINISTRATIVE_ACTION(152),
    PAYLOAD_FORMAT_INVALID(MqttCommonReasonCode.PAYLOAD_FORMAT_INVALID),
    RETAIN_NOT_SUPPORTED(MqttCommonReasonCode.RETAIN_NOT_SUPPORTED),
    QOS_NOT_SUPPORTED(MqttCommonReasonCode.QOS_NOT_SUPPORTED),
    USE_ANOTHER_SERVER(MqttCommonReasonCode.USE_ANOTHER_SERVER),
    SERVER_MOVED(MqttCommonReasonCode.SERVER_MOVED),
    SHARED_SUBSCRIPTIONS_NOT_SUPPORTED(MqttCommonReasonCode.SHARED_SUBSCRIPTIONS_NOT_SUPPORTED),
    CONNECTION_RATE_EXCEEDED(MqttCommonReasonCode.CONNECTION_RATE_EXCEEDED),
    MAXIMUM_CONNECT_TIME(160),
    SUBSCRIPTION_IDENTIFIERS_NOT_SUPPORTED(MqttCommonReasonCode.SUBSCRIPTION_IDENTIFIERS_NOT_SUPPORTED),
    WILDCARD_SUBSCRIPTIONS_NOT_SUPPORTED(MqttCommonReasonCode.WILDCARD_SUBSCRIPTIONS_NOT_SUPPORTED);
    
    private static final int K;
    private static final int L;
    private static final Mqtt5DisconnectReasonCode[] M;
    private static final EnumSet<Mqtt5DisconnectReasonCode> N;
    private static final EnumSet<Mqtt5DisconnectReasonCode> O;

    /* renamed from: f  reason: collision with root package name */
    private final int f18866f;

    static {
        Mqtt5DisconnectReasonCode[] values;
        Mqtt5DisconnectReasonCode mqtt5DisconnectReasonCode = UNSPECIFIED_ERROR;
        Mqtt5DisconnectReasonCode mqtt5DisconnectReasonCode2 = WILDCARD_SUBSCRIPTIONS_NOT_SUPPORTED;
        int i8 = mqtt5DisconnectReasonCode.f18866f;
        K = i8;
        int i9 = mqtt5DisconnectReasonCode2.f18866f;
        L = i9;
        M = new Mqtt5DisconnectReasonCode[(i9 - i8) + 1];
        for (Mqtt5DisconnectReasonCode mqtt5DisconnectReasonCode3 : values()) {
            if (mqtt5DisconnectReasonCode3 != NORMAL_DISCONNECTION && mqtt5DisconnectReasonCode3 != DISCONNECT_WITH_WILL_MESSAGE) {
                M[mqtt5DisconnectReasonCode3.f18866f - K] = mqtt5DisconnectReasonCode3;
            }
        }
        Mqtt5DisconnectReasonCode mqtt5DisconnectReasonCode4 = NORMAL_DISCONNECTION;
        Mqtt5DisconnectReasonCode mqtt5DisconnectReasonCode5 = MALFORMED_PACKET;
        Mqtt5DisconnectReasonCode mqtt5DisconnectReasonCode6 = PROTOCOL_ERROR;
        Mqtt5DisconnectReasonCode mqtt5DisconnectReasonCode7 = BAD_AUTHENTICATION_METHOD;
        Mqtt5DisconnectReasonCode mqtt5DisconnectReasonCode8 = RECEIVE_MAXIMUM_EXCEEDED;
        Mqtt5DisconnectReasonCode mqtt5DisconnectReasonCode9 = TOPIC_ALIAS_INVALID;
        Mqtt5DisconnectReasonCode mqtt5DisconnectReasonCode10 = PACKET_TOO_LARGE;
        EnumSet<Mqtt5DisconnectReasonCode> of = EnumSet.of(mqtt5DisconnectReasonCode4, DISCONNECT_WITH_WILL_MESSAGE, UNSPECIFIED_ERROR, mqtt5DisconnectReasonCode5, mqtt5DisconnectReasonCode6, IMPLEMENTATION_SPECIFIC_ERROR, mqtt5DisconnectReasonCode7, TOPIC_NAME_INVALID, mqtt5DisconnectReasonCode8, mqtt5DisconnectReasonCode9, mqtt5DisconnectReasonCode10, MESSAGE_RATE_TOO_HIGH, QUOTA_EXCEEDED, ADMINISTRATIVE_ACTION, PAYLOAD_FORMAT_INVALID);
        N = of;
        EnumSet<Mqtt5DisconnectReasonCode> copyOf = EnumSet.copyOf((EnumSet) of);
        O = copyOf;
        copyOf.removeAll(EnumSet.of(mqtt5DisconnectReasonCode5, mqtt5DisconnectReasonCode6, mqtt5DisconnectReasonCode7, mqtt5DisconnectReasonCode8, mqtt5DisconnectReasonCode9, mqtt5DisconnectReasonCode10));
    }

    Mqtt5DisconnectReasonCode(int i8) {
        this.f18866f = i8;
    }

    public static Mqtt5DisconnectReasonCode c(int i8) {
        Mqtt5DisconnectReasonCode mqtt5DisconnectReasonCode = NORMAL_DISCONNECTION;
        if (i8 == mqtt5DisconnectReasonCode.f18866f) {
            return mqtt5DisconnectReasonCode;
        }
        Mqtt5DisconnectReasonCode mqtt5DisconnectReasonCode2 = DISCONNECT_WITH_WILL_MESSAGE;
        if (i8 == mqtt5DisconnectReasonCode2.f18866f) {
            return mqtt5DisconnectReasonCode2;
        }
        int i9 = K;
        if (i8 >= i9 && i8 <= L) {
            return M[i8 - i9];
        }
        return null;
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5ReasonCode
    public /* synthetic */ boolean a() {
        return a.a(this);
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5ReasonCode
    public int getCode() {
        return this.f18866f;
    }

    Mqtt5DisconnectReasonCode(MqttCommonReasonCode mqttCommonReasonCode) {
        this(mqttCommonReasonCode.getCode());
    }
}
