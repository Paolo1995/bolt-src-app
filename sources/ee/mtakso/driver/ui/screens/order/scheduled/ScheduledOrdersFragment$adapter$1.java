package ee.mtakso.driver.ui.screens.order.scheduled;

import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ScheduledOrdersFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class ScheduledOrdersFragment$adapter$1 extends FunctionReferenceImpl implements Function1<ScheduledOrderDelegate.Model, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ScheduledOrdersFragment$adapter$1(Object obj) {
        super(1, obj, ScheduledOrdersFragment.class, "onScheduledOrderClicked", "onScheduledOrderClicked(Lee/mtakso/driver/ui/screens/order/scheduled/ScheduledOrderDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ScheduledOrderDelegate.Model model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(ScheduledOrderDelegate.Model p02) {
        Intrinsics.f(p02, "p0");
        ((ScheduledOrdersFragment) this.f50989g).c0(p02);
    }
}
