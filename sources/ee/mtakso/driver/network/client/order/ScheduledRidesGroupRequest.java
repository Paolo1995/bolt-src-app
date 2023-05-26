package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScheduledRidesGroupRequest.kt */
/* loaded from: classes3.dex */
public final class ScheduledRidesGroupRequest {
    @SerializedName("group_id")

    /* renamed from: a  reason: collision with root package name */
    private final String f22591a;

    public ScheduledRidesGroupRequest(String str) {
        this.f22591a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ScheduledRidesGroupRequest) && Intrinsics.a(this.f22591a, ((ScheduledRidesGroupRequest) obj).f22591a);
    }

    public int hashCode() {
        String str = this.f22591a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        String str = this.f22591a;
        return "ScheduledRidesGroupRequest(groupId=" + str + ")";
    }
}
