package ee.mtakso.driver.network.client.order.modal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModalAction.kt */
/* loaded from: classes3.dex */
public abstract class ModalAction implements Parcelable {

    /* compiled from: ModalAction.kt */
    /* loaded from: classes3.dex */
    public static final class DeepLink extends ModalAction {
        public static final Parcelable.Creator<DeepLink> CREATOR = new Creator();
        @SerializedName("deep_link")

        /* renamed from: f  reason: collision with root package name */
        private final String f22622f;
        @SerializedName("analytics_event")

        /* renamed from: g  reason: collision with root package name */
        private final String f22623g;

        /* compiled from: ModalAction.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<DeepLink> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final DeepLink createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new DeepLink(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final DeepLink[] newArray(int i8) {
                return new DeepLink[i8];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeepLink(String deepLink, String str) {
            super(null);
            Intrinsics.f(deepLink, "deepLink");
            this.f22622f = deepLink;
            this.f22623g = str;
        }

        public final String a() {
            return this.f22622f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DeepLink) {
                DeepLink deepLink = (DeepLink) obj;
                return Intrinsics.a(this.f22622f, deepLink.f22622f) && Intrinsics.a(this.f22623g, deepLink.f22623g);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f22622f.hashCode() * 31;
            String str = this.f22623g;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            String str = this.f22622f;
            String str2 = this.f22623g;
            return "DeepLink(deepLink=" + str + ", analyticsEvent=" + str2 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeString(this.f22622f);
            out.writeString(this.f22623g);
        }
    }

    /* compiled from: ModalAction.kt */
    /* loaded from: classes3.dex */
    public static final class Empty extends ModalAction {

        /* renamed from: f  reason: collision with root package name */
        public static final Empty f22624f = new Empty();
        public static final Parcelable.Creator<Empty> CREATOR = new Creator();

        /* compiled from: ModalAction.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<Empty> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Empty createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                parcel.readInt();
                return Empty.f22624f;
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

    /* compiled from: ModalAction.kt */
    /* loaded from: classes3.dex */
    public static final class Text extends ModalAction {
        public static final Parcelable.Creator<Text> CREATOR = new Creator();
        @SerializedName("analytics_event")

        /* renamed from: f  reason: collision with root package name */
        private final String f22625f;

        /* compiled from: ModalAction.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<Text> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Text createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new Text(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Text[] newArray(int i8) {
                return new Text[i8];
            }
        }

        public Text(String str) {
            super(null);
            this.f22625f = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Text) && Intrinsics.a(this.f22625f, ((Text) obj).f22625f);
        }

        public int hashCode() {
            String str = this.f22625f;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            String str = this.f22625f;
            return "Text(analyticsEvent=" + str + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeString(this.f22625f);
        }
    }

    /* compiled from: ModalAction.kt */
    /* loaded from: classes3.dex */
    public enum Type {
        TEXT,
        DEEP_LINK,
        UNKNOWN
    }

    private ModalAction() {
    }

    public /* synthetic */ ModalAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
