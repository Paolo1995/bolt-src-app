package ee.mtakso.driver.ui.screens.home.v3.map;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.campaign.ActiveAndPendingCampaignInfo;
import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.service.campaign.CampaignManager;
import ee.mtakso.driver.service.modules.fifo.FifoQueueManager;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.interactor.driver.DriverArea;
import ee.mtakso.driver.ui.interactor.driver.DriverAreaInteractor;
import ee.mtakso.driver.ui.interactor.driver.DriverStateInteractor;
import ee.mtakso.driver.ui.interactor.driver.FifoQueueMap;
import ee.mtakso.driver.ui.interactor.driver.FifoQueueMapInteractor;
import ee.mtakso.driver.ui.interactor.driver.NearbyDriver;
import ee.mtakso.driver.ui.interactor.driver.NearbyDriversInteractor;
import ee.mtakso.driver.ui.interactor.map.GetHeatmapInteractor;
import ee.mtakso.driver.ui.interactor.map.Heatmap;
import ee.mtakso.driver.ui.theme.AppThemeUtils;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.ObservableExtKt;
import eu.bolt.android.maps.core.plugin.driver.MapStyle;
import eu.bolt.driver.core.theme.AppThemeManager;
import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkMapViewModel.kt */
/* loaded from: classes3.dex */
public final class WorkMapViewModel extends BaseViewModel {
    private final LiveData<FifoQueueMap> A;
    private Disposable B;
    private final MutableLiveData<Heatmap> C;
    private final LiveData<Heatmap> D;
    private Disposable E;

    /* renamed from: f  reason: collision with root package name */
    private final DriverAreaInteractor f30118f;

    /* renamed from: g  reason: collision with root package name */
    private final NearbyDriversInteractor f30119g;

    /* renamed from: h  reason: collision with root package name */
    private final DriverStateInteractor f30120h;

    /* renamed from: i  reason: collision with root package name */
    private final FifoQueueManager f30121i;

    /* renamed from: j  reason: collision with root package name */
    private final FifoQueueMapInteractor f30122j;

    /* renamed from: k  reason: collision with root package name */
    private final GetHeatmapInteractor f30123k;

    /* renamed from: l  reason: collision with root package name */
    private final AppThemeManager f30124l;

    /* renamed from: m  reason: collision with root package name */
    private final CampaignManager f30125m;

    /* renamed from: n  reason: collision with root package name */
    private final MutableLiveData<DriverArea> f30126n;

    /* renamed from: o  reason: collision with root package name */
    private final LiveData<DriverArea> f30127o;

    /* renamed from: p  reason: collision with root package name */
    private Disposable f30128p;

    /* renamed from: q  reason: collision with root package name */
    private final MutableLiveData<List<NearbyDriver>> f30129q;

    /* renamed from: r  reason: collision with root package name */
    private final LiveData<List<NearbyDriver>> f30130r;

    /* renamed from: s  reason: collision with root package name */
    private Disposable f30131s;

    /* renamed from: t  reason: collision with root package name */
    private final MutableLiveData<DriverStatus> f30132t;

    /* renamed from: u  reason: collision with root package name */
    private final LiveData<DriverStatus> f30133u;

    /* renamed from: v  reason: collision with root package name */
    private Disposable f30134v;

    /* renamed from: w  reason: collision with root package name */
    private final MutableLiveData<ActiveAndPendingCampaignInfo> f30135w;

    /* renamed from: x  reason: collision with root package name */
    private final LiveData<ActiveAndPendingCampaignInfo> f30136x;

    /* renamed from: y  reason: collision with root package name */
    private Disposable f30137y;

    /* renamed from: z  reason: collision with root package name */
    private final MutableLiveData<FifoQueueMap> f30138z;

