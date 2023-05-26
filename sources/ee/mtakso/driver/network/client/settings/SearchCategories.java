package ee.mtakso.driver.network.client.settings;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Settings.kt */
/* loaded from: classes3.dex */
public final class SearchCategories implements Parcelable {
    public static final Parcelable.Creator<SearchCategories> CREATOR = new Creator();
    @SerializedName("data")

    /* renamed from: f  reason: collision with root package name */
    private final List<SearchCategory> f22803f;
    @SerializedName("status")

    /* renamed from: g  reason: collision with root package name */
    private final String f22804g;

    /* compiled from: Settings.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<SearchCategories> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final SearchCategories createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i8 = 0; i8 != readInt; i8++) {
                arrayList.add(SearchCategory.CREATOR.createFromParcel(parcel));
            }
            return new SearchCategories(arrayList, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final SearchCategories[] newArray(int i8) {
            return new SearchCategories[i8];
        }
    }

    public SearchCategories(List<SearchCategory> data, String str) {
        Intrinsics.f(data, "data");
        this.f22803f = data;
        this.f22804g = str;
    }

    public final List<SearchCategory> a() {
        return this.f22803f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SearchCategories) {
            SearchCategories searchCategories = (SearchCategories) obj;
            return Intrinsics.a(this.f22803f, searchCategories.f22803f) && Intrinsics.a(this.f22804g, searchCategories.f22804g);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f22803f.hashCode() * 31;
        String str = this.f22804g;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        List<SearchCategory> list = this.f22803f;
        String str = this.f22804g;
        return "SearchCategories(data=" + list + ", statusMessage=" + str + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        List<SearchCategory> list = this.f22803f;
        out.writeInt(list.size());
        for (SearchCategory searchCategory : list) {
            searchCategory.writeToParcel(out, i8);
        }
        out.writeString(this.f22804g);
    }
}
