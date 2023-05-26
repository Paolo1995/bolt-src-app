package ee.mtakso.driver.ui.screens.boltclub;

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
public final class BoltClubOfferDetailsFragment_Factory implements Factory<BoltClubOfferDetailsFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f27143a;

    public BoltClubOfferDetailsFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f27143a = provider;
    }

    public static BoltClubOfferDetailsFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new BoltClubOfferDetailsFragment_Factory(provider);
    }

    public static BoltClubOfferDetailsFragment c(BaseUiDependencies baseUiDependencies) {
        return new BoltClubOfferDetailsFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public BoltClubOfferDetailsFragment get() {
        return c(this.f27143a.get());
    }
}
