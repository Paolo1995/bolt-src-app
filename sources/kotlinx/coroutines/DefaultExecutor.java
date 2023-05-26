package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.EventLoopImplBase;

/* compiled from: DefaultExecutor.kt */
/* loaded from: classes5.dex */
public final class DefaultExecutor extends EventLoopImplBase implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: m  reason: collision with root package name */
    public static final DefaultExecutor f51254m;

    /* renamed from: n  reason: collision with root package name */
    private static final long f51255n;

    static {
        Long l8;
        DefaultExecutor defaultExecutor = new DefaultExecutor();
        f51254m = defaultExecutor;
        EventLoop.c1(defaultExecutor, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l8 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l8 = 1000L;
        }
        f51255n = timeUnit.toNanos(l8.longValue());
    }

    private DefaultExecutor() {
    }

    private final synchronized void E1() {
        if (!H1()) {
            return;
        }
        debugStatus = 3;
        y1();
        notifyAll();
    }

    private final synchronized Thread F1() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final boolean G1() {
        if (debugStatus == 4) {
            return true;
        }
        return false;
    }

    private final boolean H1() {
        int i8 = debugStatus;
        if (i8 != 2 && i8 != 3) {
            return false;
        }
        return true;
    }

    private final synchronized boolean I1() {
        if (H1()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    private final void J1() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // kotlinx.coroutines.EventLoopImplBase, kotlinx.coroutines.Delay
    public DisposableHandle Y(long j8, Runnable runnable, CoroutineContext coroutineContext) {
        return B1(j8, runnable);
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    protected Thread o1() {
        Thread thread = _thread;
        if (thread == null) {
            return F1();
        }
        return thread;
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    protected void p1(long j8, EventLoopImplBase.DelayedTask delayedTask) {
        J1();
    }

    @Override // java.lang.Runnable
    public void run() {
        Unit unit;
        long nanoTime;
        boolean w12;
        ThreadLocalEventLoop.f51332a.d(this);
        AbstractTimeSource a8 = AbstractTimeSourceKt.a();
        if (a8 != null) {
            a8.c();
        }
        try {
            if (!I1()) {
                if (!w12) {
                    return;
                }
                return;
            }
            long j8 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long l12 = l1();
                if (l12 == Long.MAX_VALUE) {
                    AbstractTimeSource a9 = AbstractTimeSourceKt.a();
                    if (a9 != null) {
                        nanoTime = a9.a();
                    } else {
                        nanoTime = System.nanoTime();
                    }
                    if (j8 == Long.MAX_VALUE) {
                        j8 = f51255n + nanoTime;
                    }
                    long j9 = j8 - nanoTime;
                    if (j9 <= 0) {
                        _thread = null;
                        E1();
                        AbstractTimeSource a10 = AbstractTimeSourceKt.a();
                        if (a10 != null) {
                            a10.g();
                        }
                        if (!w1()) {
                            o1();
                            return;
                        }
                        return;
                    }
                    l12 = RangesKt___RangesKt.h(l12, j9);
                } else {
                    j8 = Long.MAX_VALUE;
                }
                if (l12 > 0) {
                    if (H1()) {
                        _thread = null;
                        E1();
                        AbstractTimeSource a11 = AbstractTimeSourceKt.a();
                        if (a11 != null) {
                            a11.g();
                        }
                        if (!w1()) {
                            o1();
                            return;
                        }
                        return;
                    }
                    AbstractTimeSource a12 = AbstractTimeSourceKt.a();
                    if (a12 != null) {
                        a12.b(this, l12);
                        unit = Unit.f50853a;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        LockSupport.parkNanos(this, l12);
                    }
                }
            }
        } finally {
            _thread = null;
            E1();
            AbstractTimeSource a13 = AbstractTimeSourceKt.a();
            if (a13 != null) {
                a13.g();
            }
            if (!w1()) {
                o1();
            }
        }
    }

    @Override // kotlinx.coroutines.EventLoopImplBase, kotlinx.coroutines.EventLoop
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // kotlinx.coroutines.EventLoopImplBase
    public void u1(Runnable runnable) {
        if (G1()) {
            J1();
        }
        super.u1(runnable);
    }
}
