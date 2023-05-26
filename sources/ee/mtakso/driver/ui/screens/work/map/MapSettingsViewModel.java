package ee.mtakso.driver.ui.screens.work.map;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.service.analytics.event.facade.HeatmapAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.interactor.map.GetMapSettingsInteractor;
import ee.mtakso.driver.ui.interactor.map.MapSettings;
import ee.mtakso.driver.ui.interactor.map.MapSettingsCategory;
import ee.mtakso.driver.ui.interactor.map.MapSettingsHeatmap;
import ee.mtakso.driver.ui.interactor.map.SetMapSettingsCategoryInteractor;
import ee.mtakso.driver.ui.interactor.map.SetMapSettingsHeatmapInteractor;
import ee.mtakso.driver.ui.screens.work.map.MapSettingsState;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.ObservableExtKt;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapSettingsViewModel.kt */
/* loaded from: classes5.dex */
public final class MapSettingsViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final GetMapSettingsInteractor f34167f;

    /* renamed from: g  reason: collision with root package name */
    private final SetMapSettingsHeatmapInteractor f34168g;

    /* renamed from: h  reason: collision with root package name */
    private final SetMapSettingsCategoryInteractor f34169h;

    /* renamed from: i  reason: collision with root package name */
    private final HeatmapAnalytics f34170i;

    /* renamed from: j  reason: collision with root package name */
    private final MutableLiveData<MapSettingsState> f34171j;

    /* renamed from: k  reason: collision with root package name */
    private Disposable f34172k;

    /* renamed from: l  reason: collision with root package name */
    private Disposable f34173l;

    @Inject
    public MapSettingsViewModel(GetMapSettingsInteractor getMapSettingsInteractor, SetMapSettingsHeatmapInteractor setMapSettingsHeatmapInteractor, SetMapSettingsCategoryInteractor setMapSettingsCategoryInteractor, HeatmapAnalytics heatmapAnalytics) {
        Intrinsics.f(getMapSettingsInteractor, "getMapSettingsInteractor");
        Intrinsics.f(setMapSettingsHeatmapInteractor, "setMapSettingsHeatmapInteractor");
        Intrinsics.f(setMapSettingsCategoryInteractor, "setMapSettingsCategoryInteractor");
        Intrinsics.f(heatmapAnalytics, "heatmapAnalytics");
        this.f34167f = getMapSettingsInteractor;
        this.f34168g = setMapSettingsHeatmapInteractor;
        this.f34169h = setMapSettingsCategoryInteractor;
        this.f34170i = heatmapAnalytics;
        this.f34171j = new MutableLiveData<>(MapSettingsState.Loading.f34163a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        Observable g8 = ObservableExtKt.g(this.f34167f.c());
        final Function1<MapSettings, Unit> function1 = new Function1<MapSettings, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.map.MapSettingsViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(MapSettings mapSettings) {
                MutableLiveData mutableLiveData;
                Object obj;
                Object obj2;
                String str;
                List<MapSettingsCategory> k8;
                List<MapSettingsHeatmap> a8 = mapSettings.a();
                mutableLiveData = MapSettingsViewModel.this.f34171j;
                Iterator<T> it = a8.iterator();
                while (true) {
                    obj = null;
                    if (it.hasNext()) {
                        obj2 = it.next();
                        if (((MapSettingsHeatmap) obj2).e()) {
                            break;
                        }
                    } else {
                        obj2 = null;
                        break;
                    }
                }
                MapSettingsHeatmap mapSettingsHeatmap = (MapSettingsHeatmap) obj2;
                if (mapSettingsHeatmap != null) {
                    str = mapSettingsHeatmap.b();
                } else {
                    str = null;
                }
                Iterator<T> it2 = a8.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next = it2.next();
                    if (((MapSettingsHeatmap) next).e()) {
                        obj = next;
                        break;
                    }
                }
                MapSettingsHeatmap mapSettingsHeatmap2 = (MapSettingsHeatmap) obj;
                if (mapSettingsHeatmap2 == null || (k8 = mapSettingsHeatmap2.a()) == null) {
                    k8 = CollectionsKt__CollectionsKt.k();
                }
                mutableLiveData.o(new MapSettingsState.Ready(a8, str, k8));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MapSettings mapSettings) {
                b(mapSettings);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.map.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MapSettingsViewModel.L(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.map.MapSettingsViewModel$onStart$2
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
                MapSettingsViewModel mapSettingsViewModel = MapSettingsViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(mapSettingsViewModel, it, null, 2, null);
            }
        };
        Disposable subscribe = g8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.map.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MapSettingsViewModel.M(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun onStart() {…     .autoDispose()\n    }");
        v(subscribe);
    }

    public final LiveData<MapSettingsState> K() {
        return this.f34171j;
    }

    public final void N(String str) {
        MapSettingsState.Ready ready;
        Object obj;
        Object obj2;
        Object obj3;
        String str2;
        String str3;
        String str4;
        MapSettingsState f8 = this.f34171j.f();
        String str5 = null;
        if (f8 instanceof MapSettingsState.Ready) {
            ready = (MapSettingsState.Ready) f8;
        } else {
            ready = null;
        }
        if (ready == null) {
            return;
        }
        Iterator<T> it = ready.c().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((MapSettingsHeatmap) obj).e()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MapSettingsHeatmap mapSettingsHeatmap = (MapSettingsHeatmap) obj;
        if (mapSettingsHeatmap == null) {
            return;
        }
        Iterator<T> it2 = mapSettingsHeatmap.a().iterator();
        while (true) {
            if (it2.hasNext()) {
                obj2 = it2.next();
                if (((MapSettingsCategory) obj2).b()) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        MapSettingsCategory mapSettingsCategory = (MapSettingsCategory) obj2;
        Iterator<T> it3 = mapSettingsHeatmap.a().iterator();
        while (true) {
            if (it3.hasNext()) {
                obj3 = it3.next();
                if (Intrinsics.a(((MapSettingsCategory) obj3).a(), str)) {
                    break;
                }
            } else {
                obj3 = null;
                break;
            }
        }
        MapSettingsCategory mapSettingsCategory2 = (MapSettingsCategory) obj3;
        HeatmapAnalytics heatmapAnalytics = this.f34170i;
        String c8 = mapSettingsHeatmap.c();
        String c9 = mapSettingsHeatmap.c();
        if (mapSettingsCategory != null) {
            str2 = mapSettingsCategory.a();
        } else {
            str2 = null;
        }
        if (mapSettingsCategory2 != null) {
            str3 = mapSettingsCategory2.a();
        } else {
            str3 = null;
        }
        if (mapSettingsCategory != null) {
            str4 = mapSettingsCategory.c();
        } else {
            str4 = null;
        }
        if (mapSettingsCategory2 != null) {
            str5 = mapSettingsCategory2.c();
        }
        heatmapAnalytics.z2(c8, c9, str2, str3, str4, str5);
        Disposable disposable = this.f34173l;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Completable b8 = this.f34169h.b(mapSettingsHeatmap.c(), str);
        Action action = new Action() { // from class: ee.mtakso.driver.ui.screens.work.map.j
            @Override // io.reactivex.functions.Action
            public final void run() {
                MapSettingsViewModel.O();
            }
        };
        final Function1<Throwable, Unit> function1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.map.MapSettingsViewModel$setCategoryId$2
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
            public final void invoke2(Throwable it4) {
                MapSettingsViewModel mapSettingsViewModel = MapSettingsViewModel.this;
                Intrinsics.e(it4, "it");
                BaseViewModel.A(mapSettingsViewModel, it4, null, 2, null);
            }
        };
        this.f34173l = b8.G(action, new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.map.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj4) {
                MapSettingsViewModel.P(Function1.this, obj4);
            }
        });
    }

    public final void Q(String heatmapId) {
        MapSettingsState.Ready ready;
        Object obj;
        Object obj2;
        MapSettingsCategory mapSettingsCategory;
        MapSettingsCategory mapSettingsCategory2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        List<MapSettingsCategory> a8;
        Object obj3;
        List<MapSettingsCategory> a9;
        Object obj4;
        Intrinsics.f(heatmapId, "heatmapId");
        MapSettingsState f8 = this.f34171j.f();
        String str6 = null;
        if (f8 instanceof MapSettingsState.Ready) {
            ready = (MapSettingsState.Ready) f8;
        } else {
            ready = null;
        }
        if (ready != null) {
            Iterator<T> it = ready.c().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((MapSettingsHeatmap) obj).e()) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            MapSettingsHeatmap mapSettingsHeatmap = (MapSettingsHeatmap) obj;
            Iterator<T> it2 = ready.c().iterator();
            while (true) {
                if (it2.hasNext()) {
                    obj2 = it2.next();
                    if (Intrinsics.a(((MapSettingsHeatmap) obj2).c(), heatmapId)) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            MapSettingsHeatmap mapSettingsHeatmap2 = (MapSettingsHeatmap) obj2;
            if (mapSettingsHeatmap != null && (a9 = mapSettingsHeatmap.a()) != null) {
                Iterator<T> it3 = a9.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        obj4 = it3.next();
                        if (((MapSettingsCategory) obj4).b()) {
                            break;
                        }
                    } else {
                        obj4 = null;
                        break;
                    }
                }
                mapSettingsCategory = (MapSettingsCategory) obj4;
            } else {
                mapSettingsCategory = null;
            }
            if (mapSettingsHeatmap2 != null && (a8 = mapSettingsHeatmap2.a()) != null) {
                Iterator<T> it4 = a8.iterator();
                while (true) {
                    if (it4.hasNext()) {
                        obj3 = it4.next();
                        if (((MapSettingsCategory) obj3).b()) {
                            break;
                        }
                    } else {
                        obj3 = null;
                        break;
                    }
                }
                mapSettingsCategory2 = (MapSettingsCategory) obj3;
            } else {
                mapSettingsCategory2 = null;
            }
            HeatmapAnalytics heatmapAnalytics = this.f34170i;
            if (mapSettingsHeatmap != null) {
                str = mapSettingsHeatmap.c();
            } else {
                str = null;
            }
            if (mapSettingsHeatmap2 != null) {
                str2 = mapSettingsHeatmap2.c();
            } else {
                str2 = null;
            }
            if (mapSettingsCategory != null) {
                str3 = mapSettingsCategory.a();
            } else {
                str3 = null;
            }
            if (mapSettingsCategory2 != null) {
                str4 = mapSettingsCategory2.a();
            } else {
                str4 = null;
            }
            if (mapSettingsCategory != null) {
                str5 = mapSettingsCategory.c();
            } else {
                str5 = null;
            }
            if (mapSettingsCategory2 != null) {
                str6 = mapSettingsCategory2.c();
            }
            heatmapAnalytics.z2(str, str2, str3, str4, str5, str6);
        }
        Disposable disposable = this.f34172k;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Completable b8 = this.f34168g.b(heatmapId);
        Action action = new Action() { // from class: ee.mtakso.driver.ui.screens.work.map.l
            @Override // io.reactivex.functions.Action
            public final void run() {
                MapSettingsViewModel.R();
            }
        };
        final Function1<Throwable, Unit> function1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.map.MapSettingsViewModel$setHeatmapId$3
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
            public final void invoke2(Throwable it5) {
                MapSettingsViewModel mapSettingsViewModel = MapSettingsViewModel.this;
                Intrinsics.e(it5, "it");
                BaseViewModel.A(mapSettingsViewModel, it5, null, 2, null);
            }
        };
        this.f34172k = b8.G(action, new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.map.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj5) {
                MapSettingsViewModel.S(Function1.this, obj5);
            }
        });
    }

    public final void T() {
        MapSettingsState.Ready ready;
        Object obj;
        MapSettingsState f8 = this.f34171j.f();
        String str = null;
        if (f8 instanceof MapSettingsState.Ready) {
            ready = (MapSettingsState.Ready) f8;
        } else {
            ready = null;
        }
        if (ready == null) {
            return;
        }
        Iterator<T> it = ready.c().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((MapSettingsHeatmap) obj).e()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MapSettingsHeatmap mapSettingsHeatmap = (MapSettingsHeatmap) obj;
        HeatmapAnalytics heatmapAnalytics = this.f34170i;
        if (mapSettingsHeatmap != null) {
            str = mapSettingsHeatmap.c();
        }
        heatmapAnalytics.I1(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f34172k;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Disposable disposable2 = this.f34173l;
        if (disposable2 != null) {
            DisposableExtKt.a(disposable2);
        }
    }
}
