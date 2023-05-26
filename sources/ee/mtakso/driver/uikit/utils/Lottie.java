package ee.mtakso.driver.uikit.utils;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Lottie.kt */
/* loaded from: classes5.dex */
public abstract class Lottie implements Parcelable {

    /* compiled from: Lottie.kt */
    /* loaded from: classes5.dex */
    public static final class DarkLight extends Lottie {
        public static final Parcelable.Creator<DarkLight> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final Lottie f36043f;

        /* renamed from: g  reason: collision with root package name */
        private final Lottie f36044g;

        /* compiled from: Lottie.kt */
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<DarkLight> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final DarkLight createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new DarkLight((Lottie) parcel.readParcelable(DarkLight.class.getClassLoader()), (Lottie) parcel.readParcelable(DarkLight.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final DarkLight[] newArray(int i8) {
                return new DarkLight[i8];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DarkLight(Lottie dark, Lottie light) {
            super(null);
            Intrinsics.f(dark, "dark");
            Intrinsics.f(light, "light");
            this.f36043f = dark;
            this.f36044g = light;
        }

        public final Lottie a() {
            return this.f36043f;
        }

        public final Lottie b() {
            return this.f36044g;
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
                return Intrinsics.a(this.f36043f, darkLight.f36043f) && Intrinsics.a(this.f36044g, darkLight.f36044g);
            }
            return false;
        }

        public int hashCode() {
            return (this.f36043f.hashCode() * 31) + this.f36044g.hashCode();
        }

        public String toString() {
            Lottie lottie = this.f36043f;
            Lottie lottie2 = this.f36044g;
            return "DarkLight(dark=" + lottie + ", light=" + lottie2 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeParcelable(this.f36043f, i8);
            out.writeParcelable(this.f36044g, i8);
        }
    }

    /* compiled from: Lottie.kt */
    /* loaded from: classes5.dex */
    public static final class Res extends Lottie {
        public static final Parcelable.Creator<Res> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final int f36045f;

        /* compiled from: Lottie.kt */
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
            this.f36045f = i8;
        }

        public final int a() {
            return this.f36045f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Res) && this.f36045f == ((Res) obj).f36045f;
        }

        public int hashCode() {
            return this.f36045f;
        }

        public String toString() {
            int i8 = this.f36045f;
            return "Res(id=" + i8 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeInt(this.f36045f);
        }
    }

    /* compiled from: Lottie.kt */
    /* loaded from: classes5.dex */
    public static final class Url extends Lottie {
        public static final Parcelable.Creator<Url> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final String f36046f;

        /* compiled from: Lottie.kt */
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
            this.f36046f = url;
        }

        public final String a() {
            return this.f36046f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Url) && Intrinsics.a(this.f36046f, ((Url) obj).f36046f);
        }

        public int hashCode() {
            return this.f36046f.hashCode();
        }

        public String toString() {
            String str = this.f36046f;
            return "Url(url=" + str + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeString(this.f36046f);
        }
    }

    private Lottie() {
    }

    public /* synthetic */ Lottie(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
