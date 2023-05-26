package ee.mtakso.driver.network.client.price;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PriceReview.kt */
/* loaded from: classes3.dex */
public final class PriceReviewReasons {
    @SerializedName("reasons")

    /* renamed from: a  reason: collision with root package name */
    private final List<PriceReviewReason> f22664a;

    public final List<PriceReviewReason> a() {
        return this.f22664a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PriceReviewReasons) && Intrinsics.a(this.f22664a, ((PriceReviewReasons) obj).f22664a);
    }

    public int hashCode() {
        return this.f22664a.hashCode();
    }

    public String toString() {
        List<PriceReviewReason> list = this.f22664a;
        return "PriceReviewReasons(priceReviewReasons=" + list + ")";
    }
}
