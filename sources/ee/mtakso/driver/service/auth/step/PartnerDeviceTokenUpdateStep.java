package ee.mtakso.driver.service.auth.step;

import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.service.push.PushManagerImpl;
import ee.mtakso.driver.utils.flow.FlowStep;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PartnerDeviceTokenUpdateStep.kt */
/* loaded from: classes3.dex */
public final class PartnerDeviceTokenUpdateStep implements FlowStep<AuthStepResult> {

    /* renamed from: a  reason: collision with root package name */
    private final PushManagerImpl f23856a;

    /* renamed from: b  reason: collision with root package name */
    private final AuthManager f23857b;

    public PartnerDeviceTokenUpdateStep(PushManagerImpl pushManager, AuthManager authManager) {
        Intrinsics.f(pushManager, "pushManager");
        Intrinsics.f(authManager, "authManager");
        this.f23856a = pushManager;
        this.f23857b = authManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthStepResult c() {
        return new AuthStepResult.Message("Started OTP authentication");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthStepResult.PartnerPushTokenUpdateRequested d(PartnerDeviceTokenUpdateStep this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.f23857b.k();
        this$0.f23856a.i();
        return AuthStepResult.PartnerPushTokenUpdateRequested.f23691a;
    }

    @Override // ee.mtakso.driver.utils.flow.FlowStep
    public Observable<AuthStepResult> call() {
        Observable R = Single.u(new Callable() { // from class: ee.mtakso.driver.service.auth.step.y
            @Override // java.util.concurrent.Callable
            public final Object call() {
                AuthStepResult c8;
                c8 = PartnerDeviceTokenUpdateStep.c();
                return c8;
            }
        }).R();
        Single u7 = Single.u(new Callable() { // from class: ee.mtakso.driver.service.auth.step.z
            @Override // java.util.concurrent.Callable
            public final Object call() {
                AuthStepResult.PartnerPushTokenUpdateRequested d8;
                d8 = PartnerDeviceTokenUpdateStep.d(PartnerDeviceTokenUpdateStep.this);
                return d8;
            }
        });
        Intrinsics.e(u7, "fromCallable {\n         …UpdateRequested\n        }");
        Observable<AuthStepResult> concatWith = R.concatWith(u7);
        Intrinsics.e(concatWith, "message.concatWith(action)");
        return concatWith;
    }
}
