package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.UndispatchedCoroutine;

/* compiled from: DispatchedContinuation.kt */
/* loaded from: classes5.dex */
public final class DispatchedContinuationKt {

    /* renamed from: a */
    private static final Symbol f51787a = new Symbol("UNDEFINED");

    /* renamed from: b */
    public static final Symbol f51788b = new Symbol("REUSABLE_CLAIMED");

    public static final /* synthetic */ Symbol a() {
        return f51787a;
    }

    public static final <T> void b(Continuation<? super T> continuation, Object obj, Function1<? super Throwable, Unit> function1) {
        boolean z7;
        UndispatchedCoroutine<?> undispatchedCoroutine;
        if (continuation instanceof DispatchedContinuation) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            Object b8 = CompletionStateKt.b(obj, function1);
            if (dispatchedContinuation.f51783i.K0(dispatchedContinuation.getContext())) {
                dispatchedContinuation.f51785k = b8;
                dispatchedContinuation.f51260h = 1;
                dispatchedContinuation.f51783i.G0(dispatchedContinuation.getContext(), dispatchedContinuation);
                return;
            }
            EventLoop b9 = ThreadLocalEventLoop.f51332a.b();
            if (b9.f1()) {
                dispatchedContinuation.f51785k = b8;
                dispatchedContinuation.f51260h = 1;
                b9.W0(dispatchedContinuation);
                return;
            }
            b9.b1(true);
            try {
                Job job = (Job) dispatchedContinuation.getContext().g(Job.f51296d);
                if (job != null && !job.isActive()) {
                    CancellationException I = job.I();
                    dispatchedContinuation.a(b8, I);
                    Result.Companion companion = Result.f50818g;
                    dispatchedContinuation.resumeWith(Result.b(ResultKt.a(I)));
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (!z7) {
                    Continuation<T> continuation2 = dispatchedContinuation.f51784j;
                    Object obj2 = dispatchedContinuation.f51786l;
                    CoroutineContext context = continuation2.getContext();
                    Object c8 = ThreadContextKt.c(context, obj2);
                    if (c8 != ThreadContextKt.f51837a) {
                        undispatchedCoroutine = CoroutineContextKt.g(continuation2, context, c8);
                    } else {
                        undispatchedCoroutine = null;
                    }
                    dispatchedContinuation.f51784j.resumeWith(obj);
                    Unit unit = Unit.f50853a;
                    if (undispatchedCoroutine == null || undispatchedCoroutine.l1()) {
                        ThreadContextKt.a(context, c8);
                    }
                }
                do {
                } while (b9.m1());
            } finally {
                try {
                    return;
                } finally {
                }
            }
            return;
        }
        continuation.resumeWith(obj);
    }

    public static /* synthetic */ void c(Continuation continuation, Object obj, Function1 function1, int i8, Object obj2) {
        if ((i8 & 2) != 0) {
            function1 = null;
        }
        b(continuation, obj, function1);
    }

    public static final boolean d(DispatchedContinuation<? super Unit> dispatchedContinuation) {
        Unit unit = Unit.f50853a;
        EventLoop b8 = ThreadLocalEventLoop.f51332a.b();
        if (b8.h1()) {
            return false;
        }
        if (b8.f1()) {
            dispatchedContinuation.f51785k = unit;
            dispatchedContinuation.f51260h = 1;
            b8.W0(dispatchedContinuation);
            return true;
        }
        b8.b1(true);
        try {
            dispatchedContinuation.run();
            do {
            } while (b8.m1());
        } finally {
            try {
                return false;
            } finally {
            }
        }
        return false;
    }
}
