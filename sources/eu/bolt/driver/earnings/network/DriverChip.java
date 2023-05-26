package eu.bolt.driver.earnings.network;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverChip.kt */
/* loaded from: classes5.dex */
public final class DriverChip {
    @SerializedName("text")

    /* renamed from: a  reason: collision with root package name */
    private final String f41361a;
    @SerializedName("image")

    /* renamed from: b  reason: collision with root package name */
    private final DriverImage f41362b;
    @SerializedName("appearance")

    /* renamed from: c  reason: collision with root package name */
    private final Appearance f41363c;
    @SerializedName("size")

    /* renamed from: d  reason: collision with root package name */
    private final Size f41364d;

    /* compiled from: DriverChip.kt */
    /* loaded from: classes5.dex */
    public enum Appearance {
        ACTION,
        WARNING,
        PRIMARY,
        CRITICAL,
        NEUTRAL
    }

    /* compiled from: DriverChip.kt */
    /* loaded from: classes5.dex */
    public enum Size {
        BIG,
        MEDIUM,
        SMALL,
        SMALL_OPAQUE
    }

    public final Appearance a() {
        return this.f41363c;
    }

    public final DriverImage b() {
        return this.f41362b;
    }

    public final String c() {
        return this.f41361a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverChip) {
            DriverChip driverChip = (DriverChip) obj;
            return Intrinsics.a(this.f41361a, driverChip.f41361a) && Intrinsics.a(this.f41362b, driverChip.f41362b) && this.f41363c == driverChip.f41363c && this.f41364d == driverChip.f41364d;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f41361a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        DriverImage driverImage = this.f41362b;
        return ((((hashCode + (driverImage != null ? driverImage.hashCode() : 0)) * 31) + this.f41363c.hashCode()) * 31) + this.f41364d.hashCode();
    }

    public String toString() {
        String str = this.f41361a;
        DriverImage driverImage = this.f41362b;
        Appearance appearance = this.f41363c;
        Size size = this.f41364d;
        return "DriverChip(text=" + str + ", image=" + driverImage + ", appearance=" + appearance + ", size=" + size + ")";
    }
}
