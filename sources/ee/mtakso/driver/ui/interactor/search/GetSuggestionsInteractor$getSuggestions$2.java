package ee.mtakso.driver.ui.interactor.search;

import ee.mtakso.driver.service.geo.GeoLocation;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GetSuggestionsInteractor.kt */
/* loaded from: classes3.dex */
public final class GetSuggestionsInteractor$getSuggestions$2 extends Lambda implements Function1<String, ObservableSource<? extends Pair<? extends String, ? extends GeoLocation>>> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ GetSuggestionsInteractor f26892f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetSuggestionsInteractor$getSuggestions$2(GetSuggestionsInteractor getSuggestionsInteractor) {
        super(1);
        this.f26892f = getSuggestionsInteractor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair d(String query, GeoLocation location) {
        Intrinsics.f(query, "query");
        Intrinsics.f(location, "location");
        return new Pair(query, location);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: c */
    public final ObservableSource<? extends Pair<String, GeoLocation>> invoke(String query) {
        GeoLocationManager geoLocationManager;
        Intrinsics.f(query, "query");
        Observable just = Observable.just(query);
        geoLocationManager = this.f26892f.f26889a;
        return Observable.combineLatest(just, geoLocationManager.t().take(1L), new BiFunction() { // from class: ee.mtakso.driver.ui.interactor.search.j
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Pair d8;
                d8 = GetSuggestionsInteractor$getSuggestions$2.d((String) obj, (GeoLocation) obj2);
                return d8;
            }
        });
    }
}
