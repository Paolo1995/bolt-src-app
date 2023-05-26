package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: CampaignV2.kt */
/* loaded from: classes3.dex */
public final class InviteCampaign {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final long f21690a;
    @SerializedName("earned_amount_str")

    /* renamed from: b  reason: collision with root package name */
    private final String f21691b;
    @SerializedName("shared_amount_str")

    /* renamed from: c  reason: collision with root package name */
    private final String f21692c;
    @SerializedName("conditions")

    /* renamed from: d  reason: collision with root package name */
    private final String f21693d;
    @SerializedName("valid_until")

    /* renamed from: e  reason: collision with root package name */
    private final long f21694e;
    @SerializedName("categories_str")

    /* renamed from: f  reason: collision with root package name */
    private final String f21695f;
    @SerializedName("location_str")

    /* renamed from: g  reason: collision with root package name */
    private final String f21696g;
    @SerializedName("tc_message")

    /* renamed from: h  reason: collision with root package name */
    private final TCMessage f21697h;
    @SerializedName("bonus")

    /* renamed from: i  reason: collision with root package name */
    private final Bonus f21698i;

    public final Bonus a() {
        return this.f21698i;
    }

    public final String b() {
        return this.f21695f;
    }

    public final String c() {
        return this.f21693d;
    }

    public final long d() {
        return this.f21690a;
    }

    public final String e() {
        return this.f21696g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InviteCampaign) {
            InviteCampaign inviteCampaign = (InviteCampaign) obj;
            return this.f21690a == inviteCampaign.f21690a && Intrinsics.a(this.f21691b, inviteCampaign.f21691b) && Intrinsics.a(this.f21692c, inviteCampaign.f21692c) && Intrinsics.a(this.f21693d, inviteCampaign.f21693d) && this.f21694e == inviteCampaign.f21694e && Intrinsics.a(this.f21695f, inviteCampaign.f21695f) && Intrinsics.a(this.f21696g, inviteCampaign.f21696g) && Intrinsics.a(this.f21697h, inviteCampaign.f21697h) && Intrinsics.a(this.f21698i, inviteCampaign.f21698i);
        }
        return false;
    }

    public final String f() {
        return this.f21692c;
    }

    public final TCMessage g() {
        return this.f21697h;
    }

    public final long h() {
        return this.f21694e;
    }

    public int hashCode() {
        return (((((((((((((((i0.a.a(this.f21690a) * 31) + this.f21691b.hashCode()) * 31) + this.f21692c.hashCode()) * 31) + this.f21693d.hashCode()) * 31) + i0.a.a(this.f21694e)) * 31) + this.f21695f.hashCode()) * 31) + this.f21696g.hashCode()) * 31) + this.f21697h.hashCode()) * 31) + this.f21698i.hashCode();
    }

    public String toString() {
        long j8 = this.f21690a;
        String str = this.f21691b;
        String str2 = this.f21692c;
        String str3 = this.f21693d;
        long j9 = this.f21694e;
        String str4 = this.f21695f;
        String str5 = this.f21696g;
        TCMessage tCMessage = this.f21697h;
        Bonus bonus = this.f21698i;
        return "InviteCampaign(id=" + j8 + ", earnedAmountStr=" + str + ", sharedAmountStr=" + str2 + ", conditions=" + str3 + ", validUntil=" + j9 + ", categoriesStr=" + str4 + ", locationStr=" + str5 + ", tcMessage=" + tCMessage + ", bonus=" + bonus + ")";
    }
}
