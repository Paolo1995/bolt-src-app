package eu.bolt.driver.earnings.network;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BalanceHistory.kt */
/* loaded from: classes5.dex */
public final class BalanceHistory {
    @SerializedName("page")

    /* renamed from: a  reason: collision with root package name */
    private final String f41330a;
    @SerializedName("sections")

    /* renamed from: b  reason: collision with root package name */
    private final List<BalanceHistorySection> f41331b;

    public final String a() {
        return this.f41330a;
    }

    public final List<BalanceHistorySection> b() {
        return this.f41331b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BalanceHistory) {
            BalanceHistory balanceHistory = (BalanceHistory) obj;
            return Intrinsics.a(this.f41330a, balanceHistory.f41330a) && Intrinsics.a(this.f41331b, balanceHistory.f41331b);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f41330a;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.f41331b.hashCode();
    }

    public String toString() {
        String str = this.f41330a;
        List<BalanceHistorySection> list = this.f41331b;
        return "BalanceHistory(page=" + str + ", sections=" + list + ")";
    }
}
