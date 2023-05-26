package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpecDao;
import java.util.LinkedList;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class CancelWorkRunnable implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private final OperationImpl f8672f = new OperationImpl();

    public static CancelWorkRunnable b(@NonNull final UUID uuid, @NonNull final WorkManagerImpl workManagerImpl) {
        return new CancelWorkRunnable() { // from class: androidx.work.impl.utils.CancelWorkRunnable.1
            @Override // androidx.work.impl.utils.CancelWorkRunnable
            void h() {
                WorkDatabase o8 = WorkManagerImpl.this.o();
                o8.e();
                try {
                    a(WorkManagerImpl.this, uuid.toString());
                    o8.E();
                    o8.i();
                    g(WorkManagerImpl.this);
                } catch (Throwable th) {
                    o8.i();
                    throw th;
                }
            }
        };
    }

    public static CancelWorkRunnable c(@NonNull final String str, @NonNull final WorkManagerImpl workManagerImpl, final boolean z7) {
        return new CancelWorkRunnable() { // from class: androidx.work.impl.utils.CancelWorkRunnable.3
            @Override // androidx.work.impl.utils.CancelWorkRunnable
            void h() {
                WorkDatabase o8 = WorkManagerImpl.this.o();
                o8.e();
                try {
                    for (String str2 : o8.P().f(str)) {
                        a(WorkManagerImpl.this, str2);
                    }
                    o8.E();
                    o8.i();
                    if (z7) {
                        g(WorkManagerImpl.this);
                    }
                } catch (Throwable th) {
                    o8.i();
                    throw th;
                }
            }
        };
    }

    public static CancelWorkRunnable d(@NonNull final String str, @NonNull final WorkManagerImpl workManagerImpl) {
        return new CancelWorkRunnable() { // from class: androidx.work.impl.utils.CancelWorkRunnable.2
            @Override // androidx.work.impl.utils.CancelWorkRunnable
            void h() {
                WorkDatabase o8 = WorkManagerImpl.this.o();
                o8.e();
                try {
                    for (String str2 : o8.P().i(str)) {
                        a(WorkManagerImpl.this, str2);
                    }
                    o8.E();
                    o8.i();
                    g(WorkManagerImpl.this);
                } catch (Throwable th) {
                    o8.i();
                    throw th;
                }
            }
        };
    }

    private void f(WorkDatabase workDatabase, String str) {
        WorkSpecDao P = workDatabase.P();
        DependencyDao H = workDatabase.H();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            WorkInfo.State g8 = P.g(str2);
            if (g8 != WorkInfo.State.SUCCEEDED && g8 != WorkInfo.State.FAILED) {
                P.a(WorkInfo.State.CANCELLED, str2);
            }
            linkedList.addAll(H.b(str2));
        }
    }

    void a(WorkManagerImpl workManagerImpl, String str) {
        f(workManagerImpl.o(), str);
        workManagerImpl.m().l(str);
        for (Scheduler scheduler : workManagerImpl.n()) {
            scheduler.cancel(str);
        }
    }

    public Operation e() {
        return this.f8672f;
    }

    void g(WorkManagerImpl workManagerImpl) {
        Schedulers.b(workManagerImpl.i(), workManagerImpl.o(), workManagerImpl.n());
    }

    abstract void h();

    @Override // java.lang.Runnable
    public void run() {
        try {
            h();
            this.f8672f.a(Operation.f8300a);
        } catch (Throwable th) {
            this.f8672f.a(new Operation.State.FAILURE(th));
        }
    }
}
