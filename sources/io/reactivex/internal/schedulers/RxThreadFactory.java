package io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes5.dex */
public final class RxThreadFactory extends AtomicLong implements ThreadFactory {

    /* renamed from: f  reason: collision with root package name */
    final String f49726f;

    /* renamed from: g  reason: collision with root package name */
    final int f49727g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f49728h;

    /* loaded from: classes5.dex */
    static final class RxCustomThread extends Thread implements NonBlockingThread {
        RxCustomThread(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public RxThreadFactory(String str) {
        this(str, 5, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread;
        String str = this.f49726f + '-' + incrementAndGet();
        if (this.f49728h) {
            thread = new RxCustomThread(runnable, str);
        } else {
            thread = new Thread(runnable, str);
        }
        thread.setPriority(this.f49727g);
        thread.setDaemon(true);
        return thread;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.f49726f + "]";
    }

    public RxThreadFactory(String str, int i8) {
        this(str, i8, false);
    }

    public RxThreadFactory(String str, int i8, boolean z7) {
        this.f49726f = str;
        this.f49727g = i8;
        this.f49728h = z7;
    }
}
