package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
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
/* compiled from: HttpPlainText.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpPlainText$Plugin$install$1", f = "HttpPlainText.kt", l = {127}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class HttpPlainText$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f46330g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f46331h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f46332i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ HttpPlainText f46333j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpPlainText$Plugin$install$1(HttpPlainText httpPlainText, Continuation<? super HttpPlainText$Plugin$install$1> continuation) {
        super(3, continuation);
        this.f46333j = httpPlainText;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        HttpPlainText$Plugin$install$1 httpPlainText$Plugin$install$1 = new HttpPlainText$Plugin$install$1(this.f46333j, continuation);
        httpPlainText$Plugin$install$1.f46331h = pipelineContext;
        httpPlainText$Plugin$install$1.f46332i = obj;
        return httpPlainText$Plugin$install$1.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        Object e8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f46330g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            PipelineContext pipelineContext = (PipelineContext) this.f46331h;
            Object obj2 = this.f46332i;
            this.f46333j.c((HttpRequestBuilder) pipelineContext.c());
            if (!(obj2 instanceof String)) {
                return Unit.f50853a;
            }
            ContentType e9 = HttpMessagePropertiesKt.e((HttpMessageBuilder) pipelineContext.c());
            if (e9 == null || Intrinsics.a(e9.f(), ContentType.Text.f46754a.a().f())) {
                e8 = this.f46333j.e((String) obj2, e9);
                this.f46331h = null;
                this.f46330g = 1;
                if (pipelineContext.g(e8, this) == d8) {
                    return d8;
                }
            } else {
                return Unit.f50853a;
            }
        }
        return Unit.f50853a;
    }
}
