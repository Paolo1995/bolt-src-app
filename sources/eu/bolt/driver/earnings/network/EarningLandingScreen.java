package eu.bolt.driver.earnings.network;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningLandingScreen.kt */
/* loaded from: classes5.dex */
public final class EarningLandingScreen {
    @SerializedName("items")

    /* renamed from: a  reason: collision with root package name */
    private final List<EarningLandingItem> f41443a;

    public final List<EarningLandingItem> a() {
        return this.f41443a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EarningLandingScreen) && Intrinsics.a(this.f41443a, ((EarningLandingScreen) obj).f41443a);
    }

    public int hashCode() {
        return this.f41443a.hashCode();
    }

    public String toString() {
        List<EarningLandingItem> list = this.f41443a;
        return "EarningLandingScreen(items=" + list + ")";
    }
}
