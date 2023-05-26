package ee.mtakso.driver.ui.screens.navigator_chooser;

import ee.mtakso.driver.navigation.DynamicNavigationMapper;
import ee.mtakso.driver.network.client.driver.navigation.DriverNavigationConfigurationClient;
import ee.mtakso.driver.network.client.driver.navigation.DynamicNavigation;
import ee.mtakso.driver.network.client.driver.navigation.DynamicNavigationOption;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOptionsInteractor;
import ee.mtakso.driver.utils.AppResolver;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigationOptionsInteractor.kt */
/* loaded from: classes3.dex */
public final class NavigationOptionsInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final DriverNavigationConfigurationClient f30895a;

    /* renamed from: b  reason: collision with root package name */
    private final AppResolver f30896b;

    /* renamed from: c  reason: collision with root package name */
    private final DynamicNavigationMapper f30897c;

    @Inject
    public NavigationOptionsInteractor(DriverNavigationConfigurationClient driverNavigationConfigurationClient, AppResolver appResolver, DynamicNavigationMapper dynamicNavigationMapper) {
        Intrinsics.f(driverNavigationConfigurationClient, "driverNavigationConfigurationClient");
        Intrinsics.f(appResolver, "appResolver");
        Intrinsics.f(dynamicNavigationMapper, "dynamicNavigationMapper");
        this.f30895a = driverNavigationConfigurationClient;
        this.f30896b = appResolver;
        this.f30897c = dynamicNavigationMapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<NavigationOption> e(DynamicNavigation dynamicNavigation) {
        boolean z7;
        DynamicNavigationMapper dynamicNavigationMapper = this.f30897c;
        List<DynamicNavigationOption> a8 = dynamicNavigation.a();
        ArrayList arrayList = new ArrayList();
        for (Object obj : a8) {
            if (obj instanceof DynamicNavigationOption.ThirdParty) {
                arrayList.add(obj);
            }
        }
        List<NavigationOption> a9 = dynamicNavigationMapper.a(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : a9) {
            NavigationOption navigationOption = (NavigationOption) obj2;
            if (!NavigationOptionKt.a(navigationOption, this.f30896b) && !navigationOption.getRecommended()) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (z7) {
                arrayList2.add(obj2);
            }
        }
        return arrayList2;
    }

    public final Single<List<NavigationOption>> c() {
        Single d8 = SingleExtKt.d(this.f30895a.b());
        final Function1<DynamicNavigation, List<? extends NavigationOption>> function1 = new Function1<DynamicNavigation, List<? extends NavigationOption>>() { // from class: ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOptionsInteractor$getDynamicNavigationOptions$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<NavigationOption> invoke(DynamicNavigation it) {
                List<NavigationOption> e8;
                Intrinsics.f(it, "it");
                e8 = NavigationOptionsInteractor.this.e(it);
                return e8;
            }
        };
        Single<List<NavigationOption>> x7 = d8.x(new Function() { // from class: m4.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List d9;
                d9 = NavigationOptionsInteractor.d(Function1.this, obj);
                return d9;
            }
        });
        Intrinsics.e(x7, "fun getDynamicNavigation…(it)\n            }\n\n    }");
        return x7;
    }
}
