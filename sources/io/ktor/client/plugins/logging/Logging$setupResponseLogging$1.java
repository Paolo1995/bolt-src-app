package io.ktor.client.plugins.logging;

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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Logging.kt */
@DebugMetadata(c = "io.ktor.client.plugins.logging.Logging$setupResponseLogging$1", f = "Logging.kt", l = {158, 165, 165}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class Logging$setupResponseLogging$1 extends SuspendLambda implements Function3<PipelineContext<HttpResponse, Unit>, HttpResponse, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    Object f46553g;

    /* renamed from: h  reason: collision with root package name */
    int f46554h;

    /* renamed from: i  reason: collision with root package name */
    int f46555i;

    /* renamed from: j  reason: collision with root package name */
    private /* synthetic */ Object f46556j;

    /* renamed from: k  reason: collision with root package name */
    /* synthetic */ Object f46557k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ Logging f46558l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Logging$setupResponseLogging$1(Logging logging, Continuation<? super Logging$setupResponseLogging$1> continuation) {
        super(3, continuation);
        this.f46558l = logging;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(PipelineContext<HttpResponse, Unit> pipelineContext, HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        Logging$setupResponseLogging$1 logging$setupResponseLogging$1 = new Logging$setupResponseLogging$1(this.f46558l, continuation);
        logging$setupResponseLogging$1.f46556j = pipelineContext;
        logging$setupResponseLogging$1.f46557k = httpResponse;
        return logging$setupResponseLogging$1.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        Throwable th;
        HttpResponse httpResponse;
        AttributeKey<?> attributeKey;
        AttributeKey attributeKey2;
        HttpClientCallLogger httpClientCallLogger;
        StringBuilder sb;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f46555i;
        int i9 = 1;
        try {
            if (i8 != 0) {
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        th = (Throwable) this.f46556j;
                        ResultKt.b(obj);
                        throw th;
                    }
                    ResultKt.b(obj);
                    return Unit.f50853a;
                }
                i8 = this.f46554h;
                sb = (StringBuilder) this.f46553g;
                httpClientCallLogger = (HttpClientCallLogger) this.f46557k;
                httpResponse = (HttpResponse) this.f46556j;
                ResultKt.b(obj);
            } else {
                ResultKt.b(obj);
                PipelineContext pipelineContext = (PipelineContext) this.f46556j;
                httpResponse = (HttpResponse) this.f46557k;
                if (this.f46558l.h() != LogLevel.NONE) {
                    Attributes attributes = httpResponse.Y().getAttributes();
                    attributeKey = LoggingKt.f46568b;
                    if (!attributes.e(attributeKey)) {
                        Attributes attributes2 = httpResponse.Y().getAttributes();
                        attributeKey2 = LoggingKt.f46567a;
                        httpClientCallLogger = (HttpClientCallLogger) attributes2.a(attributeKey2);
                        sb = new StringBuilder();
                        i8 = 0;
                        LoggingUtilsKt.d(sb, httpResponse.Y().f(), this.f46558l.h());
                        Object e8 = pipelineContext.e();
                        this.f46556j = httpResponse;
                        this.f46557k = httpClientCallLogger;
                        this.f46553g = sb;
                        this.f46554h = 0;
                        this.f46555i = 1;
                        if (pipelineContext.g(e8, this) == d8) {
                            return d8;
                        }
                    }
                }
                return Unit.f50853a;
            }
            String sb2 = sb.toString();
            Intrinsics.e(sb2, "header.toString()");
            httpClientCallLogger.f(sb2);
            if (i8 != 0 || !this.f46558l.h().c()) {
                this.f46556j = null;
                this.f46557k = null;
                this.f46553g = null;
                this.f46555i = 2;
                if (httpClientCallLogger.b(this) == d8) {
                    return d8;
                }
            }
            return Unit.f50853a;
        } catch (Throwable th2) {
            try {
                this.f46558l.l(sb, httpResponse.Y().e(), th2);
            } catch (Throwable th3) {
                th = th3;
                i9 = i8;
            }
            try {
                throw th2;
            } catch (Throwable th4) {
                th = th4;
                String sb3 = sb.toString();
                Intrinsics.e(sb3, "header.toString()");
                httpClientCallLogger.f(sb3);
                if (i9 != 0 || !this.f46558l.h().c()) {
                    this.f46556j = th;
                    this.f46557k = null;
                    this.f46553g = null;
                    this.f46555i = 3;
                    if (httpClientCallLogger.b(this) == d8) {
                        return d8;
                    }
                    th = th;
                    throw th;
                }
                throw th;
            }
        }
    }
}
