package ee.mtakso.driver.ui.screens.home.v3.footer.appearance;

import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.ui.screens.home.v3.footer.FooterAppearance;
import ee.mtakso.driver.ui.screens.home.v3.footer.FooterContainer;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NoTabsAppearance.kt */
/* loaded from: classes3.dex */
public final class NoTabsAppearance implements FooterAppearance {
    @Override // ee.mtakso.driver.ui.screens.home.v3.footer.FooterAppearance
    public void a(FooterContainer container, DriverStatus driverState) {
        Intrinsics.f(container, "container");
        Intrinsics.f(driverState, "driverState");
        ViewExtKt.e(container.b(), false, 0, 2, null);
    }
}
