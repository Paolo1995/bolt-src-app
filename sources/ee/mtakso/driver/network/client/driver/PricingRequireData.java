package ee.mtakso.driver.network.client.driver;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Block.kt */
/* loaded from: classes3.dex */
public final class PricingRequireData {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f21992a;
    @SerializedName("message")

    /* renamed from: b  reason: collision with root package name */
    private final String f21993b;
    @SerializedName("actions")

    /* renamed from: c  reason: collision with root package name */
    private final List<PricingRequiredAction> f21994c;

    public final List<PricingRequiredAction> a() {
        return this.f21994c;
    }

    public final String b() {
        return this.f21993b;
    }

    public final String c() {
        return this.f21992a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PricingRequireData) {
            PricingRequireData pricingRequireData = (PricingRequireData) obj;
            return Intrinsics.a(this.f21992a, pricingRequireData.f21992a) && Intrinsics.a(this.f21993b, pricingRequireData.f21993b) && Intrinsics.a(this.f21994c, pricingRequireData.f21994c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f21992a.hashCode() * 31) + this.f21993b.hashCode()) * 31) + this.f21994c.hashCode();
    }

    public String toString() {
        String str = this.f21992a;
        String str2 = this.f21993b;
        List<PricingRequiredAction> list = this.f21994c;
        return "PricingRequireData(title=" + str + ", messageHtml=" + str2 + ", actions=" + list + ")";
    }
}
