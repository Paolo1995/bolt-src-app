package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.SerialExecutor;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class SystemAlarmDispatcher implements ExecutionListener {

    /* renamed from: p  reason: collision with root package name */
    static final String f8484p = Logger.f("SystemAlarmDispatcher");

    /* renamed from: f  reason: collision with root package name */
    final Context f8485f;

    /* renamed from: g  reason: collision with root package name */
    private final TaskExecutor f8486g;

    /* renamed from: h  reason: collision with root package name */
    private final WorkTimer f8487h;

    /* renamed from: i  reason: collision with root package name */
    private final Processor f8488i;

    /* renamed from: j  reason: collision with root package name */
    private final WorkManagerImpl f8489j;

    /* renamed from: k  reason: collision with root package name */
    final CommandHandler f8490k;

    /* renamed from: l  reason: collision with root package name */
    private final Handler f8491l;

    /* renamed from: m  reason: collision with root package name */
    final List<Intent> f8492m;

    /* renamed from: n  reason: collision with root package name */
    Intent f8493n;

    /* renamed from: o  reason: collision with root package name */
    private CommandsCompletedListener f8494o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AddRunnable implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private final SystemAlarmDispatcher f8496f;

        /* renamed from: g  reason: collision with root package name */
        private final Intent f8497g;

        /* renamed from: h  reason: collision with root package name */
        private final int f8498h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AddRunnable(@NonNull SystemAlarmDispatcher systemAlarmDispatcher, @NonNull Intent intent, int i8) {
            this.f8496f = systemAlarmDispatcher;
            this.f8497g = intent;
            this.f8498h = i8;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8496f.a(this.f8497g, this.f8498h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface CommandsCompletedListener {
        void b();
    }

    /* loaded from: classes.dex */
    static class DequeueAndCheckForCompletion implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private final SystemAlarmDispatcher f8499f;

        DequeueAndCheckForCompletion(@NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
            this.f8499f = systemAlarmDispatcher;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8499f.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SystemAlarmDispatcher(@NonNull Context context) {
        this(context, null, null);
    }

    private void b() {
        if (this.f8491l.getLooper().getThread() == Thread.currentThread()) {
            return;
        }
        throw new IllegalStateException("Needs to be invoked on the main thread.");
    }

    private boolean i(@NonNull String str) {
        b();
        synchronized (this.f8492m) {
            for (Intent intent : this.f8492m) {
                if (str.equals(intent.getAction())) {
                    return true;
                }
            }
            return false;
        }
    }

    private void l() {
        b();
        PowerManager.WakeLock b8 = WakeLocks.b(this.f8485f, "ProcessCommand");
        try {
            b8.acquire();
            this.f8489j.p().b(new Runnable() { // from class: androidx.work.impl.background.systemalarm.SystemAlarmDispatcher.1
                @Override // java.lang.Runnable
                public void run() {
                    SystemAlarmDispatcher systemAlarmDispatcher;
                    DequeueAndCheckForCompletion dequeueAndCheckForCompletion;
                    synchronized (SystemAlarmDispatcher.this.f8492m) {
                        SystemAlarmDispatcher systemAlarmDispatcher2 = SystemAlarmDispatcher.this;
                        systemAlarmDispatcher2.f8493n = systemAlarmDispatcher2.f8492m.get(0);
                    }
                    Intent intent = SystemAlarmDispatcher.this.f8493n;
                    if (intent != null) {
                        String action = intent.getAction();
                        int intExtra = SystemAlarmDispatcher.this.f8493n.getIntExtra("KEY_START_ID", 0);
                        Logger c8 = Logger.c();
                        String str = SystemAlarmDispatcher.f8484p;
                        c8.a(str, String.format("Processing command %s, %s", SystemAlarmDispatcher.this.f8493n, Integer.valueOf(intExtra)), new Throwable[0]);
                        PowerManager.WakeLock b9 = WakeLocks.b(SystemAlarmDispatcher.this.f8485f, String.format("%s (%s)", action, Integer.valueOf(intExtra)));
                        try {
                            Logger.c().a(str, String.format("Acquiring operation wake lock (%s) %s", action, b9), new Throwable[0]);
                            b9.acquire();
                            SystemAlarmDispatcher systemAlarmDispatcher3 = SystemAlarmDispatcher.this;
                            systemAlarmDispatcher3.f8490k.p(systemAlarmDispatcher3.f8493n, intExtra, systemAlarmDispatcher3);
                            Logger.c().a(str, String.format("Releasing operation wake lock (%s) %s", action, b9), new Throwable[0]);
                            b9.release();
                            systemAlarmDispatcher = SystemAlarmDispatcher.this;
                            dequeueAndCheckForCompletion = new DequeueAndCheckForCompletion(systemAlarmDispatcher);
                        } catch (Throwable th) {
                            try {
                                Logger c9 = Logger.c();
                                String str2 = SystemAlarmDispatcher.f8484p;
                                c9.b(str2, "Unexpected error in onHandleIntent", th);
                                Logger.c().a(str2, String.format("Releasing operation wake lock (%s) %s", action, b9), new Throwable[0]);
                                b9.release();
                                systemAlarmDispatcher = SystemAlarmDispatcher.this;
                                dequeueAndCheckForCompletion = new DequeueAndCheckForCompletion(systemAlarmDispatcher);
                            } catch (Throwable th2) {
                                Logger.c().a(SystemAlarmDispatcher.f8484p, String.format("Releasing operation wake lock (%s) %s", action, b9), new Throwable[0]);
                                b9.release();
                                SystemAlarmDispatcher systemAlarmDispatcher4 = SystemAlarmDispatcher.this;
                                systemAlarmDispatcher4.k(new DequeueAndCheckForCompletion(systemAlarmDispatcher4));
                                throw th2;
                            }
                        }
                        systemAlarmDispatcher.k(dequeueAndCheckForCompletion);
                    }
                }
            });
        } finally {
            b8.release();
        }
    }

    public boolean a(@NonNull Intent intent, int i8) {
        Logger c8 = Logger.c();
        String str = f8484p;
        boolean z7 = false;
        c8.a(str, String.format("Adding command %s (%s)", intent, Integer.valueOf(i8)), new Throwable[0]);
        b();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            Logger.c().h(str, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        } else if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && i("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        } else {
            intent.putExtra("KEY_START_ID", i8);
            synchronized (this.f8492m) {
                if (!this.f8492m.isEmpty()) {
                    z7 = true;
                }
                this.f8492m.add(intent);
                if (!z7) {
                    l();
                }
            }
            return true;
        }
    }

    void c() {
        Logger c8 = Logger.c();
        String str = f8484p;
        c8.a(str, "Checking if commands are complete.", new Throwable[0]);
        b();
        synchronized (this.f8492m) {
            if (this.f8493n != null) {
                Logger.c().a(str, String.format("Removing command %s", this.f8493n), new Throwable[0]);
                if (this.f8492m.remove(0).equals(this.f8493n)) {
                    this.f8493n = null;
                } else {
                    throw new IllegalStateException("Dequeue-d command is not the first.");
                }
            }
            SerialExecutor c9 = this.f8486g.c();
            if (!this.f8490k.o() && this.f8492m.isEmpty() && !c9.a()) {
                Logger.c().a(str, "No more commands & intents.", new Throwable[0]);
                CommandsCompletedListener commandsCompletedListener = this.f8494o;
                if (commandsCompletedListener != null) {
                    commandsCompletedListener.b();
                }
            } else if (!this.f8492m.isEmpty()) {
                l();
            }
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public void d(@NonNull String str, boolean z7) {
        k(new AddRunnable(this, CommandHandler.c(this.f8485f, str, z7), 0));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Processor e() {
        return this.f8488i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TaskExecutor f() {
        return this.f8486g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WorkManagerImpl g() {
        return this.f8489j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WorkTimer h() {
        return this.f8487h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        Logger.c().a(f8484p, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.f8488i.i(this);
        this.f8487h.a();
        this.f8494o = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(@NonNull Runnable runnable) {
        this.f8491l.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(@NonNull CommandsCompletedListener commandsCompletedListener) {
        if (this.f8494o != null) {
            Logger.c().b(f8484p, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            this.f8494o = commandsCompletedListener;
        }
    }

    SystemAlarmDispatcher(@NonNull Context context, Processor processor, WorkManagerImpl workManagerImpl) {
        Context applicationContext = context.getApplicationContext();
        this.f8485f = applicationContext;
        this.f8490k = new CommandHandler(applicationContext);
        this.f8487h = new WorkTimer();
        workManagerImpl = workManagerImpl == null ? WorkManagerImpl.k(context) : workManagerImpl;
        this.f8489j = workManagerImpl;
        processor = processor == null ? workManagerImpl.m() : processor;
        this.f8488i = processor;
        this.f8486g = workManagerImpl.p();
        processor.c(this);
        this.f8492m = new ArrayList();
        this.f8493n = null;
        this.f8491l = new Handler(Looper.getMainLooper());
    }
}
