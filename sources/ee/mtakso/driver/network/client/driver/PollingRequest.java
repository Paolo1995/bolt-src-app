package ee.mtakso.driver.network.client.driver;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.OrderHandle;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Polling.kt */
/* loaded from: classes3.dex */
public final class PollingRequest {
    @SerializedName("include_orders")

    /* renamed from: a  reason: collision with root package name */
    private final List<OrderHandle> f21976a;
    @SerializedName("app_state")

    /* renamed from: b  reason: collision with root package name */
    private final String f21977b;

    public PollingRequest(List<OrderHandle> list, String appState) {
        Intrinsics.f(appState, "appState");
        this.f21976a = list;
        this.f21977b = appState;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PollingRequest) {
            PollingRequest pollingRequest = (PollingRequest) obj;
            return Intrinsics.a(this.f21976a, pollingRequest.f21976a) && Intrinsics.a(this.f21977b, pollingRequest.f21977b);
        }
        return false;
    }

    public int hashCode() {
        List<OrderHandle> list = this.f21976a;
        return ((list == null ? 0 : list.hashCode()) * 31) + this.f21977b.hashCode();
    }

    public String toString() {
        List<OrderHandle> list = this.f21976a;
        String str = this.f21977b;
        return "PollingRequest(includeOrder=" + list + ", appState=" + str + ")";
    }
}
