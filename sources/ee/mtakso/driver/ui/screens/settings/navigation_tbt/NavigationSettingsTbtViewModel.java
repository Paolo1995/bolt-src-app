package ee.mtakso.driver.ui.screens.settings.navigation_tbt;

import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.R;
import ee.mtakso.driver.navigation.NavigationAppTypeFactory;
import ee.mtakso.driver.navigation.navigators.ExternalNavigator;
import ee.mtakso.driver.navigation.navigators.Navigator;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.screens.earnings.v3.common.StaticItemDelegate;
import ee.mtakso.driver.ui.screens.settings.navigation_tbt.NavigationSettingsTbtViewModel;
import ee.mtakso.driver.ui.screens.settings.navigation_tbt.delegates.NavigationHeaderItemDelegate;
import ee.mtakso.driver.ui.screens.settings.navigation_tbt.delegates.SelectorDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.DividerDelegate;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.driver.core.util.ObservableExtKt;
import io.reactivex.Observable;
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
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigationSettingsTbtViewModel.kt */
/* loaded from: classes5.dex */
public final class NavigationSettingsTbtViewModel extends BaseViewModel {

    /* renamed from: k  reason: collision with root package name */
    public static final Companion f33215k = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final DriverProvider f33216f;

    /* renamed from: g  reason: collision with root package name */
    private final PlatformManager f33217g;

    /* renamed from: h  reason: collision with root package name */
    private final NavigationAppTypeFactory f33218h;

    /* renamed from: i  reason: collision with root package name */
    private final List<ExternalNavigator> f33219i;

    /* renamed from: j  reason: collision with root package name */
    private final MutableLiveData<NavigationSettingsTbtViewState> f33220j;

