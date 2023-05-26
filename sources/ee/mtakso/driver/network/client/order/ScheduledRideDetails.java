package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/* compiled from: ScheduledRideDetails.kt */
/* loaded from: classes3.dex */
public final class ScheduledRideDetails {
    @SerializedName("toolbar_title")

    /* renamed from: a  reason: collision with root package name */
    private final String f22553a;
    @SerializedName("components")

    /* renamed from: b  reason: collision with root package name */
    private final List<ScheduledRideDetailsComponent> f22554b;
    @SerializedName("primary_action")

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledRideDetailsComponent f22555c;
    @SerializedName("detail_label_types")

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, RideDetailLabelTypeInfo> f22556d;

    public final List<ScheduledRideDetailsComponent> a() {
        return this.f22554b;
    }

    public final Map<String, RideDetailLabelTypeInfo> b() {
        return this.f22556d;
    }

    public final ScheduledRideDetailsComponent c() {
        return this.f22555c;
    }

    public final String d() {
        return this.f22553a;
    }
}
