package ee.mtakso.driver.network.client.driver;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Polling.kt */
/* loaded from: classes3.dex */
public final class PollingResult {
    @SerializedName("driver_state")

    /* renamed from: a  reason: collision with root package name */
    private final DriverStatus f21978a;
    @SerializedName("take_new_orders_during_order")

    /* renamed from: b  reason: collision with root package name */
    private final Boolean f21979b;
    @SerializedName("max_client_distance")

    /* renamed from: c  reason: collision with root package name */
    private final Double f21980c;
    @SerializedName("orders")

    /* renamed from: d  reason: collision with root package name */
    private final List<OrderSummary> f21981d;
    @SerializedName("queue")

    /* renamed from: e  reason: collision with root package name */
    private final List<Object> f21982e;
    @SerializedName("driver_destination_id")

    /* renamed from: f  reason: collision with root package name */
    private final Long f21983f;
    @SerializedName("messages")

    /* renamed from: g  reason: collision with root package name */
    private final List<PollMessage> f21984g;
    @SerializedName("categories_hash")

    /* renamed from: h  reason: collision with root package name */
    private final String f21985h;
    @SerializedName("emergency_assist_provider_hash")

    /* renamed from: i  reason: collision with root package name */
    private final String f21986i;
    @SerializedName("poll_interval_sec")

    /* renamed from: j  reason: collision with root package name */
    private final Float f21987j;
    @SerializedName("fifo_queue_state_invalidation_key")

    /* renamed from: k  reason: collision with root package name */
    private final String f21988k;
    @SerializedName("fifo_queue_state_for_driver_invalidation_key")

    /* renamed from: l  reason: collision with root package name */
    private final String f21989l;

    public final String a() {
        return this.f21985h;
    }

    public final Long b() {
        return this.f21983f;
    }

    public final DriverStatus c() {
        return this.f21978a;
    }

    public final String d() {
        return this.f21986i;
    }

    public final String e() {
        return this.f21989l;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PollingResult) {
            PollingResult pollingResult = (PollingResult) obj;
            return this.f21978a == pollingResult.f21978a && Intrinsics.a(this.f21979b, pollingResult.f21979b) && Intrinsics.a(this.f21980c, pollingResult.f21980c) && Intrinsics.a(this.f21981d, pollingResult.f21981d) && Intrinsics.a(this.f21982e, pollingResult.f21982e) && Intrinsics.a(this.f21983f, pollingResult.f21983f) && Intrinsics.a(this.f21984g, pollingResult.f21984g) && Intrinsics.a(this.f21985h, pollingResult.f21985h) && Intrinsics.a(this.f21986i, pollingResult.f21986i) && Intrinsics.a(this.f21987j, pollingResult.f21987j) && Intrinsics.a(this.f21988k, pollingResult.f21988k) && Intrinsics.a(this.f21989l, pollingResult.f21989l);
        }
        return false;
    }

    public final String f() {
        return this.f21988k;
    }

    public final Float g() {
        return this.f21987j;
    }

    public final Double h() {
        return this.f21980c;
    }

    public int hashCode() {
        int hashCode = this.f21978a.hashCode() * 31;
        Boolean bool = this.f21979b;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Double d8 = this.f21980c;
        int hashCode3 = (hashCode2 + (d8 == null ? 0 : d8.hashCode())) * 31;
        List<OrderSummary> list = this.f21981d;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        List<Object> list2 = this.f21982e;
        int hashCode5 = (hashCode4 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Long l8 = this.f21983f;
        int hashCode6 = (hashCode5 + (l8 == null ? 0 : l8.hashCode())) * 31;
        List<PollMessage> list3 = this.f21984g;
        int hashCode7 = (hashCode6 + (list3 == null ? 0 : list3.hashCode())) * 31;
        String str = this.f21985h;
        int hashCode8 = (((hashCode7 + (str == null ? 0 : str.hashCode())) * 31) + this.f21986i.hashCode()) * 31;
        Float f8 = this.f21987j;
        int hashCode9 = (hashCode8 + (f8 == null ? 0 : f8.hashCode())) * 31;
        String str2 = this.f21988k;
        int hashCode10 = (hashCode9 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f21989l;
        return hashCode10 + (str3 != null ? str3.hashCode() : 0);
    }

    public final List<PollMessage> i() {
        return this.f21984g;
    }

    public final List<OrderSummary> j() {
        return this.f21981d;
    }

    public final Boolean k() {
        return this.f21979b;
    }

    public String toString() {
        DriverStatus driverStatus = this.f21978a;
        Boolean bool = this.f21979b;
        Double d8 = this.f21980c;
        List<OrderSummary> list = this.f21981d;
        List<Object> list2 = this.f21982e;
        Long l8 = this.f21983f;
        List<PollMessage> list3 = this.f21984g;
        String str = this.f21985h;
        String str2 = this.f21986i;
        Float f8 = this.f21987j;
        String str3 = this.f21988k;
        String str4 = this.f21989l;
        return "PollingResult(driverState=" + driverStatus + ", takeNewOrdersDuringOrder=" + bool + ", maxClientDistance=" + d8 + ", orderSummaries=" + list + ", orderQueue=" + list2 + ", driverDestinationId=" + l8 + ", messages=" + list3 + ", categoriesHash=" + str + ", emergencyAssistProviderHash=" + str2 + ", interval=" + f8 + ", fifoQueueStateInvalidationKey=" + str3 + ", fifoQueueStateForDriverInvalidationKey=" + str4 + ")";
    }
}
