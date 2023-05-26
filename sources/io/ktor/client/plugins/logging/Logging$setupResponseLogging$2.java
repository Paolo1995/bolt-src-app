package io.ktor.client.plugins.logging;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponseContainer;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Logging.kt */
@DebugMetadata(c = "io.ktor.client.plugins.logging.Logging$setupResponseLogging$2", f = "Logging.kt", l = {175, 180, 181}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class Logging$setupResponseLogging$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    Object f46559g;

    /* renamed from: h  reason: collision with root package name */
    int f46560h;

    /* renamed from: i  reason: collision with root package name */
    private /* synthetic */ Object f46561i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ Logging f46562j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Logging$setupResponseLogging$2(Logging logging, Continuation<? super Logging$setupResponseLogging$2> continuation) {
        super(3, continuation);
        this.f46562j = logging;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
        Logging$setupResponseLogging$2 logging$setupResponseLogging$2 = new Logging$setupResponseLogging$2(this.f46562j, continuation);
        logging$setupResponseLogging$2.f46561i = pipelineContext;
        return logging$setupResponseLogging$2.invokeSuspend(Unit.f50853a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [io.ktor.util.pipeline.PipelineContext] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        AttributeKey attributeKey;
        HttpClientCallLogger httpClientCallLogger;
        AttributeKey<?> attributeKey2;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        ?? r12 = this.f46560h;
        try {
        } catch (Throwable th) {
            th = th;
            StringBuilder sb = new StringBuilder();
            Attributes attributes = ((HttpClientCall) r12.c()).getAttributes();
            attributeKey = LoggingKt.f46567a;
            HttpClientCallLogger httpClientCallLogger2 = (HttpClientCallLogger) attributes.a(attributeKey);
            this.f46562j.l(sb, ((HttpClientCall) r12.c()).e(), th);
            String sb2 = sb.toString();
            Intrinsics.e(sb2, "log.toString()");
            this.f46561i = th;
            this.f46559g = httpClientCallLogger2;
            this.f46560h = 2;
            if (httpClientCallLogger2.e(sb2, this) == d8) {
                return d8;
            }
            httpClientCallLogger = httpClientCallLogger2;
        }
        if (r12 != 0) {
            if (r12 != 1) {
                if (r12 != 2) {
                    if (r12 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Throwable th2 = (Throwable) this.f46561i;
                    ResultKt.b(obj);
                    throw th2;
                }
                httpClientCallLogger = (HttpClientCallLogger) this.f46559g;
                ResultKt.b(obj);
                th = (Throwable) this.f46561i;
                this.f46561i = th;
                this.f46559g = null;
                this.f46560h = 3;
                if (httpClientCallLogger.b(this) == d8) {
                    return d8;
                }
                throw th;
            }
            PipelineContext pipelineContext = (PipelineContext) this.f46561i;
            ResultKt.b(obj);
            r12 = pipelineContext;
        } else {
            ResultKt.b(obj);
            PipelineContext pipelineContext2 = (PipelineContext) this.f46561i;
            if (this.f46562j.h() != LogLevel.NONE) {
                Attributes attributes2 = ((HttpClientCall) pipelineContext2.c()).getAttributes();
                attributeKey2 = LoggingKt.f46568b;
                if (!attributes2.e(attributeKey2)) {
                    this.f46561i = pipelineContext2;
                    this.f46560h = 1;
                    Object f8 = pipelineContext2.f(this);
                    r12 = pipelineContext2;
                    if (f8 == d8) {
                        return d8;
                    }
                }
            }
            return Unit.f50853a;
        }
        return Unit.f50853a;
    }
}
