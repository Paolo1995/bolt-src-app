package ee.mtakso.driver.param;

import android.os.Parcel;
import android.os.Parcelable;
import ee.mtakso.driver.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RateMeModel.kt */
/* loaded from: classes3.dex */
public final class RateMeGenericModel extends RateMeModel {
    public static final Parcelable.Creator<RateMeGenericModel> CREATOR = new Creator();

    /* renamed from: f  reason: collision with root package name */
    private final String f23221f;

    /* renamed from: g  reason: collision with root package name */
    private final String f23222g;

    /* renamed from: h  reason: collision with root package name */
    private final String f23223h;

    /* renamed from: i  reason: collision with root package name */
    private final int f23224i;

    /* compiled from: RateMeModel.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<RateMeGenericModel> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final RateMeGenericModel createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new RateMeGenericModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final RateMeGenericModel[] newArray(int i8) {
            return new RateMeGenericModel[i8];
        }
    }

    public /* synthetic */ RateMeGenericModel(String str, String str2, String str3, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i9 & 2) != 0 ? null : str2, (i9 & 4) != 0 ? null : str3, (i9 & 8) != 0 ? R.drawable.ic_rate_driver : i8);
    }

    public final int a() {
        return this.f23224i;
    }

    public final String b() {
        return this.f23223h;
    }

    public final String c() {
        return this.f23222g;
    }

    public final String d() {
        return this.f23221f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RateMeGenericModel) {
            RateMeGenericModel rateMeGenericModel = (RateMeGenericModel) obj;
            return Intrinsics.a(this.f23221f, rateMeGenericModel.f23221f) && Intrinsics.a(this.f23222g, rateMeGenericModel.f23222g) && Intrinsics.a(this.f23223h, rateMeGenericModel.f23223h) && this.f23224i == rateMeGenericModel.f23224i;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f23221f.hashCode() * 31;
        String str = this.f23222g;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f23223h;
        return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f23224i;
    }

    public String toString() {
        String str = this.f23221f;
        String str2 = this.f23222g;
        String str3 = this.f23223h;
        int i8 = this.f23224i;
        return "RateMeGenericModel(title=" + str + ", subtitle=" + str2 + ", message=" + str3 + ", iconResource=" + i8 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f23221f);
        out.writeString(this.f23222g);
        out.writeString(this.f23223h);
        out.writeInt(this.f23224i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RateMeGenericModel(String title, String str, String str2, int i8) {
        super(null);
        Intrinsics.f(title, "title");
        this.f23221f = title;
        this.f23222g = str;
        this.f23223h = str2;
        this.f23224i = i8;
    }
}
