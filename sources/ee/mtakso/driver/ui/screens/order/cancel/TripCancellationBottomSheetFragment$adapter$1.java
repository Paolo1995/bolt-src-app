package ee.mtakso.driver.ui.screens.order.cancel;

import ee.mtakso.driver.network.client.order.RejectReason;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TripCancellationBottomSheetFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class TripCancellationBottomSheetFragment$adapter$1 extends FunctionReferenceImpl implements Function1<RejectReason, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TripCancellationBottomSheetFragment$adapter$1(Object obj) {
        super(1, obj, TripCancellationBottomSheetFragment.class, "handleItemClick", "handleItemClick(Lee/mtakso/driver/network/client/order/RejectReason;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RejectReason rejectReason) {
        j(rejectReason);
        return Unit.f50853a;
    }

    public final void j(RejectReason p02) {
        Intrinsics.f(p02, "p0");
        ((TripCancellationBottomSheetFragment) this.f50989g).k0(p02);
    }
}
