package ee.mtakso.driver.network.interceptor;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.model.DeviceInfo;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.session.SessionProvider;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class StandardParamsInterceptors_Factory implements Factory<StandardParamsInterceptors> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DeviceInfo> f22974a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SessionProvider> f22975b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverProvider> f22976c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<LanguageManager> f22977d;

    public StandardParamsInterceptors_Factory(Provider<DeviceInfo> provider, Provider<SessionProvider> provider2, Provider<DriverProvider> provider3, Provider<LanguageManager> provider4) {
        this.f22974a = provider;
        this.f22975b = provider2;
        this.f22976c = provider3;
        this.f22977d = provider4;
    }

    public static StandardParamsInterceptors_Factory a(Provider<DeviceInfo> provider, Provider<SessionProvider> provider2, Provider<DriverProvider> provider3, Provider<LanguageManager> provider4) {
        return new StandardParamsInterceptors_Factory(provider, provider2, provider3, provider4);
    }

    public static StandardParamsInterceptors c(DeviceInfo deviceInfo, SessionProvider sessionProvider, DriverProvider driverProvider, LanguageManager languageManager) {
        return new StandardParamsInterceptors(deviceInfo, sessionProvider, driverProvider, languageManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public StandardParamsInterceptors get() {
        return c(this.f22974a.get(), this.f22975b.get(), this.f22976c.get(), this.f22977d.get());
    }
}
