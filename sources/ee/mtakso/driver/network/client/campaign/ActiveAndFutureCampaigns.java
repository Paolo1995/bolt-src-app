package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Campaign.kt */
/* loaded from: classes3.dex */
public final class ActiveAndFutureCampaigns {
    @SerializedName("campaigns")

    /* renamed from: a  reason: collision with root package name */
    private final List<DriverCampaign> f21571a;
    @SerializedName("this_week_bonus_full")

    /* renamed from: b  reason: collision with root package name */
    private final CampaignDisplayPrice f21572b;
    @SerializedName("has_invite_campaign")

    /* renamed from: c  reason: collision with root package name */
    private final boolean f21573c;
    @SerializedName("optin_group_summaries")

    /* renamed from: d  reason: collision with root package name */
    private final List<OptInGroupSummary> f21574d;

    public final List<DriverCampaign> a() {
        return this.f21571a;
    }

    public final boolean b() {
        return this.f21573c;
    }

    public final List<OptInGroupSummary> c() {
        return this.f21574d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ActiveAndFutureCampaigns) {
            ActiveAndFutureCampaigns activeAndFutureCampaigns = (ActiveAndFutureCampaigns) obj;
            return Intrinsics.a(this.f21571a, activeAndFutureCampaigns.f21571a) && Intrinsics.a(this.f21572b, activeAndFutureCampaigns.f21572b) && this.f21573c == activeAndFutureCampaigns.f21573c && Intrinsics.a(this.f21574d, activeAndFutureCampaigns.f21574d);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f21571a.hashCode() * 31;
        CampaignDisplayPrice campaignDisplayPrice = this.f21572b;
        int hashCode2 = (hashCode + (campaignDisplayPrice == null ? 0 : campaignDisplayPrice.hashCode())) * 31;
        boolean z7 = this.f21573c;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode2 + i8) * 31;
        List<OptInGroupSummary> list = this.f21574d;
        return i9 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        List<DriverCampaign> list = this.f21571a;
        CampaignDisplayPrice campaignDisplayPrice = this.f21572b;
        boolean z7 = this.f21573c;
        List<OptInGroupSummary> list2 = this.f21574d;
        return "ActiveAndFutureCampaigns(campaigns=" + list + ", thisWeekBonus=" + campaignDisplayPrice + ", hasInviteCampaigns=" + z7 + ", optInGroupSummaries=" + list2 + ")";
    }
}
