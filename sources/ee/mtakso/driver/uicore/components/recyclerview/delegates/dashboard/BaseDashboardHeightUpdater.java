package ee.mtakso.driver.uicore.components.recyclerview.delegates.dashboard;

import android.view.View;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.widgets.gridlayout.SpannedGridLayoutManager;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseDashboardHeightUpdater.kt */
/* loaded from: classes5.dex */
public final class BaseDashboardHeightUpdater implements SpannedGridLayoutManager.HeightUpdater {

    /* renamed from: a  reason: collision with root package name */
    private final DiffAdapter f35203a;

    public BaseDashboardHeightUpdater(DiffAdapter diffAdapter) {
        Intrinsics.f(diffAdapter, "diffAdapter");
        this.f35203a = diffAdapter;
    }

    @Override // ee.mtakso.driver.uikit.widgets.gridlayout.SpannedGridLayoutManager.HeightUpdater
    public void a(View view, int i8) {
        DashboardDelegate dashboardDelegate;
        Intrinsics.f(view, "view");
        ListModel R = this.f35203a.R(i8);
        Unit unit = null;
        if (R != null) {
            DiffAdapterDelegate<?, ?> T = this.f35203a.T(R);
            if (T instanceof DashboardDelegate) {
                dashboardDelegate = (DashboardDelegate) T;
            } else {
                dashboardDelegate = null;
            }
            if (dashboardDelegate != null) {
                dashboardDelegate.a(view);
                unit = Unit.f50853a;
            }
        }
        if (unit == null) {
            view.getLayoutParams().height = -2;
        }
    }
}
