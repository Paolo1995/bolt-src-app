package ee.mtakso.driver.ui.screens.campaigns.v2;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignPeriodBadgesConditionsDelegate.kt */
/* loaded from: classes3.dex */
public final class CampaignPeriodString {

    /* renamed from: a  reason: collision with root package name */
    private final String f27309a;

    /* renamed from: b  reason: collision with root package name */
    private final String f27310b;

    public CampaignPeriodString(String shortText, String str) {
        Intrinsics.f(shortText, "shortText");
        this.f27309a = shortText;
        this.f27310b = str;
    }

    public final String a() {
        return this.f27310b;
    }

    public final String b() {
        return this.f27309a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CampaignPeriodString) {
            CampaignPeriodString campaignPeriodString = (CampaignPeriodString) obj;
            return Intrinsics.a(this.f27309a, campaignPeriodString.f27309a) && Intrinsics.a(this.f27310b, campaignPeriodString.f27310b);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f27309a.hashCode() * 31;
        String str = this.f27310b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.f27309a;
        String str2 = this.f27310b;
        return "CampaignPeriodString(shortText=" + str + ", longText=" + str2 + ")";
    }
}
