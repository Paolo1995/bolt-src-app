package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.emergencyassist.EmergencyAssistApi;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorized"})
/* loaded from: classes3.dex */
public final class AuthorisedNetworkModule_ProvideEmergencyAssistApiFactory implements Factory<EmergencyAssistApi> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedNetworkModule f20312a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OkHttpClient> f20313b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiFactory> f20314c;

    public AuthorisedNetworkModule_ProvideEmergencyAssistApiFactory(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        this.f20312a = authorisedNetworkModule;
        this.f20313b = provider;
        this.f20314c = provider2;
    }

    public static AuthorisedNetworkModule_ProvideEmergencyAssistApiFactory a(AuthorisedNetworkModule authorisedNetworkModule, Provider<OkHttpClient> provider, Provider<ApiFactory> provider2) {
        return new AuthorisedNetworkModule_ProvideEmergencyAssistApiFactory(authorisedNetworkModule, provider, provider2);
    }

    public static EmergencyAssistApi c(AuthorisedNetworkModule authorisedNetworkModule, OkHttpClient okHttpClient, ApiFactory apiFactory) {
        return (EmergencyAssistApi) Preconditions.checkNotNullFromProvides(authorisedNetworkModule.h(okHttpClient, apiFactory));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EmergencyAssistApi get() {
        return c(this.f20312a, this.f20313b.get(), this.f20314c.get());
    }
}
