package io.netty.handler.timeout;

import io.netty.util.internal.PlatformDependent;

/* loaded from: classes5.dex */
public final class WriteTimeoutException extends TimeoutException {
    public static final WriteTimeoutException INSTANCE;

    static {
        WriteTimeoutException writeTimeoutException;
        if (PlatformDependent.javaVersion() >= 7) {
            writeTimeoutException = new WriteTimeoutException(true);
        } else {
            writeTimeoutException = new WriteTimeoutException();
        }
        INSTANCE = writeTimeoutException;
    }

    private WriteTimeoutException() {
    }

    private WriteTimeoutException(boolean z7) {
        super(z7);
    }
}
