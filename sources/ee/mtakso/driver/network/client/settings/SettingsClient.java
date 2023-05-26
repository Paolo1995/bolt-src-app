package ee.mtakso.driver.network.client.settings;

import ee.mtakso.driver.network.client.ShardApiProvider;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import ee.mtakso.driver.network.response.DestinationServerResponse;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.network.response.ResponseErrorProcessor;
import ee.mtakso.driver.network.response.ServerResponse;
import ee.mtakso.driver.network.response.ServerResponseKt;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsClient.kt */
/* loaded from: classes3.dex */
public final class SettingsClient {

    /* renamed from: a  reason: collision with root package name */
    private final ShardApiProvider f22812a;

    /* renamed from: b  reason: collision with root package name */
    private final ResponseErrorProcessor f22813b;

    /* renamed from: c  reason: collision with root package name */
    private final CompositeResponseTransformer f22814c;

    @Inject
    public SettingsClient(ShardApiProvider apiProvider, ResponseErrorProcessor errorResponseProcessor, CompositeResponseTransformer regularTransformer) {
        Intrinsics.f(apiProvider, "apiProvider");
        Intrinsics.f(errorResponseProcessor, "errorResponseProcessor");
        Intrinsics.f(regularTransformer, "regularTransformer");
        this.f22812a = apiProvider;
        this.f22813b = errorResponseProcessor;
        this.f22814c = regularTransformer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DriverDestinationId j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (DriverDestinationId) tmp0.invoke(obj);
    }

