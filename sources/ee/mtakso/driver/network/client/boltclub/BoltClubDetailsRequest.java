package ee.mtakso.driver.network.client.boltclub;

import com.google.gson.annotations.SerializedName;
import i0.a;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: BoltClubDetailsRequest.kt */
/* loaded from: classes3.dex */
public final class BoltClubDetailsRequest {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final long f21533a;
    @SerializedName("language")

    /* renamed from: b  reason: collision with root package name */
    private final String f21534b;
    @SerializedName("theme")

    /* renamed from: c  reason: collision with root package name */
    private final String f21535c;

    public BoltClubDetailsRequest(long j8, String language, String theme) {
        Intrinsics.f(language, "language");
        Intrinsics.f(theme, "theme");
        this.f21533a = j8;
        this.f21534b = language;
        this.f21535c = theme;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BoltClubDetailsRequest) {
            BoltClubDetailsRequest boltClubDetailsRequest = (BoltClubDetailsRequest) obj;
            return this.f21533a == boltClubDetailsRequest.f21533a && Intrinsics.a(this.f21534b, boltClubDetailsRequest.f21534b) && Intrinsics.a(this.f21535c, boltClubDetailsRequest.f21535c);
        }
        return false;
    }

    public int hashCode() {
        return (((a.a(this.f21533a) * 31) + this.f21534b.hashCode()) * 31) + this.f21535c.hashCode();
    }

    public String toString() {
        long j8 = this.f21533a;
        String str = this.f21534b;
        String str2 = this.f21535c;
        return "BoltClubDetailsRequest(offerId=" + j8 + ", language=" + str + ", theme=" + str2 + ")";
    }
}
