package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpCallValidator.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpCallValidator$Companion$install$1", f = "HttpCallValidator.kt", l = {126, 129}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class HttpCallValidator$Companion$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f46287g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f46288h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f46289i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ HttpCallValidator f46290j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCallValidator$Companion$install$1(HttpCallValidator httpCallValidator, Continuation<? super HttpCallValidator$Companion$install$1> continuation) {
        super(3, continuation);
        this.f46290j = httpCallValidator;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        HttpCallValidator$Companion$install$1 httpCallValidator$Companion$install$1 = new HttpCallValidator$Companion$install$1(this.f46290j, continuation);
        httpCallValidator$Companion$install$1.f46288h = pipelineContext;
        httpCallValidator$Companion$install$1.f46289i = obj;
        return httpCallValidator$Companion$install$1.invokeSuspend(Unit.f50853a);
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
        HttpCallValidatorKt$HttpRequest$1 a8;
        Object e8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        ?? r12 = this.f46287g;
        try {
            if (r12 != 0) {
                if (r12 != 1) {
                    if (r12 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Throwable th = (Throwable) this.f46288h;
                    ResultKt.b(obj);
                    throw th;
                }
                PipelineContext pipelineContext = (PipelineContext) this.f46288h;
                ResultKt.b(obj);
                r12 = pipelineContext;
            } else {
                ResultKt.b(obj);
                PipelineContext pipelineContext2 = (PipelineContext) this.f46288h;
                Object obj2 = this.f46289i;
                Attributes b8 = ((HttpRequestBuilder) pipelineContext2.c()).b();
                AttributeKey<Boolean> d9 = HttpCallValidatorKt.d();
                final HttpCallValidator httpCallValidator = this.f46290j;
                b8.g(d9, new Function0<Boolean>() { // from class: io.ktor.client.plugins.HttpCallValidator$Companion$install$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    /* renamed from: b */
                    public final Boolean invoke() {
                        boolean z7;
                        z7 = HttpCallValidator.this.f46286c;
                        return Boolean.valueOf(z7);
                    }
                });
                this.f46288h = pipelineContext2;
                this.f46287g = 1;
                Object g8 = pipelineContext2.g(obj2, this);
                r12 = pipelineContext2;
                if (g8 == d8) {
                    return d8;
                }
            }
            return Unit.f50853a;
        } catch (Throwable th2) {
            Throwable a9 = ExceptionUtilsJvmKt.a(th2);
            HttpCallValidator httpCallValidator2 = this.f46290j;
            a8 = HttpCallValidatorKt.a((HttpRequestBuilder) r12.c());
            this.f46288h = a9;
            this.f46287g = 2;
            e8 = httpCallValidator2.e(a9, a8, this);
            if (e8 == d8) {
                return d8;
            }
            throw a9;
        }
    }
}
