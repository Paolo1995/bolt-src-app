package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.Coordinates;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: CampaignV2.kt */
/* loaded from: classes3.dex */
public final class DriverCampaignV2 {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final long f21661a;
    @SerializedName("icon_url")

    /* renamed from: b  reason: collision with root package name */
    private final Image f21662b;
    @SerializedName("title")

    /* renamed from: c  reason: collision with root package name */
    private final String f21663c;
    @SerializedName("description")

    /* renamed from: d  reason: collision with root package name */
    private final String f21664d;
    @SerializedName("period")

    /* renamed from: e  reason: collision with root package name */
    private final String f21665e;
    @SerializedName("periods")

    /* renamed from: f  reason: collision with root package name */
    private final Periods f21666f;
    @SerializedName("bonus_trips")

    /* renamed from: g  reason: collision with root package name */
    private final BonusTrips f21667g;
    @SerializedName("badges")

    /* renamed from: h  reason: collision with root package name */
    private final List<Badge> f21668h;
    @SerializedName("categories_str")

    /* renamed from: i  reason: collision with root package name */
    private final String f21669i;
    @SerializedName("location_str")

    /* renamed from: j  reason: collision with root package name */
    private final String f21670j;
    @SerializedName("bonus")

    /* renamed from: k  reason: collision with root package name */
    private final Bonus f21671k;
    @SerializedName("polygon")

    /* renamed from: l  reason: collision with root package name */
    private final List<Coordinates> f21672l;
    @SerializedName("conditions")

    /* renamed from: m  reason: collision with root package name */
    private final List<Condition> f21673m;
    @SerializedName("status_brief")

    /* renamed from: n  reason: collision with root package name */
    private final String f21674n;
    @SerializedName("status_messages")

    /* renamed from: o  reason: collision with root package name */
    private final List<InfoBlock> f21675o;
    @SerializedName("tc_message")

    /* renamed from: p  reason: collision with root package name */
    private final TCMessage f21676p;
    @SerializedName("footnote")

    /* renamed from: q  reason: collision with root package name */
    private final InfoBlock f21677q;

    public final List<Badge> a() {
        return this.f21668h;
    }

    public final Bonus b() {
        return this.f21671k;
    }

    public final BonusTrips c() {
        return this.f21667g;
    }

    public final String d() {
        return this.f21669i;
    }

    public final List<Condition> e() {
        return this.f21673m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverCampaignV2) {
            DriverCampaignV2 driverCampaignV2 = (DriverCampaignV2) obj;
            return this.f21661a == driverCampaignV2.f21661a && Intrinsics.a(this.f21662b, driverCampaignV2.f21662b) && Intrinsics.a(this.f21663c, driverCampaignV2.f21663c) && Intrinsics.a(this.f21664d, driverCampaignV2.f21664d) && Intrinsics.a(this.f21665e, driverCampaignV2.f21665e) && Intrinsics.a(this.f21666f, driverCampaignV2.f21666f) && Intrinsics.a(this.f21667g, driverCampaignV2.f21667g) && Intrinsics.a(this.f21668h, driverCampaignV2.f21668h) && Intrinsics.a(this.f21669i, driverCampaignV2.f21669i) && Intrinsics.a(this.f21670j, driverCampaignV2.f21670j) && Intrinsics.a(this.f21671k, driverCampaignV2.f21671k) && Intrinsics.a(this.f21672l, driverCampaignV2.f21672l) && Intrinsics.a(this.f21673m, driverCampaignV2.f21673m) && Intrinsics.a(this.f21674n, driverCampaignV2.f21674n) && Intrinsics.a(this.f21675o, driverCampaignV2.f21675o) && Intrinsics.a(this.f21676p, driverCampaignV2.f21676p) && Intrinsics.a(this.f21677q, driverCampaignV2.f21677q);
        }
        return false;
    }

    public final String f() {
        return this.f21664d;
    }

    public final InfoBlock g() {
        return this.f21677q;
    }

    public final Image h() {
        return this.f21662b;
    }

    public int hashCode() {
        int a8 = ((((((i0.a.a(this.f21661a) * 31) + this.f21662b.hashCode()) * 31) + this.f21663c.hashCode()) * 31) + this.f21664d.hashCode()) * 31;
        String str = this.f21665e;
        int hashCode = (a8 + (str == null ? 0 : str.hashCode())) * 31;
        Periods periods = this.f21666f;
        int hashCode2 = (hashCode + (periods == null ? 0 : periods.hashCode())) * 31;
        BonusTrips bonusTrips = this.f21667g;
        int hashCode3 = (hashCode2 + (bonusTrips == null ? 0 : bonusTrips.hashCode())) * 31;
        List<Badge> list = this.f21668h;
        int hashCode4 = (((((((hashCode3 + (list == null ? 0 : list.hashCode())) * 31) + this.f21669i.hashCode()) * 31) + this.f21670j.hashCode()) * 31) + this.f21671k.hashCode()) * 31;
        List<Coordinates> list2 = this.f21672l;
        int hashCode5 = (hashCode4 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<Condition> list3 = this.f21673m;
        int hashCode6 = (hashCode5 + (list3 == null ? 0 : list3.hashCode())) * 31;
        String str2 = this.f21674n;
        int hashCode7 = (hashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<InfoBlock> list4 = this.f21675o;
        int hashCode8 = (((hashCode7 + (list4 == null ? 0 : list4.hashCode())) * 31) + this.f21676p.hashCode()) * 31;
        InfoBlock infoBlock = this.f21677q;
        return hashCode8 + (infoBlock != null ? infoBlock.hashCode() : 0);
    }

    public final long i() {
        return this.f21661a;
    }

    public final String j() {
        return this.f21670j;
    }

    public final String k() {
        return this.f21665e;
    }

    public final Periods l() {
        return this.f21666f;
    }

    public final List<Coordinates> m() {
        return this.f21672l;
    }

    public final String n() {
        return this.f21674n;
    }

    public final List<InfoBlock> o() {
        return this.f21675o;
    }

    public final TCMessage p() {
        return this.f21676p;
    }

    public final String q() {
        return this.f21663c;
    }

    public String toString() {
        long j8 = this.f21661a;
        Image image = this.f21662b;
        String str = this.f21663c;
        String str2 = this.f21664d;
        String str3 = this.f21665e;
        Periods periods = this.f21666f;
        BonusTrips bonusTrips = this.f21667g;
        List<Badge> list = this.f21668h;
        String str4 = this.f21669i;
        String str5 = this.f21670j;
        Bonus bonus = this.f21671k;
        List<Coordinates> list2 = this.f21672l;
        List<Condition> list3 = this.f21673m;
        String str6 = this.f21674n;
        List<InfoBlock> list4 = this.f21675o;
        TCMessage tCMessage = this.f21676p;
        InfoBlock infoBlock = this.f21677q;
        return "DriverCampaignV2(id=" + j8 + ", iconUrl=" + image + ", title=" + str + ", description=" + str2 + ", period=" + str3 + ", periods=" + periods + ", bonusTrips=" + bonusTrips + ", badges=" + list + ", categoriesStr=" + str4 + ", locationStr=" + str5 + ", bonus=" + bonus + ", polygon=" + list2 + ", conditions=" + list3 + ", statusBrief=" + str6 + ", statusMessages=" + list4 + ", tcMessage=" + tCMessage + ", footnote=" + infoBlock + ")";
    }
}
