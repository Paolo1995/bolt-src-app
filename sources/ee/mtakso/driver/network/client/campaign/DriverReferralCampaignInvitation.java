package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Refferals.kt */
/* loaded from: classes3.dex */
public final class DriverReferralCampaignInvitation {
    @SerializedName("status")

    /* renamed from: a  reason: collision with root package name */
    private final DriverReferralCampaignInvitationStatus f21678a;
    @SerializedName("status_obtained_date")

    /* renamed from: b  reason: collision with root package name */
    private final long f21679b;
    @SerializedName("amount_str")

    /* renamed from: c  reason: collision with root package name */
    private final String f21680c;

    public final String a() {
        return this.f21680c;
    }

    public final DriverReferralCampaignInvitationStatus b() {
        return this.f21678a;
    }

    public final long c() {
        return this.f21679b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverReferralCampaignInvitation) {
            DriverReferralCampaignInvitation driverReferralCampaignInvitation = (DriverReferralCampaignInvitation) obj;
            return this.f21678a == driverReferralCampaignInvitation.f21678a && this.f21679b == driverReferralCampaignInvitation.f21679b && Intrinsics.a(this.f21680c, driverReferralCampaignInvitation.f21680c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f21678a.hashCode() * 31) + i0.a.a(this.f21679b)) * 31;
        String str = this.f21680c;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        DriverReferralCampaignInvitationStatus driverReferralCampaignInvitationStatus = this.f21678a;
        long j8 = this.f21679b;
        String str = this.f21680c;
        return "DriverReferralCampaignInvitation(status=" + driverReferralCampaignInvitationStatus + ", statusObtainedDateSeconds=" + j8 + ", earnAmount=" + str + ")";
    }
}
