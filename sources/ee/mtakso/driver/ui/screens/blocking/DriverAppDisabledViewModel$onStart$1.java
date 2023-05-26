package ee.mtakso.driver.ui.screens.blocking;

import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverAppDisabledViewModel.kt */
/* loaded from: classes3.dex */
/* synthetic */ class DriverAppDisabledViewModel$onStart$1 extends AdaptedFunctionReference implements Function1<Throwable, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DriverAppDisabledViewModel$onStart$1(Object obj) {
        super(1, obj, DriverAppDisabledViewModel.class, "handleError", "handleError(Ljava/lang/Throwable;Ljava/lang/String;)V", 0);
    }

    public final void c(Throwable p02) {
        Intrinsics.f(p02, "p0");
        BaseViewModel.A((DriverAppDisabledViewModel) this.f50976f, p02, null, 2, null);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        c(th);
        return Unit.f50853a;
    }
}
