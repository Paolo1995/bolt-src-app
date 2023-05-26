package io.ktor.client.engine;

import java.io.Closeable;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* compiled from: HttpClientEngineBase.kt */
/* loaded from: classes5.dex */
public final class HttpClientEngineBaseKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(CoroutineDispatcher coroutineDispatcher) {
        try {
            if (coroutineDispatcher instanceof ExecutorCoroutineDispatcher) {
                ((ExecutorCoroutineDispatcher) coroutineDispatcher).close();
            } else if (coroutineDispatcher instanceof Closeable) {
                ((Closeable) coroutineDispatcher).close();
            }
        } catch (Throwable unused) {
        }
    }
}
