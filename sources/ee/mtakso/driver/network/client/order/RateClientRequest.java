package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderDto.kt */
/* loaded from: classes3.dex */
public final class RateClientRequest {
    @SerializedName("rating")

    /* renamed from: a  reason: collision with root package name */
    private final int f22521a;
    @SerializedName("problem")

    /* renamed from: b  reason: collision with root package name */
    private final String f22522b;
    @SerializedName("comment")

    /* renamed from: c  reason: collision with root package name */
    private final String f22523c;

    public RateClientRequest(int i8, String str, String comment) {
        Intrinsics.f(comment, "comment");
        this.f22521a = i8;
        this.f22522b = str;
        this.f22523c = comment;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RateClientRequest) {
            RateClientRequest rateClientRequest = (RateClientRequest) obj;
            return this.f22521a == rateClientRequest.f22521a && Intrinsics.a(this.f22522b, rateClientRequest.f22522b) && Intrinsics.a(this.f22523c, rateClientRequest.f22523c);
        }
        return false;
    }

    public int hashCode() {
        int i8 = this.f22521a * 31;
        String str = this.f22522b;
        return ((i8 + (str == null ? 0 : str.hashCode())) * 31) + this.f22523c.hashCode();
    }

    public String toString() {
        int i8 = this.f22521a;
        String str = this.f22522b;
        String str2 = this.f22523c;
        return "RateClientRequest(rating=" + i8 + ", problem=" + str + ", comment=" + str2 + ")";
    }
}
