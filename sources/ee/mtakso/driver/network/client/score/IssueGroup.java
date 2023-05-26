package ee.mtakso.driver.network.client.score;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverScore.kt */
/* loaded from: classes3.dex */
public final class IssueGroup {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f22734a;
    @SerializedName("subtitle")

    /* renamed from: b  reason: collision with root package name */
    private final String f22735b;
    @SerializedName("items")

    /* renamed from: c  reason: collision with root package name */
    private final List<IssueItem> f22736c;

    public final List<IssueItem> a() {
        return this.f22736c;
    }

    public final String b() {
        return this.f22735b;
    }

    public final String c() {
        return this.f22734a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IssueGroup) {
            IssueGroup issueGroup = (IssueGroup) obj;
            return Intrinsics.a(this.f22734a, issueGroup.f22734a) && Intrinsics.a(this.f22735b, issueGroup.f22735b) && Intrinsics.a(this.f22736c, issueGroup.f22736c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f22734a.hashCode() * 31) + this.f22735b.hashCode()) * 31;
        List<IssueItem> list = this.f22736c;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        String str = this.f22734a;
        String str2 = this.f22735b;
        List<IssueItem> list = this.f22736c;
        return "IssueGroup(title=" + str + ", subtitle=" + str2 + ", items=" + list + ")";
    }
}
