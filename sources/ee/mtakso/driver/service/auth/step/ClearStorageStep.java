package ee.mtakso.driver.service.auth.step;

import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.utils.flow.FlowStep;
import io.reactivex.Observable;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClearStorageStep.kt */
/* loaded from: classes3.dex */
public final class ClearStorageStep implements FlowStep<AuthStepResult> {

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f23820a;

    /* renamed from: b  reason: collision with root package name */
    private final DeviceSettings f23821b;

    public ClearStorageStep(DriverProvider driverProvider, DeviceSettings deviceSettings) {
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(deviceSettings, "deviceSettings");
        this.f23820a = driverProvider;
        this.f23821b = deviceSettings;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthStepResult b(ClearStorageStep this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.f23821b.n();
        this$0.f23820a.k();
        return AuthStepResult.DriverCleared.f23682a;
    }

    @Override // ee.mtakso.driver.utils.flow.FlowStep
    public Observable<AuthStepResult> call() {
        Observable<AuthStepResult> fromCallable = Observable.fromCallable(new Callable() { // from class: ee.mtakso.driver.service.auth.step.h
            @Override // java.util.concurrent.Callable
            public final Object call() {
                AuthStepResult b8;
                b8 = ClearStorageStep.b(ClearStorageStep.this);
                return b8;
            }
        });
        Intrinsics.e(fromCallable, "fromCallable {\n         …t.DriverCleared\n        }");
        return fromCallable;
    }
}
