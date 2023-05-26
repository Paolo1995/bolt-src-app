package ee.mtakso.driver.network.client.dashboard;

import ee.mtakso.driver.network.client.ShardApiProvider;
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

/* compiled from: DashboardClient.kt */
/* loaded from: classes3.dex */
public final class DashboardClient {

    /* renamed from: a  reason: collision with root package name */
    private final ShardApiProvider f21818a;

    /* renamed from: b  reason: collision with root package name */
    private final ResponseErrorProcessor f21819b;

    @Inject
    public DashboardClient(ShardApiProvider apiProvider, ResponseErrorProcessor errorResponseProcessor) {
        Intrinsics.f(apiProvider, "apiProvider");
        Intrinsics.f(errorResponseProcessor, "errorResponseProcessor");
        this.f21818a = apiProvider;
        this.f21819b = errorResponseProcessor;
    }

    private final DashboardApi d() {
        return this.f21818a.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DriverHomeScreenResponse g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (DriverHomeScreenResponse) tmp0.invoke(obj);
    }

    public final Single<DriverHomeScreenResponse> e() {
        Single<ServerResponse<DriverHomeScreenResponse>> a8 = d().a();
        final Function1<ServerResponse<DriverHomeScreenResponse>, Unit> function1 = new Function1<ServerResponse<DriverHomeScreenResponse>, Unit>() { // from class: ee.mtakso.driver.network.client.dashboard.DashboardClient$getDriverDashboard$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ServerResponse<DriverHomeScreenResponse> serverResponse) {
                ResponseErrorProcessor responseErrorProcessor;
                responseErrorProcessor = DashboardClient.this.f21819b;
                responseErrorProcessor.c(serverResponse);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ServerResponse<DriverHomeScreenResponse> serverResponse) {
                b(serverResponse);
                return Unit.f50853a;
            }
        };
        Single<ServerResponse<DriverHomeScreenResponse>> o8 = a8.o(new Consumer() { // from class: ee.mtakso.driver.network.client.dashboard.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DashboardClient.f(Function1.this, obj);
            }
        });
        final DashboardClient$getDriverDashboard$2 dashboardClient$getDriverDashboard$2 = new Function1<ServerResponse<DriverHomeScreenResponse>, DriverHomeScreenResponse>() { // from class: ee.mtakso.driver.network.client.dashboard.DashboardClient$getDriverDashboard$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final DriverHomeScreenResponse invoke(ServerResponse<DriverHomeScreenResponse> it) {
                Intrinsics.f(it, "it");
                return (DriverHomeScreenResponse) ServerResponseKt.b(it);
            }
        };
        Single x7 = o8.x(new Function() { // from class: ee.mtakso.driver.network.client.dashboard.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DriverHomeScreenResponse g8;
                g8 = DashboardClient.g(Function1.this, obj);
                return g8;
            }
        });
        Intrinsics.e(x7, "fun getDriverDashboard()…{ it.exposeData() }\n    }");
        return x7;
    }
}
