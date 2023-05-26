package ee.mtakso.driver.network.client.boltclub.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BoltClubOffersResponse.kt */
/* loaded from: classes3.dex */
public final class BoltClubOffersResponse {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f21547a;
    @SerializedName("faq_link")

    /* renamed from: b  reason: collision with root package name */
    private final String f21548b;
    @SerializedName("groups")

    /* renamed from: c  reason: collision with root package name */
    private final List<OfferGroup> f21549c;
    @SerializedName("no_offers_available")

    /* renamed from: d  reason: collision with root package name */
    private final NoOffersAvailable f21550d;
    @SerializedName("footer_data")

    /* renamed from: e  reason: collision with root package name */
    private final FooterData f21551e;

    public final String a() {
        return this.f21548b;
    }

    public final FooterData b() {
        return this.f21551e;
    }

    public final NoOffersAvailable c() {
        return this.f21550d;
    }

    public final List<OfferGroup> d() {
        return this.f21549c;
    }

    public final String e() {
        return this.f21547a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BoltClubOffersResponse) {
            BoltClubOffersResponse boltClubOffersResponse = (BoltClubOffersResponse) obj;
            return Intrinsics.a(this.f21547a, boltClubOffersResponse.f21547a) && Intrinsics.a(this.f21548b, boltClubOffersResponse.f21548b) && Intrinsics.a(this.f21549c, boltClubOffersResponse.f21549c) && Intrinsics.a(this.f21550d, boltClubOffersResponse.f21550d) && Intrinsics.a(this.f21551e, boltClubOffersResponse.f21551e);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f21547a.hashCode() * 31;
        String str = this.f21548b;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f21549c.hashCode()) * 31;
        NoOffersAvailable noOffersAvailable = this.f21550d;
        return ((hashCode2 + (noOffersAvailable != null ? noOffersAvailable.hashCode() : 0)) * 31) + this.f21551e.hashCode();
    }

    public String toString() {
        String str = this.f21547a;
        String str2 = this.f21548b;
        List<OfferGroup> list = this.f21549c;
        NoOffersAvailable noOffersAvailable = this.f21550d;
        FooterData footerData = this.f21551e;
        return "BoltClubOffersResponse(title=" + str + ", faqLink=" + str2 + ", offerGroups=" + list + ", noOffersAvailable=" + noOffersAvailable + ", footerData=" + footerData + ")";
    }
}
