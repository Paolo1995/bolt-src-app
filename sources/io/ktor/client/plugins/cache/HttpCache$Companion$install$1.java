package io.ktor.client.plugins.cache;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.cache.HttpCache;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.UtilsKt;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMethod;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpCache.kt */
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache$Companion$install$1", f = "HttpCache.kt", l = {89, 97, 102}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class HttpCache$Companion$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f46424g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f46425h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f46426i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ HttpCache f46427j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ HttpClient f46428k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCache$Companion$install$1(HttpCache httpCache, HttpClient httpClient, Continuation<? super HttpCache$Companion$install$1> continuation) {
        super(3, continuation);
        this.f46427j = httpCache;
        this.f46428k = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        HttpCache$Companion$install$1 httpCache$Companion$install$1 = new HttpCache$Companion$install$1(this.f46427j, this.f46428k, continuation);
        httpCache$Companion$install$1.f46425h = pipelineContext;
        httpCache$Companion$install$1.f46426i = obj;
        return httpCache$Companion$install$1.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        boolean c8;
        HttpCacheEntry i8;
        Object k8;
        Object i9;
        Object j8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i10 = this.f46424g;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        ResultKt.b(obj);
                        return Unit.f50853a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Unit.f50853a;
            }
            ResultKt.b(obj);
            return Unit.f50853a;
        }
        ResultKt.b(obj);
        PipelineContext pipelineContext = (PipelineContext) this.f46425h;
        Object obj2 = this.f46426i;
        if (!(obj2 instanceof OutgoingContent.NoContent)) {
            return Unit.f50853a;
        }
        if (Intrinsics.a(((HttpRequestBuilder) pipelineContext.c()).g(), HttpMethod.f46834b.a())) {
            c8 = HttpCacheKt.c(((HttpRequestBuilder) pipelineContext.c()).h().o());
            if (c8) {
                i8 = this.f46427j.i((HttpRequestBuilder) pipelineContext.c(), (OutgoingContent) obj2);
                if (i8 == null) {
                    if (HttpHeaderValueParserKt.c(((HttpRequestBuilder) pipelineContext.c()).getHeaders().j(HttpHeaders.f46782a.f())).contains(CacheControl.f46413a.d())) {
                        HttpCache.Companion companion = HttpCache.f46419c;
                        HttpClient httpClient = this.f46428k;
                        this.f46425h = null;
                        this.f46424g = 1;
                        j8 = companion.j(pipelineContext, httpClient, this);
                        if (j8 == d8) {
                            return d8;
                        }
                    }
                    return Unit.f50853a;
                }
                HttpClientCall Y = i8.f().Y();
                ValidateStatus d9 = HttpCacheEntryKt.d(i8.b(), i8.c().getHeaders(), ((HttpRequestBuilder) pipelineContext.c()).getHeaders());
                if (d9 == ValidateStatus.ShouldNotValidate) {
                    HttpCache.Companion companion2 = HttpCache.f46419c;
                    HttpClient httpClient2 = this.f46428k;
                    this.f46425h = null;
                    this.f46424g = 2;
                    i9 = companion2.i(pipelineContext, httpClient2, Y, this);
                    if (i9 == d8) {
                        return d8;
                    }
                    return Unit.f50853a;
                } else if (d9 == ValidateStatus.ShouldWarn) {
                    HttpCache.Companion companion3 = HttpCache.f46419c;
                    HttpClient httpClient3 = this.f46428k;
                    this.f46425h = null;
                    this.f46424g = 3;
                    k8 = companion3.k(pipelineContext, Y, httpClient3, this);
                    if (k8 == d8) {
                        return d8;
                    }
                    return Unit.f50853a;
                } else {
                    Headers d10 = i8.d();
                    HttpHeaders httpHeaders = HttpHeaders.f46782a;
                    String str = d10.get(httpHeaders.k());
                    if (str != null) {
                        UtilsKt.d((HttpMessageBuilder) pipelineContext.c(), httpHeaders.n(), str);
                    }
                    String str2 = i8.d().get(httpHeaders.p());
                    if (str2 != null) {
                        UtilsKt.d((HttpMessageBuilder) pipelineContext.c(), httpHeaders.m(), str2);
                    }
                    return Unit.f50853a;
                }
            }
        }
        return Unit.f50853a;
    }
}
