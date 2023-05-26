package eu.bolt.driver.earnings.network;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BalanceHistorySectionItem.kt */
/* loaded from: classes5.dex */
public final class BalanceHistorySectionItem {
    @SerializedName("list_item")

    /* renamed from: a  reason: collision with root package name */
    private final DriverListItem f41334a;
    @SerializedName("info_block")

    /* renamed from: b  reason: collision with root package name */
    private final DriverInfoBlock f41335b;

    public final DriverInfoBlock a() {
        return this.f41335b;
    }

    public final DriverListItem b() {
        return this.f41334a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BalanceHistorySectionItem) {
            BalanceHistorySectionItem balanceHistorySectionItem = (BalanceHistorySectionItem) obj;
            return Intrinsics.a(this.f41334a, balanceHistorySectionItem.f41334a) && Intrinsics.a(this.f41335b, balanceHistorySectionItem.f41335b);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f41334a.hashCode() * 31;
        DriverInfoBlock driverInfoBlock = this.f41335b;
        return hashCode + (driverInfoBlock == null ? 0 : driverInfoBlock.hashCode());
    }

    public String toString() {
        DriverListItem driverListItem = this.f41334a;
        DriverInfoBlock driverInfoBlock = this.f41335b;
        return "BalanceHistorySectionItem(listItem=" + driverListItem + ", infoBlock=" + driverInfoBlock + ")";
    }
}
