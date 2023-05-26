package io.ktor.client.engine.okhttp;

import io.ktor.client.engine.HttpClientEngineBase;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.websocket.WebSocketCapability;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.utils.CoroutineDispatcherUtilsKt;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.CacheKt;
import io.ktor.util.CoroutinesUtilsKt;
import io.ktor.util.date.GMTDate;
import java.io.Closeable;
import java.net.Proxy;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/* compiled from: OkHttpEngine.kt */
/* loaded from: classes5.dex */
public final class OkHttpEngine extends HttpClientEngineBase {

    /* renamed from: o  reason: collision with root package name */
    private static final Companion f46152o = new Companion(null);
    @Deprecated

    /* renamed from: p  reason: collision with root package name */
    private static final Lazy<OkHttpClient> f46153p;

    /* renamed from: i  reason: collision with root package name */
    private final OkHttpConfig f46154i;

    /* renamed from: j  reason: collision with root package name */
    private final Lazy f46155j;

    /* renamed from: k  reason: collision with root package name */
    private final Set<HttpClientEngineCapability<?>> f46156k;

    /* renamed from: l  reason: collision with root package name */
    private final CoroutineContext f46157l;

    /* renamed from: m  reason: collision with root package name */
    private final CoroutineContext f46158m;

    /* renamed from: n  reason: collision with root package name */
    private final Map<HttpTimeout.HttpTimeoutCapabilityConfiguration, OkHttpClient> f46159n;

