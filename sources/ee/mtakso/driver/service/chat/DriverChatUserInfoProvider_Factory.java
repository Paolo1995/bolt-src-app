package ee.mtakso.driver.service.chat;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.model.DeviceInfo;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.session.SessionProvider;
import ee.mtakso.driver.service.token.TokenManager;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverChatUserInfoProvider_Factory implements Factory<DriverChatUserInfoProvider> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f24055a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<TokenManager> f24056b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SessionProvider> f24057c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<LanguageManager> f24058d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<DeviceInfo> f24059e;

    public DriverChatUserInfoProvider_Factory(Provider<DriverProvider> provider, Provider<TokenManager> provider2, Provider<SessionProvider> provider3, Provider<LanguageManager> provider4, Provider<DeviceInfo> provider5) {
        this.f24055a = provider;
        this.f24056b = provider2;
        this.f24057c = provider3;
        this.f24058d = provider4;
        this.f24059e = provider5;
    }

    public static DriverChatUserInfoProvider_Factory a(Provider<DriverProvider> provider, Provider<TokenManager> provider2, Provider<SessionProvider> provider3, Provider<LanguageManager> provider4, Provider<DeviceInfo> provider5) {
        return new DriverChatUserInfoProvider_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static DriverChatUserInfoProvider c(DriverProvider driverProvider, TokenManager tokenManager, SessionProvider sessionProvider, LanguageManager languageManager, DeviceInfo deviceInfo) {
        return new DriverChatUserInfoProvider(driverProvider, tokenManager, sessionProvider, languageManager, deviceInfo);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverChatUserInfoProvider get() {
        return c(this.f24055a.get(), this.f24056b.get(), this.f24057c.get(), this.f24058d.get(), this.f24059e.get());
    }
}
