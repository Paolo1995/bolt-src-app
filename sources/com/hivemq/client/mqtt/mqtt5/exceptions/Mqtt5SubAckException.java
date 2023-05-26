package com.hivemq.client.mqtt.mqtt5.exceptions;

import com.hivemq.client.mqtt.mqtt5.message.subscribe.suback.Mqtt5SubAck;

/* loaded from: classes3.dex */
public class Mqtt5SubAckException extends Mqtt5MessageException {

    /* renamed from: f  reason: collision with root package name */
    private final Mqtt5SubAck f18799f;

    public Mqtt5SubAckException(Mqtt5SubAck mqtt5SubAck, String str) {
        super(str);
        this.f18799f = mqtt5SubAck;
    }

    @Override // com.hivemq.client.mqtt.mqtt5.exceptions.Mqtt5MessageException
    /* renamed from: b */
    public Mqtt5SubAck a() {
        return this.f18799f;
    }
}
