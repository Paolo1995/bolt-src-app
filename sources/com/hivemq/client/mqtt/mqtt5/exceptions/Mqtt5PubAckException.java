package com.hivemq.client.mqtt.mqtt5.exceptions;

import com.hivemq.client.mqtt.mqtt5.message.publish.puback.Mqtt5PubAck;

/* loaded from: classes3.dex */
public class Mqtt5PubAckException extends Mqtt5MessageException {

    /* renamed from: f  reason: collision with root package name */
    private final Mqtt5PubAck f18797f;

    public Mqtt5PubAckException(Mqtt5PubAck mqtt5PubAck, String str) {
        super(str);
        this.f18797f = mqtt5PubAck;
    }

    @Override // com.hivemq.client.mqtt.mqtt5.exceptions.Mqtt5MessageException
    /* renamed from: b */
    public Mqtt5PubAck a() {
        return this.f18797f;
    }
}
