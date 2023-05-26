package ee.mtakso.driver.network.client.driver;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.ShardApiProvider;
import ee.mtakso.driver.network.client.driver.surge.SurgeMap;
import ee.mtakso.driver.network.client.driver.surge.SurgeResponse;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import ee.mtakso.driver.network.response.DestinationServerResponse;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.network.response.ResponseErrorProcessor;
import ee.mtakso.driver.network.response.ServerResponse;
import ee.mtakso.driver.network.response.ServerResponseKt;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.service.geo.storage.LocationEntity;
import ee.mtakso.driver.ui.theme.ThemeTitle;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.android.maps.core.Locatable;
import eu.bolt.driver.core.theme.Theme;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverClient.kt */
/* loaded from: classes3.dex */
public final class DriverClient {

    /* renamed from: a  reason: collision with root package name */
    private final ShardApiProvider f21898a;

    /* renamed from: b  reason: collision with root package name */
    private final CompositeResponseTransformer f21899b;

    /* renamed from: c  reason: collision with root package name */
    private final ResponseErrorProcessor f21900c;

    @Inject
    public DriverClient(ShardApiProvider apiProvider, CompositeResponseTransformer responseTransformer, ResponseErrorProcessor errorProcessor) {
        Intrinsics.f(apiProvider, "apiProvider");
        Intrinsics.f(responseTransformer, "responseTransformer");
        Intrinsics.f(errorProcessor, "errorProcessor");
        this.f21898a = apiProvider;
        this.f21899b = responseTransformer;
        this.f21900c = errorProcessor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DriverMightBeBlocked A(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (DriverMightBeBlocked) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final DriverGpsLocation D(LocationEntity locationEntity) {
        float f8;
        OrderState valueOf = OrderState.valueOf(locationEntity.h());
        double e8 = locationEntity.e();
        double f9 = locationEntity.f();
        double a8 = locationEntity.a();
        Float t7 = t(locationEntity.j());
        if (t7 != null) {
            f8 = t7.floatValue();
        } else {
            f8 = 0.0f;
        }
        return new DriverGpsLocation(valueOf, e8, f9, a8, f8, locationEntity.i(), locationEntity.d(), t(locationEntity.b()), locationEntity.c());
    }

    private final DriverApi h() {
        return this.f21898a.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DriverMapsConfigs p(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (DriverMapsConfigs) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DriverMapsConfigsExplanation r(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (DriverMapsConfigsExplanation) tmp0.invoke(obj);
    }

    private final Float t(Float f8) {
        if (f8 == null || Float.isNaN(f8.floatValue()) || Float.isInfinite(f8.floatValue())) {
            return null;
        }
        return f8;
    }

    public final Single<EmptyServerResponse> B(OrderHandle orderHandle, List<LocationEntity> points) {
        int v7;
        Intrinsics.f(orderHandle, "orderHandle");
        Intrinsics.f(points, "points");
        DriverApi h8 = h();
        v7 = CollectionsKt__IterablesKt.v(points, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (LocationEntity locationEntity : points) {
            arrayList.add(D(locationEntity));
        }
        Single<EmptyServerResponse> g8 = h8.g(new DriverGpsLocationsRequest(orderHandle, arrayList));
        final Function1<EmptyServerResponse, Unit> function1 = new Function1<EmptyServerResponse, Unit>() { // from class: ee.mtakso.driver.network.client.driver.DriverClient$storeLocations$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EmptyServerResponse emptyServerResponse) {
                ResponseErrorProcessor responseErrorProcessor;
                responseErrorProcessor = DriverClient.this.f21900c;
                responseErrorProcessor.c(emptyServerResponse);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EmptyServerResponse emptyServerResponse) {
                b(emptyServerResponse);
                return Unit.f50853a;
            }
        };
        Single<EmptyServerResponse> o8 = g8.o(new Consumer() { // from class: ee.mtakso.driver.network.client.driver.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverClient.C(Function1.this, obj);
            }
        });
        Intrinsics.e(o8, "fun storeLocations(order…rApiException(it) }\n    }");
        return o8;
    }

    public final Single<EmptyServerResponse> E(String language) {
        Intrinsics.f(language, "language");
        return SingleExtKt.e(h().p(language), this.f21900c);
    }

    public final Single<AddressSuggestions> g(String query, OrderHandle orderHandle, Locatable point) {
        Intrinsics.f(query, "query");
        Intrinsics.f(orderHandle, "orderHandle");
        Intrinsics.f(point, "point");
        return SingleExtKt.g(h().o(new SearchClientDestinationRequest(orderHandle, query, point.a(), point.b())), this.f21899b);
    }

    public final Single<Cars> i() {
        return SingleExtKt.g(h().e(), this.f21899b);
    }

    public final Single<Optional<SurgeMap>> j(GeoCoordinate point) {
        Intrinsics.f(point, "point");
        Single<ServerResponse<SurgeResponse>> d8 = h().d(point.a(), point.b());
        final DriverClient$getCurrentSurges$1 driverClient$getCurrentSurges$1 = DriverClient$getCurrentSurges$1.f21901f;
        Single x7 = d8.x(new Function() { // from class: ee.mtakso.driver.network.client.driver.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional k8;
                k8 = DriverClient.k(Function1.this, obj);
                return k8;
            }
        });
        Intrinsics.e(x7, "api.getCurrentSurges(poi….surgeMap }\n            }");
        return x7;
    }

    public final Single<DriverCancels> l() {
        return SingleExtKt.g(h().i(), this.f21899b);
    }

    public final Single<DriverHours> m(String groupBy) {
        Intrinsics.f(groupBy, "groupBy");
        return SingleExtKt.g(h().f(groupBy), this.f21899b);
    }

    public final Single<DriverRides> n(String groupBy) {
        Intrinsics.f(groupBy, "groupBy");
        return SingleExtKt.g(h().h(groupBy), this.f21899b);
    }

    public final Single<DriverMapsConfigs> o() {
        Single<ServerResponse<DriverMapsConfigs>> l8 = h().l();
        final DriverClient$getMapsConfigs$1 driverClient$getMapsConfigs$1 = new Function1<ServerResponse<DriverMapsConfigs>, DriverMapsConfigs>() { // from class: ee.mtakso.driver.network.client.driver.DriverClient$getMapsConfigs$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final DriverMapsConfigs invoke(ServerResponse<DriverMapsConfigs> it) {
                Intrinsics.f(it, "it");
                return (DriverMapsConfigs) ServerResponseKt.b(it);
            }
        };
        Single x7 = l8.x(new Function() { // from class: ee.mtakso.driver.network.client.driver.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DriverMapsConfigs p8;
                p8 = DriverClient.p(Function1.this, obj);
                return p8;
            }
        });
        Intrinsics.e(x7, "api.getMapsConfigs().map { it.exposeData() }");
        return x7;
    }

