package ee.mtakso.driver.ui.interactor.search;

import ee.mtakso.driver.network.client.geo.ExternalSourceAddresses;
import ee.mtakso.driver.service.geo.GeoLocation;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.utils.ObservableExtKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetSuggestionsInteractor.kt */
/* loaded from: classes3.dex */
public final class GetSuggestionsInteractor {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f26888c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final GeoLocationManager f26889a;

    /* renamed from: b  reason: collision with root package name */
    private final GetExternalSourceAddressInteractor f26890b;

    /* compiled from: GetSuggestionsInteractor.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public GetSuggestionsInteractor(GeoLocationManager locationManager, GetExternalSourceAddressInteractor getExternalSourceAddressInteractor) {
        Intrinsics.f(locationManager, "locationManager");
        Intrinsics.f(getExternalSourceAddressInteractor, "getExternalSourceAddressInteractor");
        this.f26889a = locationManager;
        this.f26890b = getExternalSourceAddressInteractor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource h(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    public final Observable<ExternalSourceAddresses> f(Observable<String> queryString) {
        Intrinsics.f(queryString, "queryString");
        Observable<String> distinctUntilChanged = queryString.debounce(1L, TimeUnit.SECONDS).distinctUntilChanged();
        final GetSuggestionsInteractor$getSuggestions$1 getSuggestionsInteractor$getSuggestions$1 = new Function1<String, Boolean>() { // from class: ee.mtakso.driver.ui.interactor.search.GetSuggestionsInteractor$getSuggestions$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(String query) {
                boolean z7;
                Intrinsics.f(query, "query");
                if (query.length() > 2) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        };
        Observable<String> filter = distinctUntilChanged.filter(new Predicate() { // from class: ee.mtakso.driver.ui.interactor.search.g
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean g8;
                g8 = GetSuggestionsInteractor.g(Function1.this, obj);
                return g8;
            }
        });
        final GetSuggestionsInteractor$getSuggestions$2 getSuggestionsInteractor$getSuggestions$2 = new GetSuggestionsInteractor$getSuggestions$2(this);
        Observable<R> switchMap = filter.switchMap(new Function() { // from class: ee.mtakso.driver.ui.interactor.search.h
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource h8;
                h8 = GetSuggestionsInteractor.h(Function1.this, obj);
                return h8;
            }
        });
        final Function1<Pair<? extends String, ? extends GeoLocation>, ObservableSource<? extends ExternalSourceAddresses>> function1 = new Function1<Pair<? extends String, ? extends GeoLocation>, ObservableSource<? extends ExternalSourceAddresses>>() { // from class: ee.mtakso.driver.ui.interactor.search.GetSuggestionsInteractor$getSuggestions$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<? extends ExternalSourceAddresses> invoke(Pair<String, GeoLocation> pair) {
                GetExternalSourceAddressInteractor getExternalSourceAddressInteractor;
                Intrinsics.f(pair, "<name for destructuring parameter 0>");
                String query = pair.a();
                GeoLocation location = pair.b();
                getExternalSourceAddressInteractor = GetSuggestionsInteractor.this.f26890b;
                Intrinsics.e(query, "query");
                Intrinsics.e(location, "location");
                return getExternalSourceAddressInteractor.a(query, location, null).R();
            }
        };
        Observable flatMap = switchMap.flatMap(new Function() { // from class: ee.mtakso.driver.ui.interactor.search.i
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource i8;
                i8 = GetSuggestionsInteractor.i(Function1.this, obj);
                return i8;
            }
        });
        Intrinsics.e(flatMap, "fun getSuggestions(query…applyIOSchedulers()\n    }");
        return ObservableExtKt.g(flatMap);
    }
}
