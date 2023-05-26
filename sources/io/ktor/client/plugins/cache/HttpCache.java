package io.ktor.client.plugins.cache;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.cache.storage.HttpCacheStorage;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.events.EventDefinition;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.Url;
import io.ktor.util.AttributeKey;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.pipeline.PipelinePhase;
import io.ktor.utils.io.ByteChannelCtorKt;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpCache.kt */
/* loaded from: classes5.dex */
public final class HttpCache {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f46419c = new Companion(null);

    /* renamed from: d  reason: collision with root package name */
    private static final AttributeKey<HttpCache> f46420d = new AttributeKey<>("HttpCache");

    /* renamed from: e  reason: collision with root package name */
    private static final EventDefinition<HttpResponse> f46421e = new EventDefinition<>();

    /* renamed from: a  reason: collision with root package name */
    private final HttpCacheStorage f46422a;

    /* renamed from: b  reason: collision with root package name */
    private final HttpCacheStorage f46423b;

    /* compiled from: HttpCache.kt */
    /* loaded from: classes5.dex */
    public static final class Companion implements HttpClientPlugin<Config, HttpCache> {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object i(PipelineContext<Object, HttpRequestBuilder> pipelineContext, HttpClient httpClient, HttpClientCall httpClientCall, Continuation<? super Unit> continuation) {
            Object d8;
            pipelineContext.b();
            httpClient.g().a(f(), httpClientCall.f());
            Object g8 = pipelineContext.g(httpClientCall, continuation);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            if (g8 == d8) {
                return g8;
            }
            return Unit.f50853a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object j(PipelineContext<Object, HttpRequestBuilder> pipelineContext, HttpClient httpClient, Continuation<? super Unit> continuation) {
            Object d8;
            pipelineContext.b();
            HttpRequestData a8 = pipelineContext.c().a();
            Object g8 = pipelineContext.g(new HttpClientCall(httpClient, a8, new HttpResponseData(HttpStatusCode.f46855c.k(), DateJvmKt.c(null, 1, null), Headers.f46777a.a(), HttpProtocolVersion.f46844d.b(), ByteChannelCtorKt.a(new byte[0]), a8.d())), continuation);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            if (g8 == d8) {
                return g8;
            }
            return Unit.f50853a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object k(PipelineContext<Object, HttpRequestBuilder> pipelineContext, HttpClientCall httpClientCall, HttpClient httpClient, Continuation<? super Unit> continuation) {
            Object d8;
            HttpRequestData a8 = pipelineContext.c().a();
            HttpStatusCode e8 = httpClientCall.f().e();
            GMTDate b8 = httpClientCall.f().b();
            Headers.Companion companion = Headers.f46777a;
            HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
            headersBuilder.d(httpClientCall.f().getHeaders());
            headersBuilder.f(HttpHeaders.f46782a.u(), "110");
            HttpClientCall httpClientCall2 = new HttpClientCall(httpClient, a8, new HttpResponseData(e8, b8, headersBuilder.p(), httpClientCall.f().f(), httpClientCall.f().a(), httpClientCall.f().j()));
            pipelineContext.b();
            httpClient.g().a(f(), httpClientCall2.f());
            Object g8 = pipelineContext.g(httpClientCall2, continuation);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            if (g8 == d8) {
                return g8;
            }
            return Unit.f50853a;
        }

        public final EventDefinition<HttpResponse> f() {
            return HttpCache.f46421e;
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        /* renamed from: g */
        public void a(HttpCache plugin, HttpClient scope) {
            Intrinsics.f(plugin, "plugin");
            Intrinsics.f(scope, "scope");
            PipelinePhase pipelinePhase = new PipelinePhase("Cache");
            scope.m().j(HttpSendPipeline.f46641h.d(), pipelinePhase);
            scope.m().l(pipelinePhase, new HttpCache$Companion$install$1(plugin, scope, null));
            scope.h().l(HttpReceivePipeline.f46657h.b(), new HttpCache$Companion$install$2(plugin, scope, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<HttpCache> getKey() {
            return HttpCache.f46420d;
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        /* renamed from: h */
        public HttpCache b(Function1<? super Config, Unit> block) {
            Intrinsics.f(block, "block");
            Config config = new Config();
            block.invoke(config);
            return new HttpCache(config.b(), config.a(), null);
        }
    }

    /* compiled from: HttpCache.kt */
    /* loaded from: classes5.dex */
    public static final class Config {

        /* renamed from: a  reason: collision with root package name */
        private HttpCacheStorage f46434a;

        /* renamed from: b  reason: collision with root package name */
        private HttpCacheStorage f46435b;

        public Config() {
            HttpCacheStorage.Companion companion = HttpCacheStorage.f46456a;
            this.f46434a = companion.b().invoke();
            this.f46435b = companion.b().invoke();
        }

        public final HttpCacheStorage a() {
            return this.f46435b;
        }

        public final HttpCacheStorage b() {
            return this.f46434a;
        }

        public final void c(HttpCacheStorage httpCacheStorage) {
            Intrinsics.f(httpCacheStorage, "<set-?>");
            this.f46434a = httpCacheStorage;
        }
    }

    private HttpCache(HttpCacheStorage httpCacheStorage, HttpCacheStorage httpCacheStorage2) {
        this.f46422a = httpCacheStorage;
        this.f46423b = httpCacheStorage2;
    }

    public /* synthetic */ HttpCache(HttpCacheStorage httpCacheStorage, HttpCacheStorage httpCacheStorage2, DefaultConstructorMarker defaultConstructorMarker) {
        this(httpCacheStorage, httpCacheStorage2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(io.ktor.client.statement.HttpResponse r9, kotlin.coroutines.Continuation<? super io.ktor.client.statement.HttpResponse> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof io.ktor.client.plugins.cache.HttpCache$cacheResponse$1
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.client.plugins.cache.HttpCache$cacheResponse$1 r0 = (io.ktor.client.plugins.cache.HttpCache$cacheResponse$1) r0
            int r1 = r0.f46438h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f46438h = r1
            goto L18
        L13:
            io.ktor.client.plugins.cache.HttpCache$cacheResponse$1 r0 = new io.ktor.client.plugins.cache.HttpCache$cacheResponse$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f46436f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f46438h
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r10)
            goto L77
        L29:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L31:
            kotlin.ResultKt.b(r10)
            io.ktor.client.call.HttpClientCall r10 = r9.Y()
            io.ktor.client.request.HttpRequest r10 = r10.e()
            java.util.List r2 = io.ktor.http.HttpMessagePropertiesKt.a(r9)
            java.util.List r4 = io.ktor.http.HttpMessagePropertiesKt.a(r10)
            io.ktor.client.plugins.cache.CacheControl r5 = io.ktor.client.plugins.cache.CacheControl.f46413a
            io.ktor.http.HeaderValue r6 = r5.e()
            boolean r6 = r2.contains(r6)
            if (r6 == 0) goto L53
            io.ktor.client.plugins.cache.storage.HttpCacheStorage r6 = r8.f46423b
            goto L55
        L53:
            io.ktor.client.plugins.cache.storage.HttpCacheStorage r6 = r8.f46422a
        L55:
            io.ktor.http.HeaderValue r7 = r5.c()
            boolean r2 = r2.contains(r7)
            if (r2 != 0) goto L7d
            io.ktor.http.HeaderValue r2 = r5.c()
            boolean r2 = r4.contains(r2)
            if (r2 == 0) goto L6a
            goto L7d
        L6a:
            io.ktor.http.Url r10 = r10.getUrl()
            r0.f46438h = r3
            java.lang.Object r10 = io.ktor.client.plugins.cache.storage.HttpCacheStorageKt.a(r6, r10, r9, r0)
            if (r10 != r1) goto L77
            return r1
        L77:
            io.ktor.client.plugins.cache.HttpCacheEntry r10 = (io.ktor.client.plugins.cache.HttpCacheEntry) r10
            io.ktor.client.statement.HttpResponse r9 = r10.f()
        L7d:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCache.f(io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HttpResponse g(HttpRequest httpRequest, HttpResponse httpResponse) {
        HttpCacheStorage httpCacheStorage;
        Url url = httpResponse.Y().e().getUrl();
        if (HttpMessagePropertiesKt.a(httpResponse).contains(CacheControl.f46413a.e())) {
            httpCacheStorage = this.f46423b;
        } else {
            httpCacheStorage = this.f46422a;
        }
        Map<String, String> e8 = HttpCacheEntryKt.e(httpResponse);
        HttpCacheEntry h8 = h(httpCacheStorage, e8, url, httpRequest);
        if (h8 == null) {
            return null;
        }
        if (e8.isEmpty()) {
            e8 = h8.e();
        }
        httpCacheStorage.e(url, new HttpCacheEntry(HttpCacheEntryKt.c(httpResponse, null, 1, null), e8, h8.c(), h8.a()));
        return h8.f();
    }

    private final HttpCacheEntry h(HttpCacheStorage httpCacheStorage, Map<String, String> map, Url url, HttpRequest httpRequest) {
        Function1 d8;
        List v02;
        Object obj;
        boolean z7;
        if (!(!map.isEmpty())) {
            d8 = HttpCacheKt.d(httpRequest.getContent(), new HttpCache$findResponse$requestHeaders$1(httpRequest.getHeaders()), new HttpCache$findResponse$requestHeaders$2(httpRequest.getHeaders()));
            v02 = CollectionsKt___CollectionsKt.v0(httpCacheStorage.d(url), new Comparator() { // from class: io.ktor.client.plugins.cache.HttpCache$findResponse$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t7, T t8) {
                    int a8;
                    a8 = ComparisonsKt__ComparisonsKt.a(((HttpCacheEntry) t8).c().c(), ((HttpCacheEntry) t7).c().c());
                    return a8;
                }
            });
            Iterator it = v02.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    Map<String, String> e8 = ((HttpCacheEntry) obj).e();
                    if (!e8.isEmpty()) {
                        for (Map.Entry<String, String> entry : e8.entrySet()) {
                            if (!Intrinsics.a(d8.invoke(entry.getKey()), entry.getValue())) {
                                z7 = false;
                                continue;
                                break;
                            }
                        }
                    }
                    z7 = true;
                    continue;
                    if (z7) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            return (HttpCacheEntry) obj;
        }
        return httpCacheStorage.c(url, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007b, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final io.ktor.client.plugins.cache.HttpCacheEntry i(io.ktor.client.request.HttpRequestBuilder r6, io.ktor.http.content.OutgoingContent r7) {
        /*
            r5 = this;
            io.ktor.http.URLBuilder r0 = r6.h()
            io.ktor.http.Url r0 = io.ktor.http.URLUtilsKt.c(r0)
            io.ktor.client.plugins.cache.HttpCache$findResponse$lookup$1 r1 = new io.ktor.client.plugins.cache.HttpCache$findResponse$lookup$1
            io.ktor.http.HeadersBuilder r2 = r6.getHeaders()
            r1.<init>(r2)
            io.ktor.client.plugins.cache.HttpCache$findResponse$lookup$2 r2 = new io.ktor.client.plugins.cache.HttpCache$findResponse$lookup$2
            io.ktor.http.HeadersBuilder r6 = r6.getHeaders()
            r2.<init>(r6)
            kotlin.jvm.functions.Function1 r6 = io.ktor.client.plugins.cache.HttpCacheKt.b(r7, r1, r2)
            io.ktor.client.plugins.cache.storage.HttpCacheStorage r7 = r5.f46423b
            java.util.Set r7 = r7.d(r0)
            io.ktor.client.plugins.cache.storage.HttpCacheStorage r1 = r5.f46422a
            java.util.Set r0 = r1.d(r0)
            java.util.Set r7 = kotlin.collections.SetsKt.h(r7, r0)
            java.util.Iterator r7 = r7.iterator()
        L32:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L7e
            java.lang.Object r0 = r7.next()
            io.ktor.client.plugins.cache.HttpCacheEntry r0 = (io.ktor.client.plugins.cache.HttpCacheEntry) r0
            java.util.Map r1 = r0.e()
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L7d
            boolean r2 = r1.isEmpty()
            r3 = 1
            if (r2 == 0) goto L50
            goto L7b
        L50:
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L58:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L7b
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r4 = r2.getKey()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r4 = r6.invoke(r4)
            boolean r2 = kotlin.jvm.internal.Intrinsics.a(r4, r2)
            if (r2 != 0) goto L58
            r3 = 0
        L7b:
            if (r3 == 0) goto L32
        L7d:
            return r0
        L7e:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCache.i(io.ktor.client.request.HttpRequestBuilder, io.ktor.http.content.OutgoingContent):io.ktor.client.plugins.cache.HttpCacheEntry");
    }
}
