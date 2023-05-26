package ee.mtakso.driver.network.client.auth.anonymous;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Token.kt */
/* loaded from: classes3.dex */
public final class RefreshToken {
    @SerializedName("refresh_token")

    /* renamed from: a  reason: collision with root package name */
    private final String f21495a;
    @SerializedName("token_type")

    /* renamed from: b  reason: collision with root package name */
    private final TokenType f21496b;

    public final String a() {
        return this.f21495a;
    }

    public final TokenType b() {
        return this.f21496b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RefreshToken) {
            RefreshToken refreshToken = (RefreshToken) obj;
            return Intrinsics.a(this.f21495a, refreshToken.f21495a) && this.f21496b == refreshToken.f21496b;
        }
        return false;
    }

    public int hashCode() {
        return (this.f21495a.hashCode() * 31) + this.f21496b.hashCode();
    }

    public String toString() {
        String str = this.f21495a;
        TokenType tokenType = this.f21496b;
        return "RefreshToken(refreshToken=" + str + ", type=" + tokenType + ")";
    }
}
