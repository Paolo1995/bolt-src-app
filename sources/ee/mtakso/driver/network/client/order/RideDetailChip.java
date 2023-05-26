package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RideDetailChip.kt */
/* loaded from: classes3.dex */
public final class RideDetailChip {
    @SerializedName("type")

    /* renamed from: a  reason: collision with root package name */
    private final Type f22538a;
    @SerializedName("text")

    /* renamed from: b  reason: collision with root package name */
    private final String f22539b;

    /* compiled from: RideDetailChip.kt */
    /* loaded from: classes3.dex */
    public enum Type {
        UNKNOWN,
        ACTION,
        WARNING
    }

    public final String a() {
        return this.f22539b;
    }

    public final Type b() {
        return this.f22538a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RideDetailChip) {
            RideDetailChip rideDetailChip = (RideDetailChip) obj;
            return this.f22538a == rideDetailChip.f22538a && Intrinsics.a(this.f22539b, rideDetailChip.f22539b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f22538a.hashCode() * 31) + this.f22539b.hashCode();
    }

    public String toString() {
        Type type = this.f22538a;
        String str = this.f22539b;
        return "RideDetailChip(type=" + type + ", text=" + str + ")";
    }
}
