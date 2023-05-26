package ee.mtakso.driver.service.auth.step;

import ee.mtakso.driver.network.client.auth.authenticated.AuthenticatedAuthClient;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.utils.SingleExtKt;
import ee.mtakso.driver.utils.flow.FlowStep;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogoutStep.kt */
/* loaded from: classes3.dex */
public final class LogoutStep implements FlowStep<AuthStepResult> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthenticatedAuthClient f23846a;

    public LogoutStep(AuthenticatedAuthClient authClient) {
        Intrinsics.f(authClient, "authClient");
        this.f23846a = authClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthStepResult.Logout b(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (AuthStepResult.Logout) tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.utils.flow.FlowStep
    public Observable<AuthStepResult> call() {
        Observable just = Observable.just(new AuthStepResult.Message("Logging out..."));
        Single<EmptyServerResponse> b8 = this.f23846a.b();
        final LogoutStep$call$1 logoutStep$call$1 = new Function1<EmptyServerResponse, AuthStepResult.Logout>() { // from class: ee.mtakso.driver.service.auth.step.LogoutStep$call$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final AuthStepResult.Logout invoke(EmptyServerResponse it) {
                Intrinsics.f(it, "it");
                return AuthStepResult.Logout.f23689a;
            }
        };
        Single<R> x7 = b8.x(new Function() { // from class: ee.mtakso.driver.service.auth.step.t
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AuthStepResult.Logout b9;
                b9 = LogoutStep.b(Function1.this, obj);
                return b9;
            }
        });
        Intrinsics.e(x7, "authClient.logout()\n    …{ AuthStepResult.Logout }");
        Observable<AuthStepResult> concatWith = just.concatWith(SingleExtKt.d(x7));
        Intrinsics.e(concatWith, "just<AuthStepResult>(Aut…    .applyIOSchedulers())");
        return concatWith;
    }
}
