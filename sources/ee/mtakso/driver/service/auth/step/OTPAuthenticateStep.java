package ee.mtakso.driver.service.auth.step;

import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient;
import ee.mtakso.driver.network.client.auth.anonymous.AuthResult;
import ee.mtakso.driver.network.client.auth.anonymous.ConfirmAuthenticationResponse;
import ee.mtakso.driver.network.client.auth.anonymous.ConfirmAuthenticationResponseType;
import ee.mtakso.driver.network.client.auth.anonymous.EmailVerification;
import ee.mtakso.driver.network.client.auth.anonymous.RefreshToken;
import ee.mtakso.driver.network.client.auth.anonymous.TokenType;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.utils.flow.FlowStep;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OTPAuthenticateStep.kt */
/* loaded from: classes3.dex */
public final class OTPAuthenticateStep implements FlowStep<AuthStepResult> {

    /* renamed from: a  reason: collision with root package name */
    private final AnonymousAuthClient f23848a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23849b;

    /* renamed from: c  reason: collision with root package name */
    private final String f23850c;

    /* compiled from: OTPAuthenticateStep.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f23851a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f23852b;

        static {
            int[] iArr = new int[ConfirmAuthenticationResponseType.values().length];
            try {
                iArr[ConfirmAuthenticationResponseType.EMAIL_VERIFICATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ConfirmAuthenticationResponseType.TOKEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f23851a = iArr;
            int[] iArr2 = new int[TokenType.values().length];
            try {
                iArr2[TokenType.DRIVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[TokenType.PARTNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            f23852b = iArr2;
        }
    }

    public OTPAuthenticateStep(AnonymousAuthClient anonymousAuthClient, String verificationToken, String verificationCode) {
        Intrinsics.f(anonymousAuthClient, "anonymousAuthClient");
        Intrinsics.f(verificationToken, "verificationToken");
        Intrinsics.f(verificationCode, "verificationCode");
        this.f23848a = anonymousAuthClient;
        this.f23849b = verificationToken;
        this.f23850c = verificationCode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(SingleEmitter it) {
        Intrinsics.f(it, "it");
        it.onSuccess(new AuthStepResult.Message("Started OTP authentication"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthStepResult.AuthenticationResult e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (AuthStepResult.AuthenticationResult) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthResult f(ConfirmAuthenticationResponse confirmAuthenticationResponse) {
        int i8 = WhenMappings.f23851a[confirmAuthenticationResponse.c().ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return h(confirmAuthenticationResponse.b());
            }
            throw new NoWhenBranchMatchedException();
        }
        return g(confirmAuthenticationResponse.a());
    }

    private final AuthResult.PartnerEmailVerification g(EmailVerification emailVerification) {
        if (emailVerification != null) {
            String c8 = emailVerification.c();
            String a8 = emailVerification.a();
            if (a8 == null) {
                a8 = "";
            }
            return new AuthResult.PartnerEmailVerification(c8, a8, emailVerification.b());
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final AuthResult h(RefreshToken refreshToken) {
        if (refreshToken != null) {
            int i8 = WhenMappings.f23852b[refreshToken.b().ordinal()];
            if (i8 != 1) {
                if (i8 == 2) {
                    return new AuthResult.PartnerSuccess(refreshToken.a());
                }
                throw new NoWhenBranchMatchedException();
            }
            return new AuthResult.Success(refreshToken.a());
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // ee.mtakso.driver.utils.flow.FlowStep
    public Observable<AuthStepResult> call() {
        Observable R = Single.f(new SingleOnSubscribe() { // from class: ee.mtakso.driver.service.auth.step.u
            @Override // io.reactivex.SingleOnSubscribe
            public final void a(SingleEmitter singleEmitter) {
                OTPAuthenticateStep.d(singleEmitter);
            }
        }).R();
        Single<ConfirmAuthenticationResponse> w7 = this.f23848a.w(this.f23849b, this.f23850c);
        final Function1<ConfirmAuthenticationResponse, AuthStepResult.AuthenticationResult> function1 = new Function1<ConfirmAuthenticationResponse, AuthStepResult.AuthenticationResult>() { // from class: ee.mtakso.driver.service.auth.step.OTPAuthenticateStep$call$auth$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final AuthStepResult.AuthenticationResult invoke(ConfirmAuthenticationResponse it) {
                AuthResult f8;
                Intrinsics.f(it, "it");
                f8 = OTPAuthenticateStep.this.f(it);
                return new AuthStepResult.AuthenticationResult(f8);
            }
        };
        SingleSource x7 = w7.x(new Function() { // from class: ee.mtakso.driver.service.auth.step.v
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AuthStepResult.AuthenticationResult e8;
                e8 = OTPAuthenticateStep.e(Function1.this, obj);
                return e8;
            }
        });
        Intrinsics.e(x7, "override fun call(): Obs…On(Schedulers.io())\n    }");
        Observable<AuthStepResult> subscribeOn = R.concatWith(x7).subscribeOn(Schedulers.c());
        Intrinsics.e(subscribeOn, "message.concatWith(auth)…scribeOn(Schedulers.io())");
        return subscribeOn;
    }
}
