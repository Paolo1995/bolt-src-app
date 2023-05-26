package ee.mtakso.driver.network.client.earnings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayoutResponce.kt */
/* loaded from: classes3.dex */
public final class ProgressSection {
    @SerializedName("items")

    /* renamed from: a  reason: collision with root package name */
    private final List<ProgressItem> f22163a;
    @SerializedName("comment")

    /* renamed from: b  reason: collision with root package name */
    private final String f22164b;

    public final List<ProgressItem> a() {
        return this.f22163a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ProgressSection) {
            ProgressSection progressSection = (ProgressSection) obj;
            return Intrinsics.a(this.f22163a, progressSection.f22163a) && Intrinsics.a(this.f22164b, progressSection.f22164b);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f22163a.hashCode() * 31;
        String str = this.f22164b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        List<ProgressItem> list = this.f22163a;
        String str = this.f22164b;
        return "ProgressSection(items=" + list + ", comment=" + str + ")";
    }
}
