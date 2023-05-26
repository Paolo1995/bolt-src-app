package ee.mtakso.driver.service.auth.step;

import ee.mtakso.driver.network.client.auth.anonymous.AuthResult;
import ee.mtakso.driver.network.client.auth.anonymous.RefreshToken;
import ee.mtakso.driver.network.client.partner.PartnerClient;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.utils.flow.FlowStep;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PartnerConvertAuthenticateStep.kt */
/* loaded from: classes3.dex */
public final class PartnerConvertAuthenticateStep implements FlowStep<AuthStepResult> {

    /* renamed from: a  reason: collision with root package name */
    private final PartnerClient f23854a;

    public PartnerConvertAuthenticateStep(PartnerClient partnerClient) {
        Intrinsics.f(partnerClient, "partnerClient");
        this.f23854a = partnerClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(SingleEmitter it) {
        Intrinsics.f(it, "it");
        it.onSuccess(new AuthStepResult.Message("Started Partner Token Exchange authentication"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthStepResult.AuthenticationResult d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (AuthStepResult.AuthenticationResult) tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.utils.flow.FlowStep
    public Observable<AuthStepResult> call() {
        Observable R = Single.f(new SingleOnSubscribe() { // from class: ee.mtakso.driver.service.auth.step.w
            @Override // io.reactivex.SingleOnSubscribe
            public final void a(SingleEmitter singleEmitter) {
                PartnerConvertAuthenticateStep.c(singleEmitter);
            }
        }).R();
        Single<RefreshToken> b8 = this.f23854a.b();
        final PartnerConvertAuthenticateStep$call$auth$1 partnerConvertAuthenticateStep$call$auth$1 = new Function1<RefreshToken, AuthStepResult.AuthenticationResult>() { // from class: ee.mtakso.driver.service.auth.step.PartnerConvertAuthenticateStep$call$auth$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final AuthStepResult.AuthenticationResult invoke(RefreshToken it) {
                Intrinsics.f(it, "it");
                return new AuthStepResult.AuthenticationResult(new AuthResult.Success(it.a()));
            }
        };
        SingleSource x7 = b8.x(new Function() { // from class: ee.mtakso.driver.service.auth.step.x
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AuthStepResult.AuthenticationResult d8;
                d8 = PartnerConvertAuthenticateStep.d(Function1.this, obj);
                return d8;
            }
        });
        Intrinsics.e(x7, "partnerClient.exchangeTo…          )\n            }");
        Observable<AuthStepResult> subscribeOn = R.concatWith(x7).subscribeOn(Schedulers.c());
        Intrinsics.e(subscribeOn, "message.concatWith(auth)…scribeOn(Schedulers.io())");
        return subscribeOn;
    }
}
