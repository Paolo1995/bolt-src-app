package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.WithinAppServiceBinder;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
@SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
/* loaded from: classes3.dex */
public abstract class EnhancedIntentService extends Service {
    private Binder binder;
    private int lastStartId;
    final ExecutorService executor = FcmExecutors.c();
    private final Object lock = new Object();
    private int runningTasks = 0;

    private void finishTask(Intent intent) {
        if (intent != null) {
            WakeLockHolder.b(intent);
        }
        synchronized (this.lock) {
            int i8 = this.runningTasks - 1;
            this.runningTasks = i8;
            if (i8 == 0) {
                stopSelfResultHook(this.lastStartId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task<Void> processIntent(final Intent intent) {
        if (handleIntentOnMainThread(intent)) {
            return Tasks.forResult(null);
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.executor.execute(new Runnable(this, intent, taskCompletionSource) { // from class: com.google.firebase.messaging.EnhancedIntentService$$Lambda$0

            /* renamed from: f  reason: collision with root package name */
            private final EnhancedIntentService f16460f;

            /* renamed from: g  reason: collision with root package name */
            private final Intent f16461g;

            /* renamed from: h  reason: collision with root package name */
            private final TaskCompletionSource f16462h;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f16460f = this;
                this.f16461g = intent;
                this.f16462h = taskCompletionSource;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f16460f.lambda$processIntent$0$EnhancedIntentService(this.f16461g, this.f16462h);
            }
        });
        return taskCompletionSource.getTask();
    }

    protected Intent getStartCommandIntent(Intent intent) {
        return intent;
    }

    public abstract void handleIntent(Intent intent);

    public boolean handleIntentOnMainThread(Intent intent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$onStartCommand$1$EnhancedIntentService(Intent intent, Task task) {
        finishTask(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$processIntent$0$EnhancedIntentService(Intent intent, TaskCompletionSource taskCompletionSource) {
        try {
            handleIntent(intent);
        } finally {
            taskCompletionSource.setResult(null);
        }
    }

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "Service received bind request");
        }
        if (this.binder == null) {
            this.binder = new WithinAppServiceBinder(new WithinAppServiceBinder.IntentHandler() { // from class: com.google.firebase.messaging.EnhancedIntentService.1
                @Override // com.google.firebase.messaging.WithinAppServiceBinder.IntentHandler
                @KeepForSdk
                public Task<Void> a(Intent intent2) {
                    return EnhancedIntentService.this.processIntent(intent2);
                }
            });
        }
        return this.binder;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.executor.shutdown();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(final Intent intent, int i8, int i9) {
        synchronized (this.lock) {
            this.lastStartId = i9;
            this.runningTasks++;
        }
        Intent startCommandIntent = getStartCommandIntent(intent);
        if (startCommandIntent == null) {
            finishTask(intent);
            return 2;
        }
        Task<Void> processIntent = processIntent(startCommandIntent);
        if (processIntent.isComplete()) {
            finishTask(intent);
            return 2;
        }
        processIntent.addOnCompleteListener(EnhancedIntentService$$Lambda$1.f16463f, new OnCompleteListener(this, intent) { // from class: com.google.firebase.messaging.EnhancedIntentService$$Lambda$2

            /* renamed from: a  reason: collision with root package name */
            private final EnhancedIntentService f16464a;

            /* renamed from: b  reason: collision with root package name */
            private final Intent f16465b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f16464a = this;
                this.f16465b = intent;
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task task) {
                this.f16464a.lambda$onStartCommand$1$EnhancedIntentService(this.f16465b, task);
            }
        });
        return 3;
    }

    boolean stopSelfResultHook(int i8) {
        return stopSelfResult(i8);
    }
}
