package ee.mtakso.driver.service.geo.mock;

import android.location.Location;
import android.os.Build;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverProvider;
import eu.bolt.kalev.Kalev;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReleaseMockChecker.kt */
/* loaded from: classes3.dex */
public final class ReleaseMockChecker implements MockChecker {

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f24417a;

    @Inject
    public ReleaseMockChecker(DriverProvider driverProvider) {
        Intrinsics.f(driverProvider, "driverProvider");
        this.f24417a = driverProvider;
    }

    @Override // ee.mtakso.driver.service.geo.mock.MockChecker
    public boolean a(Location location) {
        boolean isMock;
        Intrinsics.f(location, "location");
        DriverConfig d8 = this.f24417a.d();
        if (d8 == null) {
            Kalev.e(new NullPointerException("Driver config is null"), "Unexpected location");
            return false;
        } else if (!d8.z()) {
            return false;
        } else {
            if (Build.VERSION.SDK_INT >= 31) {
                isMock = location.isMock();
                return isMock;
            }
            return location.isFromMockProvider();
        }
    }
}
