package ee.mtakso.driver.network.client.audio_recording;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebAppLaunchParams.kt */
/* loaded from: classes3.dex */
public final class WebAppLaunchParams {
    @SerializedName(ImagesContract.URL)

    /* renamed from: a  reason: collision with root package name */
    private final String f21383a;
    @SerializedName("include_auth_header")

    /* renamed from: b  reason: collision with root package name */
    private final boolean f21384b;
    @SerializedName("headers")

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, String> f21385c;

    public final String a() {
        return this.f21383a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WebAppLaunchParams) {
            WebAppLaunchParams webAppLaunchParams = (WebAppLaunchParams) obj;
            return Intrinsics.a(this.f21383a, webAppLaunchParams.f21383a) && this.f21384b == webAppLaunchParams.f21384b && Intrinsics.a(this.f21385c, webAppLaunchParams.f21385c);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f21383a.hashCode() * 31;
        boolean z7 = this.f21384b;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode + i8) * 31;
        Map<String, String> map = this.f21385c;
        return i9 + (map == null ? 0 : map.hashCode());
    }

    public String toString() {
        String str = this.f21383a;
        boolean z7 = this.f21384b;
        Map<String, String> map = this.f21385c;
        return "WebAppLaunchParams(url=" + str + ", includeAuthHeader=" + z7 + ", headers=" + map + ")";
    }
}
