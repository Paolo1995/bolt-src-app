package ee.mtakso.driver.ui.interactor.call;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.service.voip.noanswer.NoAnswerCallCache;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class NoAnswerIncomingCallInteractor_Factory implements Factory<NoAnswerIncomingCallInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OrderProvider> f26419a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<NoAnswerCallCache> f26420b;

    public NoAnswerIncomingCallInteractor_Factory(Provider<OrderProvider> provider, Provider<NoAnswerCallCache> provider2) {
        this.f26419a = provider;
        this.f26420b = provider2;
    }

    public static NoAnswerIncomingCallInteractor_Factory a(Provider<OrderProvider> provider, Provider<NoAnswerCallCache> provider2) {
        return new NoAnswerIncomingCallInteractor_Factory(provider, provider2);
    }

    public static NoAnswerIncomingCallInteractor c(OrderProvider orderProvider, NoAnswerCallCache noAnswerCallCache) {
        return new NoAnswerIncomingCallInteractor(orderProvider, noAnswerCallCache);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public NoAnswerIncomingCallInteractor get() {
        return c(this.f26419a.get(), this.f26420b.get());
    }
}
