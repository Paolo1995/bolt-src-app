package ee.mtakso.driver.ui.screens.car_chooser;

import ee.mtakso.driver.network.client.driver.Car;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CarChooserActivity.kt */
/* loaded from: classes3.dex */
/* synthetic */ class CarChooserActivity$diffAdapter$1 extends FunctionReferenceImpl implements Function1<Car, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CarChooserActivity$diffAdapter$1(Object obj) {
        super(1, obj, CarChooserActivity.class, "onCarClicked", "onCarClicked(Lee/mtakso/driver/network/client/driver/Car;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Car car) {
        j(car);
        return Unit.f50853a;
    }

    public final void j(Car p02) {
        Intrinsics.f(p02, "p0");
        ((CarChooserActivity) this.f50989g).m0(p02);
    }
}
