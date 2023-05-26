package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderDto.kt */
/* loaded from: classes3.dex */
public final class RejectReasonInfo {
    @SerializedName("type")

    /* renamed from: a  reason: collision with root package name */
    private final String f22536a;
    @SerializedName("input")

    /* renamed from: b  reason: collision with root package name */
    private final String f22537b;

    public RejectReasonInfo(String type, String str) {
        Intrinsics.f(type, "type");
        this.f22536a = type;
        this.f22537b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RejectReasonInfo) {
            RejectReasonInfo rejectReasonInfo = (RejectReasonInfo) obj;
            return Intrinsics.a(this.f22536a, rejectReasonInfo.f22536a) && Intrinsics.a(this.f22537b, rejectReasonInfo.f22537b);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f22536a.hashCode() * 31;
        String str = this.f22537b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.f22536a;
        String str2 = this.f22537b;
        return "RejectReasonInfo(type=" + str + ", inputValue=" + str2 + ")";
    }
}
