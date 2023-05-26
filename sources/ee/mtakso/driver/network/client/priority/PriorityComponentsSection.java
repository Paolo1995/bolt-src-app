package ee.mtakso.driver.network.client.priority;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PreconditionItem.kt */
/* loaded from: classes3.dex */
public final class PriorityComponentsSection implements Parcelable {
    public static final Parcelable.Creator<PriorityComponentsSection> CREATOR = new Creator();
    @SerializedName("title")

    /* renamed from: f  reason: collision with root package name */
    private final String f22690f;
    @SerializedName("items")

    /* renamed from: g  reason: collision with root package name */
    private final List<PriorityComponentItem> f22691g;

    /* compiled from: PreconditionItem.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<PriorityComponentsSection> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final PriorityComponentsSection createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i8 = 0; i8 != readInt; i8++) {
                arrayList.add(PriorityComponentItem.CREATOR.createFromParcel(parcel));
            }
            return new PriorityComponentsSection(readString, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final PriorityComponentsSection[] newArray(int i8) {
            return new PriorityComponentsSection[i8];
        }
    }

    public PriorityComponentsSection(String title, List<PriorityComponentItem> items) {
        Intrinsics.f(title, "title");
        Intrinsics.f(items, "items");
        this.f22690f = title;
        this.f22691g = items;
    }

    public final List<PriorityComponentItem> a() {
        return this.f22691g;
    }

    public final String b() {
        return this.f22690f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PriorityComponentsSection) {
            PriorityComponentsSection priorityComponentsSection = (PriorityComponentsSection) obj;
            return Intrinsics.a(this.f22690f, priorityComponentsSection.f22690f) && Intrinsics.a(this.f22691g, priorityComponentsSection.f22691g);
        }
        return false;
    }

    public int hashCode() {
        return (this.f22690f.hashCode() * 31) + this.f22691g.hashCode();
    }

    public String toString() {
        String str = this.f22690f;
        List<PriorityComponentItem> list = this.f22691g;
        return "PriorityComponentsSection(title=" + str + ", items=" + list + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f22690f);
        List<PriorityComponentItem> list = this.f22691g;
        out.writeInt(list.size());
        for (PriorityComponentItem priorityComponentItem : list) {
            priorityComponentItem.writeToParcel(out, i8);
        }
    }
}
