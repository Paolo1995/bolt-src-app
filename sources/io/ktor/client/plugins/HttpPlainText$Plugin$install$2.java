package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.core.ByteReadPacket;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpPlainText.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpPlainText$Plugin$install$2", f = "HttpPlainText.kt", l = {133, 135}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class HttpPlainText$Plugin$install$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f46334g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f46335h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f46336i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ HttpPlainText f46337j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpPlainText$Plugin$install$2(HttpPlainText httpPlainText, Continuation<? super HttpPlainText$Plugin$install$2> continuation) {
        super(3, continuation);
        this.f46337j = httpPlainText;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
        HttpPlainText$Plugin$install$2 httpPlainText$Plugin$install$2 = new HttpPlainText$Plugin$install$2(this.f46337j, continuation);
        httpPlainText$Plugin$install$2.f46335h = pipelineContext;
        httpPlainText$Plugin$install$2.f46336i = httpResponseContainer;
        return httpPlainText$Plugin$install$2.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        PipelineContext pipelineContext;
        TypeInfo typeInfo;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f46334g;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 == 2) {
                    ResultKt.b(obj);
                    return Unit.f50853a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            typeInfo = (TypeInfo) this.f46336i;
            pipelineContext = (PipelineContext) this.f46335h;
            ResultKt.b(obj);
        } else {
            ResultKt.b(obj);
            PipelineContext pipelineContext2 = (PipelineContext) this.f46335h;
            HttpResponseContainer httpResponseContainer = (HttpResponseContainer) this.f46336i;
            TypeInfo a8 = httpResponseContainer.a();
            Object b8 = httpResponseContainer.b();
            if (Intrinsics.a(a8.b(), Reflection.b(String.class)) && (b8 instanceof ByteReadChannel)) {
                this.f46335h = pipelineContext2;
                this.f46336i = a8;
                this.f46334g = 1;
                Object a9 = ByteReadChannel.DefaultImpls.a((ByteReadChannel) b8, 0L, this, 1, null);
                if (a9 == d8) {
                    return d8;
                }
                pipelineContext = pipelineContext2;
                obj = a9;
                typeInfo = a8;
            } else {
                return Unit.f50853a;
            }
        }
        HttpResponseContainer httpResponseContainer2 = new HttpResponseContainer(typeInfo, this.f46337j.d((HttpClientCall) pipelineContext.c(), (ByteReadPacket) obj));
        this.f46335h = null;
        this.f46336i = null;
        this.f46334g = 2;
        if (pipelineContext.g(httpResponseContainer2, this) == d8) {
            return d8;
        }
        return Unit.f50853a;
    }
}
