package ee.mtakso.driver.network.client.priority;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PreconditionItem.kt */
/* loaded from: classes3.dex */
public final class PreconditionItem implements Parcelable {
    public static final Parcelable.Creator<PreconditionItem> CREATOR = new Creator();
    @SerializedName("title")

    /* renamed from: f  reason: collision with root package name */
    private final String f22680f;
    @SerializedName("subtitle")

    /* renamed from: g  reason: collision with root package name */
    private final String f22681g;
    @SerializedName("hint")

    /* renamed from: h  reason: collision with root package name */
    private final String f22682h;
    @SerializedName("style")

    /* renamed from: i  reason: collision with root package name */
    private final PriorityPreconditionStyleEnum f22683i;
    @SerializedName("state_image_url")

    /* renamed from: j  reason: collision with root package name */
    private final String f22684j;

    /* compiled from: PreconditionItem.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<PreconditionItem> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final PreconditionItem createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new PreconditionItem(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : PriorityPreconditionStyleEnum.valueOf(parcel.readString()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final PreconditionItem[] newArray(int i8) {
            return new PreconditionItem[i8];
        }
    }

    public PreconditionItem(String title, String str, String str2, PriorityPreconditionStyleEnum priorityPreconditionStyleEnum, String str3) {
        Intrinsics.f(title, "title");
        this.f22680f = title;
        this.f22681g = str;
        this.f22682h = str2;
        this.f22683i = priorityPreconditionStyleEnum;
        this.f22684j = str3;
    }

    public final String a() {
        return this.f22682h;
    }

    public final String b() {
        return this.f22684j;
    }

    public final PriorityPreconditionStyleEnum c() {
        return this.f22683i;
    }

    public final String d() {
        return this.f22681g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f22680f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f22680f);
        out.writeString(this.f22681g);
        out.writeString(this.f22682h);
        PriorityPreconditionStyleEnum priorityPreconditionStyleEnum = this.f22683i;
        if (priorityPreconditionStyleEnum == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeString(priorityPreconditionStyleEnum.name());
        }
        out.writeString(this.f22684j);
    }
}
