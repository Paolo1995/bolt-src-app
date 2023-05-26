package io.ktor.utils.io;

/* compiled from: ByteBufferChannel.kt */
/* loaded from: classes5.dex */
public final class ByteBufferChannelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Void b(Throwable th) {
        Throwable th2;
        try {
            th2 = ExceptionUtilsJvmKt.e(th, th);
        } catch (Throwable unused) {
            th2 = null;
        }
        if (th2 == null) {
            throw th;
        }
        throw th2;
    }
}
