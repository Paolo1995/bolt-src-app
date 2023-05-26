package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RideDetailLabel.kt */
/* loaded from: classes3.dex */
public final class RideDetailLabel {
    @SerializedName("type")

    /* renamed from: a  reason: collision with root package name */
    private final String f22544a;
    @SerializedName("text")

    /* renamed from: b  reason: collision with root package name */
    private final String f22545b;

    public final String a() {
        return this.f22545b;
    }

    public final String b() {
        return this.f22544a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RideDetailLabel) {
            RideDetailLabel rideDetailLabel = (RideDetailLabel) obj;
            return Intrinsics.a(this.f22544a, rideDetailLabel.f22544a) && Intrinsics.a(this.f22545b, rideDetailLabel.f22545b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f22544a.hashCode() * 31) + this.f22545b.hashCode();
    }

    public String toString() {
        String str = this.f22544a;
        String str2 = this.f22545b;
        return "RideDetailLabel(type=" + str + ", text=" + str2 + ")";
    }
}
