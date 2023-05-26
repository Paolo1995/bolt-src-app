package ee.mtakso.driver.network.client.earnings;

import com.google.gson.annotations.SerializedName;
import i0.a;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: PayoutHistoryResponce.kt */
/* loaded from: classes3.dex */
public final class PayoutHistoryItem {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final long f22145a;
    @SerializedName("label")

    /* renamed from: b  reason: collision with root package name */
    private final String f22146b;
    @SerializedName("date")

    /* renamed from: c  reason: collision with root package name */
    private final String f22147c;
    @SerializedName("amount")

    /* renamed from: d  reason: collision with root package name */
    private final String f22148d;
    @SerializedName("state")

    /* renamed from: e  reason: collision with root package name */
    private final PayoutState f22149e;

    public final String a() {
        return this.f22148d;
    }

    public final String b() {
        return this.f22147c;
    }

    public final long c() {
        return this.f22145a;
    }

    public final String d() {
        return this.f22146b;
    }

    public final PayoutState e() {
        return this.f22149e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PayoutHistoryItem) {
            PayoutHistoryItem payoutHistoryItem = (PayoutHistoryItem) obj;
            return this.f22145a == payoutHistoryItem.f22145a && Intrinsics.a(this.f22146b, payoutHistoryItem.f22146b) && Intrinsics.a(this.f22147c, payoutHistoryItem.f22147c) && Intrinsics.a(this.f22148d, payoutHistoryItem.f22148d) && this.f22149e == payoutHistoryItem.f22149e;
        }
        return false;
    }

    public int hashCode() {
        return (((((((a.a(this.f22145a) * 31) + this.f22146b.hashCode()) * 31) + this.f22147c.hashCode()) * 31) + this.f22148d.hashCode()) * 31) + this.f22149e.hashCode();
    }

    public String toString() {
        long j8 = this.f22145a;
        String str = this.f22146b;
        String str2 = this.f22147c;
        String str3 = this.f22148d;
        PayoutState payoutState = this.f22149e;
        return "PayoutHistoryItem(id=" + j8 + ", label=" + str + ", date=" + str2 + ", amount=" + str3 + ", state=" + payoutState + ")";
    }
}
