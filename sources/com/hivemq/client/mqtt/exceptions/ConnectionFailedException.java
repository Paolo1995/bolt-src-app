package com.hivemq.client.mqtt.exceptions;

import com.hivemq.client.internal.util.AsyncRuntimeException;

/* loaded from: classes3.dex */
public class ConnectionFailedException extends AsyncRuntimeException {
    public ConnectionFailedException(String str) {
        super(str);
    }

    public ConnectionFailedException(Throwable th) {
        super(th);
    }
}
