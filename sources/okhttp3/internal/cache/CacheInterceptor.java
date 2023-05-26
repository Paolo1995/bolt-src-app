package okhttp3.internal.cache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* compiled from: CacheInterceptor.kt */
/* loaded from: classes5.dex */
public final class CacheInterceptor implements Interceptor {
    public static final Companion Companion = new Companion(null);
    private final Cache cache;

    /* compiled from: CacheInterceptor.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Headers combine(Headers headers, Headers headers2) {
            boolean w7;
            boolean L;
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            int i8 = 0;
            int i9 = 0;
            while (i9 < size) {
                int i10 = i9 + 1;
                String name = headers.name(i9);
                String value = headers.value(i9);
                w7 = StringsKt__StringsJVMKt.w("Warning", name, true);
                if (w7) {
                    L = StringsKt__StringsJVMKt.L(value, "1", false, 2, null);
                    if (L) {
                        i9 = i10;
                    }
                }
                if (isContentSpecificHeader(name) || !isEndToEnd(name) || headers2.get(name) == null) {
                    builder.addLenient$okhttp(name, value);
                }
                i9 = i10;
            }
            int size2 = headers2.size();
            while (i8 < size2) {
                int i11 = i8 + 1;
                String name2 = headers2.name(i8);
                if (!isContentSpecificHeader(name2) && isEndToEnd(name2)) {
                    builder.addLenient$okhttp(name2, headers2.value(i8));
                }
                i8 = i11;
            }
            return builder.build();
        }

        private final boolean isContentSpecificHeader(String str) {
            boolean w7;
            boolean w8;
            boolean w9;
            w7 = StringsKt__StringsJVMKt.w("Content-Length", str, true);
            if (w7) {
                return true;
            }
            w8 = StringsKt__StringsJVMKt.w("Content-Encoding", str, true);
            if (w8) {
                return true;
            }
            w9 = StringsKt__StringsJVMKt.w("Content-Type", str, true);
            if (w9) {
                return true;
            }
            return false;
        }

        private final boolean isEndToEnd(String str) {
            boolean w7;
            boolean w8;
            boolean w9;
            boolean w10;
            boolean w11;
            boolean w12;
            boolean w13;
            boolean w14;
            w7 = StringsKt__StringsJVMKt.w("Connection", str, true);
            if (!w7) {
                w8 = StringsKt__StringsJVMKt.w("Keep-Alive", str, true);
                if (!w8) {
                    w9 = StringsKt__StringsJVMKt.w("Proxy-Authenticate", str, true);
                    if (!w9) {
                        w10 = StringsKt__StringsJVMKt.w("Proxy-Authorization", str, true);
                        if (!w10) {
                            w11 = StringsKt__StringsJVMKt.w("TE", str, true);
                            if (!w11) {
                                w12 = StringsKt__StringsJVMKt.w("Trailers", str, true);
                                if (!w12) {
                                    w13 = StringsKt__StringsJVMKt.w("Transfer-Encoding", str, true);
                                    if (!w13) {
                                        w14 = StringsKt__StringsJVMKt.w("Upgrade", str, true);
                                        if (!w14) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Response stripBody(Response response) {
            ResponseBody body;
            if (response == null) {
                body = null;
            } else {
                body = response.body();
            }
            if (body != null) {
                return response.newBuilder().body(null).build();
            }
            return response;
        }
    }

    public CacheInterceptor(Cache cache) {
        this.cache = cache;
    }

    private final Response cacheWritingResponse(final CacheRequest cacheRequest, Response response) throws IOException {
        if (cacheRequest == null) {
            return response;
        }
        Sink body = cacheRequest.body();
        ResponseBody body2 = response.body();
        Intrinsics.c(body2);
        final BufferedSource source = body2.source();
        final BufferedSink c8 = Okio.c(body);
        Source source2 = new Source() { // from class: okhttp3.internal.cache.CacheInterceptor$cacheWritingResponse$cacheWritingSource$1
            private boolean cacheRequestClosed;

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                }
                BufferedSource.this.close();
            }

            @Override // okio.Source
            public long read(Buffer sink, long j8) throws IOException {
                Intrinsics.f(sink, "sink");
                try {
                    long read = BufferedSource.this.read(sink, j8);
                    if (read == -1) {
                        if (!this.cacheRequestClosed) {
                            this.cacheRequestClosed = true;
                            c8.close();
                        }
                        return -1L;
                    }
                    sink.j(c8.b(), sink.size() - read, read);
                    c8.H();
                    return read;
                } catch (IOException e8) {
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        cacheRequest.abort();
                    }
                    throw e8;
                }
            }

            @Override // okio.Source
            public Timeout timeout() {
                return BufferedSource.this.timeout();
            }
        };
        return response.newBuilder().body(new RealResponseBody(Response.header$default(response, "Content-Type", null, 2, null), response.body().contentLength(), Okio.d(source2))).build();
    }

    public final Cache getCache$okhttp() {
        return this.cache;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response response;
        RealCall realCall;
        ResponseBody body;
        ResponseBody body2;
        Intrinsics.f(chain, "chain");
        Call call = chain.call();
        Cache cache = this.cache;
        EventListener eventListener = null;
        if (cache == null) {
            response = null;
        } else {
            response = cache.get$okhttp(chain.request());
        }
        CacheStrategy compute = new CacheStrategy.Factory(System.currentTimeMillis(), chain.request(), response).compute();
        Request networkRequest = compute.getNetworkRequest();
        Response cacheResponse = compute.getCacheResponse();
        Cache cache2 = this.cache;
        if (cache2 != null) {
            cache2.trackResponse$okhttp(compute);
        }
        if (call instanceof RealCall) {
            realCall = (RealCall) call;
        } else {
            realCall = null;
        }
        if (realCall != null) {
            eventListener = realCall.getEventListener$okhttp();
        }
        if (eventListener == null) {
            eventListener = EventListener.NONE;
        }
        if (response != null && cacheResponse == null && (body2 = response.body()) != null) {
            Util.closeQuietly(body2);
        }
        if (networkRequest == null && cacheResponse == null) {
            Response build = new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(System.currentTimeMillis()).build();
            eventListener.satisfactionFailure(call, build);
            return build;
        } else if (networkRequest == null) {
            Intrinsics.c(cacheResponse);
            Response build2 = cacheResponse.newBuilder().cacheResponse(Companion.stripBody(cacheResponse)).build();
            eventListener.cacheHit(call, build2);
            return build2;
        } else {
            if (cacheResponse != null) {
                eventListener.cacheConditionalHit(call, cacheResponse);
            } else if (this.cache != null) {
                eventListener.cacheMiss(call);
            }
            try {
                Response proceed = chain.proceed(networkRequest);
                if (proceed == null && response != null && body != null) {
                }
                if (cacheResponse != null) {
                    boolean z7 = false;
                    if (proceed != null && proceed.code() == 304) {
                        z7 = true;
                    }
                    if (z7) {
                        Response.Builder newBuilder = cacheResponse.newBuilder();
                        Companion companion = Companion;
                        Response build3 = newBuilder.headers(companion.combine(cacheResponse.headers(), proceed.headers())).sentRequestAtMillis(proceed.sentRequestAtMillis()).receivedResponseAtMillis(proceed.receivedResponseAtMillis()).cacheResponse(companion.stripBody(cacheResponse)).networkResponse(companion.stripBody(proceed)).build();
                        ResponseBody body3 = proceed.body();
                        Intrinsics.c(body3);
                        body3.close();
                        Cache cache3 = this.cache;
                        Intrinsics.c(cache3);
                        cache3.trackConditionalCacheHit$okhttp();
                        this.cache.update$okhttp(cacheResponse, build3);
                        eventListener.cacheHit(call, build3);
                        return build3;
                    }
                    ResponseBody body4 = cacheResponse.body();
                    if (body4 != null) {
                        Util.closeQuietly(body4);
                    }
                }
                Intrinsics.c(proceed);
                Response.Builder newBuilder2 = proceed.newBuilder();
                Companion companion2 = Companion;
                Response build4 = newBuilder2.cacheResponse(companion2.stripBody(cacheResponse)).networkResponse(companion2.stripBody(proceed)).build();
                if (this.cache != null) {
                    if (HttpHeaders.promisesBody(build4) && CacheStrategy.Companion.isCacheable(build4, networkRequest)) {
                        Response cacheWritingResponse = cacheWritingResponse(this.cache.put$okhttp(build4), build4);
                        if (cacheResponse != null) {
                            eventListener.cacheMiss(call);
                        }
                        return cacheWritingResponse;
                    } else if (HttpMethod.INSTANCE.invalidatesCache(networkRequest.method())) {
                        try {
                            this.cache.remove$okhttp(networkRequest);
                        } catch (IOException unused) {
                        }
                    }
                }
                return build4;
            } finally {
                if (response != null && (body = response.body()) != null) {
                    Util.closeQuietly(body);
                }
            }
        }
    }
}
