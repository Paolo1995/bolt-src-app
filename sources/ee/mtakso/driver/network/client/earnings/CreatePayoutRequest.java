package ee.mtakso.driver.network.client.earnings;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CreatePayoutRequest.kt */
/* loaded from: classes3.dex */
public final class CreatePayoutRequest {
    @SerializedName("confirmation_id")

    /* renamed from: a  reason: collision with root package name */
    private final String f22089a;

    public CreatePayoutRequest(String confirmationId) {
        Intrinsics.f(confirmationId, "confirmationId");
        this.f22089a = confirmationId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CreatePayoutRequest) && Intrinsics.a(this.f22089a, ((CreatePayoutRequest) obj).f22089a);
    }

    public int hashCode() {
        return this.f22089a.hashCode();
    }

    public String toString() {
        String str = this.f22089a;
        return "CreatePayoutRequest(confirmationId=" + str + ")";
    }
}
