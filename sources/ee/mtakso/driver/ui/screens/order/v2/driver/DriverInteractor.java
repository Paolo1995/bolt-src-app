package ee.mtakso.driver.ui.screens.order.v2.driver;

import ee.mtakso.driver.navigation.NavigationAppTypeFactory;
import ee.mtakso.driver.navigation.navigators.Navigator;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOption;
import ee.mtakso.driver.ui.screens.order.v2.driver.DriverData;
import ee.mtakso.driver.ui.screens.order.v2.driver.DriverInteractor;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverInteractor.kt */
/* loaded from: classes3.dex */
public final class DriverInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f32075a;

    /* renamed from: b  reason: collision with root package name */
    private final NavigationAppTypeFactory f32076b;

    @Inject
    public DriverInteractor(DriverProvider driverProvider, NavigationAppTypeFactory navigatorProvider) {
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(navigatorProvider, "navigatorProvider");
        this.f32075a = driverProvider;
        this.f32076b = navigatorProvider;
    }

    private final Observable<DriverData> e() {
        Observable<NavigationOption> b8 = this.f32075a.v().I().b();
        final Function1<NavigationOption, DriverData> function1 = new Function1<NavigationOption, DriverData>() { // from class: ee.mtakso.driver.ui.screens.order.v2.driver.DriverInteractor$callDynamicNavigation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final DriverData invoke(NavigationOption it) {
                DriverData j8;
                Intrinsics.f(it, "it");
                j8 = DriverInteractor.this.j(Navigator.Type.NO_NAVIGATION_SELECTED, it);
                return j8;
            }
        };
        return b8.map(new Function() { // from class: x4.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DriverData f8;
                f8 = DriverInteractor.f(Function1.this, obj);
                return f8;
            }
        }).startWith((Observable<R>) j(Navigator.Type.NO_NAVIGATION_SELECTED, this.f32075a.v().I().a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DriverData f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (DriverData) tmp0.invoke(obj);
    }

    private final Observable<DriverData> g() {
        Observable<Navigator.Type> b8 = this.f32075a.v().r().b();
        final Function1<Navigator.Type, DriverData> function1 = new Function1<Navigator.Type, DriverData>() { // from class: ee.mtakso.driver.ui.screens.order.v2.driver.DriverInteractor$callNavigator$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final DriverData invoke(Navigator.Type it) {
                DriverData j8;
                Intrinsics.f(it, "it");
                j8 = DriverInteractor.this.j(it, null);
                return j8;
            }
        };
        return b8.map(new Function() { // from class: x4.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DriverData h8;
                h8 = DriverInteractor.h(Function1.this, obj);
                return h8;
            }
        }).startWith((Observable<R>) j(this.f32075a.t().r().a(), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DriverData h(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (DriverData) tmp0.invoke(obj);
    }

    private final boolean i() {
        return this.f32075a.q().J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DriverData j(Navigator.Type type, NavigationOption navigationOption) {
        boolean z7;
        Navigator c8 = this.f32076b.c(type);
        if (!i() && this.f32075a.m().I()) {
            z7 = true;
        } else {
            z7 = false;
        }
        return new DriverData(c8, z7, i(), navigationOption);
    }

    public final Observable<DriverData> d() {
        if (this.f32075a.q().r()) {
            Observable<DriverData> e8 = e();
            Intrinsics.e(e8, "{\n            callDynamicNavigation()\n        }");
            return e8;
        }
        Observable<DriverData> g8 = g();
        Intrinsics.e(g8, "{\n            callNavigator()\n        }");
        return g8;
    }
}
