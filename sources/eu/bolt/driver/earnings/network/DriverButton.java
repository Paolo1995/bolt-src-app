package eu.bolt.driver.earnings.network;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverButton.kt */
/* loaded from: classes5.dex */
public final class DriverButton {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f41351a;
    @SerializedName("image")

    /* renamed from: b  reason: collision with root package name */
    private final DriverImage f41352b;
    @SerializedName("appearance")

    /* renamed from: c  reason: collision with root package name */
    private final Appearance f41353c;
    @SerializedName("size")

    /* renamed from: d  reason: collision with root package name */
    private final Size f41354d;
    @SerializedName("action")

    /* renamed from: e  reason: collision with root package name */
    private final DriverButtonAction f41355e;
    @SerializedName("enabled")

    /* renamed from: f  reason: collision with root package name */
    private final Boolean f41356f;

    /* compiled from: DriverButton.kt */
    /* loaded from: classes5.dex */
    public enum Appearance {
        ACTION,
        PRIMARY,
        CRITICAL,
        SECONDARY,
        OFFLINE,
        UNKNOWN
    }

    /* compiled from: DriverButton.kt */
    /* loaded from: classes5.dex */
    public enum Size {
        LARGE,
        SMALL,
        UNKNOWN
    }

    public final DriverButtonAction a() {
        return this.f41355e;
    }

    public final Appearance b() {
        return this.f41353c;
    }

    public final Boolean c() {
        return this.f41356f;
    }

    public final Size d() {
        return this.f41354d;
    }

    public final String e() {
        return this.f41351a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverButton) {
            DriverButton driverButton = (DriverButton) obj;
            return Intrinsics.a(this.f41351a, driverButton.f41351a) && Intrinsics.a(this.f41352b, driverButton.f41352b) && this.f41353c == driverButton.f41353c && this.f41354d == driverButton.f41354d && Intrinsics.a(this.f41355e, driverButton.f41355e) && Intrinsics.a(this.f41356f, driverButton.f41356f);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f41351a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        DriverImage driverImage = this.f41352b;
        int hashCode2 = (((((((hashCode + (driverImage == null ? 0 : driverImage.hashCode())) * 31) + this.f41353c.hashCode()) * 31) + this.f41354d.hashCode()) * 31) + this.f41355e.hashCode()) * 31;
        Boolean bool = this.f41356f;
        return hashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        String str = this.f41351a;
        DriverImage driverImage = this.f41352b;
        Appearance appearance = this.f41353c;
        Size size = this.f41354d;
        DriverButtonAction driverButtonAction = this.f41355e;
        Boolean bool = this.f41356f;
        return "DriverButton(title=" + str + ", image=" + driverImage + ", appearance=" + appearance + ", size=" + size + ", action=" + driverButtonAction + ", enabled=" + bool + ")";
    }
}
