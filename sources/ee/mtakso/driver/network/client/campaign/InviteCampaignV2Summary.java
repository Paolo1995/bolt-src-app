package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignV2.kt */
/* loaded from: classes3.dex */
public final class InviteCampaignV2Summary {
    @SerializedName("code")

    /* renamed from: a  reason: collision with root package name */
    private final String f21699a;
    @SerializedName("invite_share_link")

    /* renamed from: b  reason: collision with root package name */
    private final String f21700b;
    @SerializedName("invite_campaign")

    /* renamed from: c  reason: collision with root package name */
    private final InviteCampaign f21701c;
    @SerializedName("invite_campaign_summary")

    /* renamed from: d  reason: collision with root package name */
    private final DriverReferralCampaignInvitesDetails f21702d;

    public final String a() {
        return this.f21699a;
    }

    public final InviteCampaign b() {
        return this.f21701c;
    }

    public final DriverReferralCampaignInvitesDetails c() {
        return this.f21702d;
    }

    public final String d() {
        return this.f21700b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InviteCampaignV2Summary) {
            InviteCampaignV2Summary inviteCampaignV2Summary = (InviteCampaignV2Summary) obj;
            return Intrinsics.a(this.f21699a, inviteCampaignV2Summary.f21699a) && Intrinsics.a(this.f21700b, inviteCampaignV2Summary.f21700b) && Intrinsics.a(this.f21701c, inviteCampaignV2Summary.f21701c) && Intrinsics.a(this.f21702d, inviteCampaignV2Summary.f21702d);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f21699a.hashCode() * 31) + this.f21700b.hashCode()) * 31;
        InviteCampaign inviteCampaign = this.f21701c;
        int hashCode2 = (hashCode + (inviteCampaign == null ? 0 : inviteCampaign.hashCode())) * 31;
        DriverReferralCampaignInvitesDetails driverReferralCampaignInvitesDetails = this.f21702d;
        return hashCode2 + (driverReferralCampaignInvitesDetails != null ? driverReferralCampaignInvitesDetails.hashCode() : 0);
    }

    public String toString() {
        String str = this.f21699a;
        String str2 = this.f21700b;
        InviteCampaign inviteCampaign = this.f21701c;
        DriverReferralCampaignInvitesDetails driverReferralCampaignInvitesDetails = this.f21702d;
        return "InviteCampaignV2Summary(code=" + str + ", inviteShareLink=" + str2 + ", inviteCampaign=" + inviteCampaign + ", inviteCampaignSummary=" + driverReferralCampaignInvitesDetails + ")";
    }
}
