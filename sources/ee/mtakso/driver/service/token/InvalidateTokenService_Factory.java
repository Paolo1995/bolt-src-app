package ee.mtakso.driver.service.token;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.ApiExceptionProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class InvalidateTokenService_Factory implements Factory<InvalidateTokenService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ApiExceptionProvider> f26030a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<TokenManager> f26031b;

    public InvalidateTokenService_Factory(Provider<ApiExceptionProvider> provider, Provider<TokenManager> provider2) {
        this.f26030a = provider;
        this.f26031b = provider2;
    }

    public static InvalidateTokenService_Factory a(Provider<ApiExceptionProvider> provider, Provider<TokenManager> provider2) {
        return new InvalidateTokenService_Factory(provider, provider2);
    }

    public static InvalidateTokenService c(ApiExceptionProvider apiExceptionProvider, TokenManager tokenManager) {
        return new InvalidateTokenService(apiExceptionProvider, tokenManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public InvalidateTokenService get() {
        return c(this.f26030a.get(), this.f26031b.get());
    }
}