    private final SettingsApi l() {
        return this.f22812a.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional p(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DriverDestinationId t(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (DriverDestinationId) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional w(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    public final Single<DriverDestinationId> i(String type, String str, String address, double d8, double d9) {
        Intrinsics.f(type, "type");
        Intrinsics.f(address, "address");
        Single<DestinationServerResponse<DriverDestinationId>> b8 = l().b(type, str, address, d8, d9);
        final SettingsClient$addDriverDestination$1 settingsClient$addDriverDestination$1 = new Function1<DestinationServerResponse<DriverDestinationId>, DriverDestinationId>() { // from class: ee.mtakso.driver.network.client.settings.SettingsClient$addDriverDestination$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final DriverDestinationId invoke(DestinationServerResponse<DriverDestinationId> it) {
                Intrinsics.f(it, "it");
                return (DriverDestinationId) ServerResponseKt.a(it);
            }
        };
        Single<DriverDestinationId> K = b8.x(new Function() { // from class: ee.mtakso.driver.network.client.settings.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DriverDestinationId j8;
                j8 = SettingsClient.j(Function1.this, obj);
                return j8;
            }
        }).K(Schedulers.c());
        Intrinsics.e(K, "api.addDriverDestination…scribeOn(Schedulers.io())");
        return K;
    }

    public final Single<EmptyServerResponse> k(long j8) {
        return l().e(j8);
    }

    public final Single<DriverDestinations> m() {
        return SingleExtKt.g(l().f(), this.f22814c);
    }

    public final Single<Optional<SettingsResponse>> n() {
        Single<ServerResponse<SettingsResponse>> c8 = l().c();
        final Function1<ServerResponse<SettingsResponse>, Unit> function1 = new Function1<ServerResponse<SettingsResponse>, Unit>() { // from class: ee.mtakso.driver.network.client.settings.SettingsClient$getSettings$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ServerResponse<SettingsResponse> serverResponse) {
                ResponseErrorProcessor responseErrorProcessor;
                responseErrorProcessor = SettingsClient.this.f22813b;
                responseErrorProcessor.c(serverResponse);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ServerResponse<SettingsResponse> serverResponse) {
                b(serverResponse);
                return Unit.f50853a;
            }
        };
        Single<ServerResponse<SettingsResponse>> o8 = c8.o(new Consumer() { // from class: ee.mtakso.driver.network.client.settings.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SettingsClient.o(Function1.this, obj);
            }
        });
        final SettingsClient$getSettings$2 settingsClient$getSettings$2 = new Function1<ServerResponse<SettingsResponse>, Optional<SettingsResponse>>() { // from class: ee.mtakso.driver.network.client.settings.SettingsClient$getSettings$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<SettingsResponse> invoke(ServerResponse<SettingsResponse> it) {
                Intrinsics.f(it, "it");
                return ServerResponseKt.c(it);
            }
        };
        Single x7 = o8.x(new Function() { // from class: ee.mtakso.driver.network.client.settings.f
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional p8;
                p8 = SettingsClient.p(Function1.this, obj);
                return p8;
            }
        });
        Intrinsics.e(x7, "fun getSettings(): Singl….exposeOptional() }\n    }");
        return x7;
    }

    public final Single<EmptyServerResponse> q(SetDriverPricingStateRequest request) {
        Intrinsics.f(request, "request");
        Single<EmptyServerResponse> d8 = l().d(request);
        final Function1<EmptyServerResponse, Unit> function1 = new Function1<EmptyServerResponse, Unit>() { // from class: ee.mtakso.driver.network.client.settings.SettingsClient$setDriverPricingState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EmptyServerResponse emptyServerResponse) {
                ResponseErrorProcessor responseErrorProcessor;
                responseErrorProcessor = SettingsClient.this.f22813b;
                responseErrorProcessor.c(emptyServerResponse);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EmptyServerResponse emptyServerResponse) {
                b(emptyServerResponse);
                return Unit.f50853a;
            }
        };
        Single<EmptyServerResponse> o8 = d8.o(new Consumer() { // from class: ee.mtakso.driver.network.client.settings.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SettingsClient.r(Function1.this, obj);
            }
        });
        Intrinsics.e(o8, "fun setDriverPricingStat…rApiException(it) }\n    }");
        return o8;
    }

    public final Single<DriverDestinationId> s(long j8, String type, String str, String address, double d8, double d9) {
        Intrinsics.f(type, "type");
        Intrinsics.f(address, "address");
        Single<DestinationServerResponse<DriverDestinationId>> g8 = l().g(j8, type, str, address, d8, d9);
        final SettingsClient$updateDriverDestination$1 settingsClient$updateDriverDestination$1 = new Function1<DestinationServerResponse<DriverDestinationId>, DriverDestinationId>() { // from class: ee.mtakso.driver.network.client.settings.SettingsClient$updateDriverDestination$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final DriverDestinationId invoke(DestinationServerResponse<DriverDestinationId> it) {
                Intrinsics.f(it, "it");
                return (DriverDestinationId) ServerResponseKt.a(it);
            }
        };
        Single<DriverDestinationId> K = g8.x(new Function() { // from class: ee.mtakso.driver.network.client.settings.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DriverDestinationId t7;
                t7 = SettingsClient.t(Function1.this, obj);
                return t7;
            }
        }).K(Schedulers.c());
        Intrinsics.e(K, "api.updateDriverDestinat…scribeOn(Schedulers.io())");
        return K;
    }

    public final Single<Optional<SettingsResponse>> u(List<SearchCategorySelection> list, AutoOrderAcceptance autoOrderAcceptance) {
        Single<ServerResponse<SettingsResponse>> a8 = l().a(new SettingsUpdateRequest(list, autoOrderAcceptance));
        final Function1<ServerResponse<SettingsResponse>, Unit> function1 = new Function1<ServerResponse<SettingsResponse>, Unit>() { // from class: ee.mtakso.driver.network.client.settings.SettingsClient$updateSettings$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ServerResponse<SettingsResponse> serverResponse) {
                ResponseErrorProcessor responseErrorProcessor;
                responseErrorProcessor = SettingsClient.this.f22813b;
                responseErrorProcessor.c(serverResponse);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ServerResponse<SettingsResponse> serverResponse) {
                b(serverResponse);
                return Unit.f50853a;
            }
        };
        Single<ServerResponse<SettingsResponse>> o8 = a8.o(new Consumer() { // from class: ee.mtakso.driver.network.client.settings.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SettingsClient.v(Function1.this, obj);
            }
        });
        final SettingsClient$updateSettings$2 settingsClient$updateSettings$2 = new Function1<ServerResponse<SettingsResponse>, Optional<SettingsResponse>>() { // from class: ee.mtakso.driver.network.client.settings.SettingsClient$updateSettings$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<SettingsResponse> invoke(ServerResponse<SettingsResponse> it) {
                Intrinsics.f(it, "it");
                return ServerResponseKt.c(it);
            }
        };
        Single x7 = o8.x(new Function() { // from class: ee.mtakso.driver.network.client.settings.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional w7;
                w7 = SettingsClient.w(Function1.this, obj);
                return w7;
            }
        });
        Intrinsics.e(x7, "fun updateSettings(selec….exposeOptional() }\n    }");
        return x7;
    }
}
