package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.kt */
/* loaded from: classes5.dex */
public final /* synthetic */ class BuildersKt__BuildersKt {
    public static final <T> T a(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) throws InterruptedException {
        EventLoop eventLoop;
        EventLoop a8;
        CoroutineContext e8;
        Thread currentThread = Thread.currentThread();
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.g(ContinuationInterceptor.f50909b);
        if (continuationInterceptor == null) {
            a8 = ThreadLocalEventLoop.f51332a.b();
            e8 = CoroutineContextKt.e(GlobalScope.f51286f, coroutineContext.s0(a8));
        } else {
            EventLoop eventLoop2 = null;
            if (continuationInterceptor instanceof EventLoop) {
                eventLoop = (EventLoop) continuationInterceptor;
            } else {
                eventLoop = null;
            }
            if (eventLoop != null) {
                if (eventLoop.n1()) {
                    eventLoop2 = eventLoop;
                }
                if (eventLoop2 != null) {
                    a8 = eventLoop2;
                    e8 = CoroutineContextKt.e(GlobalScope.f51286f, coroutineContext);
                }
            }
            a8 = ThreadLocalEventLoop.f51332a.a();
            e8 = CoroutineContextKt.e(GlobalScope.f51286f, coroutineContext);
        }
        BlockingCoroutine blockingCoroutine = new BlockingCoroutine(e8, currentThread, a8);
        blockingCoroutine.j1(CoroutineStart.DEFAULT, blockingCoroutine, function2);
        return (T) blockingCoroutine.k1();
    }

    public static /* synthetic */ Object b(CoroutineContext coroutineContext, Function2 function2, int i8, Object obj) throws InterruptedException {
        if ((i8 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f50912f;
        }
        return BuildersKt.e(coroutineContext, function2);
    }
}
