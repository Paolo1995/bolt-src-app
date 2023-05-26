package ee.mtakso.driver.network.interceptor;

import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.geo.GeoLocation;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: LocationInterceptor.kt */
/* loaded from: classes3.dex */
public final class LocationInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    private final GeoLocationManager f22955a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverProvider f22956b;

    /* renamed from: c  reason: collision with root package name */
    private final TrueTimeProvider f22957c;

    @Inject
    public LocationInterceptor(GeoLocationManager locationManager, DriverProvider driverProvider, TrueTimeProvider trueTimeProvider) {
        Intrinsics.f(locationManager, "locationManager");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(trueTimeProvider, "trueTimeProvider");
        this.f22955a = locationManager;
        this.f22956b = driverProvider;
        this.f22957c = trueTimeProvider;
    }

    private final void a(HttpUrl.Builder builder, String str, Double d8) {
        if (d8 == null || Double.isNaN(d8.doubleValue()) || Double.isInfinite(d8.doubleValue())) {
            return;
        }
        builder.addQueryParameter(str, d8.toString());
    }

    private final void b(HttpUrl.Builder builder, String str, Float f8) {
        if (f8 == null || Float.isNaN(f8.floatValue()) || Float.isInfinite(f8.floatValue())) {
            return;
        }
        builder.addQueryParameter(str, f8.toString());
    }

    private final boolean c(Request request) {
        if (request.header("Location") != null) {
            return true;
        }
        return false;
    }

    private final boolean d(Request request) {
        return Intrinsics.a("Optional", request.header("Location"));
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.f(chain, "chain");
        Request request = chain.request();
        if (!c(request)) {
            return chain.proceed(request);
        }
        GeoLocation q8 = this.f22955a.q();
        if (q8 == null && d(request) && this.f22956b.q().G()) {
            return chain.proceed(request.newBuilder().removeHeader("Location").build());
        }
        if (q8 != null) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(q8.i());
            long a8 = this.f22957c.a() - seconds;
            HttpUrl.Builder newBuilder = request.url().newBuilder();
            newBuilder.addQueryParameter("gps_lat", String.valueOf(q8.e().a()));
            newBuilder.addQueryParameter("gps_lng", String.valueOf(q8.e().b()));
            a(newBuilder, "gps_bearing", q8.c());
            if (this.f22956b.q().z()) {
                b(newBuilder, "gps_bearing_accuracy_deg", q8.d());
            }
            newBuilder.addQueryParameter("gps_adjusted_bearing", String.valueOf(q8.a()));
            newBuilder.addQueryParameter("gps_accuracy_meters", String.valueOf(q8.f()));
            newBuilder.addQueryParameter("gps_timestamp", String.valueOf(seconds));
            newBuilder.addQueryParameter("gps_age", String.valueOf(a8));
            if (this.f22956b.q().A()) {
                b(newBuilder, "gps_speed", q8.g());
                if (this.f22956b.q().z()) {
                    b(newBuilder, "gps_speed_accuracy_mps", q8.h());
                }
            }
            return chain.proceed(request.newBuilder().url(newBuilder.build()).removeHeader("Location").build());
        }
        throw new IllegalStateException("Location is required for making this call".toString());
    }
}
