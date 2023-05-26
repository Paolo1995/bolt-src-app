package com.hivemq.client.mqtt.mqtt5.exceptions;

import com.hivemq.client.mqtt.mqtt5.message.unsubscribe.unsuback.Mqtt5UnsubAck;

/* loaded from: classes3.dex */
public class Mqtt5UnsubAckException extends Mqtt5MessageException {

    /* renamed from: f  reason: collision with root package name */
    private final Mqtt5UnsubAck f18800f;

    @Override // com.hivemq.client.mqtt.mqtt5.exceptions.Mqtt5MessageException
    /* renamed from: b */
    public Mqtt5UnsubAck a() {
        return this.f18800f;
    }
}
