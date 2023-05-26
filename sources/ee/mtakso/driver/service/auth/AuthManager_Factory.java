package ee.mtakso.driver.service.auth;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.identity.verification.IdentityVerificationManager;
import ee.mtakso.driver.network.client.auth.authenticated.AuthenticatedAuthClient;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.time.AnchoredTrueTimeProvider;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AuthManager_Factory implements Factory<AuthManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f23585a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverProvider> f23586b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Features> f23587c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DeviceSettings> f23588d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<AnchoredTrueTimeProvider> f23589e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<DriverClient> f23590f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<LanguageManager> f23591g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<IdentityVerificationManager> f23592h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<AuthenticatedAuthClient> f23593i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<LoginAnalytics> f23594j;

    public AuthManager_Factory(Provider<Context> provider, Provider<DriverProvider> provider2, Provider<Features> provider3, Provider<DeviceSettings> provider4, Provider<AnchoredTrueTimeProvider> provider5, Provider<DriverClient> provider6, Provider<LanguageManager> provider7, Provider<IdentityVerificationManager> provider8, Provider<AuthenticatedAuthClient> provider9, Provider<LoginAnalytics> provider10) {
        this.f23585a = provider;
        this.f23586b = provider2;
        this.f23587c = provider3;
        this.f23588d = provider4;
        this.f23589e = provider5;
        this.f23590f = provider6;
        this.f23591g = provider7;
        this.f23592h = provider8;
        this.f23593i = provider9;
        this.f23594j = provider10;
    }

    public static AuthManager_Factory a(Provider<Context> provider, Provider<DriverProvider> provider2, Provider<Features> provider3, Provider<DeviceSettings> provider4, Provider<AnchoredTrueTimeProvider> provider5, Provider<DriverClient> provider6, Provider<LanguageManager> provider7, Provider<IdentityVerificationManager> provider8, Provider<AuthenticatedAuthClient> provider9, Provider<LoginAnalytics> provider10) {
        return new AuthManager_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static AuthManager c(Context context, DriverProvider driverProvider, Features features, DeviceSettings deviceSettings, AnchoredTrueTimeProvider anchoredTrueTimeProvider, DriverClient driverClient, LanguageManager languageManager, IdentityVerificationManager identityVerificationManager, AuthenticatedAuthClient authenticatedAuthClient, LoginAnalytics loginAnalytics) {
        return new AuthManager(context, driverProvider, features, deviceSettings, anchoredTrueTimeProvider, driverClient, languageManager, identityVerificationManager, authenticatedAuthClient, loginAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AuthManager get() {
        return c(this.f23585a.get(), this.f23586b.get(), this.f23587c.get(), this.f23588d.get(), this.f23589e.get(), this.f23590f.get(), this.f23591g.get(), this.f23592h.get(), this.f23593i.get(), this.f23594j.get());
    }
}
