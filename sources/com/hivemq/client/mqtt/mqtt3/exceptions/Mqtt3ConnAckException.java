package com.hivemq.client.mqtt.mqtt3.exceptions;

import com.hivemq.client.mqtt.mqtt3.message.connect.connack.Mqtt3ConnAck;

/* loaded from: classes3.dex */
public class Mqtt3ConnAckException extends Mqtt3MessageException {

    /* renamed from: f  reason: collision with root package name */
    private final Mqtt3ConnAck f18760f;

    public Mqtt3ConnAckException(Mqtt3ConnAck mqtt3ConnAck, String str, Throwable th) {
        super(str, th);
        this.f18760f = mqtt3ConnAck;
    }

    public Mqtt3ConnAck a() {
        return this.f18760f;
    }
}
