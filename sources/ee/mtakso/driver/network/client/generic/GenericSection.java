package ee.mtakso.driver.network.client.generic;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GenericSection.kt */
/* loaded from: classes3.dex */
public final class GenericSection implements Parcelable {
    public static final Parcelable.Creator<GenericSection> CREATOR = new Creator();
    @SerializedName("title")

    /* renamed from: f  reason: collision with root package name */
    private final String f22223f;
    @SerializedName("items")

    /* renamed from: g  reason: collision with root package name */
    private final List<GenericItem> f22224g;

    /* compiled from: GenericSection.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<GenericSection> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final GenericSection createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i8 = 0; i8 != readInt; i8++) {
                arrayList.add(GenericItem.CREATOR.createFromParcel(parcel));
            }
            return new GenericSection(readString, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final GenericSection[] newArray(int i8) {
            return new GenericSection[i8];
        }
    }

    public GenericSection(String str, List<GenericItem> items) {
        Intrinsics.f(items, "items");
        this.f22223f = str;
        this.f22224g = items;
    }

    public final List<GenericItem> a() {
        return this.f22224g;
    }

    public final String b() {
        return this.f22223f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GenericSection) {
            GenericSection genericSection = (GenericSection) obj;
            return Intrinsics.a(this.f22223f, genericSection.f22223f) && Intrinsics.a(this.f22224g, genericSection.f22224g);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f22223f;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.f22224g.hashCode();
    }

    public String toString() {
        String str = this.f22223f;
        List<GenericItem> list = this.f22224g;
        return "GenericSection(title=" + str + ", items=" + list + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f22223f);
        List<GenericItem> list = this.f22224g;
        out.writeInt(list.size());
        for (GenericItem genericItem : list) {
            genericItem.writeToParcel(out, i8);
        }
    }
}
