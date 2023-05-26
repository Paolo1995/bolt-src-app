package ee.mtakso.driver.network.client.order.modal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModalItem.kt */
/* loaded from: classes3.dex */
public abstract class ModalItem implements Parcelable {

    /* compiled from: ModalItem.kt */
    /* loaded from: classes3.dex */
    public static final class Action extends ModalItem {
        public static final Parcelable.Creator<Action> CREATOR = new Creator();
        @SerializedName("tintable_icon_url")

        /* renamed from: f  reason: collision with root package name */
        private final String f22631f;
        @SerializedName("subtext")

        /* renamed from: g  reason: collision with root package name */
        private final String f22632g;
        @SerializedName("action")

        /* renamed from: h  reason: collision with root package name */
        private final ModalAction f22633h;
        @SerializedName("text")

        /* renamed from: i  reason: collision with root package name */
        private final String f22634i;

        /* compiled from: ModalItem.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<Action> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Action createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new Action(parcel.readString(), parcel.readString(), (ModalAction) parcel.readParcelable(Action.class.getClassLoader()), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Action[] newArray(int i8) {
                return new Action[i8];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Action(String tintableIconUrl, String str, ModalAction action, String text) {
            super(null);
            Intrinsics.f(tintableIconUrl, "tintableIconUrl");
            Intrinsics.f(action, "action");
            Intrinsics.f(text, "text");
            this.f22631f = tintableIconUrl;
            this.f22632g = str;
            this.f22633h = action;
            this.f22634i = text;
        }

        public final ModalAction a() {
            return this.f22633h;
        }

        public final String b() {
            return this.f22632g;
        }

        public final String c() {
            return this.f22634i;
        }

        public final String d() {
            return this.f22631f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Action) {
                Action action = (Action) obj;
                return Intrinsics.a(this.f22631f, action.f22631f) && Intrinsics.a(this.f22632g, action.f22632g) && Intrinsics.a(this.f22633h, action.f22633h) && Intrinsics.a(this.f22634i, action.f22634i);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f22631f.hashCode() * 31;
            String str = this.f22632g;
            return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f22633h.hashCode()) * 31) + this.f22634i.hashCode();
        }

        public String toString() {
            String str = this.f22631f;
            String str2 = this.f22632g;
            ModalAction modalAction = this.f22633h;
            String str3 = this.f22634i;
            return "Action(tintableIconUrl=" + str + ", subtext=" + str2 + ", action=" + modalAction + ", text=" + str3 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeString(this.f22631f);
            out.writeString(this.f22632g);
            out.writeParcelable(this.f22633h, i8);
            out.writeString(this.f22634i);
        }
    }

    /* compiled from: ModalItem.kt */
    /* loaded from: classes3.dex */
    public static final class Empty extends ModalItem {

        /* renamed from: f  reason: collision with root package name */
        public static final Empty f22635f = new Empty();
        public static final Parcelable.Creator<Empty> CREATOR = new Creator();

        /* compiled from: ModalItem.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<Empty> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Empty createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                parcel.readInt();
                return Empty.f22635f;
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Empty[] newArray(int i8) {
                return new Empty[i8];
            }
        }

        private Empty() {
            super(null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeInt(1);
        }
    }

    /* compiled from: ModalItem.kt */
    /* loaded from: classes3.dex */
    public enum Type {
        ACTION,
        UNKNOWN
    }

    private ModalItem() {
    }

    public /* synthetic */ ModalItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
