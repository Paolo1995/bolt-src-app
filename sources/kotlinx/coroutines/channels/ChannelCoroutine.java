package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.selects.SelectClause1;

/* compiled from: ChannelCoroutine.kt */
/* loaded from: classes5.dex */
public class ChannelCoroutine<E> extends AbstractCoroutine<Unit> implements Channel<E> {

    /* renamed from: h  reason: collision with root package name */
    private final Channel<E> f51405h;

    public ChannelCoroutine(CoroutineContext coroutineContext, Channel<E> channel, boolean z7, boolean z8) {
        super(coroutineContext, z7, z8);
        this.f51405h = channel;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object A(Continuation<? super ChannelResult<? extends E>> continuation) {
        Object A = this.f51405h.A(continuation);
        IntrinsicsKt__IntrinsicsKt.d();
        return A;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object D(E e8, Continuation<? super Unit> continuation) {
        return this.f51405h.D(e8, continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean E() {
        return this.f51405h.E();
    }

    @Override // kotlinx.coroutines.JobSupport
    public void T(Throwable th) {
        CancellationException X0 = JobSupport.X0(this, th, null, 1, null);
        this.f51405h.e(X0);
        R(X0);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean b(Throwable th) {
        return this.f51405h.b(th);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final void e(CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(W(), null, this);
        }
        T(cancellationException);
    }

    public final Channel<E> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public ChannelIterator<E> iterator() {
        return this.f51405h.iterator();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Channel<E> k1() {
        return this.f51405h;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void s(Function1<? super Throwable, Unit> function1) {
        this.f51405h.s(function1);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object u(E e8) {
        return this.f51405h.u(e8);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<E> v() {
        return this.f51405h.v();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<ChannelResult<E>> x() {
        return this.f51405h.x();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object z() {
        return this.f51405h.z();
    }
}
