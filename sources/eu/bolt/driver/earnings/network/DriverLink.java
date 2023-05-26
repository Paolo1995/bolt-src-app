package eu.bolt.driver.earnings.network;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverLink.kt */
/* loaded from: classes5.dex */
public final class DriverLink {
    @SerializedName("text")

    /* renamed from: a  reason: collision with root package name */
    private final String f41380a;
    @SerializedName(ImagesContract.URL)

    /* renamed from: b  reason: collision with root package name */
    private final String f41381b;
    @SerializedName("appearance")

    /* renamed from: c  reason: collision with root package name */
    private final Appearance f41382c;

    /* compiled from: DriverLink.kt */
    /* loaded from: classes5.dex */
    public enum Appearance {
        ACTION,
        PRIMARY
    }

    public final Appearance a() {
        return this.f41382c;
    }

    public final String b() {
        return this.f41380a;
    }

    public final String c() {
        return this.f41381b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverLink) {
            DriverLink driverLink = (DriverLink) obj;
            return Intrinsics.a(this.f41380a, driverLink.f41380a) && Intrinsics.a(this.f41381b, driverLink.f41381b) && this.f41382c == driverLink.f41382c;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f41380a.hashCode() * 31) + this.f41381b.hashCode()) * 31) + this.f41382c.hashCode();
    }

    public String toString() {
        String str = this.f41380a;
        String str2 = this.f41381b;
        Appearance appearance = this.f41382c;
        return "DriverLink(text=" + str + ", url=" + str2 + ", appearance=" + appearance + ")";
    }
}
