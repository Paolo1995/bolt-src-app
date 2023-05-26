package ee.mtakso.driver.ui.interactor.driver;

import ee.mtakso.driver.network.client.search.OtherDriver;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.driver.other.OtherDriversManager;
import ee.mtakso.driver.service.driver.other.UpdateOtherDriversService;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NearbyDriversInteractor.kt */
/* loaded from: classes3.dex */
public final class NearbyDriversInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final UpdateOtherDriversService f26506a;

    /* renamed from: b  reason: collision with root package name */
    private final OtherDriversManager f26507b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverProvider f26508c;

    @Inject
    public NearbyDriversInteractor(UpdateOtherDriversService otherDriversService, OtherDriversManager otherDriversManager, DriverProvider driverProvider) {
        Intrinsics.f(otherDriversService, "otherDriversService");
        Intrinsics.f(otherDriversManager, "otherDriversManager");
        Intrinsics.f(driverProvider, "driverProvider");
        this.f26506a = otherDriversService;
        this.f26507b = otherDriversManager;
        this.f26508c = driverProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<NearbyDriver> d(List<OtherDriver> list) {
        int v7;
        boolean z7;
        v7 = CollectionsKt__IterablesKt.v(list, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (OtherDriver otherDriver : list) {
            long i8 = this.f26508c.m().i();
            Long d8 = otherDriver.d();
            if (d8 != null && i8 == d8.longValue()) {
                z7 = true;
            } else {
                z7 = false;
            }
            arrayList.add(new NearbyDriver(z7, otherDriver, otherDriver.c()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(NearbyDriversInteractor this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.f26506a.stop();
    }

    public final Observable<List<NearbyDriver>> e() {
        this.f26506a.start();
        Observable<List<OtherDriver>> d8 = this.f26507b.d();
        final Function1<List<? extends OtherDriver>, List<? extends NearbyDriver>> function1 = new Function1<List<? extends OtherDriver>, List<? extends NearbyDriver>>() { // from class: ee.mtakso.driver.ui.interactor.driver.NearbyDriversInteractor$observeNearbyDrivers$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<NearbyDriver> invoke(List<OtherDriver> it) {
                List<NearbyDriver> d9;
                Intrinsics.f(it, "it");
                d9 = NearbyDriversInteractor.this.d(it);
                return d9;
            }
        };
        Observable<List<NearbyDriver>> doOnDispose = d8.map(new Function() { // from class: ee.mtakso.driver.ui.interactor.driver.j
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List f8;
                f8 = NearbyDriversInteractor.f(Function1.this, obj);
                return f8;
            }
        }).doOnDispose(new Action() { // from class: ee.mtakso.driver.ui.interactor.driver.k
            @Override // io.reactivex.functions.Action
            public final void run() {
                NearbyDriversInteractor.g(NearbyDriversInteractor.this);
            }
        });
        Intrinsics.e(doOnDispose, "fun observeNearbyDrivers…ersService.stop() }\n    }");
        return doOnDispose;
    }
}
