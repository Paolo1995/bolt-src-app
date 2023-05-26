package ee.mtakso.driver.service.auth.step;

import ee.mtakso.driver.network.client.targeting.TargetingParameters;
import ee.mtakso.driver.param.DeviceFeatures;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.utils.flow.FlowStep;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SaveDeviceTargetingStep.kt */
/* loaded from: classes3.dex */
public final class SaveDeviceTargetingStep implements FlowStep<AuthStepResult> {

    /* renamed from: a  reason: collision with root package name */
    private final TargetingParameters f23878a;

    /* renamed from: b  reason: collision with root package name */
    private final DeviceFeatures f23879b;

    public SaveDeviceTargetingStep(TargetingParameters targetingParameters, DeviceFeatures deviceFeatures) {
        Intrinsics.f(targetingParameters, "targetingParameters");
        Intrinsics.f(deviceFeatures, "deviceFeatures");
        this.f23878a = targetingParameters;
        this.f23879b = deviceFeatures;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.utils.flow.FlowStep
    public Observable<AuthStepResult> call() {
        Observable just = Observable.just(new AuthStepResult.Message("Saving device targeting..."));
        final Function1<AuthStepResult, Unit> function1 = new Function1<AuthStepResult, Unit>() { // from class: ee.mtakso.driver.service.auth.step.SaveDeviceTargetingStep$call$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(AuthStepResult authStepResult) {
                DeviceFeatures deviceFeatures;
                TargetingParameters targetingParameters;
                deviceFeatures = SaveDeviceTargetingStep.this.f23879b;
                targetingParameters = SaveDeviceTargetingStep.this.f23878a;
                deviceFeatures.e(targetingParameters);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AuthStepResult authStepResult) {
                b(authStepResult);
                return Unit.f50853a;
            }
        };
        Observable<AuthStepResult> concatWith = just.doOnNext(new Consumer() { // from class: ee.mtakso.driver.service.auth.step.i0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SaveDeviceTargetingStep.d(Function1.this, obj);
            }
        }).concatWith(Single.w(AuthStepResult.DeviceTargetingSaved.f23681a));
        Intrinsics.e(concatWith, "override fun call(): Obs…iceTargetingSaved))\n    }");
        return concatWith;
    }
}
