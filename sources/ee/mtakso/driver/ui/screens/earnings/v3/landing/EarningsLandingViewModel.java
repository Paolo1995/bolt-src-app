package ee.mtakso.driver.ui.screens.earnings.v3.landing;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.modal.ModalDialogResponse;
import ee.mtakso.driver.service.earnings.EarningsManager;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.interactor.modaldialog.BackendModalDialogActionReporterInteractor;
import ee.mtakso.driver.ui.interactor.modaldialog.PromoDialogEvent;
import ee.mtakso.driver.ui.interactor.modaldialog.SingleModalDialogInteractor;
import ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsLandingState;
import ee.mtakso.driver.ui.screens.modal.ModalAction;
import ee.mtakso.driver.utils.CompletableExtKt;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.driver.earnings.network.EarningLandingScreen;
import eu.bolt.kalev.Kalev;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsLandingViewModel.kt */
/* loaded from: classes3.dex */
public final class EarningsLandingViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final EarningsManager f29348f;

    /* renamed from: g  reason: collision with root package name */
    private final SingleModalDialogInteractor f29349g;

    /* renamed from: h  reason: collision with root package name */
    private final BackendModalDialogActionReporterInteractor f29350h;

    /* renamed from: i  reason: collision with root package name */
    private final MutableLiveData<EarningsLandingState> f29351i;

    /* renamed from: j  reason: collision with root package name */
    private Disposable f29352j;

    /* renamed from: k  reason: collision with root package name */
    private final LiveEvent<EarningsModal> f29353k;

    @Inject
    public EarningsLandingViewModel(EarningsManager earningsManager, SingleModalDialogInteractor modalInteractor, BackendModalDialogActionReporterInteractor modalActionReporterInteractor) {
        Intrinsics.f(earningsManager, "earningsManager");
        Intrinsics.f(modalInteractor, "modalInteractor");
        Intrinsics.f(modalActionReporterInteractor, "modalActionReporterInteractor");
        this.f29348f = earningsManager;
        this.f29349g = modalInteractor;
        this.f29350h = modalActionReporterInteractor;
        this.f29351i = new MutableLiveData<>();
        this.f29353k = new LiveEvent<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Q() {
        Disposable disposable = this.f29352j;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Observable k8 = k(ObservableExtKt.g(this.f29348f.k()));
        final Function1<EarningLandingScreen, Unit> function1 = new Function1<EarningLandingScreen, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsLandingViewModel$request$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EarningLandingScreen it) {
                MutableLiveData mutableLiveData;
                mutableLiveData = EarningsLandingViewModel.this.f29351i;
                Intrinsics.e(it, "it");
                mutableLiveData.o(new EarningsLandingState.Ready(it));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EarningLandingScreen earningLandingScreen) {
                b(earningLandingScreen);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.p
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EarningsLandingViewModel.R(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsLandingViewModel$request$2
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
                MutableLiveData mutableLiveData;
                EarningsLandingViewModel earningsLandingViewModel = EarningsLandingViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(earningsLandingViewModel, it, null, 2, null);
                mutableLiveData = EarningsLandingViewModel.this.f29351i;
                mutableLiveData.o(new EarningsLandingState.Error(it));
            }
        };
        this.f29352j = k8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.q
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EarningsLandingViewModel.S(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void U() {
        Single d8 = SingleExtKt.d(this.f29349g.a(PromoDialogEvent.EARNINGS.c()));
        final Function1<Optional<ModalDialogResponse>, Unit> function1 = new Function1<Optional<ModalDialogResponse>, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsLandingViewModel$requestModal$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Optional<ModalDialogResponse> optional) {
                LiveEvent liveEvent;
                ModalDialogResponse c8 = optional.c();
                if (c8 != null) {
                    liveEvent = EarningsLandingViewModel.this.f29353k;
                    liveEvent.o(new EarningsModal(c8));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Optional<ModalDialogResponse> optional) {
                b(optional);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EarningsLandingViewModel.V(Function1.this, obj);
            }
        };
        final EarningsLandingViewModel$requestModal$2 earningsLandingViewModel$requestModal$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsLandingViewModel$requestModal$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to load modal");
            }
        };
        Disposable I = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.o
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EarningsLandingViewModel.W(Function1.this, obj);
            }
        });
        Intrinsics.e(I, "private fun requestModal…     .autoDispose()\n    }");
        v(I);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        this.f29351i.o(EarningsLandingState.Loading.f29345a);
        Q();
        U();
    }

    public final void L(ModalAction payload) {
        Intrinsics.f(payload, "payload");
        Completable a8 = CompletableExtKt.a(this.f29350h.a(payload.c(), payload.a()));
        Action action = new Action() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.l
            @Override // io.reactivex.functions.Action
            public final void run() {
                EarningsLandingViewModel.M();
            }
        };
        final EarningsLandingViewModel$handleModalAction$2 earningsLandingViewModel$handleModalAction$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsLandingViewModel$handleModalAction$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to report modal action");
            }
        };
        Disposable G = a8.G(action, new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.landing.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EarningsLandingViewModel.N(Function1.this, obj);
            }
        });
        Intrinsics.e(G, "modalActionReporterInter… action\") }\n            )");
        v(G);
    }

    public final LiveData<EarningsLandingState> O() {
        return this.f29351i;
    }

    public final LiveData<EarningsModal> P() {
        return this.f29353k;
    }

    public final void T() {
        Disposable disposable = this.f29352j;
        boolean z7 = true;
        if ((disposable == null || !disposable.isDisposed()) ? false : false) {
            this.f29351i.o(EarningsLandingState.Retrying.f29347a);
            Q();
        }
    }
}
