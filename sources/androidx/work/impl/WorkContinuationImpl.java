package androidx.work.impl;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.WorkContinuation;
import androidx.work.WorkRequest;
import androidx.work.impl.utils.EnqueueRunnable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class WorkContinuationImpl extends WorkContinuation {

    /* renamed from: j  reason: collision with root package name */
    private static final String f8363j = Logger.f("WorkContinuationImpl");

    /* renamed from: a  reason: collision with root package name */
    private final WorkManagerImpl f8364a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8365b;

    /* renamed from: c  reason: collision with root package name */
    private final ExistingWorkPolicy f8366c;

    /* renamed from: d  reason: collision with root package name */
    private final List<? extends WorkRequest> f8367d;

    /* renamed from: e  reason: collision with root package name */
    private final List<String> f8368e;

    /* renamed from: f  reason: collision with root package name */
    private final List<String> f8369f;

    /* renamed from: g  reason: collision with root package name */
    private final List<WorkContinuationImpl> f8370g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f8371h;

    /* renamed from: i  reason: collision with root package name */
    private Operation f8372i;

    public WorkContinuationImpl(@NonNull WorkManagerImpl workManagerImpl, @NonNull List<? extends WorkRequest> list) {
        this(workManagerImpl, null, ExistingWorkPolicy.KEEP, list, null);
    }

    private static boolean i(@NonNull WorkContinuationImpl workContinuationImpl, @NonNull Set<String> set) {
        set.addAll(workContinuationImpl.c());
        Set<String> l8 = l(workContinuationImpl);
        for (String str : set) {
            if (l8.contains(str)) {
                return true;
            }
        }
        List<WorkContinuationImpl> e8 = workContinuationImpl.e();
        if (e8 != null && !e8.isEmpty()) {
            for (WorkContinuationImpl workContinuationImpl2 : e8) {
                if (i(workContinuationImpl2, set)) {
                    return true;
                }
            }
        }
        set.removeAll(workContinuationImpl.c());
        return false;
    }

    @NonNull
    public static Set<String> l(WorkContinuationImpl workContinuationImpl) {
        HashSet hashSet = new HashSet();
        List<WorkContinuationImpl> e8 = workContinuationImpl.e();
        if (e8 != null && !e8.isEmpty()) {
            for (WorkContinuationImpl workContinuationImpl2 : e8) {
                hashSet.addAll(workContinuationImpl2.c());
            }
        }
        return hashSet;
    }

    @NonNull
    public Operation a() {
        if (!this.f8371h) {
            EnqueueRunnable enqueueRunnable = new EnqueueRunnable(this);
            this.f8364a.p().b(enqueueRunnable);
            this.f8372i = enqueueRunnable.d();
        } else {
            Logger.c().h(f8363j, String.format("Already enqueued work ids (%s)", TextUtils.join(", ", this.f8368e)), new Throwable[0]);
        }
        return this.f8372i;
    }

    public ExistingWorkPolicy b() {
        return this.f8366c;
    }

    @NonNull
    public List<String> c() {
        return this.f8368e;
    }

    public String d() {
        return this.f8365b;
    }

    public List<WorkContinuationImpl> e() {
        return this.f8370g;
    }

    @NonNull
    public List<? extends WorkRequest> f() {
        return this.f8367d;
    }

    @NonNull
    public WorkManagerImpl g() {
        return this.f8364a;
    }

    public boolean h() {
        return i(this, new HashSet());
    }

    public boolean j() {
        return this.f8371h;
    }

    public void k() {
        this.f8371h = true;
    }

    public WorkContinuationImpl(@NonNull WorkManagerImpl workManagerImpl, String str, @NonNull ExistingWorkPolicy existingWorkPolicy, @NonNull List<? extends WorkRequest> list, List<WorkContinuationImpl> list2) {
        this.f8364a = workManagerImpl;
        this.f8365b = str;
        this.f8366c = existingWorkPolicy;
        this.f8367d = list;
        this.f8370g = list2;
        this.f8368e = new ArrayList(list.size());
        this.f8369f = new ArrayList();
        if (list2 != null) {
            for (WorkContinuationImpl workContinuationImpl : list2) {
                this.f8369f.addAll(workContinuationImpl.f8369f);
            }
        }
        for (int i8 = 0; i8 < list.size(); i8++) {
            String a8 = list.get(i8).a();
            this.f8368e.add(a8);
            this.f8369f.add(a8);
        }
    }
}
