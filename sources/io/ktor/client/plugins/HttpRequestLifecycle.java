package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.util.AttributeKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpRequestLifecycle.kt */
/* loaded from: classes5.dex */
public final class HttpRequestLifecycle {

    /* renamed from: a  reason: collision with root package name */
    public static final Plugin f46363a = new Plugin(null);

    /* renamed from: b  reason: collision with root package name */
    private static final AttributeKey<HttpRequestLifecycle> f46364b = new AttributeKey<>("RequestLifecycle");

    /* compiled from: HttpRequestLifecycle.kt */
    /* loaded from: classes5.dex */
    public static final class Plugin implements HttpClientPlugin<Unit, HttpRequestLifecycle> {
        private Plugin() {
        }

        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        /* renamed from: c */
        public void a(HttpRequestLifecycle plugin, HttpClient scope) {
            Intrinsics.f(plugin, "plugin");
            Intrinsics.f(scope, "scope");
            scope.k().l(HttpRequestPipeline.f46627h.a(), new HttpRequestLifecycle$Plugin$install$1(scope, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        /* renamed from: d */
        public HttpRequestLifecycle b(Function1<? super Unit, Unit> block) {
            Intrinsics.f(block, "block");
            return new HttpRequestLifecycle(null);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<HttpRequestLifecycle> getKey() {
            return HttpRequestLifecycle.f46364b;
        }
    }

    private HttpRequestLifecycle() {
    }

    public /* synthetic */ HttpRequestLifecycle(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
