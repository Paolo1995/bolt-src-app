package ee.mtakso.driver.ui.screens.settings.pricing;

import ee.mtakso.driver.network.client.driver.DriverPricingConfiguration;
import ee.mtakso.driver.network.client.settings.DriverPricingSetup;
import ee.mtakso.driver.network.client.settings.DriverPricingState;
import java.math.BigDecimal;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PricingSettings.kt */
/* loaded from: classes5.dex */
public final class PricingSettingsKt {
    public static final DriverPricingConfiguration.Option a(PricingSettings pricingSettings) {
        Object obj;
        boolean z7;
        Intrinsics.f(pricingSettings, "<this>");
        Iterator<T> it = pricingSettings.d().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((DriverPricingConfiguration.Option) obj).d().getState() == pricingSettings.g()) {
                    z7 = true;
                    continue;
                } else {
                    z7 = false;
                    continue;
                }
                if (z7) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (DriverPricingConfiguration.Option) obj;
    }

    public static final BigDecimal b(PricingSettings pricingSettings) {
        Intrinsics.f(pricingSettings, "<this>");
        if (pricingSettings.f() >= 0) {
            return pricingSettings.e().get(pricingSettings.f()).b();
        }
        return null;
    }

    public static final String c(PricingSettings pricingSettings) {
        Intrinsics.f(pricingSettings, "<this>");
        if (pricingSettings.f() >= 0) {
            return pricingSettings.e().get(pricingSettings.f()).a();
        }
        return null;
    }

    public static final boolean d(PricingSettings pricingSettings) {
        DriverPricingState driverPricingState;
        Intrinsics.f(pricingSettings, "<this>");
        if (pricingSettings.g() != null) {
            DriverPricingState g8 = pricingSettings.g();
            DriverPricingSetup c8 = pricingSettings.c();
            if (c8 != null) {
                driverPricingState = c8.b();
            } else {
                driverPricingState = null;
            }
            if (g8 != driverPricingState) {
                return true;
            }
            if (pricingSettings.g() == DriverPricingState.CUSTOM_PRICING && !Intrinsics.a(b(pricingSettings), pricingSettings.c().a())) {
                return true;
            }
        }
        return false;
    }
}
