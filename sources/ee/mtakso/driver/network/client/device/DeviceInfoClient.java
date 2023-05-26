package ee.mtakso.driver.network.client.device;

import com.google.gson.JsonObject;
import dagger.Lazy;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.network.response.ResponseErrorProcessor;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceInfoClient.kt */
/* loaded from: classes3.dex */
public final class DeviceInfoClient {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy<DeviceInfoApi> f21870a;

    /* renamed from: b  reason: collision with root package name */
    private final ResponseErrorProcessor f21871b;

    @Inject
    public DeviceInfoClient(Lazy<DeviceInfoApi> api, ResponseErrorProcessor errorProcessor) {
        Intrinsics.f(api, "api");
        Intrinsics.f(errorProcessor, "errorProcessor");
        this.f21870a = api;
        this.f21871b = errorProcessor;
    }

    public final Single<EmptyServerResponse> a(DeviceEvent event) {
        Intrinsics.f(event, "event");
        return SingleExtKt.e(this.f21870a.get().b(event), this.f21871b);
    }

    public final Single<EmptyServerResponse> b(JsonObject fingerprint) {
        Intrinsics.f(fingerprint, "fingerprint");
        return SingleExtKt.e(this.f21870a.get().a(new DeviceFingerprint(fingerprint)), this.f21871b);
    }
}
