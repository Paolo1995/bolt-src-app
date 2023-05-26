package ee.mtakso.driver.ui.screens.order.scheduled;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.order.ScheduledRideDetails;
import ee.mtakso.driver.network.client.order.modal.ModalWithList;
import ee.mtakso.driver.service.order.ScheduledOrderManager;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.interactor.order.scheduled.GetUpcomingOrderDetailsInteractor;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScheduledOrderDetailsViewModel.kt */
/* loaded from: classes3.dex */
public final class ScheduledOrderDetailsViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final GetUpcomingOrderDetailsInteractor f31711f;

    /* renamed from: g  reason: collision with root package name */
    private final ScheduledOrderManager f31712g;

    /* renamed from: h  reason: collision with root package name */
    private final ScheduledOrderDetailsStateFactory f31713h;

    /* renamed from: i  reason: collision with root package name */
    private Disposable f31714i;

    /* renamed from: j  reason: collision with root package name */
    private Disposable f31715j;

    /* renamed from: k  reason: collision with root package name */
    private final MutableLiveData<ScheduledOrderDetailsState> f31716k;

    /* renamed from: l  reason: collision with root package name */
    private final LiveEvent<ModalWithList> f31717l;

    @Inject
    public ScheduledOrderDetailsViewModel(GetUpcomingOrderDetailsInteractor getUpcomingOrderDetailsInteractor, ScheduledOrderManager scheduledOrderManager, ScheduledOrderDetailsStateFactory stateFactory) {
        Intrinsics.f(getUpcomingOrderDetailsInteractor, "getUpcomingOrderDetailsInteractor");
        Intrinsics.f(scheduledOrderManager, "scheduledOrderManager");
        Intrinsics.f(stateFactory, "stateFactory");
        this.f31711f = getUpcomingOrderDetailsInteractor;
        this.f31712g = scheduledOrderManager;
        this.f31713h = stateFactory;
        this.f31716k = new MutableLiveData<>();
        this.f31717l = new LiveEvent<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
    }

    public final void H(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        Disposable disposable = this.f31715j;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Single l8 = l(SingleExtKt.d(this.f31712g.d(orderHandle)));
        final Function1<ModalWithList, Unit> function1 = new Function1<ModalWithList, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderDetailsViewModel$acceptOrder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ModalWithList modalWithList) {
                LiveEvent liveEvent;
                liveEvent = ScheduledOrderDetailsViewModel.this.f31717l;
                liveEvent.o(modalWithList);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModalWithList modalWithList) {
                b(modalWithList);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ScheduledOrderDetailsViewModel.I(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderDetailsViewModel$acceptOrder$2
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
                ScheduledOrderDetailsViewModel scheduledOrderDetailsViewModel = ScheduledOrderDetailsViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(scheduledOrderDetailsViewModel, it, null, 2, null);
            }
        };
        this.f31715j = l8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ScheduledOrderDetailsViewModel.J(Function1.this, obj);
            }
        });
    }

    public final void N(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        Disposable disposable = this.f31714i;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Observable k8 = k(ObservableExtKt.g(this.f31711f.c(orderHandle)));
        final Function1<ScheduledRideDetails, Unit> function1 = new Function1<ScheduledRideDetails, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderDetailsViewModel$loadOrder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ScheduledRideDetails details) {
                MutableLiveData mutableLiveData;
                ScheduledOrderDetailsStateFactory scheduledOrderDetailsStateFactory;
                mutableLiveData = ScheduledOrderDetailsViewModel.this.f31716k;
                scheduledOrderDetailsStateFactory = ScheduledOrderDetailsViewModel.this.f31713h;
                Intrinsics.e(details, "details");
                mutableLiveData.o(scheduledOrderDetailsStateFactory.a(details));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ScheduledRideDetails scheduledRideDetails) {
                b(scheduledRideDetails);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ScheduledOrderDetailsViewModel.O(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderDetailsViewModel$loadOrder$2
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
                ScheduledOrderDetailsViewModel scheduledOrderDetailsViewModel = ScheduledOrderDetailsViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(scheduledOrderDetailsViewModel, it, null, 2, null);
            }
        };
        this.f31714i = k8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ScheduledOrderDetailsViewModel.P(Function1.this, obj);
            }
        });
    }

    public final LiveData<ModalWithList> Q() {
        return this.f31717l;
    }

    public final LiveData<ScheduledOrderDetailsState> R() {
        return this.f31716k;
    }

    public final void S(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        this.f31712g.j(orderHandle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f31714i;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Disposable disposable2 = this.f31715j;
        if (disposable2 != null) {
            DisposableExtKt.a(disposable2);
        }
    }
}
