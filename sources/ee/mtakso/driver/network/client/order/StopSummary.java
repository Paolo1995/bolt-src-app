package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderDto.kt */
/* loaded from: classes3.dex */
public final class StopSummary {
    @SerializedName("wait_time_sec")

    /* renamed from: a  reason: collision with root package name */
    private final long f22598a;
    @SerializedName("price_str")

    /* renamed from: b  reason: collision with root package name */
    private final String f22599b;
    @SerializedName("poll_interval_sec")

    /* renamed from: c  reason: collision with root package name */
    private final int f22600c;

    public final String a() {
        return this.f22599b;
    }

    public final int b() {
        return this.f22600c;
    }

    public final long c() {
        return this.f22598a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StopSummary) {
            StopSummary stopSummary = (StopSummary) obj;
            return this.f22598a == stopSummary.f22598a && Intrinsics.a(this.f22599b, stopSummary.f22599b) && this.f22600c == stopSummary.f22600c;
        }
        return false;
    }

    public int hashCode() {
        return (((i0.a.a(this.f22598a) * 31) + this.f22599b.hashCode()) * 31) + this.f22600c;
    }

    public String toString() {
        long j8 = this.f22598a;
        String str = this.f22599b;
        int i8 = this.f22600c;
        return "StopSummary(waitTime=" + j8 + ", price=" + str + ", summaryTtl=" + i8 + ")";
    }
}
