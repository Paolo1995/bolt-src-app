package ee.mtakso.driver.network.client.emergencyassist.reverse_geocode;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import q1.a;

/* compiled from: EmergencyAssistReverseGeocodeResponse.kt */
/* loaded from: classes3.dex */
public final class EmergencyAssistReverseGeocodeResponse {
    @SerializedName("address_lat")

    /* renamed from: a  reason: collision with root package name */
    private final double f22193a;
    @SerializedName("address_lng")

    /* renamed from: b  reason: collision with root package name */
    private final double f22194b;
    @SerializedName("country_code")

    /* renamed from: c  reason: collision with root package name */
    private final String f22195c;
    @SerializedName("country_name")

    /* renamed from: d  reason: collision with root package name */
    private final String f22196d;
    @SerializedName("place_id")

    /* renamed from: e  reason: collision with root package name */
    private final String f22197e;
    @SerializedName("type")

    /* renamed from: f  reason: collision with root package name */
    private final BoltPlaceType f22198f;
    @SerializedName("geo_token")

    /* renamed from: g  reason: collision with root package name */
    private final String f22199g;
    @SerializedName("provider")

    /* renamed from: h  reason: collision with root package name */
    private final GeoProvider f22200h;
    @SerializedName("provider_version")

    /* renamed from: i  reason: collision with root package name */
    private final String f22201i;
    @SerializedName("optimisation")

    /* renamed from: j  reason: collision with root package name */
    private final GeoOptimisation f22202j;
    @SerializedName("address")

    /* renamed from: k  reason: collision with root package name */
    private final String f22203k;
    @SerializedName("address_extra")

    /* renamed from: l  reason: collision with root package name */
    private final String f22204l;
    @SerializedName("full_address")

    /* renamed from: m  reason: collision with root package name */
    private final String f22205m;
    @SerializedName("address_details_level")

    /* renamed from: n  reason: collision with root package name */
    private final AddressDetailsLevel f22206n;
    @SerializedName("address_components")

    /* renamed from: o  reason: collision with root package name */
    private final AddressComponents f22207o;

    public final AddressComponents a() {
        return this.f22207o;
    }

    public final String b() {
        return this.f22205m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EmergencyAssistReverseGeocodeResponse) {
            EmergencyAssistReverseGeocodeResponse emergencyAssistReverseGeocodeResponse = (EmergencyAssistReverseGeocodeResponse) obj;
            return Double.compare(this.f22193a, emergencyAssistReverseGeocodeResponse.f22193a) == 0 && Double.compare(this.f22194b, emergencyAssistReverseGeocodeResponse.f22194b) == 0 && Intrinsics.a(this.f22195c, emergencyAssistReverseGeocodeResponse.f22195c) && Intrinsics.a(this.f22196d, emergencyAssistReverseGeocodeResponse.f22196d) && Intrinsics.a(this.f22197e, emergencyAssistReverseGeocodeResponse.f22197e) && this.f22198f == emergencyAssistReverseGeocodeResponse.f22198f && Intrinsics.a(this.f22199g, emergencyAssistReverseGeocodeResponse.f22199g) && this.f22200h == emergencyAssistReverseGeocodeResponse.f22200h && Intrinsics.a(this.f22201i, emergencyAssistReverseGeocodeResponse.f22201i) && this.f22202j == emergencyAssistReverseGeocodeResponse.f22202j && Intrinsics.a(this.f22203k, emergencyAssistReverseGeocodeResponse.f22203k) && Intrinsics.a(this.f22204l, emergencyAssistReverseGeocodeResponse.f22204l) && Intrinsics.a(this.f22205m, emergencyAssistReverseGeocodeResponse.f22205m) && this.f22206n == emergencyAssistReverseGeocodeResponse.f22206n && Intrinsics.a(this.f22207o, emergencyAssistReverseGeocodeResponse.f22207o);
        }
        return false;
    }

    public int hashCode() {
        int a8 = ((a.a(this.f22193a) * 31) + a.a(this.f22194b)) * 31;
        String str = this.f22195c;
        int hashCode = (a8 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f22196d;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f22197e.hashCode()) * 31;
        BoltPlaceType boltPlaceType = this.f22198f;
        return ((((((((((((((((((hashCode2 + (boltPlaceType != null ? boltPlaceType.hashCode() : 0)) * 31) + this.f22199g.hashCode()) * 31) + this.f22200h.hashCode()) * 31) + this.f22201i.hashCode()) * 31) + this.f22202j.hashCode()) * 31) + this.f22203k.hashCode()) * 31) + this.f22204l.hashCode()) * 31) + this.f22205m.hashCode()) * 31) + this.f22206n.hashCode()) * 31) + this.f22207o.hashCode();
    }

    public String toString() {
        double d8 = this.f22193a;
        double d9 = this.f22194b;
        String str = this.f22195c;
        String str2 = this.f22196d;
        String str3 = this.f22197e;
        BoltPlaceType boltPlaceType = this.f22198f;
        String str4 = this.f22199g;
        GeoProvider geoProvider = this.f22200h;
        String str5 = this.f22201i;
        GeoOptimisation geoOptimisation = this.f22202j;
        String str6 = this.f22203k;
        String str7 = this.f22204l;
        String str8 = this.f22205m;
        AddressDetailsLevel addressDetailsLevel = this.f22206n;
        AddressComponents addressComponents = this.f22207o;
        return "EmergencyAssistReverseGeocodeResponse(addressLat=" + d8 + ", addressLng=" + d9 + ", countryCode=" + str + ", countryName=" + str2 + ", placeId=" + str3 + ", type=" + boltPlaceType + ", geoToken=" + str4 + ", geoProvider=" + geoProvider + ", providerVersion=" + str5 + ", optimisation=" + geoOptimisation + ", address=" + str6 + ", addressExtra=" + str7 + ", fullAddress=" + str8 + ", addressDetailsLevel=" + addressDetailsLevel + ", addressComponents=" + addressComponents + ")";
    }
}
