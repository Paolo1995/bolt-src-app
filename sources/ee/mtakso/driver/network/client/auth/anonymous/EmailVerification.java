package ee.mtakso.driver.network.client.auth.anonymous;

import com.google.android.gms.common.Scopes;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmailVerification.kt */
/* loaded from: classes3.dex */
public final class EmailVerification {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f21486a;
    @SerializedName("description")

    /* renamed from: b  reason: collision with root package name */
    private final String f21487b;
    @SerializedName(Scopes.EMAIL)

    /* renamed from: c  reason: collision with root package name */
    private final String f21488c;

    public final String a() {
        return this.f21487b;
    }

    public final String b() {
        return this.f21488c;
    }

    public final String c() {
        return this.f21486a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EmailVerification) {
            EmailVerification emailVerification = (EmailVerification) obj;
            return Intrinsics.a(this.f21486a, emailVerification.f21486a) && Intrinsics.a(this.f21487b, emailVerification.f21487b) && Intrinsics.a(this.f21488c, emailVerification.f21488c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f21486a.hashCode() * 31;
        String str = this.f21487b;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f21488c.hashCode();
    }

    public String toString() {
        String str = this.f21486a;
        String str2 = this.f21487b;
        String str3 = this.f21488c;
        return "EmailVerification(title=" + str + ", description=" + str2 + ", email=" + str3 + ")";
    }
}
