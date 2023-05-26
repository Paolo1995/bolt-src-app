package ee.mtakso.driver.ui.utils;

import android.app.Activity;
import ee.mtakso.driver.utils.power.WakeLockManager;
import j$.util.Spliterator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowHelper.kt */
/* loaded from: classes5.dex */
public final class WindowHelperKt {
    public static final void a(Activity activity) {
        Intrinsics.f(activity, "activity");
        activity.getWindow().addFlags(Spliterator.IMMUTABLE);
        activity.getWindow().getDecorView().setSystemUiVisibility(4102);
    }

    public static final void b(Activity activity) {
        Intrinsics.f(activity, "activity");
        activity.getWindow().addFlags(4194304);
        activity.getWindow().addFlags(524288);
        activity.getWindow().addFlags(2097152);
    }

    public static final void c(Activity activity, long j8) {
        Intrinsics.f(activity, "activity");
        new WakeLockManager(activity).c(26, "driverapp:incoming_order", j8);
    }
}
