package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.JobSupport;

/* compiled from: Actor.kt */
/* loaded from: classes5.dex */
public final class ActorKt {
    public static final <E> SendChannel<E> a(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i8, CoroutineStart coroutineStart, Function1<? super Throwable, Unit> function1, Function2<? super ActorScope<E>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        ActorCoroutine actorCoroutine;
        CoroutineContext e8 = CoroutineContextKt.e(coroutineScope, coroutineContext);
        Channel b8 = ChannelKt.b(i8, null, null, 6, null);
        if (coroutineStart.e()) {
            actorCoroutine = new LazyActorCoroutine(e8, b8, function2);
        } else {
            actorCoroutine = new ActorCoroutine(e8, b8, true);
        }
        if (function1 != null) {
            ((JobSupport) actorCoroutine).X(function1);
        }
        ((AbstractCoroutine) actorCoroutine).j1(coroutineStart, actorCoroutine, function2);
        return actorCoroutine;
    }

    public static /* synthetic */ SendChannel b(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i8, CoroutineStart coroutineStart, Function1 function1, Function2 function2, int i9, Object obj) {
        int i10;
        if ((i9 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f50912f;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if ((i9 & 2) != 0) {
            i10 = 0;
        } else {
            i10 = i8;
        }
        if ((i9 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i9 & 8) != 0) {
            function1 = null;
        }
        return a(coroutineScope, coroutineContext2, i10, coroutineStart2, function1, function2);
    }
}
