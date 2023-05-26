package io.reactivex.internal.schedulers;

import androidx.camera.view.e;
import io.reactivex.functions.Function;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class SchedulerPoolFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49734a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f49735b;

    /* renamed from: c  reason: collision with root package name */
    static final AtomicReference<ScheduledExecutorService> f49736c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    static final Map<ScheduledThreadPoolExecutor, Object> f49737d = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ScheduledTask implements Runnable {
        ScheduledTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(SchedulerPoolFactory.f49737d.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    SchedulerPoolFactory.f49737d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class SystemPropertyAccessor implements Function<String, String> {
        SystemPropertyAccessor() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public String apply(String str) throws Exception {
            return System.getProperty(str);
        }
    }

    static {
        SystemPropertyAccessor systemPropertyAccessor = new SystemPropertyAccessor();
        boolean b8 = b(true, "rx2.purge-enabled", true, true, systemPropertyAccessor);
        f49734a = b8;
        f49735b = c(b8, "rx2.purge-period-seconds", 1, 1, systemPropertyAccessor);
        d();
    }

    private SchedulerPoolFactory() {
        throw new IllegalStateException("No instances!");
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        e(f49734a, newScheduledThreadPool);
        return newScheduledThreadPool;
    }

    static boolean b(boolean z7, String str, boolean z8, boolean z9, Function<String, String> function) {
        if (z7) {
            try {
                String apply = function.apply(str);
                if (apply == null) {
                    return z8;
                }
                return "true".equals(apply);
            } catch (Throwable unused) {
                return z8;
            }
        }
        return z9;
    }

    static int c(boolean z7, String str, int i8, int i9, Function<String, String> function) {
        if (z7) {
            try {
                String apply = function.apply(str);
                if (apply == null) {
                    return i8;
                }
                return Integer.parseInt(apply);
            } catch (Throwable unused) {
                return i8;
            }
        }
        return i9;
    }

    public static void d() {
        f(f49734a);
    }

    static void e(boolean z7, ScheduledExecutorService scheduledExecutorService) {
        if (z7 && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f49737d.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    static void f(boolean z7) {
        if (!z7) {
            return;
        }
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = f49736c;
            ScheduledExecutorService scheduledExecutorService = atomicReference.get();
            if (scheduledExecutorService != null) {
                return;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
            if (e.a(atomicReference, scheduledExecutorService, newScheduledThreadPool)) {
                ScheduledTask scheduledTask = new ScheduledTask();
                int i8 = f49735b;
                newScheduledThreadPool.scheduleAtFixedRate(scheduledTask, i8, i8, TimeUnit.SECONDS);
                return;
            }
            newScheduledThreadPool.shutdownNow();
        }
    }
}
