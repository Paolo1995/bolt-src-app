package ee.mtakso.driver.ui.screens.earnings.v3.common;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: CurrencyConfig.kt */
/* loaded from: classes3.dex */
public final class CurrencyConfigKt {
    public static final String a(CurrencyConfig currencyConfig, String value) {
        Intrinsics.f(currencyConfig, "<this>");
        Intrinsics.f(value, "value");
        if (currencyConfig.b()) {
            String a8 = currencyConfig.a();
            return value + a8;
        }
        String a9 = currencyConfig.a();
        return a9 + value;
    }
}
