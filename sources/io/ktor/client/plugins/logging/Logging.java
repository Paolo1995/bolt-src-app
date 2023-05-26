package io.ktor.client.plugins.logging;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.observer.ResponseObserver;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteChannelKt;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* compiled from: Logging.kt */
/* loaded from: classes5.dex */
public final class Logging {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f46535d = new Companion(null);

    /* renamed from: e  reason: collision with root package name */
    private static final AttributeKey<Logging> f46536e = new AttributeKey<>("ClientLogging");

    /* renamed from: a  reason: collision with root package name */
    private final Logger f46537a;

    /* renamed from: b  reason: collision with root package name */
    private LogLevel f46538b;

    /* renamed from: c  reason: collision with root package name */
    private List<? extends Function1<? super HttpRequestBuilder, Boolean>> f46539c;

    /* compiled from: Logging.kt */
    /* loaded from: classes5.dex */
    public static final class Companion implements HttpClientPlugin<Config, Logging> {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        /* renamed from: c */
        public void a(Logging plugin, HttpClient scope) {
            Intrinsics.f(plugin, "plugin");
            Intrinsics.f(scope, "scope");
            plugin.m(scope);
            plugin.n(scope);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        /* renamed from: d */
        public Logging b(Function1<? super Config, Unit> block) {
            Intrinsics.f(block, "block");
            Config config = new Config();
            block.invoke(config);
            return new Logging(config.c(), config.b(), config.a(), null);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<Logging> getKey() {
            return Logging.f46536e;
        }
    }

    /* compiled from: Logging.kt */
    /* loaded from: classes5.dex */
    public static final class Config {

        /* renamed from: a  reason: collision with root package name */
        private List<Function1<HttpRequestBuilder, Boolean>> f46540a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private Logger f46541b = LoggerJvmKt.a(Logger.f46532a);

        /* renamed from: c  reason: collision with root package name */
        private LogLevel f46542c = LogLevel.HEADERS;

        public final List<Function1<HttpRequestBuilder, Boolean>> a() {
            return this.f46540a;
        }

        public final LogLevel b() {
            return this.f46542c;
        }

        public final Logger c() {
            return this.f46541b;
        }

        public final void d(LogLevel logLevel) {
            Intrinsics.f(logLevel, "<set-?>");
            this.f46542c = logLevel;
        }

        public final void e(Logger logger) {
            Intrinsics.f(logger, "<set-?>");
            this.f46541b = logger;
        }
    }

    private Logging(Logger logger, LogLevel logLevel, List<? extends Function1<? super HttpRequestBuilder, Boolean>> list) {
        this.f46537a = logger;
        this.f46538b = logLevel;
        this.f46539c = list;
    }

    public /* synthetic */ Logging(Logger logger, LogLevel logLevel, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(logger, logLevel, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object i(HttpRequestBuilder httpRequestBuilder, Continuation<? super OutgoingContent> continuation) {
        AttributeKey attributeKey;
        boolean z7;
        OutgoingContent outgoingContent = (OutgoingContent) httpRequestBuilder.c();
        HttpClientCallLogger httpClientCallLogger = new HttpClientCallLogger(this.f46537a);
        Attributes b8 = httpRequestBuilder.b();
        attributeKey = LoggingKt.f46567a;
        b8.b(attributeKey, httpClientCallLogger);
        StringBuilder sb = new StringBuilder();
        if (this.f46538b.f()) {
            sb.append("REQUEST: " + URLUtilsKt.c(httpRequestBuilder.h()));
            Intrinsics.e(sb, "append(value)");
            sb.append('\n');
            Intrinsics.e(sb, "append('\\n')");
            sb.append("METHOD: " + httpRequestBuilder.g());
            Intrinsics.e(sb, "append(value)");
            sb.append('\n');
            Intrinsics.e(sb, "append('\\n')");
        }
        if (this.f46538b.e()) {
            sb.append("COMMON HEADERS");
            Intrinsics.e(sb, "append(value)");
            sb.append('\n');
            Intrinsics.e(sb, "append('\\n')");
            LoggingUtilsKt.b(sb, httpRequestBuilder.getHeaders().a());
            sb.append("CONTENT HEADERS");
            Intrinsics.e(sb, "append(value)");
            sb.append('\n');
            Intrinsics.e(sb, "append('\\n')");
            Long a8 = outgoingContent.a();
            if (a8 != null) {
                LoggingUtilsKt.a(sb, HttpHeaders.f46782a.h(), String.valueOf(a8.longValue()));
            }
            ContentType b9 = outgoingContent.b();
            if (b9 != null) {
                LoggingUtilsKt.a(sb, HttpHeaders.f46782a.i(), b9.toString());
            }
            LoggingUtilsKt.b(sb, outgoingContent.c().a());
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        boolean z8 = true;
        if (sb2.length() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            httpClientCallLogger.c(sb2);
        }
        if (sb2.length() != 0) {
            z8 = false;
        }
        if (!z8 && this.f46538b.c()) {
            return j(outgoingContent, httpClientCallLogger, continuation);
        }
        httpClientCallLogger.a();
        return null;
    }

    private final Object j(OutgoingContent outgoingContent, final HttpClientCallLogger httpClientCallLogger, Continuation<? super OutgoingContent> continuation) {
        Charset charset;
        Job d8;
        final StringBuilder sb = new StringBuilder();
        sb.append("BODY Content-Type: " + outgoingContent.b());
        Intrinsics.e(sb, "append(value)");
        sb.append('\n');
        Intrinsics.e(sb, "append('\\n')");
        ContentType b8 = outgoingContent.b();
        if (b8 == null || (charset = ContentTypesKt.a(b8)) == null) {
            charset = Charsets.f51135b;
        }
        ByteChannel b9 = ByteChannelKt.b(false, 1, null);
        d8 = BuildersKt__Builders_commonKt.d(GlobalScope.f51286f, Dispatchers.d(), null, new Logging$logRequestBody$2(b9, charset, sb, null), 2, null);
        d8.X(new Function1<Throwable, Unit>() { // from class: io.ktor.client.plugins.logging.Logging$logRequestBody$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                HttpClientCallLogger httpClientCallLogger2 = HttpClientCallLogger.this;
                String sb2 = sb.toString();
                Intrinsics.e(sb2, "requestLog.toString()");
                httpClientCallLogger2.c(sb2);
                HttpClientCallLogger.this.a();
            }
        });
        return ObservingUtilsKt.a(outgoingContent, b9, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(HttpRequestBuilder httpRequestBuilder, Throwable th) {
        if (this.f46538b.f()) {
            Logger logger = this.f46537a;
            logger.log("REQUEST " + URLUtilsKt.c(httpRequestBuilder.h()) + " failed with exception: " + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(StringBuilder sb, HttpRequest httpRequest, Throwable th) {
        if (!this.f46538b.f()) {
            return;
        }
        sb.append("RESPONSE " + httpRequest.getUrl() + " failed with exception: " + th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(HttpClient httpClient) {
        httpClient.m().l(HttpSendPipeline.f46641h.b(), new Logging$setupRequestLogging$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(HttpClient httpClient) {
        httpClient.h().l(HttpReceivePipeline.f46657h.b(), new Logging$setupResponseLogging$1(this, null));
        httpClient.l().l(HttpResponsePipeline.f46667h.b(), new Logging$setupResponseLogging$2(this, null));
        if (!this.f46538b.c()) {
            return;
        }
        ResponseObserver.f46586c.a(new ResponseObserver(new Logging$setupResponseLogging$observer$1(this, null), null, 2, null), httpClient);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o(HttpRequestBuilder httpRequestBuilder) {
        boolean z7;
        if (this.f46539c.isEmpty()) {
            return true;
        }
        List<? extends Function1<? super HttpRequestBuilder, Boolean>> list = this.f46539c;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((Boolean) ((Function1) it.next()).invoke(httpRequestBuilder)).booleanValue()) {
                    z7 = true;
                    break;
                }
            }
        }
        z7 = false;
        if (z7) {
            return true;
        }
        return false;
    }

    public final LogLevel h() {
        return this.f46538b;
    }
}
