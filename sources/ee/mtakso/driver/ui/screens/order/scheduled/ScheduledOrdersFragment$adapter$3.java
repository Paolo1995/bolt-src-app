package ee.mtakso.driver.ui.screens.order.scheduled;

import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ScheduledOrdersFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class ScheduledOrdersFragment$adapter$3 extends FunctionReferenceImpl implements Function1<TwoLinesItemDelegate.Model<ScheduledOrdersGroupInfo>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ScheduledOrdersFragment$adapter$3(Object obj) {
        super(1, obj, ScheduledOrdersFragment.class, "onExpandGroupClicked", "onExpandGroupClicked(Lee/mtakso/driver/uicore/components/recyclerview/delegates/common/TwoLinesItemDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TwoLinesItemDelegate.Model<ScheduledOrdersGroupInfo> model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(TwoLinesItemDelegate.Model<ScheduledOrdersGroupInfo> p02) {
        Intrinsics.f(p02, "p0");
        ((ScheduledOrdersFragment) this.f50989g).b0(p02);
    }
}
