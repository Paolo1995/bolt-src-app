package com.hivemq.client.mqtt.mqtt5.exceptions;

import com.hivemq.client.mqtt.mqtt5.message.connect.connack.Mqtt5ConnAck;

/* loaded from: classes3.dex */
public class Mqtt5ConnAckException extends Mqtt5MessageException {

    /* renamed from: f  reason: collision with root package name */
    private final Mqtt5ConnAck f18795f;

    public Mqtt5ConnAckException(Mqtt5ConnAck mqtt5ConnAck, String str) {
        super(str);
        this.f18795f = mqtt5ConnAck;
    }

    @Override // com.hivemq.client.mqtt.mqtt5.exceptions.Mqtt5MessageException
    /* renamed from: b */
    public Mqtt5ConnAck a() {
        return this.f18795f;
    }
}
