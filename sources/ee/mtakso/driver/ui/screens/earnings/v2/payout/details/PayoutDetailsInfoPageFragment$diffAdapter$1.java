package ee.mtakso.driver.ui.screens.earnings.v2.payout.details;

import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TextCenteredDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PayoutDetailsInfoPageFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class PayoutDetailsInfoPageFragment$diffAdapter$1 extends FunctionReferenceImpl implements Function1<TextCenteredDelegate.Model, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PayoutDetailsInfoPageFragment$diffAdapter$1(Object obj) {
        super(1, obj, PayoutDetailsInfoPageFragment.class, "handleTextClick", "handleTextClick(Lee/mtakso/driver/uicore/components/recyclerview/delegates/common/TextCenteredDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TextCenteredDelegate.Model model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(TextCenteredDelegate.Model p02) {
        Intrinsics.f(p02, "p0");
        ((PayoutDetailsInfoPageFragment) this.f50989g).a0(p02);
    }
}
