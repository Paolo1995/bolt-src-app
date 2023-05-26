package okhttp3.logging;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;

/* compiled from: HttpLoggingInterceptor.kt */
/* loaded from: classes5.dex */
public final class HttpLoggingInterceptor implements Interceptor {
    private volatile Set<String> headersToRedact;
    private volatile Level level;
    private final Logger logger;

    /* compiled from: HttpLoggingInterceptor.kt */
    /* loaded from: classes5.dex */
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* compiled from: HttpLoggingInterceptor.kt */
    /* loaded from: classes5.dex */
    public interface Logger {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final Logger DEFAULT = new Companion.DefaultLogger();

        /* compiled from: HttpLoggingInterceptor.kt */
        /* loaded from: classes5.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            /* compiled from: HttpLoggingInterceptor.kt */
            /* loaded from: classes5.dex */
            private static final class DefaultLogger implements Logger {
                @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
                public void log(String message) {
                    Intrinsics.f(message, "message");
                    Platform.log$default(Platform.Companion.get(), message, 0, null, 6, null);
                }
            }

            private Companion() {
            }
        }

        void log(String str);
    }

    public HttpLoggingInterceptor() {
        this(null, 1, null);
    }

    public HttpLoggingInterceptor(Logger logger) {
        Set<String> b8;
        Intrinsics.f(logger, "logger");
        this.logger = logger;
        b8 = SetsKt__SetsKt.b();
        this.headersToRedact = b8;
        this.level = Level.NONE;
    }

    private final boolean bodyHasUnknownEncoding(Headers headers) {
        boolean w7;
        boolean w8;
        String str = headers.get("Content-Encoding");
        if (str == null) {
            return false;
        }
        w7 = StringsKt__StringsJVMKt.w(str, "identity", true);
        if (w7) {
            return false;
        }
        w8 = StringsKt__StringsJVMKt.w(str, "gzip", true);
        if (w8) {
            return false;
        }
        return true;
    }

    private final void logHeader(Headers headers, int i8) {
        String value;
        if (this.headersToRedact.contains(headers.name(i8))) {
            value = "██";
        } else {
            value = headers.value(i8);
        }
        Logger logger = this.logger;
        logger.log(headers.name(i8) + ": " + value);
    }

    /* renamed from: -deprecated_level  reason: not valid java name */
    public final Level m149deprecated_level() {
        return this.level;
    }

    public final Level getLevel() {
        return this.level;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        String str;
        char c8;
        String sb;
        boolean w7;
        Charset charset;
        Long l8;
        Intrinsics.f(chain, "chain");
        Level level = this.level;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }
        boolean z7 = level == Level.BODY;
        boolean z8 = z7 || level == Level.HEADERS;
        RequestBody body = request.body();
        Connection connection = chain.connection();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("--> ");
        sb2.append(request.method());
        sb2.append(' ');
        sb2.append(request.url());
        sb2.append(connection != null ? Intrinsics.n(" ", connection.protocol()) : "");
        String sb3 = sb2.toString();
        if (!z8 && body != 0) {
            sb3 = sb3 + " (" + body.contentLength() + "-byte body)";
        }
        this.logger.log(sb3);
        if (z8) {
            Headers headers = request.headers();
            if (body != null) {
                MediaType contentType = body.contentType();
                if (contentType != null && headers.get("Content-Type") == null) {
                    this.logger.log(Intrinsics.n("Content-Type: ", contentType));
                }
                if (body.contentLength() != -1 && headers.get("Content-Length") == null) {
                    this.logger.log(Intrinsics.n("Content-Length: ", Long.valueOf(body.contentLength())));
                }
            }
            int size = headers.size();
            for (int i8 = 0; i8 < size; i8++) {
                logHeader(headers, i8);
            }
            if (z7 && body != null) {
                if (bodyHasUnknownEncoding(request.headers())) {
                    this.logger.log("--> END " + request.method() + " (encoded body omitted)");
                } else if (body.isDuplex()) {
                    this.logger.log("--> END " + request.method() + " (duplex request body omitted)");
                } else if (body.isOneShot()) {
                    this.logger.log("--> END " + request.method() + " (one-shot body omitted)");
                } else {
                    Buffer buffer = new Buffer();
                    body.writeTo(buffer);
                    MediaType contentType2 = body.contentType();
                    Charset UTF_8 = contentType2 == null ? null : contentType2.charset(StandardCharsets.UTF_8);
                    if (UTF_8 == null) {
                        UTF_8 = StandardCharsets.UTF_8;
                        Intrinsics.e(UTF_8, "UTF_8");
                    }
                    this.logger.log("");
                    if (Utf8Kt.isProbablyUtf8(buffer)) {
                        this.logger.log(buffer.L0(UTF_8));
                        this.logger.log("--> END " + request.method() + " (" + body.contentLength() + "-byte body)");
                    } else {
                        this.logger.log("--> END " + request.method() + " (binary " + body.contentLength() + "-byte body omitted)");
                    }
                }
            } else {
                this.logger.log(Intrinsics.n("--> END ", request.method()));
            }
        }
        long nanoTime = System.nanoTime();
        try {
            Response proceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody body2 = proceed.body();
            Intrinsics.c(body2);
            long contentLength = body2.contentLength();
            String str2 = contentLength != -1 ? contentLength + "-byte" : "unknown-length";
            Logger logger = this.logger;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("<-- ");
            sb4.append(proceed.code());
            if (proceed.message().length() == 0) {
                str = "-byte body omitted)";
                sb = "";
                c8 = ' ';
            } else {
                String message = proceed.message();
                StringBuilder sb5 = new StringBuilder();
                str = "-byte body omitted)";
                c8 = ' ';
                sb5.append(' ');
                sb5.append(message);
                sb = sb5.toString();
            }
            sb4.append(sb);
            sb4.append(c8);
            sb4.append(proceed.request().url());
            sb4.append(" (");
            sb4.append(millis);
            sb4.append("ms");
            sb4.append(z8 ? "" : ", " + str2 + " body");
            sb4.append(')');
            logger.log(sb4.toString());
            if (z8) {
                Headers headers2 = proceed.headers();
                int size2 = headers2.size();
                for (int i9 = 0; i9 < size2; i9++) {
                    logHeader(headers2, i9);
                }
                if (z7 && HttpHeaders.promisesBody(proceed)) {
                    if (bodyHasUnknownEncoding(proceed.headers())) {
                        this.logger.log("<-- END HTTP (encoded body omitted)");
                    } else {
                        BufferedSource source = body2.source();
                        source.f(Long.MAX_VALUE);
                        Buffer b8 = source.b();
                        w7 = StringsKt__StringsJVMKt.w("gzip", headers2.get("Content-Encoding"), true);
                        if (w7) {
                            l8 = Long.valueOf(b8.size());
                            GzipSource gzipSource = new GzipSource(b8.clone());
                            try {
                                b8 = new Buffer();
                                b8.V(gzipSource);
                                charset = null;
                                CloseableKt.a(gzipSource, null);
                            } finally {
                            }
                        } else {
                            charset = null;
                            l8 = null;
                        }
                        MediaType contentType3 = body2.contentType();
                        Charset UTF_82 = contentType3 == null ? charset : contentType3.charset(StandardCharsets.UTF_8);
                        if (UTF_82 == null) {
                            UTF_82 = StandardCharsets.UTF_8;
                            Intrinsics.e(UTF_82, "UTF_8");
                        }
                        if (!Utf8Kt.isProbablyUtf8(b8)) {
                            this.logger.log("");
                            this.logger.log("<-- END HTTP (binary " + b8.size() + str);
                            return proceed;
                        }
                        if (contentLength != 0) {
                            this.logger.log("");
                            this.logger.log(b8.clone().L0(UTF_82));
                        }
                        if (l8 != null) {
                            this.logger.log("<-- END HTTP (" + b8.size() + "-byte, " + l8 + "-gzipped-byte body)");
                        } else {
                            this.logger.log("<-- END HTTP (" + b8.size() + "-byte body)");
                        }
                    }
                } else {
                    this.logger.log("<-- END HTTP");
                }
            }
            return proceed;
        } catch (Exception e8) {
            this.logger.log(Intrinsics.n("<-- HTTP FAILED: ", e8));
            throw e8;
        }
    }

    public final void level(Level level) {
        Intrinsics.f(level, "<set-?>");
        this.level = level;
    }

    public final void redactHeader(String name) {
        Comparator x7;
        Intrinsics.f(name, "name");
        x7 = StringsKt__StringsJVMKt.x(StringCompanionObject.f51021a);
        TreeSet treeSet = new TreeSet(x7);
        CollectionsKt__MutableCollectionsKt.A(treeSet, this.headersToRedact);
        treeSet.add(name);
        this.headersToRedact = treeSet;
    }

    public final HttpLoggingInterceptor setLevel(Level level) {
        Intrinsics.f(level, "level");
        level(level);
        return this;
    }

    public /* synthetic */ HttpLoggingInterceptor(Logger logger, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? Logger.DEFAULT : logger);
    }
}
