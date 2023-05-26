package ee.mtakso.driver.network.client.order.modal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.ui.utils.ThemedImage;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModalImage.kt */
/* loaded from: classes3.dex */
public final class ModalImage implements Parcelable {
    public static final Parcelable.Creator<ModalImage> CREATOR = new Creator();
    @SerializedName("type")

    /* renamed from: f  reason: collision with root package name */
    private final Type f22627f;
    @SerializedName("url_variant")

    /* renamed from: g  reason: collision with root package name */
    private final Variant f22628g;

    /* compiled from: ModalImage.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<ModalImage> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final ModalImage createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new ModalImage(Type.valueOf(parcel.readString()), Variant.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final ModalImage[] newArray(int i8) {
            return new ModalImage[i8];
        }
    }

    /* compiled from: ModalImage.kt */
    /* loaded from: classes3.dex */
    public enum Type {
        IMAGE,
        UNKNOWN
    }

    /* compiled from: ModalImage.kt */
    /* loaded from: classes3.dex */
    public static final class Variant implements ThemedImage, Parcelable {
        public static final Parcelable.Creator<Variant> CREATOR = new Creator();
        @SerializedName("light_url")

        /* renamed from: f  reason: collision with root package name */
        private final String f22629f;
        @SerializedName("dark_url")

        /* renamed from: g  reason: collision with root package name */
        private final String f22630g;

        /* compiled from: ModalImage.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<Variant> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Variant createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new Variant(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Variant[] newArray(int i8) {
                return new Variant[i8];
            }
        }

        public Variant(String lightUrl, String darkUrl) {
            Intrinsics.f(lightUrl, "lightUrl");
            Intrinsics.f(darkUrl, "darkUrl");
            this.f22629f = lightUrl;
            this.f22630g = darkUrl;
        }

        @Override // ee.mtakso.driver.ui.utils.ThemedImage
        public String a() {
            return this.f22629f;
        }

        @Override // ee.mtakso.driver.ui.utils.ThemedImage
        public String b() {
            return this.f22630g;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Variant) {
                Variant variant = (Variant) obj;
                return Intrinsics.a(a(), variant.a()) && Intrinsics.a(b(), variant.b());
            }
            return false;
        }

        public int hashCode() {
            return (a().hashCode() * 31) + b().hashCode();
        }

        public String toString() {
            String a8 = a();
            String b8 = b();
            return "Variant(lightUrl=" + a8 + ", darkUrl=" + b8 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeString(this.f22629f);
            out.writeString(this.f22630g);
        }
    }

    public ModalImage(Type type, Variant urlVariant) {
        Intrinsics.f(type, "type");
        Intrinsics.f(urlVariant, "urlVariant");
        this.f22627f = type;
        this.f22628g = urlVariant;
    }

    public final Variant a() {
        return this.f22628g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ModalImage) {
            ModalImage modalImage = (ModalImage) obj;
            return this.f22627f == modalImage.f22627f && Intrinsics.a(this.f22628g, modalImage.f22628g);
        }
        return false;
    }

    public int hashCode() {
        return (this.f22627f.hashCode() * 31) + this.f22628g.hashCode();
    }

    public String toString() {
        Type type = this.f22627f;
        Variant variant = this.f22628g;
        return "ModalImage(type=" + type + ", urlVariant=" + variant + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f22627f.name());
        this.f22628g.writeToParcel(out, i8);
    }
}
