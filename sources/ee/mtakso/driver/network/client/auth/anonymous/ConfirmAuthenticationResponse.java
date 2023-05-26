package ee.mtakso.driver.network.client.auth.anonymous;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfirmAuthenticationResponse.kt */
/* loaded from: classes3.dex */
public final class ConfirmAuthenticationResponse {
    @SerializedName("type")

    /* renamed from: a  reason: collision with root package name */
    private final ConfirmAuthenticationResponseType f21483a;
    @SerializedName("token")

    /* renamed from: b  reason: collision with root package name */
    private final RefreshToken f21484b;
    @SerializedName("email_verification")

    /* renamed from: c  reason: collision with root package name */
    private final EmailVerification f21485c;

    public final EmailVerification a() {
        return this.f21485c;
    }

    public final RefreshToken b() {
        return this.f21484b;
    }

    public final ConfirmAuthenticationResponseType c() {
        return this.f21483a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConfirmAuthenticationResponse) {
            ConfirmAuthenticationResponse confirmAuthenticationResponse = (ConfirmAuthenticationResponse) obj;
            return this.f21483a == confirmAuthenticationResponse.f21483a && Intrinsics.a(this.f21484b, confirmAuthenticationResponse.f21484b) && Intrinsics.a(this.f21485c, confirmAuthenticationResponse.f21485c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f21483a.hashCode() * 31;
        RefreshToken refreshToken = this.f21484b;
        int hashCode2 = (hashCode + (refreshToken == null ? 0 : refreshToken.hashCode())) * 31;
        EmailVerification emailVerification = this.f21485c;
        return hashCode2 + (emailVerification != null ? emailVerification.hashCode() : 0);
    }

    public String toString() {
        ConfirmAuthenticationResponseType confirmAuthenticationResponseType = this.f21483a;
        RefreshToken refreshToken = this.f21484b;
        EmailVerification emailVerification = this.f21485c;
        return "ConfirmAuthenticationResponse(type=" + confirmAuthenticationResponseType + ", token=" + refreshToken + ", emailVerification=" + emailVerification + ")";
    }
}
