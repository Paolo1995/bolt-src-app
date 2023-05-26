package com.hivemq.client.mqtt.mqtt5.exceptions;

import com.hivemq.client.mqtt.mqtt5.message.auth.Mqtt5Auth;

/* loaded from: classes3.dex */
public class Mqtt5AuthException extends Mqtt5MessageException {

    /* renamed from: f  reason: collision with root package name */
    private final Mqtt5Auth f18794f;

    public Mqtt5AuthException(Mqtt5Auth mqtt5Auth, String str) {
        super(str);
        this.f18794f = mqtt5Auth;
    }

    @Override // com.hivemq.client.mqtt.mqtt5.exceptions.Mqtt5MessageException
    /* renamed from: b */
    public Mqtt5Auth a() {
        return this.f18794f;
    }
}
