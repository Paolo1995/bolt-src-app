package ee.mtakso.driver.service.auth.step;

import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient;
import ee.mtakso.driver.network.client.auth.anonymous.AuthResult;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.flow.FlowStep;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthConfirmationStep.kt */
/* loaded from: classes3.dex */
public final class AuthConfirmationStep implements FlowStep<AuthStepResult> {

    /* renamed from: a  reason: collision with root package name */
    private final String f23808a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23809b;

    /* renamed from: c  reason: collision with root package name */
    private final AnonymousAuthClient f23810c;

    public AuthConfirmationStep(String token, String code, AnonymousAuthClient client) {
        Intrinsics.f(token, "token");
        Intrinsics.f(code, "code");
        Intrinsics.f(client, "client");
        this.f23808a = token;
        this.f23809b = code;
        this.f23810c = client;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthStepResult.AuthenticationResult b(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (AuthStepResult.AuthenticationResult) tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.utils.flow.FlowStep
    public Observable<AuthStepResult> call() {
        Observable just = Observable.just(AuthStepResult.ConfirmationStarted.f23680a);
        Single<AuthResult.Success> u7 = this.f23810c.u(this.f23808a, this.f23809b);
        final AuthConfirmationStep$call$1 authConfirmationStep$call$1 = new Function1<AuthResult.Success, AuthStepResult.AuthenticationResult>() { // from class: ee.mtakso.driver.service.auth.step.AuthConfirmationStep$call$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final AuthStepResult.AuthenticationResult invoke(AuthResult.Success it) {
                Intrinsics.f(it, "it");
                return new AuthStepResult.AuthenticationResult(it);
            }
        };
        Observable concatWith = just.concatWith(u7.x(new Function() { // from class: ee.mtakso.driver.service.auth.step.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AuthStepResult.AuthenticationResult b8;
                b8 = AuthConfirmationStep.b(Function1.this, obj);
                return b8;
            }
        }));
        Intrinsics.e(concatWith, "just<AuthStepResult>(Aut…thenticationResult(it) })");
        return ObservableExtKt.g(concatWith);
    }
}
