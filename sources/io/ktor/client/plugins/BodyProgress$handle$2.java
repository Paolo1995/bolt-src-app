package io.ktor.client.plugins;

import io.ktor.client.statement.HttpResponse;
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
@DebugMetadata(c = "io.ktor.client.plugins.BodyProgress$handle$2", f = "BodyProgress.kt", l = {45}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class BodyProgress$handle$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponse, Unit>, HttpResponse, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f46235g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f46236h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f46237i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BodyProgress$handle$2(Continuation<? super BodyProgress$handle$2> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(PipelineContext<HttpResponse, Unit> pipelineContext, HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        BodyProgress$handle$2 bodyProgress$handle$2 = new BodyProgress$handle$2(continuation);
        bodyProgress$handle$2.f46236h = pipelineContext;
        bodyProgress$handle$2.f46237i = httpResponse;
        return bodyProgress$handle$2.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        AttributeKey attributeKey;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f46235g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            PipelineContext pipelineContext = (PipelineContext) this.f46236h;
            HttpResponse httpResponse = (HttpResponse) this.f46237i;
            Attributes attributes = httpResponse.Y().e().getAttributes();
            attributeKey = BodyProgressKt.f46239b;
            Function3 function3 = (Function3) attributes.f(attributeKey);
            if (function3 == null) {
                return Unit.f50853a;
            }
            HttpResponse c8 = BodyProgressKt.c(httpResponse, function3);
            this.f46236h = null;
            this.f46235g = 1;
            if (pipelineContext.g(c8, this) == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
