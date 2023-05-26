package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.logging.Logging;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
class SafeLoggingExecutor implements Executor {

    /* renamed from: f  reason: collision with root package name */
    private final Executor f12104f;

    /* loaded from: classes.dex */
    static class SafeLoggingRunnable implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private final Runnable f12105f;

        SafeLoggingRunnable(Runnable runnable) {
            this.f12105f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f12105f.run();
            } catch (Exception e8) {
                Logging.d("Executor", "Background execution failure.", e8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SafeLoggingExecutor(Executor executor) {
        this.f12104f = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f12104f.execute(new SafeLoggingRunnable(runnable));
    }
}
