package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RideDetailLabelTypeInfo.kt */
/* loaded from: classes3.dex */
public final class RideDetailLabelTypeInfo {
    @SerializedName("tintable_icon_url")

    /* renamed from: a  reason: collision with root package name */
    private final String f22546a;

    public final String a() {
        return this.f22546a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RideDetailLabelTypeInfo) && Intrinsics.a(this.f22546a, ((RideDetailLabelTypeInfo) obj).f22546a);
    }

    public int hashCode() {
        return this.f22546a.hashCode();
    }

    public String toString() {
        String str = this.f22546a;
        return "RideDetailLabelTypeInfo(tintableIconUrl=" + str + ")";
    }
}
