package ee.mtakso.driver.ui.screens.home.v3;

import ee.mtakso.driver.ui.interactor.driver.DriverStateChangeFailInteractor;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HomeViewModel.kt */
/* loaded from: classes3.dex */
/* synthetic */ class HomeViewModel$onStart$7 extends FunctionReferenceImpl implements Function1<DriverStateChangeFailInteractor.UpdateCarRequired, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public HomeViewModel$onStart$7(Object obj) {
        super(1, obj, HomeViewModel.class, "showCarUnavailableDialog", "showCarUnavailableDialog(Lee/mtakso/driver/ui/interactor/driver/DriverStateChangeFailInteractor$UpdateCarRequired;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DriverStateChangeFailInteractor.UpdateCarRequired updateCarRequired) {
        j(updateCarRequired);
        return Unit.f50853a;
    }

    public final void j(DriverStateChangeFailInteractor.UpdateCarRequired p02) {
        Intrinsics.f(p02, "p0");
        ((HomeViewModel) this.f50989g).h1(p02);
    }
}
