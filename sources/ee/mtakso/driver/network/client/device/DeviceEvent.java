package ee.mtakso.driver.network.client.device;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceEvent.kt */
/* loaded from: classes3.dex */
public final class DeviceEvent {
    @SerializedName("event")

    /* renamed from: a  reason: collision with root package name */
    private final String f21865a;
    @SerializedName("reason")

    /* renamed from: b  reason: collision with root package name */
    private final DriverAppDisabledReason f21866b;
    @SerializedName("order_id")

    /* renamed from: c  reason: collision with root package name */
    private final Long f21867c;
    @SerializedName("order_try_id")

    /* renamed from: d  reason: collision with root package name */
    private final Long f21868d;

    public DeviceEvent(String event, DriverAppDisabledReason reason, Long l8, Long l9) {
        Intrinsics.f(event, "event");
        Intrinsics.f(reason, "reason");
        this.f21865a = event;
        this.f21866b = reason;
        this.f21867c = l8;
        this.f21868d = l9;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DeviceEvent) {
            DeviceEvent deviceEvent = (DeviceEvent) obj;
            return Intrinsics.a(this.f21865a, deviceEvent.f21865a) && this.f21866b == deviceEvent.f21866b && Intrinsics.a(this.f21867c, deviceEvent.f21867c) && Intrinsics.a(this.f21868d, deviceEvent.f21868d);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f21865a.hashCode() * 31) + this.f21866b.hashCode()) * 31;
        Long l8 = this.f21867c;
        int hashCode2 = (hashCode + (l8 == null ? 0 : l8.hashCode())) * 31;
        Long l9 = this.f21868d;
        return hashCode2 + (l9 != null ? l9.hashCode() : 0);
    }

    public String toString() {
        String str = this.f21865a;
        DriverAppDisabledReason driverAppDisabledReason = this.f21866b;
        Long l8 = this.f21867c;
        Long l9 = this.f21868d;
        return "DeviceEvent(event=" + str + ", reason=" + driverAppDisabledReason + ", orderId=" + l8 + ", orderTryId=" + l9 + ")";
    }
}
