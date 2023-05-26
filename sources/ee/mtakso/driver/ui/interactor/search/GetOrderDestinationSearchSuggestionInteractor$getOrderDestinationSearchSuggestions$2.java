package ee.mtakso.driver.ui.interactor.search;

import ee.mtakso.driver.service.geo.GeoLocation;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GetOrderDestinationSearchSuggestionInteractor.kt */
/* loaded from: classes3.dex */
public final class GetOrderDestinationSearchSuggestionInteractor$getOrderDestinationSearchSuggestions$2 extends Lambda implements Function1<String, ObservableSource<? extends Pair<? extends String, ? extends GeoLocation>>> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ GetOrderDestinationSearchSuggestionInteractor f26877f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetOrderDestinationSearchSuggestionInteractor$getOrderDestinationSearchSuggestions$2(GetOrderDestinationSearchSuggestionInteractor getOrderDestinationSearchSuggestionInteractor) {
        super(1);
        this.f26877f = getOrderDestinationSearchSuggestionInteractor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair d(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Pair) tmp0.s(obj, obj2);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: c */
    public final ObservableSource<? extends Pair<String, GeoLocation>> invoke(String query) {
        GeoLocationManager geoLocationManager;
        Intrinsics.f(query, "query");
        Observable just = Observable.just(query);
        geoLocationManager = this.f26877f.f26875d;
        Observable<GeoLocation> take = geoLocationManager.t().take(1L);
        final AnonymousClass1 anonymousClass1 = new Function2<String, GeoLocation, Pair<? extends String, ? extends GeoLocation>>() { // from class: ee.mtakso.driver.ui.interactor.search.GetOrderDestinationSearchSuggestionInteractor$getOrderDestinationSearchSuggestions$2.1
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final Pair<String, GeoLocation> s(String query2, GeoLocation location) {
                Intrinsics.f(query2, "query");
                Intrinsics.f(location, "location");
                return new Pair<>(query2, location);
            }
        };
        return Observable.combineLatest(just, take, new BiFunction() { // from class: ee.mtakso.driver.ui.interactor.search.e
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Pair d8;
                d8 = GetOrderDestinationSearchSuggestionInteractor$getOrderDestinationSearchSuggestions$2.d(Function2.this, obj, obj2);
                return d8;
            }
        });
    }
}
