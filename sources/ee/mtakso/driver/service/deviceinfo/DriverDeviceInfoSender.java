package ee.mtakso.driver.service.deviceinfo;

import ee.mtakso.driver.network.client.device.DeviceEvent;
import ee.mtakso.driver.network.client.device.DeviceInfoClient;
import ee.mtakso.driver.network.client.device.DriverAppDisabledReason;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceInfoSender.kt */
/* loaded from: classes3.dex */
public final class DriverDeviceInfoSender implements DeviceInfoSender {

    /* renamed from: a  reason: collision with root package name */
    private final DeviceInfoClient f24305a;

    @Inject
    public DriverDeviceInfoSender(DeviceInfoClient apiClient) {
        Intrinsics.f(apiClient, "apiClient");
        this.f24305a = apiClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional e(Throwable it) {
        Intrinsics.f(it, "it");
        return Optional.a();
    }

    @Override // ee.mtakso.driver.service.deviceinfo.DeviceInfoSender
    public Single<Optional<EmptyServerResponse>> a(DriverAppDisabledReason driverAppDisabledReason, Long l8) {
        Intrinsics.f(driverAppDisabledReason, "driverAppDisabledReason");
        Single d8 = SingleExtKt.d(this.f24305a.a(new DeviceEvent("driver_app_disabled", driverAppDisabledReason, l8, null)));
        final DriverDeviceInfoSender$sendDriverAppDisabledEvent$1 driverDeviceInfoSender$sendDriverAppDisabledEvent$1 = new Function1<EmptyServerResponse, Optional<EmptyServerResponse>>() { // from class: ee.mtakso.driver.service.deviceinfo.DriverDeviceInfoSender$sendDriverAppDisabledEvent$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<EmptyServerResponse> invoke(EmptyServerResponse it) {
                Intrinsics.f(it, "it");
                return Optional.f(it);
            }
        };
        Single<Optional<EmptyServerResponse>> C = d8.x(new Function() { // from class: ee.mtakso.driver.service.deviceinfo.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional d9;
                d9 = DriverDeviceInfoSender.d(Function1.this, obj);
                return d9;
            }
        }).C(new Function() { // from class: ee.mtakso.driver.service.deviceinfo.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional e8;
                e8 = DriverDeviceInfoSender.e((Throwable) obj);
                return e8;
            }
        });
        Intrinsics.e(C, "apiClient.sendDeviceEven…turn { Optional.empty() }");
        return C;
    }
}
