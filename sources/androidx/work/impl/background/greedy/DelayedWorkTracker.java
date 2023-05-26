package androidx.work.impl.background.greedy;

import androidx.annotation.NonNull;
import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.model.WorkSpec;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class DelayedWorkTracker {

    /* renamed from: d  reason: collision with root package name */
    static final String f8442d = Logger.f("DelayedWorkTracker");

    /* renamed from: a  reason: collision with root package name */
    final GreedyScheduler f8443a;

    /* renamed from: b  reason: collision with root package name */
    private final RunnableScheduler f8444b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Runnable> f8445c = new HashMap();

    public DelayedWorkTracker(@NonNull GreedyScheduler greedyScheduler, @NonNull RunnableScheduler runnableScheduler) {
        this.f8443a = greedyScheduler;
        this.f8444b = runnableScheduler;
    }

    public void a(@NonNull final WorkSpec workSpec) {
        Runnable remove = this.f8445c.remove(workSpec.f8618a);
        if (remove != null) {
            this.f8444b.a(remove);
        }
        Runnable runnable = new Runnable() { // from class: androidx.work.impl.background.greedy.DelayedWorkTracker.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.c().a(DelayedWorkTracker.f8442d, String.format("Scheduling work %s", workSpec.f8618a), new Throwable[0]);
                DelayedWorkTracker.this.f8443a.a(workSpec);
            }
        };
        this.f8445c.put(workSpec.f8618a, runnable);
        long currentTimeMillis = System.currentTimeMillis();
        this.f8444b.b(workSpec.a() - currentTimeMillis, runnable);
    }

    public void b(@NonNull String str) {
        Runnable remove = this.f8445c.remove(str);
        if (remove != null) {
            this.f8444b.a(remove);
        }
    }
}
