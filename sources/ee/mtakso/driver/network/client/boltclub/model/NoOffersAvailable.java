package ee.mtakso.driver.network.client.boltclub.model;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NoOffersAvailable.kt */
/* loaded from: classes3.dex */
public final class NoOffersAvailable {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f21560a;
    @SerializedName("body")

    /* renamed from: b  reason: collision with root package name */
    private final String f21561b;

    public final String a() {
        return this.f21561b;
    }

    public final String b() {
        return this.f21560a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NoOffersAvailable) {
            NoOffersAvailable noOffersAvailable = (NoOffersAvailable) obj;
            return Intrinsics.a(this.f21560a, noOffersAvailable.f21560a) && Intrinsics.a(this.f21561b, noOffersAvailable.f21561b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f21560a.hashCode() * 31) + this.f21561b.hashCode();
    }

    public String toString() {
        String str = this.f21560a;
        String str2 = this.f21561b;
        return "NoOffersAvailable(title=" + str + ", body=" + str2 + ")";
    }
}
