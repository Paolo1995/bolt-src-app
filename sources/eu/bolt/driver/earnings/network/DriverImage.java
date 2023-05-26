package eu.bolt.driver.earnings.network;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverImage.kt */
@JsonAdapter(DriverImageDeserializer.class)
/* loaded from: classes5.dex */
public abstract class DriverImage implements Parcelable {

    /* compiled from: DriverImage.kt */
    /* loaded from: classes5.dex */
    public static final class Empty extends DriverImage {

        /* renamed from: f  reason: collision with root package name */
        public static final Empty f41367f = new Empty();
        public static final Parcelable.Creator<Empty> CREATOR = new Creator();

        /* compiled from: DriverImage.kt */
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<Empty> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Empty createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                parcel.readInt();
                return Empty.f41367f;
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

    /* compiled from: DriverImage.kt */
    /* loaded from: classes5.dex */
    public static final class Lottie extends DriverImage {
        public static final Parcelable.Creator<Lottie> CREATOR = new Creator();
        @SerializedName("light_url")

        /* renamed from: f  reason: collision with root package name */
        private final Url f41368f;
        @SerializedName("dark_url")

        /* renamed from: g  reason: collision with root package name */
        private final Url f41369g;

        /* compiled from: DriverImage.kt */
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<Lottie> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Lottie createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                Parcelable.Creator<Url> creator = Url.CREATOR;
                return new Lottie(creator.createFromParcel(parcel), parcel.readInt() == 0 ? null : creator.createFromParcel(parcel));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Lottie[] newArray(int i8) {
                return new Lottie[i8];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Lottie(Url lightUrl, Url url) {
            super(null);
            Intrinsics.f(lightUrl, "lightUrl");
            this.f41368f = lightUrl;
            this.f41369g = url;
        }

        public final Url a() {
            return this.f41369g;
        }

        public final Url b() {
            return this.f41368f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Lottie) {
                Lottie lottie = (Lottie) obj;
                return Intrinsics.a(this.f41368f, lottie.f41368f) && Intrinsics.a(this.f41369g, lottie.f41369g);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f41368f.hashCode() * 31;
            Url url = this.f41369g;
            return hashCode + (url == null ? 0 : url.hashCode());
        }

        public String toString() {
            Url url = this.f41368f;
            Url url2 = this.f41369g;
            return "Lottie(lightUrl=" + url + ", darkUrl=" + url2 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            this.f41368f.writeToParcel(out, i8);
            Url url = this.f41369g;
            if (url == null) {
                out.writeInt(0);
                return;
            }
            out.writeInt(1);
            url.writeToParcel(out, i8);
        }
    }

    /* compiled from: DriverImage.kt */
    /* loaded from: classes5.dex */
    public static final class Normal extends DriverImage {
        public static final Parcelable.Creator<Normal> CREATOR = new Creator();
        @SerializedName("light_url")

        /* renamed from: f  reason: collision with root package name */
        private final Url f41370f;
        @SerializedName("dark_url")

        /* renamed from: g  reason: collision with root package name */
        private final Url f41371g;

        /* compiled from: DriverImage.kt */
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<Normal> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Normal createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                Parcelable.Creator<Url> creator = Url.CREATOR;
                return new Normal(creator.createFromParcel(parcel), parcel.readInt() == 0 ? null : creator.createFromParcel(parcel));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Normal[] newArray(int i8) {
                return new Normal[i8];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Normal(Url lightUrl, Url url) {
            super(null);
            Intrinsics.f(lightUrl, "lightUrl");
            this.f41370f = lightUrl;
            this.f41371g = url;
        }

        public final Url a() {
            return this.f41371g;
        }

        public final Url b() {
            return this.f41370f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Normal) {
                Normal normal = (Normal) obj;
                return Intrinsics.a(this.f41370f, normal.f41370f) && Intrinsics.a(this.f41371g, normal.f41371g);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f41370f.hashCode() * 31;
            Url url = this.f41371g;
            return hashCode + (url == null ? 0 : url.hashCode());
        }

        public String toString() {
            Url url = this.f41370f;
            Url url2 = this.f41371g;
            return "Normal(lightUrl=" + url + ", darkUrl=" + url2 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            this.f41370f.writeToParcel(out, i8);
            Url url = this.f41371g;
            if (url == null) {
                out.writeInt(0);
                return;
            }
            out.writeInt(1);
            url.writeToParcel(out, i8);
        }
    }

    /* compiled from: DriverImage.kt */
    /* loaded from: classes5.dex */
    public static final class Tintable extends DriverImage {
        public static final Parcelable.Creator<Tintable> CREATOR = new Creator();
        @SerializedName("tintable_url")

        /* renamed from: f  reason: collision with root package name */
        private final Url f41372f;

        /* compiled from: DriverImage.kt */
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<Tintable> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Tintable createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new Tintable(Url.CREATOR.createFromParcel(parcel));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Tintable[] newArray(int i8) {
                return new Tintable[i8];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Tintable(Url tintableUrl) {
            super(null);
            Intrinsics.f(tintableUrl, "tintableUrl");
            this.f41372f = tintableUrl;
        }

        public final Url a() {
            return this.f41372f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Tintable) && Intrinsics.a(this.f41372f, ((Tintable) obj).f41372f);
        }

        public int hashCode() {
            return this.f41372f.hashCode();
        }

        public String toString() {
            Url url = this.f41372f;
            return "Tintable(tintableUrl=" + url + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            this.f41372f.writeToParcel(out, i8);
        }
    }

    /* compiled from: DriverImage.kt */
    /* loaded from: classes5.dex */
    public enum Type {
        NORMAL,
        TINTABLE,
        LOTTIE,
        UNKNOWN
    }

    /* compiled from: DriverImage.kt */
    /* loaded from: classes5.dex */
    public static final class Url implements Parcelable {
        public static final Parcelable.Creator<Url> CREATOR = new Creator();
        @SerializedName(ImagesContract.URL)

        /* renamed from: f  reason: collision with root package name */
        private final String f41373f;

        /* compiled from: DriverImage.kt */
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<Url> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Url createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new Url(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Url[] newArray(int i8) {
                return new Url[i8];
            }
        }

        public Url(String url) {
            Intrinsics.f(url, "url");
            this.f41373f = url;
        }

        public final String a() {
            return this.f41373f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Url) && Intrinsics.a(this.f41373f, ((Url) obj).f41373f);
        }

        public int hashCode() {
            return this.f41373f.hashCode();
        }

        public String toString() {
            String str = this.f41373f;
            return "Url(url=" + str + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeString(this.f41373f);
        }
    }

    private DriverImage() {
    }

    public /* synthetic */ DriverImage(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
