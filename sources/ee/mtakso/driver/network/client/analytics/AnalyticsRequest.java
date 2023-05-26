package ee.mtakso.driver.network.client.analytics;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnalyticsRequest.kt */
/* loaded from: classes3.dex */
public final class AnalyticsRequest {
    @SerializedName("type")

    /* renamed from: a  reason: collision with root package name */
    private final String f21355a;
    @SerializedName("data")

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Object> f21356b;

    public AnalyticsRequest(String type, Map<String, ? extends Object> data) {
        Intrinsics.f(type, "type");
        Intrinsics.f(data, "data");
        this.f21355a = type;
        this.f21356b = data;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AnalyticsRequest) {
            AnalyticsRequest analyticsRequest = (AnalyticsRequest) obj;
            return Intrinsics.a(this.f21355a, analyticsRequest.f21355a) && Intrinsics.a(this.f21356b, analyticsRequest.f21356b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f21355a.hashCode() * 31) + this.f21356b.hashCode();
    }

    public String toString() {
        String str = this.f21355a;
        Map<String, Object> map = this.f21356b;
        return "AnalyticsRequest(type=" + str + ", data=" + map + ")";
    }
}
