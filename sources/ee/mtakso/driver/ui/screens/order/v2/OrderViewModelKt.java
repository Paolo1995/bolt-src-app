package ee.mtakso.driver.ui.screens.order.v2;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderViewModel.kt */
/* loaded from: classes3.dex */
public final class OrderViewModelKt {
    public static final boolean a(StartPaidWaitingData startPaidWaitingData) {
        Intrinsics.f(startPaidWaitingData, "<this>");
        if (startPaidWaitingData.c() && !startPaidWaitingData.d()) {
            return true;
        }
        return false;
    }
}
