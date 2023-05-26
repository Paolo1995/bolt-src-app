package ee.mtakso.driver.network.client.driver;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.OrderHandle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Driver.kt */
/* loaded from: classes3.dex */
public final class SearchClientDestinationRequest {
    @SerializedName("order_handle")

    /* renamed from: a  reason: collision with root package name */
    private final OrderHandle f22009a;
    @SerializedName("search_string")

    /* renamed from: b  reason: collision with root package name */
    private final String f22010b;
    @SerializedName("lat")

    /* renamed from: c  reason: collision with root package name */
    private final double f22011c;
    @SerializedName("lng")

    /* renamed from: d  reason: collision with root package name */
    private final double f22012d;

    public SearchClientDestinationRequest(OrderHandle orderHandle, String query, double d8, double d9) {
        Intrinsics.f(orderHandle, "orderHandle");
        Intrinsics.f(query, "query");
        this.f22009a = orderHandle;
        this.f22010b = query;
        this.f22011c = d8;
        this.f22012d = d9;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SearchClientDestinationRequest) {
            SearchClientDestinationRequest searchClientDestinationRequest = (SearchClientDestinationRequest) obj;
            return Intrinsics.a(this.f22009a, searchClientDestinationRequest.f22009a) && Intrinsics.a(this.f22010b, searchClientDestinationRequest.f22010b) && Double.compare(this.f22011c, searchClientDestinationRequest.f22011c) == 0 && Double.compare(this.f22012d, searchClientDestinationRequest.f22012d) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f22009a.hashCode() * 31) + this.f22010b.hashCode()) * 31) + q1.a.a(this.f22011c)) * 31) + q1.a.a(this.f22012d);
    }

    public String toString() {
        OrderHandle orderHandle = this.f22009a;
        String str = this.f22010b;
        double d8 = this.f22011c;
        double d9 = this.f22012d;
        return "SearchClientDestinationRequest(orderHandle=" + orderHandle + ", query=" + str + ", lat=" + d8 + ", lng=" + d9 + ")";
    }
}
