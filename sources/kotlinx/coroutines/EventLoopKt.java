package kotlinx.coroutines;

/* compiled from: EventLoop.kt */
/* loaded from: classes5.dex */
public final class EventLoopKt {
    public static final EventLoop a() {
        return new BlockingEventLoop(Thread.currentThread());
    }

    public static final long b() {
        EventLoop a8 = ThreadLocalEventLoop.f51332a.a();
        if (a8 != null) {
            return a8.l1();
        }
        return Long.MAX_VALUE;
    }
}
