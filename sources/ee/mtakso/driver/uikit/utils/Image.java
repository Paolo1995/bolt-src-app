package ee.mtakso.driver.uikit.utils;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Image.kt */
/* loaded from: classes5.dex */
public abstract class Image implements Parcelable {

    /* compiled from: Image.kt */
    /* loaded from: classes5.dex */
    public static final class Attr extends Image {
        public static final Parcelable.Creator<Attr> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final int f36038f;

        /* compiled from: Image.kt */
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<Attr> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Attr createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new Attr(parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Attr[] newArray(int i8) {
                return new Attr[i8];
            }
        }

        public Attr(int i8) {
            super(null);
            this.f36038f = i8;
        }

        public final int a() {
            return this.f36038f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Attr) && this.f36038f == ((Attr) obj).f36038f;
        }

        public int hashCode() {
            return this.f36038f;
        }

        public String toString() {
            int i8 = this.f36038f;
            return "Attr(attr=" + i8 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeInt(this.f36038f);
        }
    }

    /* compiled from: Image.kt */
    /* loaded from: classes5.dex */
    public static final class DarkLight extends Image {
        public static final Parcelable.Creator<DarkLight> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final Image f36039f;

        /* renamed from: g  reason: collision with root package name */
        private final Image f36040g;

        /* compiled from: Image.kt */
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<DarkLight> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final DarkLight createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new DarkLight((Image) parcel.readParcelable(DarkLight.class.getClassLoader()), (Image) parcel.readParcelable(DarkLight.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final DarkLight[] newArray(int i8) {
                return new DarkLight[i8];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DarkLight(Image dark, Image light) {
            super(null);
            Intrinsics.f(dark, "dark");
            Intrinsics.f(light, "light");
            this.f36039f = dark;
            this.f36040g = light;
        }

        public final Image a() {
            return this.f36039f;
        }

        public final Image b() {
            return this.f36040g;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DarkLight) {
                DarkLight darkLight = (DarkLight) obj;
                return Intrinsics.a(this.f36039f, darkLight.f36039f) && Intrinsics.a(this.f36040g, darkLight.f36040g);
            }
            return false;
        }

        public int hashCode() {
            return (this.f36039f.hashCode() * 31) + this.f36040g.hashCode();
        }

        public String toString() {
            Image image = this.f36039f;
            Image image2 = this.f36040g;
            return "DarkLight(dark=" + image + ", light=" + image2 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeParcelable(this.f36039f, i8);
            out.writeParcelable(this.f36040g, i8);
        }
    }

    /* compiled from: Image.kt */
    /* loaded from: classes5.dex */
    public static final class Res extends Image {
        public static final Parcelable.Creator<Res> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final int f36041f;

        /* compiled from: Image.kt */
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<Res> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Res createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new Res(parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Res[] newArray(int i8) {
                return new Res[i8];
            }
        }

        public Res(int i8) {
            super(null);
            this.f36041f = i8;
        }

        public final int a() {
            return this.f36041f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Res) && this.f36041f == ((Res) obj).f36041f;
        }

        public int hashCode() {
            return this.f36041f;
        }

        public String toString() {
            int i8 = this.f36041f;
            return "Res(id=" + i8 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeInt(this.f36041f);
        }
    }

    /* compiled from: Image.kt */
    /* loaded from: classes5.dex */
    public static final class Url extends Image {
        public static final Parcelable.Creator<Url> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final String f36042f;

        /* compiled from: Image.kt */
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Url(String url) {
            super(null);
            Intrinsics.f(url, "url");
            this.f36042f = url;
        }

        public final String a() {
            return this.f36042f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Url) && Intrinsics.a(this.f36042f, ((Url) obj).f36042f);
        }

        public int hashCode() {
            return this.f36042f.hashCode();
        }

        public String toString() {
            String str = this.f36042f;
            return "Url(url=" + str + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeString(this.f36042f);
        }
    }

    private Image() {
    }

    public /* synthetic */ Image(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
