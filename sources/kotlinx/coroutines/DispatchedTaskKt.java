package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: DispatchedTask.kt */
/* loaded from: classes5.dex */
public final class DispatchedTaskKt {
    public static final <T> void a(DispatchedTask<? super T> dispatchedTask, int i8) {
        boolean z7;
        Continuation<? super T> b8 = dispatchedTask.b();
        if (i8 == 4) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7 && (b8 instanceof DispatchedContinuation) && b(i8) == b(dispatchedTask.f51260h)) {
            CoroutineDispatcher coroutineDispatcher = ((DispatchedContinuation) b8).f51783i;
            CoroutineContext context = b8.getContext();
            if (coroutineDispatcher.K0(context)) {
                coroutineDispatcher.G0(context, dispatchedTask);
                return;
            } else {
                e(dispatchedTask);
                return;
            }
        }
        d(dispatchedTask, b8, z7);
    }

    public static final boolean b(int i8) {
        return i8 == 1 || i8 == 2;
    }

    public static final boolean c(int i8) {
        return i8 == 2;
    }

    public static final <T> void d(DispatchedTask<? super T> dispatchedTask, Continuation<? super T> continuation, boolean z7) {
        Object e8;
        UndispatchedCoroutine<?> undispatchedCoroutine;
        boolean l12;
        Object g8 = dispatchedTask.g();
        Throwable d8 = dispatchedTask.d(g8);
        if (d8 != null) {
            Result.Companion companion = Result.f50818g;
            e8 = ResultKt.a(d8);
        } else {
            Result.Companion companion2 = Result.f50818g;
            e8 = dispatchedTask.e(g8);
        }
        Object b8 = Result.b(e8);
        if (z7) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            Continuation<T> continuation2 = dispatchedContinuation.f51784j;
            Object obj = dispatchedContinuation.f51786l;
            CoroutineContext context = continuation2.getContext();
            Object c8 = ThreadContextKt.c(context, obj);
            if (c8 != ThreadContextKt.f51837a) {
                undispatchedCoroutine = CoroutineContextKt.g(continuation2, context, c8);
            } else {
                undispatchedCoroutine = null;
            }
            try {
                dispatchedContinuation.f51784j.resumeWith(b8);
                Unit unit = Unit.f50853a;
                if (undispatchedCoroutine != null) {
                    if (!l12) {
                        return;
                    }
                }
                return;
            } finally {
                if (undispatchedCoroutine == null || undispatchedCoroutine.l1()) {
                    ThreadContextKt.a(context, c8);
                }
            }
        }
        continuation.resumeWith(b8);
    }

    private static final void e(DispatchedTask<?> dispatchedTask) {
        EventLoop b8 = ThreadLocalEventLoop.f51332a.b();
        if (b8.f1()) {
            b8.W0(dispatchedTask);
            return;
        }
        b8.b1(true);
        try {
            d(dispatchedTask, dispatchedTask.b(), true);
            do {
            } while (b8.m1());
        } finally {
            try {
            } finally {
            }
        }
    }
}
