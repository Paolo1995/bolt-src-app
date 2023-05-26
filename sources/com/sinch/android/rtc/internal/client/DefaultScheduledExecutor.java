package com.sinch.android.rtc.internal.client;

import androidx.annotation.NonNull;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class DefaultScheduledExecutor implements ScheduledExecutor {
    private final ScheduledExecutorService mExecutor = Executors.newSingleThreadScheduledExecutor();

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.mExecutor.execute(runnable);
    }

    @Override // com.sinch.android.rtc.internal.client.ScheduledExecutor
    public ScheduledFuture<?> schedule(Runnable runnable, long j8, TimeUnit timeUnit) {
        return this.mExecutor.schedule(runnable, j8, timeUnit);
    }
}
