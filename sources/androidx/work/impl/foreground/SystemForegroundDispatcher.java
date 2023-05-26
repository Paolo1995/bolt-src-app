package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes.dex */
public class SystemForegroundDispatcher implements WorkConstraintsCallback, ExecutionListener {

    /* renamed from: p  reason: collision with root package name */
    static final String f8556p = Logger.f("SystemFgDispatcher");

    /* renamed from: f  reason: collision with root package name */
    private Context f8557f;

    /* renamed from: g  reason: collision with root package name */
    private WorkManagerImpl f8558g;

    /* renamed from: h  reason: collision with root package name */
    private final TaskExecutor f8559h;

    /* renamed from: i  reason: collision with root package name */
    final Object f8560i = new Object();

    /* renamed from: j  reason: collision with root package name */
    String f8561j;

    /* renamed from: k  reason: collision with root package name */
    final Map<String, ForegroundInfo> f8562k;

    /* renamed from: l  reason: collision with root package name */
    final Map<String, WorkSpec> f8563l;

    /* renamed from: m  reason: collision with root package name */
    final Set<WorkSpec> f8564m;

    /* renamed from: n  reason: collision with root package name */
    final WorkConstraintsTracker f8565n;

    /* renamed from: o  reason: collision with root package name */
    private Callback f8566o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface Callback {
        void a(int i8, @NonNull Notification notification);

        void c(int i8, int i9, @NonNull Notification notification);

        void d(int i8);

        void stop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SystemForegroundDispatcher(@NonNull Context context) {
        this.f8557f = context;
        WorkManagerImpl k8 = WorkManagerImpl.k(context);
        this.f8558g = k8;
        TaskExecutor p8 = k8.p();
        this.f8559h = p8;
        this.f8561j = null;
        this.f8562k = new LinkedHashMap();
        this.f8564m = new HashSet();
        this.f8563l = new HashMap();
        this.f8565n = new WorkConstraintsTracker(this.f8557f, p8, this);
        this.f8558g.m().c(this);
    }

    @NonNull
    public static Intent a(@NonNull Context context, @NonNull String str, @NonNull ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", foregroundInfo.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", foregroundInfo.a());
        intent.putExtra("KEY_NOTIFICATION", foregroundInfo.b());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    @NonNull
    public static Intent c(@NonNull Context context, @NonNull String str, @NonNull ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NOTIFICATION_ID", foregroundInfo.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", foregroundInfo.a());
        intent.putExtra("KEY_NOTIFICATION", foregroundInfo.b());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    @NonNull
    public static Intent f(@NonNull Context context) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_STOP_FOREGROUND");
        return intent;
    }

    private void g(@NonNull Intent intent) {
        Logger.c().d(f8556p, String.format("Stopping foreground work for %s", intent), new Throwable[0]);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra != null && !TextUtils.isEmpty(stringExtra)) {
            this.f8558g.f(UUID.fromString(stringExtra));
        }
    }

    private void h(@NonNull Intent intent) {
        int i8 = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        Logger.c().a(f8556p, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)), new Throwable[0]);
        if (notification != null && this.f8566o != null) {
            this.f8562k.put(stringExtra, new ForegroundInfo(intExtra, notification, intExtra2));
            if (TextUtils.isEmpty(this.f8561j)) {
                this.f8561j = stringExtra;
                this.f8566o.c(intExtra, intExtra2, notification);
                return;
            }
            this.f8566o.a(intExtra, notification);
            if (intExtra2 != 0 && Build.VERSION.SDK_INT >= 29) {
                for (Map.Entry<String, ForegroundInfo> entry : this.f8562k.entrySet()) {
                    i8 |= entry.getValue().a();
                }
                ForegroundInfo foregroundInfo = this.f8562k.get(this.f8561j);
                if (foregroundInfo != null) {
                    this.f8566o.c(foregroundInfo.c(), i8, foregroundInfo.b());
                }
            }
        }
    }

    private void i(@NonNull Intent intent) {
        Logger.c().d(f8556p, String.format("Started foreground service %s", intent), new Throwable[0]);
        final String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        final WorkDatabase o8 = this.f8558g.o();
        this.f8559h.b(new Runnable() { // from class: androidx.work.impl.foreground.SystemForegroundDispatcher.1
            @Override // java.lang.Runnable
            public void run() {
                WorkSpec h8 = o8.P().h(stringExtra);
                if (h8 != null && h8.b()) {
                    synchronized (SystemForegroundDispatcher.this.f8560i) {
                        SystemForegroundDispatcher.this.f8563l.put(stringExtra, h8);
                        SystemForegroundDispatcher.this.f8564m.add(h8);
                        SystemForegroundDispatcher systemForegroundDispatcher = SystemForegroundDispatcher.this;
                        systemForegroundDispatcher.f8565n.d(systemForegroundDispatcher.f8564m);
                    }
                }
            }
        });
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void b(@NonNull List<String> list) {
        if (!list.isEmpty()) {
            for (String str : list) {
                Logger.c().a(f8556p, String.format("Constraints unmet for WorkSpec %s", str), new Throwable[0]);
                this.f8558g.w(str);
            }
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public void d(@NonNull String str, boolean z7) {
        boolean z8;
        Map.Entry<String, ForegroundInfo> entry;
        synchronized (this.f8560i) {
            WorkSpec remove = this.f8563l.remove(str);
            if (remove != null) {
                z8 = this.f8564m.remove(remove);
            } else {
                z8 = false;
            }
            if (z8) {
                this.f8565n.d(this.f8564m);
            }
        }
        ForegroundInfo remove2 = this.f8562k.remove(str);
        if (str.equals(this.f8561j) && this.f8562k.size() > 0) {
            Iterator<Map.Entry<String, ForegroundInfo>> it = this.f8562k.entrySet().iterator();
            Map.Entry<String, ForegroundInfo> next = it.next();
            while (true) {
                entry = next;
                if (!it.hasNext()) {
                    break;
                }
                next = it.next();
            }
            this.f8561j = entry.getKey();
            if (this.f8566o != null) {
                ForegroundInfo value = entry.getValue();
                this.f8566o.c(value.c(), value.a(), value.b());
                this.f8566o.d(value.c());
            }
        }
        Callback callback = this.f8566o;
        if (remove2 != null && callback != null) {
            Logger.c().a(f8556p, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", Integer.valueOf(remove2.c()), str, Integer.valueOf(remove2.a())), new Throwable[0]);
            callback.d(remove2.c());
        }
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void e(@NonNull List<String> list) {
    }

    void j(@NonNull Intent intent) {
        Logger.c().d(f8556p, "Stopping foreground service", new Throwable[0]);
        Callback callback = this.f8566o;
        if (callback != null) {
            callback.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        this.f8566o = null;
        synchronized (this.f8560i) {
            this.f8565n.e();
        }
        this.f8558g.m().i(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(@NonNull Intent intent) {
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            i(intent);
            h(intent);
        } else if ("ACTION_NOTIFY".equals(action)) {
            h(intent);
        } else if ("ACTION_CANCEL_WORK".equals(action)) {
            g(intent);
        } else if ("ACTION_STOP_FOREGROUND".equals(action)) {
            j(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(@NonNull Callback callback) {
        if (this.f8566o != null) {
            Logger.c().b(f8556p, "A callback already exists.", new Throwable[0]);
        } else {
            this.f8566o = callback;
        }
    }
}
