package ee.mtakso.driver.ui.interactor.payouts;

import ee.mtakso.driver.network.client.earnings.EarningsScreenType;
import ee.mtakso.driver.network.client.earnings.PaymentConfig;
import ee.mtakso.driver.network.client.earnings.PaymentSettingsContent;
import ee.mtakso.driver.network.client.earnings.PaymentSettingsResponse;
import ee.mtakso.driver.network.client.earnings.PayoutClient;
import ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayInfo;
import ee.mtakso.driver.utils.Optional;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayoutPayToBoltInfoInteractor.kt */
/* loaded from: classes3.dex */
public final class PayoutPayToBoltInfoInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final PayoutClient f26782a;

    @Inject
    public PayoutPayToBoltInfoInteractor(PayoutClient payoutClient) {
        Intrinsics.f(payoutClient, "payoutClient");
        this.f26782a = payoutClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PayInfo h(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (PayInfo) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PayInfo.HowTo j(boolean z7, PaymentSettingsContent paymentSettingsContent, PaymentConfig.HowTo howTo) {
        return new PayInfo.HowTo(paymentSettingsContent.b(), paymentSettingsContent.a(), paymentSettingsContent.c(), howTo.b(), z7, howTo.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PayInfo.OnlyBalance k(boolean z7, PaymentSettingsContent paymentSettingsContent) {
        return new PayInfo.OnlyBalance(paymentSettingsContent.a(), paymentSettingsContent.c(), z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PayInfo.ToBolt l(boolean z7, PaymentSettingsContent paymentSettingsContent, PaymentConfig.ToBolt toBolt) {
        return new PayInfo.ToBolt(paymentSettingsContent.b(), paymentSettingsContent.a(), paymentSettingsContent.c(), z7, toBolt.b(), toBolt.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PayInfo.Payout m(boolean z7, PaymentSettingsContent paymentSettingsContent, PaymentConfig.Payout payout) {
        return new PayInfo.Payout(paymentSettingsContent.b(), paymentSettingsContent.a(), paymentSettingsContent.c(), z7, payout.b(), payout.a());
    }

    public final Single<Optional<PayInfo>> g(EarningsScreenType earningsScreenType, boolean z7) {
        if (earningsScreenType != EarningsScreenType.BALANCE) {
            Single<Optional<PayInfo>> w7 = Single.w(Optional.a());
            Intrinsics.e(w7, "just(Optional.empty<PayInfo>())");
            return w7;
        } else if (!z7) {
            Single<Optional<PayInfo>> w8 = Single.w(Optional.a());
            Intrinsics.e(w8, "just(Optional.empty<PayInfo>())");
            return w8;
        } else {
            Single<PaymentSettingsResponse> c8 = this.f26782a.c();
            final Function1<PaymentSettingsResponse, PayInfo> function1 = new Function1<PaymentSettingsResponse, PayInfo>() { // from class: ee.mtakso.driver.ui.interactor.payouts.PayoutPayToBoltInfoInteractor$getPayToBoltInformation$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final PayInfo invoke(PaymentSettingsResponse paymentSettingsResponse) {
                    PayInfo.OnlyBalance k8;
                    PayInfo.HowTo j8;
                    PayInfo.Payout m8;
                    PayInfo.ToBolt l8;
                    Intrinsics.f(paymentSettingsResponse, "<name for destructuring parameter 0>");
                    boolean a8 = paymentSettingsResponse.a();
                    PaymentSettingsContent b8 = paymentSettingsResponse.b();
                    if (b8.e() != null) {
                        l8 = PayoutPayToBoltInfoInteractor.this.l(a8, b8, b8.e());
                        return l8;
                    } else if (b8.f() != null) {
                        m8 = PayoutPayToBoltInfoInteractor.this.m(a8, b8, b8.f());
                        return m8;
                    } else if (b8.d() != null) {
                        j8 = PayoutPayToBoltInfoInteractor.this.j(a8, b8, b8.d());
                        return j8;
                    } else {
                        k8 = PayoutPayToBoltInfoInteractor.this.k(a8, b8);
                        return k8;
                    }
                }
            };
            Single<R> x7 = c8.x(new Function() { // from class: ee.mtakso.driver.ui.interactor.payouts.c
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    PayInfo h8;
                    h8 = PayoutPayToBoltInfoInteractor.h(Function1.this, obj);
                    return h8;
                }
            });
            final PayoutPayToBoltInfoInteractor$getPayToBoltInformation$2 payoutPayToBoltInfoInteractor$getPayToBoltInformation$2 = new Function1<PayInfo, Optional<PayInfo>>() { // from class: ee.mtakso.driver.ui.interactor.payouts.PayoutPayToBoltInfoInteractor$getPayToBoltInformation$2
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final Optional<PayInfo> invoke(PayInfo it) {
                    Intrinsics.f(it, "it");
                    return Optional.f(it);
                }
            };
            Single<Optional<PayInfo>> x8 = x7.x(new Function() { // from class: ee.mtakso.driver.ui.interactor.payouts.d
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Optional i8;
                    i8 = PayoutPayToBoltInfoInteractor.i(Function1.this, obj);
                    return i8;
                }
            });
            Intrinsics.e(x8, "fun getPayToBoltInformat…{ Optional.of(it) }\n    }");
            return x8;
        }
    }
}
