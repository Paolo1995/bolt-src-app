package ee.mtakso.driver.service.modules.map;

import ee.mtakso.driver.network.client.settings.SearchCategories;
import ee.mtakso.driver.network.client.settings.SearchCategory;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.service.BaseServiceImpl;
import ee.mtakso.driver.service.settings.DispatchSettingsManager;
import ee.mtakso.driver.utils.Optional;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeatmapSettingService.kt */
/* loaded from: classes3.dex */
public final class HeatmapSettingService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final DispatchSettingsManager f24835b;

    /* renamed from: c  reason: collision with root package name */
    private final MapsConfigsService f24836c;

    /* renamed from: d  reason: collision with root package name */
    private final HeatmapSettingManager f24837d;

    /* renamed from: e  reason: collision with root package name */
    private final DriverFeatures f24838e;

    @Inject
    public HeatmapSettingService(DispatchSettingsManager dispatchSettingsManager, MapsConfigsService mapsConfigsService, HeatmapSettingManager heatmapSettingManager, DriverFeatures driverFeatures) {
        Intrinsics.f(dispatchSettingsManager, "dispatchSettingsManager");
        Intrinsics.f(mapsConfigsService, "mapsConfigsService");
        Intrinsics.f(heatmapSettingManager, "heatmapSettingManager");
        Intrinsics.f(driverFeatures, "driverFeatures");
        this.f24835b = dispatchSettingsManager;
        this.f24836c = mapsConfigsService;
        this.f24837d = heatmapSettingManager;
        this.f24838e = driverFeatures;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MapsConfigsAndCategories l(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (MapsConfigsAndCategories) tmp0.s(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable<MapsConfigs> c8 = this.f24836c.c();
        Observable<Optional<SearchCategories>> u7 = this.f24835b.u();
        final HeatmapSettingService$doStart$1 heatmapSettingService$doStart$1 = new Function2<MapsConfigs, Optional<SearchCategories>, MapsConfigsAndCategories>() { // from class: ee.mtakso.driver.service.modules.map.HeatmapSettingService$doStart$1
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final MapsConfigsAndCategories s(MapsConfigs configs, Optional<SearchCategories> optionalCategories) {
                List<SearchCategory> list;
                Intrinsics.f(configs, "configs");
                Intrinsics.f(optionalCategories, "optionalCategories");
                SearchCategories c9 = optionalCategories.c();
                if (c9 != null) {
                    list = c9.a();
                } else {
                    list = null;
                }
                return new MapsConfigsAndCategories(configs, list);
            }
        };
        Observable combineLatest = Observable.combineLatest(c8, u7, new BiFunction() { // from class: ee.mtakso.driver.service.modules.map.e
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                MapsConfigsAndCategories l8;
                l8 = HeatmapSettingService.l(Function2.this, obj, obj2);
                return l8;
            }
        });
        final Function1<MapsConfigsAndCategories, Boolean> function1 = new Function1<MapsConfigsAndCategories, Boolean>() { // from class: ee.mtakso.driver.service.modules.map.HeatmapSettingService$doStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(MapsConfigsAndCategories it) {
                DriverFeatures driverFeatures;
                Intrinsics.f(it, "it");
                driverFeatures = HeatmapSettingService.this.f24838e;
                return Boolean.valueOf(driverFeatures.O());
            }
        };
        Observable filter = combineLatest.filter(new Predicate() { // from class: ee.mtakso.driver.service.modules.map.f
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean m8;
                m8 = HeatmapSettingService.m(Function1.this, obj);
                return m8;
            }
        });
        final Function1<MapsConfigsAndCategories, Unit> function12 = new Function1<MapsConfigsAndCategories, Unit>() { // from class: ee.mtakso.driver.service.modules.map.HeatmapSettingService$doStart$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(MapsConfigsAndCategories config) {
                HeatmapSettingManager heatmapSettingManager;
                heatmapSettingManager = HeatmapSettingService.this.f24837d;
                Intrinsics.e(config, "config");
                heatmapSettingManager.k(config);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MapsConfigsAndCategories mapsConfigsAndCategories) {
                b(mapsConfigsAndCategories);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.modules.map.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HeatmapSettingService.n(Function1.this, obj);
            }
        };
        final HeatmapSettingService$doStart$4 heatmapSettingService$doStart$4 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.modules.map.HeatmapSettingService$doStart$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Unexpected error!!!");
            }
        };
        Disposable subscribe = filter.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.modules.map.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HeatmapSettingService.o(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …    }\n            )\n    }");
        return subscribe;
    }
}
