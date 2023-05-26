package kotlinx.coroutines.rx2;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.rx2.SchedulerCoroutineDispatcher;

/* compiled from: RxScheduler.kt */
/* loaded from: classes5.dex */
public final class SchedulerCoroutineDispatcher extends CoroutineDispatcher implements Delay {

    /* renamed from: h  reason: collision with root package name */
    private final Scheduler f51922h;

    public SchedulerCoroutineDispatcher(Scheduler scheduler) {
        this.f51922h = scheduler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(Disposable disposable) {
        disposable.dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(CancellableContinuation cancellableContinuation, SchedulerCoroutineDispatcher schedulerCoroutineDispatcher) {
        cancellableContinuation.C(schedulerCoroutineDispatcher, Unit.f50853a);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void G0(CoroutineContext coroutineContext, Runnable runnable) {
        this.f51922h.d(runnable);
    }

    @Override // kotlinx.coroutines.Delay
    public DisposableHandle Y(long j8, Runnable runnable, CoroutineContext coroutineContext) {
        final Disposable e8 = this.f51922h.e(runnable, j8, TimeUnit.MILLISECONDS);
        return new DisposableHandle() { // from class: o7.e
            @Override // kotlinx.coroutines.DisposableHandle
            public final void dispose() {
                SchedulerCoroutineDispatcher.U0(Disposable.this);
            }
        };
    }

    public boolean equals(Object obj) {
        if ((obj instanceof SchedulerCoroutineDispatcher) && ((SchedulerCoroutineDispatcher) obj).f51922h == this.f51922h) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return System.identityHashCode(this.f51922h);
    }

    @Override // kotlinx.coroutines.Delay
    public void j(long j8, final CancellableContinuation<? super Unit> cancellableContinuation) {
        RxAwaitKt.f(cancellableContinuation, this.f51922h.e(new Runnable() { // from class: o7.f
            @Override // java.lang.Runnable
            public final void run() {
                SchedulerCoroutineDispatcher.W0(CancellableContinuation.this, this);
            }
        }, j8, TimeUnit.MILLISECONDS));
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return this.f51922h.toString();
    }
}
