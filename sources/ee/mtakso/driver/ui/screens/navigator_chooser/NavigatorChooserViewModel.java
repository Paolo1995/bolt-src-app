package ee.mtakso.driver.ui.screens.navigator_chooser;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.navigation.NavigationAppTypeFactory;
import ee.mtakso.driver.navigation.navigators.ExternalNavigator;
import ee.mtakso.driver.navigation.navigators.Navigator;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOption;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigatorChooserViewModel;
import ee.mtakso.driver.utils.AppResolver;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigatorChooserViewModel.kt */
/* loaded from: classes3.dex */
public final class NavigatorChooserViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final NavigationAppTypeFactory f30930f;

    /* renamed from: g  reason: collision with root package name */
    private final PlatformManager f30931g;

    /* renamed from: h  reason: collision with root package name */
    private final DriverProvider f30932h;

    /* renamed from: i  reason: collision with root package name */
    private final DriverFeatures f30933i;

    /* renamed from: j  reason: collision with root package name */
    private final NavigationOptionsInteractor f30934j;

    /* renamed from: k  reason: collision with root package name */
    private final AppResolver f30935k;

    /* renamed from: l  reason: collision with root package name */
    private final MutableLiveData<NavigatorChooserState> f30936l;

    /* renamed from: m  reason: collision with root package name */
    private final LiveEvent<Object> f30937m;

    /* renamed from: n  reason: collision with root package name */
    private final MutableLiveData<DynamicNavigationState> f30938n;

    @Inject
    public NavigatorChooserViewModel(NavigationAppTypeFactory navigationAppTypeFactory, PlatformManager platformManager, DriverProvider driverProvider, DriverFeatures driverFeatures, NavigationOptionsInteractor navigationOptionsInteractor, AppResolver appResolver) {
        Intrinsics.f(navigationAppTypeFactory, "navigationAppTypeFactory");
        Intrinsics.f(platformManager, "platformManager");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(driverFeatures, "driverFeatures");
        Intrinsics.f(navigationOptionsInteractor, "navigationOptionsInteractor");
        Intrinsics.f(appResolver, "appResolver");
        this.f30930f = navigationAppTypeFactory;
        this.f30931g = platformManager;
        this.f30932h = driverProvider;
        this.f30933i = driverFeatures;
        this.f30934j = navigationOptionsInteractor;
        this.f30935k = appResolver;
        this.f30936l = new MutableLiveData<>();
        this.f30937m = new LiveEvent<>();
        this.f30938n = new MutableLiveData<>();
    }

    private final boolean H(Navigator.Type type) {
        if (type == Navigator.Type.NO_NAVIGATION_SELECTED) {
            return false;
        }
        return this.f30930f.c(type).b();
    }

    private final void I(Navigator.Type type) {
        ExternalNavigator b8 = this.f30930f.b(type);
        if (b8 == null) {
            return;
        }
        this.f30932h.v().f0(type);
        this.f30931g.a(b8.f());
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

    private final void R() {
        if (this.f30938n.f() != null) {
            MutableLiveData<DynamicNavigationState> mutableLiveData = this.f30938n;
            DynamicNavigationState f8 = mutableLiveData.f();
            DynamicNavigationState dynamicNavigationState = null;
            if (f8 != null) {
                dynamicNavigationState = DynamicNavigationState.b(f8, null, this.f30932h.v().I().a(), 1, null);
            }
            mutableLiveData.o(dynamicNavigationState);
        }
    }

    private final void S() {
        Navigator.Type type;
        List<ExternalNavigator> v02;
        int v7;
        boolean z7;
        NavigatorChooserState f8 = this.f30936l.f();
        if (f8 == null || (type = f8.c()) == null) {
            type = Navigator.Type.NO_NAVIGATION_SELECTED;
        }
        NavigatorChooserState f9 = this.f30936l.f();
        if (f9 == null) {
            Collection<Navigator> a8 = this.f30930f.a();
            ArrayList arrayList = new ArrayList();
            for (Object obj : a8) {
                if (obj instanceof ExternalNavigator) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (true) {
                boolean z8 = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                ExternalNavigator externalNavigator = (ExternalNavigator) next;
                if (externalNavigator.g() || (!externalNavigator.i() && !externalNavigator.h() && !externalNavigator.b())) {
                    z8 = false;
                }
                if (z8) {
                    arrayList2.add(next);
                }
            }
            v02 = CollectionsKt___CollectionsKt.v0(arrayList2, new Comparator() { // from class: ee.mtakso.driver.ui.screens.navigator_chooser.NavigatorChooserViewModel$restoreStaticSelection$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t7, T t8) {
                    int a9;
                    a9 = ComparisonsKt__ComparisonsKt.a(Boolean.valueOf(((ExternalNavigator) t8).i()), Boolean.valueOf(((ExternalNavigator) t7).i()));
                    return a9;
                }
            });
            v7 = CollectionsKt__IterablesKt.v(v02, 10);
            ArrayList arrayList3 = new ArrayList(v7);
            for (ExternalNavigator externalNavigator2 : v02) {
                if (type == externalNavigator2.getType()) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                arrayList3.add(new NavigatorItem(externalNavigator2, z7));
            }
            f9 = new NavigatorChooserState(arrayList3, type);
        }
        this.f30936l.o(V(f9));
    }

    private final void T() {
        NavigationOption d8;
        DynamicNavigationState f8 = this.f30938n.f();
        if (f8 != null && (d8 = f8.d()) != null) {
            this.f30932h.v().I().c(d8);
        }
        this.f30932h.v().s().b(true);
    }

    private final void U() {
        Navigator.Type type;
        NavigatorChooserState f8 = this.f30936l.f();
        if (f8 == null || (type = f8.c()) == null) {
            type = Navigator.Type.NO_NAVIGATION_SELECTED;
        }
        this.f30932h.v().T();
        this.f30932h.v().s().b(true);
        if (H(type)) {
            this.f30932h.v().c0(type);
        }
    }

    private final NavigatorChooserState V(NavigatorChooserState navigatorChooserState) {
        int v7;
        boolean z7;
        int v8;
        boolean z8;
        int v9;
        boolean z9;
        Navigator.Type a8 = this.f30932h.v().r().a();
        Navigator.Type y7 = this.f30932h.v().y();
        if (y7 != null && H(y7)) {
            List<NavigatorItem> b8 = navigatorChooserState.b();
            v9 = CollectionsKt__IterablesKt.v(b8, 10);
            ArrayList arrayList = new ArrayList(v9);
            for (NavigatorItem navigatorItem : b8) {
                if (navigatorItem.c().getType() == y7) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                arrayList.add(NavigatorItem.b(navigatorItem, null, z9, 1, null));
            }
            return navigatorChooserState.a(arrayList, y7);
        } else if (y7 != null && !H(y7)) {
            this.f30932h.v().T();
            List<NavigatorItem> b9 = navigatorChooserState.b();
            v8 = CollectionsKt__IterablesKt.v(b9, 10);
            ArrayList arrayList2 = new ArrayList(v8);
            for (NavigatorItem navigatorItem2 : b9) {
                if (navigatorItem2.c().getType() == a8) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                arrayList2.add(NavigatorItem.b(navigatorItem2, null, z8, 1, null));
            }
            return navigatorChooserState.a(arrayList2, a8);
        } else {
            List<NavigatorItem> b10 = navigatorChooserState.b();
            v7 = CollectionsKt__IterablesKt.v(b10, 10);
            ArrayList arrayList3 = new ArrayList(v7);
            for (NavigatorItem navigatorItem3 : b10) {
                if (navigatorItem3.c().getType() == a8) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                arrayList3.add(NavigatorItem.b(navigatorItem3, null, z7, 1, null));
            }
            return navigatorChooserState.a(arrayList3, a8);
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        if (this.f30933i.r()) {
            Single d8 = SingleExtKt.d(this.f30934j.c());
            final Function1<List<? extends NavigationOption>, Unit> function1 = new Function1<List<? extends NavigationOption>, Unit>() { // from class: ee.mtakso.driver.ui.screens.navigator_chooser.NavigatorChooserViewModel$onStart$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void b(List<NavigationOption> it) {
                    MutableLiveData mutableLiveData;
                    DriverProvider driverProvider;
                    mutableLiveData = NavigatorChooserViewModel.this.f30938n;
                    Intrinsics.e(it, "it");
                    driverProvider = NavigatorChooserViewModel.this.f30932h;
                    mutableLiveData.o(new DynamicNavigationState(it, driverProvider.v().I().a()));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends NavigationOption> list) {
                    b(list);
                    return Unit.f50853a;
                }
            };
            Consumer consumer = new Consumer() { // from class: m4.i
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    NavigatorChooserViewModel.P(Function1.this, obj);
                }
            };
            final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.navigator_chooser.NavigatorChooserViewModel$onStart$2
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
                    NavigatorChooserViewModel navigatorChooserViewModel = NavigatorChooserViewModel.this;
                    Intrinsics.e(it, "it");
                    BaseViewModel.A(navigatorChooserViewModel, it, null, 2, null);
                }
            };
            Disposable I = d8.I(consumer, new Consumer() { // from class: m4.j
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    NavigatorChooserViewModel.Q(Function1.this, obj);
                }
            });
            Intrinsics.e(I, "override fun onStart() {…Dispose()\n        }\n    }");
            v(I);
        }
    }

    public final LiveData<Object> J() {
        return this.f30937m;
    }

    public final LiveData<DynamicNavigationState> K() {
        return this.f30938n;
    }

    public final LiveData<NavigatorChooserState> L() {
        return this.f30936l;
    }

    public final void M(NavigationOption item) {
        DynamicNavigationState dynamicNavigationState;
        Intrinsics.f(item, "item");
        MutableLiveData<DynamicNavigationState> mutableLiveData = this.f30938n;
        DynamicNavigationState f8 = mutableLiveData.f();
        String str = null;
        if (f8 != null) {
            dynamicNavigationState = DynamicNavigationState.b(f8, null, item, 1, null);
        } else {
            dynamicNavigationState = null;
        }
        mutableLiveData.o(dynamicNavigationState);
        if (NavigationOptionKt.a(item, this.f30935k)) {
            T();
            return;
        }
        PlatformManager platformManager = this.f30931g;
        NavigationOption.IntentDataHolder intentDataHolder = item.getIntentDataHolder();
        if (intentDataHolder != null) {
            str = intentDataHolder.getPackageName();
        }
        platformManager.a(str);
    }

    public final void N(NavigatorItem item) {
        List<NavigatorItem> k8;
        List<NavigatorItem> b8;
        int v7;
        boolean z7;
        Intrinsics.f(item, "item");
        Navigator.Type type = item.c().getType();
        NavigatorChooserState f8 = this.f30936l.f();
        NavigatorChooserState navigatorChooserState = null;
        if (f8 != null && (b8 = f8.b()) != null) {
            v7 = CollectionsKt__IterablesKt.v(b8, 10);
            k8 = new ArrayList<>(v7);
            for (NavigatorItem navigatorItem : b8) {
                if (navigatorItem.c().getType() == type) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                k8.add(NavigatorItem.b(navigatorItem, null, z7, 1, null));
            }
        } else {
            k8 = CollectionsKt__CollectionsKt.k();
        }
        MutableLiveData<NavigatorChooserState> mutableLiveData = this.f30936l;
        NavigatorChooserState f9 = mutableLiveData.f();
        if (f9 != null) {
            navigatorChooserState = f9.a(k8, item.c().getType());
        }
        mutableLiveData.o(navigatorChooserState);
        if (H(type)) {
            U();
        } else {
            I(type);
        }
    }

    public final void O() {
        if (this.f30933i.r()) {
            R();
        } else {
            S();
        }
    }
}
