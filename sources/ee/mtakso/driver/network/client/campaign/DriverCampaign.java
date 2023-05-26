package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.Coordinates;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: Campaign.kt */
/* loaded from: classes3.dex */
public final class DriverCampaign {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final long f21631a;
    @SerializedName("title")

    /* renamed from: b  reason: collision with root package name */
    private final String f21632b;
    @SerializedName("description")

    /* renamed from: c  reason: collision with root package name */
    private final String f21633c;
    @SerializedName("badges")

    /* renamed from: d  reason: collision with root package name */
    private final List<DriverCampaignBadge> f21634d;
    @SerializedName("period")

    /* renamed from: e  reason: collision with root package name */
    private final DriverCampaignPeriod f21635e;
    @SerializedName("short_bonus_summary")

    /* renamed from: f  reason: collision with root package name */
    private final String f21636f;
    @SerializedName("footnote")

    /* renamed from: g  reason: collision with root package name */
    private final String f21637g;
    @SerializedName("status")

    /* renamed from: h  reason: collision with root package name */
    private final DriverCampaignStatusDetail f21638h;
    @SerializedName("conditions")

    /* renamed from: i  reason: collision with root package name */
    private final List<DriverCampaignCondition> f21639i;
    @SerializedName("polygon")

    /* renamed from: j  reason: collision with root package name */
    private final List<Coordinates> f21640j;

    public final List<DriverCampaignBadge> a() {
        return this.f21634d;
    }

    public final List<DriverCampaignCondition> b() {
        return this.f21639i;
    }

    public final long c() {
        return this.f21631a;
    }

    public final DriverCampaignPeriod d() {
        return this.f21635e;
    }

    public final List<Coordinates> e() {
        return this.f21640j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverCampaign) {
            DriverCampaign driverCampaign = (DriverCampaign) obj;
            return this.f21631a == driverCampaign.f21631a && Intrinsics.a(this.f21632b, driverCampaign.f21632b) && Intrinsics.a(this.f21633c, driverCampaign.f21633c) && Intrinsics.a(this.f21634d, driverCampaign.f21634d) && Intrinsics.a(this.f21635e, driverCampaign.f21635e) && Intrinsics.a(this.f21636f, driverCampaign.f21636f) && Intrinsics.a(this.f21637g, driverCampaign.f21637g) && Intrinsics.a(this.f21638h, driverCampaign.f21638h) && Intrinsics.a(this.f21639i, driverCampaign.f21639i) && Intrinsics.a(this.f21640j, driverCampaign.f21640j);
        }
        return false;
    }

    public final DriverCampaignStatusDetail f() {
        return this.f21638h;
    }

    public final String g() {
        return this.f21632b;
    }

    public int hashCode() {
        int a8 = ((((((((((i0.a.a(this.f21631a) * 31) + this.f21632b.hashCode()) * 31) + this.f21633c.hashCode()) * 31) + this.f21634d.hashCode()) * 31) + this.f21635e.hashCode()) * 31) + this.f21636f.hashCode()) * 31;
        String str = this.f21637g;
        int hashCode = (((((a8 + (str == null ? 0 : str.hashCode())) * 31) + this.f21638h.hashCode()) * 31) + this.f21639i.hashCode()) * 31;
        List<Coordinates> list = this.f21640j;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        long j8 = this.f21631a;
        String str = this.f21632b;
        String str2 = this.f21633c;
        List<DriverCampaignBadge> list = this.f21634d;
        DriverCampaignPeriod driverCampaignPeriod = this.f21635e;
        String str3 = this.f21636f;
        String str4 = this.f21637g;
        DriverCampaignStatusDetail driverCampaignStatusDetail = this.f21638h;
        List<DriverCampaignCondition> list2 = this.f21639i;
        List<Coordinates> list3 = this.f21640j;
        return "DriverCampaign(id=" + j8 + ", title=" + str + ", description=" + str2 + ", badges=" + list + ", period=" + driverCampaignPeriod + ", shortBonusSummary=" + str3 + ", footnote=" + str4 + ", status=" + driverCampaignStatusDetail + ", conditions=" + list2 + ", polygon=" + list3 + ")";
    }
}
