package ee.mtakso.driver.network.client.priority;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PreconditionItem.kt */
/* loaded from: classes3.dex */
public final class PreconditionSection implements Parcelable {
    public static final Parcelable.Creator<PreconditionSection> CREATOR = new Creator();
    @SerializedName("title")

    /* renamed from: f  reason: collision with root package name */
    private final String f22685f;
    @SerializedName("items")

    /* renamed from: g  reason: collision with root package name */
    private final List<PreconditionItem> f22686g;

    /* compiled from: PreconditionItem.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<PreconditionSection> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final PreconditionSection createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i8 = 0; i8 != readInt; i8++) {
                arrayList.add(PreconditionItem.CREATOR.createFromParcel(parcel));
            }
            return new PreconditionSection(readString, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final PreconditionSection[] newArray(int i8) {
            return new PreconditionSection[i8];
        }
    }

    public PreconditionSection(String title, List<PreconditionItem> items) {
        Intrinsics.f(title, "title");
        Intrinsics.f(items, "items");
        this.f22685f = title;
        this.f22686g = items;
    }

    public final List<PreconditionItem> a() {
        return this.f22686g;
    }

    public final String b() {
        return this.f22685f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PreconditionSection) {
            PreconditionSection preconditionSection = (PreconditionSection) obj;
            return Intrinsics.a(this.f22685f, preconditionSection.f22685f) && Intrinsics.a(this.f22686g, preconditionSection.f22686g);
        }
        return false;
    }

    public int hashCode() {
        return (this.f22685f.hashCode() * 31) + this.f22686g.hashCode();
    }

    public String toString() {
        String str = this.f22685f;
        List<PreconditionItem> list = this.f22686g;
        return "PreconditionSection(title=" + str + ", items=" + list + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f22685f);
        List<PreconditionItem> list = this.f22686g;
        out.writeInt(list.size());
        for (PreconditionItem preconditionItem : list) {
            preconditionItem.writeToParcel(out, i8);
        }
    }
}
