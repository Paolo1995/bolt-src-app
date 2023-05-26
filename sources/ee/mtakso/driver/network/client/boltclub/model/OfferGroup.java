package ee.mtakso.driver.network.client.boltclub.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OfferGroup.kt */
/* loaded from: classes3.dex */
public final class OfferGroup {
    @SerializedName("group_name")

    /* renamed from: a  reason: collision with root package name */
    private final String f21567a;
    @SerializedName("list")

    /* renamed from: b  reason: collision with root package name */
    private final List<Offer> f21568b;

    public final String a() {
        return this.f21567a;
    }

    public final List<Offer> b() {
        return this.f21568b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OfferGroup) {
            OfferGroup offerGroup = (OfferGroup) obj;
            return Intrinsics.a(this.f21567a, offerGroup.f21567a) && Intrinsics.a(this.f21568b, offerGroup.f21568b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f21567a.hashCode() * 31) + this.f21568b.hashCode();
    }

    public String toString() {
        String str = this.f21567a;
        List<Offer> list = this.f21568b;
        return "OfferGroup(groupName=" + str + ", offerList=" + list + ")";
    }
}
