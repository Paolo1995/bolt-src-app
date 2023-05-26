package androidx.work.impl.utils;

import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;

/* loaded from: classes.dex */
public class StartWorkRunnable implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private WorkManagerImpl f8699f;

    /* renamed from: g  reason: collision with root package name */
    private String f8700g;

    /* renamed from: h  reason: collision with root package name */
    private WorkerParameters.RuntimeExtras f8701h;

    public StartWorkRunnable(WorkManagerImpl workManagerImpl, String str, WorkerParameters.RuntimeExtras runtimeExtras) {
        this.f8699f = workManagerImpl;
        this.f8700g = str;
        this.f8701h = runtimeExtras;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f8699f.m().k(this.f8700g, this.f8701h);
    }
}
