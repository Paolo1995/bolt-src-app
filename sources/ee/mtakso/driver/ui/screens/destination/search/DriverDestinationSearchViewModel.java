package ee.mtakso.driver.ui.screens.destination.search;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.geo.ExternalSourceAddress;
import ee.mtakso.driver.network.client.geo.ExternalSourceAddresses;
import ee.mtakso.driver.network.client.settings.DriverDestination;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.ObservableLiveData;
import ee.mtakso.driver.ui.interactor.destination.SelectDestinationInteractor;
import ee.mtakso.driver.ui.interactor.destination.UpdateDriverDestinationInteractor;
import ee.mtakso.driver.ui.interactor.search.GetSuggestionsInteractor;
import ee.mtakso.driver.utils.DisposableExtKt;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverDestinationSearchViewModel.kt */
/* loaded from: classes3.dex */
public final class DriverDestinationSearchViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final GetSuggestionsInteractor f28222f;

    /* renamed from: g  reason: collision with root package name */
    private final UpdateDriverDestinationInteractor f28223g;

    /* renamed from: h  reason: collision with root package name */
    private final SelectDestinationInteractor f28224h;

    /* renamed from: i  reason: collision with root package name */
    private final SearchSuggestionMapper f28225i;

    /* renamed from: j  reason: collision with root package name */
    private final ObservableLiveData<SearchSuggestionState> f28226j;

    /* renamed from: k  reason: collision with root package name */
    private final PublishSubject<String> f28227k;

    /* renamed from: l  reason: collision with root package name */
    private final MutableLiveData<DriverDestination> f28228l;

    /* renamed from: m  reason: collision with root package name */
    private final LiveData<DriverDestination> f28229m;

    /* renamed from: n  reason: collision with root package name */
    private Disposable f28230n;

    /* renamed from: o  reason: collision with root package name */
    private final LiveEvent<Object> f28231o;

    /* renamed from: p  reason: collision with root package name */
    private final LiveData<Object> f28232p;

    /* renamed from: q  reason: collision with root package name */
    private Disposable f28233q;

    @Inject
    public DriverDestinationSearchViewModel(GetSuggestionsInteractor getSuggestionsInteractor, UpdateDriverDestinationInteractor updateDriverDestinationInteractor, SelectDestinationInteractor selectDestinationInteractor, SearchSuggestionMapper searchSuggestionMapper) {
        Intrinsics.f(getSuggestionsInteractor, "getSuggestionsInteractor");
        Intrinsics.f(updateDriverDestinationInteractor, "updateDriverDestinationInteractor");
        Intrinsics.f(selectDestinationInteractor, "selectDestinationInteractor");
        Intrinsics.f(searchSuggestionMapper, "searchSuggestionMapper");
        this.f28222f = getSuggestionsInteractor;
        this.f28223g = updateDriverDestinationInteractor;
        this.f28224h = selectDestinationInteractor;
        this.f28225i = searchSuggestionMapper;
        this.f28226j = new ObservableLiveData<>();
        PublishSubject<String> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<String>()");
        this.f28227k = e8;
        MutableLiveData<DriverDestination> mutableLiveData = new MutableLiveData<>();
        this.f28228l = mutableLiveData;
        this.f28229m = mutableLiveData;
        LiveEvent<Object> liveEvent = new LiveEvent<>();
        this.f28231o = liveEvent;
        this.f28232p = liveEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(DriverDestinationSearchViewModel this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.f28231o.o(new Object());
        this$0.y().o(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void V() {
        ObservableLiveData<SearchSuggestionState> observableLiveData = this.f28226j;
        Observable<ExternalSourceAddresses> f8 = this.f28222f.f(this.f28227k);
        final Function1<ExternalSourceAddresses, SearchSuggestionState> function1 = new Function1<ExternalSourceAddresses, SearchSuggestionState>() { // from class: ee.mtakso.driver.ui.screens.destination.search.DriverDestinationSearchViewModel$searchQuery$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SearchSuggestionState invoke(ExternalSourceAddresses it) {
                SearchSuggestionMapper searchSuggestionMapper;
                Intrinsics.f(it, "it");
                searchSuggestionMapper = DriverDestinationSearchViewModel.this.f28225i;
                return new SearchSuggestionState(searchSuggestionMapper.b(it));
            }
        };
        Observable<R> map = f8.map(new Function() { // from class: ee.mtakso.driver.ui.screens.destination.search.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SearchSuggestionState W;
                W = DriverDestinationSearchViewModel.W(Function1.this, obj);
                return W;
            }
        });
        Intrinsics.e(map, "private fun searchQuery(…Error(it)\n        }\n    }");
        ObservableLiveData.t(observableLiveData, map, null, new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.destination.search.DriverDestinationSearchViewModel$searchQuery$2
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
                BaseViewModel.A(DriverDestinationSearchViewModel.this, it, null, 2, null);
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchSuggestionState W(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SearchSuggestionState) tmp0.invoke(obj);
    }

    private final void X(Pair<DriverDestination, ExternalSourceAddress> pair) {
        if (!DisposableExtKt.b(this.f28230n)) {
            return;
        }
        Single l8 = l(this.f28223g.c(pair));
        final Function1<DriverDestination, Unit> function1 = new Function1<DriverDestination, Unit>() { // from class: ee.mtakso.driver.ui.screens.destination.search.DriverDestinationSearchViewModel$updateDriverDestination$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DriverDestination driverDestination) {
                MutableLiveData mutableLiveData;
                mutableLiveData = DriverDestinationSearchViewModel.this.f28228l;
                mutableLiveData.o(driverDestination);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverDestination driverDestination) {
                b(driverDestination);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.destination.search.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverDestinationSearchViewModel.Y(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.destination.search.DriverDestinationSearchViewModel$updateDriverDestination$2
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
                DriverDestinationSearchViewModel driverDestinationSearchViewModel = DriverDestinationSearchViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(driverDestinationSearchViewModel, it, null, 2, null);
            }
        };
        this.f28230n = l8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.destination.search.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverDestinationSearchViewModel.Z(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        V();
    }

    public final void M(DriverDestination destination) {
        Intrinsics.f(destination, "destination");
        Completable a8 = this.f28224h.a(destination);
        final Function1<Disposable, Unit> function1 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.ui.screens.destination.search.DriverDestinationSearchViewModel$activateDestination$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                MutableLiveData y7;
                y7 = DriverDestinationSearchViewModel.this.y();
                y7.o(Boolean.TRUE);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Completable r7 = a8.r(new Consumer() { // from class: ee.mtakso.driver.ui.screens.destination.search.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverDestinationSearchViewModel.N(Function1.this, obj);
            }
        });
        Action action = new Action() { // from class: ee.mtakso.driver.ui.screens.destination.search.i
            @Override // io.reactivex.functions.Action
            public final void run() {
                DriverDestinationSearchViewModel.O(DriverDestinationSearchViewModel.this);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.destination.search.DriverDestinationSearchViewModel$activateDestination$3
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
                y7 = DriverDestinationSearchViewModel.this.y();
                y7.o(Boolean.FALSE);
                DriverDestinationSearchViewModel driverDestinationSearchViewModel = DriverDestinationSearchViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(driverDestinationSearchViewModel, it, null, 2, null);
            }
        };
        this.f28233q = r7.G(action, new Consumer() { // from class: ee.mtakso.driver.ui.screens.destination.search.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverDestinationSearchViewModel.P(Function1.this, obj);
            }
        });
    }

    public final LiveData<Object> Q() {
        return this.f28232p;
    }

    public final LiveData<DriverDestination> R() {
        return this.f28229m;
    }

    public final ObservableLiveData<SearchSuggestionState> S() {
        return this.f28226j;
    }

    public final void T(Pair<DriverDestination, ExternalSourceAddress> addressPair) {
        Intrinsics.f(addressPair, "addressPair");
        X(addressPair);
    }

    public final void U(String query) {
        Intrinsics.f(query, "query");
        this.f28227k.onNext(query);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        DisposableExtKt.a(this.f28226j);
        Disposable disposable = this.f28230n;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Disposable disposable2 = this.f28233q;
        if (disposable2 != null) {
            DisposableExtKt.a(disposable2);
        }
        super.onCleared();
    }
}
