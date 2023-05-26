package ee.mtakso.driver.service.modules.map;

import ee.mtakso.driver.network.client.driver.DriverMapsConfigs;
import ee.mtakso.driver.network.client.driver.map.TileCollectionConfig;
import ee.mtakso.driver.network.client.driver.map.TileCollectionOption;
import ee.mtakso.driver.network.client.driver.map.TileCollectionsPickerUi;
import ee.mtakso.driver.network.client.settings.SearchCategory;
import ee.mtakso.driver.param.DriverSettings;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import j$.util.concurrent.atomic.DesugarAtomicReference;
import j$.util.function.Function;
import j$.util.function.UnaryOperator;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeatmapSettingManager.kt */
/* loaded from: classes3.dex */
public final class HeatmapSettingManager {

    /* renamed from: a  reason: collision with root package name */
    private final DriverSettings f24830a;

    /* renamed from: b  reason: collision with root package name */
    private final BehaviorSubject<Unit> f24831b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicReference<HeatmapSetting> f24832c;

    @Inject
    public HeatmapSettingManager(DriverSettings driverSettings) {
        Intrinsics.f(driverSettings, "driverSettings");
        this.f24830a = driverSettings;
        BehaviorSubject<Unit> f8 = BehaviorSubject.f(Unit.f50853a);
        Intrinsics.e(f8, "createDefault(Unit)");
        this.f24831b = f8;
        this.f24832c = new AtomicReference<>(new HeatmapSetting(null, null, driverSettings.u(), driverSettings.P(), 3, null));
    }

    private final String d(TileCollectionConfig tileCollectionConfig, List<SearchCategory> list) {
        Map<String, String> map;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        Object obj;
        boolean z11;
        boolean z12;
        if (tileCollectionConfig != null) {
            map = tileCollectionConfig.d();
        } else {
            map = null;
        }
        String P = this.f24830a.P();
        boolean Q = this.f24830a.Q();
        boolean z13 = true;
        if (map != null && !map.isEmpty()) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z7) {
            return null;
        }
        if (list != null && !list.isEmpty()) {
            z8 = false;
        } else {
            z8 = true;
        }
        if (z8) {
            return null;
        }
        boolean z14 = list instanceof Collection;
        if (!z14 || !list.isEmpty()) {
            for (SearchCategory searchCategory : list) {
                if (Intrinsics.a(searchCategory.c(), P) && !searchCategory.e()) {
                    z9 = true;
                    continue;
                } else {
                    z9 = false;
                    continue;
                }
                if (z9) {
                    z10 = true;
                    break;
                }
            }
        }
        z10 = false;
        if (!z10 && Q) {
            if (!z14 || !list.isEmpty()) {
                for (SearchCategory searchCategory2 : list) {
                    if (Intrinsics.a(searchCategory2.c(), P) && searchCategory2.e()) {
                        z12 = true;
                        continue;
                    } else {
                        z12 = false;
                        continue;
                    }
                    if (z12) {
                        break;
                    }
                }
            }
            z13 = false;
            if (!z13 || !map.containsKey(P)) {
                return null;
            }
            return P;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                SearchCategory searchCategory3 = (SearchCategory) obj;
                if (searchCategory3.e() && map.get(searchCategory3.c()) != null) {
                    z11 = true;
                    continue;
                } else {
                    z11 = false;
                    continue;
                }
                if (z11) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        SearchCategory searchCategory4 = (SearchCategory) obj;
        if (searchCategory4 != null) {
            j(searchCategory4.c());
        }
        if (searchCategory4 == null) {
            return null;
        }
        return searchCategory4.c();
    }

