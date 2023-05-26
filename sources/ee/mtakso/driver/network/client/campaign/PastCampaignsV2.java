package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignV2.kt */
/* loaded from: classes3.dex */
public final class PastCampaignsV2 {
    @SerializedName("campaign_groups")

    /* renamed from: a  reason: collision with root package name */
    private final List<CampaignV2Group> f21725a;

    public final List<CampaignV2Group> a() {
        return this.f21725a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PastCampaignsV2) && Intrinsics.a(this.f21725a, ((PastCampaignsV2) obj).f21725a);
    }

    public int hashCode() {
        List<CampaignV2Group> list = this.f21725a;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        List<CampaignV2Group> list = this.f21725a;
        return "PastCampaignsV2(campaignGroups=" + list + ")";
    }
}
