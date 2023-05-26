package com.hivemq.client.mqtt.mqtt3.exceptions;

import com.hivemq.client.mqtt.mqtt3.message.subscribe.suback.Mqtt3SubAck;

/* loaded from: classes3.dex */
public class Mqtt3SubAckException extends Mqtt3MessageException {

    /* renamed from: f  reason: collision with root package name */
    private final Mqtt3SubAck f18761f;

    public Mqtt3SubAckException(Mqtt3SubAck mqtt3SubAck, String str, Throwable th) {
        super(str, th);
        this.f18761f = mqtt3SubAck;
    }
}
