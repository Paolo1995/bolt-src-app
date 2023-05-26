package ee.mtakso.driver.ui.screens.campaigns.v2;

/* compiled from: PastCampaignsState.kt */
/* loaded from: classes3.dex */
public enum PastCampaignsFilter {
    ALL(false, "past_campaign_group_all_", "past_campaign_item_all_"),
    COMPLETED(true, "past_campaign_group_completed_", "past_campaign_item_completed_");
    

    /* renamed from: f  reason: collision with root package name */
    private final boolean f27338f;

    /* renamed from: g  reason: collision with root package name */
    private final String f27339g;

    /* renamed from: h  reason: collision with root package name */
    private final String f27340h;

    PastCampaignsFilter(boolean z7, String str, String str2) {
        this.f27338f = z7;
        this.f27339g = str;
        this.f27340h = str2;
    }

    public final String c() {
        return this.f27340h;
    }

    public final String e() {
        return this.f27339g;
    }

    public final boolean f() {
        return this.f27338f;
    }
}
