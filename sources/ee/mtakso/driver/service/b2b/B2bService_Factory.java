package ee.mtakso.driver.service.b2b;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class B2bService_Factory implements Factory<B2bService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PollerSource> f23945a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<B2bManager> f23946b;

    public B2bService_Factory(Provider<PollerSource> provider, Provider<B2bManager> provider2) {
        this.f23945a = provider;
        this.f23946b = provider2;
    }

    public static B2bService_Factory a(Provider<PollerSource> provider, Provider<B2bManager> provider2) {
        return new B2bService_Factory(provider, provider2);
    }

    public static B2bService c(PollerSource pollerSource, B2bManager b2bManager) {
        return new B2bService(pollerSource, b2bManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public B2bService get() {
        return c(this.f23945a.get(), this.f23946b.get());
    }
}
