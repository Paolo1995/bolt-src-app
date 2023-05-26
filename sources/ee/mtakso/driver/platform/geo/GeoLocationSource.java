package ee.mtakso.driver.platform.geo;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.platform.geo.LocationSettingsResult;
import io.reactivex.Completable;
import io.reactivex.Single;

/* compiled from: GeoLocationSource.kt */
/* loaded from: classes3.dex */
public interface GeoLocationSource {
    Single<LocationSettingsResult> a();

    Completable b();

    void c(LocationSettingsResult.ResolvableError resolvableError, Fragment fragment, int i8);

    Completable d(GeoLocationCallback geoLocationCallback);

    void e(LocationSettingsResult.ResolvableError resolvableError, Activity activity, int i8);
}
