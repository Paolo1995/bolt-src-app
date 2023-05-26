package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import ee.mtakso.driver.network.client.campaign.DriverCampaignV2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignDetailsState.kt */
/* loaded from: classes3.dex */
public final class CampaignDetailsState {

    /* renamed from: a  reason: collision with root package name */
    private final DriverCampaignV2 f27453a;

    public CampaignDetailsState(DriverCampaignV2 campaign) {
        Intrinsics.f(campaign, "campaign");
        this.f27453a = campaign;
    }

    public final DriverCampaignV2 a() {
        return this.f27453a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CampaignDetailsState) && Intrinsics.a(this.f27453a, ((CampaignDetailsState) obj).f27453a);
    }

    public int hashCode() {
        return this.f27453a.hashCode();
    }

    public String toString() {
        DriverCampaignV2 driverCampaignV2 = this.f27453a;
        return "CampaignDetailsState(campaign=" + driverCampaignV2 + ")";
    }
}
