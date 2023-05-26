package ee.mtakso.driver.ui.screens.login.v3.login;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.auth.PhoneAuthFlow;
import ee.mtakso.driver.ui.interactor.defaultcountry.DefaultCountryInteractor;
import eu.bolt.driver.core.time.SystemUptimeSource;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LoginV3ViewModel_Factory implements Factory<LoginV3ViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<LoginAnalytics> f30730a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<RoutingManager> f30731b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SystemUptimeSource> f30732c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DefaultCountryInteractor> f30733d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<PhoneAuthFlow> f30734e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<DeviceSettings> f30735f;

    public LoginV3ViewModel_Factory(Provider<LoginAnalytics> provider, Provider<RoutingManager> provider2, Provider<SystemUptimeSource> provider3, Provider<DefaultCountryInteractor> provider4, Provider<PhoneAuthFlow> provider5, Provider<DeviceSettings> provider6) {
        this.f30730a = provider;
        this.f30731b = provider2;
        this.f30732c = provider3;
        this.f30733d = provider4;
        this.f30734e = provider5;
        this.f30735f = provider6;
    }

    public static LoginV3ViewModel_Factory a(Provider<LoginAnalytics> provider, Provider<RoutingManager> provider2, Provider<SystemUptimeSource> provider3, Provider<DefaultCountryInteractor> provider4, Provider<PhoneAuthFlow> provider5, Provider<DeviceSettings> provider6) {
        return new LoginV3ViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static LoginV3ViewModel c(LoginAnalytics loginAnalytics, RoutingManager routingManager, SystemUptimeSource systemUptimeSource, DefaultCountryInteractor defaultCountryInteractor, PhoneAuthFlow phoneAuthFlow, DeviceSettings deviceSettings) {
        return new LoginV3ViewModel(loginAnalytics, routingManager, systemUptimeSource, defaultCountryInteractor, phoneAuthFlow, deviceSettings);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LoginV3ViewModel get() {
        return c(this.f30730a.get(), this.f30731b.get(), this.f30732c.get(), this.f30733d.get(), this.f30734e.get(), this.f30735f.get());
    }
}
