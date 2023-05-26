package ee.mtakso.driver.network.client.geo;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Geo.kt */
/* loaded from: classes3.dex */
public final class ExternalSourceAddress {
    @SerializedName("source")

    /* renamed from: a  reason: collision with root package name */
    private final String f22240a;
    @SerializedName("type")

    /* renamed from: b  reason: collision with root package name */
    private final String f22241b;
    @SerializedName("address")

    /* renamed from: c  reason: collision with root package name */
    private final String f22242c;
    @SerializedName("address_extra")

    /* renamed from: d  reason: collision with root package name */
    private final String f22243d;
    @SerializedName("full_address")

    /* renamed from: e  reason: collision with root package name */
    private final String f22244e;
    @SerializedName("place_id")

    /* renamed from: f  reason: collision with root package name */
    private final String f22245f;
    @SerializedName("lat")

    /* renamed from: g  reason: collision with root package name */
    private final Double f22246g;
    @SerializedName("lng")

    /* renamed from: h  reason: collision with root package name */
    private final Double f22247h;

    public ExternalSourceAddress(String source, String type, String address, String addressExtra, String fullAddress, String placeId, Double d8, Double d9) {
        Intrinsics.f(source, "source");
        Intrinsics.f(type, "type");
        Intrinsics.f(address, "address");
        Intrinsics.f(addressExtra, "addressExtra");
        Intrinsics.f(fullAddress, "fullAddress");
        Intrinsics.f(placeId, "placeId");
        this.f22240a = source;
        this.f22241b = type;
        this.f22242c = address;
        this.f22243d = addressExtra;
        this.f22244e = fullAddress;
        this.f22245f = placeId;
        this.f22246g = d8;
        this.f22247h = d9;
    }

    public final String a() {
        return this.f22242c;
    }

    public final String b() {
        return this.f22243d;
    }

    public final Double c() {
        return this.f22246g;
    }

    public final Double d() {
        return this.f22247h;
    }

    public final String e() {
        return this.f22245f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ExternalSourceAddress) {
            ExternalSourceAddress externalSourceAddress = (ExternalSourceAddress) obj;
            return Intrinsics.a(this.f22240a, externalSourceAddress.f22240a) && Intrinsics.a(this.f22241b, externalSourceAddress.f22241b) && Intrinsics.a(this.f22242c, externalSourceAddress.f22242c) && Intrinsics.a(this.f22243d, externalSourceAddress.f22243d) && Intrinsics.a(this.f22244e, externalSourceAddress.f22244e) && Intrinsics.a(this.f22245f, externalSourceAddress.f22245f) && Intrinsics.a(this.f22246g, externalSourceAddress.f22246g) && Intrinsics.a(this.f22247h, externalSourceAddress.f22247h);
        }
        return false;
    }

    public final String f() {
        return this.f22240a;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.f22240a.hashCode() * 31) + this.f22241b.hashCode()) * 31) + this.f22242c.hashCode()) * 31) + this.f22243d.hashCode()) * 31) + this.f22244e.hashCode()) * 31) + this.f22245f.hashCode()) * 31;
        Double d8 = this.f22246g;
        int hashCode2 = (hashCode + (d8 == null ? 0 : d8.hashCode())) * 31;
        Double d9 = this.f22247h;
        return hashCode2 + (d9 != null ? d9.hashCode() : 0);
    }

    public String toString() {
        String str = this.f22240a;
        String str2 = this.f22241b;
        String str3 = this.f22242c;
        String str4 = this.f22243d;
        String str5 = this.f22244e;
        String str6 = this.f22245f;
        Double d8 = this.f22246g;
        Double d9 = this.f22247h;
        return "ExternalSourceAddress(source=" + str + ", type=" + str2 + ", address=" + str3 + ", addressExtra=" + str4 + ", fullAddress=" + str5 + ", placeId=" + str6 + ", lat=" + d8 + ", lng=" + d9 + ")";
    }
}
