package ee.mtakso.driver.ui.screens.home.v3.footer.appearance;

import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.ui.screens.home.v3.footer.FooterAppearance;
import ee.mtakso.driver.ui.screens.home.v3.footer.FooterContainer;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkTabAppearance.kt */
/* loaded from: classes3.dex */
public final class WorkTabAppearance implements FooterAppearance {
    @Override // ee.mtakso.driver.ui.screens.home.v3.footer.FooterAppearance
    public void a(FooterContainer container, DriverStatus driverState) {
        Intrinsics.f(container, "container");
        Intrinsics.f(driverState, "driverState");
        ImageView imageView = (ImageView) container.a(R.id.homeButtonIndicator);
        Intrinsics.e(imageView, "container.homeButtonIndicator");
        ViewExtKt.e(imageView, false, 0, 2, null);
        ViewExtKt.e(container.b(), false, 0, 3, null);
        ((ConstraintLayout) container.a(R.id.bottomFooterWorkButtonLayout)).setActivated(true);
        ((ConstraintLayout) container.a(R.id.bottomFooterInboxButtonLayout)).setActivated(false);
        ((ConstraintLayout) container.a(R.id.bottomFooterHistoryButtonLayout)).setActivated(false);
        ((ConstraintLayout) container.a(R.id.bottomFooterSettingsButtonLayout)).setActivated(false);
    }
}
