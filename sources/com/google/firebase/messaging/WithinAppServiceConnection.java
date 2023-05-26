package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.messaging.WithinAppServiceConnection;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes3.dex */
class WithinAppServiceConnection implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final Context f16633a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f16634b;

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledExecutorService f16635c;

    /* renamed from: d  reason: collision with root package name */
    private final Queue<BindRequest> f16636d;

    /* renamed from: e  reason: collision with root package name */
    private WithinAppServiceBinder f16637e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16638f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    /* loaded from: classes3.dex */
    public static class BindRequest {

        /* renamed from: a  reason: collision with root package name */
        final Intent f16641a;

        /* renamed from: b  reason: collision with root package name */
        private final TaskCompletionSource<Void> f16642b = new TaskCompletionSource<>();

        BindRequest(Intent intent) {
            this.f16641a = intent;
        }

        void a(ScheduledExecutorService scheduledExecutorService) {
            final ScheduledFuture<?> schedule = scheduledExecutorService.schedule(new Runnable(this) { // from class: com.google.firebase.messaging.WithinAppServiceConnection$BindRequest$$Lambda$0

                /* renamed from: f  reason: collision with root package name */
                private final WithinAppServiceConnection.BindRequest f16639f;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f16639f = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f16639f.d();
                }
            }, 9000L, TimeUnit.MILLISECONDS);
            c().addOnCompleteListener(scheduledExecutorService, new OnCompleteListener(schedule) { // from class: com.google.firebase.messaging.WithinAppServiceConnection$BindRequest$$Lambda$1

                /* renamed from: a  reason: collision with root package name */
                private final ScheduledFuture f16640a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f16640a = schedule;
                }

                @Override // com.google.android.gms.tasks.OnCompleteListener
                public void onComplete(Task task) {
                    this.f16640a.cancel(false);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b() {
            this.f16642b.trySetResult(null);
        }

        Task<Void> c() {
            return this.f16642b.getTask();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ void d() {
            String action = this.f16641a.getAction();
            StringBuilder sb = new StringBuilder(String.valueOf(action).length() + 61);
            sb.append("Service took too long to process intent: ");
            sb.append(action);
            sb.append(" App may get closed.");
            Log.w("FirebaseMessaging", sb.toString());
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WithinAppServiceConnection(Context context, String str) {
        this(context, "com.google.firebase.MESSAGING_EVENT", new ScheduledThreadPoolExecutor(0, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    private void a() {
        while (!this.f16636d.isEmpty()) {
            this.f16636d.poll().b();
        }
    }

    private synchronized void b() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "flush queue called");
        }
        while (!this.f16636d.isEmpty()) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "found intent to be delivered");
            }
            WithinAppServiceBinder withinAppServiceBinder = this.f16637e;
            if (withinAppServiceBinder != null && withinAppServiceBinder.isBinderAlive()) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "binder is alive, sending the intent.");
                }
                this.f16637e.b(this.f16636d.poll());
            } else {
                d();
                return;
            }
        }
    }

    private void d() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            boolean z7 = this.f16638f;
            StringBuilder sb = new StringBuilder(39);
            sb.append("binder is dead. start connection? ");
            sb.append(!z7);
            Log.d("FirebaseMessaging", sb.toString());
        }
        if (this.f16638f) {
            return;
        }
        this.f16638f = true;
        try {
        } catch (SecurityException e8) {
            Log.e("FirebaseMessaging", "Exception while binding the service", e8);
        }
        if (ConnectionTracker.getInstance().bindService(this.f16633a, this.f16634b, this, 65)) {
            return;
        }
        Log.e("FirebaseMessaging", "binding to the service failed");
        this.f16638f = false;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Task<Void> c(Intent intent) {
        BindRequest bindRequest;
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "new intent queued in the bind-strategy delivery");
        }
        bindRequest = new BindRequest(intent);
        bindRequest.a(this.f16635c);
        this.f16636d.add(bindRequest);
        b();
        return bindRequest.c();
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(valueOf.length() + 20);
            sb.append("onServiceConnected: ");
            sb.append(valueOf);
            Log.d("FirebaseMessaging", sb.toString());
        }
        this.f16638f = false;
        if (!(iBinder instanceof WithinAppServiceBinder)) {
            String valueOf2 = String.valueOf(iBinder);
            StringBuilder sb2 = new StringBuilder(valueOf2.length() + 28);
            sb2.append("Invalid service connection: ");
            sb2.append(valueOf2);
            Log.e("FirebaseMessaging", sb2.toString());
            a();
            return;
        }
        this.f16637e = (WithinAppServiceBinder) iBinder;
        b();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(valueOf.length() + 23);
            sb.append("onServiceDisconnected: ");
            sb.append(valueOf);
            Log.d("FirebaseMessaging", sb.toString());
        }
        b();
    }

    WithinAppServiceConnection(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f16636d = new ArrayDeque();
        this.f16638f = false;
        Context applicationContext = context.getApplicationContext();
        this.f16633a = applicationContext;
        this.f16634b = new Intent("com.google.firebase.MESSAGING_EVENT").setPackage(applicationContext.getPackageName());
        this.f16635c = scheduledExecutorService;
    }
}