    /* compiled from: OkHttpEngine.kt */
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine$1", f = "OkHttpEngine.kt", l = {58}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.engine.okhttp.OkHttpEngine$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f46160g;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f46160g;
            try {
                if (i8 != 0) {
                    if (i8 == 1) {
                        ResultKt.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.b(obj);
                    CoroutineContext.Element g8 = OkHttpEngine.this.f46157l.g(Job.f51296d);
                    Intrinsics.c(g8);
                    this.f46160g = 1;
                    if (((Job) g8).v0(this) == d8) {
                        return d8;
                    }
                }
                for (Map.Entry entry : r4) {
                    OkHttpClient okHttpClient = (OkHttpClient) entry.getValue();
                    okHttpClient.connectionPool().evictAll();
                    okHttpClient.dispatcher().executorService().shutdown();
                }
                ((Closeable) OkHttpEngine.this.getDispatcher()).close();
                return Unit.f50853a;
            } finally {
                for (Map.Entry entry2 : OkHttpEngine.this.f46159n.entrySet()) {
                    OkHttpClient okHttpClient2 = (OkHttpClient) entry2.getValue();
                    okHttpClient2.connectionPool().evictAll();
                    okHttpClient2.dispatcher().executorService().shutdown();
                }
                ((Closeable) OkHttpEngine.this.getDispatcher()).close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OkHttpEngine.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OkHttpClient a() {
            return (OkHttpClient) OkHttpEngine.f46153p.getValue();
        }
    }

    static {
        Lazy<OkHttpClient> b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<OkHttpClient>() { // from class: io.ktor.client.engine.okhttp.OkHttpEngine$Companion$okHttpClientPrototype$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final OkHttpClient invoke() {
                return new OkHttpClient.Builder().build();
            }
        });
        f46153p = b8;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpEngine(OkHttpConfig config) {
        super("ktor-okhttp");
        Lazy b8;
        Set<HttpClientEngineCapability<?>> f8;
        Intrinsics.f(config, "config");
        this.f46154i = config;
        b8 = LazyKt__LazyJVMKt.b(new Function0<CoroutineDispatcher>() { // from class: io.ktor.client.engine.okhttp.OkHttpEngine$dispatcher$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final CoroutineDispatcher invoke() {
                return CoroutineDispatcherUtilsKt.a(Dispatchers.f51262a, OkHttpEngine.this.d().b(), "ktor-okhttp-dispatcher");
            }
        });
        this.f46155j = b8;
        f8 = SetsKt__SetsKt.f(HttpTimeout.f46390d, WebSocketCapability.f46603a);
        this.f46156k = f8;
        this.f46159n = CacheKt.a(new OkHttpEngine$clientCache$1(this), new Function1<OkHttpClient, Unit>() { // from class: io.ktor.client.engine.okhttp.OkHttpEngine$clientCache$2
            public final void b(OkHttpClient it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OkHttpClient okHttpClient) {
                b(okHttpClient);
                return Unit.f50853a;
            }
        }, d().c());
        CoroutineContext.Element g8 = super.j().g(Job.f51296d);
        Intrinsics.c(g8);
        CoroutineContext a8 = CoroutinesUtilsKt.a((Job) g8);
        this.f46157l = a8;
        this.f46158m = super.j().s0(a8);
        BuildersKt.c(GlobalScope.f51286f, super.j(), CoroutineStart.ATOMIC, new AnonymousClass1(null));
    }

    private final HttpResponseData m(Response response, GMTDate gMTDate, Object obj, CoroutineContext coroutineContext) {
        return new HttpResponseData(new HttpStatusCode(response.code(), response.message()), gMTDate, OkUtilsKt.c(response.headers()), OkUtilsKt.d(response.protocol()), obj, coroutineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OkHttpClient q(HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration) {
        OkHttpClient e8 = d().e();
        if (e8 == null) {
            e8 = f46152o.a();
        }
        OkHttpClient.Builder newBuilder = e8.newBuilder();
        newBuilder.dispatcher(new Dispatcher());
        d().d().invoke(newBuilder);
        Proxy a8 = d().a();
        if (a8 != null) {
            newBuilder.proxy(a8);
        }
        if (httpTimeoutCapabilityConfiguration != null) {
            OkHttpEngineKt.c(newBuilder, httpTimeoutCapabilityConfiguration);
        }
        return newBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object t(okhttp3.OkHttpClient r6, okhttp3.Request r7, kotlin.coroutines.CoroutineContext r8, io.ktor.client.request.HttpRequestData r9, kotlin.coroutines.Continuation<? super io.ktor.client.request.HttpResponseData> r10) {
        /*
            r5 = this;
            boolean r0 = r10 instanceof io.ktor.client.engine.okhttp.OkHttpEngine$executeHttpRequest$1
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.client.engine.okhttp.OkHttpEngine$executeHttpRequest$1 r0 = (io.ktor.client.engine.okhttp.OkHttpEngine$executeHttpRequest$1) r0
            int r1 = r0.f46176l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f46176l = r1
            goto L18
        L13:
            io.ktor.client.engine.okhttp.OkHttpEngine$executeHttpRequest$1 r0 = new io.ktor.client.engine.okhttp.OkHttpEngine$executeHttpRequest$1
            r0.<init>(r5, r10)
        L18:
            java.lang.Object r10 = r0.f46174j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f46176l
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r6 = r0.f46173i
            io.ktor.util.date.GMTDate r6 = (io.ktor.util.date.GMTDate) r6
            java.lang.Object r7 = r0.f46172h
            r9 = r7
            io.ktor.client.request.HttpRequestData r9 = (io.ktor.client.request.HttpRequestData) r9
            java.lang.Object r7 = r0.f46171g
            r8 = r7
            kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
            java.lang.Object r7 = r0.f46170f
            io.ktor.client.engine.okhttp.OkHttpEngine r7 = (io.ktor.client.engine.okhttp.OkHttpEngine) r7
            kotlin.ResultKt.b(r10)
            goto L60
        L3b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L43:
            kotlin.ResultKt.b(r10)
            r10 = 0
            io.ktor.util.date.GMTDate r10 = io.ktor.util.date.DateJvmKt.c(r10, r3, r10)
            r0.f46170f = r5
            r0.f46171g = r8
            r0.f46172h = r9
            r0.f46173i = r10
            r0.f46176l = r3
            java.lang.Object r6 = io.ktor.client.engine.okhttp.OkUtilsKt.b(r6, r7, r9, r0)
            if (r6 != r1) goto L5c
            return r1
        L5c:
            r7 = r5
            r4 = r10
            r10 = r6
            r6 = r4
        L60:
            okhttp3.Response r10 = (okhttp3.Response) r10
            okhttp3.ResponseBody r0 = r10.body()
            kotlinx.coroutines.Job$Key r1 = kotlinx.coroutines.Job.f51296d
            kotlin.coroutines.CoroutineContext$Element r1 = r8.g(r1)
            kotlin.jvm.internal.Intrinsics.c(r1)
            kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1
            io.ktor.client.engine.okhttp.OkHttpEngine$executeHttpRequest$2 r2 = new io.ktor.client.engine.okhttp.OkHttpEngine$executeHttpRequest$2
            r2.<init>()
            r1.X(r2)
            if (r0 == 0) goto L87
            okio.BufferedSource r0 = r0.source()
            if (r0 == 0) goto L87
            io.ktor.utils.io.ByteReadChannel r9 = io.ktor.client.engine.okhttp.OkHttpEngineKt.d(r0, r8, r9)
            if (r9 != 0) goto L8d
        L87:
            io.ktor.utils.io.ByteReadChannel$Companion r9 = io.ktor.utils.io.ByteReadChannel.f47328a
            io.ktor.utils.io.ByteReadChannel r9 = r9.a()
        L8d:
            io.ktor.client.request.HttpResponseData r6 = r7.m(r10, r6, r9, r8)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.okhttp.OkHttpEngine.t(okhttp3.OkHttpClient, okhttp3.Request, kotlin.coroutines.CoroutineContext, io.ktor.client.request.HttpRequestData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object w(okhttp3.OkHttpClient r6, okhttp3.Request r7, kotlin.coroutines.CoroutineContext r8, kotlin.coroutines.Continuation<? super io.ktor.client.request.HttpResponseData> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof io.ktor.client.engine.okhttp.OkHttpEngine$executeWebSocketRequest$1
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.client.engine.okhttp.OkHttpEngine$executeWebSocketRequest$1 r0 = (io.ktor.client.engine.okhttp.OkHttpEngine$executeWebSocketRequest$1) r0
            int r1 = r0.f46184l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f46184l = r1
            goto L18
        L13:
            io.ktor.client.engine.okhttp.OkHttpEngine$executeWebSocketRequest$1 r0 = new io.ktor.client.engine.okhttp.OkHttpEngine$executeWebSocketRequest$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.f46182j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f46184l
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r6 = r0.f46181i
            io.ktor.client.engine.okhttp.OkHttpWebsocketSession r6 = (io.ktor.client.engine.okhttp.OkHttpWebsocketSession) r6
            java.lang.Object r7 = r0.f46180h
            io.ktor.util.date.GMTDate r7 = (io.ktor.util.date.GMTDate) r7
            java.lang.Object r8 = r0.f46179g
            kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
            java.lang.Object r0 = r0.f46178f
            io.ktor.client.engine.okhttp.OkHttpEngine r0 = (io.ktor.client.engine.okhttp.OkHttpEngine) r0
            kotlin.ResultKt.b(r9)
            goto L75
        L39:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L41:
            kotlin.ResultKt.b(r9)
            r9 = 0
            io.ktor.util.date.GMTDate r9 = io.ktor.util.date.DateJvmKt.c(r9, r3, r9)
            io.ktor.client.engine.okhttp.OkHttpWebsocketSession r2 = new io.ktor.client.engine.okhttp.OkHttpWebsocketSession
            io.ktor.client.engine.okhttp.OkHttpConfig r4 = r5.d()
            okhttp3.WebSocket$Factory r4 = r4.f()
            if (r4 != 0) goto L56
            r4 = r6
        L56:
            r2.<init>(r6, r4, r7, r8)
            r2.f()
            kotlinx.coroutines.CompletableDeferred r6 = r2.c()
            r0.f46178f = r5
            r0.f46179g = r8
            r0.f46180h = r9
            r0.f46181i = r2
            r0.f46184l = r3
            java.lang.Object r6 = r6.N(r0)
            if (r6 != r1) goto L71
            return r1
        L71:
            r0 = r5
            r7 = r9
            r9 = r6
            r6 = r2
        L75:
            okhttp3.Response r9 = (okhttp3.Response) r9
            io.ktor.client.request.HttpResponseData r6 = r0.m(r9, r7, r6, r8)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.okhttp.OkHttpEngine.w(okhttp3.OkHttpClient, okhttp3.Request, kotlin.coroutines.CoroutineContext, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0096  */
    @Override // io.ktor.client.engine.HttpClientEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object Y0(io.ktor.client.request.HttpRequestData r10, kotlin.coroutines.Continuation<? super io.ktor.client.request.HttpResponseData> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof io.ktor.client.engine.okhttp.OkHttpEngine$execute$1
            if (r0 == 0) goto L13
            r0 = r11
            io.ktor.client.engine.okhttp.OkHttpEngine$execute$1 r0 = (io.ktor.client.engine.okhttp.OkHttpEngine$execute$1) r0
            int r1 = r0.f46169j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f46169j = r1
            goto L18
        L13:
            io.ktor.client.engine.okhttp.OkHttpEngine$execute$1 r0 = new io.ktor.client.engine.okhttp.OkHttpEngine$execute$1
            r0.<init>(r9, r11)
        L18:
            r6 = r0
            java.lang.Object r11 = r6.f46167h
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r1 = r6.f46169j
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L48
            if (r1 == r4) goto L3c
            if (r1 == r3) goto L38
            if (r1 != r2) goto L30
            kotlin.ResultKt.b(r11)
            goto L95
        L30:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L38:
            kotlin.ResultKt.b(r11)
            goto L85
        L3c:
            java.lang.Object r10 = r6.f46166g
            io.ktor.client.request.HttpRequestData r10 = (io.ktor.client.request.HttpRequestData) r10
            java.lang.Object r1 = r6.f46165f
            io.ktor.client.engine.okhttp.OkHttpEngine r1 = (io.ktor.client.engine.okhttp.OkHttpEngine) r1
            kotlin.ResultKt.b(r11)
            goto L59
        L48:
            kotlin.ResultKt.b(r11)
            r6.f46165f = r9
            r6.f46166g = r10
            r6.f46169j = r4
            java.lang.Object r11 = io.ktor.client.engine.UtilsKt.b(r6)
            if (r11 != r0) goto L58
            return r0
        L58:
            r1 = r9
        L59:
            r5 = r10
            r4 = r11
            kotlin.coroutines.CoroutineContext r4 = (kotlin.coroutines.CoroutineContext) r4
            okhttp3.Request r10 = io.ktor.client.engine.okhttp.OkHttpEngineKt.a(r5, r4)
            java.util.Map<io.ktor.client.plugins.HttpTimeout$HttpTimeoutCapabilityConfiguration, okhttp3.OkHttpClient> r11 = r1.f46159n
            io.ktor.client.plugins.HttpTimeout$Plugin r7 = io.ktor.client.plugins.HttpTimeout.f46390d
            java.lang.Object r7 = r5.c(r7)
            java.lang.Object r11 = r11.get(r7)
            okhttp3.OkHttpClient r11 = (okhttp3.OkHttpClient) r11
            if (r11 == 0) goto L96
            boolean r7 = io.ktor.client.request.HttpRequestKt.a(r5)
            r8 = 0
            if (r7 == 0) goto L86
            r6.f46165f = r8
            r6.f46166g = r8
            r6.f46169j = r3
            java.lang.Object r11 = r1.w(r11, r10, r4, r6)
            if (r11 != r0) goto L85
            return r0
        L85:
            return r11
        L86:
            r6.f46165f = r8
            r6.f46166g = r8
            r6.f46169j = r2
            r2 = r11
            r3 = r10
            java.lang.Object r11 = r1.t(r2, r3, r4, r5, r6)
            if (r11 != r0) goto L95
            return r0
        L95:
            return r11
        L96:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "OkHttpClient can't be constructed because HttpTimeout plugin is not installed"
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.okhttp.OkHttpEngine.Y0(io.ktor.client.request.HttpRequestData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        CoroutineContext.Element g8 = this.f46157l.g(Job.f51296d);
        if (g8 != null) {
            ((CompletableJob) g8).k();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletableJob");
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public CoroutineDispatcher getDispatcher() {
        return (CoroutineDispatcher) this.f46155j.getValue();
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, kotlinx.coroutines.CoroutineScope
    public CoroutineContext j() {
        return this.f46158m;
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    /* renamed from: y */
    public OkHttpConfig d() {
        return this.f46154i;
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, io.ktor.client.engine.HttpClientEngine
    public Set<HttpClientEngineCapability<?>> z0() {
        return this.f46156k;
    }
}
