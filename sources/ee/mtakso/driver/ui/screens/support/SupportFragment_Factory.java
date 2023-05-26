package ee.mtakso.driver.ui.screens.support;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import eu.bolt.driver.core.permission.PermissionManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes5.dex */
public final class SupportFragment_Factory implements Factory<SupportFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f33455a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PermissionManager> f33456b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<CompositeUrlLauncher> f33457c;

    public SupportFragment_Factory(Provider<BaseUiDependencies> provider, Provider<PermissionManager> provider2, Provider<CompositeUrlLauncher> provider3) {
        this.f33455a = provider;
        this.f33456b = provider2;
        this.f33457c = provider3;
    }

    public static SupportFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<PermissionManager> provider2, Provider<CompositeUrlLauncher> provider3) {
        return new SupportFragment_Factory(provider, provider2, provider3);
    }

    public static SupportFragment c(BaseUiDependencies baseUiDependencies, PermissionManager permissionManager, CompositeUrlLauncher compositeUrlLauncher) {
        return new SupportFragment(baseUiDependencies, permissionManager, compositeUrlLauncher);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SupportFragment get() {
        return c(this.f33455a.get(), this.f33456b.get(), this.f33457c.get());
    }
}
