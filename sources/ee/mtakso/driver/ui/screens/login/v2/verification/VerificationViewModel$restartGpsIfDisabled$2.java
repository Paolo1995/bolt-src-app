package ee.mtakso.driver.ui.screens.login.v2.verification;

import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VerificationViewModel.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class VerificationViewModel$restartGpsIfDisabled$2 extends AdaptedFunctionReference implements Function1<Throwable, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public VerificationViewModel$restartGpsIfDisabled$2(Object obj) {
        super(1, obj, VerificationViewModel.class, "handleError", "handleError(Ljava/lang/Throwable;Ljava/lang/String;)V", 0);
    }

    public final void c(Throwable p02) {
        Intrinsics.f(p02, "p0");
        BaseViewModel.A((VerificationViewModel) this.f50976f, p02, null, 2, null);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        c(th);
        return Unit.f50853a;
    }
}
