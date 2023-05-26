package ee.mtakso.driver.ui.screens.car_chooser;

import ee.mtakso.driver.network.client.driver.Car;
import ee.mtakso.driver.network.client.driver.Cars;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.driver.DriverManager;
import ee.mtakso.driver.ui.screens.car_chooser.CarChooserDelegate;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetDriverCarsInteractor.kt */
/* loaded from: classes3.dex */
public final class GetDriverCarsInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final DriverClient f27715a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverManager f27716b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverProvider f27717c;

    @Inject
    public GetDriverCarsInteractor(DriverClient driverClient, DriverManager driverManager, DriverProvider driverProvider) {
        Intrinsics.f(driverClient, "driverClient");
        Intrinsics.f(driverManager, "driverManager");
        Intrinsics.f(driverProvider, "driverProvider");
        this.f27715a = driverClient;
        this.f27716b = driverManager;
        this.f27717c = driverProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    public Single<List<CarChooserDelegate.Model>> d() {
        Single<Cars> i8 = this.f27715a.i();
        final Function1<Cars, List<? extends CarChooserDelegate.Model>> function1 = new Function1<Cars, List<? extends CarChooserDelegate.Model>>() { // from class: ee.mtakso.driver.ui.screens.car_chooser.GetDriverCarsInteractor$observeScreenData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<CarChooserDelegate.Model> invoke(Cars carResponse) {
                DriverProvider driverProvider;
                List v02;
                List v03;
                int v7;
                boolean z7;
                boolean z8;
                DriverManager driverManager;
                boolean z9;
                Intrinsics.f(carResponse, "carResponse");
                List<Car> a8 = carResponse.a();
                driverProvider = GetDriverCarsInteractor.this.f27717c;
                final long k8 = driverProvider.m().k();
                v02 = CollectionsKt___CollectionsKt.v0(a8, new Comparator() { // from class: ee.mtakso.driver.ui.screens.car_chooser.GetDriverCarsInteractor$observeScreenData$1$invoke$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t7, T t8) {
                        int a9;
                        a9 = ComparisonsKt__ComparisonsKt.a(((Car) t7).c(), ((Car) t8).c());
                        return a9;
                    }
                });
                v03 = CollectionsKt___CollectionsKt.v0(v02, new Comparator() { // from class: ee.mtakso.driver.ui.screens.car_chooser.GetDriverCarsInteractor$observeScreenData$1$invoke$$inlined$sortedByDescending$1
                    @Override // java.util.Comparator
                    public final int compare(T t7, T t8) {
                        boolean z10;
                        int a9;
                        boolean z11 = true;
                        if (((Car) t8).a() == k8) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        Boolean valueOf = Boolean.valueOf(z10);
                        if (((Car) t7).a() != k8) {
                            z11 = false;
                        }
                        a9 = ComparisonsKt__ComparisonsKt.a(valueOf, Boolean.valueOf(z11));
                        return a9;
                    }
                });
                GetDriverCarsInteractor getDriverCarsInteractor = GetDriverCarsInteractor.this;
                v7 = CollectionsKt__IterablesKt.v(v03, 10);
                ArrayList arrayList = new ArrayList(v7);
                int i9 = 0;
                for (Object obj : v03) {
                    int i10 = i9 + 1;
                    if (i9 < 0) {
                        CollectionsKt__CollectionsKt.u();
                    }
                    Car car = (Car) obj;
                    String valueOf = String.valueOf(car.a());
                    if (car.b() != null) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    String b8 = car.b();
                    if (car.a() == k8) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    driverManager = getDriverCarsInteractor.f27716b;
                    boolean r7 = driverManager.r();
                    if (i9 != a8.size() - 1) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    arrayList.add(new CarChooserDelegate.Model(valueOf, car, z7, b8, z8, r7, null, null, 0.0f, false, z9, false, 3008, null));
                    i9 = i10;
                }
                return arrayList;
            }
        };
        Single x7 = i8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.car_chooser.r
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List e8;
                e8 = GetDriverCarsInteractor.e(Function1.this, obj);
                return e8;
            }
        });
        Intrinsics.e(x7, "override fun observeScre…    }\n            }\n    }");
        return x7;
    }
}
