package ee.mtakso.driver.ui.screens.order.scheduled;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScheduledOrdersGroupState.kt */
/* loaded from: classes3.dex */
public final class ScheduledOrdersGroupStateKt {
    public static final boolean a(ScheduledOrdersGroupState scheduledOrdersGroupState) {
        Intrinsics.f(scheduledOrdersGroupState, "<this>");
        if (scheduledOrdersGroupState.c() > -1 && scheduledOrdersGroupState.c() < scheduledOrdersGroupState.b().size()) {
            return true;
        }
        return false;
    }
}
