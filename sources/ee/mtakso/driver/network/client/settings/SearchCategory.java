package ee.mtakso.driver.network.client.settings;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: Settings.kt */
/* loaded from: classes3.dex */
public final class SearchCategory implements Parcelable {
    public static final Parcelable.Creator<SearchCategory> CREATOR = new Creator();
    @SerializedName(Name.MARK)

    /* renamed from: f  reason: collision with root package name */
    private final String f22805f;
    @SerializedName("name")

    /* renamed from: g  reason: collision with root package name */
    private final String f22806g;
    @SerializedName("selected")

    /* renamed from: h  reason: collision with root package name */
    private final boolean f22807h;

    /* compiled from: Settings.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<SearchCategory> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final SearchCategory createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new SearchCategory(parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final SearchCategory[] newArray(int i8) {
            return new SearchCategory[i8];
        }
    }

    public SearchCategory(String id, String name, boolean z7) {
        Intrinsics.f(id, "id");
        Intrinsics.f(name, "name");
        this.f22805f = id;
        this.f22806g = name;
        this.f22807h = z7;
    }

    public static /* synthetic */ SearchCategory b(SearchCategory searchCategory, String str, String str2, boolean z7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = searchCategory.f22805f;
        }
        if ((i8 & 2) != 0) {
            str2 = searchCategory.f22806g;
        }
        if ((i8 & 4) != 0) {
            z7 = searchCategory.f22807h;
        }
        return searchCategory.a(str, str2, z7);
    }

    public final SearchCategory a(String id, String name, boolean z7) {
        Intrinsics.f(id, "id");
        Intrinsics.f(name, "name");
        return new SearchCategory(id, name, z7);
    }

    public final String c() {
        return this.f22805f;
    }

    public final String d() {
        return this.f22806g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean e() {
        return this.f22807h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SearchCategory) {
            SearchCategory searchCategory = (SearchCategory) obj;
            return Intrinsics.a(this.f22805f, searchCategory.f22805f) && Intrinsics.a(this.f22806g, searchCategory.f22806g) && this.f22807h == searchCategory.f22807h;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f22805f.hashCode() * 31) + this.f22806g.hashCode()) * 31;
        boolean z7 = this.f22807h;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode + i8;
    }

    public String toString() {
        String str = this.f22805f;
        String str2 = this.f22806g;
        boolean z7 = this.f22807h;
        return "SearchCategory(id=" + str + ", name=" + str2 + ", selected=" + z7 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f22805f);
        out.writeString(this.f22806g);
        out.writeInt(this.f22807h ? 1 : 0);
    }
}
