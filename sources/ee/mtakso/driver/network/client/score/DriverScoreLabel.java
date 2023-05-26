package ee.mtakso.driver.network.client.score;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.generic.HighlightType;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverScore.kt */
/* loaded from: classes3.dex */
public final class DriverScoreLabel {
    @SerializedName("text")

    /* renamed from: a  reason: collision with root package name */
    private final String f22724a;
    @SerializedName("type")

    /* renamed from: b  reason: collision with root package name */
    private final HighlightType f22725b;

    public final String a() {
        return this.f22724a;
    }

    public final HighlightType b() {
        return this.f22725b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverScoreLabel) {
            DriverScoreLabel driverScoreLabel = (DriverScoreLabel) obj;
            return Intrinsics.a(this.f22724a, driverScoreLabel.f22724a) && this.f22725b == driverScoreLabel.f22725b;
        }
        return false;
    }

    public int hashCode() {
        return (this.f22724a.hashCode() * 31) + this.f22725b.hashCode();
    }

    public String toString() {
        String str = this.f22724a;
        HighlightType highlightType = this.f22725b;
        return "DriverScoreLabel(text=" + str + ", type=" + highlightType + ")";
    }
}
