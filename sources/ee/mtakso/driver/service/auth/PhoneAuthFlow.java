package ee.mtakso.driver.service.auth;

import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.utils.flow.Flow;
import ee.mtakso.driver.utils.flow.FlowStep;
import ee.mtakso.driver.utils.flow.SingleItemStep;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PhoneAuthFlow.kt */
/* loaded from: classes3.dex */
public final class PhoneAuthFlow extends Flow<AuthStepResult> {

    /* renamed from: d  reason: collision with root package name */
    private final AuthStepFactory f23740d;

    /* renamed from: e  reason: collision with root package name */
    private String f23741e;

    /* renamed from: f  reason: collision with root package name */
    private String f23742f;

    @Inject
    public PhoneAuthFlow(AuthStepFactory authStepFactory) {
        Intrinsics.f(authStepFactory, "authStepFactory");
        this.f23740d = authStepFactory;
    }

    private final FlowStep<AuthStepResult> t(AuthStepResult.AuthConfiguration authConfiguration) {
        if (authConfiguration.a().a() != null) {
            return this.f23740d.t(authConfiguration.a().a());
        }
        AuthStepFactory authStepFactory = this.f23740d;
        String str = this.f23741e;
        if (str == null) {
            Intrinsics.w("phonePrefix");
            str = null;
        }
        String str2 = this.f23742f;
        if (str2 == null) {
            Intrinsics.w("phone");
            str2 = null;
        }
        return authStepFactory.p(str, str2, null);
    }

    public final void q(String phonePrefix, String phone) {
        Intrinsics.f(phonePrefix, "phonePrefix");
        Intrinsics.f(phone, "phone");
        this.f23741e = phonePrefix;
        this.f23742f = phone;
        h(n(new SingleItemStep(AuthStepResult.LoginStarted.f23688a)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.utils.flow.Flow
    /* renamed from: r */
    public AuthStepResult e(Throwable throwable) {
        Intrinsics.f(throwable, "throwable");
        return new AuthStepResult.Error(throwable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.utils.flow.Flow
    /* renamed from: s */
    public FlowStep<AuthStepResult> m(AuthStepResult result) {
        Intrinsics.f(result, "result");
        String str = null;
        if (result instanceof AuthStepResult.LoginStarted) {
            return this.f23740d.o();
        }
        if (result instanceof AuthStepResult.AuthConfiguration) {
            return t((AuthStepResult.AuthConfiguration) result);
        }
        if (!(result instanceof AuthStepResult.StoreIntegrityVerification)) {
            return null;
        }
        AuthStepFactory authStepFactory = this.f23740d;
        String str2 = this.f23741e;
        if (str2 == null) {
            Intrinsics.w("phonePrefix");
            str2 = null;
        }
        String str3 = this.f23742f;
        if (str3 == null) {
            Intrinsics.w("phone");
        } else {
            str = str3;
        }
        return authStepFactory.p(str2, str, ((AuthStepResult.StoreIntegrityVerification) result).a());
    }
}
