package ee.mtakso.driver.ui.screens.priority;

import ee.mtakso.driver.uicore.components.recyclerview.delegates.dashboard.DashboardItemDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DriverPriorityFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class DriverPriorityFragment$diffAdapter$5 extends FunctionReferenceImpl implements Function1<DashboardItemDelegate.Model, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DriverPriorityFragment$diffAdapter$5(Object obj) {
        super(1, obj, DriverPriorityFragment.class, "dashBoardItemClick", "dashBoardItemClick(Lee/mtakso/driver/uicore/components/recyclerview/delegates/dashboard/DashboardItemDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DashboardItemDelegate.Model model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(DashboardItemDelegate.Model p02) {
        Intrinsics.f(p02, "p0");
        ((DriverPriorityFragment) this.f50989g).Z(p02);
    }
}
