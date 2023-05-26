package io.ktor.client.engine;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.utils.ClientEventsKt;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfoJvmKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpClientEngine.kt */
@DebugMetadata(c = "io.ktor.client.engine.HttpClientEngine$install$1", f = "HttpClientEngine.kt", l = {70, 82}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class HttpClientEngine$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f46116g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f46117h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f46118i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ HttpClient f46119j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ HttpClientEngine f46120k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpClientEngine$install$1(HttpClient httpClient, HttpClientEngine httpClientEngine, Continuation<? super HttpClientEngine$install$1> continuation) {
        super(3, continuation);
        this.f46119j = httpClient;
        this.f46120k = httpClientEngine;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        HttpClientEngine$install$1 httpClientEngine$install$1 = new HttpClientEngine$install$1(this.f46119j, this.f46120k, continuation);
        httpClientEngine$install$1.f46117h = pipelineContext;
        httpClientEngine$install$1.f46118i = obj;
        return httpClientEngine$install$1.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        PipelineContext pipelineContext;
        HttpRequestData a8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f46116g;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 == 2) {
                    ResultKt.b(obj);
                    return Unit.f50853a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a8 = (HttpRequestData) this.f46118i;
            pipelineContext = (PipelineContext) this.f46117h;
            ResultKt.b(obj);
        } else {
            ResultKt.b(obj);
            pipelineContext = (PipelineContext) this.f46117h;
            Object obj2 = this.f46118i;
            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
            httpRequestBuilder.o((HttpRequestBuilder) pipelineContext.c());
            if (obj2 == null) {
                httpRequestBuilder.i(NullBody.f46943a);
                KType i9 = Reflection.i(Object.class);
                httpRequestBuilder.j(TypeInfoJvmKt.b(TypesJVMKt.f(i9), Reflection.b(Object.class), i9));
            } else if (obj2 instanceof OutgoingContent) {
                httpRequestBuilder.i(obj2);
                httpRequestBuilder.j(null);
            } else {
                httpRequestBuilder.i(obj2);
                KType i10 = Reflection.i(Object.class);
                httpRequestBuilder.j(TypeInfoJvmKt.b(TypesJVMKt.f(i10), Reflection.b(Object.class), i10));
            }
            this.f46119j.g().a(ClientEventsKt.b(), httpRequestBuilder);
            a8 = httpRequestBuilder.a();
            a8.a().b(HttpClientEngineKt.c(), this.f46119j.c());
            HttpClientEngineKt.d(a8);
            HttpClientEngine.DefaultImpls.d(this.f46120k, a8);
            HttpClientEngine httpClientEngine = this.f46120k;
            this.f46117h = pipelineContext;
            this.f46118i = a8;
            this.f46116g = 1;
            obj = HttpClientEngine.DefaultImpls.e(httpClientEngine, a8, this);
            if (obj == d8) {
                return d8;
            }
        }
        HttpClientCall httpClientCall = new HttpClientCall(this.f46119j, a8, (HttpResponseData) obj);
        final HttpResponse f8 = httpClientCall.f();
        this.f46119j.g().a(ClientEventsKt.e(), f8);
        Job k8 = JobKt.k(f8.j());
        final HttpClient httpClient = this.f46119j;
        k8.X(new Function1<Throwable, Unit>() { // from class: io.ktor.client.engine.HttpClientEngine$install$1.1
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
                if (th != null) {
                    HttpClient.this.g().a(ClientEventsKt.c(), f8);
                }
            }
        });
        this.f46117h = null;
        this.f46118i = null;
        this.f46116g = 2;
        if (pipelineContext.g(httpClientCall, this) == d8) {
            return d8;
        }
        return Unit.f50853a;
    }
}
