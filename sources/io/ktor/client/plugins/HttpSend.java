package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.util.AttributeKey;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpSend.kt */
/* loaded from: classes5.dex */
public final class HttpSend {

    /* renamed from: c  reason: collision with root package name */
    public static final Plugin f46370c = new Plugin(null);

    /* renamed from: d  reason: collision with root package name */
    private static final AttributeKey<HttpSend> f46371d = new AttributeKey<>("HttpSend");

    /* renamed from: a  reason: collision with root package name */
    private final int f46372a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Function3<Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object>> f46373b;

    /* compiled from: HttpSend.kt */
    /* loaded from: classes5.dex */
    public static final class Config {

        /* renamed from: a  reason: collision with root package name */
        private int f46374a = 20;

        public final int a() {
            return this.f46374a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpSend.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultSender implements Sender {

        /* renamed from: a  reason: collision with root package name */
        private final int f46375a;

        /* renamed from: b  reason: collision with root package name */
        private final HttpClient f46376b;

        /* renamed from: c  reason: collision with root package name */
        private int f46377c;

        /* renamed from: d  reason: collision with root package name */
        private HttpClientCall f46378d;

        public DefaultSender(int i8, HttpClient client) {
            Intrinsics.f(client, "client");
            this.f46375a = i8;
            this.f46376b = client;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x006b  */
        @Override // io.ktor.client.plugins.Sender
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object a(io.ktor.client.request.HttpRequestBuilder r6, kotlin.coroutines.Continuation<? super io.ktor.client.call.HttpClientCall> r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof io.ktor.client.plugins.HttpSend$DefaultSender$execute$1
                if (r0 == 0) goto L13
                r0 = r7
                io.ktor.client.plugins.HttpSend$DefaultSender$execute$1 r0 = (io.ktor.client.plugins.HttpSend$DefaultSender$execute$1) r0
                int r1 = r0.f46382i
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f46382i = r1
                goto L18
            L13:
                io.ktor.client.plugins.HttpSend$DefaultSender$execute$1 r0 = new io.ktor.client.plugins.HttpSend$DefaultSender$execute$1
                r0.<init>(r5, r7)
            L18:
                java.lang.Object r7 = r0.f46380g
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                int r2 = r0.f46382i
                r3 = 0
                r4 = 1
                if (r2 == 0) goto L36
                if (r2 != r4) goto L2e
                java.lang.Object r6 = r0.f46379f
                io.ktor.client.plugins.HttpSend$DefaultSender r6 = (io.ktor.client.plugins.HttpSend.DefaultSender) r6
                kotlin.ResultKt.b(r7)
                goto L5f
            L2e:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L36:
                kotlin.ResultKt.b(r7)
                io.ktor.client.call.HttpClientCall r7 = r5.f46378d
                if (r7 == 0) goto L40
                kotlinx.coroutines.CoroutineScopeKt.d(r7, r3, r4, r3)
            L40:
                int r7 = r5.f46377c
                int r2 = r5.f46375a
                if (r7 >= r2) goto L86
                int r7 = r7 + r4
                r5.f46377c = r7
                io.ktor.client.HttpClient r7 = r5.f46376b
                io.ktor.client.request.HttpSendPipeline r7 = r7.m()
                java.lang.Object r2 = r6.c()
                r0.f46379f = r5
                r0.f46382i = r4
                java.lang.Object r7 = r7.d(r6, r2, r0)
                if (r7 != r1) goto L5e
                return r1
            L5e:
                r6 = r5
            L5f:
                boolean r0 = r7 instanceof io.ktor.client.call.HttpClientCall
                if (r0 == 0) goto L66
                r3 = r7
                io.ktor.client.call.HttpClientCall r3 = (io.ktor.client.call.HttpClientCall) r3
            L66:
                if (r3 == 0) goto L6b
                r6.f46378d = r3
                return r3
            L6b:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r0 = "Failed to execute send pipeline. Expected [HttpClientCall], but received "
                r6.append(r0)
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r6 = r6.toString()
                r7.<init>(r6)
                throw r7
            L86:
                io.ktor.client.plugins.SendCountExceedException r6 = new io.ktor.client.plugins.SendCountExceedException
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r0 = "Max send count "
                r7.append(r0)
                int r0 = r5.f46375a
                r7.append(r0)
                java.lang.String r0 = " exceeded. Consider increasing the property maxSendCount if more is required."
                r7.append(r0)
                java.lang.String r7 = r7.toString()
                r6.<init>(r7)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpSend.DefaultSender.a(io.ktor.client.request.HttpRequestBuilder, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpSend.kt */
    /* loaded from: classes5.dex */
    public static final class InterceptedSender implements Sender {

        /* renamed from: a  reason: collision with root package name */
        private final Function3<Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> f46383a;

        /* renamed from: b  reason: collision with root package name */
        private final Sender f46384b;

        /* JADX WARN: Multi-variable type inference failed */
        public InterceptedSender(Function3<? super Sender, ? super HttpRequestBuilder, ? super Continuation<? super HttpClientCall>, ? extends Object> interceptor, Sender nextSender) {
            Intrinsics.f(interceptor, "interceptor");
            Intrinsics.f(nextSender, "nextSender");
            this.f46383a = interceptor;
            this.f46384b = nextSender;
        }

        @Override // io.ktor.client.plugins.Sender
        public Object a(HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpClientCall> continuation) {
            return this.f46383a.l(this.f46384b, httpRequestBuilder, continuation);
        }
    }

    /* compiled from: HttpSend.kt */
    /* loaded from: classes5.dex */
    public static final class Plugin implements HttpClientPlugin<Config, HttpSend> {
        private Plugin() {
        }

        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        /* renamed from: c */
        public void a(HttpSend plugin, HttpClient scope) {
            Intrinsics.f(plugin, "plugin");
            Intrinsics.f(scope, "scope");
            scope.k().l(HttpRequestPipeline.f46627h.c(), new HttpSend$Plugin$install$1(plugin, scope, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        /* renamed from: d */
        public HttpSend b(Function1<? super Config, Unit> block) {
            Intrinsics.f(block, "block");
            Config config = new Config();
            block.invoke(config);
            return new HttpSend(config.a(), null);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<HttpSend> getKey() {
            return HttpSend.f46371d;
        }
    }

    private HttpSend(int i8) {
        this.f46372a = i8;
        this.f46373b = new ArrayList();
    }

    public /* synthetic */ HttpSend(int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(i8);
    }

    public final void d(Function3<? super Sender, ? super HttpRequestBuilder, ? super Continuation<? super HttpClientCall>, ? extends Object> block) {
        Intrinsics.f(block, "block");
        this.f46373b.add(block);
    }
}
