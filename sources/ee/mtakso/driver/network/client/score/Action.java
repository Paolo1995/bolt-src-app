package ee.mtakso.driver.network.client.score;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverScore.kt */
/* loaded from: classes3.dex */
public final class Action {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f22707a;
    @SerializedName("description")

    /* renamed from: b  reason: collision with root package name */
    private final String f22708b;
    @SerializedName("button")

    /* renamed from: c  reason: collision with root package name */
    private final ActionButton f22709c;

    public final ActionButton a() {
        return this.f22709c;
    }

    public final String b() {
        return this.f22708b;
    }

    public final String c() {
        return this.f22707a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Action) {
            Action action = (Action) obj;
            return Intrinsics.a(this.f22707a, action.f22707a) && Intrinsics.a(this.f22708b, action.f22708b) && Intrinsics.a(this.f22709c, action.f22709c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f22707a.hashCode() * 31;
        String str = this.f22708b;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f22709c.hashCode();
    }

    public String toString() {
        String str = this.f22707a;
        String str2 = this.f22708b;
        ActionButton actionButton = this.f22709c;
        return "Action(title=" + str + ", description=" + str2 + ", button=" + actionButton + ")";
    }
}
