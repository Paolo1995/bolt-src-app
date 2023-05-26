package ee.mtakso.driver.network.client.dashboard;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverHomeScreenResponse.kt */
/* loaded from: classes3.dex */
public final class HomeScreenItem {
    @SerializedName("layout")

    /* renamed from: a  reason: collision with root package name */
    private final ItemLayout f21841a;
    @SerializedName("payload")

    /* renamed from: b  reason: collision with root package name */
    private final HomeScreenItemPayload f21842b;

    public HomeScreenItem(ItemLayout layout, HomeScreenItemPayload payload) {
        Intrinsics.f(layout, "layout");
        Intrinsics.f(payload, "payload");
        this.f21841a = layout;
        this.f21842b = payload;
    }

    public final ItemLayout a() {
        return this.f21841a;
    }

    public final HomeScreenItemPayload b() {
        return this.f21842b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HomeScreenItem) {
            HomeScreenItem homeScreenItem = (HomeScreenItem) obj;
            return Intrinsics.a(this.f21841a, homeScreenItem.f21841a) && Intrinsics.a(this.f21842b, homeScreenItem.f21842b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f21841a.hashCode() * 31) + this.f21842b.hashCode();
    }

    public String toString() {
        ItemLayout itemLayout = this.f21841a;
        HomeScreenItemPayload homeScreenItemPayload = this.f21842b;
        return "HomeScreenItem(layout=" + itemLayout + ", payload=" + homeScreenItemPayload + ")";
    }
}
