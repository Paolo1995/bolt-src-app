package ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.price.PriceReviewClient;
import ee.mtakso.driver.network.client.price.PriceReviewReason;
import ee.mtakso.driver.network.client.price.PriceReviewReasons;
import ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason.ChooseReviewReasonDelegate;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChoosePriceReviewViewModel.kt */
/* loaded from: classes3.dex */
public final class ChoosePriceReviewViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final OrderProvider f31106f;

    /* renamed from: g  reason: collision with root package name */
    private final PriceReviewClient f31107g;

    /* renamed from: h  reason: collision with root package name */
    private Disposable f31108h;

    /* renamed from: i  reason: collision with root package name */
    private final MutableLiveData<List<ChooseReviewReasonDelegate.Model>> f31109i;

    @Inject
    public ChoosePriceReviewViewModel(OrderProvider orderProvider, PriceReviewClient priceReviewClient) {
        Intrinsics.f(orderProvider, "orderProvider");
        Intrinsics.f(priceReviewClient, "priceReviewClient");
        this.f31106f = orderProvider;
        this.f31107g = priceReviewClient;
        this.f31109i = new MutableLiveData<>();
    }

    private final void M() {
        Single<ActiveOrderDetails> p8 = OrderProviderUtils.p(this.f31106f, OrderState.ORDER_STATE_ARRIVED_TO_DESTINATION);
        final ChoosePriceReviewViewModel$refreshScreenData$1 choosePriceReviewViewModel$refreshScreenData$1 = new Function1<ActiveOrderDetails, OrderHandle>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason.ChoosePriceReviewViewModel$refreshScreenData$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final OrderHandle invoke(ActiveOrderDetails orderDetails) {
                Intrinsics.f(orderDetails, "orderDetails");
                return orderDetails.a();
            }
        };
        Single<R> x7 = p8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                OrderHandle N;
                N = ChoosePriceReviewViewModel.N(Function1.this, obj);
                return N;
            }
        });
        final Function1<OrderHandle, SingleSource<? extends PriceReviewReasons>> function1 = new Function1<OrderHandle, SingleSource<? extends PriceReviewReasons>>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason.ChoosePriceReviewViewModel$refreshScreenData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends PriceReviewReasons> invoke(OrderHandle orderId) {
                PriceReviewClient priceReviewClient;
                Intrinsics.f(orderId, "orderId");
                priceReviewClient = ChoosePriceReviewViewModel.this.f31107g;
                return priceReviewClient.a(orderId);
            }
        };
        Single r7 = x7.r(new Function() { // from class: ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason.e
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource O;
                O = ChoosePriceReviewViewModel.O(Function1.this, obj);
                return O;
            }
        });
        final ChoosePriceReviewViewModel$refreshScreenData$3 choosePriceReviewViewModel$refreshScreenData$3 = new Function1<PriceReviewReasons, List<? extends PriceReviewReason>>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason.ChoosePriceReviewViewModel$refreshScreenData$3
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<PriceReviewReason> invoke(PriceReviewReasons reasons) {
                Intrinsics.f(reasons, "reasons");
                return reasons.a();
            }
        };
        Single x8 = r7.x(new Function() { // from class: ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason.f
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List P;
                P = ChoosePriceReviewViewModel.P(Function1.this, obj);
                return P;
            }
        });
        final ChoosePriceReviewViewModel$refreshScreenData$4 choosePriceReviewViewModel$refreshScreenData$4 = new Function1<List<? extends PriceReviewReason>, List<? extends ChooseReviewReasonDelegate.Model>>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason.ChoosePriceReviewViewModel$refreshScreenData$4
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<ChooseReviewReasonDelegate.Model> invoke(List<PriceReviewReason> reasons) {
                int v7;
                Intrinsics.f(reasons, "reasons");
                v7 = CollectionsKt__IterablesKt.v(reasons, 10);
                ArrayList arrayList = new ArrayList(v7);
                int i8 = 0;
                for (Object obj : reasons) {
                    int i9 = i8 + 1;
                    if (i8 < 0) {
                        CollectionsKt__CollectionsKt.u();
                    }
                    PriceReviewReason priceReviewReason = (PriceReviewReason) obj;
                    String str = "price_review_reason_" + priceReviewReason.a();
                    boolean z7 = true;
                    if (i8 >= reasons.size() - 1) {
                        z7 = false;
                    }
                    arrayList.add(new ChooseReviewReasonDelegate.Model(priceReviewReason, str, null, null, 0.0f, false, z7, false, 188, null));
                    i8 = i9;
                }
                return arrayList;
            }
        };
        Single x9 = x8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List Q;
                Q = ChoosePriceReviewViewModel.Q(Function1.this, obj);
                return Q;
            }
        });
        Intrinsics.e(x9, "private fun refreshScree….handleError(it) })\n    }");
        Single d8 = SingleExtKt.d(x9);
        final Function1<List<? extends ChooseReviewReasonDelegate.Model>, Unit> function12 = new Function1<List<? extends ChooseReviewReasonDelegate.Model>, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason.ChoosePriceReviewViewModel$refreshScreenData$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(List<ChooseReviewReasonDelegate.Model> list) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ChoosePriceReviewViewModel.this.f31109i;
                mutableLiveData.o(list);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ChooseReviewReasonDelegate.Model> list) {
                b(list);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChoosePriceReviewViewModel.R(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason.ChoosePriceReviewViewModel$refreshScreenData$6
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
                ChoosePriceReviewViewModel choosePriceReviewViewModel = ChoosePriceReviewViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(choosePriceReviewViewModel, it, null, 2, null);
            }
        };
        this.f31108h = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChoosePriceReviewViewModel.S(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OrderHandle N(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (OrderHandle) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource O(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List P(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List Q(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
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

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        M();
    }

    public final LiveData<List<ChooseReviewReasonDelegate.Model>> L() {
        return this.f31109i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.f31108h;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        super.onCleared();
    }
}
