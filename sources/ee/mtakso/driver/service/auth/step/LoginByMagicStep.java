package ee.mtakso.driver.service.auth.step;

import ee.mtakso.driver.deeplink.DeepLinkManager;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient;
import ee.mtakso.driver.network.client.auth.anonymous.AuthResult;
import ee.mtakso.driver.network.client.auth.anonymous.RefreshToken;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.platform.store_integrity.StoreIntegrityVerificationResult;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.service.auth.LoginWay;
import ee.mtakso.driver.utils.SingleExtKt;
import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import ee.mtakso.driver.utils.flow.FlowStep;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoginByMagicStep.kt */
/* loaded from: classes3.dex */
public final class LoginByMagicStep implements FlowStep<AuthStepResult> {

    /* renamed from: a  reason: collision with root package name */
    private final AnonymousAuthClient f23837a;

    /* renamed from: b  reason: collision with root package name */
    private final DeepLinkManager f23838b;

    /* renamed from: c  reason: collision with root package name */
    private final DeviceSettings f23839c;

    /* renamed from: d  reason: collision with root package name */
    private final StoreIntegrityVerificationResult f23840d;

    public LoginByMagicStep(AnonymousAuthClient anonymousAuthClient, DeepLinkManager deepLinkManager, DeviceSettings deviceSettings, StoreIntegrityVerificationResult storeIntegrityVerificationResult) {
        Intrinsics.f(anonymousAuthClient, "anonymousAuthClient");
        Intrinsics.f(deepLinkManager, "deepLinkManager");
        Intrinsics.f(deviceSettings, "deviceSettings");
        this.f23837a = anonymousAuthClient;
        this.f23838b = deepLinkManager;
        this.f23839c = deviceSettings;
        this.f23840d = storeIntegrityVerificationResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthStepResult f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (AuthStepResult) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthStepResult h(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (AuthStepResult) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthStepResult i(Throwable it) {
        Intrinsics.f(it, "it");
        if (ApiExceptionUtils.m(it, 5460)) {
            return new AuthStepResult.Error(it);
        }
        return new AuthStepResult.LoginMethod(LoginWay.BY_PASSWORD);
    }

    @Override // ee.mtakso.driver.utils.flow.FlowStep
    public Observable<AuthStepResult> call() {
        DeeplinkCall c8 = this.f23838b.c(DeeplinkCall.MagicLogin.class);
        Intrinsics.d(c8, "null cannot be cast to non-null type ee.mtakso.driver.deeplink.DeeplinkCall.MagicLogin");
        DeeplinkCall.MagicLogin magicLogin = (DeeplinkCall.MagicLogin) c8;
        if (magicLogin.b()) {
            Observable just = Observable.just(new AuthStepResult.Message("Logging by magic..."));
            Single<RefreshToken> r7 = this.f23837a.r(magicLogin.c());
            final Function1<RefreshToken, AuthStepResult> function1 = new Function1<RefreshToken, AuthStepResult>() { // from class: ee.mtakso.driver.service.auth.step.LoginByMagicStep$call$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final AuthStepResult invoke(RefreshToken it) {
                    DeviceSettings deviceSettings;
                    Intrinsics.f(it, "it");
                    deviceSettings = LoginByMagicStep.this.f23839c;
                    deviceSettings.s(it.a());
                    return new AuthStepResult.AuthenticationResult(new AuthResult.PartnerSuccess(it.a()));
                }
            };
            Single D = r7.x(new Function() { // from class: ee.mtakso.driver.service.auth.step.o
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    AuthStepResult f8;
                    f8 = LoginByMagicStep.f(Function1.this, obj);
                    return f8;
                }
            }).D(new AuthStepResult.LoginMethod(LoginWay.BY_PASSWORD));
            Intrinsics.e(D, "override fun call(): Obs…       )\n        }\n\n    }");
            Observable<AuthStepResult> mergeWith = just.mergeWith(SingleExtKt.d(D));
            Intrinsics.e(mergeWith, "override fun call(): Obs…       )\n        }\n\n    }");
            return mergeWith;
        }
        Observable just2 = Observable.just(new AuthStepResult.Message("Logging by magic..."));
        Single<RefreshToken> s7 = this.f23837a.s(magicLogin.c(), this.f23840d);
        final Function1<RefreshToken, Unit> function12 = new Function1<RefreshToken, Unit>() { // from class: ee.mtakso.driver.service.auth.step.LoginByMagicStep$call$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(RefreshToken refreshToken) {
                DeviceSettings deviceSettings;
                deviceSettings = LoginByMagicStep.this.f23839c;
                deviceSettings.t(refreshToken.a());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RefreshToken refreshToken) {
                b(refreshToken);
                return Unit.f50853a;
            }
        };
        Single<RefreshToken> o8 = s7.o(new Consumer() { // from class: ee.mtakso.driver.service.auth.step.p
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LoginByMagicStep.g(Function1.this, obj);
            }
        });
        final LoginByMagicStep$call$3 loginByMagicStep$call$3 = new Function1<RefreshToken, AuthStepResult>() { // from class: ee.mtakso.driver.service.auth.step.LoginByMagicStep$call$3
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final AuthStepResult invoke(RefreshToken it) {
                Intrinsics.f(it, "it");
                return new AuthStepResult.LoginMethod(LoginWay.BY_REFRESH);
            }
        };
        Single C = o8.x(new Function() { // from class: ee.mtakso.driver.service.auth.step.q
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AuthStepResult h8;
                h8 = LoginByMagicStep.h(Function1.this, obj);
                return h8;
            }
        }).C(new Function() { // from class: ee.mtakso.driver.service.auth.step.r
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AuthStepResult i8;
                i8 = LoginByMagicStep.i((Throwable) obj);
                return i8;
            }
        });
        Intrinsics.e(C, "override fun call(): Obs…       )\n        }\n\n    }");
        Observable<AuthStepResult> mergeWith2 = just2.mergeWith(SingleExtKt.d(C));
        Intrinsics.e(mergeWith2, "override fun call(): Obs…       )\n        }\n\n    }");
        return mergeWith2;
    }
}
