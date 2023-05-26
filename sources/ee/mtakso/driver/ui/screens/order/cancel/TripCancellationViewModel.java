package ee.mtakso.driver.ui.screens.order.cancel;

import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.model.CancellationReason;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.order.RejectOrderResponse;
import ee.mtakso.driver.network.client.order.RejectReason;
import ee.mtakso.driver.network.client.order.RejectResponseType;
import ee.mtakso.driver.param.RateMePrefsManager;
import ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics;
import ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils;
import ee.mtakso.driver.service.modules.order.v2.OrderStateManager;
import ee.mtakso.driver.service.order.ScheduledOrderManager;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.screens.order.cancel.WhyCancelError;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TripCancellationViewModel.kt */
/* loaded from: classes3.dex */
public final class TripCancellationViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final OrderStateManager f31251f;

    /* renamed from: g  reason: collision with root package name */
    private final OrderProvider f31252g;

    /* renamed from: h  reason: collision with root package name */
    private final OrderFlowAnalytics f31253h;

    /* renamed from: i  reason: collision with root package name */
    private final ScheduledOrderManager f31254i;

    /* renamed from: j  reason: collision with root package name */
    private final HtmlEngine f31255j;

    /* renamed from: k  reason: collision with root package name */
    private final RateMePrefsManager f31256k;

    /* renamed from: l  reason: collision with root package name */
    private Disposable f31257l;

    /* renamed from: m  reason: collision with root package name */
    private Disposable f31258m;

    /* renamed from: n  reason: collision with root package name */
    private final MutableLiveData<TripCancellationState> f31259n;

    /* renamed from: o  reason: collision with root package name */
    private final LiveEvent<CharSequence> f31260o;

    /* compiled from: TripCancellationViewModel.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31261a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f31262b;

        static {
            int[] iArr = new int[RejectResponseType.values().length];
            try {
                iArr[RejectResponseType.REASONS_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RejectResponseType.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f31261a = iArr;
            int[] iArr2 = new int[OrderState.values().length];
            try {
                iArr2[OrderState.ORDER_STATE_WAITING_DRIVER_CONFIRMATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[OrderState.ORDER_STATE_DRIVER_ACCEPTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[OrderState.ORDER_STATE_DRIVER_ARRIVED_TO_CLIENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            f31262b = iArr2;
        }
    }

    @Inject
    public TripCancellationViewModel(OrderStateManager orderStateManager, OrderProvider orderProvider, OrderFlowAnalytics orderFlowAnalytics, ScheduledOrderManager scheduledOrderManager, HtmlEngine htmlEngine, RateMePrefsManager rateMePrefsManager) {
        Intrinsics.f(orderStateManager, "orderStateManager");
        Intrinsics.f(orderProvider, "orderProvider");
        Intrinsics.f(orderFlowAnalytics, "orderFlowAnalytics");
        Intrinsics.f(scheduledOrderManager, "scheduledOrderManager");
        Intrinsics.f(htmlEngine, "htmlEngine");
        Intrinsics.f(rateMePrefsManager, "rateMePrefsManager");
        this.f31251f = orderStateManager;
        this.f31252g = orderProvider;
        this.f31253h = orderFlowAnalytics;
        this.f31254i = scheduledOrderManager;
        this.f31255j = htmlEngine;
        this.f31256k = rateMePrefsManager;
        this.f31259n = new MutableLiveData<>(new TripCancellationState(null, null, false, null, null, null, null, 127, null));
        this.f31260o = new LiveEvent<>();
    }

    private final boolean J(ActiveOrderDetails activeOrderDetails, String str) {
        int i8 = WhenMappings.f31262b[activeOrderDetails.b().ordinal()];
        if (i8 != 1 && i8 != 2) {
            if (i8 != 3) {
                return false;
            }
            if (U(activeOrderDetails.b(), str) && activeOrderDetails.i().B() > activeOrderDetails.l()) {
                return false;
            }
        }
        return true;
    }

    private final void K(CancellationReason cancellationReason) {
        this.f31251f.w0(cancellationReason);
        this.f31253h.z0(Q(cancellationReason.a()), cancellationReason);
        this.f31256k.b();
    }

    private final void M(OrderHandle orderHandle, CancellationReason cancellationReason) {
        Disposable disposable = this.f31258m;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Single d8 = SingleExtKt.d(this.f31254i.h(orderHandle, cancellationReason));
        final Function1<RejectOrderResponse, Unit> function1 = new Function1<RejectOrderResponse, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.cancel.TripCancellationViewModel$cancelScheduledOrder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(RejectOrderResponse it) {
                TripCancellationViewModel tripCancellationViewModel = TripCancellationViewModel.this;
                Intrinsics.e(it, "it");
                tripCancellationViewModel.R(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RejectOrderResponse rejectOrderResponse) {
                b(rejectOrderResponse);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.cancel.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TripCancellationViewModel.N(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.cancel.TripCancellationViewModel$cancelScheduledOrder$2
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
                TripCancellationViewModel tripCancellationViewModel = TripCancellationViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(tripCancellationViewModel, it, null, 2, null);
            }
        };
        this.f31258m = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.cancel.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TripCancellationViewModel.O(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R(RejectOrderResponse rejectOrderResponse) {
        int i8 = WhenMappings.f31261a[rejectOrderResponse.c().ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                MutableLiveData<TripCancellationState> mutableLiveData = this.f31259n;
                Object b8 = LiveDataExtKt.b(mutableLiveData);
                Intrinsics.e(b8, "screenStateLiveData.requireValue()");
                mutableLiveData.o(TripCancellationState.b((TripCancellationState) b8, null, null, false, null, null, rejectOrderResponse.c(), null, 95, null));
                return;
            }
            return;
        }
        String a8 = rejectOrderResponse.a();
        if (a8 != null) {
            this.f31260o.o(this.f31255j.a(a8));
        }
        MutableLiveData<TripCancellationState> mutableLiveData2 = this.f31259n;
        Object b9 = LiveDataExtKt.b(mutableLiveData2);
        Intrinsics.e(b9, "screenStateLiveData.requireValue()");
        mutableLiveData2.o(TripCancellationState.b((TripCancellationState) b9, null, rejectOrderResponse.b(), false, null, null, rejectOrderResponse.c(), null, 93, null));
    }

    private final boolean U(OrderState orderState, String str) {
        if (orderState != OrderState.ORDER_STATE_DRIVER_ARRIVED_TO_CLIENT) {
            return false;
        }
        return Intrinsics.a(str, "client_did_not_answer_phone");
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
    public final void Y(ActiveOrderDetails activeOrderDetails, String str, String str2) {
        boolean z7;
        if (!J(activeOrderDetails, str)) {
            b0(new WhyCancelError.CantCancel(activeOrderDetails.i().B()));
            return;
        }
        if (Q(str)) {
            if (str2.length() == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                b0(WhyCancelError.EmptyNotAllowed.f31276a);
                return;
            }
        }
        K(new CancellationReason(str, str2));
    }

    private final void b0(WhyCancelError whyCancelError) {
        MutableLiveData<TripCancellationState> mutableLiveData = this.f31259n;
        Object b8 = LiveDataExtKt.b(mutableLiveData);
        Intrinsics.e(b8, "screenStateLiveData.requireValue()");
        mutableLiveData.o(TripCancellationState.b((TripCancellationState) b8, null, null, false, null, whyCancelError, null, null, 111, null));
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
    }

    public final void L(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        TripCancellationState state = (TripCancellationState) LiveDataExtKt.b(this.f31259n);
        if (Intrinsics.a(state.g(), orderHandle)) {
            return;
        }
        MutableLiveData<TripCancellationState> mutableLiveData = this.f31259n;
        Intrinsics.e(state, "state");
        mutableLiveData.o(TripCancellationState.b(state, orderHandle, null, false, null, null, null, null, 126, null));
        M(orderHandle, null);
    }

    public final void P(List<RejectReason> reasonList) {
        Intrinsics.f(reasonList, "reasonList");
        MutableLiveData<TripCancellationState> mutableLiveData = this.f31259n;
        Object b8 = LiveDataExtKt.b(mutableLiveData);
        Intrinsics.e(b8, "screenStateLiveData.requireValue()");
        mutableLiveData.o(TripCancellationState.b((TripCancellationState) b8, null, reasonList, false, null, null, null, null, 125, null));
    }

    public final boolean Q(String str) {
        if (!Intrinsics.a(str, "do_not_wish_to_serve_this_client") && !Intrinsics.a(str, "other")) {
            return false;
        }
        return true;
    }

    public final LiveEvent<CharSequence> S() {
        return this.f31260o;
    }

    public final MutableLiveData<TripCancellationState> T() {
        return this.f31259n;
    }

    public final void V() {
        final String i8 = ((TripCancellationState) LiveDataExtKt.b(this.f31259n)).i();
        final String d8 = ((TripCancellationState) LiveDataExtKt.b(this.f31259n)).d();
        OrderHandle g8 = ((TripCancellationState) LiveDataExtKt.b(this.f31259n)).g();
        if (i8 == null) {
            return;
        }
        if (g8 != null) {
            M(g8, new CancellationReason(i8, d8));
            return;
        }
        Single d9 = SingleExtKt.d(OrderProviderUtils.p(this.f31252g, OrderState.ORDER_STATE_WAITING_DRIVER_CONFIRMATION, OrderState.ORDER_STATE_DRIVER_ACCEPTED, OrderState.ORDER_STATE_DRIVER_ARRIVED_TO_CLIENT));
        final Function1<ActiveOrderDetails, Unit> function1 = new Function1<ActiveOrderDetails, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.cancel.TripCancellationViewModel$submitCancellationReason$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(ActiveOrderDetails order) {
                TripCancellationViewModel tripCancellationViewModel = TripCancellationViewModel.this;
                Intrinsics.e(order, "order");
                tripCancellationViewModel.Y(order, i8, d8);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ActiveOrderDetails activeOrderDetails) {
                b(activeOrderDetails);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.cancel.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TripCancellationViewModel.W(Function1.this, obj);
            }
        };
        final TripCancellationViewModel$submitCancellationReason$2 tripCancellationViewModel$submitCancellationReason$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.cancel.TripCancellationViewModel$submitCancellationReason$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to submit cancellation reason!");
            }
        };
        this.f31257l = d9.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.cancel.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TripCancellationViewModel.X(Function1.this, obj);
            }
        });
    }

    public final void Z() {
        this.f31253h.I3(false);
    }

    public final void a0(String str) {
        if (!(!Intrinsics.a(str, ((TripCancellationState) LiveDataExtKt.b(this.f31259n)).i()))) {
            str = null;
        }
        boolean Q = Q(str);
        MutableLiveData<TripCancellationState> mutableLiveData = this.f31259n;
        TripCancellationState tripCancellationState = (TripCancellationState) LiveDataExtKt.b(mutableLiveData);
        Intrinsics.e(tripCancellationState, "requireValue()");
        mutableLiveData.o(TripCancellationState.b(tripCancellationState, null, null, Q, "", null, null, str, 51, null));
        if (!Q && str != null) {
            V();
        }
    }

    public final void c0(String text) {
        Intrinsics.f(text, "text");
        if (Intrinsics.a(((TripCancellationState) LiveDataExtKt.b(this.f31259n)).d(), text)) {
            return;
        }
        MutableLiveData<TripCancellationState> mutableLiveData = this.f31259n;
        Object b8 = LiveDataExtKt.b(mutableLiveData);
        Intrinsics.e(b8, "screenStateLiveData.requireValue()");
        mutableLiveData.o(TripCancellationState.b((TripCancellationState) b8, null, null, false, text, WhyCancelError.None.f31277a, null, null, 103, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f31257l;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Disposable disposable2 = this.f31258m;
        if (disposable2 != null) {
            DisposableExtKt.a(disposable2);
        }
    }
}
