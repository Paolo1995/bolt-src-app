package ee.mtakso.driver.network.client.auth.anonymous;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PhoneResendAuthenticationRequest.kt */
/* loaded from: classes3.dex */
public final class PhoneResendAuthenticationRequest {
    @SerializedName("phone")

    /* renamed from: a  reason: collision with root package name */
    private final String f21492a;
    @SerializedName("verification_token")

    /* renamed from: b  reason: collision with root package name */
    private final String f21493b;
    @SerializedName("verification_code_channel")

    /* renamed from: c  reason: collision with root package name */
    private final String f21494c;

    public PhoneResendAuthenticationRequest(String phone, String verificationToken, String verificationChannel) {
        Intrinsics.f(phone, "phone");
        Intrinsics.f(verificationToken, "verificationToken");
        Intrinsics.f(verificationChannel, "verificationChannel");
        this.f21492a = phone;
        this.f21493b = verificationToken;
        this.f21494c = verificationChannel;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PhoneResendAuthenticationRequest) {
            PhoneResendAuthenticationRequest phoneResendAuthenticationRequest = (PhoneResendAuthenticationRequest) obj;
            return Intrinsics.a(this.f21492a, phoneResendAuthenticationRequest.f21492a) && Intrinsics.a(this.f21493b, phoneResendAuthenticationRequest.f21493b) && Intrinsics.a(this.f21494c, phoneResendAuthenticationRequest.f21494c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f21492a.hashCode() * 31) + this.f21493b.hashCode()) * 31) + this.f21494c.hashCode();
    }

    public String toString() {
        String str = this.f21492a;
        String str2 = this.f21493b;
        String str3 = this.f21494c;
        return "PhoneResendAuthenticationRequest(phone=" + str + ", verificationToken=" + str2 + ", verificationChannel=" + str3 + ")";
    }
}
