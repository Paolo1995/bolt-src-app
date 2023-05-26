package ee.mtakso.driver.ui.screens.order.scheduled;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScheduledOrdersState.kt */
/* loaded from: classes3.dex */
public final class ScheduledOrdersStateKt {
    public static final boolean a(ScheduledOrdersState scheduledOrdersState) {
        Intrinsics.f(scheduledOrdersState, "<this>");
        if (scheduledOrdersState.d().isEmpty() && scheduledOrdersState.c()) {
            return true;
        }
        return false;
    }
}
