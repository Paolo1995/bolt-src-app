package ee.mtakso.driver.network.client.earnings;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReportInterval.kt */
/* loaded from: classes3.dex */
public final class Interval {
    @SerializedName("key")

    /* renamed from: a  reason: collision with root package name */
    private final String f22115a;
    @SerializedName("label")

    /* renamed from: b  reason: collision with root package name */
    private final String f22116b;
    @SerializedName("order")

    /* renamed from: c  reason: collision with root package name */
    private final int f22117c;
    @SerializedName("default")

    /* renamed from: d  reason: collision with root package name */
    private final boolean f22118d;

    public final String a() {
        return this.f22115a;
    }

    public final String b() {
        return this.f22116b;
    }

    public final int c() {
        return this.f22117c;
    }

    public final boolean d() {
        return this.f22118d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Interval) {
            Interval interval = (Interval) obj;
            return Intrinsics.a(this.f22115a, interval.f22115a) && Intrinsics.a(this.f22116b, interval.f22116b) && this.f22117c == interval.f22117c && this.f22118d == interval.f22118d;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.f22115a.hashCode() * 31) + this.f22116b.hashCode()) * 31) + this.f22117c) * 31;
        boolean z7 = this.f22118d;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode + i8;
    }

    public String toString() {
        String str = this.f22115a;
        String str2 = this.f22116b;
        int i8 = this.f22117c;
        boolean z7 = this.f22118d;
        return "Interval(key=" + str + ", label=" + str2 + ", order=" + i8 + ", isDefault=" + z7 + ")";
    }
}
