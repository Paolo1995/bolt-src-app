package com.hivemq.client.internal.mqtt.codec.decoder;

import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5DisconnectReasonCode;

/* loaded from: classes3.dex */
public class MqttDecoderException extends Exception {

    /* renamed from: f  reason: collision with root package name */
    private final Mqtt5DisconnectReasonCode f17868f;

    public MqttDecoderException(Mqtt5DisconnectReasonCode mqtt5DisconnectReasonCode, String str) {
        super(str, null, false, false);
        this.f17868f = mqtt5DisconnectReasonCode;
    }

    public Mqtt5DisconnectReasonCode a() {
        return this.f17868f;
    }

    public MqttDecoderException(String str) {
        this(Mqtt5DisconnectReasonCode.MALFORMED_PACKET, str);
    }
}
