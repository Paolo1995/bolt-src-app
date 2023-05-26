package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import eu.bolt.driver.earnings.network.DriverColor;
import eu.bolt.driver.earnings.network.DriverImage;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverAppStickyBanner.kt */
/* loaded from: classes3.dex */
public final class DriverAppStickyBanner {
    @SerializedName("text_html")

    /* renamed from: a  reason: collision with root package name */
    private final String f22329a;
    @SerializedName("image")

    /* renamed from: b  reason: collision with root package name */
    private final DriverImage f22330b;
    @SerializedName("background_color")

    /* renamed from: c  reason: collision with root package name */
    private final DriverColor f22331c;

    public final DriverColor a() {
        return this.f22331c;
    }

    public final DriverImage b() {
        return this.f22330b;
    }

    public final String c() {
        return this.f22329a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverAppStickyBanner) {
            DriverAppStickyBanner driverAppStickyBanner = (DriverAppStickyBanner) obj;
            return Intrinsics.a(this.f22329a, driverAppStickyBanner.f22329a) && Intrinsics.a(this.f22330b, driverAppStickyBanner.f22330b) && Intrinsics.a(this.f22331c, driverAppStickyBanner.f22331c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f22329a.hashCode() * 31;
        DriverImage driverImage = this.f22330b;
        int hashCode2 = (hashCode + (driverImage == null ? 0 : driverImage.hashCode())) * 31;
        DriverColor driverColor = this.f22331c;
        return hashCode2 + (driverColor != null ? driverColor.hashCode() : 0);
    }

    public String toString() {
        String str = this.f22329a;
        DriverImage driverImage = this.f22330b;
        DriverColor driverColor = this.f22331c;
        return "DriverAppStickyBanner(textHtml=" + str + ", image=" + driverImage + ", backgroundColor=" + driverColor + ")";
    }
}
