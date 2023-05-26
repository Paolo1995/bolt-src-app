package com.google.android.gms.internal.cloudmessaging;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes.dex */
public interface zzb {
    ExecutorService zza(ThreadFactory threadFactory, int i8);

    ScheduledExecutorService zza(int i8, ThreadFactory threadFactory, int i9);
}
