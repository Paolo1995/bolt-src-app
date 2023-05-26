package io.ktor.client.engine.okhttp;

import io.ktor.client.engine.HttpClientEngineConfig;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.WebSocket;

/* compiled from: OkHttpConfig.kt */
/* loaded from: classes5.dex */
public final class OkHttpConfig extends HttpClientEngineConfig {

    /* renamed from: d  reason: collision with root package name */
    private OkHttpClient f46148d;

    /* renamed from: f  reason: collision with root package name */
    private WebSocket.Factory f46150f;

    /* renamed from: c  reason: collision with root package name */
    private Function1<? super OkHttpClient.Builder, Unit> f46147c = new Function1<OkHttpClient.Builder, Unit>() { // from class: io.ktor.client.engine.okhttp.OkHttpConfig$config$1
        public final void b(OkHttpClient.Builder builder) {
            Intrinsics.f(builder, "$this$null");
            builder.followRedirects(false);
            builder.followSslRedirects(false);
            builder.retryOnConnectionFailure(true);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(OkHttpClient.Builder builder) {
            b(builder);
            return Unit.f50853a;
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private int f46149e = 10;

    public final int c() {
        return this.f46149e;
    }

    public final Function1<OkHttpClient.Builder, Unit> d() {
        return this.f46147c;
    }

    public final OkHttpClient e() {
        return this.f46148d;
    }

    public final WebSocket.Factory f() {
        return this.f46150f;
    }
}
