package io.netty.channel;

import java.net.ConnectException;

/* loaded from: classes5.dex */
public class ConnectTimeoutException extends ConnectException {
    public ConnectTimeoutException(String str) {
        super(str);
    }

    public ConnectTimeoutException() {
    }
}
