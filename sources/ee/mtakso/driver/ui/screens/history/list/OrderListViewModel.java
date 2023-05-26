package ee.mtakso.driver.ui.screens.history.list;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.order.PreviousOrder;
import ee.mtakso.driver.param.RateMePrefsManager;
import ee.mtakso.driver.service.analytics.event.facade.HistoryAnalytics;
import ee.mtakso.driver.service.driver.DriverManager;
import ee.mtakso.driver.service.modules.order.v2.OrderHistoryManager;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.SingleLiveData;
import ee.mtakso.driver.utils.DisposableExtKt;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderListViewModel.kt */
/* loaded from: classes3.dex */
public final class OrderListViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final OrderHistoryManager f29598f;

    /* renamed from: g  reason: collision with root package name */
    private final RateMePrefsManager f29599g;

    /* renamed from: h  reason: collision with root package name */
    private final HistoryAnalytics f29600h;

    /* renamed from: i  reason: collision with root package name */
    private final DriverManager f29601i;

    /* renamed from: j  reason: collision with root package name */
    private final SingleLiveData<List<PreviousOrder>> f29602j;

    @Inject
    public OrderListViewModel(OrderHistoryManager orderHistoryManager, RateMePrefsManager rateMePrefsManager, HistoryAnalytics historyAnalytics, DriverManager driverManager) {
        Intrinsics.f(orderHistoryManager, "orderHistoryManager");
        Intrinsics.f(rateMePrefsManager, "rateMePrefsManager");
        Intrinsics.f(historyAnalytics, "historyAnalytics");
        Intrinsics.f(driverManager, "driverManager");
        this.f29598f = orderHistoryManager;
        this.f29599g = rateMePrefsManager;
        this.f29600h = historyAnalytics;
        this.f29601i = driverManager;
        this.f29602j = new SingleLiveData<>();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        this.f29602j.t(l(this.f29598f.c()), new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.history.list.OrderListViewModel$onStart$1
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
                Intrinsics.f(it, "it");
                BaseViewModel.A(OrderListViewModel.this, it, null, 2, null);
            }
        });
    }

    public final SingleLiveData<List<PreviousOrder>> D() {
        return this.f29602j;
    }

    public final boolean E() {
        return this.f29601i.s();
    }

    public final void F() {
        this.f29599g.a();
    }

    public final boolean G() {
        return this.f29599g.k();
    }

    public final void H() {
        this.f29600h.E0();
    }

    public final void I(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        this.f29600h.l4(orderHandle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        DisposableExtKt.a(this.f29602j);
    }
}
