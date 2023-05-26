package ee.mtakso.driver.ui.screens.login.v3.emailverification;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EmailVerificationFragment_Factory implements Factory<EmailVerificationFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f30665a;

    public EmailVerificationFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f30665a = provider;
    }

    public static EmailVerificationFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new EmailVerificationFragment_Factory(provider);
    }

    public static EmailVerificationFragment c(BaseUiDependencies baseUiDependencies) {
        return new EmailVerificationFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EmailVerificationFragment get() {
        return c(this.f30665a.get());
    }
}
