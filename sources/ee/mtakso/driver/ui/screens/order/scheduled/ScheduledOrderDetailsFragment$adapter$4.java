package ee.mtakso.driver.ui.screens.order.scheduled;

import ee.mtakso.driver.network.client.order.ScheduledRideDetailsComponent;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ButtonItemDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ScheduledOrderDetailsFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class ScheduledOrderDetailsFragment$adapter$4 extends FunctionReferenceImpl implements Function1<ButtonItemDelegate.Model<ScheduledRideDetailsComponent.Button>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ScheduledOrderDetailsFragment$adapter$4(Object obj) {
        super(1, obj, ScheduledOrderDetailsFragment.class, "onButtonClicked", "onButtonClicked(Lee/mtakso/driver/uicore/components/recyclerview/delegates/common/ButtonItemDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ButtonItemDelegate.Model<ScheduledRideDetailsComponent.Button> model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(ButtonItemDelegate.Model<ScheduledRideDetailsComponent.Button> p02) {
        Intrinsics.f(p02, "p0");
        ((ScheduledOrderDetailsFragment) this.f50989g).f0(p02);
    }
}
