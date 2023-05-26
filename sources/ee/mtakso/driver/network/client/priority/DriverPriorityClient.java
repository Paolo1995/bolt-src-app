package ee.mtakso.driver.network.client.priority;

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

/* compiled from: DriverPriorityClient.kt */
/* loaded from: classes3.dex */
public final class DriverPriorityClient {

    /* renamed from: a  reason: collision with root package name */
    private final ShardApiProvider f22670a;

    /* renamed from: b  reason: collision with root package name */
    private final ResponseErrorProcessor f22671b;

    @Inject
    public DriverPriorityClient(ShardApiProvider apiProvider, ResponseErrorProcessor errorResponseProcessor) {
        Intrinsics.f(apiProvider, "apiProvider");
        Intrinsics.f(errorResponseProcessor, "errorResponseProcessor");
        this.f22670a = apiProvider;
        this.f22671b = errorResponseProcessor;
    }

    private final DriverPriorityApi d() {
        return this.f22670a.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DriverPriorityResponse g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (DriverPriorityResponse) tmp0.invoke(obj);
    }

    public final Single<DriverPriorityResponse> e() {
        Single<ServerResponse<DriverPriorityResponse>> a8 = d().a();
        final Function1<ServerResponse<DriverPriorityResponse>, Unit> function1 = new Function1<ServerResponse<DriverPriorityResponse>, Unit>() { // from class: ee.mtakso.driver.network.client.priority.DriverPriorityClient$getPriorityOverview$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ServerResponse<DriverPriorityResponse> serverResponse) {
                ResponseErrorProcessor responseErrorProcessor;
                responseErrorProcessor = DriverPriorityClient.this.f22671b;
                responseErrorProcessor.c(serverResponse);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ServerResponse<DriverPriorityResponse> serverResponse) {
                b(serverResponse);
                return Unit.f50853a;
            }
        };
        Single<ServerResponse<DriverPriorityResponse>> o8 = a8.o(new Consumer() { // from class: ee.mtakso.driver.network.client.priority.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverPriorityClient.f(Function1.this, obj);
            }
        });
        final DriverPriorityClient$getPriorityOverview$2 driverPriorityClient$getPriorityOverview$2 = new Function1<ServerResponse<DriverPriorityResponse>, DriverPriorityResponse>() { // from class: ee.mtakso.driver.network.client.priority.DriverPriorityClient$getPriorityOverview$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final DriverPriorityResponse invoke(ServerResponse<DriverPriorityResponse> it) {
                Intrinsics.f(it, "it");
                return (DriverPriorityResponse) ServerResponseKt.b(it);
            }
        };
        Single x7 = o8.x(new Function() { // from class: ee.mtakso.driver.network.client.priority.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DriverPriorityResponse g8;
                g8 = DriverPriorityClient.g(Function1.this, obj);
                return g8;
            }
        });
        Intrinsics.e(x7, "fun getPriorityOverview(… .map { it.exposeData() }");
        return x7;
    }
}
