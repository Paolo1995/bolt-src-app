package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;

/* loaded from: classes5.dex */
final class FastThreadLocalRunnable implements Runnable {
    private final Runnable runnable;

    private FastThreadLocalRunnable(Runnable runnable) {
        this.runnable = (Runnable) ObjectUtil.checkNotNull(runnable, "runnable");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable wrap(Runnable runnable) {
        if (!(runnable instanceof FastThreadLocalRunnable)) {
            return new FastThreadLocalRunnable(runnable);
        }
        return runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.runnable.run();
        } finally {
            FastThreadLocal.removeAll();
        }
    }
}