    private final String e(MapsConfigs mapsConfigs) {
        List<TileCollectionOption> list;
        boolean z7;
        Object obj;
        DriverMapsConfigs a8;
        TileCollectionsPickerUi c8;
        if (mapsConfigs != null && (a8 = mapsConfigs.a()) != null && (c8 = a8.c()) != null) {
            list = c8.a();
        } else {
            list = null;
        }
        String u7 = this.f24830a.u();
        boolean z8 = true;
        if (list != null && !list.isEmpty()) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z7) {
            return null;
        }
        List<TileCollectionOption> a9 = mapsConfigs.a().c().a();
        if (!(a9 instanceof Collection) || !a9.isEmpty()) {
            for (TileCollectionOption tileCollectionOption : a9) {
                if (Intrinsics.a(tileCollectionOption.d(), u7)) {
                    break;
                }
            }
        }
        z8 = false;
        if (z8) {
            return u7;
        }
        Iterator<T> it = mapsConfigs.a().c().a().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.a(((TileCollectionOption) obj).f(), Boolean.TRUE)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        TileCollectionOption tileCollectionOption2 = (TileCollectionOption) obj;
        if (tileCollectionOption2 != null) {
            this.f24830a.d0(tileCollectionOption2.d());
        } else {
            Kalev.m(new IllegalStateException("Couldn't find default heatmap option"), "Couldn't find default heatmap option");
        }
        if (tileCollectionOption2 == null) {
            return null;
        }
        return tileCollectionOption2.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HeatmapSetting g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (HeatmapSetting) tmp0.invoke(obj);
    }

    private final void j(String str) {
        this.f24830a.n0(str);
        this.f24830a.o0(true);
    }

    private final void l(final MapsConfigsAndCategories mapsConfigsAndCategories) {
        DesugarAtomicReference.updateAndGet(this.f24832c, new UnaryOperator() { // from class: ee.mtakso.driver.service.modules.map.c
            @Override // j$.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                HeatmapSetting n8;
                n8 = HeatmapSettingManager.n(MapsConfigsAndCategories.this, this, (HeatmapSetting) obj);
                return n8;
            }

            @Override // j$.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function.CC.$default$compose(this, function);
            }
        });
        this.f24831b.onNext(Unit.f50853a);
    }

    static /* synthetic */ void m(HeatmapSettingManager heatmapSettingManager, MapsConfigsAndCategories mapsConfigsAndCategories, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            mapsConfigsAndCategories = null;
        }
        heatmapSettingManager.l(mapsConfigsAndCategories);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HeatmapSetting n(MapsConfigsAndCategories mapsConfigsAndCategories, HeatmapSettingManager this$0, HeatmapSetting heatmapSetting) {
        MapsConfigs e8;
        List<SearchCategory> b8;
        TileCollectionConfig tileCollectionConfig;
        DriverMapsConfigs a8;
        Map<String, TileCollectionConfig> b9;
        Intrinsics.f(this$0, "this$0");
        if (mapsConfigsAndCategories == null || (e8 = mapsConfigsAndCategories.b()) == null) {
            e8 = heatmapSetting.e();
        }
        if (mapsConfigsAndCategories == null || (b8 = mapsConfigsAndCategories.a()) == null) {
            b8 = heatmapSetting.b();
        }
        String e9 = this$0.e(e8);
        if (e8 != null && (a8 = e8.a()) != null && (b9 = a8.b()) != null) {
            tileCollectionConfig = b9.get(e9);
        } else {
            tileCollectionConfig = null;
        }
        return heatmapSetting.a(e8, b8, e9, this$0.d(tileCollectionConfig, b8));
    }

    public final Observable<HeatmapSetting> f() {
        BehaviorSubject<Unit> behaviorSubject = this.f24831b;
        final Function1<Unit, HeatmapSetting> function1 = new Function1<Unit, HeatmapSetting>() { // from class: ee.mtakso.driver.service.modules.map.HeatmapSettingManager$observeHeatmapSetting$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final HeatmapSetting invoke(Unit it) {
                AtomicReference atomicReference;
                Intrinsics.f(it, "it");
                atomicReference = HeatmapSettingManager.this.f24832c;
                return (HeatmapSetting) atomicReference.get();
            }
        };
        Observable map = behaviorSubject.map(new io.reactivex.functions.Function() { // from class: ee.mtakso.driver.service.modules.map.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                HeatmapSetting g8;
                g8 = HeatmapSettingManager.g(Function1.this, obj);
                return g8;
            }
        });
        Intrinsics.e(map, "fun observeHeatmapSettin…stateHolder.get() }\n    }");
        return map;
    }

    public final void h(String heatmapId, String str) {
        Intrinsics.f(heatmapId, "heatmapId");
        this.f24830a.d0(heatmapId);
        if (str == null) {
            str = "";
        }
        j(str);
        m(this, null, 1, null);
    }

    public final void i(String heatmapId) {
        Intrinsics.f(heatmapId, "heatmapId");
        this.f24830a.d0(heatmapId);
        m(this, null, 1, null);
    }

    public final void k(MapsConfigsAndCategories config) {
        Intrinsics.f(config, "config");
        l(config);
    }
}
