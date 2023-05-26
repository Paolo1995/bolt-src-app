package ee.mtakso.driver.service.modules.status;

import ee.mtakso.driver.network.client.driver.DriverMightBeBlocked;
import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.utils.Optional;
import io.reactivex.Observable;

/* compiled from: DriverStatusProvider.kt */
/* loaded from: classes3.dex */
public interface DriverStatusProvider {
    Observable<Throwable> b();

    Observable<DriverStatus> g();

    Observable<Optional<DriverMightBeBlocked>> h();

    Observable<GoOnlineIssue> k();

    Observable<GoOfflineIssue> m();

    DriverStatus n();
}
