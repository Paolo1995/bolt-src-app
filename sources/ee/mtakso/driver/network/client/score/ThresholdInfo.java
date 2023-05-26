package ee.mtakso.driver.network.client.score;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.generic.HighlightType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverScore.kt */
/* loaded from: classes3.dex */
public final class ThresholdInfo {
    @SerializedName("min")

    /* renamed from: a  reason: collision with root package name */
    private final double f22756a;
    @SerializedName("max")

    /* renamed from: b  reason: collision with root package name */
    private final double f22757b;
    @SerializedName("type")

    /* renamed from: c  reason: collision with root package name */
    private final HighlightType f22758c;
    @SerializedName("thresholds")

    /* renamed from: d  reason: collision with root package name */
    private final List<Threshold> f22759d;

    public final double a() {
        return this.f22757b;
    }

    public final double b() {
        return this.f22756a;
    }

    public final List<Threshold> c() {
        return this.f22759d;
    }

    public final HighlightType d() {
        return this.f22758c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ThresholdInfo) {
            ThresholdInfo thresholdInfo = (ThresholdInfo) obj;
            return Double.compare(this.f22756a, thresholdInfo.f22756a) == 0 && Double.compare(this.f22757b, thresholdInfo.f22757b) == 0 && this.f22758c == thresholdInfo.f22758c && Intrinsics.a(this.f22759d, thresholdInfo.f22759d);
        }
        return false;
    }

    public int hashCode() {
        return (((((q1.a.a(this.f22756a) * 31) + q1.a.a(this.f22757b)) * 31) + this.f22758c.hashCode()) * 31) + this.f22759d.hashCode();
    }

    public String toString() {
        double d8 = this.f22756a;
        double d9 = this.f22757b;
        HighlightType highlightType = this.f22758c;
        List<Threshold> list = this.f22759d;
        return "ThresholdInfo(min=" + d8 + ", max=" + d9 + ", type=" + highlightType + ", thresholds=" + list + ")";
    }
}
