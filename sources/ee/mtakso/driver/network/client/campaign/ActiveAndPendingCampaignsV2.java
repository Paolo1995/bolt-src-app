package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignV2.kt */
/* loaded from: classes3.dex */
public final class ActiveAndPendingCampaignsV2 {
    @SerializedName("campaign_groups")

    /* renamed from: a  reason: collision with root package name */
    private final List<CampaignV2Group> f21582a;
    @SerializedName("this_week_bonus")

    /* renamed from: b  reason: collision with root package name */
    private final CampaignDisplayPrice f21583b;
    @SerializedName("has_invite_campaign")

    /* renamed from: c  reason: collision with root package name */
    private final boolean f21584c;
    @SerializedName("optin_groups")

    /* renamed from: d  reason: collision with root package name */
    private final List<OptInGroupSummary> f21585d;

    public final List<CampaignV2Group> a() {
        return this.f21582a;
    }

    public final boolean b() {
        return this.f21584c;
    }

    public final List<OptInGroupSummary> c() {
        return this.f21585d;
    }

    public final CampaignDisplayPrice d() {
        return this.f21583b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ActiveAndPendingCampaignsV2) {
            ActiveAndPendingCampaignsV2 activeAndPendingCampaignsV2 = (ActiveAndPendingCampaignsV2) obj;
            return Intrinsics.a(this.f21582a, activeAndPendingCampaignsV2.f21582a) && Intrinsics.a(this.f21583b, activeAndPendingCampaignsV2.f21583b) && this.f21584c == activeAndPendingCampaignsV2.f21584c && Intrinsics.a(this.f21585d, activeAndPendingCampaignsV2.f21585d);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<CampaignV2Group> list = this.f21582a;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        CampaignDisplayPrice campaignDisplayPrice = this.f21583b;
        int hashCode2 = (hashCode + (campaignDisplayPrice == null ? 0 : campaignDisplayPrice.hashCode())) * 31;
        boolean z7 = this.f21584c;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode2 + i8) * 31;
        List<OptInGroupSummary> list2 = this.f21585d;
        return i9 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        List<CampaignV2Group> list = this.f21582a;
        CampaignDisplayPrice campaignDisplayPrice = this.f21583b;
        boolean z7 = this.f21584c;
        List<OptInGroupSummary> list2 = this.f21585d;
        return "ActiveAndPendingCampaignsV2(campaignGroups=" + list + ", thisWeekBonus=" + campaignDisplayPrice + ", hasInviteCampaigns=" + z7 + ", optInGroupSummaries=" + list2 + ")";
    }
}
