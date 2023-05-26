package ee.mtakso.driver.ui.screens.work;

import ee.mtakso.driver.uicore.components.recyclerview.delegates.dashboard.DashboardBannerDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WorkDashboardInnerLayoutDelegate.kt */
/* loaded from: classes5.dex */
public /* synthetic */ class WorkDashboardInnerLayoutDelegate$diffAdapter$1$1 extends FunctionReferenceImpl implements Function1<DashboardBannerDelegate.Model, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public WorkDashboardInnerLayoutDelegate$diffAdapter$1$1(Object obj) {
        super(1, obj, WorkDashboardInnerLayoutDelegate.class, "handleBannerClick", "handleBannerClick(Lee/mtakso/driver/uicore/components/recyclerview/delegates/dashboard/DashboardBannerDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DashboardBannerDelegate.Model model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(DashboardBannerDelegate.Model p02) {
        Intrinsics.f(p02, "p0");
        ((WorkDashboardInnerLayoutDelegate) this.f50989g).h(p02);
    }
}
