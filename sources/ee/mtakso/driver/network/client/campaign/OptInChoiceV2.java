package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.Coordinates;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: CampaignV2.kt */
/* loaded from: classes3.dex */
public final class OptInChoiceV2 implements OptInCampaignChoice {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final long f21703a;
    @SerializedName("title")

    /* renamed from: b  reason: collision with root package name */
    private final String f21704b;
    @SerializedName("subtitle")

    /* renamed from: c  reason: collision with root package name */
    private final String f21705c;
    @SerializedName("description")

    /* renamed from: d  reason: collision with root package name */
    private final String f21706d;
    @SerializedName("period")

    /* renamed from: e  reason: collision with root package name */
    private final String f21707e;
    @SerializedName("periods")

    /* renamed from: f  reason: collision with root package name */
    private final Periods f21708f;
    @SerializedName("footnote")

    /* renamed from: g  reason: collision with root package name */
    private final InfoBlock f21709g;
    @SerializedName("polygon")

    /* renamed from: h  reason: collision with root package name */
    private final List<Coordinates> f21710h;
    @SerializedName("conditions")

    /* renamed from: i  reason: collision with root package name */
    private final List<Condition> f21711i;
    @SerializedName("bonus")

    /* renamed from: j  reason: collision with root package name */
    private final Bonus f21712j;
    @SerializedName("categories_str")

    /* renamed from: k  reason: collision with root package name */
    private final String f21713k;
    @SerializedName("location_str")

    /* renamed from: l  reason: collision with root package name */
    private final String f21714l;
    @SerializedName("tc_message")

    /* renamed from: m  reason: collision with root package name */
    private final TCMessage f21715m;

    @Override // ee.mtakso.driver.network.client.campaign.OptInCampaignChoice
    public String a() {
        return this.f21705c;
    }

    public final Bonus b() {
        return this.f21712j;
    }

    public final String c() {
        return this.f21713k;
    }

    public final List<Condition> d() {
        return this.f21711i;
    }

    public final String e() {
        return this.f21706d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OptInChoiceV2) {
            OptInChoiceV2 optInChoiceV2 = (OptInChoiceV2) obj;
            return getId() == optInChoiceV2.getId() && Intrinsics.a(getTitle(), optInChoiceV2.getTitle()) && Intrinsics.a(a(), optInChoiceV2.a()) && Intrinsics.a(this.f21706d, optInChoiceV2.f21706d) && Intrinsics.a(this.f21707e, optInChoiceV2.f21707e) && Intrinsics.a(this.f21708f, optInChoiceV2.f21708f) && Intrinsics.a(this.f21709g, optInChoiceV2.f21709g) && Intrinsics.a(this.f21710h, optInChoiceV2.f21710h) && Intrinsics.a(this.f21711i, optInChoiceV2.f21711i) && Intrinsics.a(this.f21712j, optInChoiceV2.f21712j) && Intrinsics.a(this.f21713k, optInChoiceV2.f21713k) && Intrinsics.a(this.f21714l, optInChoiceV2.f21714l) && Intrinsics.a(this.f21715m, optInChoiceV2.f21715m);
        }
        return false;
    }

    public final InfoBlock f() {
        return this.f21709g;
    }

    public final String g() {
        return this.f21714l;
    }

    @Override // ee.mtakso.driver.network.client.campaign.OptInCampaignChoice
    public long getId() {
        return this.f21703a;
    }

    @Override // ee.mtakso.driver.network.client.campaign.OptInCampaignChoice
    public String getTitle() {
        return this.f21704b;
    }

    public final String h() {
        return this.f21707e;
    }

    public int hashCode() {
        int a8 = ((((((i0.a.a(getId()) * 31) + getTitle().hashCode()) * 31) + a().hashCode()) * 31) + this.f21706d.hashCode()) * 31;
        String str = this.f21707e;
        int hashCode = (a8 + (str == null ? 0 : str.hashCode())) * 31;
        Periods periods = this.f21708f;
        int hashCode2 = (hashCode + (periods == null ? 0 : periods.hashCode())) * 31;
        InfoBlock infoBlock = this.f21709g;
        int hashCode3 = (hashCode2 + (infoBlock == null ? 0 : infoBlock.hashCode())) * 31;
        List<Coordinates> list = this.f21710h;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        List<Condition> list2 = this.f21711i;
        return ((((((((hashCode4 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.f21712j.hashCode()) * 31) + this.f21713k.hashCode()) * 31) + this.f21714l.hashCode()) * 31) + this.f21715m.hashCode();
    }

    public final Periods i() {
        return this.f21708f;
    }

    public final List<Coordinates> j() {
        return this.f21710h;
    }

    public final TCMessage k() {
        return this.f21715m;
    }

    public String toString() {
        long id = getId();
        String title = getTitle();
        String a8 = a();
        String str = this.f21706d;
        String str2 = this.f21707e;
        Periods periods = this.f21708f;
        InfoBlock infoBlock = this.f21709g;
        List<Coordinates> list = this.f21710h;
        List<Condition> list2 = this.f21711i;
        Bonus bonus = this.f21712j;
        String str3 = this.f21713k;
        String str4 = this.f21714l;
        TCMessage tCMessage = this.f21715m;
        return "OptInChoiceV2(id=" + id + ", title=" + title + ", subtitle=" + a8 + ", description=" + str + ", period=" + str2 + ", periods=" + periods + ", footnote=" + infoBlock + ", polygon=" + list + ", conditions=" + list2 + ", bonus=" + bonus + ", categoriesStr=" + str3 + ", locationStr=" + str4 + ", tcMessage=" + tCMessage + ")";
    }
}
