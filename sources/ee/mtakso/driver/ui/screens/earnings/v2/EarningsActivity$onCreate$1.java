package ee.mtakso.driver.ui.screens.earnings.v2;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsActivity.kt */
/* loaded from: classes3.dex */
/* synthetic */ class EarningsActivity$onCreate$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public EarningsActivity$onCreate$1(Object obj) {
        super(1, obj, EarningsActivity.class, "onPaymentLinkClicked", "onPaymentLinkClicked(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        j(str);
        return Unit.f50853a;
    }

    public final void j(String p02) {
        Intrinsics.f(p02, "p0");
        ((EarningsActivity) this.f50989g).E0(p02);
    }
}
