package ee.mtakso.driver.ui.screens.score;

import ee.mtakso.driver.network.client.score.IssueItem;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DriverScoreFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class DriverScoreFragment$adapter$2$1$4 extends FunctionReferenceImpl implements Function1<IssueItem, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DriverScoreFragment$adapter$2$1$4(Object obj) {
        super(1, obj, DriverScoreFragment.class, "onIssueClicked", "onIssueClicked(Lee/mtakso/driver/network/client/score/IssueItem;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(IssueItem issueItem) {
        j(issueItem);
        return Unit.f50853a;
    }

    public final void j(IssueItem p02) {
        Intrinsics.f(p02, "p0");
        ((DriverScoreFragment) this.f50989g).g0(p02);
    }
}
