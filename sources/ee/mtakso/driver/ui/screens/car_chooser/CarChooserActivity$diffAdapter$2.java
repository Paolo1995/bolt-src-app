package ee.mtakso.driver.ui.screens.car_chooser;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CarChooserActivity.kt */
/* loaded from: classes3.dex */
/* synthetic */ class CarChooserActivity$diffAdapter$2 extends FunctionReferenceImpl implements Function1<String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CarChooserActivity$diffAdapter$2(Object obj) {
        super(1, obj, CarChooserActivity.class, "onInsuranceClicked", "onInsuranceClicked(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        j(str);
        return Unit.f50853a;
    }

    public final void j(String p02) {
        Intrinsics.f(p02, "p0");
        ((CarChooserActivity) this.f50989g).t0(p02);
    }
}
