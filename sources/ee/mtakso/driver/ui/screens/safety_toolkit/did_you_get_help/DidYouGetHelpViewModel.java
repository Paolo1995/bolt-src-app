package ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.emergencyassist.EmergencyAssistClient;
import ee.mtakso.driver.service.analytics.event.facade.SafetyToolkitAnalytics;
import ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistManager;
import ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.driver.core.network.response.EmptyServerResponse;
import eu.bolt.driver.core.util.Optional;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DidYouGetHelpViewModel.kt */
/* loaded from: classes3.dex */
public final class DidYouGetHelpViewModel extends BaseViewModel {

    /* renamed from: j  reason: collision with root package name */
    public static final Companion f32628j = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final EmergencyAssistClient f32629f;

    /* renamed from: g  reason: collision with root package name */
    private final OrderProvider f32630g;

    /* renamed from: h  reason: collision with root package name */
    private final EmergencyAssistManager f32631h;

    /* renamed from: i  reason: collision with root package name */
    private final SafetyToolkitAnalytics f32632i;

    /* compiled from: DidYouGetHelpViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public DidYouGetHelpViewModel(EmergencyAssistClient emergencyAssistClient, OrderProvider orderProvider, EmergencyAssistManager emergencyAssistManager, SafetyToolkitAnalytics safetyToolkitAnalytics) {
        Intrinsics.f(emergencyAssistClient, "emergencyAssistClient");
        Intrinsics.f(orderProvider, "orderProvider");
        Intrinsics.f(emergencyAssistManager, "emergencyAssistManager");
        Intrinsics.f(safetyToolkitAnalytics, "safetyToolkitAnalytics");
        this.f32629f = emergencyAssistClient;
        this.f32630g = orderProvider;
        this.f32631h = emergencyAssistManager;
        this.f32632i = safetyToolkitAnalytics;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional O(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource P(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional T(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource U(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
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
    }

    public final void N() {
        List<OrderDetails> k8;
        this.f32632i.h("Yes");
        Observable<List<OrderDetails>> a8 = this.f32630g.a();
        k8 = CollectionsKt__CollectionsKt.k();
        Single<List<OrderDetails>> first = a8.first(k8);
        final DidYouGetHelpViewModel$onNoExtraHelpNeededTapped$1 didYouGetHelpViewModel$onNoExtraHelpNeededTapped$1 = new Function1<List<? extends OrderDetails>, Optional<OrderHandle>>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpViewModel$onNoExtraHelpNeededTapped$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<OrderHandle> invoke(List<? extends OrderDetails> it) {
                OrderHandle orderHandle;
                Intrinsics.f(it, "it");
                Optional.Companion companion = Optional.f41306b;
                ActiveOrderDetails j8 = OrderProviderUtils.j(it);
                if (j8 != null) {
                    orderHandle = j8.a();
                } else {
                    orderHandle = null;
                }
                return companion.b(orderHandle);
            }
        };
        Single<R> x7 = first.x(new Function() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.h
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional O;
                O = DidYouGetHelpViewModel.O(Function1.this, obj);
                return O;
            }
        });
        final Function1<Optional<OrderHandle>, SingleSource<? extends EmptyServerResponse>> function1 = new Function1<Optional<OrderHandle>, SingleSource<? extends EmptyServerResponse>>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpViewModel$onNoExtraHelpNeededTapped$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends EmptyServerResponse> invoke(Optional<OrderHandle> it) {
                EmergencyAssistClient emergencyAssistClient;
                Intrinsics.f(it, "it");
                emergencyAssistClient = DidYouGetHelpViewModel.this.f32629f;
                return SingleExtKt.d(emergencyAssistClient.f(it.b()));
            }
        };
        Single r7 = x7.r(new Function() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.i
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource P;
                P = DidYouGetHelpViewModel.P(Function1.this, obj);
                return P;
            }
        });
        final Function1<EmptyServerResponse, Unit> function12 = new Function1<EmptyServerResponse, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpViewModel$onNoExtraHelpNeededTapped$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EmptyServerResponse emptyServerResponse) {
                EmergencyAssistManager emergencyAssistManager;
                emergencyAssistManager = DidYouGetHelpViewModel.this.f32631h;
                emergencyAssistManager.t(DidYouGetHelpType.NO_HELP_NEEDED);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EmptyServerResponse emptyServerResponse) {
                b(emptyServerResponse);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DidYouGetHelpViewModel.Q(Function1.this, obj);
            }
        };
        final DidYouGetHelpViewModel$onNoExtraHelpNeededTapped$4 didYouGetHelpViewModel$onNoExtraHelpNeededTapped$4 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpViewModel$onNoExtraHelpNeededTapped$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Kalev.d("Error with no help needed");
            }
        };
        Disposable I = r7.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DidYouGetHelpViewModel.R(Function1.this, obj);
            }
        });
        Intrinsics.e(I, "fun onNoExtraHelpNeededT…     .autoDispose()\n    }");
        v(I);
    }

    public final void S() {
        List<OrderDetails> k8;
        this.f32632i.h("No");
        Observable<List<OrderDetails>> a8 = this.f32630g.a();
        k8 = CollectionsKt__CollectionsKt.k();
        Single<List<OrderDetails>> first = a8.first(k8);
        final DidYouGetHelpViewModel$onRequestHelpFromBoltTapped$1 didYouGetHelpViewModel$onRequestHelpFromBoltTapped$1 = new Function1<List<? extends OrderDetails>, Optional<OrderHandle>>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpViewModel$onRequestHelpFromBoltTapped$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<OrderHandle> invoke(List<? extends OrderDetails> it) {
                OrderHandle orderHandle;
                Intrinsics.f(it, "it");
                Optional.Companion companion = Optional.f41306b;
                ActiveOrderDetails j8 = OrderProviderUtils.j(it);
                if (j8 != null) {
                    orderHandle = j8.a();
                } else {
                    orderHandle = null;
                }
                return companion.b(orderHandle);
            }
        };
        Single<R> x7 = first.x(new Function() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional T;
                T = DidYouGetHelpViewModel.T(Function1.this, obj);
                return T;
            }
        });
        final Function1<Optional<OrderHandle>, SingleSource<? extends EmptyServerResponse>> function1 = new Function1<Optional<OrderHandle>, SingleSource<? extends EmptyServerResponse>>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpViewModel$onRequestHelpFromBoltTapped$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends EmptyServerResponse> invoke(Optional<OrderHandle> it) {
                EmergencyAssistClient emergencyAssistClient;
                Intrinsics.f(it, "it");
                emergencyAssistClient = DidYouGetHelpViewModel.this.f32629f;
                return SingleExtKt.d(emergencyAssistClient.j(it.b()));
            }
        };
        Single r7 = x7.r(new Function() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.e
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource U;
                U = DidYouGetHelpViewModel.U(Function1.this, obj);
                return U;
            }
        });
        final Function1<EmptyServerResponse, Unit> function12 = new Function1<EmptyServerResponse, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpViewModel$onRequestHelpFromBoltTapped$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EmptyServerResponse emptyServerResponse) {
                EmergencyAssistManager emergencyAssistManager;
                emergencyAssistManager = DidYouGetHelpViewModel.this.f32631h;
                emergencyAssistManager.t(DidYouGetHelpType.REQUEST_HELP_FROM_BOLT);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EmptyServerResponse emptyServerResponse) {
                b(emptyServerResponse);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DidYouGetHelpViewModel.V(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpViewModel$onRequestHelpFromBoltTapped$4
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
                DidYouGetHelpViewModel didYouGetHelpViewModel = DidYouGetHelpViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(didYouGetHelpViewModel, it, null, 2, null);
                Kalev.d("Error with no help needed");
            }
        };
        Disposable I = r7.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DidYouGetHelpViewModel.W(Function1.this, obj);
            }
        });
        Intrinsics.e(I, "fun onRequestHelpFromBol…     .autoDispose()\n    }");
        v(I);
    }

    public final void X() {
        this.f32632i.b3();
    }

    public final void Y() {
        this.f32631h.t(DidYouGetHelpType.INITIAL);
    }
}
