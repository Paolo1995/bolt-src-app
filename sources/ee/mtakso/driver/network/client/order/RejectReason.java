package ee.mtakso.driver.network.client.order;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderDto.kt */
/* loaded from: classes3.dex */
public final class RejectReason implements Parcelable {
    public static final Parcelable.Creator<RejectReason> CREATOR = new Creator();
    @SerializedName("type")

    /* renamed from: f  reason: collision with root package name */
    private final String f22533f;
    @SerializedName("format")

    /* renamed from: g  reason: collision with root package name */
    private final String f22534g;
    @SerializedName("text")

    /* renamed from: h  reason: collision with root package name */
    private final String f22535h;

    /* compiled from: OrderDto.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<RejectReason> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final RejectReason createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new RejectReason(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final RejectReason[] newArray(int i8) {
            return new RejectReason[i8];
        }
    }

    public RejectReason(String type, String format, String title) {
        Intrinsics.f(type, "type");
        Intrinsics.f(format, "format");
        Intrinsics.f(title, "title");
        this.f22533f = type;
        this.f22534g = format;
        this.f22535h = title;
    }

    public final String a() {
        return this.f22535h;
    }

    public final String b() {
        return this.f22533f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RejectReason) {
            RejectReason rejectReason = (RejectReason) obj;
            return Intrinsics.a(this.f22533f, rejectReason.f22533f) && Intrinsics.a(this.f22534g, rejectReason.f22534g) && Intrinsics.a(this.f22535h, rejectReason.f22535h);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f22533f.hashCode() * 31) + this.f22534g.hashCode()) * 31) + this.f22535h.hashCode();
    }

    public String toString() {
        String str = this.f22533f;
        String str2 = this.f22534g;
        String str3 = this.f22535h;
        return "RejectReason(type=" + str + ", format=" + str2 + ", title=" + str3 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f22533f);
        out.writeString(this.f22534g);
        out.writeString(this.f22535h);
    }
}
