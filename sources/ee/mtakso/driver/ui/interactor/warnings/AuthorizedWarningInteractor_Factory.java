package ee.mtakso.driver.ui.interactor.warnings;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.connectivity.ConnectionMessageManager;
import ee.mtakso.driver.service.polling.message.PollMessageManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AuthorizedWarningInteractor_Factory implements Factory<AuthorizedWarningInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ConnectionMessageManager> f26935a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PollMessageManager> f26936b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverProvider> f26937c;

    public AuthorizedWarningInteractor_Factory(Provider<ConnectionMessageManager> provider, Provider<PollMessageManager> provider2, Provider<DriverProvider> provider3) {
        this.f26935a = provider;
        this.f26936b = provider2;
        this.f26937c = provider3;
    }

    public static AuthorizedWarningInteractor_Factory a(Provider<ConnectionMessageManager> provider, Provider<PollMessageManager> provider2, Provider<DriverProvider> provider3) {
        return new AuthorizedWarningInteractor_Factory(provider, provider2, provider3);
    }

    public static AuthorizedWarningInteractor c(ConnectionMessageManager connectionMessageManager, PollMessageManager pollMessageManager, DriverProvider driverProvider) {
        return new AuthorizedWarningInteractor(connectionMessageManager, pollMessageManager, driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AuthorizedWarningInteractor get() {
        return c(this.f26935a.get(), this.f26936b.get(), this.f26937c.get());
    }
}
