package ee.mtakso.driver.ui.interactor.map;

import ee.mtakso.driver.network.client.driver.map.TileCollectionOption;
import ee.mtakso.driver.network.client.settings.SearchCategory;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.service.modules.map.HeatmapCategory;
import ee.mtakso.driver.service.modules.map.HeatmapOption;
import ee.mtakso.driver.service.modules.map.HeatmapOptionProvider;
import ee.mtakso.driver.service.modules.map.MapsConfigsService;
import ee.mtakso.driver.ui.interactor.map.GetHeatmapStatusInteractor;
import ee.mtakso.driver.ui.interactor.map.HeatmapStatus;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverImageMapper;
import ee.mtakso.driver.uikit.utils.Image;
import eu.bolt.driver.earnings.network.DriverImage;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetHeatmapStatusInteractor.kt */
/* loaded from: classes3.dex */
public final class GetHeatmapStatusInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final HeatmapOptionProvider f26615a;

    /* renamed from: b  reason: collision with root package name */
    private final MapsConfigsService f26616b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverImageMapper f26617c;

    /* renamed from: d  reason: collision with root package name */
    private final DriverFeatures f26618d;

    @Inject
    public GetHeatmapStatusInteractor(HeatmapOptionProvider heatmapOptionProvider, MapsConfigsService mapsConfigsService, DriverImageMapper driverImageMapper, DriverFeatures driverFeatures) {
        Intrinsics.f(heatmapOptionProvider, "heatmapOptionProvider");
        Intrinsics.f(mapsConfigsService, "mapsConfigsService");
        Intrinsics.f(driverImageMapper, "driverImageMapper");
        Intrinsics.f(driverFeatures, "driverFeatures");
        this.f26615a = heatmapOptionProvider;
        this.f26616b = mapsConfigsService;
        this.f26617c = driverImageMapper;
        this.f26618d = driverFeatures;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HeatmapStatus g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (HeatmapStatus) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final Observable<HeatmapStatus> f() {
        Observable<List<HeatmapOption>> b8 = this.f26615a.b();
        final Function1<List<? extends HeatmapOption>, HeatmapStatus> function1 = new Function1<List<? extends HeatmapOption>, HeatmapStatus>() { // from class: ee.mtakso.driver.ui.interactor.map.GetHeatmapStatusInteractor$observeHeatmapState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final HeatmapStatus invoke(List<HeatmapOption> options) {
                DriverFeatures driverFeatures;
                String str;
                Object obj;
                HeatmapCategory heatmapCategory;
                Image image;
                String str2;
                String str3;
                SearchCategory a8;
                SearchCategory a9;
                TileCollectionOption b9;
                TileCollectionOption b10;
                DriverImage a10;
                DriverImageMapper driverImageMapper;
                List<HeatmapCategory> a11;
                Object obj2;
                Intrinsics.f(options, "options");
                driverFeatures = GetHeatmapStatusInteractor.this.f26618d;
                if (driverFeatures.O() && !options.isEmpty()) {
                    Iterator<T> it = options.iterator();
                    while (true) {
                        str = null;
                        if (it.hasNext()) {
                            obj = it.next();
                            if (((HeatmapOption) obj).c()) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    HeatmapOption heatmapOption = (HeatmapOption) obj;
                    if (heatmapOption != null && (a11 = heatmapOption.a()) != null) {
                        Iterator<T> it2 = a11.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                obj2 = it2.next();
                                if (((HeatmapCategory) obj2).b()) {
                                    break;
                                }
                            } else {
                                obj2 = null;
                                break;
                            }
                        }
                        heatmapCategory = (HeatmapCategory) obj2;
                    } else {
                        heatmapCategory = null;
                    }
                    if (heatmapOption != null && (b10 = heatmapOption.b()) != null && (a10 = b10.a()) != null) {
                        driverImageMapper = GetHeatmapStatusInteractor.this.f26617c;
                        image = driverImageMapper.a(a10);
                    } else {
                        image = null;
                    }
                    if (heatmapOption != null && (b9 = heatmapOption.b()) != null) {
                        str2 = b9.d();
                    } else {
                        str2 = null;
                    }
                    if (heatmapCategory != null && (a9 = heatmapCategory.a()) != null) {
                        str3 = a9.c();
                    } else {
                        str3 = null;
                    }
                    if (heatmapCategory != null && (a8 = heatmapCategory.a()) != null) {
                        str = a8.d();
                    }
                    return new HeatmapStatus.Available(image, str2, str3, str);
                }
                return HeatmapStatus.Unavailable.f26641a;
            }
        };
        Observable<R> map = b8.map(new Function() { // from class: s2.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                HeatmapStatus g8;
                g8 = GetHeatmapStatusInteractor.g(Function1.this, obj);
                return g8;
            }
        });
        final Function1<Disposable, Unit> function12 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.ui.interactor.map.GetHeatmapStatusInteractor$observeHeatmapState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                MapsConfigsService mapsConfigsService;
                mapsConfigsService = GetHeatmapStatusInteractor.this.f26616b;
                mapsConfigsService.k();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Observable<HeatmapStatus> subscribeOn = map.doOnSubscribe(new Consumer() { // from class: s2.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GetHeatmapStatusInteractor.h(Function1.this, obj);
            }
        }).startWith((Observable) HeatmapStatus.Unavailable.f26641a).subscribeOn(AndroidSchedulers.a());
        Intrinsics.e(subscribeOn, "fun observeHeatmapState(…ulers.mainThread())\n    }");
        return subscribeOn;
    }
}
