package ee.mtakso.driver.network.client.earnings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayoutHistoryResponce.kt */
/* loaded from: classes3.dex */
public final class PayoutHistoryResponce {
    @SerializedName("items")

    /* renamed from: a  reason: collision with root package name */
    private final List<PayoutHistoryItem> f22150a;

    public final List<PayoutHistoryItem> a() {
        return this.f22150a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PayoutHistoryResponce) && Intrinsics.a(this.f22150a, ((PayoutHistoryResponce) obj).f22150a);
    }

    public int hashCode() {
        return this.f22150a.hashCode();
    }

    public String toString() {
        List<PayoutHistoryItem> list = this.f22150a;
        return "PayoutHistoryResponce(items=" + list + ")";
    }
}
