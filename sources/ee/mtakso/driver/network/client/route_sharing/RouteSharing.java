package ee.mtakso.driver.network.client.route_sharing;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RouteSharing.kt */
/* loaded from: classes3.dex */
public final class RouteSharing {
    @SerializedName(ImagesContract.URL)

    /* renamed from: a  reason: collision with root package name */
    private final String f22702a;

    public final String a() {
        return this.f22702a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RouteSharing) && Intrinsics.a(this.f22702a, ((RouteSharing) obj).f22702a);
    }

    public int hashCode() {
        return this.f22702a.hashCode();
    }

    public String toString() {
        String str = this.f22702a;
        return "RouteSharing(url=" + str + ")";
    }
}
