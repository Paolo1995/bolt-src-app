package ee.mtakso.driver.ui.screens.campaigns.v2;

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
public final class PastCampaignsFragment_Factory implements Factory<PastCampaignsFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f27348a;

    public PastCampaignsFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f27348a = provider;
    }

    public static PastCampaignsFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new PastCampaignsFragment_Factory(provider);
    }

    public static PastCampaignsFragment c(BaseUiDependencies baseUiDependencies) {
        return new PastCampaignsFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PastCampaignsFragment get() {
        return c(this.f27348a.get());
    }
}
