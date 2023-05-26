package ee.mtakso.driver.network.client.score;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverScore.kt */
/* loaded from: classes3.dex */
public final class DriverScoreExplanationResponse {
    @SerializedName("html_content")

    /* renamed from: a  reason: collision with root package name */
    private final String f22723a;

    public final String a() {
        return this.f22723a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DriverScoreExplanationResponse) && Intrinsics.a(this.f22723a, ((DriverScoreExplanationResponse) obj).f22723a);
    }

    public int hashCode() {
        return this.f22723a.hashCode();
    }

    public String toString() {
        String str = this.f22723a;
        return "DriverScoreExplanationResponse(htmlContent=" + str + ")";
    }
}
