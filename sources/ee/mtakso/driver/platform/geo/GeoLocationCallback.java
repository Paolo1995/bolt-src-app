package ee.mtakso.driver.platform.geo;

import android.location.Location;

/* compiled from: GeoLocationCallback.kt */
/* loaded from: classes3.dex */
public interface GeoLocationCallback {
    void a(GeoLocationAvailability geoLocationAvailability);

    void onLocationChanged(Location location);
}
