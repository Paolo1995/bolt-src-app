package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: CampaignV2.kt */
/* loaded from: classes3.dex */
public final class CampaignV2Group {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final long f21618a;
    @SerializedName("name")

    /* renamed from: b  reason: collision with root package name */
    private final String f21619b;
    @SerializedName("campaigns")

    /* renamed from: c  reason: collision with root package name */
    private final List<DriverCampaignV2> f21620c;

    public CampaignV2Group(long j8, String name, List<DriverCampaignV2> campaigns) {
        Intrinsics.f(name, "name");
        Intrinsics.f(campaigns, "campaigns");
        this.f21618a = j8;
        this.f21619b = name;
        this.f21620c = campaigns;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CampaignV2Group b(CampaignV2Group campaignV2Group, long j8, String str, List list, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            j8 = campaignV2Group.f21618a;
        }
        if ((i8 & 2) != 0) {
            str = campaignV2Group.f21619b;
        }
        if ((i8 & 4) != 0) {
            list = campaignV2Group.f21620c;
        }
        return campaignV2Group.a(j8, str, list);
    }

    public final CampaignV2Group a(long j8, String name, List<DriverCampaignV2> campaigns) {
        Intrinsics.f(name, "name");
        Intrinsics.f(campaigns, "campaigns");
        return new CampaignV2Group(j8, name, campaigns);
    }

    public final List<DriverCampaignV2> c() {
        return this.f21620c;
    }

    public final long d() {
        return this.f21618a;
    }

    public final String e() {
        return this.f21619b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CampaignV2Group) {
            CampaignV2Group campaignV2Group = (CampaignV2Group) obj;
            return this.f21618a == campaignV2Group.f21618a && Intrinsics.a(this.f21619b, campaignV2Group.f21619b) && Intrinsics.a(this.f21620c, campaignV2Group.f21620c);
        }
        return false;
    }

    public int hashCode() {
        return (((i0.a.a(this.f21618a) * 31) + this.f21619b.hashCode()) * 31) + this.f21620c.hashCode();
    }

    public String toString() {
        long j8 = this.f21618a;
        String str = this.f21619b;
        List<DriverCampaignV2> list = this.f21620c;
        return "CampaignV2Group(id=" + j8 + ", name=" + str + ", campaigns=" + list + ")";
    }
}
