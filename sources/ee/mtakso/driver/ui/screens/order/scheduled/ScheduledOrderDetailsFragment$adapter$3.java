package ee.mtakso.driver.ui.screens.order.scheduled;

import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderLinkDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ScheduledOrderDetailsFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class ScheduledOrderDetailsFragment$adapter$3 extends FunctionReferenceImpl implements Function1<ScheduledOrderLinkDelegate.Model, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ScheduledOrderDetailsFragment$adapter$3(Object obj) {
        super(1, obj, ScheduledOrderDetailsFragment.class, "onLinkClicked", "onLinkClicked(Lee/mtakso/driver/ui/screens/order/scheduled/ScheduledOrderLinkDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ScheduledOrderLinkDelegate.Model model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(ScheduledOrderLinkDelegate.Model p02) {
        Intrinsics.f(p02, "p0");
        ((ScheduledOrderDetailsFragment) this.f50989g).g0(p02);
    }
}
