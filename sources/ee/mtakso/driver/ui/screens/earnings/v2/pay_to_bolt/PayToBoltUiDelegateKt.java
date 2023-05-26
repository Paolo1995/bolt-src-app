package ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayToBoltUiDelegate.kt */
/* loaded from: classes3.dex */
public final class PayToBoltUiDelegateKt {
    public static final boolean a(PayToBoltInfo payToBoltInfo) {
        Intrinsics.f(payToBoltInfo, "<this>");
        if (payToBoltInfo.b() == null && payToBoltInfo.c() == null && payToBoltInfo.a() == null) {
            return true;
        }
        return false;
    }

    public static final boolean b(PayToBoltInfo payToBoltInfo) {
        if (payToBoltInfo == null) {
            return true;
        }
        return a(payToBoltInfo);
    }
}
