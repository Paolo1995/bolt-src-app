package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;

/* compiled from: Campaign.kt */
/* loaded from: classes3.dex */
public final class DriverCampaignPeriod {
    @SerializedName("start")

    /* renamed from: a  reason: collision with root package name */
    private final long f21641a;
    @SerializedName("end")

    /* renamed from: b  reason: collision with root package name */
    private final long f21642b;

    public final long a() {
        return this.f21642b;
    }

    public final long b() {
        return this.f21641a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverCampaignPeriod) {
            DriverCampaignPeriod driverCampaignPeriod = (DriverCampaignPeriod) obj;
            return this.f21641a == driverCampaignPeriod.f21641a && this.f21642b == driverCampaignPeriod.f21642b;
        }
        return false;
    }

    public int hashCode() {
        return (i0.a.a(this.f21641a) * 31) + i0.a.a(this.f21642b);
    }

    public String toString() {
        long j8 = this.f21641a;
        long j9 = this.f21642b;
        return "DriverCampaignPeriod(start=" + j8 + ", end=" + j9 + ")";
    }
}
