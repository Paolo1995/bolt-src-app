package ee.mtakso.driver.ui.screens.campaigns.v2;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.helper.DateTimeConverter;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class ActiveCampaignsFragment_Factory implements Factory<ActiveCampaignsFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DateTimeConverter> f27230a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f27231b;

    public ActiveCampaignsFragment_Factory(Provider<DateTimeConverter> provider, Provider<BaseUiDependencies> provider2) {
        this.f27230a = provider;
        this.f27231b = provider2;
    }

    public static ActiveCampaignsFragment_Factory a(Provider<DateTimeConverter> provider, Provider<BaseUiDependencies> provider2) {
        return new ActiveCampaignsFragment_Factory(provider, provider2);
    }

    public static ActiveCampaignsFragment c(DateTimeConverter dateTimeConverter, BaseUiDependencies baseUiDependencies) {
        return new ActiveCampaignsFragment(dateTimeConverter, baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ActiveCampaignsFragment get() {
        return c(this.f27230a.get(), this.f27231b.get());
    }
}
