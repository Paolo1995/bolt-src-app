package ee.mtakso.driver.service.auth.step;

import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.service.version.AppVersionStateMapper;
import ee.mtakso.driver.utils.flow.FlowStep;
import eu.bolt.driver.core.network.client.driver.DriverAppConfig;
import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CheckAppVersionStep.kt */
/* loaded from: classes3.dex */
public final class CheckAppVersionStep implements FlowStep<AuthStepResult> {

    /* renamed from: a  reason: collision with root package name */
    private final DriverAppConfig f23819a;

    public CheckAppVersionStep(DriverAppConfig driver) {
        Intrinsics.f(driver, "driver");
        this.f23819a = driver;
    }

    @Override // ee.mtakso.driver.utils.flow.FlowStep
    public Observable<AuthStepResult> call() {
        Observable<AuthStepResult> just = Observable.just(new AuthStepResult.AppVersionCheck(AppVersionStateMapper.f26098a.a(this.f23819a.b())));
        Intrinsics.e(just, "just(\n            AuthSt…)\n            )\n        )");
        return just;
    }
}
