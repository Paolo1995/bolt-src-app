package ee.mtakso.driver.ui.interactor.map;

import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.service.modules.map.HeatmapConfig;
import ee.mtakso.driver.service.modules.map.HeatmapConfigProvider;
import ee.mtakso.driver.ui.interactor.driver.surge.SurgeData;
import ee.mtakso.driver.ui.interactor.driver.surge.SurgeInteractor;
import ee.mtakso.driver.ui.interactor.map.GetHeatmapInteractor;
import ee.mtakso.driver.ui.interactor.map.Heatmap;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import javax.inject.Inject;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetHeatmapInteractor.kt */
/* loaded from: classes3.dex */
public final class GetHeatmapInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final DriverFeatures f26608a;

    /* renamed from: b  reason: collision with root package name */
    private final SurgeInteractor f26609b;

    /* renamed from: c  reason: collision with root package name */
    private final HeatmapConfigProvider f26610c;

    @Inject
    public GetHeatmapInteractor(DriverFeatures features, SurgeInteractor surgeInteractor, HeatmapConfigProvider heatmapConfigProvider) {
        Intrinsics.f(features, "features");
        Intrinsics.f(surgeInteractor, "surgeInteractor");
        Intrinsics.f(heatmapConfigProvider, "heatmapConfigProvider");
        this.f26608a = features;
        this.f26609b = surgeInteractor;
        this.f26610c = heatmapConfigProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Heatmap d(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Heatmap) tmp0.s(obj, obj2);
    }

    public final Observable<Heatmap> c() {
        Observable<SurgeData> startWith = this.f26609b.h().startWith((Observable<SurgeData>) SurgeData.Empty.f26543a);
        Observable<HeatmapConfig> b8 = this.f26610c.b();
        final Function2<SurgeData, HeatmapConfig, Heatmap> function2 = new Function2<SurgeData, HeatmapConfig, Heatmap>() { // from class: ee.mtakso.driver.ui.interactor.map.GetHeatmapInteractor$observeHeatmap$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final Heatmap s(SurgeData surge, HeatmapConfig heatmap) {
                DriverFeatures driverFeatures;
                Intrinsics.f(surge, "surge");
                Intrinsics.f(heatmap, "heatmap");
                driverFeatures = GetHeatmapInteractor.this.f26608a;
                if (driverFeatures.O()) {
                    if (heatmap.a() != null) {
                        return new Heatmap.Tile(heatmap.a(), heatmap.b());
                    }
                    return Heatmap.Empty.f26634a;
                } else if (surge instanceof SurgeData.Tile) {
                    return new Heatmap.Tile(((SurgeData.Tile) surge).a(), null);
                } else {
                    return Heatmap.Empty.f26634a;
                }
            }
        };
        Observable<Heatmap> combineLatest = Observable.combineLatest(startWith, b8, new BiFunction() { // from class: s2.a
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Heatmap d8;
                d8 = GetHeatmapInteractor.d(Function2.this, obj, obj2);
                return d8;
            }
        });
        Intrinsics.e(combineLatest, "fun observeHeatmap(): Ob…        }\n        }\n    }");
        return combineLatest;
    }
}
