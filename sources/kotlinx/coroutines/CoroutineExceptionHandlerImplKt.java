package kotlinx.coroutines;

import java.util.List;
import java.util.ServiceLoader;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: CoroutineExceptionHandlerImpl.kt */
/* loaded from: classes5.dex */
public final class CoroutineExceptionHandlerImplKt {

    /* renamed from: a  reason: collision with root package name */
    private static final List<CoroutineExceptionHandler> f51245a;

    static {
        Sequence c8;
        List<CoroutineExceptionHandler> D;
        c8 = SequencesKt__SequencesKt.c(ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader()).iterator());
        D = SequencesKt___SequencesKt.D(c8);
        f51245a = D;
    }

    public static final void a(CoroutineContext coroutineContext, Throwable th) {
        for (CoroutineExceptionHandler coroutineExceptionHandler : f51245a) {
            try {
                coroutineExceptionHandler.k0(coroutineContext, th);
            } catch (Throwable th2) {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, CoroutineExceptionHandlerKt.b(th, th2));
            }
        }
        Thread currentThread2 = Thread.currentThread();
        try {
            Result.Companion companion = Result.f50818g;
            ExceptionsKt__ExceptionsKt.a(th, new DiagnosticCoroutineContextException(coroutineContext));
            Result.b(Unit.f50853a);
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.f50818g;
            Result.b(ResultKt.a(th3));
        }
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }
}
