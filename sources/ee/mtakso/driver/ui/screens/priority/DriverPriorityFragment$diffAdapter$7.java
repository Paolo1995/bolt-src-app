package ee.mtakso.driver.ui.screens.priority;

import ee.mtakso.driver.network.client.priority.PreconditionItem;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DriverPriorityFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class DriverPriorityFragment$diffAdapter$7 extends FunctionReferenceImpl implements Function1<TwoLinesItemDelegate.Model<PreconditionItem>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DriverPriorityFragment$diffAdapter$7(Object obj) {
        super(1, obj, DriverPriorityFragment.class, "handlePriorityClick", "handlePriorityClick(Lee/mtakso/driver/uicore/components/recyclerview/delegates/common/TwoLinesItemDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TwoLinesItemDelegate.Model<PreconditionItem> model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(TwoLinesItemDelegate.Model<PreconditionItem> p02) {
        Intrinsics.f(p02, "p0");
        ((DriverPriorityFragment) this.f50989g).d0(p02);
    }
}