    @Inject
    public WorkMapViewModel(DriverAreaInteractor driverAreaInteractor, NearbyDriversInteractor nearbyDriversInteractor, DriverStateInteractor driverStateInteractor, FifoQueueManager fifoQueueManager, FifoQueueMapInteractor fifoQueueMapInteractor, GetHeatmapInteractor getHeatmapInteractor, AppThemeManager appThemeManager, CampaignManager campaignManager) {
        Intrinsics.f(driverAreaInteractor, "driverAreaInteractor");
        Intrinsics.f(nearbyDriversInteractor, "nearbyDriversInteractor");
        Intrinsics.f(driverStateInteractor, "driverStateInteractor");
        Intrinsics.f(fifoQueueManager, "fifoQueueManager");
        Intrinsics.f(fifoQueueMapInteractor, "fifoQueueMapInteractor");
        Intrinsics.f(getHeatmapInteractor, "getHeatmapInteractor");
        Intrinsics.f(appThemeManager, "appThemeManager");
        Intrinsics.f(campaignManager, "campaignManager");
        this.f30118f = driverAreaInteractor;
        this.f30119g = nearbyDriversInteractor;
        this.f30120h = driverStateInteractor;
        this.f30121i = fifoQueueManager;
        this.f30122j = fifoQueueMapInteractor;
        this.f30123k = getHeatmapInteractor;
        this.f30124l = appThemeManager;
        this.f30125m = campaignManager;
        MutableLiveData<DriverArea> mutableLiveData = new MutableLiveData<>();
        this.f30126n = mutableLiveData;
        this.f30127o = mutableLiveData;
        MutableLiveData<List<NearbyDriver>> mutableLiveData2 = new MutableLiveData<>();
        this.f30129q = mutableLiveData2;
        this.f30130r = mutableLiveData2;
        MutableLiveData<DriverStatus> mutableLiveData3 = new MutableLiveData<>();
        this.f30132t = mutableLiveData3;
        this.f30133u = mutableLiveData3;
        MutableLiveData<ActiveAndPendingCampaignInfo> mutableLiveData4 = new MutableLiveData<>();
        this.f30135w = mutableLiveData4;
        this.f30136x = mutableLiveData4;
        MutableLiveData<FifoQueueMap> mutableLiveData5 = new MutableLiveData<>();
        this.f30138z = mutableLiveData5;
        this.A = mutableLiveData5;
        MutableLiveData<Heatmap> mutableLiveData6 = new MutableLiveData<>();
        this.C = mutableLiveData6;
        this.D = mutableLiveData6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        Observable g8 = ObservableExtKt.g(this.f30118f.f());
        final Function1<DriverArea, Unit> function1 = new Function1<DriverArea, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DriverArea driverArea) {
                MutableLiveData mutableLiveData;
                mutableLiveData = WorkMapViewModel.this.f30126n;
                mutableLiveData.o(driverArea);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverArea driverArea) {
                b(driverArea);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkMapViewModel.d0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapViewModel$onStart$2
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
                WorkMapViewModel workMapViewModel = WorkMapViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(workMapViewModel, it, null, 2, null);
            }
        };
        this.f30128p = g8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkMapViewModel.e0(Function1.this, obj);
            }
        });
        Observable g9 = ObservableExtKt.g(this.f30119g.e());
        final Function1<List<? extends NearbyDriver>, Unit> function13 = new Function1<List<? extends NearbyDriver>, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapViewModel$onStart$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(List<NearbyDriver> list) {
                MutableLiveData mutableLiveData;
                mutableLiveData = WorkMapViewModel.this.f30129q;
                mutableLiveData.o(list);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends NearbyDriver> list) {
                b(list);
                return Unit.f50853a;
            }
        };
        Consumer consumer2 = new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkMapViewModel.g0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function14 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapViewModel$onStart$4
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
                WorkMapViewModel workMapViewModel = WorkMapViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(workMapViewModel, it, null, 2, null);
            }
        };
        this.f30131s = g9.subscribe(consumer2, new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkMapViewModel.h0(Function1.this, obj);
            }
        });
        Observable<DriverStatus> a8 = this.f30120h.a();
        final Function1<DriverStatus, Unit> function15 = new Function1<DriverStatus, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapViewModel$onStart$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DriverStatus driverStatus) {
                MutableLiveData mutableLiveData;
                mutableLiveData = WorkMapViewModel.this.f30132t;
                mutableLiveData.o(driverStatus);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverStatus driverStatus) {
                b(driverStatus);
                return Unit.f50853a;
            }
        };
        Consumer<? super DriverStatus> consumer3 = new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkMapViewModel.i0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function16 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapViewModel$onStart$6
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
                WorkMapViewModel workMapViewModel = WorkMapViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(workMapViewModel, it, null, 2, null);
            }
        };
        this.f30134v = a8.subscribe(consumer3, new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.o
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkMapViewModel.j0(Function1.this, obj);
            }
        });
        Observable<Notification<ActiveAndPendingCampaignInfo>> K = this.f30125m.K();
        final Function1<Notification<ActiveAndPendingCampaignInfo>, Unit> function17 = new Function1<Notification<ActiveAndPendingCampaignInfo>, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapViewModel$onStart$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Notification<ActiveAndPendingCampaignInfo> notification) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                if (notification.h()) {
                    ActiveAndPendingCampaignInfo e8 = notification.e();
                    mutableLiveData = WorkMapViewModel.this.f30135w;
                    if (!Intrinsics.a(e8, mutableLiveData.f())) {
                        mutableLiveData2 = WorkMapViewModel.this.f30135w;
                        mutableLiveData2.o(notification.e());
                    }
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Notification<ActiveAndPendingCampaignInfo> notification) {
                b(notification);
                return Unit.f50853a;
            }
        };
        this.f30137y = K.subscribe(new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.p
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkMapViewModel.k0(Function1.this, obj);
            }
        });
        Observable g10 = ObservableExtKt.g(this.f30122j.b());
        final Function1<FifoQueueMap, Unit> function18 = new Function1<FifoQueueMap, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapViewModel$onStart$8
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(FifoQueueMap fifoQueueMap) {
                MutableLiveData mutableLiveData;
                mutableLiveData = WorkMapViewModel.this.f30138z;
                mutableLiveData.o(fifoQueueMap);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FifoQueueMap fifoQueueMap) {
                b(fifoQueueMap);
                return Unit.f50853a;
            }
        };
        Consumer consumer4 = new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.q
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkMapViewModel.l0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function19 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapViewModel$onStart$9
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
                WorkMapViewModel workMapViewModel = WorkMapViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(workMapViewModel, it, null, 2, null);
            }
        };
        this.B = g10.subscribe(consumer4, new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.r
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkMapViewModel.m0(Function1.this, obj);
            }
        });
        Observable g11 = ObservableExtKt.g(this.f30123k.c());
        final Function1<Heatmap, Unit> function110 = new Function1<Heatmap, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapViewModel$onStart$10
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Heatmap heatmap) {
                MutableLiveData mutableLiveData;
                mutableLiveData = WorkMapViewModel.this.C;
                mutableLiveData.o(heatmap);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Heatmap heatmap) {
                b(heatmap);
                return Unit.f50853a;
            }
        };
        Consumer consumer5 = new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkMapViewModel.n0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function111 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.WorkMapViewModel$onStart$11
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
                WorkMapViewModel workMapViewModel = WorkMapViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(workMapViewModel, it, null, 2, null);
            }
        };
        this.E = g11.subscribe(consumer5, new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.map.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkMapViewModel.f0(Function1.this, obj);
            }
        });
    }

    public final void U() {
        this.f30121i.r();
    }

    public final void V() {
        this.f30125m.v();
    }

    public final LiveData<ActiveAndPendingCampaignInfo> W() {
        return this.f30136x;
    }

    public final LiveData<DriverArea> X() {
        return this.f30127o;
    }

    public final LiveData<DriverStatus> Y() {
        return this.f30133u;
    }

    public final LiveData<FifoQueueMap> Z() {
        return this.A;
    }

    public final LiveData<Heatmap> a0() {
        return this.D;
    }

    public final MapStyle b0() {
        return AppThemeUtils.f34255a.c(this.f30124l.d());
    }

    public final LiveData<List<NearbyDriver>> c0() {
        return this.f30130r;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f30128p;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Disposable disposable2 = this.f30131s;
        if (disposable2 != null) {
            DisposableExtKt.a(disposable2);
        }
        Disposable disposable3 = this.f30134v;
        if (disposable3 != null) {
            DisposableExtKt.a(disposable3);
        }
        Disposable disposable4 = this.B;
        if (disposable4 != null) {
            DisposableExtKt.a(disposable4);
        }
        Disposable disposable5 = this.E;
        if (disposable5 != null) {
            DisposableExtKt.a(disposable5);
        }
    }
}
