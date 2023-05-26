package eu.bolt.driver.earnings.network;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverBanner.kt */
/* loaded from: classes5.dex */
public final class DriverBanner {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f41343a;
    @SerializedName("subtitle")

    /* renamed from: b  reason: collision with root package name */
    private final String f41344b;
    @SerializedName("image")

    /* renamed from: c  reason: collision with root package name */
    private final DriverImage f41345c;
    @SerializedName("appearance")

    /* renamed from: d  reason: collision with root package name */
    private final Appearance f41346d;
    @SerializedName("action")

    /* renamed from: e  reason: collision with root package name */
    private final DriverButtonAction f41347e;
    @SerializedName("trailing_component")

    /* renamed from: f  reason: collision with root package name */
    private final DriverBannerComponent f41348f;

    /* compiled from: DriverBanner.kt */
    /* loaded from: classes5.dex */
    public enum Appearance {
        ACTION,
        SECONDARY,
        UNKNOWN
    }

    public final DriverButtonAction a() {
        return this.f41347e;
    }

    public final Appearance b() {
        return this.f41346d;
    }

    public final DriverImage c() {
        return this.f41345c;
    }

    public final String d() {
        return this.f41344b;
    }

    public final String e() {
        return this.f41343a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverBanner) {
            DriverBanner driverBanner = (DriverBanner) obj;
            return Intrinsics.a(this.f41343a, driverBanner.f41343a) && Intrinsics.a(this.f41344b, driverBanner.f41344b) && Intrinsics.a(this.f41345c, driverBanner.f41345c) && this.f41346d == driverBanner.f41346d && Intrinsics.a(this.f41347e, driverBanner.f41347e) && Intrinsics.a(this.f41348f, driverBanner.f41348f);
        }
        return false;
    }

    public final DriverBannerComponent f() {
        return this.f41348f;
    }

    public int hashCode() {
        int hashCode = this.f41343a.hashCode() * 31;
        String str = this.f41344b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        DriverImage driverImage = this.f41345c;
        int hashCode3 = (((hashCode2 + (driverImage == null ? 0 : driverImage.hashCode())) * 31) + this.f41346d.hashCode()) * 31;
        DriverButtonAction driverButtonAction = this.f41347e;
        int hashCode4 = (hashCode3 + (driverButtonAction == null ? 0 : driverButtonAction.hashCode())) * 31;
        DriverBannerComponent driverBannerComponent = this.f41348f;
        return hashCode4 + (driverBannerComponent != null ? driverBannerComponent.hashCode() : 0);
    }

    public String toString() {
        String str = this.f41343a;
        String str2 = this.f41344b;
        DriverImage driverImage = this.f41345c;
        Appearance appearance = this.f41346d;
        DriverButtonAction driverButtonAction = this.f41347e;
        DriverBannerComponent driverBannerComponent = this.f41348f;
        return "DriverBanner(title=" + str + ", subtitle=" + str2 + ", image=" + driverImage + ", appearance=" + appearance + ", action=" + driverButtonAction + ", trailingComponent=" + driverBannerComponent + ")";
    }
}
