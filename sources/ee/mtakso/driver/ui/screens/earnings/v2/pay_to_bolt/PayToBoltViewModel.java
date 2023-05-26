package ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.payments.EarningsPaymentClient;
import ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltViewModel;
import ee.mtakso.driver.ui.views.webview.WebViewTracker;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayToBoltViewModel.kt */
/* loaded from: classes3.dex */
public final class PayToBoltViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final EarningsPaymentClient f28637f;

    /* renamed from: g  reason: collision with root package name */
    private final WebViewTracker f28638g;

    /* renamed from: h  reason: collision with root package name */
    private final PayoutAnalytics f28639h;

    /* renamed from: i  reason: collision with root package name */
    private final MutableLiveData<String> f28640i;

    /* renamed from: j  reason: collision with root package name */
    private Disposable f28641j;

    @Inject
    public PayToBoltViewModel(EarningsPaymentClient client, WebViewTracker webViewTracker, PayoutAnalytics payoutAnalytics) {
        Intrinsics.f(client, "client");
        Intrinsics.f(webViewTracker, "webViewTracker");
        Intrinsics.f(payoutAnalytics, "payoutAnalytics");
        this.f28637f = client;
        this.f28638g = webViewTracker;
        this.f28639h = payoutAnalytics;
        this.f28640i = new MutableLiveData<>();
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
        this.f28638g.b();
    }

    public final void F(String contentUrl) {
        Intrinsics.f(contentUrl, "contentUrl");
        this.f28640i.o(contentUrl);
        y().o(Boolean.FALSE);
    }

    public final void G(String url) {
        Intrinsics.f(url, "url");
        y().o(Boolean.TRUE);
        Single d8 = SingleExtKt.d(this.f28637f.c(url));
        final PayToBoltViewModel$fetchUrl$1 payToBoltViewModel$fetchUrl$1 = new PayToBoltViewModel$fetchUrl$1(this);
        Consumer consumer = new Consumer() { // from class: o3.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PayToBoltViewModel.H(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltViewModel$fetchUrl$2
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
            public final void invoke2(Throwable error) {
                PayToBoltViewModel payToBoltViewModel = PayToBoltViewModel.this;
                Intrinsics.e(error, "error");
                BaseViewModel.A(payToBoltViewModel, error, null, 2, null);
            }
        };
        this.f28641j = d8.I(consumer, new Consumer() { // from class: o3.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PayToBoltViewModel.I(Function1.this, obj);
            }
        });
    }

    public final WebViewTracker J() {
        return this.f28638g;
    }

    public final LiveData<String> K() {
        return this.f28640i;
    }

    public final void L() {
        this.f28639h.X2();
    }

    public final void M() {
        this.f28639h.B3();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f28641j;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f28638g.a();
    }
}
