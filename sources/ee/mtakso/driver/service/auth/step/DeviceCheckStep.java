package ee.mtakso.driver.service.auth.step;

import ee.mtakso.driver.platform.check.PlatformAvailabilityManager;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.utils.flow.FlowStep;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceCheckStep.kt */
/* loaded from: classes3.dex */
public final class DeviceCheckStep implements FlowStep<AuthStepResult> {

    /* renamed from: a  reason: collision with root package name */
    private final PlatformAvailabilityManager f23822a;

    public DeviceCheckStep(PlatformAvailabilityManager manager) {
        Intrinsics.f(manager, "manager");
        this.f23822a = manager;
    }

    private final Single<AuthStepResult.PlatformServicesCheckResult> b() {
        Single<AuthStepResult.PlatformServicesCheckResult> f8 = Single.f(new SingleOnSubscribe() { // from class: ee.mtakso.driver.service.auth.step.i
            @Override // io.reactivex.SingleOnSubscribe
            public final void a(SingleEmitter singleEmitter) {
                DeviceCheckStep.c(DeviceCheckStep.this, singleEmitter);
            }
        });
        Intrinsics.e(f8, "create { emitter ->\n    …vailability()))\n        }");
        return f8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(DeviceCheckStep this$0, SingleEmitter emitter) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(emitter, "emitter");
        emitter.onSuccess(new AuthStepResult.PlatformServicesCheckResult(this$0.f23822a.a()));
    }

    @Override // ee.mtakso.driver.utils.flow.FlowStep
    public Observable<AuthStepResult> call() {
        Observable<AuthStepResult> mergeWith = Observable.just(AuthStepResult.LoginStarted.f23688a).mergeWith(b());
        Intrinsics.e(mergeWith, "just<AuthStepResult>(Aut…checkPlatform()\n        )");
        return mergeWith;
    }
}
