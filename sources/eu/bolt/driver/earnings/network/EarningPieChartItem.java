package eu.bolt.driver.earnings.network;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningPieChartItem.kt */
/* loaded from: classes5.dex */
public final class EarningPieChartItem {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f41447a;
    @SerializedName("subtitle")

    /* renamed from: b  reason: collision with root package name */
    private final String f41448b;
    @SerializedName("color")

    /* renamed from: c  reason: collision with root package name */
    private final DriverColor f41449c;
    @SerializedName("amount")

    /* renamed from: d  reason: collision with root package name */
    private final Double f41450d;

    public final Double a() {
        return this.f41450d;
    }

    public final DriverColor b() {
        return this.f41449c;
    }

    public final String c() {
        return this.f41448b;
    }

    public final String d() {
        return this.f41447a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EarningPieChartItem) {
            EarningPieChartItem earningPieChartItem = (EarningPieChartItem) obj;
            return Intrinsics.a(this.f41447a, earningPieChartItem.f41447a) && Intrinsics.a(this.f41448b, earningPieChartItem.f41448b) && Intrinsics.a(this.f41449c, earningPieChartItem.f41449c) && Intrinsics.a(this.f41450d, earningPieChartItem.f41450d);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.f41447a.hashCode() * 31) + this.f41448b.hashCode()) * 31) + this.f41449c.hashCode()) * 31;
        Double d8 = this.f41450d;
        return hashCode + (d8 == null ? 0 : d8.hashCode());
    }

    public String toString() {
        String str = this.f41447a;
        String str2 = this.f41448b;
        DriverColor driverColor = this.f41449c;
        Double d8 = this.f41450d;
        return "EarningPieChartItem(title=" + str + ", subtitle=" + str2 + ", color=" + driverColor + ", amount=" + d8 + ")";
    }
}
