package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpecDao;

/* loaded from: classes.dex */
public class StopWorkRunnable implements Runnable {

    /* renamed from: i  reason: collision with root package name */
    private static final String f8702i = Logger.f("StopWorkRunnable");

    /* renamed from: f  reason: collision with root package name */
    private final WorkManagerImpl f8703f;

    /* renamed from: g  reason: collision with root package name */
    private final String f8704g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f8705h;

    public StopWorkRunnable(@NonNull WorkManagerImpl workManagerImpl, @NonNull String str, boolean z7) {
        this.f8703f = workManagerImpl;
        this.f8704g = str;
        this.f8705h = z7;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean o8;
        WorkDatabase o9 = this.f8703f.o();
        Processor m8 = this.f8703f.m();
        WorkSpecDao P = o9.P();
        o9.e();
        try {
            boolean h8 = m8.h(this.f8704g);
            if (this.f8705h) {
                o8 = this.f8703f.m().n(this.f8704g);
            } else {
                if (!h8 && P.g(this.f8704g) == WorkInfo.State.RUNNING) {
                    P.a(WorkInfo.State.ENQUEUED, this.f8704g);
                }
                o8 = this.f8703f.m().o(this.f8704g);
            }
            Logger.c().a(f8702i, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", this.f8704g, Boolean.valueOf(o8)), new Throwable[0]);
            o9.E();
        } finally {
            o9.i();
        }
    }
}
