package io.netty.handler.timeout;

import io.netty.util.internal.PlatformDependent;

/* loaded from: classes5.dex */
public final class ReadTimeoutException extends TimeoutException {
    public static final ReadTimeoutException INSTANCE;

    static {
        ReadTimeoutException readTimeoutException;
        if (PlatformDependent.javaVersion() >= 7) {
            readTimeoutException = new ReadTimeoutException(true);
        } else {
            readTimeoutException = new ReadTimeoutException();
        }
        INSTANCE = readTimeoutException;
    }

    ReadTimeoutException() {
    }

    private ReadTimeoutException(boolean z7) {
        super(z7);
    }
}
