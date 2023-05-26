package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;

/* compiled from: Job.kt */
/* loaded from: classes5.dex */
public interface Job extends CoroutineContext.Element {

    /* renamed from: d  reason: collision with root package name */
    public static final Key f51296d = Key.f51297f;

    /* compiled from: Job.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void a(Job job, CancellationException cancellationException, int i8, Object obj) {
            if (obj == null) {
                if ((i8 & 1) != 0) {
                    cancellationException = null;
                }
                job.e(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static <R> R b(Job job, R r7, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R) CoroutineContext.Element.DefaultImpls.a(job, r7, function2);
        }

        public static <E extends CoroutineContext.Element> E c(Job job, CoroutineContext.Key<E> key) {
            return (E) CoroutineContext.Element.DefaultImpls.b(job, key);
        }

        public static /* synthetic */ DisposableHandle d(Job job, boolean z7, boolean z8, Function1 function1, int i8, Object obj) {
            if (obj == null) {
                if ((i8 & 1) != 0) {
                    z7 = false;
                }
                if ((i8 & 2) != 0) {
                    z8 = true;
                }
                return job.F(z7, z8, function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        public static CoroutineContext e(Job job, CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.c(job, key);
        }

        public static CoroutineContext f(Job job, CoroutineContext coroutineContext) {
            return CoroutineContext.Element.DefaultImpls.d(job, coroutineContext);
        }
    }

    /* compiled from: Job.kt */
    /* loaded from: classes5.dex */
    public static final class Key implements CoroutineContext.Key<Job> {

        /* renamed from: f  reason: collision with root package name */
        static final /* synthetic */ Key f51297f = new Key();

        private Key() {
        }
    }

    ChildHandle D0(ChildJob childJob);

    DisposableHandle F(boolean z7, boolean z8, Function1<? super Throwable, Unit> function1);

    CancellationException I();

    DisposableHandle X(Function1<? super Throwable, Unit> function1);

    boolean c();

    void e(CancellationException cancellationException);

    boolean isActive();

    boolean isCancelled();

    boolean start();

    Object v0(Continuation<? super Unit> continuation);

    Sequence<Job> y();
}
