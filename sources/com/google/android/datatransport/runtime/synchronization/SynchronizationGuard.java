package com.google.android.datatransport.runtime.synchronization;

/* loaded from: classes.dex */
public interface SynchronizationGuard {

    /* loaded from: classes.dex */
    public interface CriticalSection<T> {
        T execute();
    }

    <T> T c(CriticalSection<T> criticalSection);
}
