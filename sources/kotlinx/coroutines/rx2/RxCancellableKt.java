package kotlinx.coroutines.rx2;

import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;

/* compiled from: RxCancellable.kt */
/* loaded from: classes5.dex */
public final class RxCancellableKt {
    public static final void a(Throwable th, CoroutineContext coroutineContext) {
        if (th instanceof CancellationException) {
            return;
        }
        try {
            RxJavaPlugins.s(th);
        } catch (Throwable th2) {
            ExceptionsKt__ExceptionsKt.a(th, th2);
            CoroutineExceptionHandlerKt.a(coroutineContext, th);
        }
    }
}
