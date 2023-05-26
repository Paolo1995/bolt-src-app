package ee.mtakso.driver.network.client.earnings;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayoutResponce.kt */
/* loaded from: classes3.dex */
public final class ProgressItem {
    @SerializedName("status")

    /* renamed from: a  reason: collision with root package name */
    private final ProgressItemStatus f22160a;
    @SerializedName("label")

    /* renamed from: b  reason: collision with root package name */
    private final String f22161b;
    @SerializedName("date")

    /* renamed from: c  reason: collision with root package name */
    private final String f22162c;

    public final String a() {
        return this.f22162c;
    }

    public final String b() {
        return this.f22161b;
    }

    public final ProgressItemStatus c() {
        return this.f22160a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ProgressItem) {
            ProgressItem progressItem = (ProgressItem) obj;
            return this.f22160a == progressItem.f22160a && Intrinsics.a(this.f22161b, progressItem.f22161b) && Intrinsics.a(this.f22162c, progressItem.f22162c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f22160a.hashCode() * 31) + this.f22161b.hashCode()) * 31;
        String str = this.f22162c;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        ProgressItemStatus progressItemStatus = this.f22160a;
        String str = this.f22161b;
        String str2 = this.f22162c;
        return "ProgressItem(status=" + progressItemStatus + ", label=" + str + ", date=" + str2 + ")";
    }
}
