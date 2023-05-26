package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.ui.base.fragment.BaseFragmentParams;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AuthorisedCoreModule_ProvideBaseFragmentParamsFactory implements Factory<BaseFragmentParams> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedCoreModule f20283a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PermissionManager> f20284b;

    public AuthorisedCoreModule_ProvideBaseFragmentParamsFactory(AuthorisedCoreModule authorisedCoreModule, Provider<PermissionManager> provider) {
        this.f20283a = authorisedCoreModule;
        this.f20284b = provider;
    }

    public static AuthorisedCoreModule_ProvideBaseFragmentParamsFactory a(AuthorisedCoreModule authorisedCoreModule, Provider<PermissionManager> provider) {
        return new AuthorisedCoreModule_ProvideBaseFragmentParamsFactory(authorisedCoreModule, provider);
    }

    public static BaseFragmentParams c(AuthorisedCoreModule authorisedCoreModule, PermissionManager permissionManager) {
        return (BaseFragmentParams) Preconditions.checkNotNullFromProvides(authorisedCoreModule.a(permissionManager));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public BaseFragmentParams get() {
        return c(this.f20283a, this.f20284b.get());
    }
}
