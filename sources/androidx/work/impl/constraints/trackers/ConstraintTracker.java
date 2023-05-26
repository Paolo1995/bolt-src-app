package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class ConstraintTracker<T> {

    /* renamed from: f  reason: collision with root package name */
    private static final String f8535f = Logger.f("ConstraintTracker");

    /* renamed from: a  reason: collision with root package name */
    protected final TaskExecutor f8536a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f8537b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f8538c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private final Set<ConstraintListener<T>> f8539d = new LinkedHashSet();

    /* renamed from: e  reason: collision with root package name */
    T f8540e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConstraintTracker(@NonNull Context context, @NonNull TaskExecutor taskExecutor) {
        this.f8537b = context.getApplicationContext();
        this.f8536a = taskExecutor;
    }

    public void a(ConstraintListener<T> constraintListener) {
        synchronized (this.f8538c) {
            if (this.f8539d.add(constraintListener)) {
                if (this.f8539d.size() == 1) {
                    this.f8540e = b();
                    Logger.c().a(f8535f, String.format("%s: initial state = %s", getClass().getSimpleName(), this.f8540e), new Throwable[0]);
                    e();
                }
                constraintListener.a(this.f8540e);
            }
        }
    }

    public abstract T b();

    public void c(ConstraintListener<T> constraintListener) {
        synchronized (this.f8538c) {
            if (this.f8539d.remove(constraintListener) && this.f8539d.isEmpty()) {
                f();
            }
        }
    }

    public void d(T t7) {
        synchronized (this.f8538c) {
            T t8 = this.f8540e;
            if (t8 != t7 && (t8 == null || !t8.equals(t7))) {
                this.f8540e = t7;
                final ArrayList arrayList = new ArrayList(this.f8539d);
                this.f8536a.a().execute(new Runnable() { // from class: androidx.work.impl.constraints.trackers.ConstraintTracker.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (ConstraintListener constraintListener : arrayList) {
                            constraintListener.a(ConstraintTracker.this.f8540e);
                        }
                    }
                });
            }
        }
    }

    public abstract void e();

    public abstract void f();
}
