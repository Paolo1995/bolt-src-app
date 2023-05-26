package ee.mtakso.driver.service.deviceinfo;

import ee.mtakso.driver.network.client.device.DriverAppDisabledReason;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.utils.Optional;
import io.reactivex.Single;

/* compiled from: DeviceInfoSender.kt */
/* loaded from: classes3.dex */
public interface DeviceInfoSender {
    Single<Optional<EmptyServerResponse>> a(DriverAppDisabledReason driverAppDisabledReason, Long l8);
}
