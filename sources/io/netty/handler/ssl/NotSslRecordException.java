package io.netty.handler.ssl;

import javax.net.ssl.SSLException;

/* loaded from: classes5.dex */
public class NotSslRecordException extends SSLException {
    public NotSslRecordException() {
        super("");
    }

    public NotSslRecordException(String str) {
        super(str);
    }
}
