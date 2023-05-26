package ee.mtakso.driver.network.client.support;

import dagger.Lazy;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.response.ResponseErrorProcessor;
import ee.mtakso.driver.network.response.ServerResponse;
import ee.mtakso.driver.network.response.ServerResponseKt;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SupportClient.kt */
/* loaded from: classes3.dex */
public final class SupportClient {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy<SupportApi> f22844a;

    /* renamed from: b  reason: collision with root package name */
    private final ResponseErrorProcessor f22845b;

    @Inject
    public SupportClient(Lazy<SupportApi> api, ResponseErrorProcessor errorResponseProcessor) {
        Intrinsics.f(api, "api");
        Intrinsics.f(errorResponseProcessor, "errorResponseProcessor");
        this.f22844a = api;
        this.f22845b = errorResponseProcessor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SupportWebAppLinkResponse l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SupportWebAppLinkResponse) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SupportWebAppLinkResponse o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SupportWebAppLinkResponse) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SupportWebAppLinkResponse r(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SupportWebAppLinkResponse) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SupportWebAppLinkResponse u(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SupportWebAppLinkResponse) tmp0.invoke(obj);
    }

    public final Single<SupportWebAppLinkResponse> j() {
        Single<ServerResponse<SupportWebAppLinkResponse>> a8 = this.f22844a.get().a();
        final Function1<ServerResponse<SupportWebAppLinkResponse>, Unit> function1 = new Function1<ServerResponse<SupportWebAppLinkResponse>, Unit>() { // from class: ee.mtakso.driver.network.client.support.SupportClient$getSupportWebAppLinkForInbox$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ServerResponse<SupportWebAppLinkResponse> serverResponse) {
                ResponseErrorProcessor responseErrorProcessor;
                responseErrorProcessor = SupportClient.this.f22845b;
                responseErrorProcessor.c(serverResponse);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ServerResponse<SupportWebAppLinkResponse> serverResponse) {
                b(serverResponse);
                return Unit.f50853a;
            }
        };
        Single<ServerResponse<SupportWebAppLinkResponse>> o8 = a8.o(new Consumer() { // from class: ee.mtakso.driver.network.client.support.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SupportClient.k(Function1.this, obj);
            }
        });
        final SupportClient$getSupportWebAppLinkForInbox$2 supportClient$getSupportWebAppLinkForInbox$2 = new Function1<ServerResponse<SupportWebAppLinkResponse>, SupportWebAppLinkResponse>() { // from class: ee.mtakso.driver.network.client.support.SupportClient$getSupportWebAppLinkForInbox$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SupportWebAppLinkResponse invoke(ServerResponse<SupportWebAppLinkResponse> it) {
                Intrinsics.f(it, "it");
                return (SupportWebAppLinkResponse) ServerResponseKt.b(it);
            }
        };
        Single x7 = o8.x(new Function() { // from class: ee.mtakso.driver.network.client.support.h
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SupportWebAppLinkResponse l8;
                l8 = SupportClient.l(Function1.this, obj);
                return l8;
            }
        });
        Intrinsics.e(x7, "fun getSupportWebAppLink…{ it.exposeData() }\n    }");
        return x7;
    }

    public final Single<SupportWebAppLinkResponse> m(String webAppLaunchToken) {
        Intrinsics.f(webAppLaunchToken, "webAppLaunchToken");
        Single<ServerResponse<SupportWebAppLinkResponse>> c8 = this.f22844a.get().c(webAppLaunchToken);
        final Function1<ServerResponse<SupportWebAppLinkResponse>, Unit> function1 = new Function1<ServerResponse<SupportWebAppLinkResponse>, Unit>() { // from class: ee.mtakso.driver.network.client.support.SupportClient$getSupportWebAppLinkForPush$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ServerResponse<SupportWebAppLinkResponse> serverResponse) {
                ResponseErrorProcessor responseErrorProcessor;
                responseErrorProcessor = SupportClient.this.f22845b;
                responseErrorProcessor.c(serverResponse);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ServerResponse<SupportWebAppLinkResponse> serverResponse) {
                b(serverResponse);
                return Unit.f50853a;
            }
        };
        Single<ServerResponse<SupportWebAppLinkResponse>> o8 = c8.o(new Consumer() { // from class: ee.mtakso.driver.network.client.support.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SupportClient.n(Function1.this, obj);
            }
        });
        final SupportClient$getSupportWebAppLinkForPush$2 supportClient$getSupportWebAppLinkForPush$2 = new Function1<ServerResponse<SupportWebAppLinkResponse>, SupportWebAppLinkResponse>() { // from class: ee.mtakso.driver.network.client.support.SupportClient$getSupportWebAppLinkForPush$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SupportWebAppLinkResponse invoke(ServerResponse<SupportWebAppLinkResponse> it) {
                Intrinsics.f(it, "it");
                return (SupportWebAppLinkResponse) ServerResponseKt.b(it);
            }
        };
        Single x7 = o8.x(new Function() { // from class: ee.mtakso.driver.network.client.support.f
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SupportWebAppLinkResponse o9;
                o9 = SupportClient.o(Function1.this, obj);
                return o9;
            }
        });
        Intrinsics.e(x7, "fun getSupportWebAppLink…{ it.exposeData() }\n    }");
        return x7;
    }

    public final Single<SupportWebAppLinkResponse> p(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        Single<ServerResponse<SupportWebAppLinkResponse>> d8 = this.f22844a.get().d(orderHandle.c(), orderHandle.a(), orderHandle.b());
        final Function1<ServerResponse<SupportWebAppLinkResponse>, Unit> function1 = new Function1<ServerResponse<SupportWebAppLinkResponse>, Unit>() { // from class: ee.mtakso.driver.network.client.support.SupportClient$getSupportWebAppLinkForRideDetails$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ServerResponse<SupportWebAppLinkResponse> serverResponse) {
                ResponseErrorProcessor responseErrorProcessor;
                responseErrorProcessor = SupportClient.this.f22845b;
                responseErrorProcessor.c(serverResponse);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ServerResponse<SupportWebAppLinkResponse> serverResponse) {
                b(serverResponse);
                return Unit.f50853a;
            }
        };
        Single<ServerResponse<SupportWebAppLinkResponse>> o8 = d8.o(new Consumer() { // from class: ee.mtakso.driver.network.client.support.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SupportClient.q(Function1.this, obj);
            }
        });
        final SupportClient$getSupportWebAppLinkForRideDetails$2 supportClient$getSupportWebAppLinkForRideDetails$2 = new Function1<ServerResponse<SupportWebAppLinkResponse>, SupportWebAppLinkResponse>() { // from class: ee.mtakso.driver.network.client.support.SupportClient$getSupportWebAppLinkForRideDetails$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SupportWebAppLinkResponse invoke(ServerResponse<SupportWebAppLinkResponse> it) {
                Intrinsics.f(it, "it");
                return (SupportWebAppLinkResponse) ServerResponseKt.b(it);
            }
        };
        Single x7 = o8.x(new Function() { // from class: ee.mtakso.driver.network.client.support.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SupportWebAppLinkResponse r7;
                r7 = SupportClient.r(Function1.this, obj);
                return r7;
            }
        });
        Intrinsics.e(x7, "fun getSupportWebAppLink…{ it.exposeData() }\n    }");
        return x7;
    }

    public final Single<SupportWebAppLinkResponse> s() {
        Single<ServerResponse<SupportWebAppLinkResponse>> b8 = this.f22844a.get().b();
        final Function1<ServerResponse<SupportWebAppLinkResponse>, Unit> function1 = new Function1<ServerResponse<SupportWebAppLinkResponse>, Unit>() { // from class: ee.mtakso.driver.network.client.support.SupportClient$getSupportWebAppLinkForSettings$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ServerResponse<SupportWebAppLinkResponse> serverResponse) {
                ResponseErrorProcessor responseErrorProcessor;
                responseErrorProcessor = SupportClient.this.f22845b;
                responseErrorProcessor.c(serverResponse);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ServerResponse<SupportWebAppLinkResponse> serverResponse) {
                b(serverResponse);
                return Unit.f50853a;
            }
        };
        Single<ServerResponse<SupportWebAppLinkResponse>> o8 = b8.o(new Consumer() { // from class: ee.mtakso.driver.network.client.support.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SupportClient.t(Function1.this, obj);
            }
        });
        final SupportClient$getSupportWebAppLinkForSettings$2 supportClient$getSupportWebAppLinkForSettings$2 = new Function1<ServerResponse<SupportWebAppLinkResponse>, SupportWebAppLinkResponse>() { // from class: ee.mtakso.driver.network.client.support.SupportClient$getSupportWebAppLinkForSettings$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SupportWebAppLinkResponse invoke(ServerResponse<SupportWebAppLinkResponse> it) {
                Intrinsics.f(it, "it");
                return (SupportWebAppLinkResponse) ServerResponseKt.b(it);
            }
        };
        Single x7 = o8.x(new Function() { // from class: ee.mtakso.driver.network.client.support.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SupportWebAppLinkResponse u7;
                u7 = SupportClient.u(Function1.this, obj);
                return u7;
            }
        });
        Intrinsics.e(x7, "fun getSupportWebAppLink…{ it.exposeData() }\n    }");
        return x7;
    }
}
