package ee.mtakso.driver.network.client.generic;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GenericItem.kt */
/* loaded from: classes3.dex */
public final class GenericItem implements Parcelable {
    public static final Parcelable.Creator<GenericItem> CREATOR = new Creator();
    @SerializedName("title")

    /* renamed from: f  reason: collision with root package name */
    private final String f22217f;
    @SerializedName("subtitle")

    /* renamed from: g  reason: collision with root package name */
    private final String f22218g;
    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.VALUE)

    /* renamed from: h  reason: collision with root package name */
    private final GenericValue f22219h;
    @SerializedName("hint")

    /* renamed from: i  reason: collision with root package name */
    private final String f22220i;
    @SerializedName("warning")

    /* renamed from: j  reason: collision with root package name */
    private final String f22221j;
    @SerializedName("items")

    /* renamed from: k  reason: collision with root package name */
    private final List<GenericItem> f22222k;

    /* compiled from: GenericItem.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<GenericItem> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final GenericItem createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.f(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            GenericValue createFromParcel = GenericValue.CREATOR.createFromParcel(parcel);
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i8 = 0; i8 != readInt; i8++) {
                    arrayList2.add(GenericItem.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new GenericItem(readString, readString2, createFromParcel, readString3, readString4, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final GenericItem[] newArray(int i8) {
            return new GenericItem[i8];
        }
    }

    public GenericItem(String title, String str, GenericValue value, String str2, String str3, List<GenericItem> list) {
        Intrinsics.f(title, "title");
        Intrinsics.f(value, "value");
        this.f22217f = title;
        this.f22218g = str;
        this.f22219h = value;
        this.f22220i = str2;
        this.f22221j = str3;
        this.f22222k = list;
    }

    public final String a() {
        return this.f22220i;
    }

    public final List<GenericItem> b() {
        return this.f22222k;
    }

    public final String c() {
        return this.f22217f;
    }

    public final GenericValue d() {
        return this.f22219h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f22221j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GenericItem) {
            GenericItem genericItem = (GenericItem) obj;
            return Intrinsics.a(this.f22217f, genericItem.f22217f) && Intrinsics.a(this.f22218g, genericItem.f22218g) && Intrinsics.a(this.f22219h, genericItem.f22219h) && Intrinsics.a(this.f22220i, genericItem.f22220i) && Intrinsics.a(this.f22221j, genericItem.f22221j) && Intrinsics.a(this.f22222k, genericItem.f22222k);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f22217f.hashCode() * 31;
        String str = this.f22218g;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f22219h.hashCode()) * 31;
        String str2 = this.f22220i;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f22221j;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<GenericItem> list = this.f22222k;
        return hashCode4 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        String str = this.f22217f;
        String str2 = this.f22218g;
        GenericValue genericValue = this.f22219h;
        String str3 = this.f22220i;
        String str4 = this.f22221j;
        List<GenericItem> list = this.f22222k;
        return "GenericItem(title=" + str + ", subtitle=" + str2 + ", value=" + genericValue + ", hint=" + str3 + ", warning=" + str4 + ", items=" + list + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f22217f);
        out.writeString(this.f22218g);
        this.f22219h.writeToParcel(out, i8);
        out.writeString(this.f22220i);
        out.writeString(this.f22221j);
        List<GenericItem> list = this.f22222k;
        if (list == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeInt(list.size());
        for (GenericItem genericItem : list) {
            genericItem.writeToParcel(out, i8);
        }
    }
}
