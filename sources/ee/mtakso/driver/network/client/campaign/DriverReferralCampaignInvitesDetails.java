package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Refferals.kt */
/* loaded from: classes3.dex */
public final class DriverReferralCampaignInvitesDetails {
    @SerializedName("earned_amount_str")

    /* renamed from: a  reason: collision with root package name */
    private final String f21681a;
    @SerializedName("pending_amount_str")

    /* renamed from: b  reason: collision with root package name */
    private final String f21682b;
    @SerializedName("invitations")

    /* renamed from: c  reason: collision with root package name */
    private final List<DriverReferralCampaignInvitation> f21683c;

    public final List<DriverReferralCampaignInvitation> a() {
        return this.f21683c;
    }

    public final String b() {
        return this.f21681a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverReferralCampaignInvitesDetails) {
            DriverReferralCampaignInvitesDetails driverReferralCampaignInvitesDetails = (DriverReferralCampaignInvitesDetails) obj;
            return Intrinsics.a(this.f21681a, driverReferralCampaignInvitesDetails.f21681a) && Intrinsics.a(this.f21682b, driverReferralCampaignInvitesDetails.f21682b) && Intrinsics.a(this.f21683c, driverReferralCampaignInvitesDetails.f21683c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f21681a.hashCode() * 31) + this.f21682b.hashCode()) * 31) + this.f21683c.hashCode();
    }

    public String toString() {
        String str = this.f21681a;
        String str2 = this.f21682b;
        List<DriverReferralCampaignInvitation> list = this.f21683c;
        return "DriverReferralCampaignInvitesDetails(totalEarnedAmount=" + str + ", totalPendingAmount=" + str2 + ", invitations=" + list + ")";
    }
}
