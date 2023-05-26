package ee.mtakso.driver.network.interceptor;

import java.nio.charset.Charset;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;

/* compiled from: InterceptorUtil.kt */
/* loaded from: classes3.dex */
public final class InterceptorUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final InterceptorUtil f22953a = new InterceptorUtil();

    /* renamed from: b  reason: collision with root package name */
    private static final Charset f22954b = Charsets.f51135b;

    private InterceptorUtil() {
    }

    public static /* synthetic */ String b(InterceptorUtil interceptorUtil, Response response, long j8, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            j8 = Long.MAX_VALUE;
        }
        return interceptorUtil.a(response, j8);
    }

    public final String a(Response response, long j8) {
        boolean w7;
        Charset charset;
        Intrinsics.f(response, "response");
        ResponseBody body = response.body();
        if (body == null) {
            return null;
        }
        BufferedSource source = body.source();
        source.f(j8);
        Buffer s7 = source.s();
        w7 = StringsKt__StringsJVMKt.w("gzip", response.headers().get("Content-Encoding"), true);
        if (w7) {
            GzipSource gzipSource = new GzipSource(s7.clone());
            try {
                s7 = new Buffer();
                s7.V(gzipSource);
                CloseableKt.a(gzipSource, null);
            } finally {
            }
        }
        MediaType contentType = body.contentType();
        if (contentType == null || (charset = contentType.charset(f22954b)) == null) {
            charset = f22954b;
        }
        return s7.clone().L0(charset);
    }
}
