package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TaskContext;

/* compiled from: DispatchedTask.kt */
/* loaded from: classes5.dex */
public abstract class DispatchedTask<T> extends Task {

    /* renamed from: h  reason: collision with root package name */
    public int f51260h;

    public DispatchedTask(int i8) {
        this.f51260h = i8;
    }

    public void a(Object obj, Throwable th) {
    }

    public abstract Continuation<T> b();

    public Throwable d(Object obj) {
        CompletedExceptionally completedExceptionally;
        if (obj instanceof CompletedExceptionally) {
            completedExceptionally = (CompletedExceptionally) obj;
        } else {
            completedExceptionally = null;
        }
        if (completedExceptionally == null) {
            return null;
        }
        return completedExceptionally.f51234a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T e(Object obj) {
        return obj;
    }

    public final void f(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            ExceptionsKt__ExceptionsKt.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        Intrinsics.c(th);
        CoroutineExceptionHandlerKt.a(b().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object g();

    @Override // java.lang.Runnable
    public final void run() {
        Object b8;
        UndispatchedCoroutine<?> undispatchedCoroutine;
        Job job;
        Object b9;
        TaskContext taskContext = this.f51960g;
        try {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) b();
            Continuation<T> continuation = dispatchedContinuation.f51784j;
            Object obj = dispatchedContinuation.f51786l;
            CoroutineContext context = continuation.getContext();
            Object c8 = ThreadContextKt.c(context, obj);
            if (c8 != ThreadContextKt.f51837a) {
                undispatchedCoroutine = CoroutineContextKt.g(continuation, context, c8);
            } else {
                undispatchedCoroutine = null;
            }
            CoroutineContext context2 = continuation.getContext();
            Object g8 = g();
            Throwable d8 = d(g8);
            if (d8 == null && DispatchedTaskKt.b(this.f51260h)) {
                job = (Job) context2.g(Job.f51296d);
            } else {
                job = null;
            }
            if (job != null && !job.isActive()) {
                CancellationException I = job.I();
                a(g8, I);
                Result.Companion companion = Result.f50818g;
                continuation.resumeWith(Result.b(ResultKt.a(I)));
            } else if (d8 != null) {
                Result.Companion companion2 = Result.f50818g;
                continuation.resumeWith(Result.b(ResultKt.a(d8)));
            } else {
                Result.Companion companion3 = Result.f50818g;
                continuation.resumeWith(Result.b(e(g8)));
            }
            Unit unit = Unit.f50853a;
            if (undispatchedCoroutine == null || undispatchedCoroutine.l1()) {
                ThreadContextKt.a(context, c8);
            }
            try {
                taskContext.a();
                b9 = Result.b(Unit.f50853a);
            } catch (Throwable th) {
                Result.Companion companion4 = Result.f50818g;
                b9 = Result.b(ResultKt.a(th));
            }
            f(null, Result.e(b9));
        } catch (Throwable th2) {
            try {
                Result.Companion companion5 = Result.f50818g;
                taskContext.a();
                b8 = Result.b(Unit.f50853a);
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.f50818g;
                b8 = Result.b(ResultKt.a(th3));
            }
            f(th2, Result.e(b8));
        }
    }
}
