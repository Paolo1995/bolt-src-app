package ee.mtakso.driver.service.auth.step;

import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient;
import ee.mtakso.driver.network.client.auth.anonymous.AuthConfigurationResponse;
import ee.mtakso.driver.network.client.auth.anonymous.AuthenticationConfigurationAppStore;
import ee.mtakso.driver.network.client.auth.anonymous.AuthenticationConfigurationAuthMethod;
import ee.mtakso.driver.platform.core.PlatformType;
import ee.mtakso.driver.service.auth.AuthConfigurationBackoffStrategy;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import ee.mtakso.driver.utils.flow.FlowStep;
import eu.bolt.kalev.Kalev;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Publisher;

/* compiled from: AuthConfigurationStep.kt */
/* loaded from: classes3.dex */
public final class AuthConfigurationStep implements FlowStep<AuthStepResult> {

    /* renamed from: a  reason: collision with root package name */
    private final AnonymousAuthClient f23799a;

    /* renamed from: b  reason: collision with root package name */
    private final AuthConfigurationBackoffStrategy f23800b;

    /* renamed from: c  reason: collision with root package name */
    private final AuthenticationConfigurationAuthMethod f23801c;

    /* renamed from: d  reason: collision with root package name */
    private final AuthenticationConfigurationAppStore f23802d;

    /* compiled from: AuthConfigurationStep.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f23803a;

        static {
            int[] iArr = new int[PlatformType.values().length];
            try {
                iArr[PlatformType.GMS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PlatformType.HMS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f23803a = iArr;
        }
    }

    public AuthConfigurationStep(AnonymousAuthClient client, AuthConfigurationBackoffStrategy authConfigurationBackoffStrategy, AuthenticationConfigurationAuthMethod authMethod, PlatformType platformType) {
        AuthenticationConfigurationAppStore authenticationConfigurationAppStore;
        Intrinsics.f(client, "client");
        Intrinsics.f(authConfigurationBackoffStrategy, "authConfigurationBackoffStrategy");
        Intrinsics.f(authMethod, "authMethod");
        Intrinsics.f(platformType, "platformType");
        this.f23799a = client;
        this.f23800b = authConfigurationBackoffStrategy;
        this.f23801c = authMethod;
        int i8 = WhenMappings.f23803a[platformType.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                authenticationConfigurationAppStore = AuthenticationConfigurationAppStore.APP_GALLERY;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            authenticationConfigurationAppStore = AuthenticationConfigurationAppStore.PLAY_STORE;
        }
        this.f23802d = authenticationConfigurationAppStore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Publisher e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Publisher) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthStepResult.AuthConfiguration g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (AuthStepResult.AuthConfiguration) tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.utils.flow.FlowStep
    public Observable<AuthStepResult> call() {
        Observable just = Observable.just(new AuthStepResult.Message("Loading Authentication configuration..."));
        Single<AuthConfigurationResponse> A = this.f23799a.A(this.f23801c, this.f23802d);
        final Function1<Flowable<Throwable>, Publisher<?>> function1 = new Function1<Flowable<Throwable>, Publisher<?>>() { // from class: ee.mtakso.driver.service.auth.step.AuthConfigurationStep$call$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Publisher<?> invoke(Flowable<Throwable> it) {
                AuthConfigurationBackoffStrategy authConfigurationBackoffStrategy;
                Intrinsics.f(it, "it");
                authConfigurationBackoffStrategy = AuthConfigurationStep.this.f23800b;
                return authConfigurationBackoffStrategy.c(it, new Function1<Throwable, Boolean>() { // from class: ee.mtakso.driver.service.auth.step.AuthConfigurationStep$call$1.1
                    @Override // kotlin.jvm.functions.Function1
                    /* renamed from: b */
                    public final Boolean invoke(Throwable error) {
                        Intrinsics.f(error, "error");
                        return Boolean.valueOf(ApiExceptionUtils.m(error, 23, 22));
                    }
                });
            }
        };
        Single<AuthConfigurationResponse> F = A.F(new Function() { // from class: ee.mtakso.driver.service.auth.step.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Publisher e8;
                e8 = AuthConfigurationStep.e(Function1.this, obj);
                return e8;
            }
        });
        final AuthConfigurationStep$call$2 authConfigurationStep$call$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.auth.step.AuthConfigurationStep$call$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "getAuthenticationConfiguration failed");
            }
        };
        Single<AuthConfigurationResponse> D = F.l(new Consumer() { // from class: ee.mtakso.driver.service.auth.step.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AuthConfigurationStep.f(Function1.this, obj);
            }
        }).D(new AuthConfigurationResponse(null));
        final AuthConfigurationStep$call$3 authConfigurationStep$call$3 = new Function1<AuthConfigurationResponse, AuthStepResult.AuthConfiguration>() { // from class: ee.mtakso.driver.service.auth.step.AuthConfigurationStep$call$3
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final AuthStepResult.AuthConfiguration invoke(AuthConfigurationResponse it) {
                Intrinsics.f(it, "it");
                return new AuthStepResult.AuthConfiguration(it);
            }
        };
        Observable mergeWith = just.mergeWith(D.x(new Function() { // from class: ee.mtakso.driver.service.auth.step.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AuthStepResult.AuthConfiguration g8;
                g8 = AuthConfigurationStep.g(Function1.this, obj);
                return g8;
            }
        }));
        Intrinsics.e(mergeWith, "override fun call(): Obs…applyIOSchedulers()\n    }");
        return ObservableExtKt.g(mergeWith);
    }
}
