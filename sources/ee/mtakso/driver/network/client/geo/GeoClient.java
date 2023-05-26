package ee.mtakso.driver.network.client.geo;

import dagger.Lazy;
import ee.mtakso.driver.network.client.Coordinates;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import ee.mtakso.driver.network.response.ServerResponse;
import ee.mtakso.driver.network.response.ServerResponseKt;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.android.maps.core.Locatable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeoClient.kt */
/* loaded from: classes3.dex */
public final class GeoClient {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy<GeoApi> f22252a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverProvider f22253b;

    /* renamed from: c  reason: collision with root package name */
    private final CompositeResponseTransformer f22254c;

    @Inject
    public GeoClient(Lazy<GeoApi> geoApi, DriverProvider driverProvider, CompositeResponseTransformer responseTransformer) {
        Intrinsics.f(geoApi, "geoApi");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(responseTransformer, "responseTransformer");
        this.f22252a = geoApi;
        this.f22253b = driverProvider;
        this.f22254c = responseTransformer;
    }

    private final Coordinates b(Locatable locatable) {
        return new Coordinates(locatable.a(), locatable.b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Single d(GeoClient geoClient, GeoCoordinate geoCoordinate, Locatable locatable, String str, List list, int i8, Object obj) {
        if ((i8 & 8) != 0) {
            list = CollectionsKt__CollectionsKt.k();
        }
        return geoClient.c(geoCoordinate, locatable, str, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Directions e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Directions) tmp0.invoke(obj);
    }

    public final Single<Directions> c(GeoCoordinate source, Locatable target, String str, List<GeoCoordinate> waypoints) {
        int v7;
        Intrinsics.f(source, "source");
        Intrinsics.f(target, "target");
        Intrinsics.f(waypoints, "waypoints");
        Coordinates b8 = b(source);
        Coordinates b9 = b(target);
        String y7 = this.f22253b.m().y();
        v7 = CollectionsKt__IterablesKt.v(waypoints, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (GeoCoordinate geoCoordinate : waypoints) {
            arrayList.add(b(geoCoordinate));
        }
        Single<ServerResponse<Directions>> c8 = this.f22252a.get().c(new DrivingDirectionsParams(b8, b9, y7, str, arrayList));
        final GeoClient$getDrivingDirections$1 geoClient$getDrivingDirections$1 = new Function1<ServerResponse<Directions>, Directions>() { // from class: ee.mtakso.driver.network.client.geo.GeoClient$getDrivingDirections$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Directions invoke(ServerResponse<Directions> it) {
                Intrinsics.f(it, "it");
                return (Directions) ServerResponseKt.b(it);
            }
        };
        Single x7 = c8.x(new Function() { // from class: ee.mtakso.driver.network.client.geo.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Directions e8;
                e8 = GeoClient.e(Function1.this, obj);
                return e8;
            }
        });
        Intrinsics.e(x7, "geoApi.get().getDrivingD…).map { it.exposeData() }");
        return x7;
    }

    public final Single<ExternalSourceAddressDetails> f(String source, Long l8, String placeId) {
        Intrinsics.f(source, "source");
        Intrinsics.f(placeId, "placeId");
        return SingleExtKt.g(this.f22252a.get().b(source, l8, placeId), this.f22254c);
    }

    public final Single<ExternalSourceAddresses> g(double d8, double d9, Long l8, String query, int i8) {
        Intrinsics.f(query, "query");
        return SingleExtKt.g(this.f22252a.get().a(d8, d9, l8, query, i8), this.f22254c);
    }
}
