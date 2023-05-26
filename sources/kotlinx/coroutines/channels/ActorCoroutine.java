package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;

/* compiled from: Actor.kt */
/* loaded from: classes5.dex */
class ActorCoroutine<E> extends ChannelCoroutine<E> implements ActorScope<E> {
    public ActorCoroutine(CoroutineContext coroutineContext, Channel<E> channel, boolean z7) {
        super(coroutineContext, channel, false, z7);
        w0((Job) coroutineContext.g(Job.f51296d));
    }

    @Override // kotlinx.coroutines.JobSupport
    protected void L0(Throwable th) {
        Channel<E> k12 = k1();
        CancellationException cancellationException = null;
        if (th != null) {
            if (th instanceof CancellationException) {
                cancellationException = (CancellationException) th;
            }
            if (cancellationException == null) {
                cancellationException = ExceptionsKt.a(DebugStringsKt.a(this) + " was cancelled", th);
            }
        }
        k12.e(cancellationException);
    }

    @Override // kotlinx.coroutines.JobSupport
    protected boolean t0(Throwable th) {
        CoroutineExceptionHandlerKt.a(getContext(), th);
        return true;
    }
}
