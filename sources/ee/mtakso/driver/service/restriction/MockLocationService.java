package ee.mtakso.driver.service.restriction;

import ee.mtakso.driver.network.client.device.DriverAppDisabledReason;
import ee.mtakso.driver.service.BaseServiceImpl;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.geo.GeoLocationManagerState;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MockLocationService.kt */
/* loaded from: classes3.dex */
public final class MockLocationService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final GeoLocationManager f25853b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverRestrictionManager f25854c;

    @Inject
    public MockLocationService(GeoLocationManager locationManager, DriverRestrictionManager restrictionManager) {
        Intrinsics.f(locationManager, "locationManager");
        Intrinsics.f(restrictionManager, "restrictionManager");
        this.f25853b = locationManager;
        this.f25854c = restrictionManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable<GeoLocationManagerState> v7 = this.f25853b.v();
        final Function1<GeoLocationManagerState, Unit> function1 = new Function1<GeoLocationManagerState, Unit>() { // from class: ee.mtakso.driver.service.restriction.MockLocationService$doStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(GeoLocationManagerState geoLocationManagerState) {
                DriverRestrictionManager driverRestrictionManager;
                FastLog g8 = Kalev.f41674e.g();
                if (g8 != null) {
                    FastLog.DefaultImpls.c(g8, "GeoLocation state: " + geoLocationManagerState, null, 2, null);
                }
                if (geoLocationManagerState == GeoLocationManagerState.MOCKED_LOCATION_FOUND) {
                    driverRestrictionManager = MockLocationService.this.f25854c;
                    driverRestrictionManager.e(DriverAppDisabledReason.MOCK_LOCATION);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GeoLocationManagerState geoLocationManagerState) {
                b(geoLocationManagerState);
                return Unit.f50853a;
            }
        };
        Consumer<? super GeoLocationManagerState> consumer = new Consumer() { // from class: ee.mtakso.driver.service.restriction.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MockLocationService.i(Function1.this, obj);
            }
        };
        final MockLocationService$doStart$2 mockLocationService$doStart$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.restriction.MockLocationService$doStart$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "MockLocationService");
            }
        };
        Disposable subscribe = v7.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.restriction.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MockLocationService.j(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …ocationService\") })\n    }");
        return subscribe;
    }
}
