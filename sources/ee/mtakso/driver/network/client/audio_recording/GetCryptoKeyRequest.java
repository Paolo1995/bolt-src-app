package ee.mtakso.driver.network.client.audio_recording;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.OrderHandle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetCryptoKeyRequest.kt */
/* loaded from: classes3.dex */
public final class GetCryptoKeyRequest {
    @SerializedName("order_handle")

    /* renamed from: a  reason: collision with root package name */
    private final OrderHandle f21381a;

    public GetCryptoKeyRequest(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        this.f21381a = orderHandle;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetCryptoKeyRequest) && Intrinsics.a(this.f21381a, ((GetCryptoKeyRequest) obj).f21381a);
    }

    public int hashCode() {
        return this.f21381a.hashCode();
    }

    public String toString() {
        OrderHandle orderHandle = this.f21381a;
        return "GetCryptoKeyRequest(orderHandle=" + orderHandle + ")";
    }
}
