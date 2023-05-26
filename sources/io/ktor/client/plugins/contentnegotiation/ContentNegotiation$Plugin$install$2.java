package io.ktor.client.plugins.contentnegotiation;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.serialization.ContentConverterKt;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import java.nio.charset.Charset;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: ContentNegotiation.kt */
@DebugMetadata(c = "io.ktor.client.plugins.contentnegotiation.ContentNegotiation$Plugin$install$2", f = "ContentNegotiation.kt", l = {210, 212}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class ContentNegotiation$Plugin$install$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f46480g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f46481h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f46482i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ ContentNegotiation f46483j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentNegotiation$Plugin$install$2(ContentNegotiation contentNegotiation, Continuation<? super ContentNegotiation$Plugin$install$2> continuation) {
        super(3, continuation);
        this.f46483j = contentNegotiation;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
        ContentNegotiation$Plugin$install$2 contentNegotiation$Plugin$install$2 = new ContentNegotiation$Plugin$install$2(this.f46483j, continuation);
        contentNegotiation$Plugin$install$2.f46481h = pipelineContext;
        contentNegotiation$Plugin$install$2.f46482i = httpResponseContainer;
        return contentNegotiation$Plugin$install$2.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        PipelineContext pipelineContext;
        TypeInfo typeInfo;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f46480g;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 == 2) {
                    ResultKt.b(obj);
                    return Unit.f50853a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            typeInfo = (TypeInfo) this.f46482i;
            pipelineContext = (PipelineContext) this.f46481h;
            ResultKt.b(obj);
        } else {
            ResultKt.b(obj);
            PipelineContext pipelineContext2 = (PipelineContext) this.f46481h;
            HttpResponseContainer httpResponseContainer = (HttpResponseContainer) this.f46482i;
            TypeInfo a8 = httpResponseContainer.a();
            Object b8 = httpResponseContainer.b();
            ContentType d9 = HttpMessagePropertiesKt.d(((HttpClientCall) pipelineContext2.c()).f());
            if (d9 == null) {
                return Unit.f50853a;
            }
            Charset c8 = ContentConverterKt.c(((HttpClientCall) pipelineContext2.c()).e().getHeaders(), null, 1, null);
            ContentNegotiation contentNegotiation = this.f46483j;
            this.f46481h = pipelineContext2;
            this.f46482i = a8;
            this.f46480g = 1;
            Object c9 = contentNegotiation.c(a8, b8, d9, c8, this);
            if (c9 == d8) {
                return d8;
            }
            pipelineContext = pipelineContext2;
            obj = c9;
            typeInfo = a8;
        }
        if (obj == null) {
            return Unit.f50853a;
        }
        HttpResponseContainer httpResponseContainer2 = new HttpResponseContainer(typeInfo, obj);
        this.f46481h = null;
        this.f46482i = null;
        this.f46480g = 2;
        if (pipelineContext.g(httpResponseContainer2, this) == d8) {
            return d8;
        }
        return Unit.f50853a;
    }
}
