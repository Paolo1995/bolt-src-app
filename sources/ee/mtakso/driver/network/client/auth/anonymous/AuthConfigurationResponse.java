package ee.mtakso.driver.network.client.auth.anonymous;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthConfigurationResponse.kt */
/* loaded from: classes3.dex */
public final class AuthConfigurationResponse {
    @SerializedName("app_verification_nonce")

    /* renamed from: a  reason: collision with root package name */
    private final String f21454a;

    public AuthConfigurationResponse(String str) {
        this.f21454a = str;
    }

    public final String a() {
        return this.f21454a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AuthConfigurationResponse) && Intrinsics.a(this.f21454a, ((AuthConfigurationResponse) obj).f21454a);
    }

    public int hashCode() {
        String str = this.f21454a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        String str = this.f21454a;
        return "AuthConfigurationResponse(appVerificationNonce=" + str + ")";
    }
}
