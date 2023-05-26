package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpResponse;
import io.ktor.events.EventDefinition;
import io.ktor.util.AttributeKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpRedirect.kt */
/* loaded from: classes5.dex */
public final class HttpRedirect {

    /* renamed from: c  reason: collision with root package name */
    public static final Plugin f46338c = new Plugin(null);

    /* renamed from: d  reason: collision with root package name */
    private static final AttributeKey<HttpRedirect> f46339d = new AttributeKey<>("HttpRedirect");

    /* renamed from: e  reason: collision with root package name */
    private static final EventDefinition<HttpResponse> f46340e = new EventDefinition<>();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f46341a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f46342b;

    /* compiled from: HttpRedirect.kt */
    /* loaded from: classes5.dex */
    public static final class Config {

        /* renamed from: a  reason: collision with root package name */
        private boolean f46343a = true;

        /* renamed from: b  reason: collision with root package name */
        private boolean f46344b;

        public final boolean a() {
            return this.f46344b;
        }

        public final boolean b() {
            return this.f46343a;
        }
    }

    /* compiled from: HttpRedirect.kt */
    /* loaded from: classes5.dex */
    public static final class Plugin implements HttpClientPlugin<Config, HttpRedirect> {
        private Plugin() {
        }

        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00ef  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x011d  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0144 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0145  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0163  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0166  */
        /* JADX WARN: Type inference failed for: r14v4, types: [T, io.ktor.client.request.HttpRequestBuilder] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0145 -> B:35:0x014f). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object e(io.ktor.client.plugins.Sender r18, io.ktor.client.request.HttpRequestBuilder r19, io.ktor.client.call.HttpClientCall r20, boolean r21, io.ktor.client.HttpClient r22, kotlin.coroutines.Continuation<? super io.ktor.client.call.HttpClientCall> r23) {
            /*
                Method dump skipped, instructions count: 365
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpRedirect.Plugin.e(io.ktor.client.plugins.Sender, io.ktor.client.request.HttpRequestBuilder, io.ktor.client.call.HttpClientCall, boolean, io.ktor.client.HttpClient, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public final EventDefinition<HttpResponse> d() {
            return HttpRedirect.f46340e;
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        /* renamed from: f */
        public void a(HttpRedirect plugin, HttpClient scope) {
            Intrinsics.f(plugin, "plugin");
            Intrinsics.f(scope, "scope");
            ((HttpSend) HttpClientPluginKt.b(scope, HttpSend.f46370c)).d(new HttpRedirect$Plugin$install$1(plugin, scope, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        /* renamed from: g */
        public HttpRedirect b(Function1<? super Config, Unit> block) {
            Intrinsics.f(block, "block");
            Config config = new Config();
            block.invoke(config);
            return new HttpRedirect(config.b(), config.a(), null);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<HttpRedirect> getKey() {
            return HttpRedirect.f46339d;
        }
    }

    private HttpRedirect(boolean z7, boolean z8) {
        this.f46341a = z7;
        this.f46342b = z8;
    }

    public /* synthetic */ HttpRedirect(boolean z7, boolean z8, DefaultConstructorMarker defaultConstructorMarker) {
        this(z7, z8);
    }
}
