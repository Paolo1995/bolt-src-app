package ee.mtakso.driver.network.client.driver;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Waybill.kt */
/* loaded from: classes3.dex */
public final class WayBillData {
    @SerializedName("html")

    /* renamed from: a  reason: collision with root package name */
    private final String f22016a;

    public final String a() {
        return this.f22016a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WayBillData) && Intrinsics.a(this.f22016a, ((WayBillData) obj).f22016a);
    }

    public int hashCode() {
        return this.f22016a.hashCode();
    }

    public String toString() {
        String str = this.f22016a;
        return "WayBillData(waybillHtmlString=" + str + ")";
    }
}
