package ee.mtakso.driver.network.client.contact;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.OrderHandle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AvailableContactOptions.kt */
/* loaded from: classes3.dex */
public final class AvailableContactOptionsRequest {
    @SerializedName("use_case")

    /* renamed from: a  reason: collision with root package name */
    private final ContactOptionsUseCase f21755a;
    @SerializedName("order_handle")

    /* renamed from: b  reason: collision with root package name */
    private final OrderHandle f21756b;

    public AvailableContactOptionsRequest(ContactOptionsUseCase useCase, OrderHandle orderHandle) {
        Intrinsics.f(useCase, "useCase");
        Intrinsics.f(orderHandle, "orderHandle");
        this.f21755a = useCase;
        this.f21756b = orderHandle;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AvailableContactOptionsRequest) {
            AvailableContactOptionsRequest availableContactOptionsRequest = (AvailableContactOptionsRequest) obj;
            return this.f21755a == availableContactOptionsRequest.f21755a && Intrinsics.a(this.f21756b, availableContactOptionsRequest.f21756b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f21755a.hashCode() * 31) + this.f21756b.hashCode();
    }

    public String toString() {
        ContactOptionsUseCase contactOptionsUseCase = this.f21755a;
        OrderHandle orderHandle = this.f21756b;
        return "AvailableContactOptionsRequest(useCase=" + contactOptionsUseCase + ", orderHandle=" + orderHandle + ")";
    }
}
