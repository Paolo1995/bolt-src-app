package kotlinx.coroutines;

import kotlinx.coroutines.internal.ArrayQueue;
import kotlinx.coroutines.internal.LimitedDispatcherKt;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes5.dex */
public abstract class EventLoop extends CoroutineDispatcher {

    /* renamed from: h  reason: collision with root package name */
    private long f51270h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f51271i;

    /* renamed from: j  reason: collision with root package name */
    private ArrayQueue<DispatchedTask<?>> f51272j;

    public static /* synthetic */ void S0(EventLoop eventLoop, boolean z7, int i8, Object obj) {
        if (obj == null) {
            if ((i8 & 1) != 0) {
                z7 = false;
            }
            eventLoop.R0(z7);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }

    private final long U0(boolean z7) {
        return z7 ? 4294967296L : 1L;
    }

    public static /* synthetic */ void c1(EventLoop eventLoop, boolean z7, int i8, Object obj) {
        if (obj == null) {
            if ((i8 & 1) != 0) {
                z7 = false;
            }
            eventLoop.b1(z7);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher P0(int i8) {
        LimitedDispatcherKt.a(i8);
        return this;
    }

    public final void R0(boolean z7) {
        long U0 = this.f51270h - U0(z7);
        this.f51270h = U0;
        if (U0 <= 0 && this.f51271i) {
            shutdown();
        }
    }

    public final void W0(DispatchedTask<?> dispatchedTask) {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.f51272j;
        if (arrayQueue == null) {
            arrayQueue = new ArrayQueue<>();
            this.f51272j = arrayQueue;
        }
        arrayQueue.a(dispatchedTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long Z0() {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.f51272j;
        if (arrayQueue == null || arrayQueue.c()) {
            return Long.MAX_VALUE;
        }
        return 0L;
    }

    public final void b1(boolean z7) {
        this.f51270h += U0(z7);
        if (!z7) {
            this.f51271i = true;
        }
    }

    public final boolean f1() {
        if (this.f51270h >= U0(true)) {
            return true;
        }
        return false;
    }

    public final boolean h1() {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.f51272j;
        if (arrayQueue != null) {
            return arrayQueue.c();
        }
        return true;
    }

    public long l1() {
        if (!m1()) {
            return Long.MAX_VALUE;
        }
        return 0L;
    }

    public final boolean m1() {
        DispatchedTask<?> d8;
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.f51272j;
        if (arrayQueue == null || (d8 = arrayQueue.d()) == null) {
            return false;
        }
        d8.run();
        return true;
    }

    public boolean n1() {
        return false;
    }

    public void shutdown() {
    }
}
