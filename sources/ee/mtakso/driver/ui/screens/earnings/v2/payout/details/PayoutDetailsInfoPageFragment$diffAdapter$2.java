package ee.mtakso.driver.ui.screens.earnings.v2.payout.details;

import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ButtonItemDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PayoutDetailsInfoPageFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class PayoutDetailsInfoPageFragment$diffAdapter$2 extends FunctionReferenceImpl implements Function1<ButtonItemDelegate.Model<String>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PayoutDetailsInfoPageFragment$diffAdapter$2(Object obj) {
        super(1, obj, PayoutDetailsInfoPageFragment.class, "handleButtonClick", "handleButtonClick(Lee/mtakso/driver/uicore/components/recyclerview/delegates/common/ButtonItemDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ButtonItemDelegate.Model<String> model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(ButtonItemDelegate.Model<String> p02) {
        Intrinsics.f(p02, "p0");
        ((PayoutDetailsInfoPageFragment) this.f50989g).Y(p02);
    }
}
