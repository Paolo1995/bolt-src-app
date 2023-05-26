package ee.mtakso.driver.service.restriction;

import ee.mtakso.driver.network.client.device.DriverAppDisabledReason;
import ee.mtakso.driver.network.client.driver.DriverStatusKt;
import ee.mtakso.driver.service.BaseServiceImpl;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.geo.GeoLocationManagerState;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.utils.AssertUtils;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocationStateService.kt */
/* loaded from: classes3.dex */
public final class LocationStateService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final GeoLocationManager f25841b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverRestrictionManager f25842c;

    /* renamed from: d  reason: collision with root package name */
    private final DriverStatusProvider f25843d;

    /* renamed from: e  reason: collision with root package name */
    private int f25844e;

    /* compiled from: LocationStateService.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25845a;

        static {
            int[] iArr = new int[GeoLocationManagerState.values().length];
            try {
                iArr[GeoLocationManagerState.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GeoLocationManagerState.OUTDATED_LOCATION_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GeoLocationManagerState.WAITING_FOR_LOCATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[GeoLocationManagerState.IDLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[GeoLocationManagerState.MOCKED_LOCATION_FOUND.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[GeoLocationManagerState.LOCATION_ACCESS_ISSUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f25845a = iArr;
        }
    }

    @Inject
    public LocationStateService(GeoLocationManager locationManager, DriverRestrictionManager restrictionManager, DriverStatusProvider driverStatusProvider) {
        Intrinsics.f(locationManager, "locationManager");
        Intrinsics.f(restrictionManager, "restrictionManager");
        Intrinsics.f(driverStatusProvider, "driverStatusProvider");
        this.f25841b = locationManager;
        this.f25842c = restrictionManager;
        this.f25843d = driverStatusProvider;
        this.f25844e = -1;
    }

    private final void k(GeoLocationManagerState geoLocationManagerState) {
        if (this.f25844e > 1) {
            if (geoLocationManagerState == GeoLocationManagerState.LOCATION_ACCESS_ISSUE) {
                this.f25842c.e(DriverAppDisabledReason.LOCATION_OFF);
            } else if (geoLocationManagerState == GeoLocationManagerState.MOCKED_LOCATION_FOUND) {
                this.f25842c.e(DriverAppDisabledReason.MOCK_LOCATION);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(GeoLocationManagerState geoLocationManagerState) {
        if (!DriverStatusKt.b(this.f25843d.n())) {
            return;
        }
        switch (WhenMappings.f25845a[geoLocationManagerState.ordinal()]) {
            case 1:
            case 2:
            case 3:
                this.f25844e = 0;
                return;
            case 4:
                this.f25844e = 0;
                AssertUtils.a("Illegal location state: " + geoLocationManagerState);
                return;
            case 5:
            case 6:
                int i8 = this.f25844e + 1;
                this.f25844e = i8;
                Kalev.d("Location Issue Count: " + i8);
                k(geoLocationManagerState);
                return;
            default:
                return;
        }
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable<GeoLocationManagerState> v7 = this.f25841b.v();
        final Function1<Disposable, Unit> function1 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.service.restriction.LocationStateService$doStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                LocationStateService.this.f25844e = 0;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Observable<GeoLocationManagerState> doOnSubscribe = v7.doOnSubscribe(new Consumer() { // from class: ee.mtakso.driver.service.restriction.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LocationStateService.l(Function1.this, obj);
            }
        });
        final Function1<GeoLocationManagerState, Unit> function12 = new Function1<GeoLocationManagerState, Unit>() { // from class: ee.mtakso.driver.service.restriction.LocationStateService$doStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(GeoLocationManagerState it) {
                LocationStateService locationStateService = LocationStateService.this;
                Intrinsics.e(it, "it");
                locationStateService.o(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GeoLocationManagerState geoLocationManagerState) {
                b(geoLocationManagerState);
                return Unit.f50853a;
            }
        };
        Consumer<? super GeoLocationManagerState> consumer = new Consumer() { // from class: ee.mtakso.driver.service.restriction.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LocationStateService.m(Function1.this, obj);
            }
        };
        final LocationStateService$doStart$3 locationStateService$doStart$3 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.restriction.LocationStateService$doStart$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Exception on LocationSettingsService");
            }
        };
        Disposable subscribe = doOnSubscribe.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.restriction.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LocationStateService.n(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …ettingsService\") })\n    }");
        return subscribe;
    }
}
