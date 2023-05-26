package androidx.work.impl.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.foreground.SystemForegroundDispatcher;

/* loaded from: classes.dex */
public class SystemForegroundService extends LifecycleService implements SystemForegroundDispatcher.Callback {

    /* renamed from: k  reason: collision with root package name */
    private static final String f8570k = Logger.f("SystemFgService");

    /* renamed from: l  reason: collision with root package name */
    private static SystemForegroundService f8571l = null;

    /* renamed from: g  reason: collision with root package name */
    private Handler f8572g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f8573h;

    /* renamed from: i  reason: collision with root package name */
    SystemForegroundDispatcher f8574i;

    /* renamed from: j  reason: collision with root package name */
    NotificationManager f8575j;

    private void e() {
        this.f8572g = new Handler(Looper.getMainLooper());
        this.f8575j = (NotificationManager) getApplicationContext().getSystemService("notification");
        SystemForegroundDispatcher systemForegroundDispatcher = new SystemForegroundDispatcher(getApplicationContext());
        this.f8574i = systemForegroundDispatcher;
        systemForegroundDispatcher.m(this);
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void a(final int i8, @NonNull final Notification notification) {
        this.f8572g.post(new Runnable() { // from class: androidx.work.impl.foreground.SystemForegroundService.2
            @Override // java.lang.Runnable
            public void run() {
                SystemForegroundService.this.f8575j.notify(i8, notification);
            }
        });
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void c(final int i8, final int i9, @NonNull final Notification notification) {
        this.f8572g.post(new Runnable() { // from class: androidx.work.impl.foreground.SystemForegroundService.1
            @Override // java.lang.Runnable
            public void run() {
                if (Build.VERSION.SDK_INT >= 29) {
                    SystemForegroundService.this.startForeground(i8, notification, i9);
                } else {
                    SystemForegroundService.this.startForeground(i8, notification);
                }
            }
        });
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void d(final int i8) {
        this.f8572g.post(new Runnable() { // from class: androidx.work.impl.foreground.SystemForegroundService.3
            @Override // java.lang.Runnable
            public void run() {
                SystemForegroundService.this.f8575j.cancel(i8);
            }
        });
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        f8571l = this;
        e();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f8574i.k();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(Intent intent, int i8, int i9) {
        super.onStartCommand(intent, i8, i9);
        if (this.f8573h) {
            Logger.c().d(f8570k, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.f8574i.k();
            e();
            this.f8573h = false;
        }
        if (intent != null) {
            this.f8574i.l(intent);
            return 3;
        }
        return 3;
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void stop() {
        this.f8573h = true;
        Logger.c().a(f8570k, "All commands completed.", new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        f8571l = null;
        stopSelf();
    }
}
