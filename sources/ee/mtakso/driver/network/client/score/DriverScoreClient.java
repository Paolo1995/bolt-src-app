package ee.mtakso.driver.network.client.score;

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

/* compiled from: DriverScoreClient.kt */
/* loaded from: classes3.dex */
public final class DriverScoreClient {

    /* renamed from: a  reason: collision with root package name */
    private final DriverScoreApi f22713a;

    /* renamed from: b  reason: collision with root package name */
    private final ResponseErrorProcessor f22714b;

    @Inject
    public DriverScoreClient(DriverScoreApi driverScoreApi, ResponseErrorProcessor errorResponseProcessor) {
        Intrinsics.f(driverScoreApi, "driverScoreApi");
        Intrinsics.f(errorResponseProcessor, "errorResponseProcessor");
        this.f22713a = driverScoreApi;
        this.f22714b = errorResponseProcessor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DriverScoreResponse j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (DriverScoreResponse) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DriverScoreExplanationResponse m(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (DriverScoreExplanationResponse) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DriverScoreOverviewResponse p(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (DriverScoreOverviewResponse) tmp0.invoke(obj);
    }

    public final Single<DriverScoreResponse> h() {
        Single<ServerResponse<DriverScoreResponse>> a8 = this.f22713a.a();
        final Function1<ServerResponse<DriverScoreResponse>, Unit> function1 = new Function1<ServerResponse<DriverScoreResponse>, Unit>() { // from class: ee.mtakso.driver.network.client.score.DriverScoreClient$getScore$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ServerResponse<DriverScoreResponse> serverResponse) {
                ResponseErrorProcessor responseErrorProcessor;
                responseErrorProcessor = DriverScoreClient.this.f22714b;
                responseErrorProcessor.c(serverResponse);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ServerResponse<DriverScoreResponse> serverResponse) {
                b(serverResponse);
                return Unit.f50853a;
            }
        };
        Single<ServerResponse<DriverScoreResponse>> o8 = a8.o(new Consumer() { // from class: ee.mtakso.driver.network.client.score.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverScoreClient.i(Function1.this, obj);
            }
        });
        final DriverScoreClient$getScore$2 driverScoreClient$getScore$2 = new Function1<ServerResponse<DriverScoreResponse>, DriverScoreResponse>() { // from class: ee.mtakso.driver.network.client.score.DriverScoreClient$getScore$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final DriverScoreResponse invoke(ServerResponse<DriverScoreResponse> it) {
                Intrinsics.f(it, "it");
                return (DriverScoreResponse) ServerResponseKt.b(it);
            }
        };
        Single x7 = o8.x(new Function() { // from class: ee.mtakso.driver.network.client.score.f
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DriverScoreResponse j8;
                j8 = DriverScoreClient.j(Function1.this, obj);
                return j8;
            }
        });
        Intrinsics.e(x7, "fun getScore(): Single<D…{ it.exposeData() }\n    }");
        return x7;
    }

    public final Single<DriverScoreExplanationResponse> k(String theme) {
        Intrinsics.f(theme, "theme");
        Single<ServerResponse<DriverScoreExplanationResponse>> c8 = this.f22713a.c(theme);
        final Function1<ServerResponse<DriverScoreExplanationResponse>, Unit> function1 = new Function1<ServerResponse<DriverScoreExplanationResponse>, Unit>() { // from class: ee.mtakso.driver.network.client.score.DriverScoreClient$getScoreExplanation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ServerResponse<DriverScoreExplanationResponse> serverResponse) {
                ResponseErrorProcessor responseErrorProcessor;
                responseErrorProcessor = DriverScoreClient.this.f22714b;
                responseErrorProcessor.c(serverResponse);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ServerResponse<DriverScoreExplanationResponse> serverResponse) {
                b(serverResponse);
                return Unit.f50853a;
            }
        };
        Single<ServerResponse<DriverScoreExplanationResponse>> o8 = c8.o(new Consumer() { // from class: ee.mtakso.driver.network.client.score.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverScoreClient.l(Function1.this, obj);
            }
        });
        final DriverScoreClient$getScoreExplanation$2 driverScoreClient$getScoreExplanation$2 = new Function1<ServerResponse<DriverScoreExplanationResponse>, DriverScoreExplanationResponse>() { // from class: ee.mtakso.driver.network.client.score.DriverScoreClient$getScoreExplanation$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final DriverScoreExplanationResponse invoke(ServerResponse<DriverScoreExplanationResponse> it) {
                Intrinsics.f(it, "it");
                return (DriverScoreExplanationResponse) ServerResponseKt.b(it);
            }
        };
        Single x7 = o8.x(new Function() { // from class: ee.mtakso.driver.network.client.score.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DriverScoreExplanationResponse m8;
                m8 = DriverScoreClient.m(Function1.this, obj);
                return m8;
            }
        });
        Intrinsics.e(x7, "fun getScoreExplanation(…{ it.exposeData() }\n    }");
        return x7;
    }

    public final Single<DriverScoreOverviewResponse> n() {
        Single<ServerResponse<DriverScoreOverviewResponse>> b8 = this.f22713a.b();
        final Function1<ServerResponse<DriverScoreOverviewResponse>, Unit> function1 = new Function1<ServerResponse<DriverScoreOverviewResponse>, Unit>() { // from class: ee.mtakso.driver.network.client.score.DriverScoreClient$getScoreOverview$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ServerResponse<DriverScoreOverviewResponse> serverResponse) {
                ResponseErrorProcessor responseErrorProcessor;
                responseErrorProcessor = DriverScoreClient.this.f22714b;
                responseErrorProcessor.c(serverResponse);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ServerResponse<DriverScoreOverviewResponse> serverResponse) {
                b(serverResponse);
                return Unit.f50853a;
            }
        };
        Single<ServerResponse<DriverScoreOverviewResponse>> o8 = b8.o(new Consumer() { // from class: ee.mtakso.driver.network.client.score.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverScoreClient.o(Function1.this, obj);
            }
        });
        final DriverScoreClient$getScoreOverview$2 driverScoreClient$getScoreOverview$2 = new Function1<ServerResponse<DriverScoreOverviewResponse>, DriverScoreOverviewResponse>() { // from class: ee.mtakso.driver.network.client.score.DriverScoreClient$getScoreOverview$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final DriverScoreOverviewResponse invoke(ServerResponse<DriverScoreOverviewResponse> it) {
                Intrinsics.f(it, "it");
                return (DriverScoreOverviewResponse) ServerResponseKt.b(it);
            }
        };
        Single x7 = o8.x(new Function() { // from class: ee.mtakso.driver.network.client.score.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DriverScoreOverviewResponse p8;
                p8 = DriverScoreClient.p(Function1.this, obj);
                return p8;
            }
        });
        Intrinsics.e(x7, "fun getScoreOverview(): …{ it.exposeData() }\n    }");
        return x7;
    }
}
