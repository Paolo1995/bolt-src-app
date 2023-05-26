package ee.mtakso.driver.network.interceptor;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.token.TokenManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AccessTokenInterceptor_Factory implements Factory<AccessTokenInterceptor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<TokenManager> f22939a;

    public AccessTokenInterceptor_Factory(Provider<TokenManager> provider) {
        this.f22939a = provider;
    }

    public static AccessTokenInterceptor_Factory a(Provider<TokenManager> provider) {
        return new AccessTokenInterceptor_Factory(provider);
    }

    public static AccessTokenInterceptor c(TokenManager tokenManager) {
        return new AccessTokenInterceptor(tokenManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AccessTokenInterceptor get() {
        return c(this.f22939a.get());
    }
}
