package ee.mtakso.driver.network.client.applog;

import ee.mtakso.driver.model.DeviceInfo;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverSettings;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: ApplogParamsInterceptor.kt */
/* loaded from: classes3.dex */
public final class ApplogParamsInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    private final DeviceInfo f21363a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverProvider f21364b;

    @Inject
    public ApplogParamsInterceptor(DeviceInfo deviceInfo, DriverProvider driverProvider) {
        Intrinsics.f(deviceInfo, "deviceInfo");
        Intrinsics.f(driverProvider, "driverProvider");
        this.f21363a = deviceInfo;
        this.f21364b = driverProvider;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        String str;
        Intrinsics.f(chain, "chain");
        Request request = chain.request();
        HttpUrl.Builder addQueryParameter = request.url().newBuilder().addQueryParameter("version", this.f21363a.a()).addQueryParameter("deviceId", this.f21363a.c()).addQueryParameter("device_os_version", this.f21363a.d());
        DriverConfig d8 = this.f21364b.d();
        String str2 = null;
        if (d8 != null) {
            str = d8.j();
        } else {
            str = null;
        }
        HttpUrl.Builder addQueryParameter2 = addQueryParameter.addQueryParameter("country", str);
        DriverSettings y7 = this.f21364b.y();
        if (y7 != null) {
            str2 = y7.v();
        }
        return chain.proceed(request.newBuilder().url(addQueryParameter2.addQueryParameter("language", str2).addQueryParameter("deviceType", "android").build()).build());
    }
}
