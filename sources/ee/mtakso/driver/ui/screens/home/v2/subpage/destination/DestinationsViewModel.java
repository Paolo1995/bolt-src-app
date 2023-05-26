package ee.mtakso.driver.ui.screens.home.v2.subpage.destination;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.settings.DriverDestination;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.geo.GeoLocationManagerState;
import ee.mtakso.driver.service.geo.state.GeoLocationIssue;
import ee.mtakso.driver.service.modules.driverdestinations.DestinationLimit;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.interactor.destination.ActiveDestinationInteractor;
import ee.mtakso.driver.ui.interactor.destination.DeactivateDestinationInteractor;
import ee.mtakso.driver.ui.interactor.destination.DeleteDestinationInteractor;
import ee.mtakso.driver.ui.interactor.destination.DestinationLimitInteractor;
import ee.mtakso.driver.ui.interactor.destination.SavedDestinationsInteractor;
import ee.mtakso.driver.ui.interactor.destination.SelectDestinationInteractor;
import ee.mtakso.driver.ui.screens.destination.DestinationMapper;
import ee.mtakso.driver.ui.screens.destination.DestinationScreenState;
import ee.mtakso.driver.ui.screens.home.v2.subpage.destination.DestinationsViewModel;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: DestinationsViewModel.kt */
/* loaded from: classes3.dex */
public final class DestinationsViewModel extends BaseViewModel {
    private final LiveEvent<Unit> A;
    private final LiveData<Unit> B;
    private Disposable C;
    private final LiveEvent<GeoLocationIssue> D;
    private final LiveData<GeoLocationIssue> E;
    private Disposable F;
    private Disposable G;
    private Disposable H;
    private final LiveEvent<DriverDestination> I;
    private final LiveData<DriverDestination> J;
    private final LiveEvent<DriverDestination> K;
    private final LiveData<DriverDestination> L;

    /* renamed from: f  reason: collision with root package name */
    private final DestinationLimitInteractor f29695f;

    /* renamed from: g  reason: collision with root package name */
    private final SavedDestinationsInteractor f29696g;

    /* renamed from: h  reason: collision with root package name */
    private final ActiveDestinationInteractor f29697h;

    /* renamed from: i  reason: collision with root package name */
    private final SelectDestinationInteractor f29698i;

    /* renamed from: j  reason: collision with root package name */
    private final DeactivateDestinationInteractor f29699j;

    /* renamed from: k  reason: collision with root package name */
    private final DeleteDestinationInteractor f29700k;

    /* renamed from: l  reason: collision with root package name */
    private final GeoLocationManager f29701l;

    /* renamed from: m  reason: collision with root package name */
    private final DestinationMapper f29702m;

    /* renamed from: n  reason: collision with root package name */
    private final DriverProvider f29703n;

    /* renamed from: o  reason: collision with root package name */
    private final MutableLiveData<DestinationLimit> f29704o;

    /* renamed from: p  reason: collision with root package name */
    private final LiveData<DestinationLimit> f29705p;

    /* renamed from: q  reason: collision with root package name */
    private Disposable f29706q;

    /* renamed from: r  reason: collision with root package name */
    private final MutableLiveData<DestinationScreenState> f29707r;

    /* renamed from: s  reason: collision with root package name */
    private final LiveData<DestinationScreenState> f29708s;

    /* renamed from: t  reason: collision with root package name */
    private Disposable f29709t;

    /* renamed from: u  reason: collision with root package name */
    private final MutableLiveData<Optional<DriverDestination>> f29710u;

    /* renamed from: v  reason: collision with root package name */
    private final LiveData<Optional<DriverDestination>> f29711v;

    /* renamed from: w  reason: collision with root package name */
    private Disposable f29712w;

    /* renamed from: x  reason: collision with root package name */
    private final LiveEvent<Object> f29713x;

    /* renamed from: y  reason: collision with root package name */
    private final LiveData<Object> f29714y;

    /* renamed from: z  reason: collision with root package name */
    private Disposable f29715z;

