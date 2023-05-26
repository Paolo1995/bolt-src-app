package ee.mtakso.driver.network.client.auth.anonymous;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthResult.kt */
/* loaded from: classes3.dex */
public final class AuthResultResponse {
    @SerializedName("type")

    /* renamed from: a  reason: collision with root package name */
    private final AuthState f21469a;
    @SerializedName("refresh_token")

    /* renamed from: b  reason: collision with root package name */
    private final String f21470b;
    @SerializedName("verification_token")

    /* renamed from: c  reason: collision with root package name */
    private final String f21471c;
    @SerializedName("verification_code_channel")

    /* renamed from: d  reason: collision with root package name */
    private final VerificationChannel f21472d;
    @SerializedName("verification_code_target")

    /* renamed from: e  reason: collision with root package name */
    private final String f21473e;
    @SerializedName("verification_code_length")

    /* renamed from: f  reason: collision with root package name */
    private final Integer f21474f;
    @SerializedName("resend_wait_time_seconds")

    /* renamed from: g  reason: collision with root package name */
    private final Integer f21475g;
    @SerializedName("available_verification_channels")

    /* renamed from: h  reason: collision with root package name */
    private final List<VerificationChannel> f21476h;

    public final List<VerificationChannel> a() {
        return this.f21476h;
    }

    public final Integer b() {
        return this.f21475g;
    }

    public final String c() {
        return this.f21470b;
    }

    public final AuthState d() {
        return this.f21469a;
    }

    public final VerificationChannel e() {
        return this.f21472d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AuthResultResponse) {
            AuthResultResponse authResultResponse = (AuthResultResponse) obj;
            return this.f21469a == authResultResponse.f21469a && Intrinsics.a(this.f21470b, authResultResponse.f21470b) && Intrinsics.a(this.f21471c, authResultResponse.f21471c) && this.f21472d == authResultResponse.f21472d && Intrinsics.a(this.f21473e, authResultResponse.f21473e) && Intrinsics.a(this.f21474f, authResultResponse.f21474f) && Intrinsics.a(this.f21475g, authResultResponse.f21475g) && Intrinsics.a(this.f21476h, authResultResponse.f21476h);
        }
        return false;
    }

    public final Integer f() {
        return this.f21474f;
    }

    public final String g() {
        return this.f21473e;
    }

    public final String h() {
        return this.f21471c;
    }

    public int hashCode() {
        int hashCode = this.f21469a.hashCode() * 31;
        String str = this.f21470b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f21471c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        VerificationChannel verificationChannel = this.f21472d;
        int hashCode4 = (hashCode3 + (verificationChannel == null ? 0 : verificationChannel.hashCode())) * 31;
        String str3 = this.f21473e;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.f21474f;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f21475g;
        int hashCode7 = (hashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        List<VerificationChannel> list = this.f21476h;
        return hashCode7 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        AuthState authState = this.f21469a;
        String str = this.f21470b;
        String str2 = this.f21471c;
        VerificationChannel verificationChannel = this.f21472d;
        String str3 = this.f21473e;
        Integer num = this.f21474f;
        Integer num2 = this.f21475g;
        List<VerificationChannel> list = this.f21476h;
        return "AuthResultResponse(state=" + authState + ", refreshToken=" + str + ", verificationToken=" + str2 + ", verificationChannel=" + verificationChannel + ", verificationTarget=" + str3 + ", verificationCodeLength=" + num + ", reSendTimeout=" + num2 + ", availableChannels=" + list + ")";
    }
}
