package com.hivemq.client.mqtt.mqtt5.exceptions;

import com.hivemq.client.internal.util.AsyncRuntimeException;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5Message;

/* loaded from: classes3.dex */
public abstract class Mqtt5MessageException extends AsyncRuntimeException {
    /* JADX INFO: Access modifiers changed from: package-private */
    public Mqtt5MessageException(String str) {
        super(str);
    }

    public abstract Mqtt5Message a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Mqtt5MessageException(Throwable th) {
        super(th.getMessage(), th);
    }
}
