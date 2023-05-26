package ee.mtakso.driver.network.client.geo;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Geo.kt */
/* loaded from: classes3.dex */
public final class ExternalSourceAddresses {
    @SerializedName("places")

    /* renamed from: a  reason: collision with root package name */
    private final List<ExternalSourceAddress> f22251a;

    public ExternalSourceAddresses(List<ExternalSourceAddress> addressList) {
        Intrinsics.f(addressList, "addressList");
        this.f22251a = addressList;
    }

    public final List<ExternalSourceAddress> a() {
        return this.f22251a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ExternalSourceAddresses) && Intrinsics.a(this.f22251a, ((ExternalSourceAddresses) obj).f22251a);
    }

    public int hashCode() {
        return this.f22251a.hashCode();
    }

    public String toString() {
        List<ExternalSourceAddress> list = this.f22251a;
        return "ExternalSourceAddresses(addressList=" + list + ")";
    }
}
