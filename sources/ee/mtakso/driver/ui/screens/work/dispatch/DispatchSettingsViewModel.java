package ee.mtakso.driver.ui.screens.work.dispatch;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.settings.AutoOrderAcceptance;
import ee.mtakso.driver.network.client.settings.SearchCategory;
import ee.mtakso.driver.network.client.settings.SettingsResponse;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.service.analytics.event.facade.AutoAcceptanceAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics;
import ee.mtakso.driver.service.modules.surge.SurgeManager;
import ee.mtakso.driver.service.modules.surge.SurgeSettings;
import ee.mtakso.driver.service.modules.surge.SurgeSettingsKt;
import ee.mtakso.driver.service.settings.DispatchSettingsManager;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DispatchSettingsViewModel.kt */
/* loaded from: classes5.dex */
public final class DispatchSettingsViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final DispatchSettingsManager f34003f;

    /* renamed from: g  reason: collision with root package name */
    private final AutoAcceptanceAnalytics f34004g;

    /* renamed from: h  reason: collision with root package name */
    private final SurgeManager f34005h;

    /* renamed from: i  reason: collision with root package name */
    private final DriverFeatures f34006i;

    /* renamed from: j  reason: collision with root package name */
    private final DriverSettings f34007j;

    /* renamed from: k  reason: collision with root package name */
    private final SettingsAnalytics f34008k;

    /* renamed from: l  reason: collision with root package name */
    private List<SearchCategory> f34009l;

    /* renamed from: m  reason: collision with root package name */
    private AutoOrderAcceptance f34010m;

    /* renamed from: n  reason: collision with root package name */
    private Set<String> f34011n;

    /* renamed from: o  reason: collision with root package name */
    private SurgeSettings f34012o;

    /* renamed from: p  reason: collision with root package name */
    private String f34013p;

    /* renamed from: q  reason: collision with root package name */
    private final MutableLiveData<DispatchSettingsState> f34014q;

    /* renamed from: r  reason: collision with root package name */
    private final MutableLiveData<String> f34015r;

    /* renamed from: s  reason: collision with root package name */
    private final MutableLiveData<Boolean> f34016s;

    /* renamed from: t  reason: collision with root package name */
    private Disposable f34017t;

    /* renamed from: u  reason: collision with root package name */
    private Disposable f34018u;

    @Inject
    public DispatchSettingsViewModel(DispatchSettingsManager dispatchSettingsManager, AutoAcceptanceAnalytics autoAcceptanceAnalytics, SurgeManager surgeManager, DriverFeatures driverFeatures, DriverSettings driverSettings, SettingsAnalytics settingsAnalytics) {
        Set<String> b8;
        Intrinsics.f(dispatchSettingsManager, "dispatchSettingsManager");
        Intrinsics.f(autoAcceptanceAnalytics, "autoAcceptanceAnalytics");
        Intrinsics.f(surgeManager, "surgeManager");
        Intrinsics.f(driverFeatures, "driverFeatures");
        Intrinsics.f(driverSettings, "driverSettings");
        Intrinsics.f(settingsAnalytics, "settingsAnalytics");
        this.f34003f = dispatchSettingsManager;
        this.f34004g = autoAcceptanceAnalytics;
        this.f34005h = surgeManager;
        this.f34006i = driverFeatures;
        this.f34007j = driverSettings;
        this.f34008k = settingsAnalytics;
        b8 = SetsKt__SetsKt.b();
        this.f34011n = b8;
        this.f34014q = new MutableLiveData<>();
        this.f34015r = new MutableLiveData<>();
        this.f34016s = new MutableLiveData<>();
    }

    private final void V(String str) {
        if (this.f34011n.contains(str)) {
            this.f34013p = null;
            SurgeManager.h(this.f34005h, str, false, 2, null);
            return;
        }
        this.f34013p = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair a0(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Pair) tmp0.s(obj, obj2);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void h0() {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.work.dispatch.DispatchSettingsViewModel.h0():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void n0() {
        SurgeSettings surgeSettings;
        String str;
        Object obj;
        Object obj2;
        List<SearchCategory> list = this.f34009l;
        if (list == null || (surgeSettings = this.f34012o) == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            str = null;
            if (it.hasNext()) {
                obj = it.next();
                if (SurgeSettingsKt.d(surgeSettings, ((SearchCategory) obj).c())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        SearchCategory searchCategory = (SearchCategory) obj;
        boolean z7 = false;
        if (searchCategory != null && !searchCategory.e()) {
            z7 = true;
        }
        if (z7 && this.f34013p == null) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (it2.hasNext()) {
                    obj2 = it2.next();
                    if (((SearchCategory) obj2).e()) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            SearchCategory searchCategory2 = (SearchCategory) obj2;
            if (searchCategory2 != null) {
                str = searchCategory2.c();
            }
            if (str != null) {
                V(str);
            }
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        Observable<Optional<SettingsResponse>> R = this.f34003f.r().R();
        Observable<SurgeSettings> d8 = this.f34005h.d();
        final DispatchSettingsViewModel$onStart$1 dispatchSettingsViewModel$onStart$1 = new Function2<Optional<SettingsResponse>, SurgeSettings, Pair<? extends SettingsResponse, ? extends SurgeSettings>>() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.DispatchSettingsViewModel$onStart$1
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final Pair<SettingsResponse, SurgeSettings> s(Optional<SettingsResponse> optionalDispatchSettings, SurgeSettings surgeSettings) {
                Intrinsics.f(optionalDispatchSettings, "optionalDispatchSettings");
                Intrinsics.f(surgeSettings, "surgeSettings");
                return new Pair<>(optionalDispatchSettings.c(), surgeSettings);
            }
        };
        Observable combineLatest = Observable.combineLatest(R, d8, new BiFunction() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.o
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Pair a02;
                a02 = DispatchSettingsViewModel.a0(Function2.this, obj, obj2);
                return a02;
            }
        });
        Intrinsics.e(combineLatest, "combineLatest(\n         …          }\n            )");
        Observable k8 = k(ObservableExtKt.g(combineLatest));
        final Function1<Pair<? extends SettingsResponse, ? extends SurgeSettings>, Unit> function1 = new Function1<Pair<? extends SettingsResponse, ? extends SurgeSettings>, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.DispatchSettingsViewModel$onStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:21:0x0060, code lost:
                if (r4 == null) goto L61;
             */
            /* JADX WARN: Code restructure failed: missing block: B:36:0x00b6, code lost:
                if (r2 == null) goto L60;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void b(kotlin.Pair<ee.mtakso.driver.network.client.settings.SettingsResponse, ee.mtakso.driver.service.modules.surge.SurgeSettings> r13) {
                /*
                    Method dump skipped, instructions count: 278
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.work.dispatch.DispatchSettingsViewModel$onStart$2.b(kotlin.Pair):void");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends SettingsResponse, ? extends SurgeSettings> pair) {
                b(pair);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.p
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DispatchSettingsViewModel.b0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.DispatchSettingsViewModel$onStart$3
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
            public final void invoke2(Throwable throwable) {
                MutableLiveData y7;
                y7 = DispatchSettingsViewModel.this.y();
                y7.o(Boolean.FALSE);
                DispatchSettingsViewModel dispatchSettingsViewModel = DispatchSettingsViewModel.this;
                Intrinsics.e(throwable, "throwable");
                dispatchSettingsViewModel.z(throwable, "Failed to load categories");
            }
        };
        this.f34017t = k8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.q
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DispatchSettingsViewModel.c0(Function1.this, obj);
            }
        });
    }

    public final LiveData<DispatchSettingsState> W() {
        return this.f34014q;
    }

    public final LiveData<Boolean> X() {
        return this.f34016s;
    }

    public final LiveData<String> Y() {
        return this.f34015r;
    }

    public final void Z(boolean z7) {
        this.f34004g.Z2("Category selection screen", z7);
    }

    public final void d0(DispatchCategorySetting categorySetting, boolean z7) {
        ArrayList arrayList;
        int v7;
        Intrinsics.f(categorySetting, "categorySetting");
        List<SearchCategory> list = this.f34009l;
        if (list != null) {
            v7 = CollectionsKt__IterablesKt.v(list, 10);
            arrayList = new ArrayList(v7);
            for (SearchCategory searchCategory : list) {
                if (Intrinsics.a(categorySetting.a().c(), searchCategory.c())) {
                    searchCategory = SearchCategory.b(searchCategory, null, null, z7, 3, null);
                }
                arrayList.add(searchCategory);
            }
        } else {
            arrayList = null;
        }
        this.f34009l = arrayList;
        if (!z7 && Intrinsics.a(categorySetting.a().c(), this.f34013p)) {
            this.f34013p = null;
        }
        n0();
        h0();
    }

    public final void e0(String categoryId) {
        Intrinsics.f(categoryId, "categoryId");
        if (this.f34011n.contains(categoryId)) {
            SurgeManager.h(this.f34005h, null, false, 2, null);
        } else {
            this.f34013p = null;
        }
        h0();
    }

    public final void f0(String categoryId) {
        Intrinsics.f(categoryId, "categoryId");
        V(categoryId);
        h0();
    }

    public final void g0(boolean z7) {
        Object obj;
        boolean z8;
        List<SearchCategory> list = this.f34009l;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    SearchCategory searchCategory = (SearchCategory) obj;
                    SurgeSettings surgeSettings = this.f34012o;
                    if (surgeSettings != null) {
                        z8 = SurgeSettingsKt.c(surgeSettings, searchCategory.c());
                        continue;
                    } else {
                        z8 = false;
                        continue;
                    }
                    if (z8) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            SearchCategory searchCategory2 = (SearchCategory) obj;
            if (searchCategory2 != null) {
                if (z7) {
                    f0(searchCategory2.c());
                } else {
                    e0(searchCategory2.c());
                }
            }
        }
    }

    public final void i0(List<DispatchCategorySetting> list, AutoOrderAcceptance autoOrderAcceptance) {
        ArrayList arrayList;
        int v7;
        if (list != null) {
            v7 = CollectionsKt__IterablesKt.v(list, 10);
            arrayList = new ArrayList(v7);
            for (DispatchCategorySetting dispatchCategorySetting : list) {
                arrayList.add(dispatchCategorySetting.a());
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null && (!arrayList.isEmpty())) {
            this.f34008k.e(arrayList);
        }
        Single d8 = SingleExtKt.d(this.f34003f.L(arrayList, autoOrderAcceptance));
        final Function1<Disposable, Unit> function1 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.DispatchSettingsViewModel$updateSettings$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                MutableLiveData mutableLiveData;
                mutableLiveData = DispatchSettingsViewModel.this.f34016s;
                mutableLiveData.o(Boolean.TRUE);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Single n8 = d8.n(new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.r
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DispatchSettingsViewModel.j0(Function1.this, obj);
            }
        });
        final Function1<String, Unit> function12 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.DispatchSettingsViewModel$updateSettings$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String str) {
                String str2;
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                SurgeManager surgeManager;
                String str3;
                str2 = DispatchSettingsViewModel.this.f34013p;
                if (str2 != null) {
                    surgeManager = DispatchSettingsViewModel.this.f34005h;
                    str3 = DispatchSettingsViewModel.this.f34013p;
                    SurgeManager.h(surgeManager, str3, false, 2, null);
                }
                mutableLiveData = DispatchSettingsViewModel.this.f34016s;
                mutableLiveData.o(Boolean.FALSE);
                mutableLiveData2 = DispatchSettingsViewModel.this.f34015r;
                mutableLiveData2.o(str);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.s
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DispatchSettingsViewModel.k0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.DispatchSettingsViewModel$updateSettings$3
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
            public final void invoke2(Throwable throwable) {
                MutableLiveData mutableLiveData;
                mutableLiveData = DispatchSettingsViewModel.this.f34016s;
                mutableLiveData.o(Boolean.FALSE);
                DispatchSettingsViewModel dispatchSettingsViewModel = DispatchSettingsViewModel.this;
                Intrinsics.e(throwable, "throwable");
                dispatchSettingsViewModel.z(throwable, "Failed to update settings");
            }
        };
        this.f34018u = n8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.t
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DispatchSettingsViewModel.l0(Function1.this, obj);
            }
        });
    }

    public final void m0() {
        this.f34007j.k().b(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f34017t;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.f34018u;
        if (disposable2 != null) {
            disposable2.dispose();
        }
    }
}
