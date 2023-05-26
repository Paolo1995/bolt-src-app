package kotlinx.coroutines;

/* compiled from: EventLoop.kt */
/* loaded from: classes5.dex */
public final class BlockingEventLoop extends EventLoopImplBase {

    /* renamed from: m  reason: collision with root package name */
    private final Thread f51217m;

    public BlockingEventLoop(Thread thread) {
        this.f51217m = thread;
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    protected Thread o1() {
        return this.f51217m;
    }
}
