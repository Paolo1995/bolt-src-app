package ee.mtakso.driver.network.client.driver.surge;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CurrentSurge.kt */
/* loaded from: classes3.dex */
public final class CurrentSurge {
    @SerializedName("map")

    /* renamed from: a  reason: collision with root package name */
    private final SurgeMap f22080a;

    public final SurgeMap a() {
        return this.f22080a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CurrentSurge) && Intrinsics.a(this.f22080a, ((CurrentSurge) obj).f22080a);
    }

    public int hashCode() {
        SurgeMap surgeMap = this.f22080a;
        if (surgeMap == null) {
            return 0;
        }
        return surgeMap.hashCode();
    }

    public String toString() {
        SurgeMap surgeMap = this.f22080a;
        return "CurrentSurge(surgeMap=" + surgeMap + ")";
    }
}
