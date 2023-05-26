package ee.mtakso.driver.ui.screens.login.v3.login;

import ee.mtakso.driver.service.auth.AuthStepResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoginV3ViewModel.kt */
/* loaded from: classes3.dex */
/* synthetic */ class LoginV3ViewModel$onStart$1 extends FunctionReferenceImpl implements Function1<AuthStepResult, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LoginV3ViewModel$onStart$1(Object obj) {
        super(1, obj, LoginV3ViewModel.class, "handleAuthStep", "handleAuthStep(Lee/mtakso/driver/service/auth/AuthStepResult;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AuthStepResult authStepResult) {
        j(authStepResult);
        return Unit.f50853a;
    }

    public final void j(AuthStepResult p02) {
        Intrinsics.f(p02, "p0");
        ((LoginV3ViewModel) this.f50989g).L(p02);
    }
}
