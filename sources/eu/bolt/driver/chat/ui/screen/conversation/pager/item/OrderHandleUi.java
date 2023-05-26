package eu.bolt.driver.chat.ui.screen.conversation.pager.item;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderHandleUi.kt */
/* loaded from: classes5.dex */
public final class OrderHandleUi implements Parcelable {
    public static final Parcelable.Creator<OrderHandleUi> CREATOR = new Creator();

    /* renamed from: f  reason: collision with root package name */
    private final long f40705f;

    /* renamed from: g  reason: collision with root package name */
    private final String f40706g;

    /* renamed from: h  reason: collision with root package name */
    private final long f40707h;

    /* compiled from: OrderHandleUi.kt */
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<OrderHandleUi> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final OrderHandleUi createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new OrderHandleUi(parcel.readLong(), parcel.readString(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final OrderHandleUi[] newArray(int i8) {
            return new OrderHandleUi[i8];
        }
    }

    public OrderHandleUi(long j8, String orderSystem, long j9) {
        Intrinsics.f(orderSystem, "orderSystem");
        this.f40705f = j8;
        this.f40706g = orderSystem;
        this.f40707h = j9;
    }

    public final long a() {
        return this.f40707h;
    }

    public final long b() {
        return this.f40705f;
    }

    public final String c() {
        return this.f40706g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OrderHandleUi) {
            OrderHandleUi orderHandleUi = (OrderHandleUi) obj;
            return this.f40705f == orderHandleUi.f40705f && Intrinsics.a(this.f40706g, orderHandleUi.f40706g) && this.f40707h == orderHandleUi.f40707h;
        }
        return false;
    }

    public int hashCode() {
        return (((i0.a.a(this.f40705f) * 31) + this.f40706g.hashCode()) * 31) + i0.a.a(this.f40707h);
    }

    public String toString() {
        long j8 = this.f40705f;
        String str = this.f40706g;
        long j9 = this.f40707h;
        return "OrderHandleUi(orderId=" + j8 + ", orderSystem=" + str + ", cityId=" + j9 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeLong(this.f40705f);
        out.writeString(this.f40706g);
        out.writeLong(this.f40707h);
    }
}
