package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;

/* compiled from: FifoQueueStateForDriverRequest.kt */
/* loaded from: classes3.dex */
public final class FifoQueueStateForDriverRequest {
    @SerializedName("driver_area_id")

    /* renamed from: a  reason: collision with root package name */
    private final long f22350a;

    public FifoQueueStateForDriverRequest(long j8) {
        this.f22350a = j8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FifoQueueStateForDriverRequest) && this.f22350a == ((FifoQueueStateForDriverRequest) obj).f22350a;
    }

    public int hashCode() {
        return i0.a.a(this.f22350a);
    }

    public String toString() {
        long j8 = this.f22350a;
        return "FifoQueueStateForDriverRequest(driverAreaId=" + j8 + ")";
    }
}
