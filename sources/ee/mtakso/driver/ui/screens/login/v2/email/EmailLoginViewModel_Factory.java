package ee.mtakso.driver.ui.screens.login.v2.email;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.ui.interactor.driver.MagicTokenRequestInteractor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EmailLoginViewModel_Factory implements Factory<EmailLoginViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MagicTokenRequestInteractor> f30477a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<LoginAnalytics> f30478b;

    public EmailLoginViewModel_Factory(Provider<MagicTokenRequestInteractor> provider, Provider<LoginAnalytics> provider2) {
        this.f30477a = provider;
        this.f30478b = provider2;
    }

    public static EmailLoginViewModel_Factory a(Provider<MagicTokenRequestInteractor> provider, Provider<LoginAnalytics> provider2) {
        return new EmailLoginViewModel_Factory(provider, provider2);
    }

    public static EmailLoginViewModel c(MagicTokenRequestInteractor magicTokenRequestInteractor, LoginAnalytics loginAnalytics) {
        return new EmailLoginViewModel(magicTokenRequestInteractor, loginAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EmailLoginViewModel get() {
        return c(this.f30477a.get(), this.f30478b.get());
    }
}
