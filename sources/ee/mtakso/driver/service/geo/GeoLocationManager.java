package ee.mtakso.driver.service.geo;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import ee.mtakso.driver.helper.CircularMeanCalculator;
import ee.mtakso.driver.platform.geo.GeoLocationAvailability;
import ee.mtakso.driver.platform.geo.GeoLocationCallback;
import ee.mtakso.driver.platform.geo.GeoLocationSource;
import ee.mtakso.driver.service.geo.mock.MockChecker;
import ee.mtakso.driver.service.geo.state.GeoLocationIssue;
import ee.mtakso.driver.service.geo.state.GeoLocationState;
import ee.mtakso.driver.service.geo.state.GeoLocationStateKt;
import ee.mtakso.driver.service.geo.state.LocationStateChecker;
import ee.mtakso.driver.service.restriction.EnvironmentDataProvider;
import ee.mtakso.driver.service.time.AnchoredTrueTimeProvider;
import ee.mtakso.driver.utils.Optional;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeoLocationManager.kt */
@Singleton
/* loaded from: classes3.dex */
public final class GeoLocationManager {

    /* renamed from: m  reason: collision with root package name */
    public static final Companion f24379m = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final GeoLocationSource f24380a;

    /* renamed from: b  reason: collision with root package name */
    private final AnchoredTrueTimeProvider f24381b;

    /* renamed from: c  reason: collision with root package name */
    private final MockChecker f24382c;

    /* renamed from: d  reason: collision with root package name */
    private final LocationStateChecker f24383d;

    /* renamed from: e  reason: collision with root package name */
    private final EnvironmentDataProvider f24384e;

    /* renamed from: f  reason: collision with root package name */
    private final GeoLocationManager$locationCallback$1 f24385f;

    /* renamed from: g  reason: collision with root package name */
    private final PublishSubject<GeoLocation> f24386g;

    /* renamed from: h  reason: collision with root package name */
    private final BehaviorSubject<GeoLocationManagerState> f24387h;

    /* renamed from: i  reason: collision with root package name */
    private final CircularMeanCalculator f24388i;

    /* renamed from: j  reason: collision with root package name */
    private GeoLocation f24389j;

    /* renamed from: k  reason: collision with root package name */
    private GeoLocationAvailability f24390k;

    /* renamed from: l  reason: collision with root package name */
    private final BehaviorSubject<GeoLocationAvailability> f24391l;

