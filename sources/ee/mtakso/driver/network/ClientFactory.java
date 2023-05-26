package ee.mtakso.driver.network;

import android.os.Build;
import ee.mtakso.driver.network.cache.CacheProvider;
import ee.mtakso.driver.network.client.applog.ApplogParamsInterceptor;
import ee.mtakso.driver.network.interceptor.AccessTokenInterceptor;
import ee.mtakso.driver.network.interceptor.HttpErrorInterceptor;
import ee.mtakso.driver.network.interceptor.LocationInterceptor;
import ee.mtakso.driver.network.interceptor.LoggingInterceptor;
import ee.mtakso.driver.network.interceptor.PartnerAccessTokenInterceptor;
import ee.mtakso.driver.network.interceptor.StandardParamsInterceptors;
import ee.mtakso.driver.utils.TlsV12SocketFactory;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

/* compiled from: ClientFactory.kt */
/* loaded from: classes3.dex */
public final class ClientFactory {

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f21284f = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final StandardParamsInterceptors f21285a;

    /* renamed from: b  reason: collision with root package name */
    private final ApplogParamsInterceptor f21286b;

    /* renamed from: c  reason: collision with root package name */
    private final LoggingInterceptor f21287c;

    /* renamed from: d  reason: collision with root package name */
    private final CacheProvider f21288d;

    /* renamed from: e  reason: collision with root package name */
    private final HttpErrorInterceptor f21289e;

    /* compiled from: ClientFactory.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public ClientFactory(StandardParamsInterceptors paramsInterceptors, ApplogParamsInterceptor applogParamsInterceptor, LoggingInterceptor loggingInterceptor, CacheProvider cacheProvider, HttpErrorInterceptor httpErrorInterceptor) {
        Intrinsics.f(paramsInterceptors, "paramsInterceptors");
        Intrinsics.f(applogParamsInterceptor, "applogParamsInterceptor");
        Intrinsics.f(loggingInterceptor, "loggingInterceptor");
        Intrinsics.f(cacheProvider, "cacheProvider");
        Intrinsics.f(httpErrorInterceptor, "httpErrorInterceptor");
        this.f21285a = paramsInterceptors;
        this.f21286b = applogParamsInterceptor;
        this.f21287c = loggingInterceptor;
        this.f21288d = cacheProvider;
        this.f21289e = httpErrorInterceptor;
    }

    public final OkHttpClient a(OkHttpClient basic) {
        Intrinsics.f(basic, "basic");
        return basic.newBuilder().addInterceptor(this.f21285a).addNetworkInterceptor(this.f21287c).build();
    }

    public final OkHttpClient b(OkHttpClient basic) {
        Intrinsics.f(basic, "basic");
        return basic.newBuilder().addInterceptor(this.f21286b).build();
    }

    public final OkHttpClient c() {
        OkHttpClient.Builder connectTimeout = new OkHttpClient.Builder().connectTimeout(5L, TimeUnit.MINUTES);
        if (Build.VERSION.SDK_INT <= 22) {
            TlsV12SocketFactory.f36329b.a(connectTimeout);
        }
        return connectTimeout.build();
    }

    public final OkHttpClient d(OkHttpClient basic, LocationInterceptor locationInterceptor, AccessTokenInterceptor accessTokenInterceptor) {
        Intrinsics.f(basic, "basic");
        Intrinsics.f(locationInterceptor, "locationInterceptor");
        Intrinsics.f(accessTokenInterceptor, "accessTokenInterceptor");
        return basic.newBuilder().addInterceptor(this.f21285a).addNetworkInterceptor(this.f21287c).addNetworkInterceptor(locationInterceptor).addInterceptor(accessTokenInterceptor).build();
    }

    public final OkHttpClient e() {
        OkHttpClient.Builder cache = new OkHttpClient.Builder().cache(this.f21288d.c());
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder addInterceptor = cache.connectTimeout(20L, timeUnit).readTimeout(20L, timeUnit).writeTimeout(20L, timeUnit).addInterceptor(this.f21289e);
        if (Build.VERSION.SDK_INT <= 22) {
            TlsV12SocketFactory.f36329b.a(addInterceptor);
        }
        return addInterceptor.build();
    }

    public final OkHttpClient f(OkHttpClient basic, PartnerAccessTokenInterceptor partnerAccessTokenInterceptor) {
        Intrinsics.f(basic, "basic");
        Intrinsics.f(partnerAccessTokenInterceptor, "partnerAccessTokenInterceptor");
        return basic.newBuilder().addInterceptor(this.f21285a).addNetworkInterceptor(this.f21287c).addInterceptor(partnerAccessTokenInterceptor).build();
    }

    public final OkHttpClient g(OkHttpClient basic) {
        Intrinsics.f(basic, "basic");
        return basic.newBuilder().addNetworkInterceptor(this.f21287c).build();
    }
}
