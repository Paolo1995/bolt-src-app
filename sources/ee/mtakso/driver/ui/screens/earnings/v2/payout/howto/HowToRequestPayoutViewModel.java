package ee.mtakso.driver.ui.screens.earnings.v2.payout.howto;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.earnings.PaymentConfig;
import ee.mtakso.driver.network.client.earnings.PaymentSettingsResponse;
import ee.mtakso.driver.network.client.earnings.PayoutClient;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.howto.HowToRequestPayoutViewModel;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HowToRequestPayoutViewModel.kt */
/* loaded from: classes3.dex */
public final class HowToRequestPayoutViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final PayoutClient f28726f;

    /* renamed from: g  reason: collision with root package name */
    private final MutableLiveData<String> f28727g;

    @Inject
    public HowToRequestPayoutViewModel(PayoutClient payoutClient) {
        Intrinsics.f(payoutClient, "payoutClient");
        this.f28726f = payoutClient;
        this.f28727g = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        Single l8 = l(SingleExtKt.d(this.f28726f.c()));
        final Function1<PaymentSettingsResponse, Unit> function1 = new Function1<PaymentSettingsResponse, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.payout.howto.HowToRequestPayoutViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(PaymentSettingsResponse paymentSettingsResponse) {
                String str;
                MutableLiveData mutableLiveData;
                PaymentConfig.HowTo d8 = paymentSettingsResponse.c().d();
                if (d8 != null) {
                    str = d8.a();
                } else {
                    str = null;
                }
                if (str != null) {
                    mutableLiveData = HowToRequestPayoutViewModel.this.f28727g;
                    mutableLiveData.o(str);
                    return;
                }
                BaseViewModel.A(HowToRequestPayoutViewModel.this, new IllegalArgumentException(), null, 2, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PaymentSettingsResponse paymentSettingsResponse) {
                b(paymentSettingsResponse);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: q3.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HowToRequestPayoutViewModel.H(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.payout.howto.HowToRequestPayoutViewModel$onStart$2
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
            public final void invoke2(Throwable throwable) {
                HowToRequestPayoutViewModel howToRequestPayoutViewModel = HowToRequestPayoutViewModel.this;
                Intrinsics.e(throwable, "throwable");
                BaseViewModel.A(howToRequestPayoutViewModel, throwable, null, 2, null);
            }
        };
        Disposable I = l8.I(consumer, new Consumer() { // from class: q3.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HowToRequestPayoutViewModel.I(Function1.this, obj);
            }
        });
        Intrinsics.e(I, "override fun onStart() {…     .autoDispose()\n    }");
        v(I);
    }

    public final LiveData<String> G() {
        return this.f28727g;
    }
}
