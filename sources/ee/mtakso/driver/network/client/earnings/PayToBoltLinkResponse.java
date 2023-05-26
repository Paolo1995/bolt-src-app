package ee.mtakso.driver.network.client.earnings;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayToBoltResponse.kt */
/* loaded from: classes3.dex */
public final class PayToBoltLinkResponse {
    @SerializedName(ImagesContract.URL)

    /* renamed from: a  reason: collision with root package name */
    private final String f22119a;

    public final String a() {
        return this.f22119a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PayToBoltLinkResponse) && Intrinsics.a(this.f22119a, ((PayToBoltLinkResponse) obj).f22119a);
    }

    public int hashCode() {
        String str = this.f22119a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        String str = this.f22119a;
        return "PayToBoltLinkResponse(url=" + str + ")";
    }
}
