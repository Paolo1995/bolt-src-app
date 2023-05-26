package ee.mtakso.driver.network.client.earnings;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.generic.GenericSection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReportScreen.kt */
/* loaded from: classes3.dex */
public final class ReportScreen {
    @SerializedName("sections")

    /* renamed from: a  reason: collision with root package name */
    private final List<GenericSection> f22166a;

    public final List<GenericSection> a() {
        return this.f22166a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ReportScreen) && Intrinsics.a(this.f22166a, ((ReportScreen) obj).f22166a);
    }

    public int hashCode() {
        return this.f22166a.hashCode();
    }

    public String toString() {
        List<GenericSection> list = this.f22166a;
        return "ReportScreen(sections=" + list + ")";
    }
}
