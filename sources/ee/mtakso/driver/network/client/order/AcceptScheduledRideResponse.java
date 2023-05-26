package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.order.modal.ModalWithList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AcceptScheduledRideResponse.kt */
/* loaded from: classes3.dex */
public final class AcceptScheduledRideResponse {
    @SerializedName("modal")

    /* renamed from: a  reason: collision with root package name */
    private final ModalWithList f22312a;

    public final ModalWithList a() {
        return this.f22312a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AcceptScheduledRideResponse) && Intrinsics.a(this.f22312a, ((AcceptScheduledRideResponse) obj).f22312a);
    }

    public int hashCode() {
        return this.f22312a.hashCode();
    }

    public String toString() {
        ModalWithList modalWithList = this.f22312a;
        return "AcceptScheduledRideResponse(modal=" + modalWithList + ")";
    }
}
