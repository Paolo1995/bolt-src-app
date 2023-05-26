package eu.bolt.verification.sdk.internal;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class ic implements ThreadFactory {

    /* renamed from: f  reason: collision with root package name */
    private final AtomicInteger f43561f;

    /* renamed from: g  reason: collision with root package name */
    private final String f43562g;

    /* renamed from: h  reason: collision with root package name */
    private final ThreadFactory f43563h;

    public ic(String poolName) {
        Intrinsics.f(poolName, "poolName");
        this.f43561f = new AtomicInteger(1);
        this.f43562g = poolName + '-';
        this.f43563h = Executors.defaultThreadFactory();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r7) {
        Intrinsics.f(r7, "r");
        Thread newThread = this.f43563h.newThread(r7);
        newThread.setName(this.f43562g + this.f43561f.getAndIncrement());
        Intrinsics.e(newThread, "realFactory.newThread(r)…tAndIncrement()\n        }");
        return newThread;
    }
}
