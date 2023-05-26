package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpCallValidator.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpCallValidator$Companion$install$2", f = "HttpCallValidator.kt", l = {138, 141}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class HttpCallValidator$Companion$install$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f46292g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f46293h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f46294i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ HttpCallValidator f46295j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCallValidator$Companion$install$2(HttpCallValidator httpCallValidator, Continuation<? super HttpCallValidator$Companion$install$2> continuation) {
        super(3, continuation);
        this.f46295j = httpCallValidator;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
        HttpCallValidator$Companion$install$2 httpCallValidator$Companion$install$2 = new HttpCallValidator$Companion$install$2(this.f46295j, continuation);
        httpCallValidator$Companion$install$2.f46293h = pipelineContext;
        httpCallValidator$Companion$install$2.f46294i = httpResponseContainer;
        return httpCallValidator$Companion$install$2.invokeSuspend(Unit.f50853a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [io.ktor.util.pipeline.PipelineContext] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v8 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        Object e8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        ?? r12 = this.f46292g;
        try {
            if (r12 != 0) {
                if (r12 != 1) {
                    if (r12 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Throwable th = (Throwable) this.f46293h;
                    ResultKt.b(obj);
                    throw th;
                }
                PipelineContext pipelineContext = (PipelineContext) this.f46293h;
                ResultKt.b(obj);
                r12 = pipelineContext;
            } else {
                ResultKt.b(obj);
                PipelineContext pipelineContext2 = (PipelineContext) this.f46293h;
                HttpResponseContainer httpResponseContainer = (HttpResponseContainer) this.f46294i;
                this.f46293h = pipelineContext2;
                this.f46292g = 1;
                Object g8 = pipelineContext2.g(httpResponseContainer, this);
                r12 = pipelineContext2;
                if (g8 == d8) {
                    return d8;
                }
            }
            return Unit.f50853a;
        } catch (Throwable th2) {
            Throwable a8 = ExceptionUtilsJvmKt.a(th2);
            HttpCallValidator httpCallValidator = this.f46295j;
            HttpRequest e9 = ((HttpClientCall) r12.c()).e();
            this.f46293h = a8;
            this.f46292g = 2;
            e8 = httpCallValidator.e(a8, e9, this);
            if (e8 == d8) {
                return d8;
            }
            throw a8;
        }
    }
}
