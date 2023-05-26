package ee.mtakso.driver.network.client.boltclub.model;

import com.google.gson.annotations.SerializedName;
import i0.a;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: BoltClubOfferDetailsResponse.kt */
/* loaded from: classes3.dex */
public final class BoltClubOfferDetailsResponse {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final long f21538a;
    @SerializedName("logo_url")

    /* renamed from: b  reason: collision with root package name */
    private final String f21539b;
    @SerializedName("vendor_name")

    /* renamed from: c  reason: collision with root package name */
    private final String f21540c;
    @SerializedName("short_description")

    /* renamed from: d  reason: collision with root package name */
    private final String f21541d;
    @SerializedName("formatted_discount")

    /* renamed from: e  reason: collision with root package name */
    private final String f21542e;
    @SerializedName("is_favourite")

    /* renamed from: f  reason: collision with root package name */
    private final boolean f21543f;
    @SerializedName("is_favourite_icon_shown")

    /* renamed from: g  reason: collision with root package name */
    private final boolean f21544g;
    @SerializedName("sections")

    /* renamed from: h  reason: collision with root package name */
    private final List<Section> f21545h;
    @SerializedName("integration_data")

    /* renamed from: i  reason: collision with root package name */
    private final IntegrationData f21546i;

    public final String a() {
        return this.f21542e;
    }

    public final IntegrationData b() {
        return this.f21546i;
    }

    public final String c() {
        return this.f21539b;
    }

    public final long d() {
        return this.f21538a;
    }

    public final List<Section> e() {
        return this.f21545h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BoltClubOfferDetailsResponse) {
            BoltClubOfferDetailsResponse boltClubOfferDetailsResponse = (BoltClubOfferDetailsResponse) obj;
            return this.f21538a == boltClubOfferDetailsResponse.f21538a && Intrinsics.a(this.f21539b, boltClubOfferDetailsResponse.f21539b) && Intrinsics.a(this.f21540c, boltClubOfferDetailsResponse.f21540c) && Intrinsics.a(this.f21541d, boltClubOfferDetailsResponse.f21541d) && Intrinsics.a(this.f21542e, boltClubOfferDetailsResponse.f21542e) && this.f21543f == boltClubOfferDetailsResponse.f21543f && this.f21544g == boltClubOfferDetailsResponse.f21544g && Intrinsics.a(this.f21545h, boltClubOfferDetailsResponse.f21545h) && Intrinsics.a(this.f21546i, boltClubOfferDetailsResponse.f21546i);
        }
        return false;
    }

    public final String f() {
        return this.f21541d;
    }

    public final String g() {
        return this.f21540c;
    }

    public final boolean h() {
        return this.f21543f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a8 = ((((a.a(this.f21538a) * 31) + this.f21539b.hashCode()) * 31) + this.f21540c.hashCode()) * 31;
        String str = this.f21541d;
        int hashCode = (a8 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f21542e;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean z7 = this.f21543f;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode2 + i8) * 31;
        boolean z8 = this.f21544g;
        int hashCode3 = (((i9 + (z8 ? 1 : z8 ? 1 : 0)) * 31) + this.f21545h.hashCode()) * 31;
        IntegrationData integrationData = this.f21546i;
        return hashCode3 + (integrationData != null ? integrationData.hashCode() : 0);
    }

    public final boolean i() {
        return this.f21544g;
    }

    public String toString() {
        long j8 = this.f21538a;
        String str = this.f21539b;
        String str2 = this.f21540c;
        String str3 = this.f21541d;
        String str4 = this.f21542e;
        boolean z7 = this.f21543f;
        boolean z8 = this.f21544g;
        List<Section> list = this.f21545h;
        IntegrationData integrationData = this.f21546i;
        return "BoltClubOfferDetailsResponse(offerId=" + j8 + ", logoUrl=" + str + ", vendorName=" + str2 + ", shortDescription=" + str3 + ", formattedDiscount=" + str4 + ", isFavourite=" + z7 + ", isFavouriteIconShown=" + z8 + ", sections=" + list + ", integrationData=" + integrationData + ")";
    }
}