    /* compiled from: NavigationSettingsTbtViewModel.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public NavigationSettingsTbtViewModel(DriverProvider driverProvider, PlatformManager platformManager, NavigationAppTypeFactory navigationAppTypeFactory) {
        List<ExternalNavigator> v02;
        boolean z7;
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(platformManager, "platformManager");
        Intrinsics.f(navigationAppTypeFactory, "navigationAppTypeFactory");
        this.f33216f = driverProvider;
        this.f33217g = platformManager;
        this.f33218h = navigationAppTypeFactory;
        Collection<Navigator> a8 = navigationAppTypeFactory.a();
        ArrayList arrayList = new ArrayList();
        for (Object obj : a8) {
            if (obj instanceof ExternalNavigator) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            ExternalNavigator externalNavigator = (ExternalNavigator) obj2;
            if (!externalNavigator.g() && (externalNavigator.i() || externalNavigator.h() || externalNavigator.b())) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                arrayList2.add(obj2);
            }
        }
        v02 = CollectionsKt___CollectionsKt.v0(arrayList2, new Comparator() { // from class: ee.mtakso.driver.ui.screens.settings.navigation_tbt.NavigationSettingsTbtViewModel$special$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t7, T t8) {
                int a9;
                a9 = ComparisonsKt__ComparisonsKt.a(Boolean.valueOf(((ExternalNavigator) t8).i()), Boolean.valueOf(((ExternalNavigator) t7).i()));
                return a9;
            }
        });
        this.f33219i = v02;
        this.f33220j = new MutableLiveData<>(I());
    }

    private final DividerDelegate.Model H(String str) {
        return new DividerDelegate.Model(str, Dimens.c(1), 0, new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.backPrimary), Dimens.c(24), Dimens.c(24), 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavigationSettingsTbtViewState I() {
        List q8;
        List S;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.f33219i.iterator();
        while (true) {
            boolean z7 = false;
            if (!it.hasNext()) {
                break;
            }
            ExternalNavigator externalNavigator = (ExternalNavigator) it.next();
            String name = externalNavigator.getType().name();
            Text.Resource resource = new Text.Resource(externalNavigator.e(), null, 2, null);
            if (externalNavigator.getType() == this.f33216f.v().r().a()) {
                z7 = true;
            }
            arrayList.add(new SelectorDelegate.Model(name, resource, z7, externalNavigator.i()));
            String name2 = externalNavigator.getType().name();
            arrayList.add(H("Separator " + name2));
        }
        q8 = CollectionsKt__CollectionsKt.q(new NavigationHeaderItemDelegate.Model("Internal header", new Text.Resource(R.string.settings_default_navigation_tbt_title, null, 2, null), new Text.Resource(R.string.settings_default_navigation_tbt_subtitle, null, 2, null), 16), new SelectorDelegate.Model("Internal Selector", new Text.Resource(R.string.settings_default_navigation_tbt_internal, null, 2, null), !this.f33216f.v().f().a(), true), H("Selector Separator"), new SelectorDelegate.Model("External Selector", new Text.Resource(R.string.settings_default_navigation_tbt_external, null, 2, null), this.f33216f.v().f().a(), false), new StaticItemDelegate.Model.List("Bottom Corner Default Navigation", R.layout.background_rounded_bottom_corners, null, 4, null), new DividerDelegate.Model("Spacer", Dimens.c(8), 0, null, new Color.Attr(R.attr.backTertiary), 0, 0, 108, null), new StaticItemDelegate.Model.List("Top Corners", R.layout.background_rounded_top_corners, null, 4, null), new NavigationHeaderItemDelegate.Model("External header", new Text.Resource(R.string.settings_external_navigation_tbt_title, null, 2, null), new Text.Resource(R.string.settings_default_navigation_tbt_subtitle, null, 2, null), 0, 8, null));
        if (!arrayList.isEmpty()) {
            S = CollectionsKt___CollectionsKt.S(arrayList, 1);
            q8.addAll(S);
        }
        q8.add(new StaticItemDelegate.Model.List("Bottom Corner External Navigation", R.layout.background_rounded_bottom_corners, null, 4, null));
        return new NavigationSettingsTbtViewState(q8);
    }

    private final void J(boolean z7) {
        this.f33216f.v().f().b(z7);
        this.f33220j.o(I());
    }

    private final void K(ExternalNavigator externalNavigator) {
        if (!externalNavigator.b()) {
            this.f33216f.v().f0(externalNavigator.getType());
            this.f33217g.a(externalNavigator.f());
            return;
        }
        this.f33216f.v().r().c(externalNavigator.getType());
        this.f33216f.v().T();
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

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        Observable a8 = ObservableExtKt.a(this.f33216f.v().r().b());
        final Function1<Navigator.Type, Unit> function1 = new Function1<Navigator.Type, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.navigation_tbt.NavigationSettingsTbtViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Navigator.Type type) {
                MutableLiveData mutableLiveData;
                NavigationSettingsTbtViewState I;
                mutableLiveData = NavigationSettingsTbtViewModel.this.f33220j;
                I = NavigationSettingsTbtViewModel.this.I();
                mutableLiveData.o(I);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Navigator.Type type) {
                b(type);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: b5.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NavigationSettingsTbtViewModel.O(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.navigation_tbt.NavigationSettingsTbtViewModel$onStart$2
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
                NavigationSettingsTbtViewModel navigationSettingsTbtViewModel = NavigationSettingsTbtViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(navigationSettingsTbtViewModel, it, null, 2, null);
            }
        };
        Disposable subscribe = a8.subscribe(consumer, new Consumer() { // from class: b5.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NavigationSettingsTbtViewModel.P(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun onStart() {…    ).autoDispose()\n    }");
        v(subscribe);
    }

    public final MutableLiveData<NavigationSettingsTbtViewState> L() {
        return this.f33220j;
    }

    public final void M(SelectorDelegate.Model model) {
        Object obj;
        Intrinsics.f(model, "model");
        String m8 = model.m();
        if (Intrinsics.a(m8, "Internal Selector")) {
            J(false);
        } else if (Intrinsics.a(m8, "External Selector")) {
            J(true);
        } else {
            Iterator<T> it = this.f33219i.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.a(((ExternalNavigator) obj).getType().name(), model.m())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            ExternalNavigator externalNavigator = (ExternalNavigator) obj;
            if (externalNavigator != null) {
                K(externalNavigator);
            }
        }
    }

    public final void N() {
        Navigator.Type y7 = this.f33216f.v().y();
        if (y7 != null) {
            Navigator c8 = this.f33218h.c(y7);
            if (c8.b()) {
                this.f33216f.v().r().c(c8.getType());
                this.f33216f.v().T();
            }
        }
    }
}
