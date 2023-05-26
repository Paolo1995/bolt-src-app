package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlinx.coroutines.EventLoopImplBase;

/* compiled from: EventLoop.kt */
/* loaded from: classes5.dex */
public abstract class EventLoopImplPlatform extends EventLoop {
    protected abstract Thread o1();

    /* JADX INFO: Access modifiers changed from: protected */
    public void p1(long j8, EventLoopImplBase.DelayedTask delayedTask) {
        DefaultExecutor.f51254m.z1(j8, delayedTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q1() {
        Unit unit;
        Thread o12 = o1();
        if (Thread.currentThread() != o12) {
            AbstractTimeSource a8 = AbstractTimeSourceKt.a();
            if (a8 != null) {
                a8.f(o12);
                unit = Unit.f50853a;
            } else {
                unit = null;
            }
            if (unit == null) {
                LockSupport.unpark(o12);
            }
        }
    }
}
