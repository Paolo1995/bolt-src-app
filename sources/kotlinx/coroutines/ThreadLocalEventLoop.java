package kotlinx.coroutines;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes5.dex */
public final class ThreadLocalEventLoop {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocalEventLoop f51332a = new ThreadLocalEventLoop();

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<EventLoop> f51333b = new ThreadLocal<>();

    private ThreadLocalEventLoop() {
    }

    public final EventLoop a() {
        return f51333b.get();
    }

    public final EventLoop b() {
        ThreadLocal<EventLoop> threadLocal = f51333b;
        EventLoop eventLoop = threadLocal.get();
        if (eventLoop == null) {
            EventLoop a8 = EventLoopKt.a();
            threadLocal.set(a8);
            return a8;
        }
        return eventLoop;
    }

    public final void c() {
        f51333b.set(null);
    }

    public final void d(EventLoop eventLoop) {
        f51333b.set(eventLoop);
    }
}
