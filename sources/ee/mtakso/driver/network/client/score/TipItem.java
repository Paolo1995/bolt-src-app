package ee.mtakso.driver.network.client.score;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverScore.kt */
/* loaded from: classes3.dex */
public final class TipItem {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f22760a;

    public final String a() {
        return this.f22760a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TipItem) && Intrinsics.a(this.f22760a, ((TipItem) obj).f22760a);
    }

    public int hashCode() {
        return this.f22760a.hashCode();
    }

    public String toString() {
        String str = this.f22760a;
        return "TipItem(title=" + str + ")";
    }
}
