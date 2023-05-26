package ee.mtakso.driver.network.client.payments;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsPayment.kt */
/* loaded from: classes3.dex */
public final class EarningsPayment {
    @SerializedName(ImagesContract.URL)

    /* renamed from: a  reason: collision with root package name */
    private final String f22647a;

    public final String a() {
        return this.f22647a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EarningsPayment) && Intrinsics.a(this.f22647a, ((EarningsPayment) obj).f22647a);
    }

    public int hashCode() {
        return this.f22647a.hashCode();
    }

    public String toString() {
        String str = this.f22647a;
        return "EarningsPayment(paymentUrl=" + str + ")";
    }
}
