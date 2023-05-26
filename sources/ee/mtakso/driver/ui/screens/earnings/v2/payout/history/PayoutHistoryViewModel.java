package ee.mtakso.driver.ui.screens.earnings.v2.payout.history;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.earnings.PayoutHistoryItem;
import ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.interactor.payouts.PayoutHistoryInteractor;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.history.PayoutHistoryViewModel;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayoutHistoryViewModel.kt */
/* loaded from: classes3.dex */
public final class PayoutHistoryViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final PayoutHistoryInteractor f28711f;

    /* renamed from: g  reason: collision with root package name */
    private final PayoutAnalytics f28712g;

    /* renamed from: h  reason: collision with root package name */
    private Disposable f28713h;

    /* renamed from: i  reason: collision with root package name */
    private final MutableLiveData<ScreenState> f28714i;

    /* compiled from: PayoutHistoryViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class ScreenState {

        /* renamed from: a  reason: collision with root package name */
        private final List<PayoutHistoryItem> f28715a;

        public ScreenState(List<PayoutHistoryItem> items) {
            Intrinsics.f(items, "items");
            this.f28715a = items;
        }

        public final List<PayoutHistoryItem> a() {
            return this.f28715a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ScreenState) && Intrinsics.a(this.f28715a, ((ScreenState) obj).f28715a);
        }

        public int hashCode() {
            return this.f28715a.hashCode();
        }

        public String toString() {
            List<PayoutHistoryItem> list = this.f28715a;
            return "ScreenState(items=" + list + ")";
        }
    }

    @Inject
    public PayoutHistoryViewModel(PayoutHistoryInteractor payoutHistoryInteractor, PayoutAnalytics payoutAnalytics) {
        Intrinsics.f(payoutHistoryInteractor, "payoutHistoryInteractor");
        Intrinsics.f(payoutAnalytics, "payoutAnalytics");
        this.f28711f = payoutHistoryInteractor;
        this.f28712g = payoutAnalytics;
        this.f28714i = new MutableLiveData<>();
    }

    private final void I() {
        y().o(Boolean.TRUE);
        Single d8 = SingleExtKt.d(this.f28711f.b());
        final Function1<List<? extends PayoutHistoryItem>, Unit> function1 = new Function1<List<? extends PayoutHistoryItem>, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.payout.history.PayoutHistoryViewModel$refreshScreenData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(List<PayoutHistoryItem> items) {
                MutableLiveData mutableLiveData;
                MutableLiveData y7;
                mutableLiveData = PayoutHistoryViewModel.this.f28714i;
                Intrinsics.e(items, "items");
                mutableLiveData.o(new PayoutHistoryViewModel.ScreenState(items));
                y7 = PayoutHistoryViewModel.this.y();
                y7.o(Boolean.FALSE);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends PayoutHistoryItem> list) {
                b(list);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: p3.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PayoutHistoryViewModel.J(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.payout.history.PayoutHistoryViewModel$refreshScreenData$2
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
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to refresh screen data!");
                y7 = PayoutHistoryViewModel.this.y();
                y7.o(Boolean.FALSE);
            }
        };
        this.f28713h = d8.I(consumer, new Consumer() { // from class: p3.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PayoutHistoryViewModel.K(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        this.f28712g.E2();
        I();
    }

    public final LiveData<ScreenState> H() {
        return this.f28714i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f28713h;
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
