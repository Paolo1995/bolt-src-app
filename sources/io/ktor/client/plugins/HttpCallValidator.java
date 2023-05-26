package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.pipeline.PipelinePhase;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpCallValidator.kt */
/* loaded from: classes5.dex */
public final class HttpCallValidator {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f46282d = new Companion(null);

    /* renamed from: e  reason: collision with root package name */
    private static final AttributeKey<HttpCallValidator> f46283e = new AttributeKey<>("HttpResponseValidator");

    /* renamed from: a  reason: collision with root package name */
    private final List<Function2<HttpResponse, Continuation<? super Unit>, Object>> f46284a;

    /* renamed from: b  reason: collision with root package name */
    private final List<HandlerWrapper> f46285b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f46286c;

    /* compiled from: HttpCallValidator.kt */
    /* loaded from: classes5.dex */
    public static final class Companion implements HttpClientPlugin<Config, HttpCallValidator> {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        /* renamed from: c */
        public void a(HttpCallValidator plugin, HttpClient scope) {
            Intrinsics.f(plugin, "plugin");
            Intrinsics.f(scope, "scope");
            scope.k().l(HttpRequestPipeline.f46627h.a(), new HttpCallValidator$Companion$install$1(plugin, null));
            PipelinePhase pipelinePhase = new PipelinePhase("BeforeReceive");
            scope.l().k(HttpResponsePipeline.f46667h.b(), pipelinePhase);
            scope.l().l(pipelinePhase, new HttpCallValidator$Companion$install$2(plugin, null));
            ((HttpSend) HttpClientPluginKt.b(scope, HttpSend.f46370c)).d(new HttpCallValidator$Companion$install$3(plugin, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        /* renamed from: d */
        public HttpCallValidator b(Function1<? super Config, Unit> block) {
            List r02;
            List r03;
            Intrinsics.f(block, "block");
            Config config = new Config();
            block.invoke(config);
            r02 = CollectionsKt___CollectionsKt.r0(config.c());
            r03 = CollectionsKt___CollectionsKt.r0(config.b());
            return new HttpCallValidator(r02, r03, config.a());
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<HttpCallValidator> getKey() {
            return HttpCallValidator.f46283e;
        }
    }

    /* compiled from: HttpCallValidator.kt */
    /* loaded from: classes5.dex */
    public static final class Config {

        /* renamed from: a  reason: collision with root package name */
        private final List<Function2<HttpResponse, Continuation<? super Unit>, Object>> f46300a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final List<HandlerWrapper> f46301b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private boolean f46302c = true;

        public final boolean a() {
            return this.f46302c;
        }

        public final List<HandlerWrapper> b() {
            return this.f46301b;
        }

        public final List<Function2<HttpResponse, Continuation<? super Unit>, Object>> c() {
            return this.f46300a;
        }

        public final void d(boolean z7) {
            this.f46302c = z7;
        }

        public final void e(Function2<? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object> block) {
            Intrinsics.f(block, "block");
            this.f46300a.add(block);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpCallValidator(List<? extends Function2<? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object>> responseValidators, List<? extends HandlerWrapper> callExceptionHandlers, boolean z7) {
        Intrinsics.f(responseValidators, "responseValidators");
        Intrinsics.f(callExceptionHandlers, "callExceptionHandlers");
        this.f46284a = responseValidators;
        this.f46285b = callExceptionHandlers;
        this.f46286c = z7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(java.lang.Throwable r8, io.ktor.client.request.HttpRequest r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof io.ktor.client.plugins.HttpCallValidator$processException$1
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.client.plugins.HttpCallValidator$processException$1 r0 = (io.ktor.client.plugins.HttpCallValidator$processException$1) r0
            int r1 = r0.f46308k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f46308k = r1
            goto L18
        L13:
            io.ktor.client.plugins.HttpCallValidator$processException$1 r0 = new io.ktor.client.plugins.HttpCallValidator$processException$1
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.f46306i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f46308k
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L43
            if (r2 == r4) goto L31
            if (r2 != r3) goto L29
            goto L31
        L29:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L31:
            java.lang.Object r8 = r0.f46305h
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.f46304g
            io.ktor.client.request.HttpRequest r9 = (io.ktor.client.request.HttpRequest) r9
            java.lang.Object r2 = r0.f46303f
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            kotlin.ResultKt.b(r10)
            r10 = r9
            r9 = r2
            goto L50
        L43:
            kotlin.ResultKt.b(r10)
            java.util.List<io.ktor.client.plugins.HandlerWrapper> r10 = r7.f46285b
            java.util.Iterator r10 = r10.iterator()
            r6 = r9
            r9 = r8
            r8 = r10
            r10 = r6
        L50:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L8e
            java.lang.Object r2 = r8.next()
            io.ktor.client.plugins.HandlerWrapper r2 = (io.ktor.client.plugins.HandlerWrapper) r2
            boolean r5 = r2 instanceof io.ktor.client.plugins.ExceptionHandlerWrapper
            if (r5 == 0) goto L75
            io.ktor.client.plugins.ExceptionHandlerWrapper r2 = (io.ktor.client.plugins.ExceptionHandlerWrapper) r2
            kotlin.jvm.functions.Function2 r2 = r2.a()
            r0.f46303f = r9
            r0.f46304g = r10
            r0.f46305h = r8
            r0.f46308k = r4
            java.lang.Object r2 = r2.s(r9, r0)
            if (r2 != r1) goto L50
            return r1
        L75:
            boolean r5 = r2 instanceof io.ktor.client.plugins.RequestExceptionHandlerWrapper
            if (r5 == 0) goto L50
            io.ktor.client.plugins.RequestExceptionHandlerWrapper r2 = (io.ktor.client.plugins.RequestExceptionHandlerWrapper) r2
            kotlin.jvm.functions.Function3 r2 = r2.a()
            r0.f46303f = r9
            r0.f46304g = r10
            r0.f46305h = r8
            r0.f46308k = r3
            java.lang.Object r2 = r2.l(r9, r10, r0)
            if (r2 != r1) goto L50
            return r1
        L8e:
            kotlin.Unit r8 = kotlin.Unit.f50853a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpCallValidator.e(java.lang.Throwable, io.ktor.client.request.HttpRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(io.ktor.client.statement.HttpResponse r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.client.plugins.HttpCallValidator$validateResponse$1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.client.plugins.HttpCallValidator$validateResponse$1 r0 = (io.ktor.client.plugins.HttpCallValidator$validateResponse$1) r0
            int r1 = r0.f46313j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f46313j = r1
            goto L18
        L13:
            io.ktor.client.plugins.HttpCallValidator$validateResponse$1 r0 = new io.ktor.client.plugins.HttpCallValidator$validateResponse$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f46311h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f46313j
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.f46310g
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r2 = r0.f46309f
            io.ktor.client.statement.HttpResponse r2 = (io.ktor.client.statement.HttpResponse) r2
            kotlin.ResultKt.b(r7)
            r7 = r2
            goto L46
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.ResultKt.b(r7)
            java.util.List<kotlin.jvm.functions.Function2<io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object>> r7 = r5.f46284a
            java.util.Iterator r7 = r7.iterator()
            r4 = r7
            r7 = r6
            r6 = r4
        L46:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L5f
            java.lang.Object r2 = r6.next()
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.f46309f = r7
            r0.f46310g = r6
            r0.f46313j = r3
            java.lang.Object r2 = r2.s(r7, r0)
            if (r2 != r1) goto L46
            return r1
        L5f:
            kotlin.Unit r6 = kotlin.Unit.f50853a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpCallValidator.f(io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
