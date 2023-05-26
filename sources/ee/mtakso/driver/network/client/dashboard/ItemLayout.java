package ee.mtakso.driver.network.client.dashboard;

import com.google.gson.annotations.SerializedName;

/* compiled from: DriverHomeScreenResponse.kt */
/* loaded from: classes3.dex */
public final class ItemLayout {
    @SerializedName("row")

    /* renamed from: a  reason: collision with root package name */
    private final int f21857a;
    @SerializedName("column")

    /* renamed from: b  reason: collision with root package name */
    private final int f21858b;
    @SerializedName("height")

    /* renamed from: c  reason: collision with root package name */
    private final int f21859c;
    @SerializedName("width")

    /* renamed from: d  reason: collision with root package name */
    private final int f21860d;

    public final int a() {
        return this.f21858b;
    }

    public final int b() {
        return this.f21859c;
    }

    public final int c() {
        return this.f21857a;
    }

    public final int d() {
        return this.f21860d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ItemLayout) {
            ItemLayout itemLayout = (ItemLayout) obj;
            return this.f21857a == itemLayout.f21857a && this.f21858b == itemLayout.f21858b && this.f21859c == itemLayout.f21859c && this.f21860d == itemLayout.f21860d;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f21857a * 31) + this.f21858b) * 31) + this.f21859c) * 31) + this.f21860d;
    }

    public String toString() {
        int i8 = this.f21857a;
        int i9 = this.f21858b;
        int i10 = this.f21859c;
        int i11 = this.f21860d;
        return "ItemLayout(row=" + i8 + ", column=" + i9 + ", height=" + i10 + ", width=" + i11 + ")";
    }
}
