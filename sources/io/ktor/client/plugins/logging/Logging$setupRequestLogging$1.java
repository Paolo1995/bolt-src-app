package io.ktor.client.plugins.logging;

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
/* compiled from: Logging.kt */
@DebugMetadata(c = "io.ktor.client.plugins.logging.Logging$setupRequestLogging$1", f = "Logging.kt", l = {68, 74}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class Logging$setupRequestLogging$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f46550g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f46551h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ Logging f46552i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Logging$setupRequestLogging$1(Logging logging, Continuation<? super Logging$setupRequestLogging$1> continuation) {
        super(3, continuation);
        this.f46552i = logging;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        Logging$setupRequestLogging$1 logging$setupRequestLogging$1 = new Logging$setupRequestLogging$1(this.f46552i, continuation);
        logging$setupRequestLogging$1.f46551h = pipelineContext;
        return logging$setupRequestLogging$1.invokeSuspend(Unit.f50853a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2, types: [io.ktor.util.pipeline.PipelineContext, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v5, types: [io.ktor.util.pipeline.PipelineContext, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v9, types: [io.ktor.util.pipeline.PipelineContext] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        Object obj2;
        ?? r12;
        PipelineContext pipelineContext;
        boolean o8;
        AttributeKey attributeKey;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f46550g;
        try {
        } catch (Throwable unused) {
            obj2 = null;
            r12 = i8;
        }
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 == 2) {
                    pipelineContext = (PipelineContext) this.f46551h;
                    try {
                        ResultKt.b(obj);
                        return Unit.f50853a;
                    } catch (Throwable th) {
                        th = th;
                        this.f46552i.k((HttpRequestBuilder) pipelineContext.c(), th);
                        throw th;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ?? r13 = (PipelineContext) this.f46551h;
            ResultKt.b(obj);
            i8 = r13;
        } else {
            ResultKt.b(obj);
            ?? r14 = (PipelineContext) this.f46551h;
            o8 = this.f46552i.o((HttpRequestBuilder) r14.c());
            if (!o8) {
                Attributes b8 = ((HttpRequestBuilder) r14.c()).b();
                attributeKey = LoggingKt.f46568b;
                Unit unit = Unit.f50853a;
                b8.b(attributeKey, unit);
                return unit;
            }
            this.f46551h = r14;
            this.f46550g = 1;
            obj = this.f46552i.i((HttpRequestBuilder) r14.c(), this);
            i8 = r14;
            if (obj == d8) {
                return d8;
            }
        }
        obj2 = (OutgoingContent) obj;
        r12 = i8;
        if (obj2 == null) {
            try {
                obj2 = r12.e();
            } catch (Throwable th2) {
                th = th2;
                pipelineContext = r12;
                this.f46552i.k((HttpRequestBuilder) pipelineContext.c(), th);
                throw th;
            }
        }
        this.f46551h = r12;
        this.f46550g = 2;
        if (r12.g(obj2, this) == d8) {
            return d8;
        }
        return Unit.f50853a;
    }
}
