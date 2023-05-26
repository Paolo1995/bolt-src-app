package ee.mtakso.driver.network.client.boltclub;

import com.google.gson.annotations.SerializedName;
import i0.a;
import org.simpleframework.xml.strategy.Name;

/* compiled from: FavouriteStatusRequest.kt */
/* loaded from: classes3.dex */
public final class FavouriteStatusRequest {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final long f21536a;
    @SerializedName("is_favourite")

    /* renamed from: b  reason: collision with root package name */
    private final boolean f21537b;

    public FavouriteStatusRequest(long j8, boolean z7) {
        this.f21536a = j8;
        this.f21537b = z7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FavouriteStatusRequest) {
            FavouriteStatusRequest favouriteStatusRequest = (FavouriteStatusRequest) obj;
            return this.f21536a == favouriteStatusRequest.f21536a && this.f21537b == favouriteStatusRequest.f21537b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a8 = a.a(this.f21536a) * 31;
        boolean z7 = this.f21537b;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return a8 + i8;
    }

    public String toString() {
        long j8 = this.f21536a;
        boolean z7 = this.f21537b;
        return "FavouriteStatusRequest(offerId=" + j8 + ", isFavourite=" + z7 + ")";
    }
}
