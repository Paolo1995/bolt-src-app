package ee.mtakso.driver.network.client.emergencyassist.reverse_geocode;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AddressComponents.kt */
/* loaded from: classes3.dex */
public final class AddressComponents {
    @SerializedName("place_name")

    /* renamed from: a  reason: collision with root package name */
    private final String f22181a;
    @SerializedName("street_number")

    /* renamed from: b  reason: collision with root package name */
    private final String f22182b;
    @SerializedName("street_name")

    /* renamed from: c  reason: collision with root package name */
    private final String f22183c;
    @SerializedName("postcode")

    /* renamed from: d  reason: collision with root package name */
    private final String f22184d;
    @SerializedName("district")

    /* renamed from: e  reason: collision with root package name */
    private final String f22185e;
    @SerializedName("city")

    /* renamed from: f  reason: collision with root package name */
    private final String f22186f;
    @SerializedName("country_subdivision")

    /* renamed from: g  reason: collision with root package name */
    private final String f22187g;
    @SerializedName("country")

    /* renamed from: h  reason: collision with root package name */
    private final String f22188h;
    @SerializedName("country_code")

    /* renamed from: i  reason: collision with root package name */
    private final String f22189i;
    @SerializedName("fallback_address")

    /* renamed from: j  reason: collision with root package name */
    private final String f22190j;
    @SerializedName("fallback_address_extra")

    /* renamed from: k  reason: collision with root package name */
    private final String f22191k;
    @SerializedName("fallback_full_address")

    /* renamed from: l  reason: collision with root package name */
    private final String f22192l;

    public final String a() {
        return this.f22190j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AddressComponents) {
            AddressComponents addressComponents = (AddressComponents) obj;
            return Intrinsics.a(this.f22181a, addressComponents.f22181a) && Intrinsics.a(this.f22182b, addressComponents.f22182b) && Intrinsics.a(this.f22183c, addressComponents.f22183c) && Intrinsics.a(this.f22184d, addressComponents.f22184d) && Intrinsics.a(this.f22185e, addressComponents.f22185e) && Intrinsics.a(this.f22186f, addressComponents.f22186f) && Intrinsics.a(this.f22187g, addressComponents.f22187g) && Intrinsics.a(this.f22188h, addressComponents.f22188h) && Intrinsics.a(this.f22189i, addressComponents.f22189i) && Intrinsics.a(this.f22190j, addressComponents.f22190j) && Intrinsics.a(this.f22191k, addressComponents.f22191k) && Intrinsics.a(this.f22192l, addressComponents.f22192l);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((this.f22181a.hashCode() * 31) + this.f22182b.hashCode()) * 31) + this.f22183c.hashCode()) * 31) + this.f22184d.hashCode()) * 31) + this.f22185e.hashCode()) * 31) + this.f22186f.hashCode()) * 31) + this.f22187g.hashCode()) * 31) + this.f22188h.hashCode()) * 31) + this.f22189i.hashCode()) * 31;
        String str = this.f22190j;
        return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f22191k.hashCode()) * 31) + this.f22192l.hashCode();
    }

    public String toString() {
        String str = this.f22181a;
        String str2 = this.f22182b;
        String str3 = this.f22183c;
        String str4 = this.f22184d;
        String str5 = this.f22185e;
        String str6 = this.f22186f;
        String str7 = this.f22187g;
        String str8 = this.f22188h;
        String str9 = this.f22189i;
        String str10 = this.f22190j;
        String str11 = this.f22191k;
        String str12 = this.f22192l;
        return "AddressComponents(place_name=" + str + ", street_number=" + str2 + ", street_name=" + str3 + ", postcode=" + str4 + ", district=" + str5 + ", city=" + str6 + ", countrySubdivision=" + str7 + ", country=" + str8 + ", countryCode=" + str9 + ", fallbackAddress=" + str10 + ", fallbackAddressExtra=" + str11 + ", fallbackFullAddress=" + str12 + ")";
    }
}
