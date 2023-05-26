package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Campaign.kt */
/* loaded from: classes3.dex */
public final class CampaignDisplayPrice {
    @SerializedName("amount")

    /* renamed from: a  reason: collision with root package name */
    private final String f21614a;
    @SerializedName("currency_symbol_before")

    /* renamed from: b  reason: collision with root package name */
    private final String f21615b;
    @SerializedName("currency_symbol_after")

    /* renamed from: c  reason: collision with root package name */
    private final String f21616c;

    public final String a() {
        return this.f21614a;
    }

    public final String b() {
        return this.f21616c;
    }

    public final String c() {
        return this.f21615b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CampaignDisplayPrice) {
            CampaignDisplayPrice campaignDisplayPrice = (CampaignDisplayPrice) obj;
            return Intrinsics.a(this.f21614a, campaignDisplayPrice.f21614a) && Intrinsics.a(this.f21615b, campaignDisplayPrice.f21615b) && Intrinsics.a(this.f21616c, campaignDisplayPrice.f21616c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f21614a.hashCode() * 31;
        String str = this.f21615b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f21616c;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        String str = this.f21614a;
        String str2 = this.f21615b;
        String str3 = this.f21616c;
        return "CampaignDisplayPrice(amount=" + str + ", currencySymbolBefore=" + str2 + ", currencySymbolAfter=" + str3 + ")";
    }
}
