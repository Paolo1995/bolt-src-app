package ee.mtakso.driver.network.client.driver.navigation;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DynamicNavigation.kt */
/* loaded from: classes3.dex */
public final class DynamicNavigation {
    @SerializedName("options")

    /* renamed from: a  reason: collision with root package name */
    private final List<DynamicNavigationOption> f22063a;

    public final List<DynamicNavigationOption> a() {
        return this.f22063a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DynamicNavigation) && Intrinsics.a(this.f22063a, ((DynamicNavigation) obj).f22063a);
    }

    public int hashCode() {
        return this.f22063a.hashCode();
    }

    public String toString() {
        List<DynamicNavigationOption> list = this.f22063a;
        return "DynamicNavigation(dynamicNavigationOptions=" + list + ")";
    }
}
