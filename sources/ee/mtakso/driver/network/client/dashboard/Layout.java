package ee.mtakso.driver.network.client.dashboard;

import com.google.gson.annotations.SerializedName;

/* compiled from: DriverHomeScreenResponse.kt */
/* loaded from: classes3.dex */
public final class Layout {
    @SerializedName("max_row")

    /* renamed from: a  reason: collision with root package name */
    private final int f21861a;
    @SerializedName("max_column")

    /* renamed from: b  reason: collision with root package name */
    private final int f21862b;

    public final int a() {
        return this.f21862b;
    }

    public final int b() {
        return this.f21861a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Layout) {
            Layout layout = (Layout) obj;
            return this.f21861a == layout.f21861a && this.f21862b == layout.f21862b;
        }
        return false;
    }

    public int hashCode() {
        return (this.f21861a * 31) + this.f21862b;
    }

    public String toString() {
        int i8 = this.f21861a;
        int i9 = this.f21862b;
        return "Layout(maxRows=" + i8 + ", maxCols=" + i9 + ")";
    }
}
