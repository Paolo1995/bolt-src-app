package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* loaded from: classes.dex */
public class Trackers {

    /* renamed from: e  reason: collision with root package name */
    private static Trackers f8550e;

    /* renamed from: a  reason: collision with root package name */
    private BatteryChargingTracker f8551a;

    /* renamed from: b  reason: collision with root package name */
    private BatteryNotLowTracker f8552b;

    /* renamed from: c  reason: collision with root package name */
    private NetworkStateTracker f8553c;

    /* renamed from: d  reason: collision with root package name */
    private StorageNotLowTracker f8554d;

    private Trackers(@NonNull Context context, @NonNull TaskExecutor taskExecutor) {
        Context applicationContext = context.getApplicationContext();
        this.f8551a = new BatteryChargingTracker(applicationContext, taskExecutor);
        this.f8552b = new BatteryNotLowTracker(applicationContext, taskExecutor);
        this.f8553c = new NetworkStateTracker(applicationContext, taskExecutor);
        this.f8554d = new StorageNotLowTracker(applicationContext, taskExecutor);
    }

    @NonNull
    public static synchronized Trackers c(Context context, TaskExecutor taskExecutor) {
        Trackers trackers;
        synchronized (Trackers.class) {
            if (f8550e == null) {
                f8550e = new Trackers(context, taskExecutor);
            }
            trackers = f8550e;
        }
        return trackers;
    }

    @NonNull
    public BatteryChargingTracker a() {
        return this.f8551a;
    }

    @NonNull
    public BatteryNotLowTracker b() {
        return this.f8552b;
    }

    @NonNull
    public NetworkStateTracker d() {
        return this.f8553c;
    }

    @NonNull
    public StorageNotLowTracker e() {
        return this.f8554d;
    }
}
