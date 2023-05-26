package ee.mtakso.driver.ui.screens.earnings.v3.balance;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EarningsBalanceFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class EarningsBalanceFragment$adapter$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public EarningsBalanceFragment$adapter$1(Object obj) {
        super(1, obj, EarningsBalanceFragment.class, "handleHistoryPayload", "handleHistoryPayload(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        j(str);
        return Unit.f50853a;
    }

    public final void j(String p02) {
        Intrinsics.f(p02, "p0");
        ((EarningsBalanceFragment) this.f50989g).j0(p02);
    }
}
