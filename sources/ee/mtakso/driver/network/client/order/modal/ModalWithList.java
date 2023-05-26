package ee.mtakso.driver.network.client.order.modal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModalWithList.kt */
/* loaded from: classes3.dex */
public final class ModalWithList implements Parcelable {
    public static final Parcelable.Creator<ModalWithList> CREATOR = new Creator();
    @SerializedName("description")

    /* renamed from: f  reason: collision with root package name */
    private final String f22637f;
    @SerializedName("items")

    /* renamed from: g  reason: collision with root package name */
    private final List<ModalItem> f22638g;
    @SerializedName("secondary_action_options")

    /* renamed from: h  reason: collision with root package name */
    private final ModalAction f22639h;
    @SerializedName("title")

    /* renamed from: i  reason: collision with root package name */
    private final String f22640i;
    @SerializedName("image")

    /* renamed from: j  reason: collision with root package name */
    private final ModalImage f22641j;
    @SerializedName("secondary_action_title")

    /* renamed from: k  reason: collision with root package name */
    private final String f22642k;

    /* compiled from: ModalWithList.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<ModalWithList> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final ModalWithList createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i8 = 0; i8 != readInt; i8++) {
                arrayList.add(parcel.readParcelable(ModalWithList.class.getClassLoader()));
            }
            return new ModalWithList(readString, arrayList, (ModalAction) parcel.readParcelable(ModalWithList.class.getClassLoader()), parcel.readString(), parcel.readInt() == 0 ? null : ModalImage.CREATOR.createFromParcel(parcel), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final ModalWithList[] newArray(int i8) {
            return new ModalWithList[i8];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ModalWithList(String str, List<? extends ModalItem> items, ModalAction secondaryActionOptions, String title, ModalImage modalImage, String str2) {
        Intrinsics.f(items, "items");
        Intrinsics.f(secondaryActionOptions, "secondaryActionOptions");
        Intrinsics.f(title, "title");
        this.f22637f = str;
        this.f22638g = items;
        this.f22639h = secondaryActionOptions;
        this.f22640i = title;
        this.f22641j = modalImage;
        this.f22642k = str2;
    }

    public final String a() {
        return this.f22637f;
    }

    public final ModalImage b() {
        return this.f22641j;
    }

    public final List<ModalItem> c() {
        return this.f22638g;
    }

    public final ModalAction d() {
        return this.f22639h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f22642k;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ModalWithList) {
            ModalWithList modalWithList = (ModalWithList) obj;
            return Intrinsics.a(this.f22637f, modalWithList.f22637f) && Intrinsics.a(this.f22638g, modalWithList.f22638g) && Intrinsics.a(this.f22639h, modalWithList.f22639h) && Intrinsics.a(this.f22640i, modalWithList.f22640i) && Intrinsics.a(this.f22641j, modalWithList.f22641j) && Intrinsics.a(this.f22642k, modalWithList.f22642k);
        }
        return false;
    }

    public final String f() {
        return this.f22640i;
    }

    public int hashCode() {
        String str = this.f22637f;
        int hashCode = (((((((str == null ? 0 : str.hashCode()) * 31) + this.f22638g.hashCode()) * 31) + this.f22639h.hashCode()) * 31) + this.f22640i.hashCode()) * 31;
        ModalImage modalImage = this.f22641j;
        int hashCode2 = (hashCode + (modalImage == null ? 0 : modalImage.hashCode())) * 31;
        String str2 = this.f22642k;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        String str = this.f22637f;
        List<ModalItem> list = this.f22638g;
        ModalAction modalAction = this.f22639h;
        String str2 = this.f22640i;
        ModalImage modalImage = this.f22641j;
        String str3 = this.f22642k;
        return "ModalWithList(description=" + str + ", items=" + list + ", secondaryActionOptions=" + modalAction + ", title=" + str2 + ", image=" + modalImage + ", secondaryActionTitle=" + str3 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f22637f);
        List<ModalItem> list = this.f22638g;
        out.writeInt(list.size());
        for (ModalItem modalItem : list) {
            out.writeParcelable(modalItem, i8);
        }
        out.writeParcelable(this.f22639h, i8);
        out.writeString(this.f22640i);
        ModalImage modalImage = this.f22641j;
        if (modalImage == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            modalImage.writeToParcel(out, i8);
        }
        out.writeString(this.f22642k);
    }
}
