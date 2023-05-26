package ee.mtakso.driver.service.geo.state;

import eu.bolt.driver.core.permission.PermissionManager;
import io.reactivex.Single;

/* compiled from: LocationStateChecker.kt */
/* loaded from: classes3.dex */
public interface LocationStateChecker {

    /* compiled from: LocationStateChecker.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static boolean a(LocationStateChecker locationStateChecker) {
            if (!locationStateChecker.b() && !locationStateChecker.e()) {
                return false;
            }
            return true;
        }
    }

    Single<PermissionManager.PermissionInfo> a();

    boolean b();

    Single<GeoLocationState> c();

    boolean d();

    boolean e();
}
