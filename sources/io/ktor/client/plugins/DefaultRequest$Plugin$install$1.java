package io.ktor.client.plugins;

import io.ktor.client.plugins.DefaultRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.AttributeKey;
import io.ktor.util.StringValuesKt;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultRequest.kt */
@DebugMetadata(c = "io.ktor.client.plugins.DefaultRequest$Plugin$install$1", f = "DefaultRequest.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class DefaultRequest$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f46247g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f46248h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ DefaultRequest f46249i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultRequest$Plugin$install$1(DefaultRequest defaultRequest, Continuation<? super DefaultRequest$Plugin$install$1> continuation) {
        super(3, continuation);
        this.f46249i = defaultRequest;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        DefaultRequest$Plugin$install$1 defaultRequest$Plugin$install$1 = new DefaultRequest$Plugin$install$1(this.f46249i, continuation);
        defaultRequest$Plugin$install$1.f46248h = pipelineContext;
        return defaultRequest$Plugin$install$1.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Function1 function1;
        IntrinsicsKt__IntrinsicsKt.d();
        if (this.f46247g == 0) {
            ResultKt.b(obj);
            PipelineContext pipelineContext = (PipelineContext) this.f46248h;
            DefaultRequest.DefaultRequestBuilder defaultRequestBuilder = new DefaultRequest.DefaultRequestBuilder();
            DefaultRequest defaultRequest = this.f46249i;
            StringValuesKt.c(defaultRequestBuilder.getHeaders(), ((HttpRequestBuilder) pipelineContext.c()).getHeaders());
            function1 = defaultRequest.f46243a;
            function1.invoke(defaultRequestBuilder);
            DefaultRequest.f46241b.f(defaultRequestBuilder.b().b(), ((HttpRequestBuilder) pipelineContext.c()).h());
            for (AttributeKey<?> attributeKey : defaultRequestBuilder.a().c()) {
                if (!((HttpRequestBuilder) pipelineContext.c()).b().e(attributeKey)) {
                    ((HttpRequestBuilder) pipelineContext.c()).b().b(attributeKey, defaultRequestBuilder.a().a(attributeKey));
                }
            }
            ((HttpRequestBuilder) pipelineContext.c()).getHeaders().g(defaultRequestBuilder.getHeaders().p());
            return Unit.f50853a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
