package ee.mtakso.driver.network.client.payments;

import dagger.Lazy;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsPaymentClient.kt */
/* loaded from: classes3.dex */
public final class EarningsPaymentClient {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy<EarningsPaymentApi> f22648a;

    /* renamed from: b  reason: collision with root package name */
    private final CompositeResponseTransformer f22649b;

    @Inject
    public EarningsPaymentClient(Lazy<EarningsPaymentApi> api, CompositeResponseTransformer responseTransformer) {
        Intrinsics.f(api, "api");
        Intrinsics.f(responseTransformer, "responseTransformer");
        this.f22648a = api;
        this.f22649b = responseTransformer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (String) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (String) tmp0.invoke(obj);
    }

    public final Single<String> c(String source) {
        Intrinsics.f(source, "source");
        Single g8 = SingleExtKt.g(this.f22648a.get().a(source), this.f22649b);
        final EarningsPaymentClient$fetchPaymentUrl$1 earningsPaymentClient$fetchPaymentUrl$1 = new Function1<EarningsPayment, String>() { // from class: ee.mtakso.driver.network.client.payments.EarningsPaymentClient$fetchPaymentUrl$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final String invoke(EarningsPayment it) {
                Intrinsics.f(it, "it");
                return it.a();
            }
        };
        Single<String> x7 = g8.x(new Function() { // from class: ee.mtakso.driver.network.client.payments.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String d8;
                d8 = EarningsPaymentClient.d(Function1.this, obj);
                return d8;
            }
        });
        Intrinsics.e(x7, "api.get().fetchPaymentUr…   .map { it.paymentUrl }");
        return x7;
    }

    public final Single<String> e(String source) {
        Intrinsics.f(source, "source");
        Single g8 = SingleExtKt.g(this.f22648a.get().b(source), this.f22649b);
        final EarningsPaymentClient$getPaymentUrl$1 earningsPaymentClient$getPaymentUrl$1 = new Function1<EarningsPayment, String>() { // from class: ee.mtakso.driver.network.client.payments.EarningsPaymentClient$getPaymentUrl$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final String invoke(EarningsPayment it) {
                Intrinsics.f(it, "it");
                return it.a();
            }
        };
        Single<String> x7 = g8.x(new Function() { // from class: ee.mtakso.driver.network.client.payments.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String f8;
                f8 = EarningsPaymentClient.f(Function1.this, obj);
                return f8;
            }
        });
        Intrinsics.e(x7, "api.get().getPaymentUrl(…   .map { it.paymentUrl }");
        return x7;
    }
}
