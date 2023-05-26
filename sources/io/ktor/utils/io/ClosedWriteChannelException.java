package io.ktor.utils.io;

import java.util.concurrent.CancellationException;

/* compiled from: ByteWriteChannel.kt */
/* loaded from: classes5.dex */
public final class ClosedWriteChannelException extends CancellationException {
    public ClosedWriteChannelException(String str) {
        super(str);
    }
}
