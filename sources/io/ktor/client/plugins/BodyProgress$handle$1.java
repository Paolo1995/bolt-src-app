package io.ktor.client.plugins;

import io.ktor.client.content.ObservableContent;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BodyProgress.kt */
@DebugMetadata(c = "io.ktor.client.plugins.BodyProgress$handle$1", f = "BodyProgress.kt", l = {38}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class BodyProgress$handle$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f46232g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f46233h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f46234i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BodyProgress$handle$1(Continuation<? super BodyProgress$handle$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        BodyProgress$handle$1 bodyProgress$handle$1 = new BodyProgress$handle$1(continuation);
        bodyProgress$handle$1.f46233h = pipelineContext;
        bodyProgress$handle$1.f46234i = obj;
        return bodyProgress$handle$1.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        AttributeKey attributeKey;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f46232g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            PipelineContext pipelineContext = (PipelineContext) this.f46233h;
            Object obj2 = this.f46234i;
            Attributes b8 = ((HttpRequestBuilder) pipelineContext.c()).b();
            attributeKey = BodyProgressKt.f46238a;
            Function3 function3 = (Function3) b8.f(attributeKey);
            if (function3 == null) {
                return Unit.f50853a;
            }
            ObservableContent observableContent = new ObservableContent((OutgoingContent) obj2, ((HttpRequestBuilder) pipelineContext.c()).f(), function3);
            this.f46233h = null;
            this.f46232g = 1;
            if (pipelineContext.g(observableContent, this) == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
