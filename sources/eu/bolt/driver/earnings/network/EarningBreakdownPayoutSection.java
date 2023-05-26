package eu.bolt.driver.earnings.network;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningBreakdownPayoutSection.kt */
/* loaded from: classes5.dex */
public final class EarningBreakdownPayoutSection {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f41422a;
    @SerializedName("items")

    /* renamed from: b  reason: collision with root package name */
    private final List<DriverListItem> f41423b;

    public final List<DriverListItem> a() {
        return this.f41423b;
    }

    public final String b() {
        return this.f41422a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EarningBreakdownPayoutSection) {
            EarningBreakdownPayoutSection earningBreakdownPayoutSection = (EarningBreakdownPayoutSection) obj;
            return Intrinsics.a(this.f41422a, earningBreakdownPayoutSection.f41422a) && Intrinsics.a(this.f41423b, earningBreakdownPayoutSection.f41423b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f41422a.hashCode() * 31) + this.f41423b.hashCode();
    }

    public String toString() {
        String str = this.f41422a;
        List<DriverListItem> list = this.f41423b;
        return "EarningBreakdownPayoutSection(title=" + str + ", items=" + list + ")";
    }
}
