package ee.mtakso.driver.network.client.boltclub.model;

import com.google.gson.annotations.SerializedName;
import i0.a;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: Offer.kt */
/* loaded from: classes3.dex */
public final class Offer {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final long f21562a;
    @SerializedName("vendor_name")

    /* renamed from: b  reason: collision with root package name */
    private final String f21563b;
    @SerializedName("short_description")

    /* renamed from: c  reason: collision with root package name */
    private final String f21564c;
    @SerializedName("formatted_discount")

    /* renamed from: d  reason: collision with root package name */
    private final String f21565d;
    @SerializedName("logo_url")

    /* renamed from: e  reason: collision with root package name */
    private final String f21566e;

    public final String a() {
        return this.f21565d;
    }

    public final String b() {
        return this.f21566e;
    }

    public final long c() {
        return this.f21562a;
    }

    public final String d() {
        return this.f21564c;
    }

    public final String e() {
        return this.f21563b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Offer) {
            Offer offer = (Offer) obj;
            return this.f21562a == offer.f21562a && Intrinsics.a(this.f21563b, offer.f21563b) && Intrinsics.a(this.f21564c, offer.f21564c) && Intrinsics.a(this.f21565d, offer.f21565d) && Intrinsics.a(this.f21566e, offer.f21566e);
        }
        return false;
    }

    public int hashCode() {
        int a8 = ((a.a(this.f21562a) * 31) + this.f21563b.hashCode()) * 31;
        String str = this.f21564c;
        int hashCode = (a8 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f21565d;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f21566e.hashCode();
    }

    public String toString() {
        long j8 = this.f21562a;
        String str = this.f21563b;
        String str2 = this.f21564c;
        String str3 = this.f21565d;
        String str4 = this.f21566e;
        return "Offer(offerId=" + j8 + ", vendorName=" + str + ", shortDescription=" + str2 + ", formattedDiscount=" + str3 + ", logoUrl=" + str4 + ")";
    }
}
