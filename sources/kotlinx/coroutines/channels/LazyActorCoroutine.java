package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.CancellableKt;

/* compiled from: Actor.kt */
/* loaded from: classes5.dex */
final class LazyActorCoroutine<E> extends ActorCoroutine<E> {

    /* renamed from: i  reason: collision with root package name */
    private Continuation<? super Unit> f51417i;

    public LazyActorCoroutine(CoroutineContext coroutineContext, Channel<E> channel, Function2<? super ActorScope<E>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        super(coroutineContext, channel, false);
        Continuation<? super Unit> b8;
        b8 = IntrinsicsKt__IntrinsicsJvmKt.b(function2, this, this);
        this.f51417i = b8;
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.SendChannel
    public Object D(E e8, Continuation<? super Unit> continuation) {
        Object d8;
        start();
        Object D = super.D(e8, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (D == d8) {
            return D;
        }
        return Unit.f50853a;
    }

    @Override // kotlinx.coroutines.JobSupport
    protected void N0() {
        CancellableKt.b(this.f51417i, this);
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.SendChannel
    public boolean b(Throwable th) {
        boolean b8 = super.b(th);
        start();
        return b8;
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.SendChannel
    public Object u(E e8) {
        start();
        return super.u(e8);
    }
}
