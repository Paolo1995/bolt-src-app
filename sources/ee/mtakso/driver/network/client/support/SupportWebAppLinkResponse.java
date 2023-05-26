package ee.mtakso.driver.network.client.support;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Support.kt */
/* loaded from: classes3.dex */
public final class SupportWebAppLinkResponse {
    @SerializedName(ImagesContract.URL)

    /* renamed from: a  reason: collision with root package name */
    private final String f22856a;

    public final String a() {
        return this.f22856a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SupportWebAppLinkResponse) && Intrinsics.a(this.f22856a, ((SupportWebAppLinkResponse) obj).f22856a);
    }

    public int hashCode() {
        return this.f22856a.hashCode();
    }

    public String toString() {
        String str = this.f22856a;
        return "SupportWebAppLinkResponse(url=" + str + ")";
    }
}
