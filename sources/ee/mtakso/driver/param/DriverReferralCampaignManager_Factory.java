package ee.mtakso.driver.param;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverReferralCampaignManager_Factory implements Factory<DriverReferralCampaignManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f23162a;

    public DriverReferralCampaignManager_Factory(Provider<DriverProvider> provider) {
        this.f23162a = provider;
    }

    public static DriverReferralCampaignManager_Factory a(Provider<DriverProvider> provider) {
        return new DriverReferralCampaignManager_Factory(provider);
    }

    public static DriverReferralCampaignManager c(DriverProvider driverProvider) {
        return new DriverReferralCampaignManager(driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverReferralCampaignManager get() {
        return c(this.f23162a.get());
    }
}
