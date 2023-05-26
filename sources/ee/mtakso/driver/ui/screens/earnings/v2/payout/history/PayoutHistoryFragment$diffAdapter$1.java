package ee.mtakso.driver.ui.screens.earnings.v2.payout.history;

import ee.mtakso.driver.uicore.components.recyclerview.delegates.payout.PayoutDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PayoutHistoryFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class PayoutHistoryFragment$diffAdapter$1 extends FunctionReferenceImpl implements Function1<PayoutDelegate.Model, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PayoutHistoryFragment$diffAdapter$1(Object obj) {
        super(1, obj, PayoutHistoryFragment.class, "openDetails", "openDetails(Lee/mtakso/driver/uicore/components/recyclerview/delegates/payout/PayoutDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PayoutDelegate.Model model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(PayoutDelegate.Model p02) {
        Intrinsics.f(p02, "p0");
        ((PayoutHistoryFragment) this.f50989g).X(p02);
    }
}
