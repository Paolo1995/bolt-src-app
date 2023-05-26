package ee.mtakso.driver.ui.screens.blocking;

import androidx.lifecycle.LiveData;
import ee.mtakso.driver.network.client.support.SupportClient;
import ee.mtakso.driver.network.client.support.SupportWebAppLinkResponse;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.geo.GeoLocationManagerState;
import ee.mtakso.driver.service.geo.state.GeoLocationIssue;
import ee.mtakso.driver.service.push.PushMessage;
import ee.mtakso.driver.service.push.PushNotificationManager;
import ee.mtakso.driver.service.push.SupportPushMessage;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.ObservableLiveData;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverAppDisabledViewModel.kt */
/* loaded from: classes3.dex */
public final class DriverAppDisabledViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final GeoLocationManager f27064f;

    /* renamed from: g  reason: collision with root package name */
    private final PushNotificationManager f27065g;

    /* renamed from: h  reason: collision with root package name */
    private final SupportClient f27066h;

    /* renamed from: i  reason: collision with root package name */
    private final LiveEvent<GeoLocationIssue> f27067i;

    /* renamed from: j  reason: collision with root package name */
    private final LiveEvent<String> f27068j;

    /* renamed from: k  reason: collision with root package name */
    private final LiveEvent<String> f27069k;

    /* renamed from: l  reason: collision with root package name */
    private Disposable f27070l;

    /* renamed from: m  reason: collision with root package name */
    private Disposable f27071m;

    /* renamed from: n  reason: collision with root package name */
    private Disposable f27072n;

    /* renamed from: o  reason: collision with root package name */
    private final ObservableLiveData<GeoLocationManagerState> f27073o;

    @Inject
    public DriverAppDisabledViewModel(GeoLocationManager locationManager, PushNotificationManager pushNotificationManager, SupportClient supportClient) {
        Intrinsics.f(locationManager, "locationManager");
        Intrinsics.f(pushNotificationManager, "pushNotificationManager");
        Intrinsics.f(supportClient, "supportClient");
        this.f27064f = locationManager;
        this.f27065g = pushNotificationManager;
        this.f27066h = supportClient;
        this.f27067i = new LiveEvent<>();
        this.f27068j = new LiveEvent<>();
        this.f27069k = new LiveEvent<>();
        this.f27073o = new ObservableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        ObservableLiveData.t(this.f27073o, this.f27064f.v(), null, new DriverAppDisabledViewModel$onStart$1(this), 2, null);
    }

    public final GeoLocationManager N() {
        return this.f27064f;
    }

    public final ObservableLiveData<GeoLocationManagerState> O() {
        return this.f27073o;
    }

    public final LiveData<GeoLocationIssue> P() {
        return this.f27067i;
    }

    public final LiveData<String> Q() {
        return this.f27068j;
    }

    public final LiveData<String> R() {
        return this.f27069k;
    }

    public final void S() {
        if (!DisposableExtKt.b(this.f27072n)) {
            Kalev.l("Url is already loading");
            return;
        }
        Single l8 = l(SingleExtKt.d(this.f27066h.j()));
        final Function1<SupportWebAppLinkResponse, Unit> function1 = new Function1<SupportWebAppLinkResponse, Unit>() { // from class: ee.mtakso.driver.ui.screens.blocking.DriverAppDisabledViewModel$requestSupportWebAppLinkForInbox$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(SupportWebAppLinkResponse supportWebAppLinkResponse) {
                LiveEvent liveEvent;
                liveEvent = DriverAppDisabledViewModel.this.f27069k;
                liveEvent.o(supportWebAppLinkResponse.a());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SupportWebAppLinkResponse supportWebAppLinkResponse) {
                b(supportWebAppLinkResponse);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.blocking.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverAppDisabledViewModel.T(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.blocking.DriverAppDisabledViewModel$requestSupportWebAppLinkForInbox$2
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
                DriverAppDisabledViewModel driverAppDisabledViewModel = DriverAppDisabledViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(driverAppDisabledViewModel, it, null, 2, null);
            }
        };
        this.f27072n = l8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.blocking.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverAppDisabledViewModel.U(Function1.this, obj);
            }
        });
    }

    public final void V() {
        Disposable disposable = this.f27070l;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Single d8 = SingleExtKt.d(this.f27064f.z());
        final Function1<Optional<GeoLocationIssue>, Unit> function1 = new Function1<Optional<GeoLocationIssue>, Unit>() { // from class: ee.mtakso.driver.ui.screens.blocking.DriverAppDisabledViewModel$startObservingGeoLocationIssue$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Optional<GeoLocationIssue> optional) {
                LiveEvent liveEvent;
                liveEvent = DriverAppDisabledViewModel.this.f27067i;
                liveEvent.m(optional.c());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Optional<GeoLocationIssue> optional) {
                b(optional);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.blocking.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverAppDisabledViewModel.W(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.blocking.DriverAppDisabledViewModel$startObservingGeoLocationIssue$2
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
                DriverAppDisabledViewModel driverAppDisabledViewModel = DriverAppDisabledViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(driverAppDisabledViewModel, it, null, 2, null);
            }
        };
        this.f27070l = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.blocking.o
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverAppDisabledViewModel.X(Function1.this, obj);
            }
        });
    }

    public final void Y() {
        Disposable disposable = this.f27071m;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Observable g8 = ObservableExtKt.g(this.f27065g.i());
        final DriverAppDisabledViewModel$startObservingSupportPushNotifications$1 driverAppDisabledViewModel$startObservingSupportPushNotifications$1 = new Function1<PushMessage, Boolean>() { // from class: ee.mtakso.driver.ui.screens.blocking.DriverAppDisabledViewModel$startObservingSupportPushNotifications$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(PushMessage it) {
                Intrinsics.f(it, "it");
                return Boolean.valueOf(it instanceof SupportPushMessage);
            }
        };
        Observable filter = g8.filter(new Predicate() { // from class: ee.mtakso.driver.ui.screens.blocking.k
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean Z;
                Z = DriverAppDisabledViewModel.Z(Function1.this, obj);
                return Z;
            }
        });
        final Function1<PushMessage, Unit> function1 = new Function1<PushMessage, Unit>() { // from class: ee.mtakso.driver.ui.screens.blocking.DriverAppDisabledViewModel$startObservingSupportPushNotifications$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(PushMessage pushMessage) {
                LiveEvent liveEvent;
                liveEvent = DriverAppDisabledViewModel.this.f27068j;
                Intrinsics.d(pushMessage, "null cannot be cast to non-null type ee.mtakso.driver.service.push.SupportPushMessage");
                liveEvent.m(((SupportPushMessage) pushMessage).a());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PushMessage pushMessage) {
                b(pushMessage);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.blocking.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverAppDisabledViewModel.a0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.blocking.DriverAppDisabledViewModel$startObservingSupportPushNotifications$3
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
                DriverAppDisabledViewModel driverAppDisabledViewModel = DriverAppDisabledViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(driverAppDisabledViewModel, it, null, 2, null);
            }
        };
        this.f27071m = filter.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.blocking.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverAppDisabledViewModel.b0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.f27070l;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Disposable disposable2 = this.f27071m;
        if (disposable2 != null) {
            DisposableExtKt.a(disposable2);
        }
        Disposable disposable3 = this.f27072n;
        if (disposable3 != null) {
            DisposableExtKt.a(disposable3);
        }
        DisposableExtKt.a(this.f27073o);
    }
}
