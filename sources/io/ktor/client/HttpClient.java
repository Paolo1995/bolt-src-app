package io.ktor.client;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.client.plugins.BodyProgress;
import io.ktor.client.plugins.DefaultResponseValidationKt;
import io.ktor.client.plugins.DefaultTransformKt;
import io.ktor.client.plugins.HttpCallValidator;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.plugins.HttpPlainText;
import io.ktor.client.plugins.HttpRedirect;
import io.ktor.client.plugins.HttpRequestLifecycle;
import io.ktor.client.plugins.HttpSend;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.client.utils.ClientEventsKt;
import io.ktor.client.utils.HttpResponseReceiveFail;
import io.ktor.events.Events;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.pipeline.PipelineContext;
import java.io.Closeable;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* compiled from: HttpClient.kt */
/* loaded from: classes5.dex */
public final class HttpClient implements CoroutineScope, Closeable {

    /* renamed from: s  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f46032s = AtomicIntegerFieldUpdater.newUpdater(HttpClient.class, "closed");
    private volatile /* synthetic */ int closed;

    /* renamed from: f  reason: collision with root package name */
    private final HttpClientEngine f46033f;

    /* renamed from: g  reason: collision with root package name */
    private final HttpClientConfig<? extends HttpClientEngineConfig> f46034g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f46035h;

    /* renamed from: i  reason: collision with root package name */
    private final CompletableJob f46036i;

    /* renamed from: j  reason: collision with root package name */
    private final CoroutineContext f46037j;

    /* renamed from: k  reason: collision with root package name */
    private final HttpRequestPipeline f46038k;

    /* renamed from: l  reason: collision with root package name */
    private final HttpResponsePipeline f46039l;

    /* renamed from: m  reason: collision with root package name */
    private final HttpSendPipeline f46040m;

    /* renamed from: n  reason: collision with root package name */
    private final HttpReceivePipeline f46041n;

    /* renamed from: o  reason: collision with root package name */
    private final Attributes f46042o;

    /* renamed from: p  reason: collision with root package name */
    private final HttpClientEngineConfig f46043p;

    /* renamed from: q  reason: collision with root package name */
    private final Events f46044q;

    /* renamed from: r  reason: collision with root package name */
    private final HttpClientConfig<HttpClientEngineConfig> f46045r;

