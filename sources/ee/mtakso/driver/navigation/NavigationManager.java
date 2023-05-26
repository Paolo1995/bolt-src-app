package ee.mtakso.driver.navigation;

import android.content.ActivityNotFoundException;
import android.content.Context;
import ee.mtakso.App;
import ee.mtakso.driver.navigation.navigators.ExternalNavigator;
import ee.mtakso.driver.navigation.navigators.Navigator;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.routing.command.NavigationCommand;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.service.geo.GeoLocation;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOption;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOptionKt;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigatorChooserFragment;
import ee.mtakso.driver.utils.AppResolver;
import eu.bolt.android.maps.core.GeoUtils;
import eu.bolt.kalev.Kalev;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigationManager.kt */
@Singleton
/* loaded from: classes3.dex */
public final class NavigationManager {

    /* renamed from: h  reason: collision with root package name */
    public static final Companion f21202h = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f21203a;

    /* renamed from: b  reason: collision with root package name */
    private final NavigationAppTypeFactory f21204b;

    /* renamed from: c  reason: collision with root package name */
    private final GeoLocationManager f21205c;

    /* renamed from: d  reason: collision with root package name */
    private final AppResolver f21206d;

    /* renamed from: e  reason: collision with root package name */
    private final DynamicNavigationProvider f21207e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f21208f;

    /* renamed from: g  reason: collision with root package name */
    private GeoCoordinate f21209g;

    /* compiled from: NavigationManager.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public NavigationManager(App app, DriverProvider driverProvider, NavigationAppTypeFactory navigationAppTypeFactory, GeoLocationManager locationManager, AppResolver appResolver, DynamicNavigationProvider dynamicNavigationProvider) {
        Intrinsics.f(app, "app");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(navigationAppTypeFactory, "navigationAppTypeFactory");
        Intrinsics.f(locationManager, "locationManager");
        Intrinsics.f(appResolver, "appResolver");
        Intrinsics.f(dynamicNavigationProvider, "dynamicNavigationProvider");
        this.f21203a = driverProvider;
        this.f21204b = navigationAppTypeFactory;
        this.f21205c = locationManager;
        this.f21206d = appResolver;
        this.f21207e = dynamicNavigationProvider;
        Context baseContext = app.getBaseContext();
        Intrinsics.e(baseContext, "app.baseContext");
        this.f21208f = baseContext;
    }

    private final void b(GeoCoordinate geoCoordinate) {
        NavigationOption a8 = this.f21203a.v().I().a();
        if (a8 != null && NavigationOptionKt.a(a8, this.f21206d)) {
            this.f21209g = geoCoordinate;
            try {
                this.f21207e.c(a8, geoCoordinate).a(this.f21208f);
                return;
            } catch (ActivityNotFoundException e8) {
                Kalev.e(e8, "Failed to start navigation");
                f();
                return;
            }
        }
        f();
    }

    private final void c(Navigator.Type type, GeoCoordinate geoCoordinate) {
        ExternalNavigator b8 = this.f21204b.b(type);
        if (b8 != null && type != Navigator.Type.NO_NAVIGATION_SELECTED && b8.b()) {
            try {
                d(b8.l(geoCoordinate), type, geoCoordinate);
                return;
            } catch (ActivityNotFoundException e8) {
                Kalev.e(e8, "Failed to start navigation");
                this.f21203a.t().g0(Navigator.Type.NO_NAVIGATION_SELECTED);
                f();
                return;
            }
        }
        f();
    }

    private final void d(NavigationCommand<Context> navigationCommand, Navigator.Type type, GeoCoordinate geoCoordinate) throws ActivityNotFoundException {
        this.f21209g = geoCoordinate;
        this.f21203a.t().g0(type);
        navigationCommand.a(this.f21208f);
    }

    private final void f() {
        NavigatorChooserFragment.f30914t.a(this.f21208f);
    }

    public final void a(GeoCoordinate targetLatLng) {
        GeoCoordinate e8;
        Intrinsics.f(targetLatLng, "targetLatLng");
        GeoLocation q8 = this.f21205c.q();
        if (q8 != null && (e8 = q8.e()) != null && GeoUtils.f36938a.f(e8, targetLatLng) > 20.0d) {
            e(targetLatLng);
        }
    }

    public final void e(GeoCoordinate targetLatLng) {
        Intrinsics.f(targetLatLng, "targetLatLng");
        if (this.f21203a.q().r()) {
            b(targetLatLng);
        } else {
            c(this.f21203a.t().r().a(), targetLatLng);
        }
    }
}
