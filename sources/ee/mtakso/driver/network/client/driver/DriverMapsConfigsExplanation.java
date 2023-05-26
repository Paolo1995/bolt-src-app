package ee.mtakso.driver.network.client.driver;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverMapsConfigsExplanation.kt */
/* loaded from: classes3.dex */
public final class DriverMapsConfigsExplanation {
    @SerializedName("html_content")

    /* renamed from: a  reason: collision with root package name */
    private final String f21931a;

    public final String a() {
        return this.f21931a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DriverMapsConfigsExplanation) && Intrinsics.a(this.f21931a, ((DriverMapsConfigsExplanation) obj).f21931a);
    }

    public int hashCode() {
        return this.f21931a.hashCode();
    }

    public String toString() {
        String str = this.f21931a;
        return "DriverMapsConfigsExplanation(htmlContent=" + str + ")";
    }
}
