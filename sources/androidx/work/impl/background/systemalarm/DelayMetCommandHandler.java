package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class DelayMetCommandHandler implements WorkConstraintsCallback, ExecutionListener, WorkTimer.TimeLimitExceededListener {

    /* renamed from: o  reason: collision with root package name */
    private static final String f8473o = Logger.f("DelayMetCommandHandler");

    /* renamed from: f  reason: collision with root package name */
    private final Context f8474f;

    /* renamed from: g  reason: collision with root package name */
    private final int f8475g;

    /* renamed from: h  reason: collision with root package name */
    private final String f8476h;

    /* renamed from: i  reason: collision with root package name */
    private final SystemAlarmDispatcher f8477i;

    /* renamed from: j  reason: collision with root package name */
    private final WorkConstraintsTracker f8478j;

    /* renamed from: m  reason: collision with root package name */
    private PowerManager.WakeLock f8481m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f8482n = false;

    /* renamed from: l  reason: collision with root package name */
    private int f8480l = 0;

    /* renamed from: k  reason: collision with root package name */
    private final Object f8479k = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public DelayMetCommandHandler(@NonNull Context context, int i8, @NonNull String str, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        this.f8474f = context;
        this.f8475g = i8;
        this.f8477i = systemAlarmDispatcher;
        this.f8476h = str;
        this.f8478j = new WorkConstraintsTracker(context, systemAlarmDispatcher.f(), this);
    }

    private void c() {
        synchronized (this.f8479k) {
            this.f8478j.e();
            this.f8477i.h().c(this.f8476h);
            PowerManager.WakeLock wakeLock = this.f8481m;
            if (wakeLock != null && wakeLock.isHeld()) {
                Logger.c().a(f8473o, String.format("Releasing wakelock %s for WorkSpec %s", this.f8481m, this.f8476h), new Throwable[0]);
                this.f8481m.release();
            }
        }
    }

    private void g() {
        synchronized (this.f8479k) {
            if (this.f8480l < 2) {
                this.f8480l = 2;
                Logger c8 = Logger.c();
                String str = f8473o;
                c8.a(str, String.format("Stopping work for WorkSpec %s", this.f8476h), new Throwable[0]);
                Intent g8 = CommandHandler.g(this.f8474f, this.f8476h);
                SystemAlarmDispatcher systemAlarmDispatcher = this.f8477i;
                systemAlarmDispatcher.k(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher, g8, this.f8475g));
                if (this.f8477i.e().g(this.f8476h)) {
                    Logger.c().a(str, String.format("WorkSpec %s needs to be rescheduled", this.f8476h), new Throwable[0]);
                    Intent f8 = CommandHandler.f(this.f8474f, this.f8476h);
                    SystemAlarmDispatcher systemAlarmDispatcher2 = this.f8477i;
                    systemAlarmDispatcher2.k(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher2, f8, this.f8475g));
                } else {
                    Logger.c().a(str, String.format("Processor does not have WorkSpec %s. No need to reschedule ", this.f8476h), new Throwable[0]);
                }
            } else {
                Logger.c().a(f8473o, String.format("Already stopped work for %s", this.f8476h), new Throwable[0]);
            }
        }
    }

    @Override // androidx.work.impl.utils.WorkTimer.TimeLimitExceededListener
    public void a(@NonNull String str) {
        Logger.c().a(f8473o, String.format("Exceeded time limits on execution for %s", str), new Throwable[0]);
        g();
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void b(@NonNull List<String> list) {
        g();
    }

    @Override // androidx.work.impl.ExecutionListener
    public void d(@NonNull String str, boolean z7) {
        Logger.c().a(f8473o, String.format("onExecuted %s, %s", str, Boolean.valueOf(z7)), new Throwable[0]);
        c();
        if (z7) {
            Intent f8 = CommandHandler.f(this.f8474f, this.f8476h);
            SystemAlarmDispatcher systemAlarmDispatcher = this.f8477i;
            systemAlarmDispatcher.k(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher, f8, this.f8475g));
        }
        if (this.f8482n) {
            Intent a8 = CommandHandler.a(this.f8474f);
            SystemAlarmDispatcher systemAlarmDispatcher2 = this.f8477i;
            systemAlarmDispatcher2.k(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher2, a8, this.f8475g));
        }
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void e(@NonNull List<String> list) {
        if (!list.contains(this.f8476h)) {
            return;
        }
        synchronized (this.f8479k) {
            if (this.f8480l == 0) {
                this.f8480l = 1;
                Logger.c().a(f8473o, String.format("onAllConstraintsMet for %s", this.f8476h), new Throwable[0]);
                if (this.f8477i.e().j(this.f8476h)) {
                    this.f8477i.h().b(this.f8476h, 600000L, this);
                } else {
                    c();
                }
            } else {
                Logger.c().a(f8473o, String.format("Already started work for %s", this.f8476h), new Throwable[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f8481m = WakeLocks.b(this.f8474f, String.format("%s (%s)", this.f8476h, Integer.valueOf(this.f8475g)));
        Logger c8 = Logger.c();
        String str = f8473o;
        c8.a(str, String.format("Acquiring wakelock %s for WorkSpec %s", this.f8481m, this.f8476h), new Throwable[0]);
        this.f8481m.acquire();
        WorkSpec h8 = this.f8477i.g().o().P().h(this.f8476h);
        if (h8 == null) {
            g();
            return;
        }
        boolean b8 = h8.b();
        this.f8482n = b8;
        if (!b8) {
            Logger.c().a(str, String.format("No constraints for %s", this.f8476h), new Throwable[0]);
            e(Collections.singletonList(this.f8476h));
            return;
        }
        this.f8478j.d(Collections.singletonList(h8));
    }
}
