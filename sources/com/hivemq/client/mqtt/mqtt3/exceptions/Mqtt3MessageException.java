package com.hivemq.client.mqtt.mqtt3.exceptions;

import com.hivemq.client.internal.util.AsyncRuntimeException;

/* loaded from: classes3.dex */
public abstract class Mqtt3MessageException extends AsyncRuntimeException {
    /* JADX INFO: Access modifiers changed from: package-private */
    public Mqtt3MessageException(String str, Throwable th) {
        super(str, th);
    }
}
