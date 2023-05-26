package ee.mtakso.driver.service.auth.step;

import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient;
import ee.mtakso.driver.network.client.auth.anonymous.VerificationCode;
import ee.mtakso.driver.platform.store_integrity.StoreIntegrityVerificationResult;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.utils.flow.FlowStep;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PhoneAuthenticationStep.kt */
/* loaded from: classes3.dex */
public final class PhoneAuthenticationStep implements FlowStep<AuthStepResult> {

    /* renamed from: a  reason: collision with root package name */
    private final AnonymousAuthClient f23858a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23859b;

    /* renamed from: c  reason: collision with root package name */
    private final String f23860c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f23861d;

    /* renamed from: e  reason: collision with root package name */
    private final StoreIntegrityVerificationResult f23862e;

    public PhoneAuthenticationStep(AnonymousAuthClient anonymousAuthClient, String phonePrefix, String phone, boolean z7, StoreIntegrityVerificationResult storeIntegrityVerificationResult) {
        Intrinsics.f(anonymousAuthClient, "anonymousAuthClient");
        Intrinsics.f(phonePrefix, "phonePrefix");
        Intrinsics.f(phone, "phone");
        this.f23858a = anonymousAuthClient;
        this.f23859b = phonePrefix;
        this.f23860c = phone;
        this.f23861d = z7;
        this.f23862e = storeIntegrityVerificationResult;
    }

    private final Observable<AuthStepResult> d() {
        Single<VerificationCode> L = this.f23858a.L(this.f23859b, this.f23860c, this.f23861d, this.f23862e);
        final Function1<VerificationCode, AuthStepResult> function1 = new Function1<VerificationCode, AuthStepResult>() { // from class: ee.mtakso.driver.service.auth.step.PhoneAuthenticationStep$performAuthentication$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final AuthStepResult invoke(VerificationCode it) {
                String str;
                String str2;
                Intrinsics.f(it, "it");
                str = PhoneAuthenticationStep.this.f23859b;
                str2 = PhoneAuthenticationStep.this.f23860c;
                return new AuthStepResult.PhoneAuthentication(it, str, str2);
            }
        };
        return L.x(new Function() { // from class: ee.mtakso.driver.service.auth.step.a0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AuthStepResult e8;
                e8 = PhoneAuthenticationStep.e(Function1.this, obj);
                return e8;
            }
        }).R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthStepResult e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (AuthStepResult) tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.utils.flow.FlowStep
    public Observable<AuthStepResult> call() {
        Observable<AuthStepResult> subscribeOn = Observable.just(new AuthStepResult.Message("Started phone authentication")).concatWith(d()).subscribeOn(Schedulers.c());
        Intrinsics.e(subscribeOn, "just<AuthStepResult>(\n  …scribeOn(Schedulers.io())");
        return subscribeOn;
    }
}
