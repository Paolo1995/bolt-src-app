package ee.mtakso.driver.service.auth.step;

import ee.mtakso.driver.network.client.driver.DriverConfigurationClient;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.service.auth.TempDriverConfigHolder;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.flow.FlowStep;
import eu.bolt.driver.core.network.client.driver.DriverConfiguration;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverConfigStep.kt */
/* loaded from: classes3.dex */
public final class DriverConfigStep implements FlowStep<AuthStepResult> {

    /* renamed from: a  reason: collision with root package name */
    private final DriverConfigurationClient f23823a;

    /* renamed from: b  reason: collision with root package name */
    private final TempDriverConfigHolder f23824b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverProvider f23825c;

    /* renamed from: d  reason: collision with root package name */
    private final AuthManager f23826d;

    public DriverConfigStep(DriverConfigurationClient driverConfigurationClient, TempDriverConfigHolder holder, DriverProvider provider, AuthManager authManager) {
        Intrinsics.f(driverConfigurationClient, "driverConfigurationClient");
        Intrinsics.f(holder, "holder");
        Intrinsics.f(provider, "provider");
        Intrinsics.f(authManager, "authManager");
        this.f23823a = driverConfigurationClient;
        this.f23824b = holder;
        this.f23825c = provider;
        this.f23826d = authManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthStepResult.DriverConfigurationResult f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (AuthStepResult.DriverConfigurationResult) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.utils.flow.FlowStep
    public Observable<AuthStepResult> call() {
        Single<DriverConfiguration> b8 = this.f23823a.b();
        final DriverConfigStep$call$driverConfigSingle$1 driverConfigStep$call$driverConfigSingle$1 = new Function1<DriverConfiguration, AuthStepResult.DriverConfigurationResult>() { // from class: ee.mtakso.driver.service.auth.step.DriverConfigStep$call$driverConfigSingle$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final AuthStepResult.DriverConfigurationResult invoke(DriverConfiguration it) {
                Intrinsics.f(it, "it");
                return new AuthStepResult.DriverConfigurationResult(it);
            }
        };
        Single<R> x7 = b8.x(new Function() { // from class: ee.mtakso.driver.service.auth.step.j
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AuthStepResult.DriverConfigurationResult f8;
                f8 = DriverConfigStep.f(Function1.this, obj);
                return f8;
            }
        });
        final Function1<AuthStepResult.DriverConfigurationResult, Unit> function1 = new Function1<AuthStepResult.DriverConfigurationResult, Unit>() { // from class: ee.mtakso.driver.service.auth.step.DriverConfigStep$call$driverConfigSingle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(AuthStepResult.DriverConfigurationResult driverConfigurationResult) {
                TempDriverConfigHolder tempDriverConfigHolder;
                DriverProvider driverProvider;
                AuthManager authManager;
                tempDriverConfigHolder = DriverConfigStep.this.f23824b;
                tempDriverConfigHolder.a(driverConfigurationResult.a());
                driverProvider = DriverConfigStep.this.f23825c;
                driverProvider.x(driverConfigurationResult.a().d().i(), driverConfigurationResult.a().d().d());
                authManager = DriverConfigStep.this.f23826d;
                authManager.u(driverConfigurationResult.a());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AuthStepResult.DriverConfigurationResult driverConfigurationResult) {
                b(driverConfigurationResult);
                return Unit.f50853a;
            }
        };
        Single o8 = x7.o(new Consumer() { // from class: ee.mtakso.driver.service.auth.step.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverConfigStep.g(Function1.this, obj);
            }
        });
        Intrinsics.e(o8, "override fun call(): Obs…applyIOSchedulers()\n    }");
        Observable mergeWith = Observable.just(new AuthStepResult.Message("Loading config...")).mergeWith(o8);
        Intrinsics.e(mergeWith, "just<AuthStepResult>(Aut…eWith(driverConfigSingle)");
        return ObservableExtKt.g(mergeWith);
    }
}
