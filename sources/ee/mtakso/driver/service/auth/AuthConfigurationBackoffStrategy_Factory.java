package ee.mtakso.driver.service.auth;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AuthConfigurationBackoffStrategy_Factory implements Factory<AuthConfigurationBackoffStrategy> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<TrueTimeProvider> f23562a;

    public AuthConfigurationBackoffStrategy_Factory(Provider<TrueTimeProvider> provider) {
        this.f23562a = provider;
    }

    public static AuthConfigurationBackoffStrategy_Factory a(Provider<TrueTimeProvider> provider) {
        return new AuthConfigurationBackoffStrategy_Factory(provider);
    }

    public static AuthConfigurationBackoffStrategy c(TrueTimeProvider trueTimeProvider) {
        return new AuthConfigurationBackoffStrategy(trueTimeProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AuthConfigurationBackoffStrategy get() {
        return c(this.f23562a.get());
    }
}
