package ee.mtakso.driver.ui.screens.order.modal;

import ee.mtakso.driver.network.client.order.modal.ModalItem;
import ee.mtakso.driver.ui.screens.order.modal.OrderModalItemDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OrderModalFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class OrderModalFragment$adapter$1 extends FunctionReferenceImpl implements Function1<OrderModalItemDelegate.Model<ModalItem.Action>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public OrderModalFragment$adapter$1(Object obj) {
        super(1, obj, OrderModalFragment.class, "onItemClicked", "onItemClicked(Lee/mtakso/driver/ui/screens/order/modal/OrderModalItemDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(OrderModalItemDelegate.Model<ModalItem.Action> model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(OrderModalItemDelegate.Model<ModalItem.Action> p02) {
        Intrinsics.f(p02, "p0");
        ((OrderModalFragment) this.f50989g).P(p02);
    }
}
