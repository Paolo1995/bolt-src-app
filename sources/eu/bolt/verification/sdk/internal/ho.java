package eu.bolt.verification.sdk.internal;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class ho {
    @SerializedName("alignment")

    /* renamed from: a  reason: collision with root package name */
    private final String f43419a;
    @SerializedName("main_elements")

    /* renamed from: b  reason: collision with root package name */
    private final List<ro> f43420b;
    @SerializedName("bottom_elements")

    /* renamed from: c  reason: collision with root package name */
    private final List<ro> f43421c;

    public final String a() {
        return this.f43419a;
    }

    public final List<ro> b() {
        return this.f43421c;
    }

    public final List<ro> c() {
        return this.f43420b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ho) {
            ho hoVar = (ho) obj;
            return Intrinsics.a(this.f43419a, hoVar.f43419a) && Intrinsics.a(this.f43420b, hoVar.f43420b) && Intrinsics.a(this.f43421c, hoVar.f43421c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f43419a.hashCode() * 31) + this.f43420b.hashCode()) * 31) + this.f43421c.hashCode();
    }

    public String toString() {
        String str = this.f43419a;
        List<ro> list = this.f43420b;
        List<ro> list2 = this.f43421c;
        return "VerificationFormContentNetworkModel(alignment=" + str + ", mainElements=" + list + ", bottomElements=" + list2 + ")";
    }
}
