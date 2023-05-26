package ee.mtakso.driver.network.client.auth.authenticated;

import dagger.Lazy;
import ee.mtakso.driver.model.DeviceInfo;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.network.response.ResponseErrorProcessor;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthenticatedAuthClient.kt */
/* loaded from: classes3.dex */
public final class AuthenticatedAuthClient {

    /* renamed from: a  reason: collision with root package name */
    private final DeviceInfo f21522a;

    /* renamed from: b  reason: collision with root package name */
    private final DeviceSettings f21523b;

    /* renamed from: c  reason: collision with root package name */
    private final Lazy<AuthenticatedAuthApi> f21524c;

    /* renamed from: d  reason: collision with root package name */
    private final CompositeResponseTransformer f21525d;

    /* renamed from: e  reason: collision with root package name */
    private final ResponseErrorProcessor f21526e;

    @Inject
    public AuthenticatedAuthClient(DeviceInfo deviceInfo, DeviceSettings deviceSettings, Lazy<AuthenticatedAuthApi> authApi, CompositeResponseTransformer transformer, ResponseErrorProcessor processor) {
        Intrinsics.f(deviceInfo, "deviceInfo");
        Intrinsics.f(deviceSettings, "deviceSettings");
        Intrinsics.f(authApi, "authApi");
        Intrinsics.f(transformer, "transformer");
        Intrinsics.f(processor, "processor");
        this.f21522a = deviceInfo;
        this.f21523b = deviceSettings;
        this.f21524c = authApi;
        this.f21525d = transformer;
        this.f21526e = processor;
    }

    public final Single<DriverPortalMagicToken> a() {
        return SingleExtKt.g(this.f21524c.get().b(this.f21522a.a(), this.f21522a.c(), this.f21522a.b(), this.f21522a.d()), this.f21525d);
    }

    public final Single<EmptyServerResponse> b() {
        String l8 = this.f21523b.l();
        if (l8 == null) {
            Single<EmptyServerResponse> error = Single.error(new NullPointerException("refresh token is null"));
            Intrinsics.e(error, "error(NullPointerExcepti…\"refresh token is null\"))");
            return error;
        }
        return SingleExtKt.e(this.f21524c.get().a(l8), this.f21526e);
    }
}
