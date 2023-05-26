package ee.mtakso.driver.ui.screens.campaigns.v2.circlek.starter;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class CircleKLoyaltyStarterFragment_Factory implements Factory<CircleKLoyaltyStarterFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f27393a;

    public CircleKLoyaltyStarterFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f27393a = provider;
    }

    public static CircleKLoyaltyStarterFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new CircleKLoyaltyStarterFragment_Factory(provider);
    }

    public static CircleKLoyaltyStarterFragment c(BaseUiDependencies baseUiDependencies) {
        return new CircleKLoyaltyStarterFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CircleKLoyaltyStarterFragment get() {
        return c(this.f27393a.get());
    }
}
