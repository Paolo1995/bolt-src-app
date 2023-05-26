package io.ktor.client.plugins.contentnegotiation;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: ContentNegotiation.kt */
@DebugMetadata(c = "io.ktor.client.plugins.contentnegotiation.ContentNegotiation$Plugin$install$1", f = "ContentNegotiation.kt", l = {202, 203}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class ContentNegotiation$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f46477g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f46478h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ContentNegotiation f46479i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentNegotiation$Plugin$install$1(ContentNegotiation contentNegotiation, Continuation<? super ContentNegotiation$Plugin$install$1> continuation) {
        super(3, continuation);
        this.f46479i = contentNegotiation;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        ContentNegotiation$Plugin$install$1 contentNegotiation$Plugin$install$1 = new ContentNegotiation$Plugin$install$1(this.f46479i, continuation);
        contentNegotiation$Plugin$install$1.f46478h = pipelineContext;
        return contentNegotiation$Plugin$install$1.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        PipelineContext pipelineContext;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f46477g;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 == 2) {
                    ResultKt.b(obj);
                    return Unit.f50853a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            pipelineContext = (PipelineContext) this.f46478h;
            ResultKt.b(obj);
        } else {
            ResultKt.b(obj);
            pipelineContext = (PipelineContext) this.f46478h;
            Object e8 = pipelineContext.e();
            this.f46478h = pipelineContext;
            this.f46477g = 1;
            obj = this.f46479i.b((HttpRequestBuilder) pipelineContext.c(), e8, this);
            if (obj == d8) {
                return d8;
            }
        }
        if (obj == null) {
            return Unit.f50853a;
        }
        this.f46478h = null;
        this.f46477g = 2;
        if (pipelineContext.g(obj, this) == d8) {
            return d8;
        }
        return Unit.f50853a;
    }
}
