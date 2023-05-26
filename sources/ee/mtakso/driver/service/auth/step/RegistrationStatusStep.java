package ee.mtakso.driver.service.auth.step;

import ee.mtakso.driver.network.client.auth.anonymous.AccessToken;
import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient;
import ee.mtakso.driver.network.client.registration.DriverRegistrationClient;
import ee.mtakso.driver.network.client.registration.DriverRegistrationCompletionStatus;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.service.auth.NextScreen;
import ee.mtakso.driver.service.push.PushManagerImpl;
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

/* compiled from: RegistrationStatusStep.kt */
/* loaded from: classes3.dex */
public final class RegistrationStatusStep implements FlowStep<AuthStepResult> {

    /* renamed from: a  reason: collision with root package name */
    private final DeviceSettings f23867a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverRegistrationClient f23868b;

    /* renamed from: c  reason: collision with root package name */
    private final AnonymousAuthClient f23869c;

    /* renamed from: d  reason: collision with root package name */
    private final PushManagerImpl f23870d;

    /* renamed from: e  reason: collision with root package name */
    private final AuthManager f23871e;

    public RegistrationStatusStep(DeviceSettings deviceSettings, DriverRegistrationClient driverRegistrationClient, AnonymousAuthClient authClient, PushManagerImpl pushManager, AuthManager authManager) {
        Intrinsics.f(deviceSettings, "deviceSettings");
        Intrinsics.f(driverRegistrationClient, "driverRegistrationClient");
        Intrinsics.f(authClient, "authClient");
        Intrinsics.f(pushManager, "pushManager");
        Intrinsics.f(authManager, "authManager");
        this.f23867a = deviceSettings;
        this.f23868b = driverRegistrationClient;
        this.f23869c = authClient;
        this.f23870d = pushManager;
        this.f23871e = authManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthStepResult.RoutingAction l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (AuthStepResult.RoutingAction) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m(DriverRegistrationCompletionStatus driverRegistrationCompletionStatus) {
        if (driverRegistrationCompletionStatus.a() == 1) {
            return true;
        }
        return false;
    }

    private final Single<NextScreen> n(String str) {
        Single d8 = SingleExtKt.d(this.f23869c.C(str));
        final RegistrationStatusStep$loadPartnerStatus$1 registrationStatusStep$loadPartnerStatus$1 = new Function1<AccessToken, NextScreen>() { // from class: ee.mtakso.driver.service.auth.step.RegistrationStatusStep$loadPartnerStatus$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final NextScreen invoke(AccessToken it) {
                boolean z7;
                Intrinsics.f(it, "it");
                if (it.a().length() > 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    return NextScreen.CONTINUE_REGISTRATION_SIGNUP;
                }
                return NextScreen.OPEN_LANDING;
            }
        };
        Single x7 = d8.x(new Function() { // from class: ee.mtakso.driver.service.auth.step.e0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                NextScreen o8;
                o8 = RegistrationStatusStep.o(Function1.this, obj);
                return o8;
            }
        });
        final Function1<Throwable, Unit> function1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.auth.step.RegistrationStatusStep$loadPartnerStatus$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable error) {
                DeviceSettings deviceSettings;
                DeviceSettings deviceSettings2;
                Intrinsics.e(error, "error");
                if (ApiExceptionUtils.m(error, 5010)) {
                    deviceSettings = RegistrationStatusStep.this.f23867a;
                    deviceSettings.m().b(null);
                    deviceSettings2 = RegistrationStatusStep.this.f23867a;
                    deviceSettings2.s("");
                }
            }
        };
        Single<NextScreen> D = x7.l(new Consumer() { // from class: ee.mtakso.driver.service.auth.step.f0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RegistrationStatusStep.p(Function1.this, obj);
            }
        }).D(NextScreen.OPEN_LANDING);
        Intrinsics.e(D, "private fun loadPartnerS…creen.OPEN_LANDING)\n    }");
        return D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NextScreen o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (NextScreen) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final Single<NextScreen> q(String str) {
        Single<DriverRegistrationCompletionStatus> a8 = this.f23868b.a(str);
        final Function1<DriverRegistrationCompletionStatus, NextScreen> function1 = new Function1<DriverRegistrationCompletionStatus, NextScreen>() { // from class: ee.mtakso.driver.service.auth.step.RegistrationStatusStep$loadRegistrationStatus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final NextScreen invoke(DriverRegistrationCompletionStatus it) {
                boolean m8;
                Intrinsics.f(it, "it");
                m8 = RegistrationStatusStep.this.m(it);
                if (m8) {
                    return NextScreen.OPEN_LANDING;
                }
                return NextScreen.CONTINUE_REGISTRATION;
            }
        };
        Single<R> x7 = a8.x(new Function() { // from class: ee.mtakso.driver.service.auth.step.g0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                NextScreen r7;
                r7 = RegistrationStatusStep.r(Function1.this, obj);
                return r7;
            }
        });
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.auth.step.RegistrationStatusStep$loadRegistrationStatus$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable error) {
                DeviceSettings deviceSettings;
                Intrinsics.e(error, "error");
                if (ApiExceptionUtils.m(error, 5010)) {
                    deviceSettings = RegistrationStatusStep.this.f23867a;
                    deviceSettings.m().b(null);
                }
            }
        };
        Single<NextScreen> l8 = x7.l(new Consumer() { // from class: ee.mtakso.driver.service.auth.step.h0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RegistrationStatusStep.s(Function1.this, obj);
            }
        });
        Intrinsics.e(l8, "private fun loadRegistra…    }\n            }\n    }");
        return l8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NextScreen r(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (NextScreen) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.utils.flow.FlowStep
    public Observable<AuthStepResult> call() {
        boolean z7;
        Single<NextScreen> q8;
        String a8 = this.f23867a.m().a();
        String j8 = this.f23867a.j();
        boolean z8 = true;
        if (j8.length() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            q8 = n(j8);
        } else {
            if (a8 != null && a8.length() != 0) {
                z8 = false;
            }
            if (z8) {
                q8 = Single.w(NextScreen.OPEN_LANDING);
                Intrinsics.e(q8, "just(NextScreen.OPEN_LANDING)");
            } else {
                q8 = q(a8);
            }
        }
        Observable just = Observable.just(new AuthStepResult.Message("Checking registration status"));
        final Function1<NextScreen, Unit> function1 = new Function1<NextScreen, Unit>() { // from class: ee.mtakso.driver.service.auth.step.RegistrationStatusStep$call$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(NextScreen nextScreen) {
                AuthManager authManager;
                AuthManager authManager2;
                PushManagerImpl pushManagerImpl;
                if (nextScreen == NextScreen.CONTINUE_REGISTRATION_SIGNUP) {
                    authManager2 = RegistrationStatusStep.this.f23871e;
                    authManager2.k();
                    pushManagerImpl = RegistrationStatusStep.this.f23870d;
                    pushManagerImpl.i();
                    return;
                }
                authManager = RegistrationStatusStep.this.f23871e;
                authManager.j();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NextScreen nextScreen) {
                b(nextScreen);
                return Unit.f50853a;
            }
        };
        Single<NextScreen> o8 = q8.o(new Consumer() { // from class: ee.mtakso.driver.service.auth.step.c0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RegistrationStatusStep.k(Function1.this, obj);
            }
        });
        final RegistrationStatusStep$call$2 registrationStatusStep$call$2 = new Function1<NextScreen, AuthStepResult.RoutingAction>() { // from class: ee.mtakso.driver.service.auth.step.RegistrationStatusStep$call$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final AuthStepResult.RoutingAction invoke(NextScreen it) {
                Intrinsics.f(it, "it");
                return new AuthStepResult.RoutingAction(it);
            }
        };
        Observable<AuthStepResult> mergeWith = just.mergeWith(o8.x(new Function() { // from class: ee.mtakso.driver.service.auth.step.d0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AuthStepResult.RoutingAction l8;
                l8 = RegistrationStatusStep.l(Function1.this, obj);
                return l8;
            }
        }));
        Intrinsics.e(mergeWith, "override fun call(): Obs…it) }\n            )\n    }");
        return mergeWith;
    }
}
