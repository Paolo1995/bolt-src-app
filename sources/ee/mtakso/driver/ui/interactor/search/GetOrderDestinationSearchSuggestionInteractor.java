package ee.mtakso.driver.ui.interactor.search;

import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.driver.AddressSuggestion;
import ee.mtakso.driver.network.client.driver.AddressSuggestions;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.network.client.geo.ExternalSourceAddress;
import ee.mtakso.driver.network.client.geo.ExternalSourceAddresses;
import ee.mtakso.driver.service.geo.GeoLocation;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.utils.ObservableExtKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetOrderDestinationSearchSuggestionInteractor.kt */
/* loaded from: classes3.dex */
public final class GetOrderDestinationSearchSuggestionInteractor {

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f26871e = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final GetExternalSourceAddressInteractor f26872a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverClient f26873b;

    /* renamed from: c  reason: collision with root package name */
    private final OrderProvider f26874c;

    /* renamed from: d  reason: collision with root package name */
    private final GeoLocationManager f26875d;

    /* compiled from: GetOrderDestinationSearchSuggestionInteractor.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public GetOrderDestinationSearchSuggestionInteractor(GetExternalSourceAddressInteractor getExternalSourceAddressInteractor, DriverClient driverApiClient, OrderProvider orderProvider, GeoLocationManager locationManager) {
        Intrinsics.f(getExternalSourceAddressInteractor, "getExternalSourceAddressInteractor");
        Intrinsics.f(driverApiClient, "driverApiClient");
        Intrinsics.f(orderProvider, "orderProvider");
        Intrinsics.f(locationManager, "locationManager");
        this.f26872a = getExternalSourceAddressInteractor;
        this.f26873b = driverApiClient;
        this.f26874c = orderProvider;
        this.f26875d = locationManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource m(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Observable<ExternalSourceAddresses> n(String str, GeoLocation geoLocation) {
        Single<OrderDetails> r7 = OrderProviderUtils.r(this.f26874c, OrderState.ORDER_STATE_DRIVING_WITH_CLIENT, OrderState.ORDER_STATE_WAITING_ON_STOP);
        final GetOrderDestinationSearchSuggestionInteractor$getSearchSuggestions$1 getOrderDestinationSearchSuggestionInteractor$getSearchSuggestions$1 = new GetOrderDestinationSearchSuggestionInteractor$getSearchSuggestions$1(this, str, geoLocation);
        Observable t7 = r7.t(new Function() { // from class: ee.mtakso.driver.ui.interactor.search.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource o8;
                o8 = GetOrderDestinationSearchSuggestionInteractor.o(Function1.this, obj);
                return o8;
            }
        });
        Intrinsics.e(t7, "private fun getSearchSug…    }\n            }\n    }");
        return t7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ExternalSourceAddress> p(AddressSuggestions addressSuggestions) {
        int v7;
        Boolean bool;
        ArrayList arrayList = new ArrayList();
        ArrayList<AddressSuggestion> a8 = addressSuggestions.a();
        if (a8 != null) {
            v7 = CollectionsKt__IterablesKt.v(a8, 10);
            ArrayList arrayList2 = new ArrayList(v7);
            for (AddressSuggestion addressSuggestion : a8) {
                String a9 = addressSuggestion.a();
                if (a9 != null) {
                    bool = Boolean.valueOf(arrayList.add(new ExternalSourceAddress("", "", a9, "", "", "", addressSuggestion.b(), addressSuggestion.c())));
                } else {
                    bool = null;
                }
                arrayList2.add(bool);
            }
        }
        return arrayList;
    }

    public final Observable<ExternalSourceAddresses> j(Observable<String> queryObservable) {
        Intrinsics.f(queryObservable, "queryObservable");
        Observable<String> distinctUntilChanged = queryObservable.debounce(1L, TimeUnit.SECONDS).distinctUntilChanged();
        final GetOrderDestinationSearchSuggestionInteractor$getOrderDestinationSearchSuggestions$1 getOrderDestinationSearchSuggestionInteractor$getOrderDestinationSearchSuggestions$1 = new Function1<String, Boolean>() { // from class: ee.mtakso.driver.ui.interactor.search.GetOrderDestinationSearchSuggestionInteractor$getOrderDestinationSearchSuggestions$1
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
        Observable<String> filter = distinctUntilChanged.filter(new Predicate() { // from class: ee.mtakso.driver.ui.interactor.search.a
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean k8;
                k8 = GetOrderDestinationSearchSuggestionInteractor.k(Function1.this, obj);
                return k8;
            }
        });
        final GetOrderDestinationSearchSuggestionInteractor$getOrderDestinationSearchSuggestions$2 getOrderDestinationSearchSuggestionInteractor$getOrderDestinationSearchSuggestions$2 = new GetOrderDestinationSearchSuggestionInteractor$getOrderDestinationSearchSuggestions$2(this);
        Observable<R> switchMap = filter.switchMap(new Function() { // from class: ee.mtakso.driver.ui.interactor.search.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource l8;
                l8 = GetOrderDestinationSearchSuggestionInteractor.l(Function1.this, obj);
                return l8;
            }
        });
        final Function1<Pair<? extends String, ? extends GeoLocation>, ObservableSource<? extends ExternalSourceAddresses>> function1 = new Function1<Pair<? extends String, ? extends GeoLocation>, ObservableSource<? extends ExternalSourceAddresses>>() { // from class: ee.mtakso.driver.ui.interactor.search.GetOrderDestinationSearchSuggestionInteractor$getOrderDestinationSearchSuggestions$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<? extends ExternalSourceAddresses> invoke(Pair<String, GeoLocation> pair) {
                Observable n8;
                Intrinsics.f(pair, "<name for destructuring parameter 0>");
                String query = pair.a();
                GeoLocation location = pair.b();
                GetOrderDestinationSearchSuggestionInteractor getOrderDestinationSearchSuggestionInteractor = GetOrderDestinationSearchSuggestionInteractor.this;
                Intrinsics.e(query, "query");
                Intrinsics.e(location, "location");
                n8 = getOrderDestinationSearchSuggestionInteractor.n(query, location);
                return n8;
            }
        };
        Observable flatMap = switchMap.flatMap(new Function() { // from class: ee.mtakso.driver.ui.interactor.search.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m8;
                m8 = GetOrderDestinationSearchSuggestionInteractor.m(Function1.this, obj);
                return m8;
            }
        });
        Intrinsics.e(flatMap, "fun getOrderDestinationS…pplyIOSchedulers()\n\n    }");
        return ObservableExtKt.g(flatMap);
    }
}
