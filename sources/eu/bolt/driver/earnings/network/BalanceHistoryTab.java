package eu.bolt.driver.earnings.network;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: BalanceHistoryTab.kt */
/* loaded from: classes5.dex */
public final class BalanceHistoryTab {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f41336a;
    @SerializedName(Name.MARK)

    /* renamed from: b  reason: collision with root package name */
    private final String f41337b;
    @SerializedName("is_default")

    /* renamed from: c  reason: collision with root package name */
    private final boolean f41338c;

    public final String a() {
        return this.f41337b;
    }

    public final String b() {
        return this.f41336a;
    }

    public final boolean c() {
        return this.f41338c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BalanceHistoryTab) {
            BalanceHistoryTab balanceHistoryTab = (BalanceHistoryTab) obj;
            return Intrinsics.a(this.f41336a, balanceHistoryTab.f41336a) && Intrinsics.a(this.f41337b, balanceHistoryTab.f41337b) && this.f41338c == balanceHistoryTab.f41338c;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f41336a.hashCode() * 31) + this.f41337b.hashCode()) * 31;
        boolean z7 = this.f41338c;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode + i8;
    }

    public String toString() {
        String str = this.f41336a;
        String str2 = this.f41337b;
        boolean z7 = this.f41338c;
        return "BalanceHistoryTab(title=" + str + ", id=" + str2 + ", isDefault=" + z7 + ")";
    }
}
