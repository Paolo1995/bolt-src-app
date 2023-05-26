package ee.mtakso.driver.network.client.contact;

import com.appsflyer.AppsFlyerProperties;
import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.OrderHandle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactOptionsDetailsResponse.kt */
/* loaded from: classes3.dex */
public final class ContactOptionsDetailsRequest {
    @SerializedName(AppsFlyerProperties.CHANNEL)

    /* renamed from: a  reason: collision with root package name */
    private final String f21791a;
    @SerializedName("recipient_type")

    /* renamed from: b  reason: collision with root package name */
    private final String f21792b;
    @SerializedName("order_handle")

    /* renamed from: c  reason: collision with root package name */
    private final OrderHandle f21793c;

    public ContactOptionsDetailsRequest(String channel, String recipientType, OrderHandle orderHandle) {
        Intrinsics.f(channel, "channel");
        Intrinsics.f(recipientType, "recipientType");
        Intrinsics.f(orderHandle, "orderHandle");
        this.f21791a = channel;
        this.f21792b = recipientType;
        this.f21793c = orderHandle;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ContactOptionsDetailsRequest) {
            ContactOptionsDetailsRequest contactOptionsDetailsRequest = (ContactOptionsDetailsRequest) obj;
            return Intrinsics.a(this.f21791a, contactOptionsDetailsRequest.f21791a) && Intrinsics.a(this.f21792b, contactOptionsDetailsRequest.f21792b) && Intrinsics.a(this.f21793c, contactOptionsDetailsRequest.f21793c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f21791a.hashCode() * 31) + this.f21792b.hashCode()) * 31) + this.f21793c.hashCode();
    }

    public String toString() {
        String str = this.f21791a;
        String str2 = this.f21792b;
        OrderHandle orderHandle = this.f21793c;
        return "ContactOptionsDetailsRequest(channel=" + str + ", recipientType=" + str2 + ", orderHandle=" + orderHandle + ")";
    }
}
