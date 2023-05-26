package ee.mtakso.driver.network.client.earnings;

import dagger.Lazy;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayoutClient.kt */
/* loaded from: classes3.dex */
public final class PayoutClient {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy<PayoutApi> f22137a;

    /* renamed from: b  reason: collision with root package name */
    private final CompositeResponseTransformer f22138b;

    @Inject
    public PayoutClient(Lazy<PayoutApi> payoutApi, CompositeResponseTransformer responseTransformer) {
        Intrinsics.f(payoutApi, "payoutApi");
        Intrinsics.f(responseTransformer, "responseTransformer");
        this.f22137a = payoutApi;
        this.f22138b = responseTransformer;
    }

    public final Single<CreatePayoutResponse> a(String confirmationId) {
        Intrinsics.f(confirmationId, "confirmationId");
        return SingleExtKt.g(this.f22137a.get().f(new CreatePayoutRequest(confirmationId)), this.f22138b);
    }

    public final Single<PayToBoltLinkResponse> b() {
        return SingleExtKt.g(this.f22137a.get().d(), this.f22138b);
    }

    public final Single<PaymentSettingsResponse> c() {
        return SingleExtKt.g(this.f22137a.get().c(), this.f22138b);
    }

    public final Single<PayoutResponce> d(long j8) {
        return SingleExtKt.g(this.f22137a.get().e(j8), this.f22138b);
    }

    public final Single<PayoutHistoryResponce> e() {
        return SingleExtKt.g(this.f22137a.get().a(), this.f22138b);
    }

    public final Single<PayoutConfirmationResponce> f() {
        return SingleExtKt.g(this.f22137a.get().b(), this.f22138b);
    }
}
