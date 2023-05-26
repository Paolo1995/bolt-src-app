package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* loaded from: classes.dex */
public abstract class BroadcastReceiverConstraintTracker<T> extends ConstraintTracker<T> {

    /* renamed from: h  reason: collision with root package name */
    private static final String f8532h = Logger.f("BrdcstRcvrCnstrntTrckr");

    /* renamed from: g  reason: collision with root package name */
    private final BroadcastReceiver f8533g;

    public BroadcastReceiverConstraintTracker(@NonNull Context context, @NonNull TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        this.f8533g = new BroadcastReceiver() { // from class: androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (intent != null) {
                    BroadcastReceiverConstraintTracker.this.h(context2, intent);
                }
            }
        };
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void e() {
        Logger.c().a(f8532h, String.format("%s: registering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.f8537b.registerReceiver(this.f8533g, g());
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void f() {
        Logger.c().a(f8532h, String.format("%s: unregistering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.f8537b.unregisterReceiver(this.f8533g);
    }

    public abstract IntentFilter g();

    public abstract void h(Context context, @NonNull Intent intent);
}
