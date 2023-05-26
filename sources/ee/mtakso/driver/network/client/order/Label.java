package ee.mtakso.driver.network.client.order;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActiveOrder.kt */
/* loaded from: classes3.dex */
public final class Label implements Parcelable {
    public static final Parcelable.Creator<Label> CREATOR = new Creator();
    @SerializedName("title")

    /* renamed from: f  reason: collision with root package name */
    private final String f22377f;
    @SerializedName("icon")

    /* renamed from: g  reason: collision with root package name */
    private final String f22378g;
    @SerializedName("severity")

    /* renamed from: h  reason: collision with root package name */
    private final LabelSeverity f22379h;

    /* compiled from: ActiveOrder.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<Label> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final Label createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new Label(parcel.readString(), parcel.readString(), LabelSeverity.valueOf(parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final Label[] newArray(int i8) {
            return new Label[i8];
        }
    }

    public Label(String title, String str, LabelSeverity severity) {
        Intrinsics.f(title, "title");
        Intrinsics.f(severity, "severity");
        this.f22377f = title;
        this.f22378g = str;
        this.f22379h = severity;
    }

    public final String a() {
        return this.f22378g;
    }

    public final LabelSeverity b() {
        return this.f22379h;
    }

    public final String c() {
        return this.f22377f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Label) {
            Label label = (Label) obj;
            return Intrinsics.a(this.f22377f, label.f22377f) && Intrinsics.a(this.f22378g, label.f22378g) && this.f22379h == label.f22379h;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f22377f.hashCode() * 31;
        String str = this.f22378g;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f22379h.hashCode();
    }

    public String toString() {
        String str = this.f22377f;
        String str2 = this.f22378g;
        LabelSeverity labelSeverity = this.f22379h;
        return "Label(title=" + str + ", icon=" + str2 + ", severity=" + labelSeverity + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f22377f);
        out.writeString(this.f22378g);
        out.writeString(this.f22379h.name());
    }
}
