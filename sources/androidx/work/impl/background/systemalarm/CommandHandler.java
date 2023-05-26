package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.model.WorkSpec;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class CommandHandler implements ExecutionListener {

    /* renamed from: i  reason: collision with root package name */
    private static final String f8458i = Logger.f("CommandHandler");

    /* renamed from: f  reason: collision with root package name */
    private final Context f8459f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, ExecutionListener> f8460g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private final Object f8461h = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public CommandHandler(@NonNull Context context) {
        this.f8459f = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent a(@NonNull Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent b(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent c(@NonNull Context context, @NonNull String str, boolean z7) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z7);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent e(@NonNull Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_RESCHEDULE");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent f(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent g(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    private void h(@NonNull Intent intent, int i8, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        Logger.c().a(f8458i, String.format("Handling constraints changed %s", intent), new Throwable[0]);
        new ConstraintsCommandHandler(this.f8459f, i8, systemAlarmDispatcher).a();
    }

    private void i(@NonNull Intent intent, int i8, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        Bundle extras = intent.getExtras();
        synchronized (this.f8461h) {
            String string = extras.getString("KEY_WORKSPEC_ID");
            Logger c8 = Logger.c();
            String str = f8458i;
            c8.a(str, String.format("Handing delay met for %s", string), new Throwable[0]);
            if (!this.f8460g.containsKey(string)) {
                DelayMetCommandHandler delayMetCommandHandler = new DelayMetCommandHandler(this.f8459f, i8, string, systemAlarmDispatcher);
                this.f8460g.put(string, delayMetCommandHandler);
                delayMetCommandHandler.f();
            } else {
                Logger.c().a(str, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", string), new Throwable[0]);
            }
        }
    }

    private void j(@NonNull Intent intent, int i8) {
        Bundle extras = intent.getExtras();
        String string = extras.getString("KEY_WORKSPEC_ID");
        boolean z7 = extras.getBoolean("KEY_NEEDS_RESCHEDULE");
        Logger.c().a(f8458i, String.format("Handling onExecutionCompleted %s, %s", intent, Integer.valueOf(i8)), new Throwable[0]);
        d(string, z7);
    }

    private void k(@NonNull Intent intent, int i8, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        Logger.c().a(f8458i, String.format("Handling reschedule %s, %s", intent, Integer.valueOf(i8)), new Throwable[0]);
        systemAlarmDispatcher.g().s();
    }

    private void l(@NonNull Intent intent, int i8, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        Logger c8 = Logger.c();
        String str = f8458i;
        c8.a(str, String.format("Handling schedule work for %s", string), new Throwable[0]);
        WorkDatabase o8 = systemAlarmDispatcher.g().o();
        o8.e();
        try {
            WorkSpec h8 = o8.P().h(string);
            if (h8 == null) {
                Logger c9 = Logger.c();
                c9.h(str, "Skipping scheduling " + string + " because it's no longer in the DB", new Throwable[0]);
            } else if (h8.f8619b.a()) {
                Logger c10 = Logger.c();
                c10.h(str, "Skipping scheduling " + string + "because it is finished.", new Throwable[0]);
            } else {
                long a8 = h8.a();
                if (!h8.b()) {
                    Logger.c().a(str, String.format("Setting up Alarms for %s at %s", string, Long.valueOf(a8)), new Throwable[0]);
                    Alarms.c(this.f8459f, systemAlarmDispatcher.g(), string, a8);
                } else {
                    Logger.c().a(str, String.format("Opportunistically setting an alarm for %s at %s", string, Long.valueOf(a8)), new Throwable[0]);
                    Alarms.c(this.f8459f, systemAlarmDispatcher.g(), string, a8);
                    systemAlarmDispatcher.k(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher, a(this.f8459f), i8));
                }
                o8.E();
            }
        } finally {
            o8.i();
        }
    }

    private void m(@NonNull Intent intent, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        Logger.c().a(f8458i, String.format("Handing stopWork work for %s", string), new Throwable[0]);
        systemAlarmDispatcher.g().x(string);
        Alarms.a(this.f8459f, systemAlarmDispatcher.g(), string);
        systemAlarmDispatcher.d(string, false);
    }

    private static boolean n(Bundle bundle, @NonNull String... strArr) {
        if (bundle == null || bundle.isEmpty()) {
            return false;
        }
        for (String str : strArr) {
            if (bundle.get(str) == null) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.work.impl.ExecutionListener
    public void d(@NonNull String str, boolean z7) {
        synchronized (this.f8461h) {
            ExecutionListener remove = this.f8460g.remove(str);
            if (remove != null) {
                remove.d(str, z7);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o() {
        boolean z7;
        synchronized (this.f8461h) {
            if (!this.f8460g.isEmpty()) {
                z7 = true;
            } else {
                z7 = false;
            }
        }
        return z7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(@NonNull Intent intent, int i8, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            h(intent, i8, systemAlarmDispatcher);
        } else if ("ACTION_RESCHEDULE".equals(action)) {
            k(intent, i8, systemAlarmDispatcher);
        } else if (!n(intent.getExtras(), "KEY_WORKSPEC_ID")) {
            Logger.c().b(f8458i, String.format("Invalid request for %s, requires %s.", action, "KEY_WORKSPEC_ID"), new Throwable[0]);
        } else if ("ACTION_SCHEDULE_WORK".equals(action)) {
            l(intent, i8, systemAlarmDispatcher);
        } else if ("ACTION_DELAY_MET".equals(action)) {
            i(intent, i8, systemAlarmDispatcher);
        } else if ("ACTION_STOP_WORK".equals(action)) {
            m(intent, systemAlarmDispatcher);
        } else if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
            j(intent, i8);
        } else {
            Logger.c().h(f8458i, String.format("Ignoring intent %s", intent), new Throwable[0]);
        }
    }
}
