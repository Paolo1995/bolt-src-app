package ee.mtakso.driver.ui.screens.home.v2.subpage.destination;

import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DestinationsViewModel.kt */
/* loaded from: classes3.dex */
/* synthetic */ class DestinationsViewModel$onStart$6 extends AdaptedFunctionReference implements Function1<Throwable, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DestinationsViewModel$onStart$6(Object obj) {
        super(1, obj, DestinationsViewModel.class, "handleError", "handleError(Ljava/lang/Throwable;Ljava/lang/String;)V", 0);
    }

    public final void c(Throwable p02) {
        Intrinsics.f(p02, "p0");
        BaseViewModel.A((DestinationsViewModel) this.f50976f, p02, null, 2, null);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        c(th);
        return Unit.f50853a;
    }
}
