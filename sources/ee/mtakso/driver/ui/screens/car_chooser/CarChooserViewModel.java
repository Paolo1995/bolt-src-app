package ee.mtakso.driver.ui.screens.car_chooser;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.driver.Car;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.driver.DriverManager;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.screens.car_chooser.CarChooserDelegate;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import ee.mtakso.driver.utils.UrlFactory;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CarChooserViewModel.kt */
/* loaded from: classes3.dex */
public final class CarChooserViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final DriverProvider f27689f;

    /* renamed from: g  reason: collision with root package name */
    private final DriverClient f27690g;

    /* renamed from: h  reason: collision with root package name */
    private final UrlFactory f27691h;

    /* renamed from: i  reason: collision with root package name */
    private final GetDriverCarsInteractor f27692i;

    /* renamed from: j  reason: collision with root package name */
    private final GetDriverPortalTokenInteractor f27693j;

    /* renamed from: k  reason: collision with root package name */
    private final DriverManager f27694k;

    /* renamed from: l  reason: collision with root package name */
    private final MutableLiveData<Boolean> f27695l;

    /* renamed from: m  reason: collision with root package name */
    private final MutableLiveData<List<CarChooserDelegate.Model>> f27696m;

    /* renamed from: n  reason: collision with root package name */
    private final MutableLiveData<Boolean> f27697n;

    /* renamed from: o  reason: collision with root package name */
    private final LiveEvent<String> f27698o;

    /* renamed from: p  reason: collision with root package name */
    private Disposable f27699p;

    /* renamed from: q  reason: collision with root package name */
    private Disposable f27700q;

    /* renamed from: r  reason: collision with root package name */
    private Disposable f27701r;

    @Inject
    public CarChooserViewModel(DriverProvider driverProvider, DriverClient driverApiClient, UrlFactory urlFactory, GetDriverCarsInteractor carsInteractor, GetDriverPortalTokenInteractor driverPortalTokenInteractor, DriverManager driverManager) {
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(driverApiClient, "driverApiClient");
        Intrinsics.f(urlFactory, "urlFactory");
        Intrinsics.f(carsInteractor, "carsInteractor");
        Intrinsics.f(driverPortalTokenInteractor, "driverPortalTokenInteractor");
        Intrinsics.f(driverManager, "driverManager");
        this.f27689f = driverProvider;
        this.f27690g = driverApiClient;
        this.f27691h = urlFactory;
        this.f27692i = carsInteractor;
        this.f27693j = driverPortalTokenInteractor;
        this.f27694k = driverManager;
        this.f27695l = new MutableLiveData<>();
        this.f27696m = new MutableLiveData<>();
        this.f27697n = new MutableLiveData<>();
        this.f27698o = new LiveEvent<>();
    }

    private final void T() {
        Single d8 = SingleExtKt.d(this.f27692i.d());
        final Function1<List<? extends CarChooserDelegate.Model>, Unit> function1 = new Function1<List<? extends CarChooserDelegate.Model>, Unit>() { // from class: ee.mtakso.driver.ui.screens.car_chooser.CarChooserViewModel$requestCarsData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(List<CarChooserDelegate.Model> list) {
                MutableLiveData mutableLiveData;
                mutableLiveData = CarChooserViewModel.this.f27696m;
                mutableLiveData.o(list);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends CarChooserDelegate.Model> list) {
                b(list);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.car_chooser.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CarChooserViewModel.U(Function1.this, obj);
            }
        };
        final CarChooserViewModel$requestCarsData$2 carChooserViewModel$requestCarsData$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.car_chooser.CarChooserViewModel$requestCarsData$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to observe driver car data!");
            }
        };
        this.f27699p = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.car_chooser.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CarChooserViewModel.V(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String X(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (String) tmp0.invoke(obj);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        T();
    }

    public final LiveData<List<CarChooserDelegate.Model>> P() {
        return this.f27696m;
    }

    public final LiveEvent<String> Q() {
        return this.f27698o;
    }

    public final LiveData<Boolean> R() {
        return this.f27695l;
    }

    public final LiveData<Boolean> S() {
        return this.f27697n;
    }

    public final void W() {
        if (!DisposableExtKt.b(this.f27701r)) {
            return;
        }
        Single<String> b8 = this.f27693j.b();
        final Function1<String, String> function1 = new Function1<String, String>() { // from class: ee.mtakso.driver.ui.screens.car_chooser.CarChooserViewModel$requestDriverToken$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final String invoke(String it) {
                UrlFactory urlFactory;
                Intrinsics.f(it, "it");
                urlFactory = CarChooserViewModel.this.f27691h;
                return urlFactory.a("https://partners.taxify.eu/vehicles/add", "t", it);
            }
        };
        Single<R> x7 = b8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.car_chooser.o
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String X;
                X = CarChooserViewModel.X(Function1.this, obj);
                return X;
            }
        });
        Intrinsics.e(x7, "fun requestDriverToken()… driver token!\") })\n    }");
        Single d8 = SingleExtKt.d(x7);
        final Function1<String, Unit> function12 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.car_chooser.CarChooserViewModel$requestDriverToken$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String str) {
                LiveEvent liveEvent;
                liveEvent = CarChooserViewModel.this.f27698o;
                liveEvent.o(str);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.car_chooser.p
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CarChooserViewModel.Y(Function1.this, obj);
            }
        };
        final CarChooserViewModel$requestDriverToken$3 carChooserViewModel$requestDriverToken$3 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.car_chooser.CarChooserViewModel$requestDriverToken$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to request driver token!");
            }
        };
        this.f27701r = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.car_chooser.q
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CarChooserViewModel.Z(Function1.this, obj);
            }
        });
    }

    public final void a0(Car car) {
        Intrinsics.f(car, "car");
        if (!this.f27694k.r()) {
            this.f27697n.o(Boolean.TRUE);
            return;
        }
        y().o(Boolean.TRUE);
        this.f27689f.g().f().c(car.a());
        this.f27689f.g().g().b(car.c());
        Single d8 = SingleExtKt.d(this.f27690g.u(car.a()));
        final Function1<EmptyServerResponse, Unit> function1 = new Function1<EmptyServerResponse, Unit>() { // from class: ee.mtakso.driver.ui.screens.car_chooser.CarChooserViewModel$selectCar$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EmptyServerResponse emptyServerResponse) {
                MutableLiveData y7;
                MutableLiveData mutableLiveData;
                y7 = CarChooserViewModel.this.y();
                y7.o(Boolean.FALSE);
                mutableLiveData = CarChooserViewModel.this.f27695l;
                mutableLiveData.o(Boolean.TRUE);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EmptyServerResponse emptyServerResponse) {
                b(emptyServerResponse);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.car_chooser.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CarChooserViewModel.b0(Function1.this, obj);
            }
        };
        final CarChooserViewModel$selectCar$2 carChooserViewModel$selectCar$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.car_chooser.CarChooserViewModel$selectCar$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to select car!");
            }
        };
        this.f27700q = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.car_chooser.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CarChooserViewModel.c0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f27699p;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.f27700q;
        if (disposable2 != null) {
            disposable2.dispose();
        }
    }
}
