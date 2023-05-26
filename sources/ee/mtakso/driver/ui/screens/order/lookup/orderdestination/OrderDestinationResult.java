package ee.mtakso.driver.ui.screens.order.lookup.orderdestination;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderDestinationResult.kt */
/* loaded from: classes3.dex */
public final class OrderDestinationResult implements Parcelable {
    public static final Parcelable.Creator<OrderDestinationResult> CREATOR = new Creator();

    /* renamed from: f  reason: collision with root package name */
    private final Long f31477f;

    /* renamed from: g  reason: collision with root package name */
    private final String f31478g;

    /* renamed from: h  reason: collision with root package name */
    private final double f31479h;

    /* renamed from: i  reason: collision with root package name */
    private final double f31480i;

    /* compiled from: OrderDestinationResult.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<OrderDestinationResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final OrderDestinationResult createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new OrderDestinationResult(parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readDouble(), parcel.readDouble());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final OrderDestinationResult[] newArray(int i8) {
            return new OrderDestinationResult[i8];
        }
    }

    public OrderDestinationResult(Long l8, String address, double d8, double d9) {
        Intrinsics.f(address, "address");
        this.f31477f = l8;
        this.f31478g = address;
        this.f31479h = d8;
        this.f31480i = d9;
    }

    public final String a() {
        return this.f31478g;
    }

    public final Long b() {
        return this.f31477f;
    }

    public final double c() {
        return this.f31479h;
    }

    public final double d() {
        return this.f31480i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OrderDestinationResult) {
            OrderDestinationResult orderDestinationResult = (OrderDestinationResult) obj;
            return Intrinsics.a(this.f31477f, orderDestinationResult.f31477f) && Intrinsics.a(this.f31478g, orderDestinationResult.f31478g) && Double.compare(this.f31479h, orderDestinationResult.f31479h) == 0 && Double.compare(this.f31480i, orderDestinationResult.f31480i) == 0;
        }
        return false;
    }

    public int hashCode() {
        Long l8 = this.f31477f;
        return ((((((l8 == null ? 0 : l8.hashCode()) * 31) + this.f31478g.hashCode()) * 31) + q1.a.a(this.f31479h)) * 31) + q1.a.a(this.f31480i);
    }

    public String toString() {
        Long l8 = this.f31477f;
        String str = this.f31478g;
        double d8 = this.f31479h;
        double d9 = this.f31480i;
        return "OrderDestinationResult(id=" + l8 + ", address=" + str + ", latitude=" + d8 + ", longitude=" + d9 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        Long l8 = this.f31477f;
        if (l8 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l8.longValue());
        }
        out.writeString(this.f31478g);
        out.writeDouble(this.f31479h);
        out.writeDouble(this.f31480i);
    }
}
