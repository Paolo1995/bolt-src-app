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
public final class BoltClubListingFragment_Factory implements Factory<BoltClubListingFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f27133a;

    public BoltClubListingFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f27133a = provider;
    }

    public static BoltClubListingFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new BoltClubListingFragment_Factory(provider);
    }

    public static BoltClubListingFragment c(BaseUiDependencies baseUiDependencies) {
        return new BoltClubListingFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public BoltClubListingFragment get() {
        return c(this.f27133a.get());
    }
}
