package com.hivemq.client.mqtt.mqtt5.exceptions;

import com.hivemq.client.mqtt.mqtt5.message.publish.pubrec.Mqtt5PubRec;

/* loaded from: classes3.dex */
public class Mqtt5PubRecException extends Mqtt5MessageException {

    /* renamed from: f  reason: collision with root package name */
    private final Mqtt5PubRec f18798f;

    public Mqtt5PubRecException(Mqtt5PubRec mqtt5PubRec, String str) {
        super(str);
        this.f18798f = mqtt5PubRec;
    }

    @Override // com.hivemq.client.mqtt.mqtt5.exceptions.Mqtt5MessageException
    /* renamed from: b */
    public Mqtt5PubRec a() {
        return this.f18798f;
    }
}
