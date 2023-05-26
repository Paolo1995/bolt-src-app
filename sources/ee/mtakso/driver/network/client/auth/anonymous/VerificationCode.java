package ee.mtakso.driver.network.client.auth.anonymous;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VerificationCode.kt */
/* loaded from: classes3.dex */
public final class VerificationCode {
    @SerializedName("verification_token")

    /* renamed from: a  reason: collision with root package name */
    private final String f21504a;
    @SerializedName("verification_code_channel")

    /* renamed from: b  reason: collision with root package name */
    private final VerificationChannel f21505b;
    @SerializedName("verification_code_length")

    /* renamed from: c  reason: collision with root package name */
    private final int f21506c;
    @SerializedName("verification_code_target")

    /* renamed from: d  reason: collision with root package name */
    private final String f21507d;
    @SerializedName("resend_wait_time_seconds")

    /* renamed from: e  reason: collision with root package name */
    private final Integer f21508e;
    @SerializedName("available_verification_code_channels")

    /* renamed from: f  reason: collision with root package name */
    private final List<VerificationChannel> f21509f;

    public final List<VerificationChannel> a() {
        return this.f21509f;
    }

    public final int b() {
        return this.f21506c;
    }

    public final Integer c() {
        return this.f21508e;
    }

    public final String d() {
        return this.f21504a;
    }

    public final VerificationChannel e() {
        return this.f21505b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VerificationCode) {
            VerificationCode verificationCode = (VerificationCode) obj;
            return Intrinsics.a(this.f21504a, verificationCode.f21504a) && this.f21505b == verificationCode.f21505b && this.f21506c == verificationCode.f21506c && Intrinsics.a(this.f21507d, verificationCode.f21507d) && Intrinsics.a(this.f21508e, verificationCode.f21508e) && Intrinsics.a(this.f21509f, verificationCode.f21509f);
        }
        return false;
    }

    public final String f() {
        return this.f21507d;
    }

    public int hashCode() {
        int hashCode = ((((((this.f21504a.hashCode() * 31) + this.f21505b.hashCode()) * 31) + this.f21506c) * 31) + this.f21507d.hashCode()) * 31;
        Integer num = this.f21508e;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        List<VerificationChannel> list = this.f21509f;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        String str = this.f21504a;
        VerificationChannel verificationChannel = this.f21505b;
        int i8 = this.f21506c;
        String str2 = this.f21507d;
        Integer num = this.f21508e;
        List<VerificationChannel> list = this.f21509f;
        return "VerificationCode(token=" + str + ", verificationChannel=" + verificationChannel + ", codeLength=" + i8 + ", verificationTarget=" + str2 + ", resendTimeSeconds=" + num + ", availableChannels=" + list + ")";
    }
}
