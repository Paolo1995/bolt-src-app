package com.hivemq.client.mqtt.exceptions;

import com.hivemq.client.internal.util.AsyncRuntimeException;

/* loaded from: classes3.dex */
public class MqttSessionExpiredException extends AsyncRuntimeException {
    public MqttSessionExpiredException(String str, Throwable th) {
        super(str, th);
    }
}
