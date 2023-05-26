package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.request.ClientUpgradeContent;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.URLProtocolKt;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpTimeout.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpTimeout$Plugin$install$1", f = "HttpTimeout.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class HttpTimeout$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f46400g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f46401h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ HttpTimeout f46402i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ HttpClient f46403j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpTimeout$Plugin$install$1(HttpTimeout httpTimeout, HttpClient httpClient, Continuation<? super HttpTimeout$Plugin$install$1> continuation) {
        super(3, continuation);
        this.f46402i = httpTimeout;
        this.f46403j = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        HttpTimeout$Plugin$install$1 httpTimeout$Plugin$install$1 = new HttpTimeout$Plugin$install$1(this.f46402i, this.f46403j, continuation);
        httpTimeout$Plugin$install$1.f46401h = pipelineContext;
        return httpTimeout$Plugin$install$1.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final Job d8;
        boolean f8;
        IntrinsicsKt__IntrinsicsKt.d();
        if (this.f46400g == 0) {
            ResultKt.b(obj);
            PipelineContext pipelineContext = (PipelineContext) this.f46401h;
            if (!URLProtocolKt.b(((HttpRequestBuilder) pipelineContext.c()).h().o()) && !(((HttpRequestBuilder) pipelineContext.c()).c() instanceof ClientUpgradeContent)) {
                HttpTimeout.Plugin plugin = HttpTimeout.f46390d;
                HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration = (HttpTimeout.HttpTimeoutCapabilityConfiguration) ((HttpRequestBuilder) pipelineContext.c()).e(plugin);
                if (httpTimeoutCapabilityConfiguration == null) {
                    f8 = this.f46402i.f();
                    if (f8) {
                        httpTimeoutCapabilityConfiguration = new HttpTimeout.HttpTimeoutCapabilityConfiguration(null, null, null, 7, null);
                        ((HttpRequestBuilder) pipelineContext.c()).k(plugin, httpTimeoutCapabilityConfiguration);
                    }
                }
                if (httpTimeoutCapabilityConfiguration != null) {
                    HttpTimeout httpTimeout = this.f46402i;
                    HttpClient httpClient = this.f46403j;
                    HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) pipelineContext.c();
                    Long c8 = httpTimeoutCapabilityConfiguration.c();
                    if (c8 == null) {
                        c8 = httpTimeout.f46393b;
                    }
                    httpTimeoutCapabilityConfiguration.f(c8);
                    Long e8 = httpTimeoutCapabilityConfiguration.e();
                    if (e8 == null) {
                        e8 = httpTimeout.f46394c;
                    }
                    httpTimeoutCapabilityConfiguration.h(e8);
                    Long d9 = httpTimeoutCapabilityConfiguration.d();
                    if (d9 == null) {
                        d9 = httpTimeout.f46392a;
                    }
                    httpTimeoutCapabilityConfiguration.g(d9);
                    Long d10 = httpTimeoutCapabilityConfiguration.d();
                    if (d10 == null) {
                        d10 = httpTimeout.f46392a;
                    }
                    if (d10 != null && d10.longValue() != Long.MAX_VALUE) {
                        d8 = BuildersKt__Builders_commonKt.d(httpClient, null, null, new HttpTimeout$Plugin$install$1$1$killer$1(d10, httpRequestBuilder, httpRequestBuilder.f(), null), 3, null);
                        httpRequestBuilder.f().X(new Function1<Throwable, Unit>() { // from class: io.ktor.client.plugins.HttpTimeout$Plugin$install$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
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
                                Job.DefaultImpls.a(Job.this, null, 1, null);
                            }
                        });
                    }
                }
                return Unit.f50853a;
            }
            return Unit.f50853a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
