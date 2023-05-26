package ee.mtakso.driver.service.geo.state;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import androidx.core.content.ContextCompat;
import ee.mtakso.driver.platform.geo.GeoLocationSource;
import ee.mtakso.driver.platform.geo.LocationSettingsResult;
import ee.mtakso.driver.service.geo.state.GeoLocationIssue;
import ee.mtakso.driver.service.geo.state.LocationStateChecker;
import ee.mtakso.driver.service.geo.state.ReleaseLocationStateChecker;
import ee.mtakso.driver.utils.AssertUtils;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReleaseLocationStateChecker.kt */
/* loaded from: classes3.dex */
public final class ReleaseLocationStateChecker implements LocationStateChecker {

    /* renamed from: a  reason: collision with root package name */
    private final Context f24431a;

    /* renamed from: b  reason: collision with root package name */
    private final LocationManager f24432b;

    /* renamed from: c  reason: collision with root package name */
    private final GeoLocationSource f24433c;

    /* renamed from: d  reason: collision with root package name */
    private final PackageManager f24434d;

    /* renamed from: e  reason: collision with root package name */
    private final PermissionManager f24435e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f24436f;

    public ReleaseLocationStateChecker(Context context, LocationManager locationManager, GeoLocationSource locationSource, PackageManager packageManager, PermissionManager permissionManager, boolean z7) {
        Intrinsics.f(context, "context");
        Intrinsics.f(locationManager, "locationManager");
        Intrinsics.f(locationSource, "locationSource");
        Intrinsics.f(packageManager, "packageManager");
        Intrinsics.f(permissionManager, "permissionManager");
        this.f24431a = context;
        this.f24432b = locationManager;
        this.f24433c = locationSource;
        this.f24434d = packageManager;
        this.f24435e = permissionManager;
        this.f24436f = z7;
    }

    private final void g(SingleEmitter<GeoLocationState> singleEmitter) {
        AssertUtils.e("Should be executed on background thread");
        l("Checking location state...");
        if (i()) {
            l("Gps feature: OK");
            if (k()) {
                l("Location permission: OK");
                if (j()) {
                    l("Location state: OK");
                    singleEmitter.onSuccess(new GeoLocationState(null));
                    return;
                }
                try {
                    LocationSettingsResult d8 = this.f24433c.a().d();
                    if (d8 instanceof LocationSettingsResult.Ok) {
                        l("Location state: OK");
                        singleEmitter.onSuccess(new GeoLocationState(null));
                    } else if (d8 instanceof LocationSettingsResult.ResolvableError) {
                        l("Location state: RESOLVABLE");
                        singleEmitter.onSuccess(new GeoLocationState(new GeoLocationIssue.ResolvableError((LocationSettingsResult.ResolvableError) d8)));
                    } else if (d8 instanceof LocationSettingsResult.Error) {
                        l("Location state: ERROR");
                        singleEmitter.onSuccess(new GeoLocationState(new GeoLocationIssue.Error(((LocationSettingsResult.Error) d8).a())));
                    } else if (d8 instanceof LocationSettingsResult.SettingsChangeUnavailable) {
                        l("Location state: SETTINGS_CHANGE_UNAVAILABLE");
                        singleEmitter.onSuccess(new GeoLocationState(GeoLocationIssue.UnresolvableError.f24429a));
                    } else {
                        l("Location state: Unexpected: " + d8);
                        singleEmitter.onSuccess(new GeoLocationState(new GeoLocationIssue.Error(new IllegalStateException("Unexpected location settings: " + d8))));
                    }
                    return;
                } catch (Exception e8) {
                    singleEmitter.onSuccess(new GeoLocationState(new GeoLocationIssue.Error(e8)));
                    return;
                }
            }
            singleEmitter.onSuccess(new GeoLocationState(GeoLocationIssue.PermissionDenied.f24427a));
            return;
        }
        singleEmitter.onSuccess(new GeoLocationState(GeoLocationIssue.InsufficientDevice.f24426a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ReleaseLocationStateChecker this$0, SingleEmitter emitter) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(emitter, "emitter");
        this$0.g(emitter);
    }

    @SuppressLint({"ObsoleteSdkInt"})
    private final boolean j() {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        try {
            if (Settings.Secure.getInt(this.f24431a.getContentResolver(), "location_mode") != 3) {
                return false;
            }
            return true;
        } catch (Exception e8) {
            Kalev.e(e8, "Failed to read GPS settings");
            return false;
        }
    }

    private final void l(String str) {
        FastLog g8;
        if (this.f24436f && (g8 = Kalev.f41674e.g()) != null) {
            FastLog.DefaultImpls.b(g8, str, null, 2, null);
        }
    }

    @Override // ee.mtakso.driver.service.geo.state.LocationStateChecker
    public Single<PermissionManager.PermissionInfo> a() {
        return this.f24435e.j("android.permission.ACCESS_FINE_LOCATION", this.f24431a);
    }

    @Override // ee.mtakso.driver.service.geo.state.LocationStateChecker
    public boolean b() {
        return this.f24432b.isProviderEnabled("gps");
    }

    @Override // ee.mtakso.driver.service.geo.state.LocationStateChecker
    public Single<GeoLocationState> c() {
        Single<GeoLocationState> f8 = Single.f(new SingleOnSubscribe() { // from class: g2.a
            @Override // io.reactivex.SingleOnSubscribe
            public final void a(SingleEmitter singleEmitter) {
                ReleaseLocationStateChecker.h(ReleaseLocationStateChecker.this, singleEmitter);
            }
        });
        Intrinsics.e(f8, "create { emitter -> checkLocationState(emitter) }");
        return f8;
    }

    @Override // ee.mtakso.driver.service.geo.state.LocationStateChecker
    public boolean d() {
        return LocationStateChecker.DefaultImpls.a(this);
    }

    @Override // ee.mtakso.driver.service.geo.state.LocationStateChecker
    public boolean e() {
        return this.f24432b.isProviderEnabled("network");
    }

    public boolean i() {
        return this.f24434d.hasSystemFeature("android.hardware.location.gps");
    }

    public boolean k() {
        boolean z7;
        boolean z8;
        if (ContextCompat.checkSelfPermission(this.f24431a, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (ContextCompat.checkSelfPermission(this.f24431a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 && z8) {
            return true;
        }
        return false;
    }
}
