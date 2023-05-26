package ee.mtakso.driver.ui.screens.order.ordermenudialog;

import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OrderMenuDialogFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class OrderMenuDialogFragment$diffAdapter$1$1 extends FunctionReferenceImpl implements Function1<TwoLinesItemDelegate.Model<OrderMenuDialogData>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public OrderMenuDialogFragment$diffAdapter$1$1(Object obj) {
        super(1, obj, OrderMenuDialogFragment.class, "handleMenuItemClick", "handleMenuItemClick(Lee/mtakso/driver/uicore/components/recyclerview/delegates/common/TwoLinesItemDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TwoLinesItemDelegate.Model<OrderMenuDialogData> model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(TwoLinesItemDelegate.Model<OrderMenuDialogData> p02) {
        Intrinsics.f(p02, "p0");
        ((OrderMenuDialogFragment) this.f50989g).m0(p02);
    }
}
