package ee.mtakso.driver.ui.screens.earnings.v3.payout;

import androidx.lifecycle.LiveData;
import ee.mtakso.driver.network.client.payments.EarningsPaymentClient;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.screens.earnings.v3.payout.RequestWebUrlViewModel;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestWebUrlViewModel.kt */
/* loaded from: classes3.dex */
public final class RequestWebUrlViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final EarningsPaymentClient f29418f;

    /* renamed from: g  reason: collision with root package name */
    private Disposable f29419g;

    /* renamed from: h  reason: collision with root package name */
    private final LiveEvent<String> f29420h;

    @Inject
    public RequestWebUrlViewModel(EarningsPaymentClient client) {
        Intrinsics.f(client, "client");
        this.f29418f = client;
        this.f29420h = new LiveEvent<>();
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
    }

    public final void G(String requestUrl) {
        Intrinsics.f(requestUrl, "requestUrl");
        Disposable disposable = this.f29419g;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Single l8 = l(SingleExtKt.d(this.f29418f.e(requestUrl)));
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.payout.RequestWebUrlViewModel$initWithRequestUrl$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String str) {
                LiveEvent liveEvent;
                liveEvent = RequestWebUrlViewModel.this.f29420h;
                liveEvent.o(str);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: t3.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RequestWebUrlViewModel.H(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.payout.RequestWebUrlViewModel$initWithRequestUrl$2
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
                RequestWebUrlViewModel requestWebUrlViewModel = RequestWebUrlViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(requestWebUrlViewModel, it, null, 2, null);
            }
        };
        this.f29419g = l8.I(consumer, new Consumer() { // from class: t3.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RequestWebUrlViewModel.I(Function1.this, obj);
            }
        });
    }

    public final LiveData<String> J() {
        return this.f29420h;
    }
}
