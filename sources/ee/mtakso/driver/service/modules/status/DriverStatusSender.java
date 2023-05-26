package ee.mtakso.driver.service.modules.status;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.driver.DriverStatus;
import io.reactivex.Observable;

/* loaded from: classes3.dex */
public interface DriverStatusSender extends DriverStatusProvider {
    void a();

    void c();

    @Deprecated
    Observable<DriverStatus> d();

    void e();

    void f();

    void i(DriverStatus driverStatus);

    void j(Long l8, OrderHandle orderHandle);

    void l();
}
