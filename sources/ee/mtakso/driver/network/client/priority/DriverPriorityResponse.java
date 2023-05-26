package ee.mtakso.driver.network.client.priority;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.generic.InformationMessage;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverPriorityResponse.kt */
/* loaded from: classes3.dex */
public final class DriverPriorityResponse {
    @SerializedName("summary")

    /* renamed from: a  reason: collision with root package name */
    private final PrioritySummary f22676a;
    @SerializedName("information_message")

    /* renamed from: b  reason: collision with root package name */
    private final InformationMessage f22677b;
    @SerializedName("preconditions")

    /* renamed from: c  reason: collision with root package name */
    private final PreconditionSection f22678c;
    @SerializedName("priority_components")

    /* renamed from: d  reason: collision with root package name */
    private final PriorityComponentsSection f22679d;

    public final InformationMessage a() {
        return this.f22677b;
    }

    public final PreconditionSection b() {
        return this.f22678c;
    }

    public final PriorityComponentsSection c() {
        return this.f22679d;
    }

    public final PrioritySummary d() {
        return this.f22676a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverPriorityResponse) {
            DriverPriorityResponse driverPriorityResponse = (DriverPriorityResponse) obj;
            return Intrinsics.a(this.f22676a, driverPriorityResponse.f22676a) && Intrinsics.a(this.f22677b, driverPriorityResponse.f22677b) && Intrinsics.a(this.f22678c, driverPriorityResponse.f22678c) && Intrinsics.a(this.f22679d, driverPriorityResponse.f22679d);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f22676a.hashCode() * 31;
        InformationMessage informationMessage = this.f22677b;
        return ((((hashCode + (informationMessage == null ? 0 : informationMessage.hashCode())) * 31) + this.f22678c.hashCode()) * 31) + this.f22679d.hashCode();
    }

    public String toString() {
        PrioritySummary prioritySummary = this.f22676a;
        InformationMessage informationMessage = this.f22677b;
        PreconditionSection preconditionSection = this.f22678c;
        PriorityComponentsSection priorityComponentsSection = this.f22679d;
        return "DriverPriorityResponse(summary=" + prioritySummary + ", informationMessage=" + informationMessage + ", preconditions=" + preconditionSection + ", priorityComponents=" + priorityComponentsSection + ")";
    }
}
