package ee.mtakso.driver.network.client.earnings;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayToBoltResponse.kt */
/* loaded from: classes3.dex */
public final class PayToBoltResponse {
    @SerializedName("get_payment_link_url")

    /* renamed from: a  reason: collision with root package name */
    private final String f22120a;
    @SerializedName("pending_payments_message")

    /* renamed from: b  reason: collision with root package name */
    private final String f22121b;
    @SerializedName("to_pay")

    /* renamed from: c  reason: collision with root package name */
    private final ToPay f22122c;

    public final ToPay a() {
        return this.f22122c;
    }

    public final String b() {
        return this.f22120a;
    }

    public final String c() {
        return this.f22121b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PayToBoltResponse) {
            PayToBoltResponse payToBoltResponse = (PayToBoltResponse) obj;
            return Intrinsics.a(this.f22120a, payToBoltResponse.f22120a) && Intrinsics.a(this.f22121b, payToBoltResponse.f22121b) && Intrinsics.a(this.f22122c, payToBoltResponse.f22122c);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f22120a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f22121b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        ToPay toPay = this.f22122c;
        return hashCode2 + (toPay != null ? toPay.hashCode() : 0);
    }

    public String toString() {
        String str = this.f22120a;
        String str2 = this.f22121b;
        ToPay toPay = this.f22122c;
        return "PayToBoltResponse(paymentLinkUrl=" + str + ", pendingMessage=" + str2 + ", amountToPay=" + toPay + ")";
    }
}
