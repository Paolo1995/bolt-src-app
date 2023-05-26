package com.hivemq.client.internal.util;

/* loaded from: classes3.dex */
public abstract class AsyncRuntimeException extends RuntimeException {
    /* JADX INFO: Access modifiers changed from: protected */
    public AsyncRuntimeException(String str) {
        super(str, null);
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AsyncRuntimeException(String str, Throwable th) {
        super(str, th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AsyncRuntimeException(Throwable th) {
        super(th);
    }
}
