package ee.mtakso.driver.network.client.earnings;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayToBoltResponse.kt */
/* loaded from: classes3.dex */
public final class ToPay {
    @SerializedName("label")

    /* renamed from: a  reason: collision with root package name */
    private final String f22167a;
    @SerializedName("price_str")

    /* renamed from: b  reason: collision with root package name */
    private final String f22168b;

    public final String a() {
        return this.f22167a;
    }

    public final String b() {
        return this.f22168b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ToPay) {
            ToPay toPay = (ToPay) obj;
            return Intrinsics.a(this.f22167a, toPay.f22167a) && Intrinsics.a(this.f22168b, toPay.f22168b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f22167a.hashCode() * 31) + this.f22168b.hashCode();
    }

    public String toString() {
        String str = this.f22167a;
        String str2 = this.f22168b;
        return "ToPay(label=" + str + ", value=" + str2 + ")";
    }
}
