package ee.mtakso.driver.network.client.earnings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReportInterval.kt */
/* loaded from: classes3.dex */
public final class ReportIntervals {
    @SerializedName("items")

    /* renamed from: a  reason: collision with root package name */
    private final List<Interval> f22165a;

    public final List<Interval> a() {
        return this.f22165a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ReportIntervals) && Intrinsics.a(this.f22165a, ((ReportIntervals) obj).f22165a);
    }

    public int hashCode() {
        return this.f22165a.hashCode();
    }

    public String toString() {
        List<Interval> list = this.f22165a;
        return "ReportIntervals(items=" + list + ")";
    }
}