    public final Single<DriverMapsConfigsExplanation> q(Theme theme) {
        Intrinsics.f(theme, "theme");
        Single<ServerResponse<DriverMapsConfigsExplanation>> m8 = h().m(ThemeTitle.f34260g.a(theme));
        final DriverClient$getMapsConfigsExplanation$1 driverClient$getMapsConfigsExplanation$1 = new Function1<ServerResponse<DriverMapsConfigsExplanation>, DriverMapsConfigsExplanation>() { // from class: ee.mtakso.driver.network.client.driver.DriverClient$getMapsConfigsExplanation$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final DriverMapsConfigsExplanation invoke(ServerResponse<DriverMapsConfigsExplanation> it) {
                Intrinsics.f(it, "it");
                return (DriverMapsConfigsExplanation) ServerResponseKt.b(it);
            }
        };
        Single x7 = m8.x(new Function() { // from class: ee.mtakso.driver.network.client.driver.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DriverMapsConfigsExplanation r7;
                r7 = DriverClient.r(Function1.this, obj);
                return r7;
            }
        });
        Intrinsics.e(x7, "api.getMapsConfigsExplan…).map { it.exposeData() }");
        return x7;
    }

    public final Single<PollingResult> s(List<OrderHandle> list, String appState) {
        Intrinsics.f(appState, "appState");
        return SingleExtKt.g(h().b(new PollingRequest(list, appState)), this.f21899b);
    }

    public final Single<EmptyServerResponse> u(long j8) {
        return SingleExtKt.e(h().q(j8), this.f21900c);
    }

    public final Single<EmptyServerResponse> v(String deviceToken) {
        Intrinsics.f(deviceToken, "deviceToken");
        return SingleExtKt.e(h().a(deviceToken), this.f21900c);
    }

    public final Single<EmptyServerResponse> w() {
        return SingleExtKt.e(h().n(""), this.f21900c);
    }

    public final Single<EmptyServerResponse> x(double d8) {
        return SingleExtKt.e(h().j(d8), this.f21900c);
    }

    public final Single<EmptyServerResponse> y(boolean z7) {
        int i8 = 1;
        if (!z7) {
            if (!z7) {
                i8 = 0;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return SingleExtKt.e(h().k(i8), this.f21900c);
    }

    public final Single<DriverMightBeBlocked> z(double d8, Long l8, OrderHandle orderHandle, String environmentData) {
        Intrinsics.f(environmentData, "environmentData");
        Single<DestinationServerResponse<DriverMightBeBlocked>> c8 = h().c(new StartWorkingRequest(d8, l8, orderHandle), environmentData);
        final DriverClient$startWorking$1 driverClient$startWorking$1 = new Function1<DestinationServerResponse<DriverMightBeBlocked>, DriverMightBeBlocked>() { // from class: ee.mtakso.driver.network.client.driver.DriverClient$startWorking$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final DriverMightBeBlocked invoke(DestinationServerResponse<DriverMightBeBlocked> it) {
                Intrinsics.f(it, "it");
                return (DriverMightBeBlocked) ServerResponseKt.a(it);
            }
        };
        Single<DriverMightBeBlocked> K = c8.x(new Function() { // from class: ee.mtakso.driver.network.client.driver.e
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DriverMightBeBlocked A;
                A = DriverClient.A(Function1.this, obj);
                return A;
            }
        }).K(Schedulers.c());
        Intrinsics.e(K, "api\n            .startWo…scribeOn(Schedulers.io())");
        return K;
    }
}
