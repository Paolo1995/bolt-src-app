package ee.mtakso.driver.network.client.score;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverScore.kt */
/* loaded from: classes3.dex */
public final class DriverScoreResponse {
    @SerializedName("score")

    /* renamed from: a  reason: collision with root package name */
    private final double f22731a;
    @SerializedName("formatted_score")

    /* renamed from: b  reason: collision with root package name */
    private final String f22732b;
    @SerializedName("labels")

    /* renamed from: c  reason: collision with root package name */
    private final List<DriverScoreLabel> f22733c;

    public final String a() {
        return this.f22732b;
    }

    public final List<DriverScoreLabel> b() {
        return this.f22733c;
    }

    public final double c() {
        return this.f22731a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverScoreResponse) {
            DriverScoreResponse driverScoreResponse = (DriverScoreResponse) obj;
            return Double.compare(this.f22731a, driverScoreResponse.f22731a) == 0 && Intrinsics.a(this.f22732b, driverScoreResponse.f22732b) && Intrinsics.a(this.f22733c, driverScoreResponse.f22733c);
        }
        return false;
    }

    public int hashCode() {
        int a8 = ((q1.a.a(this.f22731a) * 31) + this.f22732b.hashCode()) * 31;
        List<DriverScoreLabel> list = this.f22733c;
        return a8 + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        double d8 = this.f22731a;
        String str = this.f22732b;
        List<DriverScoreLabel> list = this.f22733c;
        return "DriverScoreResponse(score=" + d8 + ", formattedScore=" + str + ", labels=" + list + ")";
    }
}
