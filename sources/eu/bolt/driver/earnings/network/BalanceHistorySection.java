package eu.bolt.driver.earnings.network;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BalanceHistorySection.kt */
/* loaded from: classes5.dex */
public final class BalanceHistorySection {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f41332a;
    @SerializedName("items")

    /* renamed from: b  reason: collision with root package name */
    private final List<BalanceHistorySectionItem> f41333b;

    public final List<BalanceHistorySectionItem> a() {
        return this.f41333b;
    }

    public final String b() {
        return this.f41332a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BalanceHistorySection) {
            BalanceHistorySection balanceHistorySection = (BalanceHistorySection) obj;
            return Intrinsics.a(this.f41332a, balanceHistorySection.f41332a) && Intrinsics.a(this.f41333b, balanceHistorySection.f41333b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f41332a.hashCode() * 31) + this.f41333b.hashCode();
    }

    public String toString() {
        String str = this.f41332a;
        List<BalanceHistorySectionItem> list = this.f41333b;
        return "BalanceHistorySection(title=" + str + ", items=" + list + ")";
    }
}
