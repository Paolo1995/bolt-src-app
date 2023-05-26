package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.helper.DateTimeConverter;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ReferralCampaignInvitationFactory_Factory implements Factory<ReferralCampaignInvitationFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DateTimeConverter> f27539a;

    public ReferralCampaignInvitationFactory_Factory(Provider<DateTimeConverter> provider) {
        this.f27539a = provider;
    }

    public static ReferralCampaignInvitationFactory_Factory a(Provider<DateTimeConverter> provider) {
        return new ReferralCampaignInvitationFactory_Factory(provider);
    }

    public static ReferralCampaignInvitationFactory c(DateTimeConverter dateTimeConverter) {
        return new ReferralCampaignInvitationFactory(dateTimeConverter);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ReferralCampaignInvitationFactory get() {
        return c(this.f27539a.get());
    }
}
