package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ConstraintsCommandHandler {

    /* renamed from: e  reason: collision with root package name */
    private static final String f8468e = Logger.f("ConstraintsCmdHandler");

    /* renamed from: a  reason: collision with root package name */
    private final Context f8469a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8470b;

    /* renamed from: c  reason: collision with root package name */
    private final SystemAlarmDispatcher f8471c;

    /* renamed from: d  reason: collision with root package name */
    private final WorkConstraintsTracker f8472d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConstraintsCommandHandler(@NonNull Context context, int i8, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        this.f8469a = context;
        this.f8470b = i8;
        this.f8471c = systemAlarmDispatcher;
        this.f8472d = new WorkConstraintsTracker(context, systemAlarmDispatcher.f(), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        List<WorkSpec> e8 = this.f8471c.g().o().P().e();
        ConstraintProxy.a(this.f8469a, e8);
        this.f8472d.d(e8);
        ArrayList<WorkSpec> arrayList = new ArrayList(e8.size());
        long currentTimeMillis = System.currentTimeMillis();
        for (WorkSpec workSpec : e8) {
            String str = workSpec.f8618a;
            if (currentTimeMillis >= workSpec.a() && (!workSpec.b() || this.f8472d.c(str))) {
                arrayList.add(workSpec);
            }
        }
        for (WorkSpec workSpec2 : arrayList) {
            String str2 = workSpec2.f8618a;
            Intent b8 = CommandHandler.b(this.f8469a, str2);
            Logger.c().a(f8468e, String.format("Creating a delay_met command for workSpec with id (%s)", str2), new Throwable[0]);
            SystemAlarmDispatcher systemAlarmDispatcher = this.f8471c;
            systemAlarmDispatcher.k(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher, b8, this.f8470b));
        }
        this.f8472d.e();
    }
}
