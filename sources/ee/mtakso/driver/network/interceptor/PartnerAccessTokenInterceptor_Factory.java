package ee.mtakso.driver.network.interceptor;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.token.PartnerTokenManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PartnerAccessTokenInterceptor_Factory implements Factory<PartnerAccessTokenInterceptor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PartnerTokenManager> f22969a;

    public PartnerAccessTokenInterceptor_Factory(Provider<PartnerTokenManager> provider) {
        this.f22969a = provider;
    }

    public static PartnerAccessTokenInterceptor_Factory a(Provider<PartnerTokenManager> provider) {
        return new PartnerAccessTokenInterceptor_Factory(provider);
    }

    public static PartnerAccessTokenInterceptor c(PartnerTokenManager partnerTokenManager) {
        return new PartnerAccessTokenInterceptor(partnerTokenManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PartnerAccessTokenInterceptor get() {
        return c(this.f22969a.get());
    }
}
