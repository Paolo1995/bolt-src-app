package ee.mtakso.driver.service.modules.status;

import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.geo.GeoLocationManagerState;
import ee.mtakso.driver.service.modules.status.GoOnlineStepResult;
import ee.mtakso.driver.utils.flow.FlowStep;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoOnlineLocationStep.kt */
/* loaded from: classes3.dex */
public final class GoOnlineLocationStep implements FlowStep<GoOnlineStepResult> {

    /* renamed from: a  reason: collision with root package name */
    private final GeoLocationManager f25270a;

    public GoOnlineLocationStep(GeoLocationManager locationManager) {
        Intrinsics.f(locationManager, "locationManager");
        this.f25270a = locationManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GoOnlineStepResult b(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (GoOnlineStepResult) tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.utils.flow.FlowStep
    public Observable<GoOnlineStepResult> call() {
        Observable<GeoLocationManagerState> take = this.f25270a.v().take(1L);
        final GoOnlineLocationStep$call$1 goOnlineLocationStep$call$1 = new Function1<GeoLocationManagerState, GoOnlineStepResult>() { // from class: ee.mtakso.driver.service.modules.status.GoOnlineLocationStep$call$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final GoOnlineStepResult invoke(GeoLocationManagerState it) {
                Intrinsics.f(it, "it");
                return new GoOnlineStepResult.LocationCheck(it);
            }
        };
        Observable map = take.map(new Function() { // from class: ee.mtakso.driver.service.modules.status.n
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                GoOnlineStepResult b8;
                b8 = GoOnlineLocationStep.b(Function1.this, obj);
                return b8;
            }
        });
        Intrinsics.e(map, "locationManager\n        …esult.LocationCheck(it) }");
        return map;
    }
}
