package ee.mtakso.driver.network.interceptor;

import ee.mtakso.driver.network.internal.MediaTypes;
import eu.bolt.driver.core.time.SystemUptimeSource;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.LogEntry;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.inject.Inject;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LoggingInterceptor.kt */
/* loaded from: classes3.dex */
public final class LoggingInterceptor implements Interceptor {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f22961d = new Companion(null);

    /* renamed from: e  reason: collision with root package name */
    private static final Set<String> f22962e;

    /* renamed from: a  reason: collision with root package name */
    private final SystemUptimeSource f22963a;

    /* renamed from: b  reason: collision with root package name */
    private final Charset f22964b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicLong f22965c;

    /* compiled from: LoggingInterceptor.kt */
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
        f8 = SetsKt__SetsKt.f("/driver/startAuthentication", "/driver/completeAuthentication", "/driver/getAccessToken", "/driver/logout", "/comms-manager/driver/getAllContactConfigurations", "/comms-manager/driver/getContactOptionDetails", "/comms-manager/driver/getAvailableContactOptions");
        f22962e = f8;
    }

    @Inject
    public LoggingInterceptor(SystemUptimeSource timeSource) {
        Intrinsics.f(timeSource, "timeSource");
        this.f22963a = timeSource;
        this.f22964b = Charsets.f51135b;
        this.f22965c = new AtomicLong(0L);
    }

    private final String a(Request request) {
        RequestBody body;
        if (c(request)) {
            return "████";
        }
        if (Intrinsics.a(request.method(), "GET") || (body = request.body()) == null) {
            return null;
        }
        Buffer buffer = new Buffer();
        body.writeTo(buffer);
        return buffer.L0(this.f22964b);
    }

    private final String b(Response response) {
        MediaType mediaType;
        ResponseBody body = response.body();
        MediaType mediaType2 = null;
        if (body != null) {
            mediaType = body.contentType();
        } else {
            mediaType = null;
        }
        MediaTypes mediaTypes = MediaTypes.f22978a;
        if (Intrinsics.a(mediaType, mediaTypes.c())) {
            return "PNG BINARY";
        }
        ResponseBody body2 = response.body();
        if (body2 != null) {
            mediaType2 = body2.contentType();
        }
        if (Intrinsics.a(mediaType2, mediaTypes.b())) {
            return "XML";
        }
        if (c(response.request())) {
            return "████";
        }
        return InterceptorUtil.b(InterceptorUtil.f22953a, response, 0L, 2, null);
    }

    private final boolean c(Request request) {
        if (f22962e.contains(request.url().encodedPath())) {
            return true;
        }
        return false;
    }

    private final void d(String str, Request request, long j8, Throwable th) {
        int v7;
        Map q8;
        HttpUrl url = request.url();
        Set<String> queryParameterNames = url.queryParameterNames();
        v7 = CollectionsKt__IterablesKt.v(queryParameterNames, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (String str2 : queryParameterNames) {
            arrayList.add(TuplesKt.a(str2, url.queryParameter(str2)));
        }
        q8 = MapsKt__MapsKt.q(arrayList);
        LogEntry n8 = Kalev.n("method", request.method()).n("path", url.encodedPath());
        n8.n("duration", Double.valueOf(j8 / 1000.0d));
        n8.n("trace_id", str);
        for (Map.Entry entry : q8.entrySet()) {
            String str3 = (String) entry.getKey();
            String str4 = (String) entry.getValue();
            if (str4 == null) {
                str4 = "";
            }
            n8.n(str3, str4);
        }
        String a8 = a(request);
        if (a8 != null) {
            try {
                n8.n("request.body", new JSONObject(a8));
            } catch (JSONException unused) {
                n8.n("request.body", a8);
            }
        }
        n8.n("response.error", th.getClass().getName());
        String message = th.getMessage();
        if (message != null) {
            n8.n("response.error.message", message);
        }
        n8.b("network");
    }

    private final void e(String str, Request request) {
        Kalev.n("host", request.url().host()).n("path", request.url().encodedPath()).n("method", request.method()).n("trace_id", str).l("network");
    }

    private final void f(String str, Response response, long j8) {
        HttpUrl url = response.request().url();
        LogEntry n8 = Kalev.n("host", url.host()).n("path", url.encodedPath()).n("method", response.request().method()).n("trace_id", str).n("duration", Double.valueOf(j8 / 1000.0d)).n("trace_id", str);
        for (String str2 : url.queryParameterNames()) {
            String queryParameter = url.queryParameter(str2);
            if (queryParameter == null) {
                queryParameter = "";
            }
            n8.n(str2, queryParameter);
        }
        String a8 = a(response.request());
        if (a8 != null) {
            try {
                n8.n("request.body", new JSONObject(a8));
            } catch (JSONException unused) {
                n8.n("request.body", a8);
            }
        }
        n8.n("response.code", Integer.valueOf(response.code()));
        String b8 = b(response);
        if (b8 != null) {
            try {
                n8.n("response.body", new JSONObject(b8));
            } catch (JSONException unused2) {
                n8.n("response.body", b8);
            }
        }
        n8.l("network");
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.f(chain, "chain");
        String valueOf = String.valueOf(this.f22965c.incrementAndGet());
        Request request = chain.request();
        e(valueOf, request);
        long a8 = this.f22963a.a();
        try {
            Response proceed = chain.proceed(request);
            f(valueOf, proceed, this.f22963a.a() - a8);
            return proceed;
        } catch (Exception e8) {
            d(valueOf, request, this.f22963a.a() - a8, e8);
            throw e8;
        }
    }
}
