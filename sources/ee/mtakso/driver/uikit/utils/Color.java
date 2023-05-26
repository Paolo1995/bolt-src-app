package ee.mtakso.driver.uikit.utils;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Color.kt */
/* loaded from: classes5.dex */
public abstract class Color implements Parcelable {

    /* compiled from: Color.kt */
    /* loaded from: classes5.dex */
    public static final class Attr extends Color {
        public static final Parcelable.Creator<Attr> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final int f36029f;

        /* compiled from: Color.kt */
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
            this.f36029f = i8;
        }

        public final int a() {
            return this.f36029f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Attr) && this.f36029f == ((Attr) obj).f36029f;
        }

        public int hashCode() {
            return this.f36029f;
        }

        public String toString() {
            int i8 = this.f36029f;
            return "Attr(id=" + i8 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeInt(this.f36029f);
        }
    }

    /* compiled from: Color.kt */
    /* loaded from: classes5.dex */
    public static final class DarkLight extends Color {
        public static final Parcelable.Creator<DarkLight> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final Color f36030f;

        /* renamed from: g  reason: collision with root package name */
        private final Color f36031g;

        /* compiled from: Color.kt */
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<DarkLight> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final DarkLight createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new DarkLight((Color) parcel.readParcelable(DarkLight.class.getClassLoader()), (Color) parcel.readParcelable(DarkLight.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final DarkLight[] newArray(int i8) {
                return new DarkLight[i8];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DarkLight(Color dark, Color light) {
            super(null);
            Intrinsics.f(dark, "dark");
            Intrinsics.f(light, "light");
            this.f36030f = dark;
            this.f36031g = light;
        }

        public final Color a() {
            return this.f36030f;
        }

        public final Color b() {
            return this.f36031g;
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
                return Intrinsics.a(this.f36030f, darkLight.f36030f) && Intrinsics.a(this.f36031g, darkLight.f36031g);
            }
            return false;
        }

        public int hashCode() {
            return (this.f36030f.hashCode() * 31) + this.f36031g.hashCode();
        }

        public String toString() {
            Color color = this.f36030f;
            Color color2 = this.f36031g;
            return "DarkLight(dark=" + color + ", light=" + color2 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeParcelable(this.f36030f, i8);
            out.writeParcelable(this.f36031g, i8);
        }
    }

    /* compiled from: Color.kt */
    /* loaded from: classes5.dex */
    public static final class Res extends Color {
        public static final Parcelable.Creator<Res> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final int f36032f;

        /* compiled from: Color.kt */
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
            this.f36032f = i8;
        }

        public final int a() {
            return this.f36032f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Res) && this.f36032f == ((Res) obj).f36032f;
        }

        public int hashCode() {
            return this.f36032f;
        }

        public String toString() {
            int i8 = this.f36032f;
            return "Res(id=" + i8 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeInt(this.f36032f);
        }
    }

    /* compiled from: Color.kt */
    /* loaded from: classes5.dex */
    public static final class Static extends Color {
        public static final Parcelable.Creator<Static> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final int f36033f;

        /* compiled from: Color.kt */
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<Static> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Static createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new Static(parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Static[] newArray(int i8) {
                return new Static[i8];
            }
        }

        public Static(int i8) {
            super(null);
            this.f36033f = i8;
        }

        public final int a() {
            return this.f36033f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Static) && this.f36033f == ((Static) obj).f36033f;
        }

        public int hashCode() {
            return this.f36033f;
        }

        public String toString() {
            int i8 = this.f36033f;
            return "Static(value=" + i8 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeInt(this.f36033f);
        }
    }

    private Color() {
    }

    public /* synthetic */ Color(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