    /* compiled from: GeoLocationManager.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GeoLocationManager.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f24392a;

        static {
            int[] iArr = new int[GeoLocationManagerState.values().length];
            try {
                iArr[GeoLocationManagerState.WAITING_FOR_LOCATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GeoLocationManagerState.MOCKED_LOCATION_FOUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GeoLocationManagerState.OUTDATED_LOCATION_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[GeoLocationManagerState.LOCATION_ACCESS_ISSUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f24392a = iArr;
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [ee.mtakso.driver.service.geo.GeoLocationManager$locationCallback$1] */
    public GeoLocationManager(GeoLocationSource locationSource, AnchoredTrueTimeProvider timeProvider, MockChecker mockChecker, LocationStateChecker locationStateChecker, EnvironmentDataProvider environmentDataProvider) {
        Intrinsics.f(locationSource, "locationSource");
        Intrinsics.f(timeProvider, "timeProvider");
        Intrinsics.f(mockChecker, "mockChecker");
        Intrinsics.f(locationStateChecker, "locationStateChecker");
        Intrinsics.f(environmentDataProvider, "environmentDataProvider");
        this.f24380a = locationSource;
        this.f24381b = timeProvider;
        this.f24382c = mockChecker;
        this.f24383d = locationStateChecker;
        this.f24384e = environmentDataProvider;
        this.f24385f = new GeoLocationCallback() { // from class: ee.mtakso.driver.service.geo.GeoLocationManager$locationCallback$1
            @Override // ee.mtakso.driver.platform.geo.GeoLocationCallback
            public void a(GeoLocationAvailability availability) {
                LocationStateChecker locationStateChecker2;
                BehaviorSubject behaviorSubject;
                BehaviorSubject behaviorSubject2;
                Intrinsics.f(availability, "availability");
                if (availability.a()) {
                    GeoLocationManager.this.f24390k = availability;
                    behaviorSubject2 = GeoLocationManager.this.f24391l;
                    behaviorSubject2.onNext(availability);
                    return;
                }
                locationStateChecker2 = GeoLocationManager.this.f24383d;
                GeoLocationAvailability geoLocationAvailability = new GeoLocationAvailability(locationStateChecker2.d());
                GeoLocationManager.this.f24390k = geoLocationAvailability;
                behaviorSubject = GeoLocationManager.this.f24391l;
                behaviorSubject.onNext(geoLocationAvailability);
            }

            @Override // ee.mtakso.driver.platform.geo.GeoLocationCallback
            public void onLocationChanged(Location location) {
                Optional m8;
                BehaviorSubject behaviorSubject;
                BehaviorSubject behaviorSubject2;
                PublishSubject publishSubject;
                BehaviorSubject behaviorSubject3;
                BehaviorSubject behaviorSubject4;
                long j8;
                Intrinsics.f(location, "location");
                m8 = GeoLocationManager.this.m(location);
                GeoLocation geoLocation = (GeoLocation) m8.c();
                if (geoLocation != null) {
                    FastLog g8 = Kalev.f41674e.g();
                    if (g8 != null) {
                        long i8 = geoLocation.i();
                        GeoLocation q8 = GeoLocationManager.this.q();
                        if (q8 != null) {
                            j8 = q8.i();
                        } else {
                            j8 = 0;
                        }
                        long j9 = (i8 - j8) / 1000;
                        FastLog.DefaultImpls.a(g8, "Obtained new location. Time since previous one: " + j9 + " seconds", null, 2, null);
                    }
                    GeoLocationManager.this.f24389j = geoLocation;
                    publishSubject = GeoLocationManager.this.f24386g;
                    publishSubject.onNext(geoLocation);
                    behaviorSubject3 = GeoLocationManager.this.f24387h;
                    Object g9 = behaviorSubject3.g();
                    GeoLocationManagerState geoLocationManagerState = GeoLocationManagerState.RUNNING;
                    if (g9 != geoLocationManagerState) {
                        behaviorSubject4 = GeoLocationManager.this.f24387h;
                        behaviorSubject4.onNext(geoLocationManagerState);
                        return;
                    }
                    return;
                }
                FastLog g10 = Kalev.f41674e.g();
                if (g10 != null) {
                    FastLog.DefaultImpls.a(g10, "Location is suspicious", null, 2, null);
                }
                behaviorSubject = GeoLocationManager.this.f24387h;
                Object g11 = behaviorSubject.g();
                GeoLocationManagerState geoLocationManagerState2 = GeoLocationManagerState.MOCKED_LOCATION_FOUND;
                if (g11 != geoLocationManagerState2) {
                    behaviorSubject2 = GeoLocationManager.this.f24387h;
                    behaviorSubject2.onNext(geoLocationManagerState2);
                }
            }
        };
        PublishSubject<GeoLocation> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<GeoLocation>()");
        this.f24386g = e8;
        BehaviorSubject<GeoLocationManagerState> f8 = BehaviorSubject.f(GeoLocationManagerState.IDLE);
        Intrinsics.e(f8, "createDefault(GeoLocationManagerState.IDLE)");
        this.f24387h = f8;
        this.f24388i = new CircularMeanCalculator(5);
        GeoLocationAvailability geoLocationAvailability = new GeoLocationAvailability(true);
        this.f24390k = geoLocationAvailability;
        BehaviorSubject<GeoLocationAvailability> f9 = BehaviorSubject.f(geoLocationAvailability);
        Intrinsics.e(f9, "createDefault(lastKnownAvailability)");
        this.f24391l = f9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional A(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    public static /* synthetic */ void E(GeoLocationManager geoLocationManager, GeoLocationIssue geoLocationIssue, Activity activity, Fragment fragment, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            fragment = null;
        }
        geoLocationManager.C(geoLocationIssue, activity, fragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(GeoLocationManager this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.f24387h.onNext(GeoLocationManagerState.WAITING_FOR_LOCATION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Optional<GeoLocation> m(Location location) {
        boolean z7;
        Float f8 = null;
        if (this.f24382c.a(location)) {
            FastLog g8 = Kalev.f41674e.g();
            if (g8 != null) {
                FastLog.DefaultImpls.c(g8, "Skipped mocked location", null, 2, null);
            }
            Optional<GeoLocation> a8 = Optional.a();
            Intrinsics.e(a8, "empty()");
            return a8;
        }
        GeoCoordinate geoCoordinate = new GeoCoordinate(location.getLatitude(), location.getLongitude());
        if (location.hasSpeed() && location.getSpeed() <= 1.0f) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (location.hasSpeed()) {
            f8 = Float.valueOf(location.getSpeed());
        }
        Float f9 = f8;
        if (location.hasBearing() && z7) {
            this.f24388i.a(location.getBearing());
        }
        Optional<GeoLocation> f10 = Optional.f(new GeoLocation(geoCoordinate, location.getAccuracy(), location.getAltitude(), o(location), this.f24388i.b(), p(location), f9, r(location), this.f24381b.b()));
        Intrinsics.e(f10, "of(geoLocation)");
        return f10;
    }

    private final Double o(Location location) {
        if (location.hasBearing()) {
            return Double.valueOf(location.getBearing());
        }
        return null;
    }

    private final Float p(Location location) {
        boolean hasBearingAccuracy;
        float bearingAccuracyDegrees;
        if (Build.VERSION.SDK_INT >= 26) {
            hasBearingAccuracy = location.hasBearingAccuracy();
            if (hasBearingAccuracy) {
                bearingAccuracyDegrees = location.getBearingAccuracyDegrees();
                return Float.valueOf(bearingAccuracyDegrees);
            }
        }
        return null;
    }

    private final Float r(Location location) {
        boolean hasSpeedAccuracy;
        float speedAccuracyMetersPerSecond;
        if (Build.VERSION.SDK_INT >= 26) {
            hasSpeedAccuracy = location.hasSpeedAccuracy();
            if (hasSpeedAccuracy) {
                speedAccuracyMetersPerSecond = location.getSpeedAccuracyMetersPerSecond();
                return Float.valueOf(speedAccuracyMetersPerSecond);
            }
        }
        return null;
    }

    private final String w(GeoLocationIssue geoLocationIssue) {
        boolean a8;
        if (geoLocationIssue instanceof GeoLocationIssue.Error) {
            String name = geoLocationIssue.getClass().getName();
            String message = ((GeoLocationIssue.Error) geoLocationIssue).a().getMessage();
            return name + ":" + message;
        }
        boolean z7 = true;
        if (Intrinsics.a(geoLocationIssue, GeoLocationIssue.InsufficientDevice.f24426a)) {
            a8 = true;
        } else {
            a8 = Intrinsics.a(geoLocationIssue, GeoLocationIssue.PermissionDenied.f24427a);
        }
        if (!a8) {
            z7 = Intrinsics.a(geoLocationIssue, GeoLocationIssue.UnresolvableError.f24429a);
        }
        if (z7) {
            String name2 = geoLocationIssue.getClass().getName();
            Intrinsics.e(name2, "issue.javaClass.name");
            return name2;
        } else if (geoLocationIssue instanceof GeoLocationIssue.ResolvableError) {
            String name3 = geoLocationIssue.getClass().getName();
            String message2 = ((GeoLocationIssue.ResolvableError) geoLocationIssue).a().a().getMessage();
            return name3 + ":" + message2;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(GeoLocationManager this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.f24387h.onNext(GeoLocationManagerState.IDLE);
    }

    public final Single<PermissionManager.PermissionInfo> B() {
        return this.f24383d.a();
    }

    public final void C(GeoLocationIssue issue, Activity solverHostActivity, Fragment fragment) {
        Intrinsics.f(issue, "issue");
        Intrinsics.f(solverHostActivity, "solverHostActivity");
        this.f24387h.g();
        GeoLocationManagerState geoLocationManagerState = GeoLocationManagerState.IDLE;
        if (issue instanceof GeoLocationIssue.Error) {
            Kalev.e(((GeoLocationIssue.Error) issue).a(), "Failed to fix location issue");
        } else if (Intrinsics.a(issue, GeoLocationIssue.InsufficientDevice.f24426a)) {
            Kalev.b("InsufficientDevice");
        } else if (Intrinsics.a(issue, GeoLocationIssue.PermissionDenied.f24427a)) {
            this.f24383d.a().G();
        } else if (issue instanceof GeoLocationIssue.ResolvableError) {
            Kalev.b("ResolvableError");
            if (fragment != null) {
                this.f24380a.c(((GeoLocationIssue.ResolvableError) issue).a(), fragment, 5599);
            } else {
                this.f24380a.e(((GeoLocationIssue.ResolvableError) issue).a(), solverHostActivity, 5599);
            }
        } else if (Intrinsics.a(issue, GeoLocationIssue.UnresolvableError.f24429a)) {
            Kalev.b("UnresolvableError");
            Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            if (fragment != null) {
                fragment.startActivityForResult(intent, 5599);
            } else {
                ActivityCompat.k(solverHostActivity, intent, 5599, null);
            }
        }
    }

    public final void D(GeoLocationIssue issue, Fragment solverHostFragment) {
        Intrinsics.f(issue, "issue");
        Intrinsics.f(solverHostFragment, "solverHostFragment");
        FragmentActivity requireActivity = solverHostFragment.requireActivity();
        Intrinsics.e(requireActivity, "solverHostFragment.requireActivity()");
        C(issue, requireActivity, solverHostFragment);
    }

    public final Completable k() {
        this.f24384e.onStart();
        Completable n8 = this.f24380a.d(this.f24385f).n(new Action() { // from class: ee.mtakso.driver.service.geo.g
            @Override // io.reactivex.functions.Action
            public final void run() {
                GeoLocationManager.l(GeoLocationManager.this);
            }
        });
        Intrinsics.e(n8, "locationSource.startLoca…e.WAITING_FOR_LOCATION) }");
        return n8;
    }

    public final synchronized void n() {
        GeoLocationManagerState g8 = this.f24387h.g();
        if (g8 != null) {
            Intrinsics.e(g8, "checkNotNull(locationStateBus.value)");
            GeoLocationManagerState geoLocationManagerState = g8;
            GeoLocation geoLocation = this.f24389j;
            GeoLocationManagerState g9 = this.f24387h.g();
            Kalev.h("Location state value " + g9);
            if (this.f24387h.g() == GeoLocationManagerState.IDLE) {
                return;
            }
            GeoLocationState geoState = this.f24383d.c().d();
            Intrinsics.e(geoState, "geoState");
            if (!GeoLocationStateKt.b(geoState)) {
                String w7 = w(GeoLocationStateKt.a(geoState));
                Kalev.d("Location issue type: " + w7);
                this.f24387h.onNext(GeoLocationManagerState.LOCATION_ACCESS_ISSUE);
                return;
            }
            int i8 = WhenMappings.f24392a[geoLocationManagerState.ordinal()];
            if (i8 != 1 && i8 != 2 && i8 != 3 && i8 != 4) {
                if (geoLocation != null) {
                    if (this.f24381b.b() - geoLocation.i() > 120000) {
                        this.f24387h.onNext(GeoLocationManagerState.OUTDATED_LOCATION_DATA);
                        return;
                    } else if (geoLocationManagerState == GeoLocationManagerState.RUNNING) {
                        return;
                    } else {
                        GeoLocationManagerState g10 = this.f24387h.g();
                        Kalev.d("Illegal Location value " + g10);
                        GeoLocationManagerState g11 = this.f24387h.g();
                        throw new IllegalStateException("Illegal geo location state " + g11);
                    }
                }
                throw new IllegalStateException("Required value was null.".toString());
            }
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final GeoLocation q() {
        return this.f24389j;
    }

    public final boolean s() {
        return this.f24383d.b();
    }

    public final Observable<GeoLocation> t() {
        GeoLocation geoLocation = this.f24389j;
        if (geoLocation == null) {
            return this.f24386g;
        }
        Observable<GeoLocation> startWith = this.f24386g.startWith((PublishSubject<GeoLocation>) geoLocation);
        Intrinsics.e(startWith, "{\n            locationBu…tKnownLocation)\n        }");
        return startWith;
    }

    public final Observable<GeoLocation> u(long j8) {
        Observable<GeoLocation> throttleFirst = t().throttleFirst(j8, TimeUnit.SECONDS);
        Intrinsics.e(throttleFirst, "observeLocationUpdates()…econds, TimeUnit.SECONDS)");
        return throttleFirst;
    }

    public final Observable<GeoLocationManagerState> v() {
        return this.f24387h;
    }

    public final Completable x() {
        this.f24384e.onStop();
        Completable n8 = this.f24380a.b().n(new Action() { // from class: ee.mtakso.driver.service.geo.f
            @Override // io.reactivex.functions.Action
            public final void run() {
                GeoLocationManager.y(GeoLocationManager.this);
            }
        });
        Intrinsics.e(n8, "locationSource.stopLocat…ationManagerState.IDLE) }");
        return n8;
    }

    public final Single<Optional<GeoLocationIssue>> z() {
        Single<GeoLocationState> c8 = this.f24383d.c();
        final GeoLocationManager$requestIssue$1 geoLocationManager$requestIssue$1 = new Function1<GeoLocationState, Optional<GeoLocationIssue>>() { // from class: ee.mtakso.driver.service.geo.GeoLocationManager$requestIssue$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<GeoLocationIssue> invoke(GeoLocationState state) {
                Intrinsics.f(state, "state");
                if (GeoLocationStateKt.b(state)) {
                    return Optional.a();
                }
                return Optional.f(GeoLocationStateKt.a(state));
            }
        };
        Single x7 = c8.x(new Function() { // from class: ee.mtakso.driver.service.geo.e
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional A;
                A = GeoLocationManager.A(Function1.this, obj);
                return A;
            }
        });
        Intrinsics.e(x7, "locationStateChecker.che…          }\n            }");
        return x7;
    }
}
