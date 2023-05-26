package androidx.work.impl.background.systemalarm;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.Logger;
import androidx.work.impl.Scheduler;
import androidx.work.impl.model.WorkSpec;

/* loaded from: classes.dex */
public class SystemAlarmScheduler implements Scheduler {

    /* renamed from: g  reason: collision with root package name */
    private static final String f8500g = Logger.f("SystemAlarmScheduler");

    /* renamed from: f  reason: collision with root package name */
    private final Context f8501f;

    public SystemAlarmScheduler(@NonNull Context context) {
        this.f8501f = context.getApplicationContext();
    }

    private void b(@NonNull WorkSpec workSpec) {
        Logger.c().a(f8500g, String.format("Scheduling work with workSpecId %s", workSpec.f8618a), new Throwable[0]);
        this.f8501f.startService(CommandHandler.f(this.f8501f, workSpec.f8618a));
    }

    @Override // androidx.work.impl.Scheduler
    public void a(@NonNull WorkSpec... workSpecArr) {
        for (WorkSpec workSpec : workSpecArr) {
            b(workSpec);
        }
    }

    @Override // androidx.work.impl.Scheduler
    public boolean c() {
        return true;
    }

    @Override // androidx.work.impl.Scheduler
    public void cancel(@NonNull String str) {
        this.f8501f.startService(CommandHandler.g(this.f8501f, str));
    }
}
