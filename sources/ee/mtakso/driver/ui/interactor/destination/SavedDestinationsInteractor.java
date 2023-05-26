package ee.mtakso.driver.ui.interactor.destination;

import ee.mtakso.driver.network.client.settings.DriverDestination;
import ee.mtakso.driver.network.client.settings.DriverDestinations;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.ui.interactor.destination.SavedDestinationsInteractor;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SavedDestinationsInteractor.kt */
/* loaded from: classes3.dex */
public final class SavedDestinationsInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final DriverDestinationsManager f26434a;

    @Inject
    public SavedDestinationsInteractor(DriverDestinationsManager destinationsManager) {
        Intrinsics.f(destinationsManager, "destinationsManager");
        this.f26434a = destinationsManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<DriverDestination> f(List<DriverDestination> list) {
        List<DriverDestination> v02;
        if (list.size() < 2) {
            return list;
        }
        v02 = CollectionsKt___CollectionsKt.v0(list, new Comparator() { // from class: r2.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int g8;
                g8 = SavedDestinationsInteractor.g((DriverDestination) obj, (DriverDestination) obj2);
                return g8;
            }
        });
        return v02;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int g(DriverDestination destination1, DriverDestination destination2) {
        Intrinsics.f(destination1, "destination1");
        Intrinsics.f(destination2, "destination2");
        if (Intrinsics.a(destination1.f(), "home")) {
            return -1;
        }
        if (Intrinsics.a(destination1.f(), "favorite") && !Intrinsics.a(destination2.f(), "home")) {
            return -1;
        }
        return 0;
    }

    public final Single<List<DriverDestination>> d() {
        Single<DriverDestinations> B = this.f26434a.B();
        final Function1<DriverDestinations, List<? extends DriverDestination>> function1 = new Function1<DriverDestinations, List<? extends DriverDestination>>() { // from class: ee.mtakso.driver.ui.interactor.destination.SavedDestinationsInteractor$call$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<DriverDestination> invoke(DriverDestinations it) {
                List<DriverDestination> f8;
                Intrinsics.f(it, "it");
                SavedDestinationsInteractor savedDestinationsInteractor = SavedDestinationsInteractor.this;
                List<DriverDestination> a8 = it.a();
                if (a8 == null) {
                    a8 = CollectionsKt__CollectionsKt.k();
                }
                f8 = savedDestinationsInteractor.f(a8);
                return f8;
            }
        };
        Single<R> x7 = B.x(new Function() { // from class: r2.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List e8;
                e8 = SavedDestinationsInteractor.e(Function1.this, obj);
                return e8;
            }
        });
        Intrinsics.e(x7, "fun call(): Single<List<…applyIOSchedulers()\n    }");
        return SingleExtKt.d(x7);
    }
}
