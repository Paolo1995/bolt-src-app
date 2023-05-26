package kotlinx.coroutines.reactive;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.intrinsics.CancellableKt;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: ReactiveFlow.kt */
/* loaded from: classes5.dex */
public final class FlowSubscription<T> extends AbstractCoroutine<Unit> implements Subscription {

    /* renamed from: j  reason: collision with root package name */
    static final /* synthetic */ AtomicLongFieldUpdater f51851j = AtomicLongFieldUpdater.newUpdater(FlowSubscription.class, "requested");

    /* renamed from: k  reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f51852k = AtomicReferenceFieldUpdater.newUpdater(FlowSubscription.class, Object.class, "producer");
    private volatile boolean cancellationRequested;

    /* renamed from: h  reason: collision with root package name */
    public final Flow<T> f51853h;

    /* renamed from: i  reason: collision with root package name */
    public final Subscriber<? super T> f51854i;
    volatile /* synthetic */ Object producer;
    volatile /* synthetic */ long requested;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowSubscription(Flow<? extends T> flow, Subscriber<? super T> subscriber, CoroutineContext coroutineContext) {
        super(coroutineContext, false, true);
        this.f51853h = flow;
        this.f51854i = subscriber;
        this.requested = 0L;
        this.producer = m1();
    }

    private final Object l1(Continuation<? super Unit> continuation) {
        Object d8;
        Object a8 = this.f51853h.a(new FlowCollector(this) { // from class: kotlinx.coroutines.reactive.FlowSubscription$consumeFlow$2

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ FlowSubscription<T> f51857f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f51857f = this;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object b(T t7, Continuation<? super Unit> continuation2) {
                Continuation c8;
                Object d9;
                Object d10;
                this.f51857f.f51854i.onNext(t7);
                if (FlowSubscription.f51851j.decrementAndGet(this.f51857f) <= 0) {
                    FlowSubscription<T> flowSubscription = this.f51857f;
                    c8 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation2);
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(c8, 1);
                    cancellableContinuationImpl.y();
                    flowSubscription.producer = cancellableContinuationImpl;
                    Object v7 = cancellableContinuationImpl.v();
                    d9 = IntrinsicsKt__IntrinsicsKt.d();
                    if (v7 == d9) {
                        DebugProbesKt.c(continuation2);
                    }
                    d10 = IntrinsicsKt__IntrinsicsKt.d();
                    if (v7 == d10) {
                        return v7;
                    }
                    return Unit.f50853a;
                }
                JobKt.i(this.f51857f.j());
                return Unit.f50853a;
            }
        }, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (a8 == d8) {
            return a8;
        }
        return Unit.f50853a;
    }

    private final Continuation<Unit> m1() {
        final CoroutineContext j8 = j();
        return new Continuation<Unit>() { // from class: kotlinx.coroutines.reactive.FlowSubscription$createInitialContinuation$$inlined$Continuation$1
            @Override // kotlin.coroutines.Continuation
            public CoroutineContext getContext() {
                return CoroutineContext.this;
            }

            @Override // kotlin.coroutines.Continuation
            public void resumeWith(Object obj) {
                CancellableKt.c(new FlowSubscription$createInitialContinuation$1$1(this), this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(7:5|6|(1:(3:9|10|11)(2:35|36))(4:37|38|39|(1:41)(1:42))|12|13|14|15))|46|6|(0)(0)|12|13|14|15|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004c, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004d, code lost:
        kotlinx.coroutines.CoroutineExceptionHandlerKt.a(r0.j(), r5);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object n1(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1 r0 = (kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1) r0
            int r1 = r0.f51861i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f51861i = r1
            goto L18
        L13:
            kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1 r0 = new kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f51859g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f51861i
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r0 = r0.f51858f
            kotlinx.coroutines.reactive.FlowSubscription r0 = (kotlinx.coroutines.reactive.FlowSubscription) r0
            kotlin.ResultKt.b(r5)     // Catch: java.lang.Throwable -> L2d
            goto L46
        L2d:
            r5 = move-exception
            goto L59
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L37:
            kotlin.ResultKt.b(r5)
            r0.f51858f = r4     // Catch: java.lang.Throwable -> L57
            r0.f51861i = r3     // Catch: java.lang.Throwable -> L57
            java.lang.Object r5 = r4.l1(r0)     // Catch: java.lang.Throwable -> L57
            if (r5 != r1) goto L45
            return r1
        L45:
            r0 = r4
        L46:
            org.reactivestreams.Subscriber<? super T> r5 = r0.f51854i     // Catch: java.lang.Throwable -> L4c
            r5.onComplete()     // Catch: java.lang.Throwable -> L4c
            goto L54
        L4c:
            r5 = move-exception
            kotlin.coroutines.CoroutineContext r0 = r0.j()
            kotlinx.coroutines.CoroutineExceptionHandlerKt.a(r0, r5)
        L54:
            kotlin.Unit r5 = kotlin.Unit.f50853a
            return r5
        L57:
            r5 = move-exception
            r0 = r4
        L59:
            boolean r1 = r0.cancellationRequested
            if (r1 == 0) goto L69
            boolean r1 = r0.isActive()
            if (r1 != 0) goto L69
            java.util.concurrent.CancellationException r1 = r0.I()
            if (r5 == r1) goto L7a
        L69:
            org.reactivestreams.Subscriber<? super T> r1 = r0.f51854i     // Catch: java.lang.Throwable -> L6f
            r1.onError(r5)     // Catch: java.lang.Throwable -> L6f
            goto L7a
        L6f:
            r1 = move-exception
            kotlin.ExceptionsKt.a(r5, r1)
            kotlin.coroutines.CoroutineContext r0 = r0.j()
            kotlinx.coroutines.CoroutineExceptionHandlerKt.a(r0, r5)
        L7a:
            kotlin.Unit r5 = kotlin.Unit.f50853a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.FlowSubscription.n1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.cancellationRequested = true;
        e(null);
    }

    @Override // org.reactivestreams.Subscription
    public void f(long j8) {
        long j9;
        long j10;
        Continuation continuation;
        if (j8 <= 0) {
            return;
        }
        do {
            j9 = this.requested;
            j10 = j9 + j8;
            if (j10 <= 0) {
                j10 = Long.MAX_VALUE;
            }
        } while (!f51851j.compareAndSet(this, j9, j10));
        if (j9 <= 0) {
            do {
                continuation = (Continuation) f51852k.getAndSet(this, null);
            } while (continuation == null);
            Result.Companion companion = Result.f50818g;
            continuation.resumeWith(Result.b(Unit.f50853a));
        }
    }
}
