package ee.mtakso.driver.network.interceptor;

import ee.mtakso.driver.network.client.auth.anonymous.AccessToken;
import ee.mtakso.driver.service.token.TokenManager;
import ee.mtakso.driver.service.token.UnavailableAccessTokenException;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: AccessTokenInterceptor.kt */
/* loaded from: classes3.dex */
public final class AccessTokenInterceptor implements Interceptor {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f22937b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final TokenManager f22938a;

    /* compiled from: AccessTokenInterceptor.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public AccessTokenInterceptor(TokenManager tokenService) {
        Intrinsics.f(tokenService, "tokenService");
        this.f22938a = tokenService;
    }

    private final String a(String str) {
        return "Bearer " + str;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.f(chain, "chain");
        Kalev kalev = Kalev.f41674e;
        FastLog g8 = kalev.g();
        String str = null;
        if (g8 != null) {
            String encodedPath = chain.request().url().encodedPath();
            FastLog.DefaultImpls.c(g8, "AccessTokenInterceptor intercepted the request " + encodedPath, null, 2, null);
        }
        AccessToken c8 = this.f22938a.q().c();
        if (c8 == null) {
            try {
                c8 = this.f22938a.H().d();
            } catch (Throwable th) {
                throw new UnavailableAccessTokenException(th);
            }
        }
        FastLog g9 = kalev.g();
        if (g9 != null) {
            FastLog.DefaultImpls.c(g9, "AccessTokenInterceptor got token: " + c8, null, 2, null);
        }
        Request.Builder newBuilder = chain.request().newBuilder();
        if (c8 != null) {
            str = c8.a();
        }
        return chain.proceed(newBuilder.addHeader("Authorization", a(str)).build());
    }
}
