package ee.mtakso.driver.ui.screens.score;

import ee.mtakso.driver.ui.screens.score.DriverScoreActionDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DriverScoreFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class DriverScoreFragment$adapter$2$1$2 extends FunctionReferenceImpl implements Function1<DriverScoreActionDelegate.Model, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DriverScoreFragment$adapter$2$1$2(Object obj) {
        super(1, obj, DriverScoreFragment.class, "onActionClicked", "onActionClicked(Lee/mtakso/driver/ui/screens/score/DriverScoreActionDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DriverScoreActionDelegate.Model model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(DriverScoreActionDelegate.Model p02) {
        Intrinsics.f(p02, "p0");
        ((DriverScoreFragment) this.f50989g).e0(p02);
    }
}
