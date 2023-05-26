package ee.mtakso.driver.network.client.order;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.InaccurateCoordinates;
import eu.bolt.android.maps.core.Locatable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderMapPoint.kt */
/* loaded from: classes3.dex */
public final class OrderMapPoint implements Parcelable, Locatable {
    public static final Parcelable.Creator<OrderMapPoint> CREATOR = new Creator();
    @SerializedName("type")

    /* renamed from: f  reason: collision with root package name */
    private final Type f22425f;
    @SerializedName("location")

    /* renamed from: g  reason: collision with root package name */
    private final InaccurateCoordinates f22426g;
    @SerializedName("pin")

    /* renamed from: h  reason: collision with root package name */
    private final Pin f22427h;

    /* compiled from: OrderMapPoint.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<OrderMapPoint> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final OrderMapPoint createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new OrderMapPoint(Type.valueOf(parcel.readString()), InaccurateCoordinates.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Pin.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final OrderMapPoint[] newArray(int i8) {
            return new OrderMapPoint[i8];
        }
    }

    /* compiled from: OrderMapPoint.kt */
    /* loaded from: classes3.dex */
    public static final class Pin implements Parcelable {
        public static final Parcelable.Creator<Pin> CREATOR = new Creator();
        @SerializedName("type")

        /* renamed from: f  reason: collision with root package name */
        private final PinType f22428f;
        @SerializedName("title")

        /* renamed from: g  reason: collision with root package name */
        private final String f22429g;
        @SerializedName("appearance")

        /* renamed from: h  reason: collision with root package name */
        private final PinAppearance f22430h;

        /* compiled from: OrderMapPoint.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<Pin> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Pin createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new Pin(PinType.valueOf(parcel.readString()), parcel.readString(), parcel.readInt() == 0 ? null : PinAppearance.valueOf(parcel.readString()));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Pin[] newArray(int i8) {
                return new Pin[i8];
            }
        }

        public Pin(PinType type, String title, PinAppearance pinAppearance) {
            Intrinsics.f(type, "type");
            Intrinsics.f(title, "title");
            this.f22428f = type;
            this.f22429g = title;
            this.f22430h = pinAppearance;
        }

        public final PinAppearance a() {
            return this.f22430h;
        }

        public final String b() {
            return this.f22429g;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Pin) {
                Pin pin = (Pin) obj;
                return this.f22428f == pin.f22428f && Intrinsics.a(this.f22429g, pin.f22429g) && this.f22430h == pin.f22430h;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((this.f22428f.hashCode() * 31) + this.f22429g.hashCode()) * 31;
            PinAppearance pinAppearance = this.f22430h;
            return hashCode + (pinAppearance == null ? 0 : pinAppearance.hashCode());
        }

        public String toString() {
            PinType pinType = this.f22428f;
            String str = this.f22429g;
            PinAppearance pinAppearance = this.f22430h;
            return "Pin(type=" + pinType + ", title=" + str + ", appearance=" + pinAppearance + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeString(this.f22428f.name());
            out.writeString(this.f22429g);
            PinAppearance pinAppearance = this.f22430h;
            if (pinAppearance == null) {
                out.writeInt(0);
                return;
            }
            out.writeInt(1);
            out.writeString(pinAppearance.name());
        }
    }

    /* compiled from: OrderMapPoint.kt */
    /* loaded from: classes3.dex */
    public enum PinAppearance {
        PICKUP,
        DESTINATION,
        WAYPOINT,
        UNKNOWN
    }

    /* compiled from: OrderMapPoint.kt */
    /* loaded from: classes3.dex */
    public enum PinType {
        TEXT,
        ICON_DEFAULT,
        UNKNOWN
    }

    /* compiled from: OrderMapPoint.kt */
    /* loaded from: classes3.dex */
    public enum Type {
        PICKUP,
        DESTINATION,
        WAYPOINT,
        CUSTOM,
        CURRENT_ORDER_DESTINATION,
        UNKNOWN
    }

    public OrderMapPoint(Type type, InaccurateCoordinates location, Pin pin) {
        Intrinsics.f(type, "type");
        Intrinsics.f(location, "location");
        this.f22425f = type;
        this.f22426g = location;
        this.f22427h = pin;
    }

    @Override // eu.bolt.android.maps.core.Locatable
    public double a() {
        return this.f22426g.a();
    }

    @Override // eu.bolt.android.maps.core.Locatable
    public double b() {
        return this.f22426g.b();
    }

    public final InaccurateCoordinates c() {
        return this.f22426g;
    }

    public final Pin d() {
        return this.f22427h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Type e() {
        return this.f22425f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OrderMapPoint) {
            OrderMapPoint orderMapPoint = (OrderMapPoint) obj;
            return this.f22425f == orderMapPoint.f22425f && Intrinsics.a(this.f22426g, orderMapPoint.f22426g) && Intrinsics.a(this.f22427h, orderMapPoint.f22427h);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f22425f.hashCode() * 31) + this.f22426g.hashCode()) * 31;
        Pin pin = this.f22427h;
        return hashCode + (pin == null ? 0 : pin.hashCode());
    }

    public String toString() {
        Type type = this.f22425f;
        InaccurateCoordinates inaccurateCoordinates = this.f22426g;
        Pin pin = this.f22427h;
        return "OrderMapPoint(type=" + type + ", location=" + inaccurateCoordinates + ", pin=" + pin + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f22425f.name());
        this.f22426g.writeToParcel(out, i8);
        Pin pin = this.f22427h;
        if (pin == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        pin.writeToParcel(out, i8);
    }
}
