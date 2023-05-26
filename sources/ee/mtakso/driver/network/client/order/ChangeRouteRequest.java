package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.OrderHandle;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChangeRouteRequest.kt */
/* loaded from: classes3.dex */
public final class ChangeRouteRequest {
    @SerializedName("order_handle")

    /* renamed from: a  reason: collision with root package name */
    private final OrderHandle f22323a;
    @SerializedName("destination_stops")

    /* renamed from: b  reason: collision with root package name */
    private final List<DestinationStop> f22324b;

    /* compiled from: ChangeRouteRequest.kt */
    /* loaded from: classes3.dex */
    public static final class DestinationStop {
        @SerializedName("address")

        /* renamed from: a  reason: collision with root package name */
        private final String f22325a;
        @SerializedName("lat")

        /* renamed from: b  reason: collision with root package name */
        private final double f22326b;
        @SerializedName("lng")

        /* renamed from: c  reason: collision with root package name */
        private final double f22327c;

        public DestinationStop(String str, double d8, double d9) {
            this.f22325a = str;
            this.f22326b = d8;
            this.f22327c = d9;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DestinationStop) {
                DestinationStop destinationStop = (DestinationStop) obj;
                return Intrinsics.a(this.f22325a, destinationStop.f22325a) && Double.compare(this.f22326b, destinationStop.f22326b) == 0 && Double.compare(this.f22327c, destinationStop.f22327c) == 0;
            }
            return false;
        }

        public int hashCode() {
            String str = this.f22325a;
            return ((((str == null ? 0 : str.hashCode()) * 31) + q1.a.a(this.f22326b)) * 31) + q1.a.a(this.f22327c);
        }

        public String toString() {
            String str = this.f22325a;
            double d8 = this.f22326b;
            double d9 = this.f22327c;
            return "DestinationStop(address=" + str + ", lat=" + d8 + ", lng=" + d9 + ")";
        }
    }

    public ChangeRouteRequest(OrderHandle orderHandle, List<DestinationStop> destinationStops) {
        Intrinsics.f(orderHandle, "orderHandle");
        Intrinsics.f(destinationStops, "destinationStops");
        this.f22323a = orderHandle;
        this.f22324b = destinationStops;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChangeRouteRequest) {
            ChangeRouteRequest changeRouteRequest = (ChangeRouteRequest) obj;
            return Intrinsics.a(this.f22323a, changeRouteRequest.f22323a) && Intrinsics.a(this.f22324b, changeRouteRequest.f22324b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f22323a.hashCode() * 31) + this.f22324b.hashCode();
    }

    public String toString() {
        OrderHandle orderHandle = this.f22323a;
        List<DestinationStop> list = this.f22324b;
        return "ChangeRouteRequest(orderHandle=" + orderHandle + ", destinationStops=" + list + ")";
    }
}
