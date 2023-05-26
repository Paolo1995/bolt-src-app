package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignV2.kt */
/* loaded from: classes3.dex */
public final class CampaignV2Details {
    @SerializedName("campaign")

    /* renamed from: a  reason: collision with root package name */
    private final DriverCampaignV2 f21617a;

    public final DriverCampaignV2 a() {
        return this.f21617a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CampaignV2Details) && Intrinsics.a(this.f21617a, ((CampaignV2Details) obj).f21617a);
    }

    public int hashCode() {
        DriverCampaignV2 driverCampaignV2 = this.f21617a;
        if (driverCampaignV2 == null) {
            return 0;
        }
        return driverCampaignV2.hashCode();
    }

    public String toString() {
        DriverCampaignV2 driverCampaignV2 = this.f21617a;
        return "CampaignV2Details(campaign=" + driverCampaignV2 + ")";
    }
}
