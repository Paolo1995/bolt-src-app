package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.content.TextContent;
import io.ktor.util.AttributeKey;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt___MapsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.Charsets;

/* compiled from: HttpPlainText.kt */
/* loaded from: classes5.dex */
public final class HttpPlainText {

    /* renamed from: d  reason: collision with root package name */
    public static final Plugin f46321d = new Plugin(null);

    /* renamed from: e  reason: collision with root package name */
    private static final AttributeKey<HttpPlainText> f46322e = new AttributeKey<>("HttpPlainText");

    /* renamed from: a  reason: collision with root package name */
    private final Charset f46323a;

    /* renamed from: b  reason: collision with root package name */
    private final Charset f46324b;

    /* renamed from: c  reason: collision with root package name */
    private final String f46325c;

    /* compiled from: HttpPlainText.kt */
    /* loaded from: classes5.dex */
    public static final class Config {

        /* renamed from: c  reason: collision with root package name */
        private Charset f46328c;

        /* renamed from: a  reason: collision with root package name */
        private final Set<Charset> f46326a = new LinkedHashSet();

        /* renamed from: b  reason: collision with root package name */
        private final Map<Charset, Float> f46327b = new LinkedHashMap();

        /* renamed from: d  reason: collision with root package name */
        private Charset f46329d = Charsets.f51135b;

        public final Map<Charset, Float> a() {
            return this.f46327b;
        }

        public final Set<Charset> b() {
            return this.f46326a;
        }

        public final Charset c() {
            return this.f46329d;
        }

        public final Charset d() {
            return this.f46328c;
        }
    }

    /* compiled from: HttpPlainText.kt */
    /* loaded from: classes5.dex */
    public static final class Plugin implements HttpClientPlugin<Config, HttpPlainText> {
        private Plugin() {
        }

        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        /* renamed from: c */
        public void a(HttpPlainText plugin, HttpClient scope) {
            Intrinsics.f(plugin, "plugin");
            Intrinsics.f(scope, "scope");
            scope.k().l(HttpRequestPipeline.f46627h.b(), new HttpPlainText$Plugin$install$1(plugin, null));
            scope.l().l(HttpResponsePipeline.f46667h.c(), new HttpPlainText$Plugin$install$2(plugin, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        /* renamed from: d */
        public HttpPlainText b(Function1<? super Config, Unit> block) {
            Intrinsics.f(block, "block");
            Config config = new Config();
            block.invoke(config);
            return new HttpPlainText(config.b(), config.a(), config.d(), config.c());
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<HttpPlainText> getKey() {
            return HttpPlainText.f46322e;
        }
    }

    public HttpPlainText(Set<? extends Charset> charsets, Map<Charset, Float> charsetQuality, Charset charset, Charset responseCharsetFallback) {
        List v7;
        List<Pair> v02;
        List v03;
        int b8;
        Intrinsics.f(charsets, "charsets");
        Intrinsics.f(charsetQuality, "charsetQuality");
        Intrinsics.f(responseCharsetFallback, "responseCharsetFallback");
        this.f46323a = responseCharsetFallback;
        v7 = MapsKt___MapsKt.v(charsetQuality);
        v02 = CollectionsKt___CollectionsKt.v0(v7, new Comparator() { // from class: io.ktor.client.plugins.HttpPlainText$special$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t7, T t8) {
                int a8;
                a8 = ComparisonsKt__ComparisonsKt.a((Float) ((Pair) t8).e(), (Float) ((Pair) t7).e());
                return a8;
            }
        });
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = charsets.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (true ^ charsetQuality.containsKey((Charset) next)) {
                arrayList.add(next);
            }
        }
        v03 = CollectionsKt___CollectionsKt.v0(arrayList, new Comparator() { // from class: io.ktor.client.plugins.HttpPlainText$special$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t7, T t8) {
                int a8;
                a8 = ComparisonsKt__ComparisonsKt.a(CharsetJVMKt.i((Charset) t7), CharsetJVMKt.i((Charset) t8));
                return a8;
            }
        });
        StringBuilder sb = new StringBuilder();
        Iterator it2 = v03.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Charset charset2 = (Charset) it2.next();
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(CharsetJVMKt.i(charset2));
        }
        for (Pair pair : v02) {
            Charset charset3 = (Charset) pair.a();
            float floatValue = ((Number) pair.b()).floatValue();
            if (sb.length() > 0) {
                sb.append(",");
            }
            double d8 = floatValue;
            if (0.0d <= d8 && d8 <= 1.0d) {
                b8 = MathKt__MathJVMKt.b(100 * floatValue);
                sb.append(CharsetJVMKt.i(charset3) + ";q=" + (b8 / 100.0d));
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        if (sb.length() == 0) {
            sb.append(CharsetJVMKt.i(this.f46323a));
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        this.f46325c = sb2;
        if (charset == null && (charset = (Charset) CollectionsKt___CollectionsKt.Y(v03)) == null) {
            Pair pair2 = (Pair) CollectionsKt___CollectionsKt.Y(v02);
            charset = pair2 != null ? (Charset) pair2.d() : null;
            if (charset == null) {
                charset = Charsets.f51135b;
            }
        }
        this.f46324b = charset;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object e(String str, ContentType contentType) {
        ContentType contentType2;
        Charset charset;
        if (contentType == null) {
            contentType2 = ContentType.Text.f46754a.a();
        } else {
            contentType2 = contentType;
        }
        if (contentType == null || (charset = ContentTypesKt.a(contentType)) == null) {
            charset = this.f46324b;
        }
        return new TextContent(str, ContentTypesKt.b(contentType2, charset), null, 4, null);
    }

    public final void c(HttpRequestBuilder context) {
        Intrinsics.f(context, "context");
        HeadersBuilder headers = context.getHeaders();
        HttpHeaders httpHeaders = HttpHeaders.f46782a;
        if (headers.j(httpHeaders.d()) != null) {
            return;
        }
        context.getHeaders().m(httpHeaders.d(), this.f46325c);
    }

    public final String d(HttpClientCall call, Input body) {
        Intrinsics.f(call, "call");
        Intrinsics.f(body, "body");
        Charset b8 = HttpMessagePropertiesKt.b(call.f());
        if (b8 == null) {
            b8 = this.f46323a;
        }
        return StringsKt.e(body, b8, 0, 2, null);
    }
}
