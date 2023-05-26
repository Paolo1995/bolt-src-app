package io.ktor.client.request;

import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.engine.HttpClientEngineCapabilityKt;
import io.ktor.client.utils.EmptyContent;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.AttributesKt;
import io.ktor.util.StringValuesKt;
import io.ktor.util.reflect.TypeInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: HttpRequest.kt */
/* loaded from: classes5.dex */
public final class HttpRequestBuilder implements HttpMessageBuilder {

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f46612g = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final URLBuilder f46613a = new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null);

    /* renamed from: b  reason: collision with root package name */
    private HttpMethod f46614b = HttpMethod.f46834b.a();

    /* renamed from: c  reason: collision with root package name */
    private final HeadersBuilder f46615c = new HeadersBuilder(0, 1, null);

    /* renamed from: d  reason: collision with root package name */
    private Object f46616d = EmptyContent.f46708a;

    /* renamed from: e  reason: collision with root package name */
    private Job f46617e = SupervisorKt.b(null, 1, null);

    /* renamed from: f  reason: collision with root package name */
    private final Attributes f46618f = AttributesJvmKt.a(true);

    /* compiled from: HttpRequest.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final HttpRequestData a() {
        OutgoingContent outgoingContent;
        Url b8 = this.f46613a.b();
        HttpMethod httpMethod = this.f46614b;
        Headers p8 = getHeaders().p();
        Object obj = this.f46616d;
        if (obj instanceof OutgoingContent) {
            outgoingContent = (OutgoingContent) obj;
        } else {
            outgoingContent = null;
        }
        OutgoingContent outgoingContent2 = outgoingContent;
        if (outgoingContent2 != null) {
            return new HttpRequestData(b8, httpMethod, p8, outgoingContent2, this.f46617e, this.f46618f);
        }
        throw new IllegalStateException(("No request transformation found: " + this.f46616d).toString());
    }

    public final Attributes b() {
        return this.f46618f;
    }

    public final Object c() {
        return this.f46616d;
    }

    public final TypeInfo d() {
        return (TypeInfo) this.f46618f.f(RequestBodyKt.a());
    }

    public final <T> T e(HttpClientEngineCapability<T> key) {
        Intrinsics.f(key, "key");
        Map map = (Map) this.f46618f.f(HttpClientEngineCapabilityKt.a());
        if (map != null) {
            return (T) map.get(key);
        }
        return null;
    }

    public final Job f() {
        return this.f46617e;
    }

    public final HttpMethod g() {
        return this.f46614b;
    }

    @Override // io.ktor.http.HttpMessageBuilder
    public HeadersBuilder getHeaders() {
        return this.f46615c;
    }

    public final URLBuilder h() {
        return this.f46613a;
    }

    public final void i(Object obj) {
        Intrinsics.f(obj, "<set-?>");
        this.f46616d = obj;
    }

    public final void j(TypeInfo typeInfo) {
        if (typeInfo != null) {
            this.f46618f.b(RequestBodyKt.a(), typeInfo);
        } else {
            this.f46618f.d(RequestBodyKt.a());
        }
    }

    public final <T> void k(HttpClientEngineCapability<T> key, T capability) {
        Intrinsics.f(key, "key");
        Intrinsics.f(capability, "capability");
        ((Map) this.f46618f.g(HttpClientEngineCapabilityKt.a(), new Function0<Map<HttpClientEngineCapability<?>, Object>>() { // from class: io.ktor.client.request.HttpRequestBuilder$setCapability$capabilities$1
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Map<HttpClientEngineCapability<?>, Object> invoke() {
                return new LinkedHashMap();
            }
        })).put(key, capability);
    }

    public final void l(Job job) {
        Intrinsics.f(job, "<set-?>");
        this.f46617e = job;
    }

    public final void m(HttpMethod httpMethod) {
        Intrinsics.f(httpMethod, "<set-?>");
        this.f46614b = httpMethod;
    }

    public final HttpRequestBuilder n(HttpRequestBuilder builder) {
        Intrinsics.f(builder, "builder");
        this.f46614b = builder.f46614b;
        this.f46616d = builder.f46616d;
        j(builder.d());
        URLUtilsKt.h(this.f46613a, builder.f46613a);
        URLBuilder uRLBuilder = this.f46613a;
        uRLBuilder.u(uRLBuilder.g());
        StringValuesKt.c(getHeaders(), builder.getHeaders());
        AttributesKt.a(this.f46618f, builder.f46618f);
        return this;
    }

    public final HttpRequestBuilder o(HttpRequestBuilder builder) {
        Intrinsics.f(builder, "builder");
        this.f46617e = builder.f46617e;
        return n(builder);
    }

    public final void p(Function2<? super URLBuilder, ? super URLBuilder, Unit> block) {
        Intrinsics.f(block, "block");
        URLBuilder uRLBuilder = this.f46613a;
        block.s(uRLBuilder, uRLBuilder);
    }
}
