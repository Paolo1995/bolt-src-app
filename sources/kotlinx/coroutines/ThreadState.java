package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Interruptible.kt */
/* loaded from: classes5.dex */
final class ThreadState implements Function1<Throwable, Unit> {

    /* renamed from: i  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f51334i = AtomicIntegerFieldUpdater.newUpdater(ThreadState.class, "_state");

    /* renamed from: f  reason: collision with root package name */
    private final Job f51335f;

    /* renamed from: h  reason: collision with root package name */
    private DisposableHandle f51337h;
    private volatile /* synthetic */ int _state = 0;

    /* renamed from: g  reason: collision with root package name */
    private final Thread f51336g = Thread.currentThread();

    public ThreadState(Job job) {
        this.f51335f = job;
    }

    private final Void c(int i8) {
        throw new IllegalStateException(("Illegal state " + i8).toString());
    }

    public final void b() {
        while (true) {
            int i8 = this._state;
            if (i8 != 0) {
                if (i8 != 2) {
                    if (i8 == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        c(i8);
                        throw new KotlinNothingValueException();
                    }
                }
            } else if (f51334i.compareAndSet(this, i8, 1)) {
                DisposableHandle disposableHandle = this.f51337h;
                if (disposableHandle != null) {
                    disposableHandle.dispose();
                    return;
                }
                return;
            }
        }
    }

    public void d(Throwable th) {
        int i8;
        do {
            i8 = this._state;
            if (i8 != 0) {
                if (i8 != 1 && i8 != 2 && i8 != 3) {
                    c(i8);
                    throw new KotlinNothingValueException();
                }
                return;
            }
        } while (!f51334i.compareAndSet(this, i8, 2));
        this.f51336g.interrupt();
        this._state = 3;
    }

    public final void e() {
        int i8;
        this.f51337h = this.f51335f.F(true, true, this);
        do {
            i8 = this._state;
            if (i8 != 0) {
                if (i8 != 2 && i8 != 3) {
                    c(i8);
                    throw new KotlinNothingValueException();
                }
                return;
            }
        } while (!f51334i.compareAndSet(this, i8, 0));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        d(th);
        return Unit.f50853a;
    }
}
