package kotlinx.coroutines.internal;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;

/* compiled from: LimitedDispatcher.kt */
/* loaded from: classes5.dex */
public final class LimitedDispatcher extends CoroutineDispatcher implements Runnable, Delay {

    /* renamed from: h  reason: collision with root package name */
    private final CoroutineDispatcher f51791h;

    /* renamed from: i  reason: collision with root package name */
    private final int f51792i;

    /* renamed from: j  reason: collision with root package name */
    private final /* synthetic */ Delay f51793j;

    /* renamed from: k  reason: collision with root package name */
    private final LockFreeTaskQueue<Runnable> f51794k;

    /* renamed from: l  reason: collision with root package name */
    private final Object f51795l;
    private volatile int runningWorkers;

    public LimitedDispatcher(CoroutineDispatcher coroutineDispatcher, int i8) {
        Delay delay;
        this.f51791h = coroutineDispatcher;
        this.f51792i = i8;
        if (coroutineDispatcher instanceof Delay) {
            delay = (Delay) coroutineDispatcher;
        } else {
            delay = null;
        }
        this.f51793j = delay == null ? DefaultExecutorKt.a() : delay;
        this.f51794k = new LockFreeTaskQueue<>(false);
        this.f51795l = new Object();
    }

    private final boolean R0(Runnable runnable) {
        this.f51794k.a(runnable);
        if (this.runningWorkers >= this.f51792i) {
            return true;
        }
        return false;
    }

    private final boolean S0() {
        synchronized (this.f51795l) {
            if (this.runningWorkers >= this.f51792i) {
                return false;
            }
            this.runningWorkers++;
            return true;
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void G0(CoroutineContext coroutineContext, Runnable runnable) {
        if (!R0(runnable) && S0()) {
            this.f51791h.G0(this, this);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void I0(CoroutineContext coroutineContext, Runnable runnable) {
        if (!R0(runnable) && S0()) {
            this.f51791h.I0(this, this);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher P0(int i8) {
        LimitedDispatcherKt.a(i8);
        if (i8 >= this.f51792i) {
            return this;
        }
        return super.P0(i8);
    }

    @Override // kotlinx.coroutines.Delay
    public DisposableHandle Y(long j8, Runnable runnable, CoroutineContext coroutineContext) {
        return this.f51793j.Y(j8, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.Delay
    public void j(long j8, CancellableContinuation<? super Unit> cancellableContinuation) {
        this.f51793j.j(j8, cancellableContinuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
        r1 = r4.f51795l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
        monitor-enter(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
        r4.runningWorkers--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
        if (r4.f51794k.c() != 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
        monitor-exit(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
        r4.runningWorkers++;
        r2 = kotlin.Unit.f50853a;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r4 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            kotlinx.coroutines.internal.LockFreeTaskQueue<java.lang.Runnable> r2 = r4.f51794k
            java.lang.Object r2 = r2.d()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            if (r2 == 0) goto L2a
            r2.run()     // Catch: java.lang.Throwable -> L10
            goto L16
        L10:
            r2 = move-exception
            kotlin.coroutines.EmptyCoroutineContext r3 = kotlin.coroutines.EmptyCoroutineContext.f50912f
            kotlinx.coroutines.CoroutineExceptionHandlerKt.a(r3, r2)
        L16:
            int r1 = r1 + 1
            r2 = 16
            if (r1 < r2) goto L2
            kotlinx.coroutines.CoroutineDispatcher r2 = r4.f51791h
            boolean r2 = r2.K0(r4)
            if (r2 == 0) goto L2
            kotlinx.coroutines.CoroutineDispatcher r0 = r4.f51791h
            r0.G0(r4, r4)
            return
        L2a:
            java.lang.Object r1 = r4.f51795l
            monitor-enter(r1)
            int r2 = r4.runningWorkers     // Catch: java.lang.Throwable -> L47
            int r2 = r2 + (-1)
            r4.runningWorkers = r2     // Catch: java.lang.Throwable -> L47
            kotlinx.coroutines.internal.LockFreeTaskQueue<java.lang.Runnable> r2 = r4.f51794k     // Catch: java.lang.Throwable -> L47
            int r2 = r2.c()     // Catch: java.lang.Throwable -> L47
            if (r2 != 0) goto L3d
            monitor-exit(r1)
            return
        L3d:
            int r2 = r4.runningWorkers     // Catch: java.lang.Throwable -> L47
            int r2 = r2 + 1
            r4.runningWorkers = r2     // Catch: java.lang.Throwable -> L47
            kotlin.Unit r2 = kotlin.Unit.f50853a     // Catch: java.lang.Throwable -> L47
            monitor-exit(r1)
            goto L1
        L47:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LimitedDispatcher.run():void");
    }
}
