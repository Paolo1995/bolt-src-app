package ee.mtakso.driver.ui.screens.campaigns.v2.circlek;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import eu.bolt.driver.core.permission.PermissionManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class CircleKLoyaltyFragment_Factory implements Factory<CircleKLoyaltyFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f27383a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PermissionManager> f27384b;

    public CircleKLoyaltyFragment_Factory(Provider<BaseUiDependencies> provider, Provider<PermissionManager> provider2) {
        this.f27383a = provider;
        this.f27384b = provider2;
    }

    public static CircleKLoyaltyFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<PermissionManager> provider2) {
        return new CircleKLoyaltyFragment_Factory(provider, provider2);
    }

    public static CircleKLoyaltyFragment c(BaseUiDependencies baseUiDependencies, PermissionManager permissionManager) {
        return new CircleKLoyaltyFragment(baseUiDependencies, permissionManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CircleKLoyaltyFragment get() {
        return c(this.f27383a.get(), this.f27384b.get());
    }
}
