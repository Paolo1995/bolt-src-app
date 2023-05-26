package ee.mtakso.driver.ui.screens.shared;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import ee.mtakso.driver.service.analytics.event.facade.ReferralCampaignsAnalytics;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class InviteDriversActivity_MembersInjector implements MembersInjector<InviteDriversActivity> {
    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.shared.InviteDriversActivity.referralCampaignsAnalytics")
    public static void a(InviteDriversActivity inviteDriversActivity, ReferralCampaignsAnalytics referralCampaignsAnalytics) {
        inviteDriversActivity.f33316j = referralCampaignsAnalytics;
    }
}
