package ee.mtakso.driver.network.client.geo;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Geo.kt */
/* loaded from: classes3.dex */
public final class ExternalSourceAddressDetails {
    @SerializedName("address")

    /* renamed from: a  reason: collision with root package name */
    private final String f22248a;
    @SerializedName("lat")

    /* renamed from: b  reason: collision with root package name */
    private final double f22249b;
    @SerializedName("lng")

    /* renamed from: c  reason: collision with root package name */
    private final double f22250c;

    public ExternalSourceAddressDetails(String address, double d8, double d9) {
        Intrinsics.f(address, "address");
        this.f22248a = address;
        this.f22249b = d8;
        this.f22250c = d9;
    }

    public final String a() {
        return this.f22248a;
    }

    public final double b() {
        return this.f22249b;
    }

    public final double c() {
        return this.f22250c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ExternalSourceAddressDetails) {
            ExternalSourceAddressDetails externalSourceAddressDetails = (ExternalSourceAddressDetails) obj;
            return Intrinsics.a(this.f22248a, externalSourceAddressDetails.f22248a) && Double.compare(this.f22249b, externalSourceAddressDetails.f22249b) == 0 && Double.compare(this.f22250c, externalSourceAddressDetails.f22250c) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f22248a.hashCode() * 31) + q1.a.a(this.f22249b)) * 31) + q1.a.a(this.f22250c);
    }

    public String toString() {
        String str = this.f22248a;
        double d8 = this.f22249b;
        double d9 = this.f22250c;
        return "ExternalSourceAddressDetails(address=" + str + ", lat=" + d8 + ", lng=" + d9 + ")";
    }
}
