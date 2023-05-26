package ee.mtakso.driver.network.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderHandle.kt */
/* loaded from: classes3.dex */
public final class OrderHandle implements Parcelable {
    public static final Parcelable.Creator<OrderHandle> CREATOR = new Creator();
    @SerializedName("order_system")

    /* renamed from: f  reason: collision with root package name */
    private final String f21320f;
    @SerializedName("city_id")

    /* renamed from: g  reason: collision with root package name */
    private final long f21321g;
    @SerializedName("order_id")

    /* renamed from: h  reason: collision with root package name */
    private final long f21322h;

    /* compiled from: OrderHandle.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<OrderHandle> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final OrderHandle createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new OrderHandle(parcel.readString(), parcel.readLong(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final OrderHandle[] newArray(int i8) {
            return new OrderHandle[i8];
        }
    }

    public OrderHandle(String orderSystem, long j8, long j9) {
        Intrinsics.f(orderSystem, "orderSystem");
        this.f21320f = orderSystem;
        this.f21321g = j8;
        this.f21322h = j9;
    }

    public final long a() {
        return this.f21321g;
    }

    public final long b() {
        return this.f21322h;
    }

    public final String c() {
        return this.f21320f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OrderHandle) {
            OrderHandle orderHandle = (OrderHandle) obj;
            return Intrinsics.a(this.f21320f, orderHandle.f21320f) && this.f21321g == orderHandle.f21321g && this.f21322h == orderHandle.f21322h;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f21320f.hashCode() * 31) + i0.a.a(this.f21321g)) * 31) + i0.a.a(this.f21322h);
    }

    public String toString() {
        String str = this.f21320f;
        long j8 = this.f21321g;
        long j9 = this.f21322h;
        return "OrderHandle(orderSystem=" + str + ", cityId=" + j8 + ", orderId=" + j9 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f21320f);
        out.writeLong(this.f21321g);
        out.writeLong(this.f21322h);
    }
}
