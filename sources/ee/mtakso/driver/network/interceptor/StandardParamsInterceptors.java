package ee.mtakso.driver.network.interceptor;

import ee.mtakso.driver.model.DeviceInfo;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.session.SessionProvider;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: StandardParamsInterceptors.kt */
/* loaded from: classes3.dex */
public final class StandardParamsInterceptors implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    private final DeviceInfo f22970a;

    /* renamed from: b  reason: collision with root package name */
    private final SessionProvider f22971b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverProvider f22972c;

    /* renamed from: d  reason: collision with root package name */
    private final LanguageManager f22973d;

    @Inject
    public StandardParamsInterceptors(DeviceInfo deviceInfo, SessionProvider sessionProvider, DriverProvider provider, LanguageManager languageManager) {
        Intrinsics.f(deviceInfo, "deviceInfo");
        Intrinsics.f(sessionProvider, "sessionProvider");
        Intrinsics.f(provider, "provider");
        Intrinsics.f(languageManager, "languageManager");
        this.f22970a = deviceInfo;
        this.f22971b = sessionProvider;
        this.f22972c = provider;
        this.f22973d = languageManager;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.f(chain, "chain");
        Request request = chain.request();
        return chain.proceed(request.newBuilder().url(request.url().newBuilder().addEncodedQueryParameter("version", this.f22970a.a()).addEncodedQueryParameter("driver_id", this.f22972c.f()).addEncodedQueryParameter("deviceId", this.f22970a.c()).addEncodedQueryParameter("device_name", this.f22970a.b()).addEncodedQueryParameter("device_os_version", this.f22970a.d()).addEncodedQueryParameter("country", this.f22972c.c()).addEncodedQueryParameter("language", this.f22973d.e()).addEncodedQueryParameter("deviceType", "android").addEncodedQueryParameter("session_id", this.f22971b.c().a()).build()).build());
    }
}
