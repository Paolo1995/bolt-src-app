package eu.bolt.driver.earnings.network;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BalanceScreen.kt */
/* loaded from: classes5.dex */
public final class BalanceScreen {
    @SerializedName("faq_url")

    /* renamed from: a  reason: collision with root package name */
    private final String f41339a;
    @SerializedName("header")

    /* renamed from: b  reason: collision with root package name */
    private final BalanceHeader f41340b;
    @SerializedName("history_section_title")

    /* renamed from: c  reason: collision with root package name */
    private final String f41341c;
    @SerializedName("history_sections")

    /* renamed from: d  reason: collision with root package name */
    private final List<BalanceHistoryTab> f41342d;

    public final String a() {
        return this.f41339a;
    }

    public final BalanceHeader b() {
        return this.f41340b;
    }

    public final String c() {
        return this.f41341c;
    }

    public final List<BalanceHistoryTab> d() {
        return this.f41342d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BalanceScreen) {
            BalanceScreen balanceScreen = (BalanceScreen) obj;
            return Intrinsics.a(this.f41339a, balanceScreen.f41339a) && Intrinsics.a(this.f41340b, balanceScreen.f41340b) && Intrinsics.a(this.f41341c, balanceScreen.f41341c) && Intrinsics.a(this.f41342d, balanceScreen.f41342d);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f41339a.hashCode() * 31) + this.f41340b.hashCode()) * 31;
        String str = this.f41341c;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f41342d.hashCode();
    }

    public String toString() {
        String str = this.f41339a;
        BalanceHeader balanceHeader = this.f41340b;
        String str2 = this.f41341c;
        List<BalanceHistoryTab> list = this.f41342d;
        return "BalanceScreen(faqUrl=" + str + ", header=" + balanceHeader + ", historySectionTitle=" + str2 + ", historySections=" + list + ")";
    }
}
