package ee.mtakso.driver.network.client.score;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverScore.kt */
/* loaded from: classes3.dex */
public final class TipsSection {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f22761a;
    @SerializedName("subtitle")

    /* renamed from: b  reason: collision with root package name */
    private final String f22762b;
    @SerializedName("items")

    /* renamed from: c  reason: collision with root package name */
    private final List<TipItem> f22763c;

    public final List<TipItem> a() {
        return this.f22763c;
    }

    public final String b() {
        return this.f22762b;
    }

    public final String c() {
        return this.f22761a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TipsSection) {
            TipsSection tipsSection = (TipsSection) obj;
            return Intrinsics.a(this.f22761a, tipsSection.f22761a) && Intrinsics.a(this.f22762b, tipsSection.f22762b) && Intrinsics.a(this.f22763c, tipsSection.f22763c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f22761a.hashCode() * 31) + this.f22762b.hashCode()) * 31) + this.f22763c.hashCode();
    }

    public String toString() {
        String str = this.f22761a;
        String str2 = this.f22762b;
        List<TipItem> list = this.f22763c;
        return "TipsSection(title=" + str + ", subtitle=" + str2 + ", items=" + list + ")";
    }
}
