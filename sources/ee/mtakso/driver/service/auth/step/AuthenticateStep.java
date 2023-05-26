package ee.mtakso.driver.service.auth.step;

import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient;
import ee.mtakso.driver.network.client.auth.anonymous.AuthResult;
import ee.mtakso.driver.network.client.auth.anonymous.RefreshToken;
import ee.mtakso.driver.param.DeviceFeatures;
import ee.mtakso.driver.platform.store_integrity.StoreIntegrityVerificationResult;
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

/* compiled from: AuthenticateStep.kt */
/* loaded from: classes3.dex */
public final class AuthenticateStep implements FlowStep<AuthStepResult> {

    /* renamed from: a  reason: collision with root package name */
    private final AnonymousAuthClient f23812a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23813b;

    /* renamed from: c  reason: collision with root package name */
    private final String f23814c;

    /* renamed from: d  reason: collision with root package name */
    private final DeviceFeatures f23815d;

    /* renamed from: e  reason: collision with root package name */
    private final StoreIntegrityVerificationResult f23816e;

    public AuthenticateStep(AnonymousAuthClient anonymousAuthClient, String login, String password, DeviceFeatures deviceFeatures, StoreIntegrityVerificationResult storeIntegrityVerificationResult) {
        Intrinsics.f(anonymousAuthClient, "anonymousAuthClient");
        Intrinsics.f(login, "login");
        Intrinsics.f(password, "password");
        Intrinsics.f(deviceFeatures, "deviceFeatures");
        this.f23812a = anonymousAuthClient;
        this.f23813b = login;
        this.f23814c = password;
        this.f23815d = deviceFeatures;
        this.f23816e = storeIntegrityVerificationResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(SingleEmitter it) {
        Intrinsics.f(it, "it");
        it.onSuccess(new AuthStepResult.Message("Started authentication"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthStepResult.AuthenticationResult e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (AuthStepResult.AuthenticationResult) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthStepResult.AuthenticationResult f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (AuthStepResult.AuthenticationResult) tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.utils.flow.FlowStep
    public Observable<AuthStepResult> call() {
        Observable R = Single.f(new SingleOnSubscribe() { // from class: ee.mtakso.driver.service.auth.step.e
            @Override // io.reactivex.SingleOnSubscribe
            public final void a(SingleEmitter singleEmitter) {
                AuthenticateStep.d(singleEmitter);
            }
        }).R();
        Single<RefreshToken> n8 = this.f23812a.n(this.f23813b, this.f23814c);
        final AuthenticateStep$call$oldAuth$1 authenticateStep$call$oldAuth$1 = new Function1<RefreshToken, AuthStepResult.AuthenticationResult>() { // from class: ee.mtakso.driver.service.auth.step.AuthenticateStep$call$oldAuth$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final AuthStepResult.AuthenticationResult invoke(RefreshToken it) {
                Intrinsics.f(it, "it");
                return new AuthStepResult.AuthenticationResult(new AuthResult.Success(it.a()));
            }
        };
        SingleSource x7 = n8.x(new Function() { // from class: ee.mtakso.driver.service.auth.step.f
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AuthStepResult.AuthenticationResult e8;
                e8 = AuthenticateStep.e(Function1.this, obj);
                return e8;
            }
        });
        Intrinsics.e(x7, "anonymousAuthClient.auth…ccess(it.refreshToken)) }");
        Single<AuthResult> p8 = this.f23812a.p(this.f23813b, this.f23814c, this.f23815d.d(), this.f23816e);
        final AuthenticateStep$call$newAuth$1 authenticateStep$call$newAuth$1 = new Function1<AuthResult, AuthStepResult.AuthenticationResult>() { // from class: ee.mtakso.driver.service.auth.step.AuthenticateStep$call$newAuth$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final AuthStepResult.AuthenticationResult invoke(AuthResult it) {
                Intrinsics.f(it, "it");
                return new AuthStepResult.AuthenticationResult(it);
            }
        };
        SingleSource x8 = p8.x(new Function() { // from class: ee.mtakso.driver.service.auth.step.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AuthStepResult.AuthenticationResult f8;
                f8 = AuthenticateStep.f(Function1.this, obj);
                return f8;
            }
        });
        Intrinsics.e(x8, "anonymousAuthClient.auth…uthenticationResult(it) }");
        if (this.f23815d.c()) {
            x7 = x8;
        }
        Observable<AuthStepResult> subscribeOn = R.concatWith(x7).subscribeOn(Schedulers.c());
        Intrinsics.e(subscribeOn, "message.concatWith(auth)…scribeOn(Schedulers.io())");
        return subscribeOn;
    }
}
