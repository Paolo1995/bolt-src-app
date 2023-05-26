package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.kt */
/* loaded from: classes5.dex */
public final class BlockingCoroutine<T> extends AbstractCoroutine<T> {

    /* renamed from: h  reason: collision with root package name */
    private final Thread f51215h;

    /* renamed from: i  reason: collision with root package name */
    private final EventLoop f51216i;

    public BlockingCoroutine(CoroutineContext coroutineContext, Thread thread, EventLoop eventLoop) {
        super(coroutineContext, true, true);
        this.f51215h = thread;
        this.f51216i = eventLoop;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.JobSupport
    public void M(Object obj) {
        Unit unit;
        if (!Intrinsics.a(Thread.currentThread(), this.f51215h)) {
            Thread thread = this.f51215h;
            AbstractTimeSource a8 = AbstractTimeSourceKt.a();
            if (a8 != null) {
                a8.f(thread);
                unit = Unit.f50853a;
            } else {
                unit = null;
            }
            if (unit == null) {
                LockSupport.unpark(thread);
            }
        }
    }

    public final T k1() {
        long j8;
        Unit unit;
        AbstractTimeSource a8 = AbstractTimeSourceKt.a();
        if (a8 != null) {
            a8.c();
        }
        try {
            EventLoop eventLoop = this.f51216i;
            CompletedExceptionally completedExceptionally = null;
            if (eventLoop != null) {
                EventLoop.c1(eventLoop, false, 1, null);
            }
            while (!Thread.interrupted()) {
                EventLoop eventLoop2 = this.f51216i;
                if (eventLoop2 != null) {
                    j8 = eventLoop2.l1();
                } else {
                    j8 = Long.MAX_VALUE;
                }
                if (!c()) {
                    AbstractTimeSource a9 = AbstractTimeSourceKt.a();
                    if (a9 != null) {
                        a9.b(this, j8);
                        unit = Unit.f50853a;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        LockSupport.parkNanos(this, j8);
                    }
                } else {
                    EventLoop eventLoop3 = this.f51216i;
                    if (eventLoop3 != null) {
                        EventLoop.S0(eventLoop3, false, 1, null);
                    }
                    T t7 = (T) JobSupportKt.h(r0());
                    if (t7 instanceof CompletedExceptionally) {
                        completedExceptionally = (CompletedExceptionally) t7;
                    }
                    if (completedExceptionally == null) {
                        return t7;
                    }
                    throw completedExceptionally.f51234a;
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            R(interruptedException);
            throw interruptedException;
        } finally {
            AbstractTimeSource a10 = AbstractTimeSourceKt.a();
            if (a10 != null) {
                a10.g();
            }
        }
    }

    @Override // kotlinx.coroutines.JobSupport
    protected boolean x0() {
        return true;
    }
}
