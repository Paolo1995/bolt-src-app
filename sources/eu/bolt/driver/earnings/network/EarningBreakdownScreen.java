package eu.bolt.driver.earnings.network;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningBreakdownScreen.kt */
/* loaded from: classes5.dex */
public final class EarningBreakdownScreen {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f41424a;
    @SerializedName("items")

    /* renamed from: b  reason: collision with root package name */
    private final List<DriverListItemWithNestedItems> f41425b;
    @SerializedName("bottom_section")

    /* renamed from: c  reason: collision with root package name */
    private final EarningBreakdownBottomSection f41426c;
    @SerializedName("payout_section")

    /* renamed from: d  reason: collision with root package name */
    private final EarningBreakdownPayoutSection f41427d;

    public final EarningBreakdownBottomSection a() {
        return this.f41426c;
    }

    public final List<DriverListItemWithNestedItems> b() {
        return this.f41425b;
    }

    public final EarningBreakdownPayoutSection c() {
        return this.f41427d;
    }

    public final String d() {
        return this.f41424a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EarningBreakdownScreen) {
            EarningBreakdownScreen earningBreakdownScreen = (EarningBreakdownScreen) obj;
            return Intrinsics.a(this.f41424a, earningBreakdownScreen.f41424a) && Intrinsics.a(this.f41425b, earningBreakdownScreen.f41425b) && Intrinsics.a(this.f41426c, earningBreakdownScreen.f41426c) && Intrinsics.a(this.f41427d, earningBreakdownScreen.f41427d);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f41424a.hashCode() * 31) + this.f41425b.hashCode()) * 31) + this.f41426c.hashCode()) * 31) + this.f41427d.hashCode();
    }

    public String toString() {
        String str = this.f41424a;
        List<DriverListItemWithNestedItems> list = this.f41425b;
        EarningBreakdownBottomSection earningBreakdownBottomSection = this.f41426c;
        EarningBreakdownPayoutSection earningBreakdownPayoutSection = this.f41427d;
        return "EarningBreakdownScreen(title=" + str + ", items=" + list + ", bottomSection=" + earningBreakdownBottomSection + ", payoutSection=" + earningBreakdownPayoutSection + ")";
    }
}
