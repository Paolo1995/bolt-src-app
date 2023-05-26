package ee.mtakso.driver.service.token;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.utils.retry.StandardExponentialBackoffStrategy;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class TokenManager_Factory implements Factory<TokenManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DeviceSettings> f26069a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AnonymousAuthClient> f26070b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<AuthManager> f26071c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<StandardExponentialBackoffStrategy> f26072d;

    public TokenManager_Factory(Provider<DeviceSettings> provider, Provider<AnonymousAuthClient> provider2, Provider<AuthManager> provider3, Provider<StandardExponentialBackoffStrategy> provider4) {
        this.f26069a = provider;
        this.f26070b = provider2;
        this.f26071c = provider3;
        this.f26072d = provider4;
    }

    public static TokenManager_Factory a(Provider<DeviceSettings> provider, Provider<AnonymousAuthClient> provider2, Provider<AuthManager> provider3, Provider<StandardExponentialBackoffStrategy> provider4) {
        return new TokenManager_Factory(provider, provider2, provider3, provider4);
    }

    public static TokenManager c(DeviceSettings deviceSettings, AnonymousAuthClient anonymousAuthClient, AuthManager authManager, StandardExponentialBackoffStrategy standardExponentialBackoffStrategy) {
        return new TokenManager(deviceSettings, anonymousAuthClient, authManager, standardExponentialBackoffStrategy);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public TokenManager get() {
        return c(this.f26069a.get(), this.f26070b.get(), this.f26071c.get(), this.f26072d.get());
    }
}
