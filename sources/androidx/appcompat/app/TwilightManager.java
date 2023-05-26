package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.PermissionChecker;
import java.util.Calendar;

/* loaded from: classes.dex */
class TwilightManager {

    /* renamed from: d  reason: collision with root package name */
    private static TwilightManager f1296d;

    /* renamed from: a  reason: collision with root package name */
    private final Context f1297a;

    /* renamed from: b  reason: collision with root package name */
    private final LocationManager f1298b;

    /* renamed from: c  reason: collision with root package name */
    private final TwilightState f1299c = new TwilightState();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class TwilightState {

        /* renamed from: a  reason: collision with root package name */
        boolean f1300a;

        /* renamed from: b  reason: collision with root package name */
        long f1301b;

        TwilightState() {
        }
    }

    TwilightManager(@NonNull Context context, @NonNull LocationManager locationManager) {
        this.f1297a = context;
        this.f1298b = locationManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TwilightManager a(@NonNull Context context) {
        if (f1296d == null) {
            Context applicationContext = context.getApplicationContext();
            f1296d = new TwilightManager(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f1296d;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location location;
        Location location2 = null;
        if (PermissionChecker.b(this.f1297a, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            location = c("network");
        } else {
            location = null;
        }
        if (PermissionChecker.b(this.f1297a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location2 = c("gps");
        }
        if (location2 != null && location != null) {
            if (location2.getTime() > location.getTime()) {
                return location2;
            }
            return location;
        } else if (location2 != null) {
            return location2;
        } else {
            return location;
        }
    }

    private Location c(String str) {
        try {
            if (this.f1298b.isProviderEnabled(str)) {
                return this.f1298b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e8) {
            Log.d("TwilightManager", "Failed to get last known location", e8);
            return null;
        }
    }

    private boolean e() {
        if (this.f1299c.f1301b > System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    private void f(@NonNull Location location) {
        boolean z7;
        long j8;
        long j9;
        TwilightState twilightState = this.f1299c;
        long currentTimeMillis = System.currentTimeMillis();
        TwilightCalculator b8 = TwilightCalculator.b();
        b8.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        b8.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        if (b8.f1295c == 1) {
            z7 = true;
        } else {
            z7 = false;
        }
        long j10 = b8.f1294b;
        long j11 = b8.f1293a;
        b8.a(currentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j12 = b8.f1294b;
        if (j10 != -1 && j11 != -1) {
            if (currentTimeMillis > j11) {
                j9 = j12 + 0;
            } else if (currentTimeMillis > j10) {
                j9 = j11 + 0;
            } else {
                j9 = j10 + 0;
            }
            j8 = j9 + 60000;
        } else {
            j8 = 43200000 + currentTimeMillis;
        }
        twilightState.f1300a = z7;
        twilightState.f1301b = j8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        TwilightState twilightState = this.f1299c;
        if (e()) {
            return twilightState.f1300a;
        }
        Location b8 = b();
        if (b8 != null) {
            f(b8);
            return twilightState.f1300a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i8 = Calendar.getInstance().get(11);
        if (i8 >= 6 && i8 < 22) {
            return false;
        }
        return true;
    }
}
