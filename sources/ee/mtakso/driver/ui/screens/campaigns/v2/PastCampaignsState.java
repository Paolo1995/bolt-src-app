package ee.mtakso.driver.ui.screens.campaigns.v2;

import ee.mtakso.driver.network.client.campaign.CampaignV2Group;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PastCampaignsState.kt */
/* loaded from: classes3.dex */
public final class PastCampaignsState {

    /* renamed from: a  reason: collision with root package name */
    private final PastCampaignsFilter f27349a;

    /* renamed from: b  reason: collision with root package name */
    private final List<CampaignV2Group> f27350b;

    /* renamed from: c  reason: collision with root package name */
    private final List<ListModel> f27351c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f27352d;

    /* JADX WARN: Multi-variable type inference failed */
    public PastCampaignsState(PastCampaignsFilter filter, List<CampaignV2Group> source, List<? extends ListModel> campaigns, boolean z7) {
        Intrinsics.f(filter, "filter");
        Intrinsics.f(source, "source");
        Intrinsics.f(campaigns, "campaigns");
        this.f27349a = filter;
        this.f27350b = source;
        this.f27351c = campaigns;
        this.f27352d = z7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PastCampaignsState b(PastCampaignsState pastCampaignsState, PastCampaignsFilter pastCampaignsFilter, List list, List list2, boolean z7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            pastCampaignsFilter = pastCampaignsState.f27349a;
        }
        if ((i8 & 2) != 0) {
            list = pastCampaignsState.f27350b;
        }
        if ((i8 & 4) != 0) {
            list2 = pastCampaignsState.f27351c;
        }
        if ((i8 & 8) != 0) {
            z7 = pastCampaignsState.f27352d;
        }
        return pastCampaignsState.a(pastCampaignsFilter, list, list2, z7);
    }

    public final PastCampaignsState a(PastCampaignsFilter filter, List<CampaignV2Group> source, List<? extends ListModel> campaigns, boolean z7) {
        Intrinsics.f(filter, "filter");
        Intrinsics.f(source, "source");
        Intrinsics.f(campaigns, "campaigns");
        return new PastCampaignsState(filter, source, campaigns, z7);
    }

    public final List<ListModel> c() {
        return this.f27351c;
    }

    public final PastCampaignsFilter d() {
        return this.f27349a;
    }

    public final boolean e() {
        return this.f27352d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PastCampaignsState) {
            PastCampaignsState pastCampaignsState = (PastCampaignsState) obj;
            return this.f27349a == pastCampaignsState.f27349a && Intrinsics.a(this.f27350b, pastCampaignsState.f27350b) && Intrinsics.a(this.f27351c, pastCampaignsState.f27351c) && this.f27352d == pastCampaignsState.f27352d;
        }
        return false;
    }

    public final List<CampaignV2Group> f() {
        return this.f27350b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.f27349a.hashCode() * 31) + this.f27350b.hashCode()) * 31) + this.f27351c.hashCode()) * 31;
        boolean z7 = this.f27352d;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode + i8;
    }

    public String toString() {
        PastCampaignsFilter pastCampaignsFilter = this.f27349a;
        List<CampaignV2Group> list = this.f27350b;
        List<ListModel> list2 = this.f27351c;
        boolean z7 = this.f27352d;
        return "PastCampaignsState(filter=" + pastCampaignsFilter + ", source=" + list + ", campaigns=" + list2 + ", lastPageLoaded=" + z7 + ")";
    }
}
