package com.hivemq.client.mqtt.mqtt5.exceptions;

import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5Disconnect;

/* loaded from: classes3.dex */
public class Mqtt5DisconnectException extends Mqtt5MessageException {

    /* renamed from: f  reason: collision with root package name */
    private final Mqtt5Disconnect f18796f;

    public Mqtt5DisconnectException(Mqtt5Disconnect mqtt5Disconnect, String str) {
        super(str);
        this.f18796f = mqtt5Disconnect;
    }

    @Override // com.hivemq.client.mqtt.mqtt5.exceptions.Mqtt5MessageException
    /* renamed from: b */
    public Mqtt5Disconnect a() {
        return this.f18796f;
    }

    public Mqtt5DisconnectException(Mqtt5Disconnect mqtt5Disconnect, Throwable th) {
        super(th);
        this.f18796f = mqtt5Disconnect;
    }
}
