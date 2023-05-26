package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.utils.WakeLocks;

/* loaded from: classes.dex */
public class SystemAlarmService extends LifecycleService implements SystemAlarmDispatcher.CommandsCompletedListener {

    /* renamed from: i  reason: collision with root package name */
    private static final String f8502i = Logger.f("SystemAlarmService");

    /* renamed from: g  reason: collision with root package name */
    private SystemAlarmDispatcher f8503g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f8504h;

    private void e() {
        SystemAlarmDispatcher systemAlarmDispatcher = new SystemAlarmDispatcher(this);
        this.f8503g = systemAlarmDispatcher;
        systemAlarmDispatcher.m(this);
    }

    @Override // androidx.work.impl.background.systemalarm.SystemAlarmDispatcher.CommandsCompletedListener
    public void b() {
        this.f8504h = true;
        Logger.c().a(f8502i, "All commands completed in dispatcher", new Throwable[0]);
        WakeLocks.a();
        stopSelf();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        e();
        this.f8504h = false;
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f8504h = true;
        this.f8503g.j();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(Intent intent, int i8, int i9) {
        super.onStartCommand(intent, i8, i9);
        if (this.f8504h) {
            Logger.c().d(f8502i, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.f8503g.j();
            e();
            this.f8504h = false;
        }
        if (intent != null) {
            this.f8503g.a(intent, i9);
            return 3;
        }
        return 3;
    }
}
