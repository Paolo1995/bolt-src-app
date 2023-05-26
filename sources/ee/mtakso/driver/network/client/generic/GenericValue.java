package ee.mtakso.driver.network.client.generic;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GenericValue.kt */
/* loaded from: classes3.dex */
public final class GenericValue implements Parcelable {
    public static final Parcelable.Creator<GenericValue> CREATOR = new Creator();
    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.VALUE)

    /* renamed from: f  reason: collision with root package name */
    private final String f22225f;
    @SerializedName("style")

    /* renamed from: g  reason: collision with root package name */
    private final ValueStyle f22226g;
    @SerializedName("mark")

    /* renamed from: h  reason: collision with root package name */
    private final ValueMark f22227h;
    @SerializedName("copyable")

    /* renamed from: i  reason: collision with root package name */
    private final Boolean f22228i;

    /* compiled from: GenericValue.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<GenericValue> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final GenericValue createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Intrinsics.f(parcel, "parcel");
            String readString = parcel.readString();
            ValueStyle valueOf2 = ValueStyle.valueOf(parcel.readString());
            ValueMark valueOf3 = ValueMark.valueOf(parcel.readString());
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new GenericValue(readString, valueOf2, valueOf3, valueOf);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final GenericValue[] newArray(int i8) {
            return new GenericValue[i8];
        }
    }

    public GenericValue(String value, ValueStyle style, ValueMark mark, Boolean bool) {
        Intrinsics.f(value, "value");
        Intrinsics.f(style, "style");
        Intrinsics.f(mark, "mark");
        this.f22225f = value;
        this.f22226g = style;
        this.f22227h = mark;
        this.f22228i = bool;
    }

    public final Boolean a() {
        return this.f22228i;
    }

    public final ValueMark b() {
        return this.f22227h;
    }

    public final ValueStyle c() {
        return this.f22226g;
    }

    public final String d() {
        return this.f22225f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GenericValue) {
            GenericValue genericValue = (GenericValue) obj;
            return Intrinsics.a(this.f22225f, genericValue.f22225f) && this.f22226g == genericValue.f22226g && this.f22227h == genericValue.f22227h && Intrinsics.a(this.f22228i, genericValue.f22228i);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.f22225f.hashCode() * 31) + this.f22226g.hashCode()) * 31) + this.f22227h.hashCode()) * 31;
        Boolean bool = this.f22228i;
        return hashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        String str = this.f22225f;
        ValueStyle valueStyle = this.f22226g;
        ValueMark valueMark = this.f22227h;
        Boolean bool = this.f22228i;
        return "GenericValue(value=" + str + ", style=" + valueStyle + ", mark=" + valueMark + ", copyable=" + bool + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        int i9;
        Intrinsics.f(out, "out");
        out.writeString(this.f22225f);
        out.writeString(this.f22226g.name());
        out.writeString(this.f22227h.name());
        Boolean bool = this.f22228i;
        if (bool == null) {
            i9 = 0;
        } else {
            out.writeInt(1);
            i9 = bool.booleanValue();
        }
        out.writeInt(i9);
    }
}
