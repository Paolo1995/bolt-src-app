package com.hivemq.client.internal.mqtt.message;

import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5ReasonCode;
import v0.a;

/* loaded from: classes3.dex */
public enum MqttCommonReasonCode implements Mqtt5ReasonCode {
    SUCCESS(0),
    NO_MATCHING_SUBSCRIBERS(16),
    UNSPECIFIED_ERROR(128),
    MALFORMED_PACKET(129),
    PROTOCOL_ERROR(130),
    IMPLEMENTATION_SPECIFIC_ERROR(131),
    NOT_AUTHORIZED(135),
    SERVER_BUSY(137),
    BAD_AUTHENTICATION_METHOD(140),
    TOPIC_FILTER_INVALID(143),
    TOPIC_NAME_INVALID(144),
    PACKET_IDENTIFIER_IN_USE(145),
    PACKET_IDENTIFIER_NOT_FOUND(146),
    PACKET_TOO_LARGE(149),
    QUOTA_EXCEEDED(151),
    PAYLOAD_FORMAT_INVALID(153),
    RETAIN_NOT_SUPPORTED(154),
    QOS_NOT_SUPPORTED(155),
    USE_ANOTHER_SERVER(156),
    SERVER_MOVED(157),
    SHARED_SUBSCRIPTIONS_NOT_SUPPORTED(158),
    CONNECTION_RATE_EXCEEDED(159),
    SUBSCRIPTION_IDENTIFIERS_NOT_SUPPORTED(161),
    WILDCARD_SUBSCRIPTIONS_NOT_SUPPORTED(162);
    

    /* renamed from: f  reason: collision with root package name */
    private final int f18466f;

    MqttCommonReasonCode(int i8) {
        this.f18466f = i8;
    }

    public static boolean c(ImmutableList<? extends Mqtt5ReasonCode> immutableList) {
        for (int i8 = 0; i8 < immutableList.size(); i8++) {
            if (!immutableList.get(i8).a()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5ReasonCode
    public /* synthetic */ boolean a() {
        return a.a(this);
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5ReasonCode
    public int getCode() {
        return this.f18466f;
    }
}
