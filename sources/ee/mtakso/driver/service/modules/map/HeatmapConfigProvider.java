package ee.mtakso.driver.service.modules.map;

import ee.mtakso.driver.network.client.driver.DriverMapsConfigs;
import ee.mtakso.driver.network.client.driver.map.TileCollectionConfig;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeatmapConfigProvider.kt */
/* loaded from: classes3.dex */
public final class HeatmapConfigProvider {

    /* renamed from: a  reason: collision with root package name */
    private final HeatmapSettingManager f24817a;

    @Inject
    public HeatmapConfigProvider(HeatmapSettingManager heatmapSettingManager) {
        Intrinsics.f(heatmapSettingManager, "heatmapSettingManager");
        this.f24817a = heatmapSettingManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HeatmapConfig c(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (HeatmapConfig) tmp0.invoke(obj);
    }

    public final Observable<HeatmapConfig> b() {
        Observable<HeatmapSetting> f8 = this.f24817a.f();
        final HeatmapConfigProvider$observeHeatmapConfig$1 heatmapConfigProvider$observeHeatmapConfig$1 = new Function1<HeatmapSetting, HeatmapConfig>() { // from class: ee.mtakso.driver.service.modules.map.HeatmapConfigProvider$observeHeatmapConfig$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final HeatmapConfig invoke(HeatmapSetting settings) {
                TileCollectionConfig tileCollectionConfig;
                Map<String, String> d8;
                String str;
                DriverMapsConfigs a8;
                Map<String, TileCollectionConfig> b8;
                Intrinsics.f(settings, "settings");
                MapsConfigs e8 = settings.e();
                String str2 = null;
                if (e8 != null && (a8 = e8.a()) != null && (b8 = a8.b()) != null) {
                    tileCollectionConfig = b8.get(settings.d());
                } else {
                    tileCollectionConfig = null;
                }
                if (tileCollectionConfig != null && (d8 = tileCollectionConfig.d()) != null && (str = d8.get(settings.c())) != null) {
                    str2 = str;
                } else if (tileCollectionConfig != null) {
                    str2 = tileCollectionConfig.c();
                }
                return new HeatmapConfig(str2, tileCollectionConfig);
            }
        };
        Observable map = f8.map(new Function() { // from class: ee.mtakso.driver.service.modules.map.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                HeatmapConfig c8;
                c8 = HeatmapConfigProvider.c(Function1.this, obj);
                return c8;
            }
        });
        Intrinsics.e(map, "heatmapSettingManager.ob…,\n            )\n        }");
        return map;
    }
}
