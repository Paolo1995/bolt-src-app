package io.ktor.client.plugins.observer;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.AttributeKey;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResponseObserver.kt */
/* loaded from: classes5.dex */
public final class ResponseObserver {

    /* renamed from: c  reason: collision with root package name */
    public static final Plugin f46586c = new Plugin(null);

    /* renamed from: d  reason: collision with root package name */
    private static final AttributeKey<ResponseObserver> f46587d = new AttributeKey<>("BodyInterceptor");

    /* renamed from: a  reason: collision with root package name */
    private final Function2<HttpResponse, Continuation<? super Unit>, Object> f46588a;

    /* renamed from: b  reason: collision with root package name */
    private final Function1<HttpClientCall, Boolean> f46589b;

    /* compiled from: ResponseObserver.kt */
    /* loaded from: classes5.dex */
    public static final class Config {

        /* renamed from: a  reason: collision with root package name */
        private Function2<? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object> f46590a = new ResponseObserver$Config$responseHandler$1(null);

        /* renamed from: b  reason: collision with root package name */
        private Function1<? super HttpClientCall, Boolean> f46591b;

        public final Function1<HttpClientCall, Boolean> a() {
            return this.f46591b;
        }

        public final Function2<HttpResponse, Continuation<? super Unit>, Object> b() {
            return this.f46590a;
        }
    }

    /* compiled from: ResponseObserver.kt */
    /* loaded from: classes5.dex */
    public static final class Plugin implements HttpClientPlugin<Config, ResponseObserver> {
        private Plugin() {
        }

        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        /* renamed from: c */
        public void a(ResponseObserver plugin, HttpClient scope) {
            Intrinsics.f(plugin, "plugin");
            Intrinsics.f(scope, "scope");
            scope.h().l(HttpReceivePipeline.f46657h.a(), new ResponseObserver$Plugin$install$1(plugin, scope, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        /* renamed from: d */
        public ResponseObserver b(Function1<? super Config, Unit> block) {
            Intrinsics.f(block, "block");
            Config config = new Config();
            block.invoke(config);
            return new ResponseObserver(config.b(), config.a());
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<ResponseObserver> getKey() {
            return ResponseObserver.f46587d;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ResponseObserver(Function2<? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object> responseHandler, Function1<? super HttpClientCall, Boolean> function1) {
        Intrinsics.f(responseHandler, "responseHandler");
        this.f46588a = responseHandler;
        this.f46589b = function1;
    }

    public /* synthetic */ ResponseObserver(Function2 function2, Function1 function1, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(function2, (i8 & 2) != 0 ? null : function1);
    }
}
