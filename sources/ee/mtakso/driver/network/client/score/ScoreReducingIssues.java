package ee.mtakso.driver.network.client.score;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverScore.kt */
/* loaded from: classes3.dex */
public final class ScoreReducingIssues {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f22750a;
    @SerializedName("items")

    /* renamed from: b  reason: collision with root package name */
    private final List<IssueGroup> f22751b;

    public final List<IssueGroup> a() {
        return this.f22751b;
    }

    public final String b() {
        return this.f22750a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ScoreReducingIssues) {
            ScoreReducingIssues scoreReducingIssues = (ScoreReducingIssues) obj;
            return Intrinsics.a(this.f22750a, scoreReducingIssues.f22750a) && Intrinsics.a(this.f22751b, scoreReducingIssues.f22751b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f22750a.hashCode() * 31) + this.f22751b.hashCode();
    }

    public String toString() {
        String str = this.f22750a;
        List<IssueGroup> list = this.f22751b;
        return "ScoreReducingIssues(title=" + str + ", items=" + list + ")";
    }
}
