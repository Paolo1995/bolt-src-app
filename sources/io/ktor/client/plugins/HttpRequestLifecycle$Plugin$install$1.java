package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpRequestLifecycle.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpRequestLifecycle$Plugin$install$1", f = "HttpRequestLifecycle.kt", l = {35}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class HttpRequestLifecycle$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f46365g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f46366h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ HttpClient f46367i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpRequestLifecycle$Plugin$install$1(HttpClient httpClient, Continuation<? super HttpRequestLifecycle$Plugin$install$1> continuation) {
        super(3, continuation);
        this.f46367i = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        HttpRequestLifecycle$Plugin$install$1 httpRequestLifecycle$Plugin$install$1 = new HttpRequestLifecycle$Plugin$install$1(this.f46367i, continuation);
        httpRequestLifecycle$Plugin$install$1.f46366h = pipelineContext;
        return httpRequestLifecycle$Plugin$install$1.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        CompletableJob completableJob;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f46365g;
        if (i8 != 0) {
            if (i8 == 1) {
                completableJob = (CompletableJob) this.f46366h;
                try {
                    ResultKt.b(obj);
                } catch (Throwable th) {
                    th = th;
                    try {
                        completableJob.a(th);
                        throw th;
                    } catch (Throwable th2) {
                        completableJob.k();
                        throw th2;
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            PipelineContext pipelineContext = (PipelineContext) this.f46366h;
            CompletableJob a8 = JobKt.a(((HttpRequestBuilder) pipelineContext.c()).f());
            CoroutineContext.Element g8 = this.f46367i.j().g(Job.f51296d);
            Intrinsics.c(g8);
            HttpRequestLifecycleKt.b(a8, (Job) g8);
            try {
                ((HttpRequestBuilder) pipelineContext.c()).l(a8);
                this.f46366h = a8;
                this.f46365g = 1;
                if (pipelineContext.f(this) == d8) {
                    return d8;
                }
                completableJob = a8;
            } catch (Throwable th3) {
                th = th3;
                completableJob = a8;
                completableJob.a(th);
                throw th;
            }
        }
        completableJob.k();
        return Unit.f50853a;
    }
}
