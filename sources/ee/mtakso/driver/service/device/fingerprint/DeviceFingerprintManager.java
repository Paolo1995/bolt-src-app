package ee.mtakso.driver.service.device.fingerprint;

import com.google.gson.JsonObject;
import ee.mtakso.driver.network.client.device.DeviceInfoClient;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceFingerprintManager.kt */
/* loaded from: classes3.dex */
public final class DeviceFingerprintManager {

    /* renamed from: a  reason: collision with root package name */
    private final DeviceFingerprintCollector f24293a;

    /* renamed from: b  reason: collision with root package name */
    private final DeviceInfoClient f24294b;

    @Inject
    public DeviceFingerprintManager(DeviceFingerprintCollector fingerprintCollector, DeviceInfoClient driverApiClient) {
        Intrinsics.f(fingerprintCollector, "fingerprintCollector");
        Intrinsics.f(driverApiClient, "driverApiClient");
        this.f24293a = fingerprintCollector;
        this.f24294b = driverApiClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    public final Completable c() {
        Single<JsonObject> e8 = this.f24293a.e();
        final Function1<JsonObject, CompletableSource> function1 = new Function1<JsonObject, CompletableSource>() { // from class: ee.mtakso.driver.service.device.fingerprint.DeviceFingerprintManager$postDeviceFingerprint$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final CompletableSource invoke(JsonObject it) {
                DeviceInfoClient deviceInfoClient;
                Intrinsics.f(it, "it");
                deviceInfoClient = DeviceFingerprintManager.this.f24294b;
                return deviceInfoClient.b(it).v();
            }
        };
        Completable s7 = e8.s(new Function() { // from class: ee.mtakso.driver.service.device.fingerprint.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource d8;
                d8 = DeviceFingerprintManager.d(Function1.this, obj);
                return d8;
            }
        });
        Intrinsics.e(s7, "fun postDeviceFingerprin…ent()\n            }\n    }");
        return s7;
    }
}
