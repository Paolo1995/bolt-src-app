package ee.mtakso.driver.ui.interactor.driver.surge;

import ee.mtakso.driver.network.client.driver.surge.SurgeMap;
import ee.mtakso.driver.network.client.settings.SearchCategories;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.service.modules.surge.SurgeManager;
import ee.mtakso.driver.service.modules.surge.SurgeSettings;
import ee.mtakso.driver.service.settings.DispatchSettingsManager;
import ee.mtakso.driver.ui.interactor.driver.surge.SurgeData;
import ee.mtakso.driver.utils.Optional;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SurgeInteractor.kt */
/* loaded from: classes3.dex */
public final class SurgeInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final SurgeManager f26545a;

    /* renamed from: b  reason: collision with root package name */
    private final DispatchSettingsManager f26546b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverFeatures f26547c;

    @Inject
    public SurgeInteractor(SurgeManager surgeManager, DispatchSettingsManager dispatchSettingsManager, DriverFeatures features) {
        Intrinsics.f(surgeManager, "surgeManager");
        Intrinsics.f(dispatchSettingsManager, "dispatchSettingsManager");
        Intrinsics.f(features, "features");
        this.f26545a = surgeManager;
        this.f26546b = dispatchSettingsManager;
        this.f26547c = features;
    }

    private final Observable<Optional<String>> f(final SurgeSettings surgeSettings) {
        final SurgeMap c8 = surgeSettings.c();
        if (c8 == null) {
            Observable<Optional<String>> just = Observable.just(Optional.a());
            Intrinsics.e(just, "just(Optional.empty())");
            return just;
        } else if (c8.d() != null) {
            Observable<Optional<String>> just2 = Observable.just(Optional.f(c8.d()));
            Intrinsics.e(just2, "just(Optional.of(surgeMap.tileCollectionId))");
            return just2;
        } else {
            Observable<Optional<SearchCategories>> distinctUntilChanged = this.f26546b.u().distinctUntilChanged();
            final Function1<Optional<SearchCategories>, Optional<String>> function1 = new Function1<Optional<SearchCategories>, Optional<String>>() { // from class: ee.mtakso.driver.ui.interactor.driver.surge.SurgeInteractor$fetchTileCollectionId$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Code restructure failed: missing block: B:50:0x00df, code lost:
                    if (r5 != false) goto L51;
                 */
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final ee.mtakso.driver.utils.Optional<java.lang.String> invoke(ee.mtakso.driver.utils.Optional<ee.mtakso.driver.network.client.settings.SearchCategories> r11) {
                    /*
                        Method dump skipped, instructions count: 316
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.interactor.driver.surge.SurgeInteractor$fetchTileCollectionId$1.invoke(ee.mtakso.driver.utils.Optional):ee.mtakso.driver.utils.Optional");
                }
            };
            Observable map = distinctUntilChanged.map(new Function() { // from class: ee.mtakso.driver.ui.interactor.driver.surge.c
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Optional g8;
                    g8 = SurgeInteractor.g(Function1.this, obj);
                    return g8;
                }
            });
            Intrinsics.e(map, "private fun fetchTileCol…onId)\n            }\n    }");
            return map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Observable<SurgeData> j(SurgeSettings surgeSettings) {
        boolean z7;
        SurgeMap c8 = surgeSettings.c();
        if (c8 == null) {
            Observable<SurgeData> just = Observable.just(SurgeData.Empty.f26543a);
            Intrinsics.e(just, "just(SurgeData.Empty)");
            return just;
        } else if (this.f26547c.O()) {
            Observable<SurgeData> just2 = Observable.just(SurgeData.Empty.f26543a);
            Intrinsics.e(just2, "just(SurgeData.Empty)");
            return just2;
        } else {
            if (c8.d() == null) {
                LinkedHashMap<String, String> a8 = c8.a();
                if (a8 != null && !a8.isEmpty()) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                if (z7) {
                    Observable<SurgeData> just3 = Observable.just(SurgeData.Empty.f26543a);
                    Intrinsics.e(just3, "just(SurgeData.Empty)");
                    return just3;
                }
            }
            Observable<Optional<String>> f8 = f(surgeSettings);
            final SurgeInteractor$prepare$1 surgeInteractor$prepare$1 = new Function1<Optional<String>, ObservableSource<? extends SurgeData>>() { // from class: ee.mtakso.driver.ui.interactor.driver.surge.SurgeInteractor$prepare$1
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final ObservableSource<? extends SurgeData> invoke(Optional<String> optionalTileCollectionId) {
                    Intrinsics.f(optionalTileCollectionId, "optionalTileCollectionId");
                    String c9 = optionalTileCollectionId.c();
                    if (c9 != null) {
                        Observable just4 = Observable.just(new SurgeData.Tile(c9));
                        Intrinsics.e(just4, "{\n                    Ob…ionId))\n                }");
                        return just4;
                    }
                    Observable just5 = Observable.just(SurgeData.Empty.f26543a);
                    Intrinsics.e(just5, "{\n                    Ob….Empty)\n                }");
                    return just5;
                }
            };
            Observable flatMap = f8.flatMap(new Function() { // from class: ee.mtakso.driver.ui.interactor.driver.surge.b
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource k8;
                    k8 = SurgeInteractor.k(Function1.this, obj);
                    return k8;
                }
            });
            Intrinsics.e(flatMap, "fetchTileCollectionId(su…          }\n            }");
            return flatMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    public final Observable<SurgeData> h() {
        Observable<SurgeSettings> observeOn = this.f26545a.d().observeOn(Schedulers.c());
        final Function1<SurgeSettings, ObservableSource<? extends SurgeData>> function1 = new Function1<SurgeSettings, ObservableSource<? extends SurgeData>>() { // from class: ee.mtakso.driver.ui.interactor.driver.surge.SurgeInteractor$observeSurge$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<? extends SurgeData> invoke(SurgeSettings it) {
                Observable j8;
                Intrinsics.f(it, "it");
                j8 = SurgeInteractor.this.j(it);
                return j8;
            }
        };
        Observable<SurgeData> observeOn2 = observeOn.switchMap(new Function() { // from class: ee.mtakso.driver.ui.interactor.driver.surge.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource i8;
                i8 = SurgeInteractor.i(Function1.this, obj);
                return i8;
            }
        }).distinctUntilChanged().observeOn(AndroidSchedulers.a());
        Intrinsics.e(observeOn2, "fun observeSurge(): Obse…ulers.mainThread())\n    }");
        return observeOn2;
    }
}
