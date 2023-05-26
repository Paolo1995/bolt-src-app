package ee.mtakso.driver.ui.interactor.map;

import ee.mtakso.driver.service.modules.map.HeatmapCategory;
import ee.mtakso.driver.service.modules.map.HeatmapOption;
import ee.mtakso.driver.service.modules.map.HeatmapOptionProvider;
import ee.mtakso.driver.ui.interactor.map.GetMapSettingsInteractor;
import ee.mtakso.driver.ui.interactor.map.MapSettings;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverImageMapper;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetMapSettingsInteractor.kt */
/* loaded from: classes3.dex */
public final class GetMapSettingsInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final HeatmapOptionProvider f26629a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverImageMapper f26630b;

    @Inject
    public GetMapSettingsInteractor(HeatmapOptionProvider heatmapOptionProvider, DriverImageMapper driverImageMapper) {
        Intrinsics.f(heatmapOptionProvider, "heatmapOptionProvider");
        Intrinsics.f(driverImageMapper, "driverImageMapper");
        this.f26629a = heatmapOptionProvider;
        this.f26630b = driverImageMapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MapSettings d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (MapSettings) tmp0.invoke(obj);
    }

    public final Observable<MapSettings> c() {
        Observable<List<HeatmapOption>> b8 = this.f26629a.b();
        final Function1<List<? extends HeatmapOption>, MapSettings> function1 = new Function1<List<? extends HeatmapOption>, MapSettings>() { // from class: ee.mtakso.driver.ui.interactor.map.GetMapSettingsInteractor$observeMapSettings$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final MapSettings invoke(List<HeatmapOption> heatmapOptions) {
                int v7;
                int v8;
                DriverImageMapper driverImageMapper;
                Intrinsics.f(heatmapOptions, "heatmapOptions");
                GetMapSettingsInteractor getMapSettingsInteractor = GetMapSettingsInteractor.this;
                v7 = CollectionsKt__IterablesKt.v(heatmapOptions, 10);
                ArrayList arrayList = new ArrayList(v7);
                for (HeatmapOption heatmapOption : heatmapOptions) {
                    List<HeatmapCategory> a8 = heatmapOption.a();
                    v8 = CollectionsKt__IterablesKt.v(a8, 10);
                    ArrayList arrayList2 = new ArrayList(v8);
                    for (HeatmapCategory heatmapCategory : a8) {
                        arrayList2.add(new MapSettingsCategory(heatmapCategory.a().c(), heatmapCategory.a().d(), heatmapCategory.b()));
                    }
                    String d8 = heatmapOption.b().d();
                    String e8 = heatmapOption.b().e();
                    String b9 = heatmapOption.b().b();
                    driverImageMapper = getMapSettingsInteractor.f26630b;
                    arrayList.add(new MapSettingsHeatmap(d8, e8, b9, driverImageMapper.a(heatmapOption.b().c()), arrayList2, heatmapOption.c()));
                }
                return new MapSettings(arrayList);
            }
        };
        Observable map = b8.map(new Function() { // from class: s2.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                MapSettings d8;
                d8 = GetMapSettingsInteractor.d(Function1.this, obj);
                return d8;
            }
        });
        Intrinsics.e(map, "fun observeMapSettings()…    )\n            }\n    }");
        return map;
    }
}
