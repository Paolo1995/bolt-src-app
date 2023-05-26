package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignV2.kt */
/* loaded from: classes3.dex */
public final class OptInChoicesV2 {
    @SerializedName("groups")

    /* renamed from: a  reason: collision with root package name */
    private final List<OptInGroupV2> f21716a;

    public final List<OptInGroupV2> a() {
        return this.f21716a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OptInChoicesV2) && Intrinsics.a(this.f21716a, ((OptInChoicesV2) obj).f21716a);
    }

    public int hashCode() {
        return this.f21716a.hashCode();
    }

    public String toString() {
        List<OptInGroupV2> list = this.f21716a;
        return "OptInChoicesV2(groups=" + list + ")";
    }
}
