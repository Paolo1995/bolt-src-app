package ee.mtakso.driver.utils.retry;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class StandardExponentialBackoffStrategy_Factory implements Factory<StandardExponentialBackoffStrategy> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<TrueTimeProvider> f36470a;

    public StandardExponentialBackoffStrategy_Factory(Provider<TrueTimeProvider> provider) {
        this.f36470a = provider;
    }

    public static StandardExponentialBackoffStrategy_Factory a(Provider<TrueTimeProvider> provider) {
        return new StandardExponentialBackoffStrategy_Factory(provider);
    }

    public static StandardExponentialBackoffStrategy c(TrueTimeProvider trueTimeProvider) {
        return new StandardExponentialBackoffStrategy(trueTimeProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public StandardExponentialBackoffStrategy get() {
        return c(this.f36470a.get());
    }
}