    @Inject
    public DestinationsViewModel(DestinationLimitInteractor destinationLimitInteractor, SavedDestinationsInteractor savedDestinationsInteractor, ActiveDestinationInteractor activeDestinationInteractor, SelectDestinationInteractor selectDestinationInteractor, DeactivateDestinationInteractor deactivateDestinationInteractor, DeleteDestinationInteractor deleteDestinationInteractor, GeoLocationManager locationManager, DestinationMapper destinationMapper, DriverProvider driverProvider) {
        Intrinsics.f(destinationLimitInteractor, "destinationLimitInteractor");
        Intrinsics.f(savedDestinationsInteractor, "savedDestinationsInteractor");
        Intrinsics.f(activeDestinationInteractor, "activeDestinationInteractor");
        Intrinsics.f(selectDestinationInteractor, "selectDestinationInteractor");
        Intrinsics.f(deactivateDestinationInteractor, "deactivateDestinationInteractor");
        Intrinsics.f(deleteDestinationInteractor, "deleteDestinationInteractor");
        Intrinsics.f(locationManager, "locationManager");
        Intrinsics.f(destinationMapper, "destinationMapper");
        Intrinsics.f(driverProvider, "driverProvider");
        this.f29695f = destinationLimitInteractor;
        this.f29696g = savedDestinationsInteractor;
        this.f29697h = activeDestinationInteractor;
        this.f29698i = selectDestinationInteractor;
        this.f29699j = deactivateDestinationInteractor;
        this.f29700k = deleteDestinationInteractor;
        this.f29701l = locationManager;
        this.f29702m = destinationMapper;
        this.f29703n = driverProvider;
        MutableLiveData<DestinationLimit> mutableLiveData = new MutableLiveData<>();
        this.f29704o = mutableLiveData;
        this.f29705p = mutableLiveData;
        MutableLiveData<DestinationScreenState> mutableLiveData2 = new MutableLiveData<>();
        this.f29707r = mutableLiveData2;
        this.f29708s = mutableLiveData2;
        MutableLiveData<Optional<DriverDestination>> mutableLiveData3 = new MutableLiveData<>();
        this.f29710u = mutableLiveData3;
        this.f29711v = mutableLiveData3;
        LiveEvent<Object> liveEvent = new LiveEvent<>();
        this.f29713x = liveEvent;
        this.f29714y = liveEvent;
        LiveEvent<Unit> liveEvent2 = new LiveEvent<>();
        this.A = liveEvent2;
        this.B = liveEvent2;
        LiveEvent<GeoLocationIssue> liveEvent3 = new LiveEvent<>();
        this.D = liveEvent3;
        this.E = liveEvent3;
        LiveEvent<DriverDestination> liveEvent4 = new LiveEvent<>();
        this.I = liveEvent4;
        this.J = liveEvent4;
        LiveEvent<DriverDestination> liveEvent5 = new LiveEvent<>();
        this.K = liveEvent5;
        this.L = liveEvent5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(DestinationsViewModel this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.f29713x.o(new Object());
        this$0.y().o(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static /* synthetic */ void E0(DestinationsViewModel destinationsViewModel, DriverDestination driverDestination, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        destinationsViewModel.D0(driverDestination, z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(DestinationsViewModel this$0, DriverDestination driverDestination) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(driverDestination, "$driverDestination");
        this$0.y().o(Boolean.FALSE);
        this$0.m0();
        this$0.K.o(driverDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        this.f29703n.t().o().b(true);
        Observable<DestinationLimit> a8 = this.f29695f.a();
        final Function1<DestinationLimit, Unit> function1 = new Function1<DestinationLimit, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v2.subpage.destination.DestinationsViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DestinationLimit destinationLimit) {
                MutableLiveData mutableLiveData;
                mutableLiveData = DestinationsViewModel.this.f29704o;
                mutableLiveData.o(destinationLimit);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DestinationLimit destinationLimit) {
                b(destinationLimit);
                return Unit.f50853a;
            }
        };
        Consumer<? super DestinationLimit> consumer = new Consumer() { // from class: x3.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DestinationsViewModel.q0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v2.subpage.destination.DestinationsViewModel$onStart$2
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
                DestinationsViewModel destinationsViewModel = DestinationsViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(destinationsViewModel, it, null, 2, null);
            }
        };
        this.f29706q = a8.subscribe(consumer, new Consumer() { // from class: x3.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DestinationsViewModel.r0(Function1.this, obj);
            }
        });
        Observable<Optional<DriverDestination>> a9 = this.f29697h.a();
        final Function1<Optional<DriverDestination>, Unit> function13 = new Function1<Optional<DriverDestination>, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v2.subpage.destination.DestinationsViewModel$onStart$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Optional<DriverDestination> optional) {
                MutableLiveData mutableLiveData;
                mutableLiveData = DestinationsViewModel.this.f29710u;
                mutableLiveData.o(optional);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Optional<DriverDestination> optional) {
                b(optional);
                return Unit.f50853a;
            }
        };
        Consumer<? super Optional<DriverDestination>> consumer2 = new Consumer() { // from class: x3.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DestinationsViewModel.s0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function14 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v2.subpage.destination.DestinationsViewModel$onStart$4
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
                DestinationsViewModel destinationsViewModel = DestinationsViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(destinationsViewModel, it, null, 2, null);
            }
        };
        this.f29712w = a9.subscribe(consumer2, new Consumer() { // from class: x3.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DestinationsViewModel.t0(Function1.this, obj);
            }
        });
        Observable<GeoLocationManagerState> take = this.f29701l.v().take(1L);
        Intrinsics.e(take, "locationManager\n        …te()\n            .take(1)");
        Observable g8 = ObservableExtKt.g(take);
        final Function1<GeoLocationManagerState, Unit> function15 = new Function1<GeoLocationManagerState, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v2.subpage.destination.DestinationsViewModel$onStart$5

            /* compiled from: DestinationsViewModel.kt */
            /* loaded from: classes3.dex */
            public /* synthetic */ class WhenMappings {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f29726a;

                static {
                    int[] iArr = new int[GeoLocationManagerState.values().length];
                    try {
                        iArr[GeoLocationManagerState.MOCKED_LOCATION_FOUND.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[GeoLocationManagerState.LOCATION_ACCESS_ISSUE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f29726a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(GeoLocationManagerState geoLocationManagerState) {
                int i8;
                LiveEvent liveEvent;
                if (geoLocationManagerState == null) {
                    i8 = -1;
                } else {
                    i8 = WhenMappings.f29726a[geoLocationManagerState.ordinal()];
                }
                if (i8 == 1 || i8 == 2) {
                    liveEvent = DestinationsViewModel.this.A;
                    liveEvent.o(Unit.f50853a);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GeoLocationManagerState geoLocationManagerState) {
                b(geoLocationManagerState);
                return Unit.f50853a;
            }
        };
        Consumer consumer3 = new Consumer() { // from class: x3.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DestinationsViewModel.u0(Function1.this, obj);
            }
        };
        final DestinationsViewModel$onStart$6 destinationsViewModel$onStart$6 = new DestinationsViewModel$onStart$6(this);
        this.C = g8.subscribe(consumer3, new Consumer() { // from class: x3.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DestinationsViewModel.v0(Function1.this, obj);
            }
        });
    }

    public final void D0(DriverDestination driverDestination, boolean z7) {
        String a8;
        boolean y7;
        boolean z8 = false;
        if (driverDestination != null && (a8 = driverDestination.a()) != null) {
            y7 = StringsKt__StringsJVMKt.y(a8);
            if (!y7) {
                z8 = true;
            }
        }
        if (z8 && !z7) {
            z0(driverDestination);
        } else {
            this.I.o(driverDestination);
        }
    }

    public final void b0(final DriverDestination driverDestination) {
        Intrinsics.f(driverDestination, "driverDestination");
        Disposable disposable = this.H;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Completable a8 = this.f29700k.a(driverDestination.b());
        final Function1<Disposable, Unit> function1 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v2.subpage.destination.DestinationsViewModel$deleteDestination$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable2) {
                MutableLiveData y7;
                y7 = DestinationsViewModel.this.y();
                y7.o(Boolean.TRUE);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable2) {
                b(disposable2);
                return Unit.f50853a;
            }
        };
        Completable r7 = a8.r(new Consumer() { // from class: x3.p
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DestinationsViewModel.c0(Function1.this, obj);
            }
        });
        Action action = new Action() { // from class: x3.q
            @Override // io.reactivex.functions.Action
            public final void run() {
                DestinationsViewModel.d0(DestinationsViewModel.this, driverDestination);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v2.subpage.destination.DestinationsViewModel$deleteDestination$3
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
                MutableLiveData y7;
                y7 = DestinationsViewModel.this.y();
                y7.o(Boolean.FALSE);
                DestinationsViewModel destinationsViewModel = DestinationsViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(destinationsViewModel, it, null, 2, null);
            }
        };
        this.H = r7.G(action, new Consumer() { // from class: x3.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DestinationsViewModel.e0(Function1.this, obj);
            }
        });
    }

    public final LiveData<DriverDestination> f0() {
        return this.L;
    }

    public final LiveData<DestinationLimit> g0() {
        return this.f29705p;
    }

    public final LiveData<GeoLocationIssue> h0() {
        return this.E;
    }

    public final LiveData<Unit> i0() {
        return this.B;
    }

    public final LiveData<DestinationScreenState> j0() {
        return this.f29708s;
    }

    public final LiveData<Object> k0() {
        return this.f29714y;
    }

    public final LiveData<DriverDestination> l0() {
        return this.J;
    }

    public final void m0() {
        Single<List<DriverDestination>> d8 = this.f29696g.d();
        final Function1<Disposable, Unit> function1 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v2.subpage.destination.DestinationsViewModel$loadDestinations$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                MutableLiveData y7;
                y7 = DestinationsViewModel.this.y();
                y7.o(Boolean.TRUE);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Single<List<DriverDestination>> n8 = d8.n(new Consumer() { // from class: x3.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DestinationsViewModel.n0(Function1.this, obj);
            }
        });
        final Function1<List<? extends DriverDestination>, Unit> function12 = new Function1<List<? extends DriverDestination>, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v2.subpage.destination.DestinationsViewModel$loadDestinations$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(List<DriverDestination> it) {
                MutableLiveData y7;
                MutableLiveData mutableLiveData;
                DestinationMapper destinationMapper;
                y7 = DestinationsViewModel.this.y();
                y7.o(Boolean.FALSE);
                mutableLiveData = DestinationsViewModel.this.f29707r;
                destinationMapper = DestinationsViewModel.this.f29702m;
                Intrinsics.e(it, "it");
                mutableLiveData.o(new DestinationScreenState(destinationMapper.f(it), null, 2, null));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends DriverDestination> list) {
                b(list);
                return Unit.f50853a;
            }
        };
        Consumer<? super List<DriverDestination>> consumer = new Consumer() { // from class: x3.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DestinationsViewModel.o0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v2.subpage.destination.DestinationsViewModel$loadDestinations$3
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
                MutableLiveData y7;
                y7 = DestinationsViewModel.this.y();
                y7.o(Boolean.FALSE);
                DestinationsViewModel destinationsViewModel = DestinationsViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(destinationsViewModel, it, null, 2, null);
            }
        };
        this.f29709t = n8.I(consumer, new Consumer() { // from class: x3.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DestinationsViewModel.p0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f29706q;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Disposable disposable2 = this.f29709t;
        if (disposable2 != null) {
            DisposableExtKt.a(disposable2);
        }
        Disposable disposable3 = this.f29712w;
        if (disposable3 != null) {
            DisposableExtKt.a(disposable3);
        }
        Disposable disposable4 = this.f29715z;
        if (disposable4 != null) {
            DisposableExtKt.a(disposable4);
        }
        Disposable disposable5 = this.G;
        if (disposable5 != null) {
            DisposableExtKt.a(disposable5);
        }
        Disposable disposable6 = this.C;
        if (disposable6 != null) {
            DisposableExtKt.a(disposable6);
        }
        Disposable disposable7 = this.F;
        if (disposable7 != null) {
            DisposableExtKt.a(disposable7);
        }
        Disposable disposable8 = this.H;
        if (disposable8 != null) {
            DisposableExtKt.a(disposable8);
        }
    }

    public final void w0() {
        if (!DisposableExtKt.b(this.F)) {
            return;
        }
        Single l8 = l(SingleExtKt.d(this.f29701l.z()));
        final Function1<Optional<GeoLocationIssue>, Unit> function1 = new Function1<Optional<GeoLocationIssue>, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v2.subpage.destination.DestinationsViewModel$requestLocationIssue$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Optional<GeoLocationIssue> optional) {
                LiveEvent liveEvent;
                if (optional.c() != null) {
                    liveEvent = DestinationsViewModel.this.D;
                    liveEvent.o(optional.c());
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Optional<GeoLocationIssue> optional) {
                b(optional);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: x3.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DestinationsViewModel.x0(Function1.this, obj);
            }
        };
        final DestinationsViewModel$requestLocationIssue$2 destinationsViewModel$requestLocationIssue$2 = new DestinationsViewModel$requestLocationIssue$2(this);
        this.F = l8.I(consumer, new Consumer() { // from class: x3.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DestinationsViewModel.y0(Function1.this, obj);
            }
        });
    }

    public final void z0(DriverDestination destination) {
        Intrinsics.f(destination, "destination");
        Completable a8 = this.f29698i.a(destination);
        final Function1<Disposable, Unit> function1 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v2.subpage.destination.DestinationsViewModel$selectDestination$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                MutableLiveData y7;
                y7 = DestinationsViewModel.this.y();
                y7.o(Boolean.TRUE);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Completable r7 = a8.r(new Consumer() { // from class: x3.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DestinationsViewModel.C0(Function1.this, obj);
            }
        });
        Action action = new Action() { // from class: x3.n
            @Override // io.reactivex.functions.Action
            public final void run() {
                DestinationsViewModel.A0(DestinationsViewModel.this);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v2.subpage.destination.DestinationsViewModel$selectDestination$3
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
                MutableLiveData y7;
                y7 = DestinationsViewModel.this.y();
                y7.o(Boolean.FALSE);
                DestinationsViewModel destinationsViewModel = DestinationsViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(destinationsViewModel, it, null, 2, null);
            }
        };
        this.f29715z = r7.G(action, new Consumer() { // from class: x3.o
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DestinationsViewModel.B0(Function1.this, obj);
            }
        });
    }
}
