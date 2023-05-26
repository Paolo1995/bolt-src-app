package ee.mtakso.driver.network.client.auth.anonymous;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Token.kt */
/* loaded from: classes3.dex */
public final class AccessToken {
    @SerializedName("access_token")

    /* renamed from: a  reason: collision with root package name */
    private final String f21424a;
    @SerializedName("expires_timestamp")

    /* renamed from: b  reason: collision with root package name */
    private final long f21425b;
    @SerializedName("next_update_in_seconds")

    /* renamed from: c  reason: collision with root package name */
    private final long f21426c;
    @SerializedName("expires_in_seconds")

    /* renamed from: d  reason: collision with root package name */
    private final long f21427d;

    public final String a() {
        return this.f21424a;
    }

    public final long b() {
        return this.f21426c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AccessToken) {
            AccessToken accessToken = (AccessToken) obj;
            return Intrinsics.a(this.f21424a, accessToken.f21424a) && this.f21425b == accessToken.f21425b && this.f21426c == accessToken.f21426c && this.f21427d == accessToken.f21427d;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f21424a.hashCode() * 31) + i0.a.a(this.f21425b)) * 31) + i0.a.a(this.f21426c)) * 31) + i0.a.a(this.f21427d);
    }

    public String toString() {
        String str = this.f21424a;
        long j8 = this.f21425b;
        long j9 = this.f21426c;
        long j10 = this.f21427d;
        return "AccessToken(accessToken=" + str + ", expiresTimestamp=" + j8 + ", updateInSeconds=" + j9 + ", expiresInSeconds=" + j10 + ")";
    }
}
