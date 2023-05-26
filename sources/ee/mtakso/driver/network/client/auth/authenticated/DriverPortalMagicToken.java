package ee.mtakso.driver.network.client.auth.authenticated;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Token.kt */
/* loaded from: classes3.dex */
public final class DriverPortalMagicToken {
    @SerializedName("token")

    /* renamed from: a  reason: collision with root package name */
    private final String f21532a;

    public final String a() {
        return this.f21532a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DriverPortalMagicToken) && Intrinsics.a(this.f21532a, ((DriverPortalMagicToken) obj).f21532a);
    }

    public int hashCode() {
        return this.f21532a.hashCode();
    }

    public String toString() {
        String str = this.f21532a;
        return "DriverPortalMagicToken(token=" + str + ")";
    }
}