    /* compiled from: HttpClient.kt */
    @DebugMetadata(c = "io.ktor.client.HttpClient$2", f = "HttpClient.kt", l = {144, 146}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.HttpClient$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f46047g;

        /* renamed from: h  reason: collision with root package name */
        private /* synthetic */ Object f46048h;

        /* renamed from: i  reason: collision with root package name */
        /* synthetic */ Object f46049i;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        /* renamed from: h */
        public final Object l(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.f46048h = pipelineContext;
            anonymousClass2.f46049i = obj;
            return anonymousClass2.invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            Object obj2;
            PipelineContext pipelineContext;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f46047g;
            if (i8 != 0) {
                if (i8 != 1) {
                    if (i8 == 2) {
                        ResultKt.b(obj);
                        return Unit.f50853a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj2 = this.f46049i;
                pipelineContext = (PipelineContext) this.f46048h;
                ResultKt.b(obj);
            } else {
                ResultKt.b(obj);
                PipelineContext pipelineContext2 = (PipelineContext) this.f46048h;
                obj2 = this.f46049i;
                if (obj2 instanceof HttpClientCall) {
                    HttpReceivePipeline h8 = HttpClient.this.h();
                    Unit unit = Unit.f50853a;
                    HttpResponse f8 = ((HttpClientCall) obj2).f();
                    this.f46048h = pipelineContext2;
                    this.f46049i = obj2;
                    this.f46047g = 1;
                    Object d9 = h8.d(unit, f8, this);
                    if (d9 == d8) {
                        return d8;
                    }
                    pipelineContext = pipelineContext2;
                    obj = d9;
                } else {
                    throw new IllegalStateException(("Error: HttpClientCall expected, but found " + obj2 + '(' + Reflection.b(obj2.getClass()) + ").").toString());
                }
            }
            ((HttpClientCall) obj2).l((HttpResponse) obj);
            this.f46048h = null;
            this.f46049i = null;
            this.f46047g = 2;
            if (pipelineContext.g(obj2, this) == d8) {
                return d8;
            }
            return Unit.f50853a;
        }
    }

    /* compiled from: HttpClient.kt */
    @DebugMetadata(c = "io.ktor.client.HttpClient$4", f = "HttpClient.kt", l = {177}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.HttpClient$4  reason: invalid class name */
    /* loaded from: classes5.dex */
    static final class AnonymousClass4 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f46052g;

        /* renamed from: h  reason: collision with root package name */
        private /* synthetic */ Object f46053h;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        /* renamed from: h */
        public final Object l(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(continuation);
            anonymousClass4.f46053h = pipelineContext;
            return anonymousClass4.invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            PipelineContext pipelineContext;
            Throwable th;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f46052g;
            if (i8 != 0) {
                if (i8 == 1) {
                    pipelineContext = (PipelineContext) this.f46053h;
                    try {
                        ResultKt.b(obj);
                    } catch (Throwable th2) {
                        th = th2;
                        HttpClient.this.g().a(ClientEventsKt.d(), new HttpResponseReceiveFail(((HttpClientCall) pipelineContext.c()).f(), th));
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.b(obj);
                PipelineContext pipelineContext2 = (PipelineContext) this.f46053h;
                try {
                    this.f46053h = pipelineContext2;
                    this.f46052g = 1;
                    if (pipelineContext2.f(this) == d8) {
                        return d8;
                    }
                } catch (Throwable th3) {
                    pipelineContext = pipelineContext2;
                    th = th3;
                    HttpClient.this.g().a(ClientEventsKt.d(), new HttpResponseReceiveFail(((HttpClientCall) pipelineContext.c()).f(), th));
                    throw th;
                }
            }
            return Unit.f50853a;
        }
    }

    public HttpClient(HttpClientEngine engine, HttpClientConfig<? extends HttpClientEngineConfig> userConfig) {
        Intrinsics.f(engine, "engine");
        Intrinsics.f(userConfig, "userConfig");
        this.f46033f = engine;
        this.f46034g = userConfig;
        this.closed = 0;
        CompletableJob a8 = JobKt.a((Job) engine.j().g(Job.f51296d));
        this.f46036i = a8;
        this.f46037j = engine.j().s0(a8);
        this.f46038k = new HttpRequestPipeline(userConfig.b());
        HttpResponsePipeline httpResponsePipeline = new HttpResponsePipeline(userConfig.b());
        this.f46039l = httpResponsePipeline;
        HttpSendPipeline httpSendPipeline = new HttpSendPipeline(userConfig.b());
        this.f46040m = httpSendPipeline;
        this.f46041n = new HttpReceivePipeline(userConfig.b());
        this.f46042o = AttributesJvmKt.a(true);
        this.f46043p = engine.d();
        this.f46044q = new Events();
        HttpClientConfig<HttpClientEngineConfig> httpClientConfig = new HttpClientConfig<>();
        this.f46045r = httpClientConfig;
        if (this.f46035h) {
            a8.X(new Function1<Throwable, Unit>() { // from class: io.ktor.client.HttpClient.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    if (th != null) {
                        CoroutineScopeKt.d(HttpClient.this.e(), null, 1, null);
                    }
                }
            });
        }
        engine.g1(this);
        httpSendPipeline.l(HttpSendPipeline.f46641h.c(), new AnonymousClass2(null));
        HttpClientConfig.i(httpClientConfig, HttpRequestLifecycle.f46363a, null, 2, null);
        HttpClientConfig.i(httpClientConfig, BodyProgress.f46230a, null, 2, null);
        if (userConfig.e()) {
            httpClientConfig.h("DefaultTransformers", new Function1<HttpClient, Unit>() { // from class: io.ktor.client.HttpClient$3$1
                public final void b(HttpClient install) {
                    Intrinsics.f(install, "$this$install");
                    DefaultTransformKt.a(install);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpClient httpClient) {
                    b(httpClient);
                    return Unit.f50853a;
                }
            });
        }
        HttpClientConfig.i(httpClientConfig, HttpSend.f46370c, null, 2, null);
        HttpClientConfig.i(httpClientConfig, HttpCallValidator.f46282d, null, 2, null);
        if (userConfig.d()) {
            HttpClientConfig.i(httpClientConfig, HttpRedirect.f46338c, null, 2, null);
        }
        httpClientConfig.j(userConfig);
        if (userConfig.e()) {
            HttpClientConfig.i(httpClientConfig, HttpPlainText.f46321d, null, 2, null);
        }
        DefaultResponseValidationKt.b(httpClientConfig);
        httpClientConfig.f(this);
        httpResponsePipeline.l(HttpResponsePipeline.f46667h.b(), new AnonymousClass4(null));
    }

    public final Object a(HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpClientCall> continuation) {
        Object d8;
        this.f46044q.a(ClientEventsKt.a(), httpRequestBuilder);
        Object d9 = this.f46038k.d(httpRequestBuilder, httpRequestBuilder.c(), continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (d9 == d8) {
            return d9;
        }
        return (HttpClientCall) d9;
    }

    public final HttpClientConfig<HttpClientEngineConfig> c() {
        return this.f46045r;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!f46032s.compareAndSet(this, 0, 1)) {
            return;
        }
        Attributes attributes = (Attributes) this.f46042o.a(HttpClientPluginKt.a());
        Iterator<T> it = attributes.c().iterator();
        while (it.hasNext()) {
            Object a8 = attributes.a((AttributeKey) it.next());
            if (a8 instanceof Closeable) {
                ((Closeable) a8).close();
            }
        }
        this.f46036i.k();
        if (this.f46035h) {
            this.f46033f.close();
        }
    }

    public final HttpClientEngine e() {
        return this.f46033f;
    }

    public final Events g() {
        return this.f46044q;
    }

    public final Attributes getAttributes() {
        return this.f46042o;
    }

    public final HttpReceivePipeline h() {
        return this.f46041n;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext j() {
        return this.f46037j;
    }

    public final HttpRequestPipeline k() {
        return this.f46038k;
    }

    public final HttpResponsePipeline l() {
        return this.f46039l;
    }

    public final HttpSendPipeline m() {
        return this.f46040m;
    }

    public String toString() {
        return "HttpClient[" + this.f46033f + ']';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpClient(HttpClientEngine engine, HttpClientConfig<? extends HttpClientEngineConfig> userConfig, boolean z7) {
        this(engine, userConfig);
        Intrinsics.f(engine, "engine");
        Intrinsics.f(userConfig, "userConfig");
        this.f46035h = z7;
    }
}
