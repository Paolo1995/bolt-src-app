package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderDto.kt */
/* loaded from: classes3.dex */
public final class RejectOrderResponse {
    @SerializedName("type")

    /* renamed from: a  reason: collision with root package name */
    private final RejectResponseType f22530a;
    @SerializedName("reasons")

    /* renamed from: b  reason: collision with root package name */
    private final List<RejectReason> f22531b;
    @SerializedName("confirmation_message_html")

    /* renamed from: c  reason: collision with root package name */
    private final String f22532c;

    public final String a() {
        return this.f22532c;
    }

    public final List<RejectReason> b() {
        return this.f22531b;
    }

    public final RejectResponseType c() {
        return this.f22530a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RejectOrderResponse) {
            RejectOrderResponse rejectOrderResponse = (RejectOrderResponse) obj;
            return this.f22530a == rejectOrderResponse.f22530a && Intrinsics.a(this.f22531b, rejectOrderResponse.f22531b) && Intrinsics.a(this.f22532c, rejectOrderResponse.f22532c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f22530a.hashCode() * 31;
        List<RejectReason> list = this.f22531b;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.f22532c;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        RejectResponseType rejectResponseType = this.f22530a;
        List<RejectReason> list = this.f22531b;
        String str = this.f22532c;
        return "RejectOrderResponse(type=" + rejectResponseType + ", reasonList=" + list + ", confirmationMessageHtml=" + str + ")";
    }
}
