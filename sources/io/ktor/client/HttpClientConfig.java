package io.ktor.client;

import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.PlatformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpClientConfig.kt */
/* loaded from: classes5.dex */
public final class HttpClientConfig<T extends HttpClientEngineConfig> {

    /* renamed from: g */
    private boolean f46061g;

    /* renamed from: a */
    private final Map<AttributeKey<?>, Function1<HttpClient, Unit>> f46055a = new LinkedHashMap();

    /* renamed from: b */
    private final Map<AttributeKey<?>, Function1<Object, Unit>> f46056b = new LinkedHashMap();

    /* renamed from: c */
    private final Map<String, Function1<HttpClient, Unit>> f46057c = new LinkedHashMap();

    /* renamed from: d */
    private Function1<? super T, Unit> f46058d = new Function1<T, Unit>() { // from class: io.ktor.client.HttpClientConfig$engineConfig$1
        /* JADX WARN: Incorrect types in method signature: (TT;)V */
        public final void b(HttpClientEngineConfig httpClientEngineConfig) {
            Intrinsics.f(httpClientEngineConfig, "$this$null");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            b((HttpClientEngineConfig) obj);
            return Unit.f50853a;
        }
    };

    /* renamed from: e */
    private boolean f46059e = true;

    /* renamed from: f */
    private boolean f46060f = true;

    /* renamed from: h */
    private boolean f46062h = PlatformUtils.f47049a.b();

    public static /* synthetic */ void i(HttpClientConfig httpClientConfig, HttpClientPlugin httpClientPlugin, Function1 function1, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.HttpClientConfig$install$1
                public final void b(Object obj2) {
                    Intrinsics.f(obj2, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    b(obj2);
                    return Unit.f50853a;
                }
            };
        }
        httpClientConfig.g(httpClientPlugin, function1);
    }

    public final boolean b() {
        return this.f46062h;
    }

    public final boolean c() {
        return this.f46061g;
    }

    public final boolean d() {
        return this.f46059e;
    }

    public final boolean e() {
        return this.f46060f;
    }

    public final void f(HttpClient client) {
        Intrinsics.f(client, "client");
        Iterator<T> it = this.f46055a.values().iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(client);
        }
        Iterator<T> it2 = this.f46057c.values().iterator();
        while (it2.hasNext()) {
            ((Function1) it2.next()).invoke(client);
        }
    }

    public final <TBuilder, TPlugin> void g(final HttpClientPlugin<? extends TBuilder, TPlugin> plugin, final Function1<? super TBuilder, Unit> configure) {
        Intrinsics.f(plugin, "plugin");
        Intrinsics.f(configure, "configure");
        final Function1<Object, Unit> function1 = this.f46056b.get(plugin.getKey());
        this.f46056b.put(plugin.getKey(), new Function1<Object, Unit>() { // from class: io.ktor.client.HttpClientConfig$install$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final void b(Object obj) {
                Intrinsics.f(obj, "$this$null");
                Function1<Object, Unit> function12 = function1;
                if (function12 != null) {
                    function12.invoke(obj);
                }
                configure.invoke(obj);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                b(obj);
                return Unit.f50853a;
            }
        });
        if (this.f46055a.containsKey(plugin.getKey())) {
            return;
        }
        this.f46055a.put(plugin.getKey(), new Function1<HttpClient, Unit>() { // from class: io.ktor.client.HttpClientConfig$install$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final void b(HttpClient scope) {
                Map map;
                Intrinsics.f(scope, "scope");
                map = ((HttpClientConfig) scope.c()).f46056b;
                Object obj = map.get(plugin.getKey());
                Intrinsics.c(obj);
                Object b8 = plugin.b((Function1) obj);
                plugin.a(b8, scope);
                ((Attributes) scope.getAttributes().g(HttpClientPluginKt.a(), new Function0<Attributes>() { // from class: io.ktor.client.HttpClientConfig$install$3$attributes$1
                    @Override // kotlin.jvm.functions.Function0
                    /* renamed from: b */
                    public final Attributes invoke() {
                        return AttributesJvmKt.a(true);
                    }
                })).b(plugin.getKey(), b8);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpClient httpClient) {
                b(httpClient);
                return Unit.f50853a;
            }
        });
    }

    public final void h(String key, Function1<? super HttpClient, Unit> block) {
        Intrinsics.f(key, "key");
        Intrinsics.f(block, "block");
        this.f46057c.put(key, block);
    }

    public final void j(HttpClientConfig<? extends T> other) {
        Intrinsics.f(other, "other");
        this.f46059e = other.f46059e;
        this.f46060f = other.f46060f;
        this.f46061g = other.f46061g;
        this.f46055a.putAll(other.f46055a);
        this.f46056b.putAll(other.f46056b);
        this.f46057c.putAll(other.f46057c);
    }
}
