package ee.mtakso.driver.ui.screens.settings.pricing;

import ee.mtakso.driver.network.client.settings.DriverPricingHint;
import ee.mtakso.driver.network.client.settings.DriverPricingSetup;
import java.math.BigDecimal;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PricingSettingsViewModel.kt */
/* loaded from: classes5.dex */
public final class PricingSettingsViewModelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int c(DriverPricingSetup driverPricingSetup) {
        BigDecimal c8 = driverPricingSetup.d().c();
        BigDecimal d8 = driverPricingSetup.d().d();
        BigDecimal a8 = driverPricingSetup.a();
        if (a8 == null) {
            a8 = driverPricingSetup.c();
        }
        BigDecimal subtract = a8.subtract(c8);
        Intrinsics.e(subtract, "this.subtract(other)");
        return subtract.divide(d8).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DriverPricingHint d(DriverPricingSetup driverPricingSetup, final BigDecimal bigDecimal) {
        int i8;
        i8 = CollectionsKt__CollectionsKt.i(driverPricingSetup.d().a(), 0, 0, new Function1<DriverPricingHint, Integer>() { // from class: ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsViewModelKt$findHint$index$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Integer invoke(DriverPricingHint hint) {
                int i9;
                Intrinsics.f(hint, "hint");
                if (bigDecimal.compareTo(hint.c()) < 0) {
                    i9 = 1;
                } else if (bigDecimal.compareTo(hint.a()) > 0) {
                    i9 = -1;
                } else {
                    i9 = 0;
                }
                return Integer.valueOf(i9);
            }
        }, 3, null);
        if (i8 >= 0) {
            return driverPricingSetup.d().a().get(i8);
        }
        return null;
    }
}
