package ee.mtakso.driver.service.auth.step;

import android.content.Context;
import android.content.pm.PackageManager;
import ee.mtakso.driver.platform.store_integrity.StoreIntegrityCheck;
import ee.mtakso.driver.platform.store_integrity.StoreIntegrityVerificationResult;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.service.auth.StoreVerificationBackoffStrategy;
import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import ee.mtakso.driver.utils.flow.FlowStep;
import eu.bolt.driver.core.util.PlatformManagerExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Publisher;

/* compiled from: StoreVerificationStep.kt */
/* loaded from: classes3.dex */
public final class StoreVerificationStep implements FlowStep<AuthStepResult> {

    /* renamed from: a  reason: collision with root package name */
    private final StoreIntegrityCheck f23881a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23882b;

    /* renamed from: c  reason: collision with root package name */
    private final StoreVerificationBackoffStrategy f23883c;

    /* renamed from: d  reason: collision with root package name */
    private final Lazy f23884d;

    public StoreVerificationStep(final Context applicationContext, StoreIntegrityCheck integrityCheck, String nonce, StoreVerificationBackoffStrategy storeVerificationBackoffStrategy) {
        Lazy b8;
        Intrinsics.f(applicationContext, "applicationContext");
        Intrinsics.f(integrityCheck, "integrityCheck");
        Intrinsics.f(nonce, "nonce");
        Intrinsics.f(storeVerificationBackoffStrategy, "storeVerificationBackoffStrategy");
        this.f23881a = integrityCheck;
        this.f23882b = nonce;
        this.f23883c = storeVerificationBackoffStrategy;
        b8 = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: ee.mtakso.driver.service.auth.step.StoreVerificationStep$versionCode$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final String invoke() {
                PackageManager packageManager = applicationContext.getPackageManager();
                Intrinsics.e(packageManager, "applicationContext\n            .packageManager");
                String packageName = applicationContext.getPackageName();
                Intrinsics.e(packageName, "applicationContext.packageName");
                return String.valueOf(PlatformManagerExtKt.b(packageManager, packageName));
            }
        });
        this.f23884d = b8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Publisher e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Publisher) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthStepResult g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (AuthStepResult) tmp0.invoke(obj);
    }

    private final String h() {
        return (String) this.f23884d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flowable<Long> i(Flowable<Throwable> flowable) {
        Kalev.d("Store integrity retry triggered: " + flowable);
        return this.f23883c.b(flowable, new Function1<Throwable, Boolean>() { // from class: ee.mtakso.driver.service.auth.step.StoreVerificationStep$retryIntegrityCheck$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(Throwable error) {
                StoreIntegrityVerificationResult.Error error2;
                boolean z7;
                Intrinsics.f(error, "error");
                StoreIntegrityVerificationResult.ErrorType errorType = null;
                if (error instanceof StoreIntegrityVerificationResult.Error) {
                    error2 = (StoreIntegrityVerificationResult.Error) error;
                } else {
                    error2 = null;
                }
                if (error2 != null) {
                    errorType = error2.b();
                }
                if (errorType == StoreIntegrityVerificationResult.ErrorType.RETRY_OR_BACKEND_HANDLING_REQUIRED && !ApiExceptionUtils.m(error, 23, 22)) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                return Boolean.valueOf(z7);
            }
        });
    }

    @Override // ee.mtakso.driver.utils.flow.FlowStep
    public Observable<AuthStepResult> call() {
        Kalev.j("Store Integrity");
        Single<StoreIntegrityVerificationResult> a8 = this.f23881a.a(this.f23882b, h());
        final Function1<Flowable<Throwable>, Publisher<?>> function1 = new Function1<Flowable<Throwable>, Publisher<?>>() { // from class: ee.mtakso.driver.service.auth.step.StoreVerificationStep$call$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Publisher<?> invoke(Flowable<Throwable> it) {
                Flowable i8;
                Intrinsics.f(it, "it");
                i8 = StoreVerificationStep.this.i(it);
                return i8;
            }
        };
        Single<StoreIntegrityVerificationResult> F = a8.F(new Function() { // from class: ee.mtakso.driver.service.auth.step.j0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Publisher e8;
                e8 = StoreVerificationStep.e(Function1.this, obj);
                return e8;
            }
        });
        final StoreVerificationStep$call$2 storeVerificationStep$call$2 = new Function1<Throwable, SingleSource<? extends StoreIntegrityVerificationResult>>() { // from class: ee.mtakso.driver.service.auth.step.StoreVerificationStep$call$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends StoreIntegrityVerificationResult> invoke(Throwable it) {
                StoreIntegrityVerificationResult.Error error;
                Intrinsics.f(it, "it");
                Kalev.d("Store integrity verification failed: " + it);
                StoreIntegrityVerificationResult.ErrorType errorType = null;
                if (it instanceof StoreIntegrityVerificationResult.Error) {
                    error = (StoreIntegrityVerificationResult.Error) it;
                } else {
                    error = null;
                }
                if (error != null) {
                    errorType = error.b();
                }
                if (errorType == StoreIntegrityVerificationResult.ErrorType.RETRY_OR_BACKEND_HANDLING_REQUIRED) {
                    return Single.w(it);
                }
                return Single.error(it);
            }
        };
        Observable<StoreIntegrityVerificationResult> R = F.B(new Function() { // from class: ee.mtakso.driver.service.auth.step.k0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource f8;
                f8 = StoreVerificationStep.f(Function1.this, obj);
                return f8;
            }
        }).R();
        final StoreVerificationStep$call$3 storeVerificationStep$call$3 = new Function1<StoreIntegrityVerificationResult, AuthStepResult>() { // from class: ee.mtakso.driver.service.auth.step.StoreVerificationStep$call$3
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final AuthStepResult invoke(StoreIntegrityVerificationResult it) {
                Intrinsics.f(it, "it");
                return new AuthStepResult.StoreIntegrityVerification(it);
            }
        };
        Observable map = R.map(new Function() { // from class: ee.mtakso.driver.service.auth.step.l0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AuthStepResult g8;
                g8 = StoreVerificationStep.g(Function1.this, obj);
                return g8;
            }
        });
        Intrinsics.e(map, "override fun call(): Obs…n(it)\n            }\n    }");
        return map;
    }
}
