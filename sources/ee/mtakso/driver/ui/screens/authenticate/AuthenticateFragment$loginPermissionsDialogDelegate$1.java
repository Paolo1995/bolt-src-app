package ee.mtakso.driver.ui.screens.authenticate;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AuthenticateFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class AuthenticateFragment$loginPermissionsDialogDelegate$1 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AuthenticateFragment$loginPermissionsDialogDelegate$1(Object obj) {
        super(1, obj, AuthenticateFragment.class, "showError", "showError(Ljava/lang/Throwable;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        j(th);
        return Unit.f50853a;
    }

    public final void j(Throwable p02) {
        Intrinsics.f(p02, "p0");
        ((AuthenticateFragment) this.f50989g).H(p02);
    }
}
