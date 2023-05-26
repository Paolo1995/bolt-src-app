package com.hivemq.client.mqtt.exceptions;

import com.hivemq.client.internal.util.AsyncRuntimeException;

/* loaded from: classes3.dex */
public class ConnectionClosedException extends AsyncRuntimeException {
    public ConnectionClosedException(String str) {
        super(str);
    }

    public ConnectionClosedException(Throwable th) {
        super(th);
    }
}
