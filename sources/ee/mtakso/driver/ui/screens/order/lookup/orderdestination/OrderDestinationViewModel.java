package ee.mtakso.driver.ui.screens.order.lookup.orderdestination;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.geo.ExternalSourceAddress;
import ee.mtakso.driver.network.client.geo.ExternalSourceAddressDetails;
import ee.mtakso.driver.network.client.geo.ExternalSourceAddresses;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.ObservableLiveData;
import ee.mtakso.driver.ui.interactor.search.GetExternalSourceAddressDetailInteractor;
import ee.mtakso.driver.ui.interactor.search.GetOrderDestinationSearchSuggestionInteractor;
import ee.mtakso.driver.ui.screens.destination.search.SearchSuggestionMapper;
import ee.mtakso.driver.utils.DisposableExtKt;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderDestinationViewModel.kt */
/* loaded from: classes3.dex */
public final class OrderDestinationViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final GetOrderDestinationSearchSuggestionInteractor f31482f;

    /* renamed from: g  reason: collision with root package name */
    private final GetExternalSourceAddressDetailInteractor f31483g;

    /* renamed from: h  reason: collision with root package name */
    private final SearchSuggestionMapper f31484h;

    /* renamed from: i  reason: collision with root package name */
    private Long f31485i;

    /* renamed from: j  reason: collision with root package name */
    private final ObservableLiveData<OrderDestinationState> f31486j;

    /* renamed from: k  reason: collision with root package name */
    private final PublishSubject<String> f31487k;

    /* renamed from: l  reason: collision with root package name */
    private final LiveEvent<ExternalSourceAddressDetails> f31488l;

    /* renamed from: m  reason: collision with root package name */
    private final LiveData<ExternalSourceAddressDetails> f31489m;

    /* renamed from: n  reason: collision with root package name */
    private Disposable f31490n;

    @Inject
    public OrderDestinationViewModel(GetOrderDestinationSearchSuggestionInteractor getOrderDestinationSearchSuggestionsInteractor, GetExternalSourceAddressDetailInteractor getExternalSourceAddressDetailInteractor, SearchSuggestionMapper searchSuggestionMapper) {
        Intrinsics.f(getOrderDestinationSearchSuggestionsInteractor, "getOrderDestinationSearchSuggestionsInteractor");
        Intrinsics.f(getExternalSourceAddressDetailInteractor, "getExternalSourceAddressDetailInteractor");
        Intrinsics.f(searchSuggestionMapper, "searchSuggestionMapper");
        this.f31482f = getOrderDestinationSearchSuggestionsInteractor;
        this.f31483g = getExternalSourceAddressDetailInteractor;
        this.f31484h = searchSuggestionMapper;
        this.f31486j = new ObservableLiveData<>();
        PublishSubject<String> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<String>()");
        this.f31487k = e8;
        LiveEvent<ExternalSourceAddressDetails> liveEvent = new LiveEvent<>();
        this.f31488l = liveEvent;
        this.f31489m = liveEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OrderDestinationState Q(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (OrderDestinationState) tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        ObservableLiveData<OrderDestinationState> observableLiveData = this.f31486j;
        Observable<ExternalSourceAddresses> j8 = this.f31482f.j(this.f31487k);
        final Function1<ExternalSourceAddresses, OrderDestinationState> function1 = new Function1<ExternalSourceAddresses, OrderDestinationState>() { // from class: ee.mtakso.driver.ui.screens.order.lookup.orderdestination.OrderDestinationViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final OrderDestinationState invoke(ExternalSourceAddresses it) {
                SearchSuggestionMapper searchSuggestionMapper;
                Intrinsics.f(it, "it");
                searchSuggestionMapper = OrderDestinationViewModel.this.f31484h;
                return new OrderDestinationState(searchSuggestionMapper.b(it));
            }
        };
        Observable<R> map = j8.map(new Function() { // from class: ee.mtakso.driver.ui.screens.order.lookup.orderdestination.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                OrderDestinationState Q;
                Q = OrderDestinationViewModel.Q(Function1.this, obj);
                return Q;
            }
        });
        Intrinsics.e(map, "override fun onStart() {…Error(it)\n        }\n    }");
        ObservableLiveData.t(observableLiveData, map, null, new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.lookup.orderdestination.OrderDestinationViewModel$onStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.f(it, "it");
                BaseViewModel.A(OrderDestinationViewModel.this, it, null, 2, null);
            }
        }, 2, null);
    }

    public final LiveData<ExternalSourceAddressDetails> K() {
        return this.f31489m;
    }

    public final ObservableLiveData<OrderDestinationState> L() {
        return this.f31486j;
    }

    public final void M(ExternalSourceAddress externalSourceAddress) {
        Intrinsics.f(externalSourceAddress, "externalSourceAddress");
        Single<ExternalSourceAddressDetails> a8 = this.f31483g.a(externalSourceAddress, this.f31485i);
        final Function1<Disposable, Unit> function1 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.lookup.orderdestination.OrderDestinationViewModel$onAddressSelected$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                MutableLiveData y7;
                y7 = OrderDestinationViewModel.this.y();
                y7.o(Boolean.TRUE);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Single<ExternalSourceAddressDetails> n8 = a8.n(new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.lookup.orderdestination.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderDestinationViewModel.N(Function1.this, obj);
            }
        });
        final Function1<ExternalSourceAddressDetails, Unit> function12 = new Function1<ExternalSourceAddressDetails, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.lookup.orderdestination.OrderDestinationViewModel$onAddressSelected$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ExternalSourceAddressDetails externalSourceAddressDetails) {
                LiveEvent liveEvent;
                MutableLiveData y7;
                liveEvent = OrderDestinationViewModel.this.f31488l;
                liveEvent.o(externalSourceAddressDetails);
                y7 = OrderDestinationViewModel.this.y();
                y7.o(Boolean.FALSE);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ExternalSourceAddressDetails externalSourceAddressDetails) {
                b(externalSourceAddressDetails);
                return Unit.f50853a;
            }
        };
        Consumer<? super ExternalSourceAddressDetails> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.lookup.orderdestination.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderDestinationViewModel.O(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.lookup.orderdestination.OrderDestinationViewModel$onAddressSelected$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                MutableLiveData y7;
                y7 = OrderDestinationViewModel.this.y();
                y7.o(Boolean.FALSE);
                OrderDestinationViewModel orderDestinationViewModel = OrderDestinationViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(orderDestinationViewModel, it, null, 2, null);
            }
        };
        this.f31490n = n8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.lookup.orderdestination.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderDestinationViewModel.P(Function1.this, obj);
            }
        });
    }

    public final void R(String query) {
        Intrinsics.f(query, "query");
        this.f31487k.onNext(query);
    }

    public final void S(Long l8) {
        this.f31485i = l8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        DisposableExtKt.a(this.f31486j);
        Disposable disposable = this.f31490n;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
    }
}
