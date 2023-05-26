package ee.mtakso.driver.ui.screens.vehicle;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.network.client.vehicle.Car;
import ee.mtakso.driver.network.client.vehicle.CarApplicationClient;
import ee.mtakso.driver.network.client.vehicle.VehiclesAndApplications;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.driver.DriverManager;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.interactor.portal.DriverPortalTokenInteractor;
import ee.mtakso.driver.utils.ChromeCustomTabsUrlLauncher;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import ee.mtakso.driver.utils.SystemUrlLauncher;
import ee.mtakso.driver.utils.UrlFactory;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VehicleListViewModel.kt */
/* loaded from: classes5.dex */
public final class VehicleListViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final DriverPortalTokenInteractor f33519f;

    /* renamed from: g  reason: collision with root package name */
    private final UrlFactory f33520g;

    /* renamed from: h  reason: collision with root package name */
    private final DriverManager f33521h;

    /* renamed from: i  reason: collision with root package name */
    private final DriverProvider f33522i;

    /* renamed from: j  reason: collision with root package name */
    private final DriverClient f33523j;

    /* renamed from: k  reason: collision with root package name */
    private final CarApplicationClient f33524k;

    /* renamed from: l  reason: collision with root package name */
    private Disposable f33525l;

    /* renamed from: m  reason: collision with root package name */
    private Disposable f33526m;

    /* renamed from: n  reason: collision with root package name */
    private Disposable f33527n;

    /* renamed from: o  reason: collision with root package name */
    private final MutableLiveData<Unit> f33528o;

    /* renamed from: p  reason: collision with root package name */
    private final MutableLiveData<VehiclesAndApplications> f33529p;

    /* renamed from: q  reason: collision with root package name */
    private final LiveData<VehiclesAndApplications> f33530q;

    @Inject
    public VehicleListViewModel(DriverPortalTokenInteractor driverPortalTokenInteractor, UrlFactory urlFactory, DriverManager driverManager, DriverProvider driverProvider, DriverClient driverApiClient, CarApplicationClient carApplicationClient) {
        Intrinsics.f(driverPortalTokenInteractor, "driverPortalTokenInteractor");
        Intrinsics.f(urlFactory, "urlFactory");
        Intrinsics.f(driverManager, "driverManager");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(driverApiClient, "driverApiClient");
        Intrinsics.f(carApplicationClient, "carApplicationClient");
        this.f33519f = driverPortalTokenInteractor;
        this.f33520g = urlFactory;
        this.f33521h = driverManager;
        this.f33522i = driverProvider;
        this.f33523j = driverApiClient;
        this.f33524k = carApplicationClient;
        this.f33528o = new MutableLiveData<>();
        MutableLiveData<VehiclesAndApplications> mutableLiveData = new MutableLiveData<>();
        this.f33529p = mutableLiveData;
        this.f33530q = mutableLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(String str, Context context) {
        ChromeCustomTabsUrlLauncher chromeCustomTabsUrlLauncher = new ChromeCustomTabsUrlLauncher(context);
        chromeCustomTabsUrlLauncher.b(false);
        new CompositeUrlLauncher(chromeCustomTabsUrlLauncher, new SystemUrlLauncher(context)).a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        b0();
    }

    public final void O(final Context context) {
        Intrinsics.f(context, "context");
        Single l8 = l(SingleExtKt.d(this.f33519f.b()));
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.vehicle.VehicleListViewModel$createVehicleApplication$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(String it) {
                UrlFactory urlFactory;
                VehicleListViewModel vehicleListViewModel = VehicleListViewModel.this;
                urlFactory = vehicleListViewModel.f33520g;
                Intrinsics.e(it, "it");
                vehicleListViewModel.X(urlFactory.h(it), context);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.vehicle.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VehicleListViewModel.P(Function1.this, obj);
            }
        };
        final VehicleListViewModel$createVehicleApplication$2 vehicleListViewModel$createVehicleApplication$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.vehicle.VehicleListViewModel$createVehicleApplication$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to create vehicle application");
            }
        };
        this.f33526m = l8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.vehicle.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VehicleListViewModel.Q(Function1.this, obj);
            }
        });
    }

    public final MutableLiveData<Unit> R() {
        return this.f33528o;
    }

    public final long S() {
        return this.f33522i.n().k();
    }

    public final MutableLiveData<VehiclesAndApplications> T() {
        return this.f33529p;
    }

    public final Car U(long j8) {
        Object obj;
        boolean z7;
        Iterator<T> it = ((VehiclesAndApplications) LiveDataExtKt.b(this.f33530q)).b().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((Car) obj).a() == j8) {
                    z7 = true;
                    continue;
                } else {
                    z7 = false;
                    continue;
                }
                if (z7) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            return (Car) obj;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final LiveData<VehiclesAndApplications> V() {
        return this.f33530q;
    }

    public final boolean W() {
        return this.f33521h.r();
    }

    public final void Y(final long j8, final Context context) {
        Intrinsics.f(context, "context");
        Single l8 = l(SingleExtKt.d(this.f33519f.b()));
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.vehicle.VehicleListViewModel$openVehicleApplication$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(String token) {
                UrlFactory urlFactory;
                VehicleListViewModel vehicleListViewModel = VehicleListViewModel.this;
                urlFactory = vehicleListViewModel.f33520g;
                Intrinsics.e(token, "token");
                vehicleListViewModel.X(urlFactory.e(token, j8), context);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.vehicle.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VehicleListViewModel.Z(Function1.this, obj);
            }
        };
        final VehicleListViewModel$openVehicleApplication$2 vehicleListViewModel$openVehicleApplication$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.vehicle.VehicleListViewModel$openVehicleApplication$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to create vehicle application");
            }
        };
        this.f33526m = l8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.vehicle.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VehicleListViewModel.a0(Function1.this, obj);
            }
        });
    }

    public final void b0() {
        if (!DisposableExtKt.b(this.f33527n)) {
            return;
        }
        Single l8 = l(SingleExtKt.d(this.f33524k.b()));
        final Function1<VehiclesAndApplications, Unit> function1 = new Function1<VehiclesAndApplications, Unit>() { // from class: ee.mtakso.driver.ui.screens.vehicle.VehicleListViewModel$reloadCarList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(VehiclesAndApplications vehiclesAndApplications) {
                VehicleListViewModel.this.T().o(vehiclesAndApplications);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VehiclesAndApplications vehiclesAndApplications) {
                b(vehiclesAndApplications);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.vehicle.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VehicleListViewModel.c0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.vehicle.VehicleListViewModel$reloadCarList$2
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
                VehicleListViewModel vehicleListViewModel = VehicleListViewModel.this;
                Intrinsics.e(it, "it");
                vehicleListViewModel.z(it, "Failed to load vehicles");
            }
        };
        this.f33527n = l8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.vehicle.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VehicleListViewModel.d0(Function1.this, obj);
            }
        });
    }

    public final boolean e0(long j8) {
        if (!this.f33521h.r()) {
            return false;
        }
        Car U = U(j8);
        y().o(Boolean.TRUE);
        this.f33522i.g().f().c(j8);
        this.f33522i.g().g().b(U.c());
        Single d8 = SingleExtKt.d(this.f33523j.u(j8));
        final Function1<EmptyServerResponse, Unit> function1 = new Function1<EmptyServerResponse, Unit>() { // from class: ee.mtakso.driver.ui.screens.vehicle.VehicleListViewModel$selectVehicle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EmptyServerResponse emptyServerResponse) {
                MutableLiveData y7;
                y7 = VehicleListViewModel.this.y();
                y7.o(Boolean.FALSE);
                VehicleListViewModel.this.R().o(Unit.f50853a);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EmptyServerResponse emptyServerResponse) {
                b(emptyServerResponse);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.vehicle.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VehicleListViewModel.f0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.vehicle.VehicleListViewModel$selectVehicle$2
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
                VehicleListViewModel vehicleListViewModel = VehicleListViewModel.this;
                Intrinsics.e(it, "it");
                vehicleListViewModel.z(it, "Failed to select car");
            }
        };
        this.f33525l = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.vehicle.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VehicleListViewModel.g0(Function1.this, obj);
            }
        });
        return true;
    }
}
