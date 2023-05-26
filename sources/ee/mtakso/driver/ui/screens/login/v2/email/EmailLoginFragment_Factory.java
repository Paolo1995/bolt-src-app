package ee.mtakso.driver.ui.screens.login.v2.email;

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
public final class EmailLoginFragment_Factory implements Factory<EmailLoginFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f30464a;

    public EmailLoginFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f30464a = provider;
    }

    public static EmailLoginFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new EmailLoginFragment_Factory(provider);
    }

    public static EmailLoginFragment c(BaseUiDependencies baseUiDependencies) {
        return new EmailLoginFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EmailLoginFragment get() {
        return c(this.f30464a.get());
    }
}
