package com.hivemq.client.internal.util;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes3.dex */
public final class ExecutorUtil {
    private ExecutorUtil() {
    }

    public static boolean a(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
            return true;
        } catch (RejectedExecutionException unused) {
            return false;
        }
    }
}
