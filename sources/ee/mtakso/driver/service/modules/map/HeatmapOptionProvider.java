package ee.mtakso.driver.service.modules.map;

import ee.mtakso.driver.network.client.driver.DriverMapsConfigs;
import ee.mtakso.driver.network.client.driver.map.TileCollectionConfig;
import ee.mtakso.driver.network.client.driver.map.TileCollectionOption;
import ee.mtakso.driver.network.client.driver.map.TileCollectionsPickerUi;
import ee.mtakso.driver.network.client.settings.SearchCategory;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeatmapOptionProvider.kt */
/* loaded from: classes3.dex */
public final class HeatmapOptionProvider {

    /* renamed from: a  reason: collision with root package name */
    private final HeatmapSettingManager f24823a;

    @Inject
    public HeatmapOptionProvider(HeatmapSettingManager heatmapSettingManager) {
        Intrinsics.f(heatmapSettingManager, "heatmapSettingManager");
        this.f24823a = heatmapSettingManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List c(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    public final Observable<List<HeatmapOption>> b() {
        Observable<HeatmapSetting> f8 = this.f24823a.f();
        final HeatmapOptionProvider$observeHeatmapOptions$1 heatmapOptionProvider$observeHeatmapOptions$1 = new Function1<HeatmapSetting, List<? extends HeatmapOption>>() { // from class: ee.mtakso.driver.service.modules.map.HeatmapOptionProvider$observeHeatmapOptions$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<HeatmapOption> invoke(HeatmapSetting settings) {
                List<TileCollectionOption> list;
                Map<String, TileCollectionConfig> map;
                List<HeatmapOption> k8;
                int v7;
                TileCollectionConfig tileCollectionConfig;
                List k9;
                String str;
                HeatmapCategory heatmapCategory;
                Map<String, String> d8;
                DriverMapsConfigs a8;
                DriverMapsConfigs a9;
                TileCollectionsPickerUi c8;
                Intrinsics.f(settings, "settings");
                MapsConfigs e8 = settings.e();
                if (e8 != null && (a9 = e8.a()) != null && (c8 = a9.c()) != null) {
                    list = c8.a();
                } else {
                    list = null;
                }
                MapsConfigs e9 = settings.e();
                if (e9 != null && (a8 = e9.a()) != null) {
                    map = a8.b();
                } else {
                    map = null;
                }
                if (list != null) {
                    v7 = CollectionsKt__IterablesKt.v(list, 10);
                    ArrayList arrayList = new ArrayList(v7);
                    for (TileCollectionOption tileCollectionOption : list) {
                        if (map != null) {
                            tileCollectionConfig = map.get(tileCollectionOption.d());
                        } else {
                            tileCollectionConfig = null;
                        }
                        List<SearchCategory> b8 = settings.b();
                        if (b8 != null) {
                            k9 = new ArrayList();
                            for (SearchCategory searchCategory : b8) {
                                if (tileCollectionConfig != null && (d8 = tileCollectionConfig.d()) != null) {
                                    str = d8.get(searchCategory.c());
                                } else {
                                    str = null;
                                }
                                if (str != null && searchCategory.e()) {
                                    heatmapCategory = new HeatmapCategory(searchCategory, Intrinsics.a(searchCategory.c(), settings.c()));
                                } else {
                                    heatmapCategory = null;
                                }
                                if (heatmapCategory != null) {
                                    k9.add(heatmapCategory);
                                }
                            }
                        } else {
                            k9 = CollectionsKt__CollectionsKt.k();
                        }
                        arrayList.add(new HeatmapOption(tileCollectionOption, k9, Intrinsics.a(tileCollectionOption.d(), settings.d())));
                    }
                    return arrayList;
                }
                k8 = CollectionsKt__CollectionsKt.k();
                return k8;
            }
        };
        Observable map = f8.map(new Function() { // from class: ee.mtakso.driver.service.modules.map.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List c8;
                c8 = HeatmapOptionProvider.c(Function1.this, obj);
                return c8;
            }
        });
        Intrinsics.e(map, "heatmapSettingManager.ob… ?: emptyList()\n        }");
        return map;
    }
}
