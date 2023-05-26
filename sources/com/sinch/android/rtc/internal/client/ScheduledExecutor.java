package com.sinch.android.rtc.internal.client;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public interface ScheduledExecutor extends Executor {
    ScheduledFuture<?> schedule(Runnable runnable, long j8, TimeUnit timeUnit);
}
