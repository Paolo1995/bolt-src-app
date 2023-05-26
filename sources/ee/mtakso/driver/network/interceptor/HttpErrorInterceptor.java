package ee.mtakso.driver.network.interceptor;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import ee.mtakso.driver.log.report.ReportManager;
import ee.mtakso.driver.network.exception.ApiException;
import ee.mtakso.driver.network.exception.ApiExceptionFactory;
import ee.mtakso.driver.network.exception.HttpException;
import ee.mtakso.driver.network.exception.HttpTransportException;
import ee.mtakso.driver.network.response.BasicServerResponse;
import ee.mtakso.driver.network.response.EmptyDestinationServerResponse;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.network.response.ResponseErrorProcessor;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.facade.NetworkErrorAnalytics;
import java.util.Set;
import javax.inject.Inject;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;

/* compiled from: HttpErrorInterceptor.kt */
/* loaded from: classes3.dex */
public final class HttpErrorInterceptor implements Interceptor {

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f22940g = new Companion(null);

    /* renamed from: h  reason: collision with root package name */
    private static final Set<String> f22941h;

    /* renamed from: a  reason: collision with root package name */
    private final ResponseErrorProcessor f22942a;

    /* renamed from: b  reason: collision with root package name */
    private final NetworkErrorAnalytics f22943b;

    /* renamed from: c  reason: collision with root package name */
    private final ApiExceptionFactory f22944c;

    /* renamed from: d  reason: collision with root package name */
    private final ReportManager f22945d;

    /* renamed from: e  reason: collision with root package name */
    private final DriverProvider f22946e;

    /* renamed from: f  reason: collision with root package name */
    private final Gson f22947f;

    /* compiled from: HttpErrorInterceptor.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Set<String> f8;
        f8 = SetsKt__SetsKt.f("/orderDriver/driverStartWorking/", "/driver/addDriverDestination/", "/driver/updateDriverDestination/", "/orderDriver/setActiveDriverDestination/", "/driver/deleteDriverDestination/");
        f22941h = f8;
    }

    @Inject
    public HttpErrorInterceptor(ResponseErrorProcessor responseProcessor, NetworkErrorAnalytics networkErrorAnalytics, ApiExceptionFactory exceptionFactory, ReportManager reportManager, DriverProvider driverProvider) {
        Intrinsics.f(responseProcessor, "responseProcessor");
        Intrinsics.f(networkErrorAnalytics, "networkErrorAnalytics");
        Intrinsics.f(exceptionFactory, "exceptionFactory");
        Intrinsics.f(reportManager, "reportManager");
        Intrinsics.f(driverProvider, "driverProvider");
        this.f22942a = responseProcessor;
        this.f22943b = networkErrorAnalytics;
        this.f22944c = exceptionFactory;
        this.f22945d = reportManager;
        this.f22946e = driverProvider;
        this.f22947f = new Gson();
    }

    private final BasicServerResponse a(Response response) {
        if (f22941h.contains(response.request().url().encodedPath())) {
            return c(response);
        }
        return b(response);
    }

    private final EmptyServerResponse b(Response response) {
        try {
            return (EmptyServerResponse) this.f22947f.fromJson(InterceptorUtil.b(InterceptorUtil.f22953a, response, 0L, 2, null), (Class<Object>) EmptyServerResponse.class);
        } catch (JsonSyntaxException unused) {
            return null;
        }
    }

    private final EmptyDestinationServerResponse c(Response response) {
        try {
            return (EmptyDestinationServerResponse) this.f22947f.fromJson(InterceptorUtil.b(InterceptorUtil.f22953a, response, 0L, 2, null), (Class<Object>) EmptyDestinationServerResponse.class);
        } catch (JsonSyntaxException unused) {
            return null;
        }
    }

    private final boolean d(Response response) {
        int code = response.code();
        if (code != 400 && code != 429 && code != 500) {
            return false;
        }
        return true;
    }

    private final void e(ApiException apiException, String str, String str2) {
        if (apiException.e() == null) {
            this.f22943b.V(str, apiException.c(), str2);
        } else {
            this.f22943b.j0(str, apiException.c(), str2);
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.f(chain, "chain");
        String host = chain.request().url().host();
        String encodedPath = chain.request().url().encodedPath();
        try {
            Response proceed = chain.proceed(chain.request());
            int code = proceed.code();
            if (proceed.isSuccessful()) {
                BasicServerResponse a8 = a(proceed);
                if (a8 == null) {
                    return proceed;
                }
                ApiException a9 = this.f22944c.a(encodedPath, a8);
                if (a9 != null) {
                    this.f22943b.I(host, encodedPath, a8.c());
                    if (this.f22946e.d() != null) {
                        if (this.f22946e.q().c()) {
                            e(a9, encodedPath, a8.c());
                        }
                    } else {
                        e(a9, encodedPath, a8.c());
                    }
                    this.f22945d.d(a9);
                    this.f22942a.d(a9);
                    throw a9;
                }
            } else if (d(proceed)) {
                BasicServerResponse a10 = a(proceed);
                if (a10 != null) {
                    ApiException a11 = this.f22944c.a(encodedPath, a10);
                    if (a11 != null) {
                        this.f22943b.I(host, encodedPath, a10.c());
                        if (this.f22946e.d() != null) {
                            if (this.f22946e.q().c()) {
                                e(a11, encodedPath, a10.c());
                            }
                        } else {
                            e(a11, encodedPath, a10.c());
                        }
                        this.f22945d.d(a11);
                        this.f22942a.d(a11);
                        throw a11;
                    }
                } else {
                    this.f22943b.T0(host, encodedPath, code);
                    HttpException httpException = new HttpException(host, encodedPath, code);
                    this.f22945d.d(httpException);
                    throw httpException;
                }
            } else {
                this.f22943b.T0(host, encodedPath, code);
                HttpException httpException2 = new HttpException(host, encodedPath, code);
                this.f22945d.d(httpException2);
                throw httpException2;
            }
            return proceed;
        } catch (Throwable th) {
            NetworkErrorAnalytics networkErrorAnalytics = this.f22943b;
            String simpleName = th.getClass().getSimpleName();
            Intrinsics.e(simpleName, "exc.javaClass.simpleName");
            networkErrorAnalytics.r0(host, encodedPath, simpleName);
            throw new HttpTransportException(host, encodedPath, th);
        }
    }
}
