package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;

/* compiled from: FifoQueueStateRequest.kt */
/* loaded from: classes3.dex */
public final class FifoQueueStateRequest {
    @SerializedName("driver_area_id")

    /* renamed from: a  reason: collision with root package name */
    private final long f22362a;

    public FifoQueueStateRequest(long j8) {
        this.f22362a = j8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FifoQueueStateRequest) && this.f22362a == ((FifoQueueStateRequest) obj).f22362a;
    }

    public int hashCode() {
        return i0.a.a(this.f22362a);
    }

    public String toString() {
        long j8 = this.f22362a;
        return "FifoQueueStateRequest(driverAreaId=" + j8 + ")";
    }
}
