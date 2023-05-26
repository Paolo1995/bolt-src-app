package ee.mtakso.driver.network.client.score;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.generic.HighlightType;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverScore.kt */
/* loaded from: classes3.dex */
public final class Threshold {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f22752a;
    @SerializedName("formatted_value")

    /* renamed from: b  reason: collision with root package name */
    private final String f22753b;
    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.VALUE)

    /* renamed from: c  reason: collision with root package name */
    private final double f22754c;
    @SerializedName("type")

    /* renamed from: d  reason: collision with root package name */
    private final HighlightType f22755d;

    public final String a() {
        return this.f22753b;
    }

    public final String b() {
        return this.f22752a;
    }

    public final HighlightType c() {
        return this.f22755d;
    }

    public final double d() {
        return this.f22754c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Threshold) {
            Threshold threshold = (Threshold) obj;
            return Intrinsics.a(this.f22752a, threshold.f22752a) && Intrinsics.a(this.f22753b, threshold.f22753b) && Double.compare(this.f22754c, threshold.f22754c) == 0 && this.f22755d == threshold.f22755d;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f22752a.hashCode() * 31) + this.f22753b.hashCode()) * 31) + q1.a.a(this.f22754c)) * 31) + this.f22755d.hashCode();
    }

    public String toString() {
        String str = this.f22752a;
        String str2 = this.f22753b;
        double d8 = this.f22754c;
        HighlightType highlightType = this.f22755d;
        return "Threshold(title=" + str + ", formattedValue=" + str2 + ", value=" + d8 + ", type=" + highlightType + ")";
    }
}
