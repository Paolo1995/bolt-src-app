package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.service.modules.order.v2.DynamicStopDetailsService;
import ee.mtakso.driver.service.modules.order.v2.StaticStopDetailsService;
import ee.mtakso.driver.service.modules.order.v2.StopDetailsService;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AuthorisedServicesModule_ProvideStopDetailsServiceFactory implements Factory<StopDetailsService> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedServicesModule f20363a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<StaticStopDetailsService> f20364b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DynamicStopDetailsService> f20365c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<Features> f20366d;

    public AuthorisedServicesModule_ProvideStopDetailsServiceFactory(AuthorisedServicesModule authorisedServicesModule, Provider<StaticStopDetailsService> provider, Provider<DynamicStopDetailsService> provider2, Provider<Features> provider3) {
        this.f20363a = authorisedServicesModule;
        this.f20364b = provider;
        this.f20365c = provider2;
        this.f20366d = provider3;
    }

    public static AuthorisedServicesModule_ProvideStopDetailsServiceFactory a(AuthorisedServicesModule authorisedServicesModule, Provider<StaticStopDetailsService> provider, Provider<DynamicStopDetailsService> provider2, Provider<Features> provider3) {
        return new AuthorisedServicesModule_ProvideStopDetailsServiceFactory(authorisedServicesModule, provider, provider2, provider3);
    }

    public static StopDetailsService c(AuthorisedServicesModule authorisedServicesModule, StaticStopDetailsService staticStopDetailsService, DynamicStopDetailsService dynamicStopDetailsService, Features features) {
        return (StopDetailsService) Preconditions.checkNotNullFromProvides(authorisedServicesModule.a(staticStopDetailsService, dynamicStopDetailsService, features));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public StopDetailsService get() {
        return c(this.f20363a, this.f20364b.get(), this.f20365c.get(), this.f20366d.get());
    }
}
