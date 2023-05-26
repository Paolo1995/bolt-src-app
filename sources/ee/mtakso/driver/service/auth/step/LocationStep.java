package ee.mtakso.driver.service.auth.step;

import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.utils.flow.FlowStep;
import eu.bolt.driver.core.permission.PermissionManager;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocationStep.kt */
/* loaded from: classes3.dex */
public final class LocationStep implements FlowStep<AuthStepResult> {

    /* renamed from: a  reason: collision with root package name */
    private final GeoLocationManager f23835a;

    public LocationStep(GeoLocationManager locationManager) {
        Intrinsics.f(locationManager, "locationManager");
        this.f23835a = locationManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthStepResult.LocationPermission b(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (AuthStepResult.LocationPermission) tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.utils.flow.FlowStep
    public Observable<AuthStepResult> call() {
        Observable just = Observable.just(new AuthStepResult.Message("Checking location permission"));
        Single<PermissionManager.PermissionInfo> B = this.f23835a.B();
        final LocationStep$call$1 locationStep$call$1 = new Function1<PermissionManager.PermissionInfo, AuthStepResult.LocationPermission>() { // from class: ee.mtakso.driver.service.auth.step.LocationStep$call$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final AuthStepResult.LocationPermission invoke(PermissionManager.PermissionInfo it) {
                Intrinsics.f(it, "it");
                return new AuthStepResult.LocationPermission(it);
            }
        };
        Observable<AuthStepResult> mergeWith = just.mergeWith(B.x(new Function() { // from class: ee.mtakso.driver.service.auth.step.n
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AuthStepResult.LocationPermission b8;
                b8 = LocationStep.b(Function1.this, obj);
                return b8;
            }
        }));
        Intrinsics.e(mergeWith, "just<AuthStepResult>(Aut…ssion(it) }\n            )");
        return mergeWith;
    }
}
